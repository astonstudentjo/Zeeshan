<!DOCTYPE html>
@extends('layouts.header')
@section('body')

<html>
    <head>
        <meta charset="utf-8">
        <title>About Us</title>
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

<!-- header section starts-->
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
<!-- header section ends -->

<hr>
<!-- about section starts  -->

<section class="about" id="about">

    <h1 class="heading">About Us </h1>

    <div class="row">

       
        <img src="  " alt="background image">
            
        </div>

        <div class="content">
            <h3>Who we are</h3>
            <p>Welcome to our E-ticketing platform! We are a team of dedicated professionals</p>
            <p> who are passionate about providing a convenient and hassle-free ticket purchasing experience to our valued customers.</p>
            <a href="#" class="btn">learn more</a>
             
            <br>
            <br>
            <button> Our Team</button>
            <br>
            <br>
            <br>
            <img src="  " alt="background image">
            <p>We take pride in our work, and our goal is to deliver exceptional customer service to each and 
                every one of our customers. We are committed to making the process of buying e-tickets online as simple and effortless as possible,
                 while ensuring that all transactions are safe and secure.</p>
            <p> Our mission is to offer a secure and reliable platform where customers can purchase e-tickets for various events such as concerts, sports games, theatre performances, and much more.
                 We understand the importance of convenience and speed, which is why we have designed our platform to be user-friendly, efficient and accessible 24/7.</p>
            <p> Our team comprises of individuals who are experts in their respective fields, including software developers, 
                customer service representatives, and marketing professionals. </p>
            <p> Thank you for choosing us as your go-to platform for all your e-ticketing needs. We look forward to continuing to serve you and
                 providing you with the best possible experience!</p>
        </div>

    </div>
</section>
</html>
<!-- about section ends -->

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