<!DOCTYPE html>
@extends('layouts.main')
@section('body')
<html>

<head>
  <meta charset="utf-8">
  <title>Home</title>
  <style>
    .categories {

      display: flex;
      padding: 10px;
      justify-content: space-between;
    }
  </style>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ticket Selling Website</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="{{ asset('css/home.css') }}">

</head>

<body>
  <section class="display">
    <div class="content">
      <br>
      <h3>Buy Tickets</h3>
      <span>Concerts & music events</span>
      <p>Attention all music lovers! Get ready to experience the thrill of live music!</p>
      <a href="{{ url('/products') }}" class="btn" style="margin-top: 5%;">Buy now</a>
    </div>

    <div class="content">
      <!-- <h2>EventTick</h2> -->
      <img src="{{ asset('images/logo-white.png') }}" alt="EventTick" width="100%" height="100%">
    </div>

    <div class="content">
      <br>
      <br>
      <h3>Learn About Us!</h3>
      <span>See our Vision</span>
      <p>Learn more about our vision for the future of live music post pandemic and how we plan to keep the music industry going strong!</p>

      <a href="{{ url('/aboutus') }}" class="btn">About Us</a>
    </div>
  </section>

  <section class="category">
    <h1 class="heading">Categories</h1>
    <div class="categories">
      <a href="{{ url('/products/category/pop') }}">Pop</a>
      <a href="{{ url('/products/category/metal') }}">Metal</a>
      <a href="{{ url('/products/category/rap') }}">Rap</a>
      <a href="{{ url('/products/category/rock') }}">Rock</a>
      <a href="{{ url('/products/category/country') }}">Country</a>
    </div>
  </section>
  <br>
  <br>

  <?php
  if (isset($_GET['search'])) {
    $searchQuery = $_GET['search'];
  } else {
    $searchQuery = null;
  }
  ?>

  <!-- add a search bar that searches  -->
  <section class="search">
    <div class="searchbar">
      <form action="/products/search/{searchQuery}" method="GET">

        <input type="text" name="search" placeholder="Search for an Event or Artist">
        <button type="submit">Search</button>
      </form>
    </div>
  </section>

  <br>


  <section class="Community-reviews">
    <h1 class="heading">Community Reviews</h1>
    <div class="Reviews">
      <div class="Review">
        <div class="ImageArea" style="background-image: url('{{ asset('images/suit.png') }}');"></div>
        <div class="ImageText">
          <span class="header_text"><strong>John Doe</strong></span>
          <p>"Excellent service, highly recommend. Professional, efficient, great customer service. Would use again."</p>
        </div>
        <br>
        <!-- add stars rating -->
        <div class="stars">
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="far fa-star"></i>
        </div>

      </div>

      <div class="Review">
        <div class="ImageArea" style="background-image: url('{{ asset('images/suit.png') }}');"></div>
        <div class="ImageText">
          <span class="header_text"><strong>James Chris</strong></span>
            <p>"The concert was fantastic! The artist's performance was electrifying, and the atmosphere was amazing. I had a great time and would definitely go to another one of their shows."</p>
        </div>
        <br>
        <!-- add stars rating -->
        <div class="stars">
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="far fa-star"></i>
          <i class="far fa-star"></i>
        </div>

      </div>


      <div class="Review">
        <div class="ImageArea" style="background-image: url('{{ asset('images/suit.png') }}');"></div>
        <div class="ImageText">
          <span class="header_text"><strong>John Smith</strong></span>
          <p>"I loved the concert! <br> The songs was engaging and the singers gave great performances."</p>
        </div>
        <br>
        <!-- add stars rating -->
        <div class="stars">
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
        </div>

      </div>


      <div class="Review">
        <div class="ImageArea" style="background-image: url('{{ asset('images/suit.png') }}');"></div>
        <div class="ImageText">
          <span class="header_text"><strong>Karan Smith</strong></span>
          <p>"The concert was okay. The artist performed well but the atmosphere was lacking."</p>
        </div>
        <br>
        <!-- add stars rating -->
        <div class="stars">
          <i class="fas fa-star"></i>
          <i class="fas fa-star"></i>
          <i class="far fa-star"></i>
          <i class="far fa-star"></i>
          <i class="far fa-star"></i>
        </div>

      </div>
    </div>



    </div>

  </section>

  <section class="padding">
    <br>
    <br>
    <br>
    <br>
  </section>








</body>

</html>
@endsection