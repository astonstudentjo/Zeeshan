<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Contact Us</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="{{ asset('css/contactus.css') }}">
    </head>

    <style media="screen">
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

li {
  display: inline;
}
</style>
</head>

<!-- header section starts
<header>

<ul>
    <li><a href="#" class="logo">Website.</a></li>
    <li><a href="#wishlist">Wish List</a></li>
    <li><a href="#contact"><a href="../HTML/contactus.html">Contact Us</a></li>
    <li><a href="#about"><a href="../HTML/aboutus.html">About Us</a></li>
    <li><a href="#ticket"><a href="../HTML/productspage.html">Ticket</a></li>
    <li><a href="#login"><a href="../HTML/login.html">Log in</a></li>
    <li><a href="#register"><a href="../HTML/Registration.html">Register</a></li>
</ul>

</header>
header section ends -->

<hr>
<!--contact section starts-->

<!--The contact section has a form with fields for name, email, number, and message. 
    It also includes an image on the right side. -->

<section class="contact" id="contact">

    <h1 class="heading"> Contact us </h1>

    <div>
    <h class="heading"> Social media:</h>
        <div>
        <img src="./images/instagram.png">
        <p class="socials"> @Eventick</p>
        </div>
        <div>
        <img src="./images/facebook.png">
        <p class="socials"> @Eventick</p>
        </div>
        <div>
        <img src="./images/linkden.png">
        <p class="socials"> @Eventick</p>
        </div>
        <div>
        <img src="./images/twitter.png">
        <p class="socials"> @Eventick</p>
        </div>
        <p class="text">If you have any queries or issues please drop us an email or give us a call using the following information:</p>
    </div>
<div> 
    <div>
    <img src="./images/phone.png" alt="phone">
    <p>0121 465 298</p>
    </div>
    <div>
    <img src="./images/email.png" alt="email">
    <p>support@eventick.ac.uk</p>
    </div>
</div>
    <div class="row">

        <form action="">
            <input type="text" placeholder="name" class="box">
            <br>
            <input type="email" placeholder="email" class="box">
            <br>
            <input type="number" placeholder="number" class="box">
            <br>
            <textarea name="" class="box" placeholder="message" id="" cols="30" rows="10"></textarea>
            <br>
            <input type="submit" value="send message" class="btn">
        </form>

        <div class="image">
            <img src="./images/side2.jpg" alt="">
        </div>

    </div>

   

</section>
@include ('layouts.footer')
<!-- contact section ends -->

<hr>
<!-- footer section starts-->


<!-- footer section ends -->


</html>

@endsection
