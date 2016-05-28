var adminApp=angular.module("adminApp",['requestModule']);

adminApp.controller('AdminDashboardController',['$scope','$location','requestHandler',function($scope,$location,requestHandler){
		
	requestHandler.getRequest("Admin/getJobSeekerCount.json","").then(function(response){
		$scope.jobSeekerCount=response.data.jobSeekerCount;
	});
	
	requestHandler.getRequest("Admin/getEmployerCount.json","").then(function(response){
		$scope.employerCount=response.data.employerCount;
	});
	
	requestHandler.getRequest("Admin/getJobCount.json","").then(function(response){
		$scope.jobCount=response.data.jobCount;
	});
	
}]);