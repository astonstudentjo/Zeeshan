<!DOCTYPE html>
@extends('layouts.header')
@section('body')

<html>
    <head>
        <meta charset="utf-8">
        <title>About Us</title>
        <link rel="stylesheet" type="text/css" href="{{ asset('css/aboutus.css') }}">
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
<!-- about section starts  -->

<img class="image" src="./images/background.png" alt="image">
<section>

        <div class="info">
            <h3 class="heading">Who we are</h3>
            <p>Welcome to our E-ticketing platform! We are a team of dedicated professionals</p>
            <p> who are passionate about providing a convenient and hassle-free ticket purchasing experience to our valued customers.</p>
            <p>Due to Covid, live music revenues collapsed by about 90%, leaving musicians and those working in venues or recording studios 
               badly affected because many were ineligible for the furlough scheme. Our aim is to bring attention back to the music industry and create events bigger and better than ever before. </p>
            <p>We want to be versatile by bringing a range of different genres and musicians onto the stage at our events to reach out to all our customers who will have different preferences when it comes
               to music. So not only are we giving you guys the chance to see some amazing artists such as Chris brown and Adele but we are giving more recognition to smaller artists who need a platform to expand and grow. </p>
              
             
            <h> our team </h>
            <div class="profile">
        <div>
        <img src="./images/profile.png" alt="profile">
        <p>Humera Muhammad</p>
        <p>200060828@aston.ac.uk</p>
        </div>
        <div>
        <img src="./images/profile.png" alt="profile">
        <p> Jenson</p>
        <p>@aston.ac.uk</p>
        </div>
        <div>
        <img src="./images/profile.png" alt="profile">
        <p> Faryak</p>
        <p>@aston.ac.uk</p>
        </div>
    </div>
        <div class="info">
            <h4 class="heading">Our mission:</h4>


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
    </div>
    </section>

<!-- about section ends -->
@include ('layouts.footer')
<hr>
<!-- footer section starts-->


<!-- footer section ends -->




</html>
@endsection