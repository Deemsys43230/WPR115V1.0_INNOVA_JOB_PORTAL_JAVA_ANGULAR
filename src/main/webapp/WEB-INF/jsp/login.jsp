<!doctype html>
<html class="no-js">
  <head>
    <meta charset="utf-8">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!-- build:css(.) styles/vendor.css -->
    <!-- bower:css -->
    <link rel="stylesheet" href="resources/angular/bootstrap/dist/css/bootstrap.min.css" />
    <!-- end bower -->
    <!-- end build -->
    
    <!-- build:css(.tmp) styles/main.css -->
    <link rel="stylesheet" href="resources/styles/main.css" type="text/css">
    <link rel="stylesheet" href="resources/styles/sb-admin-2.css" type="text/css">
    <link rel="stylesheet" href="resources/styles/timeline.css" type="text/css">
    <!-- end build -->
    
    <!-- build:js(.) scripts/vendor.js -->
    <!-- bower:js -->
    <!-- <script src="resources/angular/jquery/dist/jquery.min.js"></script>
    <script src="resources/angular//angular/angular.min.js"></script>
    <script src="resources/angular/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="resources/angular/angular-ui-router/release/angular-ui-router.min.js"></script>
    <script src="resources/angular/json3/lib/json3.min.js"></script>
    <script src="resources/angular/oclazyload/dist/ocLazyLoad.min.js"></script>
    <script src="resources/angular/angular-loading-bar/build/loading-bar.min.js"></script>
    <script src="resources/angular/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
    <script src="resources/angular/metisMenu/dist/metisMenu.min.js"></script>
    <script src="resources/angular/Chart.js/Chart.min.js"></script> -->
    <!-- end bower -->
    <!-- end build -->
    
    <!-- build:js({.tmp,app}) scripts/scripts.js -->
        <!-- <script src="resources/scripts/app.js"></script>
        <script src="resources/js/sb-admin-2.js"></script> -->
    <!-- end build -->


    <!-- Custom CSS -->

    <!-- Custom Fonts -->

    <!-- Morris Charts CSS -->
    <!-- <link href="styles/morrisjs/morris.css" rel="stylesheet"> -->


    </head>
   
    <body>

    <div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <a ui-sref="dashboard.home" class="btn btn-lg btn-success btn-block">Login</a>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
	</div>

    </body>

</html>