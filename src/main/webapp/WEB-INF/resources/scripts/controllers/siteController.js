var adminApp = angular.module('adminApp', [ 'requestModule','flash']);

adminApp.controller('SiteController', ['$scope','$location','requestHandler','Flash',
		function($scope, $location, requestHandler,Flash) {
	
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