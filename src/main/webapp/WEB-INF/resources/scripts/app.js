var innovaApp= angular.module('innovaApp', ['ngRoute','oc.lazyLoad','ngCookies','requestModule','flash','ngAnimate']);

innovaApp.config(['$routeProvider','$ocLazyLoadProvider','$httpProvider',

    function($routeProvider,$ocLazyLoadProvider,$httpProvider) {
        $ocLazyLoadProvider.config({
            debug:false,
            events:true
        });

        //Do For Cross Orgin Login Management
        $httpProvider.defaults.withCredentials = true;

        $httpProvider.interceptors.push(['$q','$location','$injector','$cookies',function ($q, $location,$injector,$cookies) {

            return {

                'request': function(request) {
                    request.headers['X-CSRFToken']=$cookies.get('X-CSRFToken');
                    return request;
                },
                'response': function (response) {
                    return response;
                },
                'responseError': function (rejection) {
                    switch (rejection.status) {
                        case 400: {
                            break;
                        }
                        case 401:{
                            alert("restricted");
                            break;
                        }
                        case 403: {
                            $location.path("/login");
                            break;
                        }
                        case 500: {
                            break;
                        }
                        default : {
                            break;
                        }
                    }
                    return $q.reject(rejection);
                }
            };
        }]);

        $routeProvider.
            when('/index', {
                templateUrl: 'views/index.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                 'resources/scripts/services/jobServices.js',
                                 'resources/scripts/directives/fileUpload.js',
                                'resources/scripts/controllers/commonController.js',
                                
                            ]
                        });
                    }]

                },
                controller:'CommonController'
            }).
            when('/about', {
                templateUrl: 'views/about.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                'resources/scripts/services/employeeMessageService.js',
                                'resources/scripts/services/jobServices.js',
                                'resources/scripts/controllers/aboutController.js',
                                'resources/scripts/directives/fileUpload.js',
                                'resources/js/easyResponsiveTabs.js',
                                'resources/styles/easy-responsive-tabs.css',
                                
                              ]
                        })
                    }]
                },
                controller:'AboutController'
            }).
            when('/jobs', {
                templateUrl: 'views/jobs.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                'resources/js/easyResponsiveTabs.js',
                                'resources/styles/easy-responsive-tabs.css',
                                'resources/scripts/services/jobServices.js',
                                'resources/scripts/controllers/jobController.js',
                                'resources/scripts/directives/fileUpload.js',
                            ]
                        });
                    }]
                },
                controller:'JobController'
            }).
            when('/job-details/:id', {
                templateUrl: 'views/job-details.html'
                /*resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                'js/jquery.contact-buttons.js',
                                'js/demo.js'
                            ]
                        })
                    }]
                }
                controller:'CommonController'*/
            }).
            when('/solutions', {
                templateUrl: 'views/solutions.html',
                	 resolve: {
                         loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                             return $ocLazyLoad.load({
                                 name:'innovaApp',
                                 files:[
                                     'resources/scripts/services/employeeMessageService.js',
                                     'resources/scripts/controllers/aboutController.js',
                                     
                                   ]
                             })
                         }]
                     },
                     controller:'AboutController'
            }).
            when('/mbe', {
                templateUrl: 'views/mbe.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                   'resources/scripts/services/employeeMessageService.js',
                                   'resources/scripts/controllers/aboutController.js',

                            ]
                        })
                    }]
                },
                controller:'AboutController'
            }).
            when('/news', {
                templateUrl: 'views/news.html'
                /*resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                'js/jquery.contact-buttons.js',
                                'js/demo.js'
                            ]
                        })
                    }]
                }
                controller:'CommonController'*/
            }).
            when('/news-details/:id', {
                templateUrl: 'views/news-details.html'
                /*resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                'js/jquery.contact-buttons.js',
                                'js/demo.js'
                            ]
                        })
                    }]
                }
                controller:'CommonController'*/
            }).
            when('/contact', {
                templateUrl: 'views/contact.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                /*'http://maps.googleapis.com/maps/api/js',*/
                                'resources/scripts/services/employeeMessageService.js',
                                'resources/scripts/controllers/contactController.js'
                            ]
                        })
                    }]
                },
              controller:'ContactController'
            }).
           
            otherwise({
                redirectTo: '/index'
            });
    }]);

