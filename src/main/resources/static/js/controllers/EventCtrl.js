function EventCtrl($scope, $location, $rootScope, $window){

	
	$scope.routeToEvent = function(event){
		$rootScope.event = event;
		$location.path('/event/'+event._id+'/attendee');
	}
}