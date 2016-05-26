var innovaApp=angular.module('JobServiceModule',['requestModule']);

innovaApp.service('jobService',['requestHandler', function(requestHandler){
	
	
	this.uploadResume=function(file){
		return requestHandler.postFileUpload("saveUpdateResumeDetail.json",file,"uploadFile").then(function(response){
			return response;
		});
	};
	
	this.saveJobSeeker=function(){
		requestHandler.postRequest("",params).then(function(response){
			return response;
		});
	};
	
}]);