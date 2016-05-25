var adminApp = angular.module('adminApp', [ 'requestModule','flash','summernote']);

adminApp.controller('SiteController', ['$scope','$location','requestHandler','Flash',
		function($scope, $location, requestHandler,Flash) {

	$scope.isNews=false;
	$scope.isTestimonial=false;
    $scope.newsTemplate='resources/views/admin/news-list.html';
    $scope.testimonialTemplate='resources/views/admin/testimonial-list.html';
    
    $scope.addNews=function(){
    	$scope.newsTemplate='resources/views/admin/news-add-or-edit.html';
    	alert($scope.newsTemplate);
    };
    
    
    $scope.addTestimonial=function(){
    	$scope.jobListTemplate='resources/views/admin/testimonial-add-or-edit.html';
    };
    
    $scope.cancelAddNews=function(){
    	$scope.newsTemplate='resources/views/admin/news-list.html';
    };
    
    $scope.cancelAddTestimonial=function(){
    	$scope.jobListTemplate='resources/views/admin/testimonial-list.html';
    };
    
    
    //summer note
    $scope.options = {
        height: 250
    };
	
	
	//Get Contact Details
	$scope.getContactDetails = function(){
		
	
		requestHandler.getRequest("getContactDetail.json?id="+$scope.contactid,"").then(function(response){
			$scope.contactDetails = response.data.contactDetailForm;
			originalContactDetails = angular.copy($scope.contactDetails);
		});
	};
	
	$scope.saveUpdateContactDetails=function(){
		
		requestHandler.postRequest("Admin/saveUpdateContactDetail.json",$scope.contactDetails).then(function(response){
		Flash.create('success', "Saved Successfully!");	
		});
		
	};
	
	//Get Social Media Details
	$scope.getSocialMediaDetails = function(){
		
		requestHandler.getRequest("getSocialMedia.json?id="+$scope.socialMediaid,"").then(function(response){
			$scope.socialMediaDetails = response.data.socialMediaForm;
			originalsocialMediaDetails = angular.copy($scope.socialMediaDetails);
		});
	};
	
	$scope.saveUpdateSocialMediaDetails=function(){
		
		requestHandler.postRequest("Admin/saveUpdateSocialMedia.json",$scope.socialMediaDetails).then(function(response){
		Flash.create('success', "Saved Successfully!");		
		});
	};
	
	 $scope.doSocialMediaDetails_isClean=function(){
	        return angular.equals(originalsocialMediaDetails, $scope.socialMediaDetails);
	    };
	    
	 $scope.doContactDetails_isClean=function(){
	        return angular.equals(originalContactDetails, $scope.contactDetails);
	    };
	
	$scope.init=function(){
		$scope.contactid = 1;
		$scope.socialMediaid = 1;
		$scope.getContactDetails();
		$scope.getSocialMediaDetails();
		var originalsocialMediaDetails="";
		var originalContactDetails="";
	};
	
	$scope.init();
	
	
	
}]);