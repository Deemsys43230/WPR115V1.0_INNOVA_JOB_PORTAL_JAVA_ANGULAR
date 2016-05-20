/**
 * Created by user on 18/5/16.
 */

var innovaApp = angular.module('innovaApp');

innovaApp.controller('CommonController',['$scope','$http','$document','$parse',function($scope,$http,$document,$parse){
    console.log($scope);
    console.log($http);
    console.log($document);
    console.log($document.context.URL);
    console.log($parse);
}]);