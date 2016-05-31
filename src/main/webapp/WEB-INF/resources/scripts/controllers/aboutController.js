var adminApp = angular.module('innovaApp', [ 'requestModule','flash','employeeMessageServiceModule','JobServiceModule']);

adminApp.controller('AboutController', ['$scope','$location','requestHandler','Flash','employeeMessageService','jobService',
		function($scope, $location, requestHandler,Flash,employeeMessageService,jobService) {
	
			$scope.init=function(){
				 $(function(){
						$("html,body").scrollTop(0);
					});
				 $scope.jobSeekerForm={
						 "status":1
				 };
				 $scope.saveData=false;
				 $scope.saveButtonText="SUBMIT YOUR RESUME";
				 $scope.getTestimonial();
				 $scope.getCapabilitySheet();
			};
	
	
			//Save Update Method
			$scope.saveEmployersMessage = function() {
				
				employeeMessageService.doSendMessage($scope.employersMessageForm);
				Flash.create('success', "Thanks for contacting us!!!");
				 $scope.employersMessageForm={};
				 $scope.messageForm={};
			     $scope.submitted=false;
					
			};
			
			$scope.uploadResume=function(){
				$scope.saveData=true;
				 $scope.saveButtonText="SUBMITTING...";
				jobService.uploadResume($scope.resume).then(function(response){
					$scope.jobSeekerForm.jobSeekerId=response.data.jobSeekerId;
			    	jobService.saveJobSeeker($scope.jobSeekerForm).then(function(response){
			    		if(response.data.requestSuccess){
			    			Flash.create('success', "Thanks for submitting!!!");
							 $scope.jobSeekerForm={};
							 $scope.resume="";
							 document.getElementsByClassName('upload-path')[0].innerHTML="";
						     $scope.jobseekerForm.$setPristine();
						     $scope.jobSeekerSubmitted=false;
						 }
			    		 $scope.saveData=false;
						 $scope.saveButtonText="SUBMIT YOUR RESUME";
			    		
			    	});
			    });
			};
			
			
			// Clear JobSeeker Data
			$scope.clearJobSeekerData=function(){
				 $scope.jobSeekerForm={
						 "status":1
				 };
				 $scope.saveData=false;
				 $scope.jobSeekerSubmitted=false;
				 $scope.saveButtonText="SUBMIT YOUR RESUME";
			};
			
			//Get Capability sheet
			$scope.getCapabilitySheet = function(){
				requestHandler.getRequest("getCapabilitySheetLink.json","").then(function(response){
					console.log(response);
					$scope.capabilitySheet = response.data.sheetLink;
				});
			};
			
			
			
			 $scope.getTestimonial = function(){
			        requestHandler.getRequest("getAllTestimonials.json","").then(function(response){
			        $scope.jobTestimonialList = response.data.testimonialForms;
			       
			  });
			 };
			 

				$scope.init();
			
			 
}]).directive("owlCarousel", function() {
	return {
		restrict: 'E',
		transclude: false,
		link: function (scope) {
			scope.initCarousel = function(element) {
			  // provide any default options you want
				var defaultOptions = {
				};
				var customOptions = scope.$eval($(element).attr('data-options'));
				// combine the two options objects
				for(var key in customOptions) {
					defaultOptions[key] = customOptions[key];
				}
				// init carousel
				$(element).owlCarousel(defaultOptions);
			};
		}
	};
})
.directive('owlCarouselItem', [function() {
	return {
		restrict: 'A',
		transclude: false,
		link: function(scope, element) {
		  // wait for the last item in the ng-repeat then call init
			if(scope.$last) {
				scope.initCarousel(element.parent());
			}
		}
	};
}]);

adminApp.filter('trustUrl', function ($sce) {
	  return function(url) {
	    return $sce.trustAsResourceUrl(url);
	  };
	});