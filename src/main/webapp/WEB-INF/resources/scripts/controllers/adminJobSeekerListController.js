/**
 * Created by user on 18/5/16.
 */

var adminApp = angular.module('adminApp',['ngSanitize', 'ui.select','angularUtils.directives.dirPagination','requestModule','flash']);

adminApp.controller('AdminJobSeekerListController',['$scope','$location','requestHandler','Flash',function($scope, $location, requestHandler,Flash){
	
	$scope.jobSeekerListTemplate='resources/views/admin/jobseeker-list.html';
	
	requestHandler.getRequest("Admin/getAllJobSeekers.json","").then(function(response){
		$scope.jobSeekerList=response.data.jobSeekerForms;
	});
    
}]);