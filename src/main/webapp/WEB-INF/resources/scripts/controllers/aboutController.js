var adminApp = angular.module('innovaApp', [ 'requestModule','flash','employeeMessageServiceModule','JobServiceModule']);

adminApp.controller('AboutController', ['$scope','$location','requestHandler','Flash','employeeMessageService','jobService',
		function($scope, $location, requestHandler,Flash,employeeMessageService,jobService) {
			
	
			//Save Update Method
			$scope.saveEmployersMessage = function() {
				
				employeeMessageService.doSendMessage($scope.employersMessageForm);
				Flash.create('successs', "Thanks for contacting us!!!");
				 $scope.employersMessageForm={};
			     $scope.messageForm.$setPristine();
			     $scope.submitted=false;
					
			};
			
			$scope.uploadResume=function(){
				jobService.uploadResume($scope.resume).then(function(response){
			    	$scope.jobSeekerForm.resume_id=response.data.resume_id;
			    	jobService.saveJobSeeker($scope.jobSeekerForm).then(function(response){
			    		
			    	});
			    });
			};
			
			/*$scope.saveJobSeekers = function() {
				
				requestHandler.postRequest(
						"/Admin/saveUpdateDocumentType.json",
						$scope.jobSeekersForm).then(function(response) {
						Flash.create('success', "You have Successfully Updated!");	
				});
			};*/
} ]);

