<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    </head>

    <div class = "header">
        <div class = "left-header">
        <a href = "/">Home</a>
        <a href = "/products">Products</a>
        <a href = "/aboutus">About Us</a>
        <a href = "/contactus">Contact Us</a>
        </div>

       @guest
           
       

        <div class = "right-header">
            <a href = "/signup">Sign Up</a>
            <a href = "/login">Login</a>
        </div>

        @endguest

        @auth
            
        <div class = "right-header">
            <a>{{auth()->user()->name}}</a>
            <a href = >Logout</a>
        </div>

        @endauth
    </div>
    <body>
        @yield('body')
    </body>
</html>