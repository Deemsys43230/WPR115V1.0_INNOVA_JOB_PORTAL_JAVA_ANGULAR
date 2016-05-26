/**
 * Created by user on 18/5/16.
 */

var innovaApp = angular.module('innovaApp',['JobServiceModule','flash']);
innovaApp.controller('CommonController',['$scope','$http','$document','$parse','jobService','Flash',function($scope,$http,$document,$parse,jobService,Flash){
 
	$scope.init=function(){
		$scope.saveData=false;
		$scope.saveButtonText="Submit Resume";
		$scope.indexJobSeekerForm={
				"status":1
		};
	};
    
    $scope.saveJobSeeker=function(){
    	$scope.saveData=true;
		$scope.saveButtonText="Submitting...";
		jobService.uploadResume($scope.indexresume).then(function(response){
	    	$scope.indexJobSeekerForm.jobSeekerId=response.data.jobSeekerId;
	    	jobService.saveJobSeeker($scope.indexJobSeekerForm).then(function(response){
	    		if(response.data.requestSuccess){
	    			Flash.create('success', "Thanks for submitting!!!");
					 $scope.indexJobSeekerForm={};
					 $scope.indexresume="";
					 document.getElementsByClassName('upload-path')[0].innerHTML="";
				     $scope.indexJobSeekerForm.$setPristine();
				     $scope.submitted=false;
					 $scope.saveData=false;
					 $scope.saveButtonText="Submit Resume";
				 }
	    	
	    		
	    	});
	    });
    };
    
    $scope.init();
}]);