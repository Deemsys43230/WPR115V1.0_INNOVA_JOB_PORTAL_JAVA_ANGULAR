/**
 * Created by user on 18/5/16.
 */

var adminApp = angular.module('adminApp',['ngSanitize', 'ui.select','angularUtils.directives.dirPagination','requestModule','flash','summernote']);

adminApp.controller('AdminJobListController',['$scope','$location','$q','requestHandler','Flash',function($scope, $location, $q, requestHandler,Flash){
	$scope.init=function(){
		$scope.isJobList=true;
		$scope.jobListTemplate='resources/views/admin/job-list.html';
	    $scope.getJobList();
		
	};
	
    // Get JOBS List
    $scope.getJobList=function(){
	    requestHandler.getRequest("Admin/getAllJobs.json","").then(function(response){
			$scope.jobsList=response.data.jobForms;
		});
    };
   
    // Enable Or Disable
    $scope.enableOrDisable=function(jobId){
    	requestHandler.postRequest("Admin/enableDisableJob.json?jobId="+jobId,"").then(function(response){
    		$scope.getJobList();
		});
    };
    
    // get Job Details
    $scope.getJobDetails=function(jobId){
    	 requestHandler.getRequest("Admin/getJob.json?jobId="+jobId,"").then(function(response){
 			$scope.jobDetails=response.data.jobForm;
 			$("#jobDetailsModal").modal('show');
 		});
    };
    
    // Delete Job
    $scope.deleteJobAlert=function(id){
    	$("#jobDeleteModal").modal('show');
    	$scope.deleteJob=function(){
    		requestHandler.deletePostRequest("Admin/deleteJob.json?jobId=",id).then(function(response){
    			$("#jobDeleteModal").modal('hide');
    			Flash.create('success', "You have Successfully Deleted!");
				$scope.init();
			});
    	};
    };
    
    $scope.init();
    
}]);

adminApp.controller('AdminJobAddController',['$scope','$location','$q','requestHandler','Flash',function($scope, $location, $q, requestHandler,Flash){
	
	 //summer note
    $scope.options = {
        height: 250
    };
	
	$scope.init=function(){
		$scope.isAlreadyExist=false;
		$scope.getJobCategoryList();
		$scope.submitButtonText="Save Job";
		$scope.adminTagForm={};
    	$scope.adminJobForm={
    			"jobCategoryId":"",
    			"isEnable":1,
    			"status":1
    	};
    	$scope.adminTagForm.tagId=[];
		$scope.jobListTemplate='resources/views/admin/job-add-or-edit.html';
	};
    
		// get All Tags
	 	$scope.getAllTags=function(){
	    	return requestHandler.getRequest("Admin/getAllJobTags.json","").then(function(response){
	    		   return response;
	    		});
	    };
	    
	    // Insert Particular Tag
	    $scope.insertTag=function(){
	    	return requestHandler.postRequest("Admin/saveUpdateJobTag.json",$scope.jobTagForm).then(function(response){
	    		return response;
	    	});
	    };
	    
    	
    	$scope.getJobCategoryList=function(){
    	 requestHandler.getRequest("Admin/getAllJobCategorys.json","").then(function(response){
             $scope.jobCategoryList = response.data.jobCategoryForms;
           });
    	};
    	 
    	$scope.tagListArray=[];
    	$scope.getAllTags().then(function(response){
    		 $scope.availableTags=response.data.jobTagForms;
    		 $.each($scope.availableTags, function(index,value){
    	            $scope.tagListArray.push(value.tagName);
    	     });
    	});
   
    var tagPromise;
    $scope.saveJob=function(){
    	var tagId=[];
    	 $.each($scope.adminTagForm.tagId, function(index,value){
    		 $scope.jobTagForm={};
    		 if(value.isTag){
    			$scope.jobTagForm.tagName=value.tagName;
    			tagPromise=$scope.insertTag();
    			tagPromise.then(function(response){
		    		tagId.push(response.data.tagId);
		    	});
    		 }else{
    			tagId.push(value.tagId);
    		 }
    	});
    	$scope.adminJobForm.jobTagId=tagId;
    	$q.all([tagPromise]).then(function(){
    		requestHandler.postRequest("Admin/checkJobTitleExist.json",$scope.adminJobForm).then(function(response){
    			if(response.data.isJobExist){
    				$scope.isAlreadyExist=true;
    			}else{
    				$scope.isAlreadyExist=false;
		    		requestHandler.postRequest("Admin/saveUpdateJob.json",$scope.adminJobForm).then(function(response){
		    			Flash.create('success',"Saved Successfully !!!");
		    			$location.path("jobManagement-jobList");
		    		});
    			}
    		});
    	},function(error){
    		
    	});
    };
    
    
    $scope.cancelAddJob=function(){
    	$location.path("jobManagement-jobList");
    };
    
   
    //For Tag Input
    $scope.tagTransform = function (newTag) {
        if($scope.tagListArray.indexOf(newTag)==-1){
            var item = {
                "tagId": null,
                "tagName": newTag
            };

            return item;
        }
    };
    
    $scope.init();
    
}]);

