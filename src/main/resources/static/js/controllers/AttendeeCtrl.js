function AttendeeCtrl($scope){
	$scope.formSteps = [
						{"stepNumber" : 0, "title" : "Questions", "view" : "question"}, 
						{"stepNumber" : 1, "title" : "Calendar", "view" : "calendar"}, 
						{"stepNumber" : 2, "title" : "Details", "view" : "detail"},
						{"stepNumber" : 3, "title" : "Confirmation", "view" : "confirmation"}
						];
	
	$scope.currentStep = $scope.formSteps[0];
	
	$scope.nextStep = function(){
		$scope.currentStep.stepNumber++;
		$scope.currentStep = $scope.formSteps[$scope.currentStep.stepNumber];
		
	}
	
	$scope.previousStep = function(){
		$scope.currentStep.stepNumber--;
		$scope.currentStep = $scope.formSteps[$scope.currentStep.stepNumber];
	}
	
}