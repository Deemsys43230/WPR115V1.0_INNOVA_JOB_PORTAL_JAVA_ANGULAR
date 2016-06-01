/**
 * Created by user on 18/5/16.
 */

var adminApp = angular.module('adminApp',['ngSanitize', 'ui.select','angularUtils.directives.dirPagination','requestModule','flash']);

adminApp.controller('AdminJobCategoryController',['$scope','$location','requestHandler','Flash',function($scope, $location, requestHandler,Flash){
    
	$scope.isJobCateogry=true;
	var originalJobcategory = "";
	
	$scope.jobListTemplate='resources/views/admin/job-category.html';
	
	//Get Contact Details
    $scope.getJobCategory = function(){
           requestHandler.getRequest("Admin/getAllJobCategorys.json","").then(function(response){
           $scope.jobCategoryList = response.data.jobCategoryForms;
     });
    };
                                   	
                                   
   $scope.saveUpdateJobCategory=function(){
	   requestHandler.postRequest("Admin/checkJobCategoryExist.json",$scope.jobCategory).then(function(response){
		   if(response.data.isJobCategoryExist){
			   $scope.isAlreadyExist=true;
		   }
		   else{
			   $scope.isAlreadyExist=false;
		         requestHandler.postRequest("Admin/saveUpdateJobCategory.json",$scope.jobCategory).then(function(response){
		          $("#myModal").modal('hide');
		          Flash.create('success', "Saved Successfully!");
		          $scope.getJobCategory();
		      });
		   }
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
         
    // Delete Job Category
    $scope.deleteJobCategoryAlert=function(id){
		$("#jobCategoryDeleteModal").modal('show');
		$scope.deleteJobCategory=function(){
			requestHandler.deletePostRequest("Admin/deleteJobCategory.json?id=",id).then(function(response){
				if(response.data.isDelete==0){
					$("#jobCategoryDeleteModal").modal('hide');
					$("#jobCategoryWithJobDeleteModal").modal('show');
					$scope.deleteJobCategoryWithJob=function(){
						requestHandler.deletePostRequest("Admin/deleteJobCategoryWithJob.json?id=",id).then(function(response){
							$("#jobCategoryWithJobDeleteModal").modal('hide');
							Flash.create('success', "You have Successfully Deleted!");
							$scope.init();
						});
					};
				}else if(response.data.isDelete==1){
					$("#jobCategoryDeleteModal").modal('hide');
					Flash.create('success', "You have Successfully Deleted!");
					$scope.init();
				}
				
			});
		};
	};
    
	$scope.clearModalData=function(){
		$scope.isAlreadyExist=false;
		$scope.submitted=false;
		$scope.jobCategory={};
        $scope.jobCategory.isJobAvailable = 1;
        $scope.jobCategory.status =1;
        
	};
	
    $scope.init=function(){
    	$scope.isAlreadyExist=false;
    	$scope.submitted=false;
        $scope.jobCategory={};
        $scope.jobCategory.isJobAvailable = 1;
        $scope.jobCategory.status =1;
        $scope.getJobCategory();
        
    	};
                                   	
	$scope.init();
                                   	
    
}]);