var adminApp = angular.module('adminApp', ['requestModule','flash']);

adminApp.controller('ContactDetailsController', ['$scope','$location','requestHandler','Flash',
		function($scope, $location, requestHandler,Flash) {

    $scope.siteTemplate='resources/views/admin/contact-details.html';
	
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
	
	$scope.doContactDetails_isClean=function(){
		return angular.equals(originalContactDetails, $scope.contactDetails);
	};
	
	$scope.init=function(){
		$scope.contactid = 1;
		$scope.getContactDetails();
		var originalContactDetails="";
	};
	
	$scope.init();
	
}]);