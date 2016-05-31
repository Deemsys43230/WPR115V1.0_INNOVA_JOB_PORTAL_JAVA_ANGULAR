var adminApp=angular.module('employeeMessageServiceModule',['requestModule']);

adminApp.factory("employeeMessageService",['requestHandler',function(requestHandler){

    var employeeMessageServiceObj={};
    
    //Get Categories
    employeeMessageServiceObj.doSendMessage= function (employersMessageForm) {
    	console.log(employersMessageForm);
       return requestHandler.postRequest("mergeEmployerMessages.json",employersMessageForm).then(function(response){
    	  console.log(response);
          return response.data.requestSuccess;
        });
    };
    
  //Get Categories
    employeeMessageServiceObj.doSendContactUsMessage= function (employersMessageForm) {
    	console.log(employersMessageForm);
       return requestHandler.postRequest("mergeContactMessages.json",employersMessageForm).then(function(response){
    	  console.log(response);
          return response.data.requestSuccess;
        });
    };
    
    
    return employeeMessageServiceObj;
    
}]);