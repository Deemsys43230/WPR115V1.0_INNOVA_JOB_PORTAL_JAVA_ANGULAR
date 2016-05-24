var adminApp= angular.module('adminApp', ['ngRoute','oc.lazyLoad','ngCookies']);

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
                templateUrl: 'dashboard.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/scripts/controllers/commonController.js'
                            ]
                        })
                    }]

                }
                /*controller:'CommonController'*/
            }).
            when('/jobManagement', {
                templateUrl: 'job.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/js/easyResponsiveTabs.js',
                                'resources/styles/easy-responsive-tabs.css'
                            ]
                        })
                    }]
                }
                /*controller:'CommonController'*/
            }).
            when('/siteManagement', {
                templateUrl: 'site.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'adminApp',
                            files:[
                                'resources/js/easyResponsiveTabs.js',
                                'resources/styles/easy-responsive-tabs.css'
                            ]
                        })
                    }]
                }
                /*controller:'CommonController'*/
            }).

            otherwise({
                redirectTo: '/dashboard'
            });
    }]);

//Initial Controller for Username
adminApp.controller("InitialController",['$scope','$location',function($scope,$location){

    $scope.$on('$routeChangeStart', function(next, current) {
        $scope.activeClass={};
        var currentPage = $location.url().substr(1);
        $scope.activeClass[currentPage]='active';
        $scope.header = currentPage.replace(/([a-z])([A-Z])/g, '$1 $2');
    });

}]);