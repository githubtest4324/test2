package test2.utils.controller;

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;

public class ControllerUtils {
	private final static Logger	logger			= Logger.getLogger(ControllerUtils.class.getName());
	/**
	 * Builds a redirect.
	 * Concatenates urlPaths into a single path.
	 * Any of urlPath may contain or not leading or trailing slashes. They will be properly added during concatenation.
	 * However if the first urlPath contains a leading /, the path is considered absolute, otherwise, relative.
	 */
	public static String redirect(String... urlPaths){
		StringBuffer res = new StringBuffer();
		res.append("redirect:");
		int i = 0;
		for(String path : urlPaths){
			if(i==0){
				if(path.startsWith("/")){
					// Absolute path
					String canonicalPath = canonicalPathAbsolute(path);
					res.append(canonicalPath);
				} else{
					// Relative path
					String canonicalPath = canonicalPathRelative(path);
					res.append(canonicalPath);
				}
			} else{
				String canonicalPath = canonicalPathAbsolute(path);
				res.append(canonicalPath);
			}
			i++;
		}
		return res.toString();
	}

	/**
	 * Adds a leading '/' and removes any trailing '/'
	 */
	private static String canonicalPathAbsolute(String path) {
		if(path.startsWith("/") && !path.endsWith("/")){
			return path;
		} else if(path.startsWith("/") && path.endsWith("/")){
			// remove trailing /
			return path.substring(0, path.length()-1);
		} else if(!path.startsWith("/") && path.endsWith("/")){
			// add leading / and remove trailing /
			return "/"+path.substring(0, path.length()-1);
		} else if(!path.startsWith("/") && !path.endsWith("/")){
			// add leading  /
			return "/"+path;
		} else{
			throw new RuntimeException("Shouldn't get here");
		}
	}
	
	/**
	 * Received path is relative. Remove any trailing '/'
	 */
	private static String canonicalPathRelative(String path) {
		if(path.endsWith("/")){
			return path.substring(0, path.length()-1);
		} else{
			return path;
		}
	}

	/**
	 * Has to be called before any render is done.
	 */
	public static void onBeforeRender(ModelMap map, String title, String url) {
		logger.info(String.format("Rendering '%s'", url));
		map.addAttribute("title", title);
	}
}
