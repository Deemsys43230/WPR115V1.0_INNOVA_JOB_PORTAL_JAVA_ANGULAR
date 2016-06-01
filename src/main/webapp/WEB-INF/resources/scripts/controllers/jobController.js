var innovaApp=angular.module('innovaApp',['JobServiceModule','flash','requestModule']);

innovaApp.controller('JobController',['$rootScope','$scope','jobService','Flash','requestHandler', function($rootScope,$scope,jobService,Flash,requestHandler){
	
	$scope.init=function(){
		 $(function(){
				$("html,body").scrollTop(0);
		});
		// Reset Search Data Based on State
		if($rootScope.previousState!="/jobs-details/:id" && $rootScope.previousState!="/jobs-submit-resume/:id"){
			$scope.jobSearchForm={
					"jobKeyword":"",
					"jobCategoryId":"0"
			};
		}else{
			$scope.jobSearchForm=jobService.getJobPreviousSearchForm();
		}
		
		$scope.getJobCategoryList();
		$scope.searchJob();
		
	};
	
	$scope.searchJob=function(){
		jobService.setJobPreviousSearchForm($scope.jobSearchForm);
		var jobSearchForm=jobService.getJobPreviousSearchForm();
		requestHandler.postRequest("searchJobs.json",jobSearchForm).then(function(response){
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

innovaApp.filter('html', ['$sce', function ($sce) {
    return function (text) {
        return $sce.trustAsHtml(text);
    };
}]);

