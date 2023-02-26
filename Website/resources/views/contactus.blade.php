<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Contact Us</title>
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

<!-- contact section ends -->

<hr>
<!-- footer section starts-->
<section class="footer">

    <div class="box-container">

        <div class="box">
            <h3>quick links</h3>
            <a href="#">home</a>
            <a href="#">about</a>
            <a href="#">products</a>
            <a href="#">review</a>
            <a href="#">contact</a>
        </div>

        <div class="box">
            <h3>extra links</h3>
            <a href="#">my account</a>
            <a href="#">my favorite</a>
        </div>

        <div class="box">
            <h3>locations</h3>
            <a href="#">England</a>
            <a href="#">USA</a>
            <a href="#">Japan</a>
            <a href="#">France</a>
        </div>

        <div class="box">
            <h3>contact info</h3>
            <a href="#">+123-456-7890</a>
            <a href="#">example@gmail.com</a>
            <a href="#">city, country - 400104</a>
            <img src="images/payment.png" alt="">
        </div>

    </div>

    <div class="credit"> <span> </span> </div>

</section>

<!-- footer section ends -->

    
</html>

@endsection