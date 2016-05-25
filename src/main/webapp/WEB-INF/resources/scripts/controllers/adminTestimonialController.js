var adminApp = angular.module('adminApp', [ 'requestModule','flash']);

adminApp.controller('TestimonialController', ['$scope','$location','requestHandler','Flash',
		function($scope, $location, requestHandler,Flash) {

	$scope.isTestimonial=true;

    $scope.siteTemplate='resources/views/admin/testimonial-list.html';
    
    $scope.addTestimonial=function(){
    	$scope.siteTemplate='resources/views/admin/testimonial-add-or-edit.html';
    };
    
    $scope.cancelAddTestimonial=function(){
    	$scope.siteTemplate='resources/views/admin/testimonial-list.html';
    };
    
    $scope.imageAdded=false;

    $scope.fileNameChanged = function(element)
   {
       if(!$scope.imageAdded){
           if(element.files.length > 0){
               $scope.inputContainsFile = false;
               $scope.imageAdded=true;
           }
           else{
               $scope.inputContainsFile = true;
               $scope.imageAdded=false;
           }
       }
   };
   
    //For image upload
    $('.image-editor').cropit();
    
}]);