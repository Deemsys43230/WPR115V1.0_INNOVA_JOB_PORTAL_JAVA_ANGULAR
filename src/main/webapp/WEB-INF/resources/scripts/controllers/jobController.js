var innovaApp=angular.module('innovaApp',['JobServiceModule']);

innovaApp.controller('JobController',['$scope','jobService', function($scope,jobService){
	
	$scope.uploadResume=function(){
		jobService.uploadResume($scope.resume).then(function(response){
	    	$scope.jobSeekerForm.resume_id=response.data.resume_id;
	    	jobService.saveJobSeeker($scope.jobSeekerForm).then(function(response){
	    		
	    	});
	    });
	};
}]);

