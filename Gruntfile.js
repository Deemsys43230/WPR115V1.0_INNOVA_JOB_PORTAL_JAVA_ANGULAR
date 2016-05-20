module.exports=function(grunt){
   grunt.initConfig({
        watch: {
        	options: { nospawn: true },
            scripts: {
                files: ['app/*.js','app/**/*.js','js/*.js','css/*.css','views/*.html','index.html','images/*.{png,jpg,gif}','images/**/*.{png,jpg,gif}'],
                tasks: ['newer:uglify','newer:cssmin','newer:imagemin','newer:htmlmin']
            }
        },
        uglify  : {
            build: {
                files: [
                    {
                        mangle: false,
                        expand: true,
                        src: ['app/*.js','app/**/*.js','js/*.js','angular/**/*.js','angular/*.js'],
                        dest: 'Innova/'
                    }
                ]
            }
        },
       concat: {
           options: {
               separator: ';'
           },
           dist: {
              /*src: ['angular/angular-cookies.js', 'angular/ocLazyLoad.min.js', 'angular/angular-animate-1.4.3.js','angular/angular-flash.min.js','js/jquery.migrate.js','js/jquery.fitvids.js','js/nivo-lightbox.min.js','js/owl.carousel.min.js','js/jquery.isotope.min.js','js/jquery.appear.js','js/count-to.js','js/jquery.textillate.js','js/jquery.lettering.js','js/jquery.easypiechart.min.js','plugin/scroll/jquery.nicescroll.min.js','js/jquery.parallax.js','js/mediaelement-and-player.js','angular/angular-touch.js','plugin/dateRange/moment.js','angular/roundProgress.js','angular/ui-bootstrap-tpls-0.14.0.js','js/prefixfree.min.js','plugin/highchart/highchart.js','plugin/highchart/highchart-more.js','angular/angular-count-to.min.js','angular/angular-nicescroll.js'],*/
               src: ['js/modernizrr.js','js/bootstrap.min.js','plugin/popup/jquery.leanModal.min.js'],
              dest: 'angular/output1.js'
           }
       },
       imagemin: {                         // Task
          dynamic: {                         // Another target
               files: [{
                   expand: true,                  // Enable dynamic expansion
                          // Src matches are relative to this path
                   src: ['images/*.{png,jpg,gif}','images/**/*.{png,jpg,gif}'],   // Actual patterns to match
                   dest: 'Innova/'                  // Destination path prefix
               }]
           }
        },
       htmlmin: {                                     // Task
           dist: {                                      // Target
               options: {                                 // Target options
                   removeComments: true,
                   collapseWhitespace: true
               },
               files: [{
                   expand:true,
                   src: ['views/*.html','index.html'],   // Actual patterns to match
                   dest: 'Innova/'

               }]
           }
       },
       cssmin: {
           target: {
               files: [{
                   expand: true,
                   src: ['css/*.css'],
                   dest: 'Innova/',
                   ext: '.css'
               }]
           }
       }

   });
	grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-imagemin');
    grunt.loadNpmTasks('grunt-contrib-htmlmin');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-newer');
    grunt.registerTask('default', ['newer:uglify', 'watch']);
};