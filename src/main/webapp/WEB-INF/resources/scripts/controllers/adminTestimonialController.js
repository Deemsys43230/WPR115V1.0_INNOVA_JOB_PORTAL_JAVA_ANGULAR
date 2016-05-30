var adminApp = angular.module('adminApp', [ 'ngSanitize', 'ui.select',
		'angularUtils.directives.dirPagination', 'requestModule', 'flash' ]);

adminApp
		.controller(
				'TestimonialController',
				[
						'$scope',
						'$location',
						'requestHandler',
						'Flash',
						function($scope, $location, requestHandler, Flash) {

							$scope.isTestimonial = true;

							$scope.siteTemplate = 'resources/views/admin/testimonial-list.html';

							$scope.getTestimonial = function() {
								requestHandler
										.getRequest(
												"Admin/getAllTestimonialsAdmin.json",
												"")
										.then(
												function(response) {
													$scope.jobTestimonialList = response.data.testimonialForms;
												});
							};

							$scope.editTestimonial = function(testimonialId) {

								requestHandler
										.getRequest(
												"Admin/getTestimonial.json?testimonialId="
														+ testimonialId, "")
										.then(
												function(response) {

													$scope.testimonial = response.data.testimonialForm;

												});
								$scope.getTestimonial();
								$scope.siteTemplate = 'resources/views/admin/testimonial-add-or-edit.html';
							};
							$scope.saveUpdateTestimonial = function() {
								if ($scope.testimonial.testimonialId == null) {
									$scope.testimonial.status = 1;
									console.log($scope.testimonial);
								}
								requestHandler
										.postRequest(
												"Admin/saveUpdateTestimonial.json",
												$scope.testimonial)
										.then(
												function(response) {
													$scope.getTestimonial();
													$scope.siteTemplate = 'resources/views/admin/testimonial-list.html';
													Flash
															.create('success',
																	"Saved Successfully!");

												});
							};
							$scope.enableOrDisbaleTestimonial = function(
									testimonialId) {
								requestHandler
										.postRequest(
												"Admin/enableDisableTestimonial.json?testimonialId="
														+ testimonialId, "")
										.then(
												function(response) {
													$scope.response = response.data.requestSuccess;
													if ($scope.response == true) {
														Flash
																.create(
																		'success',
																		"You have Successfully Updated!");
														$scope.getTestimonial();
													}
												});
							};
							$scope.addTestimonial = function() {
								$scope.siteTemplate = 'resources/views/admin/testimonial-add-or-edit.html';
								$scope.testimonial = {};
							};

							$scope.cancelAddTestimonial = function() {
								$scope.siteTemplate = 'resources/views/admin/testimonial-list.html';
							};

							$scope.init = function() {

								$scope.getTestimonial();

							};
							$scope.init();
						} ]);