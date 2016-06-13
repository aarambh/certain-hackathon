function AttendeeCtrl($scope, $http, $routeParams){
	$scope.event = {};
	
	$http.get('/event/'+$routeParams.eventId).then(function(data){
		$scope.event= data.data;
	})
	
	$scope.formSteps = [
						{"stepNumber" : 1, "title" : "Questions", "view" : "question"}, 
						{"stepNumber" : 2, "title" : "Calendar", "view" : "calendar"},
						{"stepNumber" : 3, "title" : "Time", "view" : "time"},
						{"stepNumber" : 4, "title" : "Details", "view" : "detail"},
						{"stepNumber" : 5, "title" : "Confirmation", "view" : "confirm"}
						];
	
	$scope.currentStep = 1;
	$scope.module = $scope.formSteps[0];
	
	$scope.nextStep = function(){
		$scope.currentStep++;
		$scope.moveToStep($scope.currentStep);
	}
	
	$scope.moveToStep = function(index){
		for ( var i = 0; i < $scope.formSteps.length; i++) {
			if(index == $scope.formSteps[i].stepNumber)
				$scope.module = $scope.formSteps[i]; 
		}
	}
	
	$scope.previousStep = function(){
		$scope.currentStep--;
		$scope.moveToStep($scope.currentStep);
	}
	
	
	$scope.chooseDate = function(date){
		// TODO write the code choose the date
		$scope.nextStep();
	}
	
}