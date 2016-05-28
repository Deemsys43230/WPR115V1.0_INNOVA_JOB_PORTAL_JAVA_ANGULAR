var adminApp = angular.module('adminApp', [ 'requestModule','flash','summernote','angularUtils.directives.dirPagination','angular-media-preview']);

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
    
    //$scope.imageAdded=false;

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
    
    var originalNews = "";
    
    
    $scope.getNewsList = function(){
        requestHandler.getRequest("Admin/getAllLatestNewssAdmin.json","").then(function(response){
        $scope.newsList = response.data.latestNewsForms;
  });
 };
                                	
                                
 	$scope.saveUpdateNews=function(){ 
 		requestHandler.postFileUpload("Admin/saveTitleImage.json",$scope.news.titleImage,"titleImage").then(function(response){
	    	$scope.news.latestNewsId=response.data.newsId;
	    	delete $scope.news.titleImage;
	    	 requestHandler.postRequest("Admin/saveUpdateLatestNews.json",$scope.news).then(function(response){
	    		if(response.data.requestSuccess){
	    			
				     $scope.submitted=false;
				     $scope.siteTemplate='resources/views/admin/news-list.html';
				     Flash.create('success', "Saved Successfully!!!");
		    			
				 }
	    		
	    	});
	    });
	
    /*  requestHandler.postRequest("Admin/saveUpdateJobCategory.json",$scope.news).then(function(response){
       Flash.create('success', "Saved Successfully!");
       $scope.getNewsList();
      	});*/
 	};
 
 	$scope.editNews = function(latestNewsId){
 		$scope.siteTemplate='resources/views/admin/news-add-or-edit.html';
 		requestHandler.getRequest("getLatestNews.json?latestNewsId="+latestNewsId,"").then(function(response){
 		  originalNews=angular.copy(response.data.latestNewsForm);
           $scope.news=response.data.latestNewsForm;
       });
 	};
 
 	$scope.enableOrDisbaleNews=function(latestNewsId){
 	requestHandler.postRequest("Admin/enableDisableNews.json?latestNewsId="+latestNewsId,"").then(function(response){
		 $scope.response=response.data.requestSuccess;
			 if($scope.response==true)
			 {
			 Flash.create('success', "You have Successfully Updated!");
			 $scope.getNewsList();
	}
	});
 	};
 
 	$scope.doNews_isClean=function(){
     return angular.equals(originalNews, $scope.news);
 	};
                                	
 	$scope.init=function(){
     $scope.news={};
     $scope.news.status=1;
     $scope.getNewsList();
     
 	};
                                	
	$scope.init();
	
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
	  return {
	    require:'ngModel',
	    link:function(scope,el,attrs,ngModel){
	      el.bind('change',function(){
	        scope.$apply(function(){
	        	 ngModel.$setViewValue(el.val());
		          ngModel.$render(); 
	         });
	      });
	    }
	  };
});


var adminApp = angular.module('innovaApp', ['ngRoute','oc.lazyLoad','requestModule','flash','ngAnimate']);

adminApp.controller('NewsUserController',['$scope','requestHandler','Flash','$sce','$routeParams',function($scope,requestHandler,Flash,$sce,$routeParams){

    // To display News as user
    $scope.doGetNewsByUser=function(){
        requestHandler.getRequest("getAllLatestNewss.json", "").then(function(response){
      $scope.usernewslist=response.data.latestNewsForms;
      
      $scope.myImgSrc = $sce.trustAsResourceUrl(response.data.latestNewsForms[0].titleImageUrl);
      $scope.usernewsdetails = response.data.latestNewsForms[0];
      $scope.id = response.data.latestNewsForms[0].latestNewsId;
        });
    };

    $scope.doGetNewsDetailsByUser= function (latestNewsId) {
        requestHandler.getRequest("getLatestNews.json?latestNewsId="+latestNewsId, "").then(function(response){

            //View the image in ng-src for view testimonials
            $scope.myImgSrc = $sce.trustAsResourceUrl(response.data.latestNewsForm.titleImageUrl);
 $scope.usernewsdetails=response.data.latestNewsForm;
        });

        return false;

    };

    // To display the user Testimonial list on load
    $scope.doGetNewsByUser();


}]);

adminApp.filter('html', ['$sce', function ($sce) {
    return function (text) {
        return $sce.trustAsHtml(text);
    };
}]);

//render image to view in list
adminApp.filter('trusted', ['$sce', function ($sce) {
    return function(url) {
        return $sce.trustAsResourceUrl(url);
    };
}]);