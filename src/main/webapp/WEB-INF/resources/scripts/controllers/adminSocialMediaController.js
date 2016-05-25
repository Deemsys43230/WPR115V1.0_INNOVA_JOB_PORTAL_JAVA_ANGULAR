var adminApp = angular.module('adminApp', [ 'requestModule','flash']);

adminApp.controller('SocialMediaController', ['$scope','$location','requestHandler','Flash',
		function($scope, $location, requestHandler,Flash) {

	$scope.siteTemplate='resources/views/admin/social-media.html';
	
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
	
	$scope.init=function(){
		$scope.socialMediaid = 1;
		$scope.getSocialMediaDetails();
		var originalsocialMediaDetails="";
	};
	
	$scope.init();	
	
}]);