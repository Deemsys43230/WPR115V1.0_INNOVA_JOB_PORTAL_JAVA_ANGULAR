var adminApp = angular.module('innovaApp', [ 'requestModule','flash']);

adminApp.controller('JobSeekerAndEmployersContactController', ['$scope','$location','requestHandler','Flash',
		function($scope, $location, requestHandler,Flash) {
			
			
			//Save Update Method
			$scope.saveEmployersContact = function() {
				
				requestHandler.postRequest(
						"/Admin/saveUpdateDocumentType.json",
						$scope.employersContactForm).then(function(response) {
						Flash.create('success', "You have Successfully Updated!");		
				});
			};
				
			$scope.saveJobSeekers = function() {
				
				requestHandler.postRequest(
						"/Admin/saveUpdateDocumentType.json",
						$scope.jobSeekersForm).then(function(response) {
						Flash.create('success', "You have Successfully Updated!");	
				});
			};
} ]);

