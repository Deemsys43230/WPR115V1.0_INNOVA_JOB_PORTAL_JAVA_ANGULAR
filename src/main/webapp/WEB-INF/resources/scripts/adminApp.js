var adminApp= angular.module('adminApp', ['ngRoute','oc.lazyLoad','ngCookies','requestModule','flash','ngAnimate']);

adminApp.config(['$routeProvider','$ocLazyLoadProvider','$httpProvider',

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
            when('/dashboard', {
                templateUrl: 'admin/dashboard.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                               /* 'resources/scripts/controllers/commonController.js'*/
                            ]
                        })
                    }]

                }
                /*controller:'CommonController'*/
            }).
            when('/jobManagement-jobList', {
                templateUrl: 'admin/job.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/js/easyResponsiveTabs.js',
                                'resources/styles/easy-responsive-tabs.css',
                                'resources/scripts/controllers/adminJobListController.js'
                            ]
                        });
                    }]
                },
                controller:'AdminJobListController'
            }).
            when('/jobManagement-jobList-addJob', {
                templateUrl: 'admin/job.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/js/easyResponsiveTabs.js',
                                'resources/styles/easy-responsive-tabs.css',
                                'resources/scripts/controllers/adminJobListController.js'
                            ]
                        });
                    }]
                },
                controller:'AdminJobAddController'
            })
            . when('/jobManagement-jobList-editJob/:id', {
                templateUrl: 'admin/job.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/js/easyResponsiveTabs.js',
                                'resources/styles/easy-responsive-tabs.css',
                                'resources/scripts/controllers/adminJobListController.js'
                            ]
                        });
                    }]
                },
                controller:'AdminJobEditController'
            }).
            when('/jobManagement-jobCategory', {
                templateUrl: 'admin/job.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/js/easyResponsiveTabs.js',
                                'resources/styles/easy-responsive-tabs.css',
                                'resources/scripts/controllers/adminJobCategoryController.js'
                            ]
                        })
                    }]
                },
                controller:'AdminJobCategoryController'
            }).
            when('/siteManagement-contactDetails', {
                templateUrl: 'admin/site.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/scripts/controllers/adminContactDetailsController.js'
                            ]
                        })
                    }]
                },
                controller:'ContactDetailsController'
            }).
            when('/siteManagement-socialMedia', {
                templateUrl: 'admin/site.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/scripts/controllers/adminSocialMediaController.js'
                            ]
                        })
                    }]
                },
                controller:'SocialMediaController'
            }).
            when('/siteManagement-news', {
                templateUrl: 'admin/site.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/js/summernote.js',
                                'resources/styles/summernote.css',
                                'resources/scripts/controllers/adminNewsController.js'
                            ]
                        })
                    }]
                },
                controller:'NewsController'
            }).
            when('/siteManagement-testimonial', {
                templateUrl: 'admin/site.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/styles/testimonial-image-upload.css',
                                'resources/js/image-upload.js',
                                'resources/scripts/controllers/adminTestimonialController.js'
                            ]
                        })
                    }]
                },
                controller:'TestimonialController'
            }).
            when('/capabilitySheet', {
                templateUrl: 'admin/capability-sheet.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/scripts/controllers/adminCapabilitySheetController.js'
                            ]
                        })
                    }]
                },
                controller:'CapabilitySheetController'
            }).
            when('/jobSeekers-List', {
                templateUrl: 'admin/jobseeker.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/scripts/controllers/adminJobSeekerListController.js'
                            ]
                        });
                    }]
                },
                controller:'AdminJobSeekerListController'
            }).
            when('/employers-List', {
                templateUrl: 'admin/employers.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/scripts/controllers/adminEmployersListController.js'
                            ]
                        });
                    }]
                },
                controller:'AdminEmployersListController'
            }).
            otherwise({
                redirectTo: '/dashboard'
            });
    }]);

//Initial Controller for Username
adminApp.controller("InitialController",['$scope','$location',function($scope,$location){

    $scope.$on('$routeChangeStart', function(next, current) {
        $scope.activeClass={};
        $scope.submenuActive={};
        var currentPage = $location.url().substr(1);
        var activePage=currentPage.split('-');
        $scope.activeClass[activePage[0]]='active';
        $scope.submenuActive[activePage[1]]=true;
        $scope.header = activePage[0].replace(/([a-z])([A-Z])/g, '$1 $2');
    });

}]);

adminApp.directive(
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

adminApp.directive('validateMobile', function() {
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

adminApp.directive('validateName', function() {
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

adminApp.directive('validateNumber', function() {
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

adminApp.directive('validateZipcode', function() {
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

adminApp.directive('validateUrl', function () {
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
