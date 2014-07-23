	var myApp = angular.module('myApp', ['ngRoute', 'ui.bootstrap']);
	
	myApp.config(function($routeProvider) {
		$routeProvider
			.when('/', {
				templateUrl : 'pages/home.jsp',
				controller  : 'mainController'
			})
			.when('/security/listUsers', {
				templateUrl : 'pages/security/users/listUsers.jsp',
				controller  : 'listUsersController'
			});
	});
	
	myApp.config(['$tooltipProvider', function($tooltipProvider){
		$tooltipProvider.options({
			animation: false,
			popupDelay: 400,
			appendToBody: true
			});
		}]);	

	myApp.controller('mainController', function($scope) {
		$scope.message = 'Everyone come and see how good I look!';
	});

	myApp.controller('listUsersController', function($scope) {
		$scope.message = 'listUsersController msg';
	});
