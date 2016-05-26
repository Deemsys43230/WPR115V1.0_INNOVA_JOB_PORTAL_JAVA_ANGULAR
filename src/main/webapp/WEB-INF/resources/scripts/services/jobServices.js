var innovaApp=angular.module('JobServiceModule',['requestModule']);

innovaApp.service('jobService',['requestHandler', function(requestHandler){
	
	
	this.uploadResume=function(file){
		return requestHandler.postFileUpload("saveResume.json",file,"resume").then(function(response){
			return response;
		});
	};
	
	this.saveJobSeeker=function(params){
		return requestHandler.postRequest("updateJobSeeker.json",params).then(function(response){
			return response;
		});
	};
	
}]);