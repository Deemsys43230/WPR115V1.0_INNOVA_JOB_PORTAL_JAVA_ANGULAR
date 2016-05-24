var adminApp = angular.module('adminApp', [ 'requestModule','flash']);

adminApp.controller('SiteController', ['$scope','$location','requestHandler','Flash',
		function($scope, $location, requestHandler,Flash) {
	
	//Get Contact Details
	$scope.getContactDetails = function(){
		
	
		requestHandler.getRequest("getContactDetail.json?id="+$scope.contactid,"").then(function(response){
			$scope.contactDetails = response.data.contactDetailForm;
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
		});
	};
	
	$scope.saveUpdateSocialMediaDetails=function(){
		
		requestHandler.postRequest("Admin/saveUpdateSocialMedia.json",$scope.socialMediaDetails).then(function(response){
		Flash.create('success', "Saved Successfully!");		
		});
	};
	
	$scope.init=function(){
		$scope.contactid = 1;
		$scope.socialMediaid = 1;
		$scope.getContactDetails();
		$scope.getSocialMediaDetails();
	};
	
	$scope.init();
	
	
	
}]);