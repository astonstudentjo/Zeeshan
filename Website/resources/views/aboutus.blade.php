<!DOCTYPE html>
@extends('layouts.main')
@section('body')

<html>
    <head>
        <meta charset="utf-8">
        <title>About Us</title>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ticket Selling Website</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="{{ asset('css/aboutus.css') }}">

    <style media="screen">

        /* ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        }

        li {
        display: inline;
        } */
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


<!-- about section starts  -->

<body>
    
  <div>
        <img class="image" src="./images/background.png" alt="background image"> 
   
  </div> 

        <section>    
        <h2 class="heading">Who we are: </h1>  
        <div class="info">
            <p>Welcome to our E-ticketing platform! We are a team of dedicated professionals</p>
            <p> who are passionate about providing a convenient and hassle-free ticket purchasing experience to our valued customers.</p>
            <p>Due to Covid, live music revenues collapsed by about 90%, leaving musicians and those working in venues or recording studios 
               badly affected because many were ineligible for the furlough scheme. Our aim is to bring attention back to the music industry and create events bigger and better than ever before. </p>
            <p>We want to be versatile by bringing a range of different genres and musicians onto the stage at our events to reach out to all our customers who will have different preferences when it comes
               to music. So not only are we giving you guys the chance to see some amazing artists such as Chris brown and Adele but we are giving more recognition to smaller artists who need a platform to expand and grow. </p>
    </div>
    </section>
        <section class = "Social Media">
        <a class="twitter-timeline" href="https://twitter.com/event_tick?ref_src=twsrc%5Etfw">Tweets by event_tick</a> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
      </section>
    <section>
        <div class="info">
    <div>
        <h3 class="heading"> Our team </h>
    </div>
    </section>
    <section class="container">
      <div class="card">
        <div class="image">
          <!--<img src="images/img1.jpg" alt="" />-->
        </div>
        <h2>Someone Name</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elite.</p>
      </div>
      <div class="card">
        <div class="image">
          <!--<img src="images/img2.jpg" alt="" />-->
        </div>
        <h2>Someone Name</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elite.</p>
      </div>
      <div class="card">
        <div class="image">
          <!--<img src="images/img3.jpg" alt="" />-->
        </div>
        <h2>Someone Name</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elite.</p>
      </div>
      <div class="card">
        <div class="image">
          <!--<img src="images/img4.jpg" alt="" />-->
        </div>
        <h2>Someone Name</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elite.</p>
      </div>
    </section>
    <section>
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
    </section>
    </body>

<!-- about section ends -->


<!-- footer section starts-->


<!-- footer section ends -->


</html>
@endsection