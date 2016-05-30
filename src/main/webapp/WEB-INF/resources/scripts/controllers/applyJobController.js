var innovaApp=angular.module("innovaApp",['JobServiceModule','requestModule','flash']);

innovaApp.controller('ApplyJobController',['$scope','$location','jobService','requestHandler','Flash',function($scope,$location,jobService,requestHandler,Flash){
		
	$scope.init=function(){
		$scope.saveData=false;
		$scope.saveButtonText="Apply Now";
		$scope.jobSeekerForm={
				"status":1
		};
	};
	
	$scope.uploadResume=function(){
		$scope.saveData=true;
		$scope.saveButtonText="Applying...";
		jobService.uploadResume($scope.jobresume).then(function(response){
	    	$scope.jobSeekerForm.jobSeekerId=response.data.jobSeekerId;
	    	jobService.saveJobSeeker($scope.jobSeekerForm).then(function(response){
	    		if(response.data.requestSuccess){
	    			Flash.create('success', "Thanks for applying!!!");
					 $scope.jobSeekerForm={};
					 $scope.jobresume="";
					 document.getElementsByClassName('upload-path')[0].innerHTML="";
				     $scope.jobForm.$setPristine();
				     $scope.submitted=false;
				 }
	    		 $scope.saveData=false;
				 $scope.saveButtonText="Apply Now";
	    		
	    	});
	    });
	};
	
	$scope.init();
}]);

innovaApp.controller('JobDetailsController', ['$scope','$location','$routeParams','jobService','requestHandler',function($scope,$location,$routeParams,jobService,requestHandler){
	
	$scope.init=function(){
		$scope.getJobDetails();
	};
	
	$scope.getJobDetails=function(){
		requestHandler.getRequest("/getJobDetailsForUser.json?jobId="+$routeParams.id,"").then(function(response){
			$scope.jobDetails=response.data.jobForm;
		});
	};
	
	$scope.init();
}]);