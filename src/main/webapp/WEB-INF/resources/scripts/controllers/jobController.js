var innovaApp=angular.module('innovaApp',['JobServiceModule','flash']);

innovaApp.controller('JobController',['$scope','jobService','Flash', function($scope,jobService,Flash){
	
	$scope.init=function(){
		$scope.saveData=false;
		$scope.saveButtonText="SEARCH JOB";
		$scope.jobSeekerForm={
				"status":1
		};
		
		$scope.jobSearchList=[{"name":"job1"},{"name":"job2"},{"name":"job3"},{"name":"job4"},{"name":"job5"},
		                      {"name":"job6"},{"name":"job7"},{"name":"job8"},{"name":"job9"},{"name":"job10"},
		                      {"name":"job11"},{"name":"job12"},{"name":"job13"},{"name":"job14"},{"name":"job15"}];
	};
	
	$scope.uploadResume=function(){
		$scope.saveData=true;
		$scope.saveButtonText="Saving...";
		jobService.uploadResume($scope.jobresume).then(function(response){
	    	$scope.jobSeekerForm.jobSeekerId=response.data.jobSeekerId;
	    	jobService.saveJobSeeker($scope.jobSeekerForm).then(function(response){
	    		if(response.data.requestSuccess){
	    			Flash.create('success', "Thanks for submiyting!!!");
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

