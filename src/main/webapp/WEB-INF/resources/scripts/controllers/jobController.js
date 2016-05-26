var innovaApp=angular.module('innovaApp',['JobServiceModule','flash']);

innovaApp.controller('JobController',['$scope','jobService','Flash', function($scope,jobService,Flash){
	
	$scope.init=function(){
		$scope.saveData=false;
		$scope.saveButtonText="SEARCH JOB";
		$scope.jobSeekerForm={
				"status":1
		};
	};
	
	$scope.uploadResume=function(){
		$scope.saveData=true;
		$scope.saveButtonText="Saving...";
		jobService.uploadResume($scope.jobresume).then(function(response){
	    	$scope.jobSeekerForm.jobSeekerId=response.data.jobSeekerId;
	    	jobService.saveJobSeeker($scope.jobSeekerForm).then(function(response){
	    		if(response.data.requestSuccess){
	    			Flash.create('success', "Thanks!!!");
					 $scope.jobSeekerForm={};
					 $scope.jobresume="";
					 document.getElementsByClassName('upload-path')[0].innerHTML="";
				     $scope.jobForm.$setPristine();
				     $scope.submitted=false;
				 }
	    		 $scope.saveData=false;
				 $scope.saveButtonText="SEARCH JOB";
	    		
	    	});
	    });
	};
	
	$scope.init();
}]);

