function EventCtrl($scope, $location, $rootScope, $window, $http){
	
	$http.get('/event').then(function(data){
		console.log(data);
		$scope.events = data.data;
	});
	
	$scope.routeToEvent = function(event){
		$location.path('/event/'+event._id+'/attendee');
	}
}