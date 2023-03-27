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
    <!-- <br> -->
    <section class="display">
        <div class="content">
            <br>
            <h3>Buy Tickets</h3>
            <span>Concerts & music events</span>
            <p>Attention all music lovers! Get ready to experience the thrill of live music!</p>
            <br>
            <a href="{{ url('/products') }}" class="btn">Buy now</a>
        </div>

        <div class="content">
            <h2>EventTick</h2>
        </div>

        <div class="content">
            <br>
            <br>
            <h3>Learn About Us!</h3>
            <span></span>
            <p>See our Vision</p>
            <br>
            <p>Learn more about our vision for the future of live music post pandemic and how we plan to keep the music industry going strong!</p>
            <a href="{{ url('/aboutus') }}" class="btn">About Us</a>
        </div>
    </section>

    <section class="category">
        <h1 class="heading">Categories</h1>
        <div class="categories">
            <a href="{{ url('/products/category/price_ascending') }}">Price-Low to High</a>
            <a href="{{ url('/products/category/price_descending') }}">Price-High to Low</a>
            <a href="{{ url('/products/category/pop') }}">Pop</a>
            <a href="{{ url('/products/category/metal') }}">Metal</a>
            <a href="{{ url('/products/category/rap') }}">Rap</a>
            <a href="{{ url('/products/category/rock') }}">Rock</a>
            <a href="{{ url('/products/category/country') }}">Country</a>
        </div>
    </section>
    <br>
    <br>
</body>
</html>
@endsection