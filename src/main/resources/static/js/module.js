
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
});

app.module.config(['$httpProvider', '$routeProvider', function($httpProvider, $routeProvider) {
    $routeProvider
        .when('/event/:eventId/attendee',             { controller: AttendeeCtrl, templateUrl: '/views/attendee.html' })
        .when('/event',             { controller: EventCtrl, templateUrl: '/views/event.html' })
        .otherwise({redirectTo: '/event' });
    
    $httpProvider.interceptors.push('httpInterceptor');
    
}]);