adminApp.controller('AdminJobEditController',['$scope','$location','$q','$routeParams','requestHandler','Flash',function($scope, $location, $q, $routeParams, requestHandler,Flash){
	
	 //summer note
    $scope.options = {
        height: 250
    };
	
	
	$scope.init=function(){
		$scope.isAlreadyExist=false;
		$scope.submitButtonText="Update Job";
		$scope.getJob();
		$scope.getJobCategoryList();
		$scope.jobListTemplate='resources/views/admin/job-add-or-edit.html';
	};
	
	// get Job
	$scope.getJob=function(){
		$scope.adminTagForm={};
		$scope.adminTagForm.tagId=[];
		requestHandler.getRequest("Admin/getJob.json?jobId="+$routeParams.id,"").then(function(response){
			$scope.adminJobForm=response.data.jobForm;
			if($scope.adminJobForm.jobCategoryId!=null){
				$scope.adminJobForm.jobCategoryId=String($scope.adminJobForm.jobCategoryId);
			}else{
				$scope.adminJobForm.jobCategoryId="";
			}
			$scope.adminTagForm.tagId=$scope.adminJobForm.jobTagMapForms;
		});
	};
	
	
	// Get Job Category List
	$scope.getJobCategoryList=function(){
	requestHandler.getRequest("Admin/getAllJobCategorys.json","").then(function(response){
        $scope.jobCategoryList = response.data.jobCategoryForms;
      });
	};
	
	// Get All Tags
	$scope.getAllTags=function(){
    	return requestHandler.getRequest("Admin/getAllJobTags.json","").then(function(response){
    		   return response;
    		});
    };
    
	// Set Array List of Job Tags
	 $scope.tagListArray=[];
	 $scope.getAllTags().then(function(response){
		 $scope.availableTags=response.data.jobTagForms;
		 $.each($scope.availableTags, function(index,value){
	            $scope.tagListArray.push(value.tagName);
	     });
	 });
	
	//For Tag Input
	 $scope.tagTransform = function (newTag) {
	      if($scope.tagListArray.indexOf(newTag)==-1){
	            var item = {
	                "tagId": null,
	                "tagName": newTag
	            };

	            return item;
	       }
	  };
	
	// Insert tag
	  $scope.insertTag=function(){
	    	return requestHandler.postRequest("Admin/saveUpdateJobTag.json",$scope.jobTagForm).then(function(response){
	    		return response;
	    	});
	    };
	  
	// Update Job
	var tagPromise;
	$scope.saveJob=function(){
			var tagId=[];
	   	 $.each($scope.adminTagForm.tagId, function(index,value){
	   		 $scope.jobTagForm={};
	   		 if(value.isTag){
	   			$scope.jobTagForm.tagName=value.tagName;
	   			tagPromise=$scope.insertTag();
	   			tagPromise.then(function(response){
			    		tagId.push(response.data.tagId);
			    	});
	   		 }else{
	   			tagId.push(value.tagId);
	   		 }
	   	});
	   	$scope.adminJobForm.jobTagId=tagId;
	   	$q.all([tagPromise]).then(function(){
	   		requestHandler.postRequest("Admin/checkJobTitleExist.json",$scope.adminJobForm).then(function(response){
    			if(response.data.isJobExist){
    				$scope.isAlreadyExist=true;
    			}else{
    				$scope.isAlreadyExist=false;
			   		requestHandler.postRequest("Admin/saveUpdateJob.json",$scope.adminJobForm).then(function(response){
			   			Flash.create('success',"Updated Successfully !!!");
			   			$location.path("jobManagement-jobList");
			   		});
    			}	
    		});
	   	},function(error){
	   		
	   	});
	};
	
	$scope.cancelAddJob=function(){
    	$location.path("jobManagement-jobList");
    };
     
	
	$scope.init();
}]);

adminApp.directive('requireMultiple', function () {
    return {
        require: 'ngModel',
        link: function postLink(scope, element, attrs, ngModel) {
            ngModel.$validators.required = function (value) {
                return angular.isArray(value) && value.length > 0;
            };
        }
    };
});