/**
 * Created by user on 18/5/16.
 */

var adminApp = angular.module('adminApp',['ngSanitize', 'ui.select']);

adminApp.controller('AdminJobCategoryController',['$scope','$location','requestHandler','Flash',function($scope, $location, requestHandler,Flash){
    
	$scope.isJobCateogry=true;
	
	$scope.jobListTemplate='resources/views/admin/job-category.html';
	
	//Get Contact Details
    $scope.getJobCategory = function(){
           requestHandler.getRequest("Admin/getAllJobCategorys.json","").then(function(response){
           $scope.jobCategoryList = response.data.jobCategoryForms;
     });
    };
                                   	
                                   
   $scope.saveUpdateJobCategory=function(){
                                   		
         requestHandler.postRequest("Admin/saveUpdateJobCategory.json",$scope.jobCategory).then(function(response){
          Flash.create('success', "Saved Successfully!");
          $scope.getJobCategory();
    });
    };
    
    $scope.editJobCategory = function(jobCategoryId){
    	  requestHandler.getRequest("Admin/getJobCategory.json?id="+jobCategoryId,"").then(function(response){
    		  originalJobcategory=angular.copy(response.data.jobCategoryForm);
              $scope.jobCategory=response.data.jobCategoryForm;
          });
    };
    
    $scope.enableOrDisbaleJobCategory=function(jobCategoryId){
    	requestHandler.postRequest("Admin/enableDisableJobCategory.json?id="+jobCategoryId,"").then(function(response){
   		 $scope.response=response.data.requestSuccess;
			 if($scope.response==true)
			 {
			 Flash.create('success', "You have Successfully Updated!");
			 $scope.getJobCategory();
   	}
   	});
    };
    
    $scope.dojobCatgeoryDetails_isClean=function(){
        return angular.equals(originalJobcategory, $scope.jobCategory);
    };
                                   	
    $scope.init=function(){
        $scope.jobCategory={};
        $scope.jobCategory.isJobAvailable = 1;
        $scope.jobCategory.status =1;
        $scope.getJobCategory();
        var originalJobcategory = "";
    	};
                                   	
	$scope.init();
                                   	
    
}]);