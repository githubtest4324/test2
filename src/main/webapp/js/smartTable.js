/*
<%@ page language="java" contentType="application/javascript; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
*/

// Conventions:
// -each <tr> will have an attribute named smtId. This identify uniquely the row and is sent back to server.

//PUBLIC METHODS
function getSelectedRecords(smtTableId){
	smtTable = document.getElementById(smtTableId);
	trs = smtTable.getElementsByTagName('tbody')[0].trs2;
	var res = '';
	if(trs!=null){
		for(var i = 0, k = 0; i<trs.length; i++){
			if(trs[i].className=='smartTablSeselected'){
				if(trs[i].getAttribute('smtId')!=null){
					if(k!=0){
						res = res+',';
					}
					res = res + trs[i].getAttribute('smtId');
					k++;
				}
			}
		}
	}
	return res;
}


function rowClick(currenttr, lock) {
    if(currenttr.parentNode.trs2==null){
    	currenttr.parentNode.trs2 = currenttr.parentNode.parentNode.tBodies[0].getElementsByTagName('tr');
    	currenttr.parentNode.lastSelectedRow2 = new Object();
    	currenttr.parentNode.lastSelectedRow2.value = null;
    }
	if (window.event.ctrlKey) {
        toggleRow(currenttr, currenttr.parentNode.lastSelectedRow2);
    }
    
    if (window.event.button === 0) {
        if (!window.event.ctrlKey && !window.event.shiftKey) {
            clearAll(currenttr.parentNode.trs2);
            toggleRow(currenttr, currenttr.parentNode.lastSelectedRow2);
        }
    
        if (window.event.shiftKey) {
            selectRowsBetweenIndexes([currenttr.parentNode.lastSelectedRow2.value.rowIndex, currenttr.rowIndex], currenttr.parentNode.trs2);
        }
    }
}


//PRIVATE METHODS
function toggleRow(row, lastSelectedRow2) {
    row.className = row.className == 'smartTablSeselected' ? '' : 'smartTablSeselected';
    lastSelectedRow2.value = row;
}

function selectRowsBetweenIndexes(indexes, trs2) {
    indexes.sort(function(a, b) {
        return a - b;
    });

    for (var i = indexes[0]; i <= indexes[1]; i++) {
        trs2[i-1].className = 'smartTablSeselected';
    }
}

function clearAll(trs2) {
    for (var i = 0; i < trs2.length; i++) {
        trs2[i].className = '';
    }
}