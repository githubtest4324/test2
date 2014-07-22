	var myApp = angular.module('myApp', ['ngRoute']);
	
	myApp.config(function($routeProvider) {
		$routeProvider
			.when('/', {
				templateUrl : 'pages/home.jsp',
				controller  : 'mainController'
			})
			.when('/about', {
				templateUrl : 'pages/listUsers.jsp',
				controller  : 'listUsersController'
			});
	});

	myApp.controller('mainController', function($scope) {
		$scope.message = 'Everyone come and see how good I look!';
	});

	myApp.controller('listUsersController', function($scope) {
		$scope.message = 'listUsersController msg';
	});
