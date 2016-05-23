var innovaApp= angular.module('innovaApp', ['ngRoute','oc.lazyLoad','ngCookies']);

innovaApp.config(['$routeProvider','$ocLazyLoadProvider','$httpProvider',

    function($routeProvider,$ocLazyLoadProvider,$httpProvider) {
        $ocLazyLoadProvider.config({
            debug:false,
            events:true
        });

        //Do For Cross Orgin Login Management
        //$httpProvider.defaults.withCredentials = false;

        $httpProvider.interceptors.push(['$q','$location','$injector','$cookies',function ($q, $location,$injector,$cookies) {

            return {

                'request': function(request) {
                    request.headers['JSESSIONID']=$cookies.get('JSESSIONID');
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
                                'app/commonController.js'
                            ]
                        })
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
                                'js/easyResponsiveTabs.js',
                                'css/easy-responsive-tabs.css'
                            ]
                        })
                    }]
                }
                /*controller:'CommonController'*/
            }).
            when('/jobs', {
                templateUrl: 'views/jobs.html'
                /*resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                'js/easyResponsiveTabs.js',
                                'css/easy-responsive-tabs.css'
                            ]
                        })
                    }]
                }
                controller:'CommonController'*/
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
                templateUrl: 'views/solutions.html'
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
            when('/mbe', {
                templateUrl: 'views/mbe.html'
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
                templateUrl: 'views/contact.html'
                /*resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                'http://maps.googleapis.com/maps/api/js'
                            ]
                        })
                    }]
                }
                controller:'CommonController'*/
            }).
            when('/login', {
                templateUrl: 'views/login.html',
                resolve: {
                    loadMyFiles:['$ocLazyLoad',function($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name:'innovaApp',
                            files:[
                                'app/controllers/loginController.js'
                            ]
                        })
                    }]
                },
                controller:'LoginController'
            }).

            otherwise({
                redirectTo: '/index'
            });
    }]);