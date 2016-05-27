var adminApp = angular.module('adminApp', [ 'requestModule','flash','summernote','angularUtils.directives.dirPagination']);

adminApp.controller('NewsController', ['$scope','$location','requestHandler','Flash',
		function($scope, $location, requestHandler,Flash) {
	
	$scope.isNews=true;

    $scope.siteTemplate='resources/views/admin/news-list.html';
    
    $scope.addNews=function(){
    	$scope.siteTemplate='resources/views/admin/news-add-or-edit.html';
    };
    
    $scope.cancelAddNews=function(){
    	$scope.siteTemplate='resources/views/admin/news-list.html';
    };
    
    //summer note
    $scope.options = {
        height: 250
    };
    
    
    var originalNews = "";
    
    
    $scope.getNewsList = function(){
        requestHandler.getRequest("Admin/getAllJobCategorys.json","").then(function(response){
        $scope.newsList = response.data.jobCategoryForms;
  });
 };
                                	
                                
 	$scope.saveUpdateNews=function(){                		
      requestHandler.postRequest("Admin/saveUpdateJobCategory.json",$scope.news).then(function(response){
       Flash.create('success', "Saved Successfully!");
       $scope.getNewsList();
      	});
 	};
 
 	$scope.editNews = function(jobCategoryId){
 	  requestHandler.getRequest("Admin/getJobCategory.json?id="+jobCategoryId,"").then(function(response){
 		  originalNews=angular.copy(response.data.jobCategoryForm);
           $scope.news=response.data.jobCategoryForm;
       });
 	};
 
 	$scope.enableOrDisbaleNews=function(jobCategoryId){
 	requestHandler.postRequest("Admin/enableDisableJobCategory.json?id="+jobCategoryId,"").then(function(response){
		 $scope.response=response.data.requestSuccess;
			 if($scope.response==true)
			 {
			 Flash.create('success', "You have Successfully Updated!");
			 $scope.getJobCategory();
	}
	});
 	};
 
 	$scope.doNews_isClean=function(){
     return angular.equals(originalNews, $scope.news);
 	};
                                	
 	$scope.init=function(){
     $scope.news={};
     $scope.getNewsList();
     
 	};
                                	
	$scope.init();
	
}]);