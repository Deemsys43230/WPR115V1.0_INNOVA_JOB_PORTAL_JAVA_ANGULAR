/**
 * Created by user on 18/5/16.
 */

var adminApp = angular.module('adminApp',['ngSanitize', 'ui.select','angularUtils.directives.dirPagination','requestModule','flash']);

adminApp.controller('AdminJobSeekerListController',['$scope','$location','requestHandler','Flash',function($scope, $location, requestHandler,Flash){
	
	$scope.init=function(){
		$scope.jobSeekerListTemplate='resources/views/admin/jobseeker-list.html';
		$scope.getAllJobSeekers();
	};
	
	$scope.getAllJobSeekers=function(){
		requestHandler.getRequest("Admin/getAllJobSeekers.json","").then(function(response){
			$scope.jobSeekerList=response.data.jobSeekerForms;
		});
	};
    
	$scope.deleteJobSeekerAlert=function(id){
		$("#jobSeekerDeleteModal").modal('show');
		$scope.deleteJobSeeker=function(){
			requestHandler.deletePostRequest("Admin/deleteJobSeeker.json?id=",id).then(function(response){
				$("#jobSeekerDeleteModal").modal('hide');
				Flash.create('success', "You have Successfully Deleted!");
				$scope.init();
			});
		};
	};
	
	$scope.init();
}]);