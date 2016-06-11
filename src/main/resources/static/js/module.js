
var app={};
app.name = 'meetballs';

angular.element(document).ready(function() {
	 angular.bootstrap(document, [app.name]);
});
app.services = angular.module('services', ['ngResource']);

app.module = angular.module(app.name, ['ngRoute', 'services', 'ngAnimate', 'toaster', 'mwl.calendar', 'ui.bootstrap']);

app.module.run(function($rootScope, $location, $http){
	$rootScope.$location = $location;
	$rootScope.events = [];
	$http.get('/event-mock.json').then(function(data){
		$rootScope.events = data.data;
	});
});

app.module.config(['$httpProvider', '$routeProvider', function($httpProvider, $routeProvider) {
    $routeProvider
        .when('/event/:eventId/attendee',             { controller: AttendeeCtrl, templateUrl: '/views/attendee.html' })
        .when('/event',             { controller: AttendeeCtrl, templateUrl: '/views/event.html' })
        .otherwise({redirectTo: '/event' });
    
    $httpProvider.interceptors.push('httpInterceptor');
    
}]);