var innovaApp=angular.module("innovaApp",['JobServiceModule','requestModule','flash']);

innovaApp.controller('ApplyJobController',['$scope','$location','$routeParams','jobService','requestHandler','Flash',function($scope,$location,$routeParams,jobService,requestHandler,Flash){
		
	$scope.init=function(){
		$scope.saveData=false;
		$scope.saveButtonText="Apply Now";
		$scope.jobSeekerForm={
				"status":1
		};
		$scope.getJobDetails();
	};
	
	$scope.getJobDetails=function(){
		requestHandler.getRequest("/getJobDetailsForUser.json?jobId="+$routeParams.id,"").then(function(response){
			$scope.jobDetails=response.data.jobForm;
			$scope.jobSeekerForm.interestedIn=$scope.jobDetails.name;
		});
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
			console.log($scope.jobDetails);
			$("meta[property='og\\:title']").attr("content","Job Openings for "+$scope.jobDetails.name);
			$("meta[property='og\\:description']").attr("content",$scope.jobDetails.description.substring(0, 300)+"...");
			$("meta[property='og\\:image']").attr("content","https://www.google.co.in/imgres?imgurl=http%3A%2F%2Fdatadrivendetroit.org%2Fwp-content%2Fuploads%2F2015%2F03%2FJobs-Graphic.jpg&imgrefurl=http%3A%2F%2Fdatadrivendetroit.org%2Feconomy%2Fuphill-both-ways-where-are-the-jobs-in-metro-detroit%2F&docid=Tv0DEQ6JbIIu5M&tbnid=uA5QBYV-0tC-pM%3A&w=800&h=600&bih=667&biw=1366&ved=0ahUKEwiwosq_uYTNAhVHs48KHekVBOsQMwgzKAIwAg&iact=mrc&uact=8#h=600&imgdii=uA5QBYV-0tC-pM%3A%3BuA5QBYV-0tC-pM%3A%3B3Dw6Lo5n80qaPM%3A&w=800");
			$("meta[property='og\\:url']").attr("content",$location.$$absUrl);
			
			var meta = $("meta[property='og\\:url']").attr("content");
			console.log(meta);
		});
	};
	
	
	
	$scope.init();
}]);