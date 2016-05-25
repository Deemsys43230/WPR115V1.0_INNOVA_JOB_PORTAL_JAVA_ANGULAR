/**
 * Created by user on 18/5/16.
 */

var adminApp = angular.module('adminApp',['ngSanitize', 'ui.select']);

adminApp.controller('AdminJobListController',['$scope','$location','requestHandler','Flash',function($scope, $location, requestHandler,Flash){
	
    $scope.isJobList=true;
	
	$scope.jobListTemplate='resources/views/admin/job-list.html';
    
    $scope.addNewJob=function(){
    	$scope.jobListTemplate='resources/views/admin/job-add-or-edit.html';
    };
    
    $scope.cancelAddJob=function(){
    	$scope.jobListTemplate='resources/views/admin/job-list.html';
    };
    
    $scope.availableColors = ['Red','Green','Blue','Yellow','Magenta','Maroon','Umbra','Turquoise'];

    $scope.multipleDemo = {};
    $scope.multipleDemo.colors = ['Blue','Red'];
    
}]);