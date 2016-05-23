/**
 * Created by user on 18/5/16.
 */
var innovaApp = angular.module('innovaApp',['requestModule']);

innovaApp.controller('LoginController',['$scope','requestHandler',function($scope,requestHandler){
   	
   	$scope.doLogin=function(){
   		alert("hittttt");
   		requestHandler.postRequest("j_spring_security_check?username="+$scope.username+"&password="+$scope.password,"").then(function(response){
   			alert(response);
		});
   	};

}]);