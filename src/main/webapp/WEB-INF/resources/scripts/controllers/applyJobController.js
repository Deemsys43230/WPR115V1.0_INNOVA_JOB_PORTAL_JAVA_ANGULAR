var innovaApp=angular.module("innovaApp",['requestModule']);

innovaApp.controller('ApplyJobController',['$scope','$location','requestHandler',function($scope,$location,requestHandler){
		
	$scope.init=function(){
		$scope.saveButtonText="Apply Now";
	};
	
	$scope.init();
}]);