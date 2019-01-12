
<link href="static/css/style.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">



    <link rel="icon" href="Favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!------ Include the above in your HEAD tag ---------->
<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
    <div class="container">
    <a class="navbar-brand" href="#">Automation of Travel Agency</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Register</a>
            </li>
        </ul>

    </div>
    </div>
</nav>

<main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Register</div>
                        <div class="card-body">
                           <form name="my-form" onsubmit="return validform()" action="success.php" method="">
                                <div class="form-group row">
                                    <label for="fname" class="col-md-4 col-form-label text-md-right">First Name</label>
                                    <div class="col-md-6">
                                        <input type="text" id="fname" class="form-control" name="fname">
                                    </div>
                                </div>
							<div class="form-group row">
                                    <label for="lname" class="col-md-4 col-form-label text-md-right">Last Name</label>
                                    <div class="col-md-6">
                                        <input type="text" id="lname" class="form-control" name="lname">
                                    </div>
                               </div>
							<div class="form-group row">
                                    <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                                    <div class="col-md-6">
                                        <input type="text" id="password" class="form-control" name="password">
                                    </div>
                               </div>
							
							<div class="form-group row">
                                    <label for="dob" class="col-md-4 col-form-label text-md-right">Date Of Birth</label>
                                    <div class="col-md-6">
                                        <input type="date" id="dob" class="form-control" name="dob">
                                    </div>
                            </div>
							
							<div class="form-group row">
                                    <label for="gender" class="col-md-4 col-form-label text-md-right">Gender</label>
                                    <div class="col-md-6">
                                        <input type="text" id="gender" class="form-control" name="full-name">
                                    </div>
                            </div>
							
                                <div class="form-group row">
                                    <label for="street" class="col-md-4 col-form-label text-md-right">Street</label>
                                    <div class="col-md-6">
                                    <textarea rows="2" cols="37" style="border-radius: 4px" name="street"></textarea></div>
                                </div>
                                  <div class="form-group row">
                                    <label for="location" class="col-md-4 col-form-label text-md-right">Address</label>
                                    <div class="col-md-6">
                                    <textarea rows="2" cols="37" style="border-radius: 4px" name="location"></textarea></div>
                                </div>
<div class="form-group row">
                                    <label for="city" class="col-md-4 col-form-label text-md-right">City</label>
                                    <div class="col-md-6">
                                        <input type="text" id="city" class="form-control" name="city">
                                    </div>
                                </div>
<div class="form-group row">
                                    <label for="state" class="col-md-4 col-form-label text-md-right">State</label>
                                    <div class="col-md-6">
                                        <input type="text" id="state" class="form-control" name="state">
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <label for="pincode" class="col-md-4 col-form-label text-md-right">Pincode</label>
                                    <div class="col-md-6">
                                        <input type="text" id="pincode" class="form-control" name="pincode">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="phone_number" class="col-md-4 col-form-label text-md-right">Phone Number</label>
                                    <div class="col-md-6">
                                        <input type="text" id="phone_number" name="mobile" class="form-control">
                                    </div>
                                </div>

<div class="form-group row">
                                    <label for="email_address" class="col-md-4 col-form-label text-md-right">Email Address</label>
                                    <div class="col-md-6">
                                        <input type="text" id="email_address" class="form-control" name="email">
                                    </div>
                                </div>
                                
                                    <div class="col-md-6 offset-md-4">
                                        <button type="submit" class="btn btn-primary">
                                        Register
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
            </div>
        </div>
    </div>

</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>