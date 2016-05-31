var adminApp = angular.module('innovaApp', [ 'requestModule','flash','employeeMessageServiceModule']);

adminApp.controller('ContactController', ['$scope','$location','requestHandler','Flash','employeeMessageService',
		function($scope, $location, requestHandler,Flash,employeeMessageService) {
	
	
	//Get Contact Details
	$scope.getContactDetails = function(){
		
	
		requestHandler.getRequest("getContactDetail.json?id="+$scope.contactid,"").then(function(response){
			$scope.contactDetails = response.data.contactDetailForm;
		});
	};
	
	//Save Update Method
	$scope.saveEmployersMessage = function() {
		
		employeeMessageService.doSendContactUsMessage($scope.employersMessageForm);
		Flash.create('success', "Thanks for contacting us!!!");
		 $scope.employersMessageForm={};
	     $scope.messageForm.$setPristine();
	     $scope.submitted=false;
			
	};

	$scope.init=function(){
		 $(function(){
				$("html,body").scrollTop(0);
		});
		$scope.contactid = 1;
		$scope.getContactDetails();
	};
	
	$scope.init();
	
}]);


adminApp.directive('myMap', function() {
    // directive link function
    /*var link = function(scope, element, attrs) {
        };*/

    return {
        restrict: 'A',
        template: '<div id="gmaps"></div>',
        replace: true,
        link: function(scope, element, attr) {
            scope.$watch('contactDetails', function() {
                if(!scope.contactDetails){
                }else{
                    scope.address = scope.contactDetails.street+', '+scope.contactDetails.city+', '+scope.contactDetails.state+', '+scope.contactDetails.country+', '+scope.contactDetails.zipCode;
                    $.ajax({
                        url:"http://maps.googleapis.com/maps/api/geocode/json?address="+scope.address+"&sensor=false",
                        type: "POST",
                        success:function(res){
                            scope.latitudeValue = res.results[0].geometry.location.lat;
                            scope.longitudeValue = res.results[0].geometry.location.lng;

                            var map, infoWindow;
                            var markers = [];

                            // map config
                            var mapOptions = {
                                center: new google.maps.LatLng(scope.latitudeValue, scope.longitudeValue),
                                zoom: 12,
                                mapTypeId: google.maps.MapTypeId.ROADMAP,
                                scrollwheel: false
                            };

                            // init the map
                            function initMap() {
                                if (map === void 0) {
                                    map = new google.maps.Map(element[0], mapOptions);
                                }
                            }

                            // place a marker
                            function setMarker(map, position, title, content) {
                                var marker;
                                var markerOptions = {
                                    position: position,
                                    data: 'Deemsys INC',
                                    map: map,
                                    title: title,
                                    icon: 'https://maps.google.com/mapfiles/ms/icons/green-dot.png'
                                };

                                marker = new google.maps.Marker(markerOptions);
                                markers.push(marker); // add marker to array

                                google.maps.event.addListener(marker, 'click', function () {
                                    // close window if not undefined
                                    if (infoWindow !== void 0) {
                                        infoWindow.close();
                                    }
                                    // create new window
                                    var infoWindowOptions = {
                                        content: content
                                    };
                                    infoWindow = new google.maps.InfoWindow(infoWindowOptions);
                                    infoWindow.open(map, marker);
                                });
                            }

                            // show the map and place some markers
                            initMap();

                            setMarker(map, new google.maps.LatLng(scope.latitudeValue, scope.longitudeValue), 'Deemsys Inc', scope.address);

                        }
                    });

                }
            });
        }
    };
});