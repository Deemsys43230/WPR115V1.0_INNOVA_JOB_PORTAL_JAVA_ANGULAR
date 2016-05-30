/**
 * Created by user on 18/5/16.
 */

var innovaApp = angular.module('innovaApp',['JobServiceModule','flash','requestModule']);
innovaApp.controller('CommonController',['$scope','$http','$document','$parse','jobService','Flash','requestHandler','$sce','$routeParams',function($scope,$http,$document,$parse,jobService,Flash,requestHandler,$sce,$routeParams){
 
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
				     $scope.indexjobForm.$setPristine();
				     $scope.submitted=false;
					 $scope.saveData=false;
					 $scope.saveButtonText="Submit Resume";
				 }
	    	
	    		
	    	});
	    });
    };
    
    // To display News as user
    $scope.doGetNewsByUser=function(){
      requestHandler.getRequest("getAllLatestNewss.json", "").then(function(response){
      $scope.usernewslist=response.data.latestNewsForms;
      $scope.myImgSrc = $sce.trustAsResourceUrl(response.data.latestNewsForms.titleImageUrl);
        });
    };
    
   
    $scope.doGetNewsDetailsByUser= function () {
        requestHandler.getRequest("getLatestNews.json?latestNewsId="+$routeParams.latestNewsId, "").then(function(response){

            //View the image in ng-src for view testimonials
            $scope.myImgSrc = $sce.trustAsResourceUrl(response.data.latestNewsForm.titleImageUrl);
            $scope.usernewsdetails=response.data.latestNewsForm;
        });
    };
    
    if($routeParams.latestNewsId){
   	 $scope.doGetNewsDetailsByUser();
   }
    
    $scope.doGetNewsByUser();
    
    $scope.init();
}]);

innovaApp.filter('html', ['$sce', function ($sce) {
    return function (text) {
        return $sce.trustAsHtml(text);
    };
}]);

//render image to view in list
innovaApp.filter('trusted', ['$sce', function ($sce) {
    return function(url) {
        return $sce.trustAsResourceUrl(url);
    };
}]);