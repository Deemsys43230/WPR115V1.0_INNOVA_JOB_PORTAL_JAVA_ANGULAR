var adminApp = angular.module('innovaApp', [ 'requestModule']);

adminApp.controller('ContactController', ['$scope','$location','requestHandler',
		function($scope, $location, requestHandler) {
	
	
	//Get Contact Details
	$scope.getContactDetails = function(){
		
	
		requestHandler.getRequest("getContactDetail.json?id="+$scope.contactid,"").then(function(response){
			$scope.contactDetails = response.data.contactDetailForm;
		});
	};
	

	$scope.init=function(){
		$scope.contactid = 1;
		$scope.getContactDetails();
	};
	
	$scope.init();
	
}]);