
var app={};
app.name = 'meetballs';

angular.element(document).ready(function() {
	 angular.bootstrap(document, [app.name]);
});
app.services = angular.module('services', ['ngResource']);

app.module = angular.module(app.name, ['ngRoute', 'services', 'ngAnimate', 'toaster', 'mwl.calendar', 'ui.bootstrap']);

app.module.run(function($rootScope, $location){
	$rootScope.$location = $location;
});

app.module.config(['$httpProvider', '$routeProvider', function($httpProvider, $routeProvider) {
    $routeProvider
        .when('/event/:eventId/attendee',             { controller: AttendeeCtrl, templateUrl: '/views/attendee.html' })
        .otherwise({redirectTo: '/' });
    
    $httpProvider.interceptors.push('httpInterceptor');
    
}]);