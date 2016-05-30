/**
 * Created by user on 18/5/16.
 */

var adminApp = angular.module('adminApp',['requestModule','flash']);

adminApp.controller('CapabilitySheetController',['$scope','$location','requestHandler','Flash','$sce','$window',function($scope, $location, requestHandler,Flash,$sce,$window){

	//Get Capability sheet
	$scope.getCapabilitySheet = function(){
		requestHandler.getRequest("getCapabilitySheetLink.json","").then(function(response){
			$scope.capabilitySheet = response.data.sheetLink;
			$scope.content = $sce.trustAsResourceUrl($scope.capabilitySheet);
		});
	};
	$scope.getCapabilitySheet();
	
	$scope.uploadSheet = function(){
		console.log($scope.capabilityUploadSheet);
	     requestHandler.postFileUpload("Admin/uploadCapabilitySheet.json",$scope.capabilityUploadSheet,"sheet").then(function(response){
	    	   Flash.create('success', "Successfully Uploaded!!!");
	       });
	     
	    };
	
    
}]);


//File Upload Directive
adminApp.directive('fileModel', ['$parse', function ($parse) {
  return {
      restrict: 'A',
      link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          element.bind('change', function(){
              scope.$apply(function(){
                  modelSetter(scope, element[0].files[0]);
                 
              });
          });
      }
  };
}]);

//File Validation Directive
adminApp.directive('validFile',function(){
	 var validFormats = ['pdf'];
	  return {
	    require:'ngModel',
	    link:function(scope,el,attrs,ngModel){
	      el.bind('change',function(){
	        scope.$apply(function(){
	        	 ngModel.$setViewValue(el.val());
		          ngModel.$render(); 
		          var fileSize=el[0].files[0].size;
		          var value = el.val(),
	              ext = value.substring(value.lastIndexOf('.') + 1).toLowerCase();  
		          
		    ngModel.$validators.validateFileType = function() {
				return validFormats.indexOf(ext) !== -1;
			};
			
			 ngModel.$validators.validateFileSize=function(){
	        	  return fileSize<5000000;
	          };
		            
	         });
	      });
	    }
	  };
});