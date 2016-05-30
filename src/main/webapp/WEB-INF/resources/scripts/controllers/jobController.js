var innovaApp=angular.module('innovaApp',['JobServiceModule','flash','requestModule']);

innovaApp.controller('JobController',['$scope','jobService','Flash','requestHandler', function($scope,jobService,Flash,requestHandler){
	
	$scope.init=function(){
		$scope.jobSearchForm={
				"jobKeyword":"",
				"jobCategoryId":"0"
		};
		$scope.getJobCategoryList();
		$scope.searchJob();
	
	};
	
	$scope.searchJob=function(){
		requestHandler.postRequest("searchJobs.json",$scope.jobSearchForm).then(function(response){
			$scope.jobSearchList=response.data.jobForms;
		});
	};
	
	// Get JobCategory
	$scope.getJobCategoryList=function(){
   	 requestHandler.getRequest("/getAllJobCategorysForUser.json","").then(function(response){
            $scope.jobCategoryList = response.data.jobCategoryForms;
          });
   	};
	
	
	$scope.init();
}]);

