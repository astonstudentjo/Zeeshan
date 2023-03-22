<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/styles.css') }}">



</head>


<div class="container">
    <div class="left-header">
        <h2>EventTick</h2>
        <a href="/">Home</a>
        <a href="/products">Products</a>
        <a href="/aboutus">About Us</a>
        <a href="/contactus">Contact Us</a>
    </div>


    @guest

    <div class="right-header">
        <a href="/basket">Basket</a>
        <a href="/signup">Sign Up</a>
        <a href="/login">Login</a>
    </div>

    @endguest

    @auth



    <div class="right-header">
        <a>{{auth()->user()->name}}</a>
        <a href="/basket">Basket</a>
        <a href="/orders">Orders</a>
        <a href = "/signout">Signout</a>

    </div>

    @endauth


</div>

<body>
    @yield('body')
</body>

<footer>
<section class="footer">

<div class="box-container">

    <div class="box">
        <h3>quick links</h3>
        <a href="/">Home</a>
        <a href="/products">Products</a>
        <a href="/aboutus">About Us</a>
        <a href="/contactus">Contact Us</a>
        <a href = "/basket">Basket</a>
    </div>

    <div class="box">
        <h3>Subscribe to our news letter</h3>
        <br>
        <form >
            <input type = "email" placeholder="Enter email address" required>
            <input type = "submit" value = "Follow me">
        </form>
    </div>

    <div class="box">
        <h3>contact info</h3>
        <a href="#">+0121 204 3000</a>
        <a href="#">EventTick@aston.ac.uk</a>
        <a href="#">Birmingham, United Kingdom</a>
        <img src="images/payment.png" alt="">
    </div>

</div>

<div class="credit"> <span> </span> </div>

</section>
</footer>
</html>