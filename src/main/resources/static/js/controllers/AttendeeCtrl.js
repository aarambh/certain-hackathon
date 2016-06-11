function AttendeeCtrl($scope){
	$scope.formSteps = [
						{"stepNumber" : 1, "title" : "Questions", "view" : "question"}, 
						{"stepNumber" : 2, "title" : "Calendar", "view" : "calendar"}, 
						{"stepNumber" : 3, "title" : "Details", "view" : "detail"},
						{"stepNumber" : 4, "title" : "Confirmation", "view" : "confirmation"}
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
	
}