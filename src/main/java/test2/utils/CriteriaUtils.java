package test2.utils;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

public class CriteriaUtils {

	public static class MultipleInstancesFound extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}

	/**
	 * This is supposed to find only one or no result. If multiple results are found, throws a {@link MultipleInstancesFound} exception. If no result is found, returns null.
	 */
	public static Serializable findSingleResult(Criteria criteria) {
		@SuppressWarnings("unchecked")
		List<? extends Serializable> res = criteria.list();
		if (res.size() > 1) {
			throw new MultipleInstancesFound();
		} else if (res.size() == 0) {
			return null;
		} else {
			return res.get(0);
		}
	}
}
