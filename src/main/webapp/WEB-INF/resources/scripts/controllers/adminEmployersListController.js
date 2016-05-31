/**
 * Created by user on 28/5/16.
 */

var adminApp = angular.module('adminApp',['ngSanitize', 'ui.select','angularUtils.directives.dirPagination','requestModule','flash']);

adminApp.controller('AdminEmployersListController',['$scope','$location','requestHandler','Flash',function($scope, $location, requestHandler,Flash){
	
	$scope.init=function(){
		$scope.employerListTemplate='resources/views/admin/employers-list.html';
		$scope.getAllEmployerList();
	};
	
	$scope.getAllEmployerList=function(){
		requestHandler.getRequest("Admin/getAllEmployerMessagess.json","").then(function(response){
			$scope.employersList=response.data.employerMessagesForms;
		});
	};
	
	$scope.getEmployerMessage=function(id){
		requestHandler.getRequest("Admin/getEmployerMessages.json?id="+id,"").then(function(response){
			$scope.employerDetails=response.data.employerMessagesForm;
			$("#employerDetailsModal").modal('show');
		});
	};
	
	$scope.deleteEmployerMessageAlert=function(id){
		$("#employerMessageDeleteModal").modal('show');
		$scope.deleteEmployerMessage=function(){
			requestHandler.deletePostRequest("Admin/deleteEmployerMessages.json?id=",id).then(function(response){
				$("#employerMessageDeleteModal").modal('hide');
				Flash.create('success', "You have Successfully Deleted!");
				$scope.init();
			});
		};
	};
	
	$scope.init();
}]);