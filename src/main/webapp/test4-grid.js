var app = angular.module('myApp', ['ngGrid']);
app.controller('MyCtrl', function($scope, $http) {
//	$scope.myData = [{name: "Moroni", age: 50},
//	                 {name: "Tiancum", age: 43},
//	                 {name: "Jacob", age: 27},
//	                 {name: "Nephi", age: 29},
//	                 {name: "Enos", age: 34}];
    $scope.totalServerItems = 0;

	
	$scope.getDataAsync = function () {
		setTimeout(function () {
			console.log(contextPath+'/ajax/getUsers');
			$http.get(contextPath+'/ajax/getUsers').success(function (largeLoad) {
		        $scope.myData = largeLoad;
		        $scope.totalServerItems = largeLoad.length;
			});
		}, 100);
	};

	$scope.getDataAsync();

    $scope.gridOptions = {
            data: 'myData',
            enablePaging: false,
            showFooter: false,
            totalServerItems:'totalServerItems',
            enableColumnResize: true,
            enableColumnReordering: true,
            enableRowReordering: true,
            enableRowSelection: true,
            enableSorting: true,
            footerRowHeight: 30,
            headerRowHeight: 35,
            rowHeight: 35,
            keepLastSelected: false,
            multiSelect: true,
            selectWithCheckboxOnly: true,
            showSelectionCheckbox: true
            
        };
	

});


