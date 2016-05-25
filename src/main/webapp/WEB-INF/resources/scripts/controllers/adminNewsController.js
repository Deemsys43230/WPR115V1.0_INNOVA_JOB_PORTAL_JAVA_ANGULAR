var adminApp = angular.module('adminApp', [ 'requestModule','flash','summernote']);

adminApp.controller('NewsController', ['$scope','$location','requestHandler','Flash',
		function($scope, $location, requestHandler,Flash) {
	
	$scope.isNews=true;

    $scope.siteTemplate='resources/views/admin/news-list.html';
    
    $scope.addNews=function(){
    	$scope.siteTemplate='resources/views/admin/news-add-or-edit.html';
    };
    
    $scope.cancelAddNews=function(){
    	$scope.siteTemplate='resources/views/admin/news-list.html';
    };
    
    //summer note
    $scope.options = {
        height: 250
    };
	
}]);