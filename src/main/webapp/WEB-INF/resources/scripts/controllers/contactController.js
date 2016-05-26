var adminApp = angular.module('innovaApp', [ 'requestModule','flash','employeeMessageServiceModule']);

adminApp.controller('ContactController', ['$scope','$location','requestHandler','Flash','employeeMessageService',
		function($scope, $location, requestHandler,Flash,employeeMessageService) {
	
	
	//Get Contact Details
	$scope.getContactDetails = function(){
		
	
		requestHandler.getRequest("getContactDetail.json?id="+$scope.contactid,"").then(function(response){
			$scope.contactDetails = response.data.contactDetailForm;
		});
	};
	
	//Save Update Method
	$scope.saveEmployersMessage = function() {
		
		employeeMessageService.doSendMessage($scope.employersMessageForm);
		Flash.create('success', "Thanks for contacting us!!!");
		 $scope.employersMessageForm={};
	     $scope.messageForm.$setPristine();
	     $scope.submitted=false;
			
	};

	$scope.init=function(){
		$scope.contactid = 1;
		$scope.getContactDetails();
	};
	
	$scope.init();
	
}]);