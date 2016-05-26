var adminApp = angular.module('innovaApp', [ 'requestModule','flash','employeeMessageServiceModule','JobServiceModule']);

adminApp.controller('AboutController', ['$scope','$location','requestHandler','Flash','employeeMessageService','jobService',
		function($scope, $location, requestHandler,Flash,employeeMessageService,jobService) {
			
			$scope.init=function(){
				 $scope.jobSeekerForm={
						 "status":1
				 };
				 $scope.saveData=false;
				 $scope.saveButtonText="SUBMIT YOUR RESUME";
			};
	
	
			//Save Update Method
			$scope.saveEmployersMessage = function() {
				
				employeeMessageService.doSendMessage($scope.employersMessageForm);
				Flash.create('successs', "Thanks for contacting us!!!");
				 $scope.employersMessageForm={};
			     $scope.messageForm.$setPristine();
			     $scope.submitted=false;
					
			};
			
			$scope.uploadResume=function(){
				$scope.saveData=true;
				 $scope.saveButtonText="SUBMITTING...";
				jobService.uploadResume($scope.resume).then(function(response){
					$scope.jobSeekerForm.jobSeekerId=response.data.jobSeekerId;
			    	jobService.saveJobSeeker($scope.jobSeekerForm).then(function(response){
			    		if(response.data.requestSuccess){
			    			Flash.create('success', "Thanks for submitting!!!");
							 $scope.jobSeekerForm={};
							 $scope.resume="";
							 document.getElementsByClassName('upload-path')[0].innerHTML="";
						     $scope.jobseekerForm.$setPristine();
						     $scope.submitted=false;
						 }
			    		 $scope.saveData=false;
						 $scope.saveButtonText="SUBMIT YOUR RESUME";
			    		
			    	});
			    });
			};
			
			$scope.init();
} ]);

