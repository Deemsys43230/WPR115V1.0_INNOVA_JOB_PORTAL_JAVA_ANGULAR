var adminApp = angular.module('innovaApp', [ 'requestModule','flash','employeeMessageServiceModule']);

adminApp.controller('AboutController', ['$scope','$location','requestHandler','Flash','employeeMessageService',
		function($scope, $location, requestHandler,Flash,employeeMessageService) {
			
	
			
			//Save Update Method
			$scope.saveEmployersMessage = function() {
				
				employeeMessageService.doSendMessage($scope.employersMessageForm);
				Flash.create('successs', "Thanks for contacting us!!!");
				 $scope.employersMessageForm={};
			     $scope.messageForm.$setPristine();
			     $scope.submitted=false;
					
			};
				
			/*$scope.saveJobSeekers = function() {
				
				requestHandler.postRequest(
						"/Admin/saveUpdateDocumentType.json",
						$scope.jobSeekersForm).then(function(response) {
						Flash.create('success', "You have Successfully Updated!");	
				});
			};*/
} ]);

