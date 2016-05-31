/**
 * Created by user on 31/5/16.
 */

var adminApp = angular.module('adminApp',['ngSanitize', 'ui.select','angularUtils.directives.dirPagination','requestModule','flash']);

adminApp.controller('AdminContactUsMessageController',['$scope','$location','requestHandler','Flash',function($scope, $location, requestHandler,Flash){
	
	$scope.contactUsMessageTemplate='resources/views/admin/contatctus-messages-list.html';
	
	$scope.getContactUsMessagesList=function(){
		requestHandler.getRequest("Admin/getAllContactMessagess.json","").then(function(response){
			$scope.contactMessageList=response.data.contactMessagesForms;
		});
	};
	$scope.init=function()
	{
		$scope.getContactUsMessagesList();
	};
	
	$scope.getContactMessages=function(id){
		requestHandler.getRequest("Admin/getContactMessages.json?id="+id,"").then(function(response){
			$scope.contactMessageDetails=response.data.contactMessagesForm;
			$("#contactMessageDetailsModal").modal('show');
			requestHandler.postRequest("Admin/markAsRead.json?id="+id,"").then(function(response){
				$scope.init();
			});
		});
	};
	
	$scope.init();
}]);