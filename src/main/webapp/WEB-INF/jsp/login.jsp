<!DOCTYPE html>
<html lang="en">
    <html xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Commerce Tech Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .color-second-bg{ background: #00A5C4}
        .card-body{ 
            background: #00A5C4;
            border-radius: 10px;}
    </style>
</head>

<body>
    <!-- start #header -->
    <!--start #nav-bar -->

    <nav class="navbar navbar-expand-lg color-second-bg">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.html">Tech Fun House</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!--Start search -->

            <form method="get">
                <div class="input-group">
                    <input class="form-control" placeholder="Search for..." type="text" name="name">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i></button>
                    </div>
                </div>
            </form>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav m-auto ">
                    <li class="nav-item">
                        <a class="nav-link" href="index.html">Home</a>
                    </li>
                    <!-- type Select -->
                    <li class="nav-item">
                        <a class="nav-link" id="Samsung-submit" type="submit" name="type-select"
                            value="Laptops">Laptops</a>
                    </li>
                    <a class="nav-link" id="Samsung-submit" type="submit" name="type-select"
                        value="Cellphones">Cellphones</a>
                    <li class="nav-item">
                        <a class="nav-link" id="Microsoft-submit" type="submit" name="type-select"
                            value="Microsoft">Headphones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="Microsoft-submit" type="submit" name="type-select"
                            value="Accessories">Accessories</a>
                    </li>
                    <!-- If already Logged in buttons to display-->
                    <!--<li class=\"nav-item\"><a class=\"nav-link\" href=\"profile.php\">$accountUsername</a></li> -->
                    <!--<li class=\"nav-item\"><a class=\"nav-link\" href=\"logout.php\">Log out</a></li>-->
                    <li class="nav-item"><a class="nav-link" href="signup">Sign up</a></li>
                    <li class="nav-item"><a class="nav-link" href="signup">Log In</a></li>
                </ul>
                </a>
            </div>
        </div>
    </nav>
    </header>
    <!--start of main-->
    <div class="d-flex justify-content-center mt-5">
        <section className="row justify-content-center">
            <form className="form-container" action="" th:action="@{/login}" th:object="${login}" method="post">
                <div class="card-body">
                    <h3>Sign in to E-Commerce Tech Store</h3>
                    <h6 className="card-subtitle mb-2 text-muted">Welcome back. Sign in with your account.</h6>
                    <span id="errormessage"></span>
                    <div class="form-group">
                        <label for="userField">Phone Number</label>
                        <input type="text" class="form-control" id="userField" placeholder="Enter Phone Number" th:field="*{phoneNumber}">
                    </div>
                    <div class="form-group">
                        <label for="passwordField">Password</label>
                        <input type="password" class="form-control" id="passwordField" placeholder="Enter Password" th:field="*{password}">
                    </div>
                    <button type="submit" class="btn btn-primary">Log In</button>
                    <br></br>
                    <Link to="/SignUp">Not a member? Sign up today!</Link>
                </div>
            </form>

        </section>
    </div>

</body>

</html>