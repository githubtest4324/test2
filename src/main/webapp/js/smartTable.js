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


function setSelectedRecords(smtTableId, idsStr){
	smtTable = document.getElementById(smtTableId);
	tbody = smtTable.getElementsByTagName('tbody')[0];
	initializeSmartTable(tbody);

	ids = idsStr.split(',');
	
	trs = tbody.trs2;
	for(var i = 0; i<trs.length; i++){
		smtId = trs[i].getAttribute('smtId');
		if(ids.indexOf(smtId)>-1){
	        toggleRow(trs[i], tbody.lastSelectedRow2);
		}
	}
}

function rowClick(currenttr, lock) {
	tbody = currenttr.parentNode;
	initializeSmartTable(tbody);
	if (window.event.ctrlKey) {
        toggleRow(currenttr, tbody.lastSelectedRow2);
    }
    
    if (window.event.button === 0) {
        if (!window.event.ctrlKey && !window.event.shiftKey) {
            clearAll(tbody.trs2);
            toggleRow(currenttr, tbody.lastSelectedRow2);
        }
    
        if (window.event.shiftKey) {
            selectRowsBetweenIndexes([tbody.lastSelectedRow2.value.rowIndex, currenttr.rowIndex], tbody.trs2);
        }
    }
}


//PRIVATE METHODS
function initializeSmartTable(tbody){
    if(tbody.trs2==null){
    	tbody.trs2 = tbody.getElementsByTagName('tr');
    	tbody.lastSelectedRow2 = new Object();
    	tbody.lastSelectedRow2.value = null;
    }
}

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