<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
    <head>
        <title>Hello WebSocket</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="/src/main/resources/style.css" rel="stylesheet" type="text/css" media="screen">
        <style>
          .color-second-bg{ background: #00A5C4}
          .card-body{ 
              background: #00A5C4;
              border-radius: 10px;}
          body{
            background-color: #D3D3D3;
          }
      </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg color-second-bg">
            <div class="container-fluid">
              <a class="navbar-brand" href="index.html">Tech Fun House</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <!--Start search -->
              
          <form method="get" >  
            <div class="input-group">
                <input class="form-control" placeholder="Search for..." type="text" name="name" >
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
                    <a class="nav-link"
                    id = "Samsung-submit" type="submit" name="type-select" value="Laptops">Laptops</a>
                  </li>
                    <a class="nav-link"
                    id = "Samsung-submit" type="submit" name="type-select" value="Cellphones">Cellphones</a>
                    <li class="nav-item">
                    <a class="nav-link" 
                    id = "Microsoft-submit" type="submit" name="type-select" value="Microsoft">Headphones</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" 
                    id = "Microsoft-submit" type="submit" name="type-select" value="Accessories">Accessories</a>
                  </li>
                  <!-- If already Logged in buttons to display-->
                  <!--<li class=\"nav-item\"><a class=\"nav-link\" href=\"profile.php\">$accountUsername</a></li> -->
                  <!--<li class=\"nav-item\"><a class=\"nav-link\" href=\"logout.php\">Log out</a></li>-->
                  <li class="nav-item"><a class="nav-link" href="signup">Sign up</a></li>
                  <li class="nav-item"><a class="nav-link" href="login">Log In</a></li>
                </ul>
          </a>
              </div>
            </div>
          </nav>
    <noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
        enabled. Please enable
        Javascript and reload this page!</h2></noscript>
    <div id="main-content" class="container">
        <div class="row text-center py-5">
        <div class="col-md-3 col-sm-6 my-3 my-md-0">
          <form action="index.php" method="post">
          <div class="card shadow">
          <div>
          <img src="./upload/product0.png" class= "img-fluid card-img-top" style="height:400px;">
          </div>
          <div class= "card-body">
          <h5 class="card-title">Bose Noise Cancelling Headphones 700</h5>
          <h5>
              <span class="price">$379</span>
          </h5>
      <button type="submit" class="btn btn-warning my-3" name="add"> Add to Cart<i class="fas fa=shopping-cart"></i></button>
      <input type='hidden' name='product_id' value='$productid'>
      <input type='hidden' name='product_price' value='$productprice'>
          </div>
          </div>
          </form>
      </div>
      <div class="col-md-3 col-sm-6 my-3 my-md-0">
        <form action="index.php" method="post">
        <div class="card shadow">
        <div>
        <img src="./upload/product1.png" class= "img-fluid card-img-top" style="height:400px;">
        </div>
        <div class= "card-body">
        <h5 class="card-title">Beats Solo</h5>
        <h5>
            <span class="price">$199</span>
        </h5>
    <button type="submit" class="btn btn-warning my-3" name="add"> Add to Cart<i class="fas fa=shopping-cart"></i></button>
    <input type='hidden' name='product_id' value='$productid'>
    <input type='hidden' name='product_price' value='$productprice'>
        </div>
        </div>
        </form>
    </div>
  </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="/app.js"></script>
    </body>
</html>