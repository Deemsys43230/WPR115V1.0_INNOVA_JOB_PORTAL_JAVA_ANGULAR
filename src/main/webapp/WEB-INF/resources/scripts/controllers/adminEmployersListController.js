/**
 * Created by user on 28/5/16.
 */

var adminApp = angular.module('adminApp',['ngSanitize', 'ui.select','angularUtils.directives.dirPagination','requestModule','flash']);

adminApp.controller('AdminEmployersListController',['$scope','$location','requestHandler','Flash',function($scope, $location, requestHandler,Flash){
	
	$scope.employerListTemplate='resources/views/admin/employers-list.html';
	
	requestHandler.getRequest("Admin/getAllEmployerMessagess.json","").then(function(response){
		$scope.employersList=response.data.employerMessagesForms;
	});
    
	$scope.getEmployerMessage=function(id){
		requestHandler.getRequest("Admin/getEmployerMessages.json?id="+id,"").then(function(response){
			$scope.employerDetails=response.data.employerMessagesForm;
			$("#employerDetailsModal").modal('show');
		});
	};
	
}]);