innovaApp.controller('SocialMediaController', ['$scope','$location','requestHandler',
		function($scope, $location, requestHandler) {
	
	
	//Get Contact Details
	$scope.getSocialMediaDetails = function(){
		
	
		requestHandler.getRequest("getSocialMedia.json?id="+$scope.id,"").then(function(response){
			$scope.socialMediaDetails = response.data.socialMediaForm;
		});
	};
	
	$scope.init=function(){
		$scope.id = 1;
		$scope.getSocialMediaDetails();
	};
	
	$scope.init();
	
}]);

innovaApp.directive(
		'validateEmail',
		function() {
			var EMAIL_REGEXP = /^[_a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,5})$/;
			return {
				require : 'ngModel',
				restrict : '',
				link : function(scope, elm, attrs, ctrl) {
					// only apply the validator if ngModel is present
					// and Angular has added the email validator
					if (ctrl && ctrl.$validators.email) {

						// this will overwrite the default Angular email
						// validator
						ctrl.$validators.email = function(modelValue) {
							return ctrl.$isEmpty(modelValue)
									|| EMAIL_REGEXP.test(modelValue);
						};
					}
				}
			};
		});

innovaApp.directive('validateMobile', function() {
var USA_MOB_EXPR = /^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
var USA_MOB_EXPR_NOSPACE = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
var USA_MOB_EXPR_NO = /^[0-9]{10}$/;
return {
require : 'ngModel',
restrict : '',
link : function(scope, elm, attrs, ngModel) {
	ngModel.$validators.validateMobile = function(modelValue) {
		if (modelValue == "" || modelValue == undefined) {
			return true;
		} else {
			return USA_MOB_EXPR.test(modelValue)
					|| USA_MOB_EXPR_NO.test(modelValue)
					|| USA_MOB_EXPR_NOSPACE.test(modelValue);
		}

	};
}
};
});

innovaApp.directive('validateName', function() {
var NAME_EXPR = /^ *([a-zA-Z]+ ?)+ *$/;
// var USA_MOB_EXPR_WITH_BR=/^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
return {
require : 'ngModel',
restrict : '',
link : function(scope, elm, attrs, ngModel) {
	ngModel.$validators.validateName = function(modelValue) {
		return NAME_EXPR.test(modelValue);// ||USA_MOB_EXPR_WITH_BR.test(modelValue);
	};
}
};
});

innovaApp.directive('validateNumber', function() {
	var NUMBER_EXPR = /^[0-9]*$/;
	// var USA_MOB_EXPR_WITH_BR=/^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
	return {
		require : 'ngModel',
		restrict : '',
		link : function(scope, elm, attrs, ngModel) {
			ngModel.$validators.validateNumber = function(modelValue) {
				return NUMBER_EXPR.test(modelValue);// ||USA_MOB_EXPR_WITH_BR.test(modelValue);
			};
		}
	};
});

innovaApp.directive('validateZipcode', function() {
	var ZIPCODE_EXPR = /^[0-9]{5}$/;
	// var USA_MOB_EXPR_WITH_BR=/^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
	return {
		require : 'ngModel',
		restrict : '',
		link : function(scope, elm, attrs, ngModel) {
			ngModel.$validators.validateZipcode = function(modelValue) {
				return ZIPCODE_EXPR.test(modelValue);// ||USA_MOB_EXPR_WITH_BR.test(modelValue);
			};
		}
	};
});

innovaApp.directive('validateUrl', function () {
	  var URL_REGEXP = /^http(s)?:\/\/(www\.)?[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/;
	  return {
	    require: 'ngModel',
	    restrict: '',
	    link: function (scope, elm, attrs, ngModel) {
	      // only apply the validator if ngModel is present and Angular has added the email validator
	      ngModel.$validators.validateUrl = function (modelValue) {
	        return URL_REGEXP.test(modelValue);
	      };
	    }
	  };
	});


