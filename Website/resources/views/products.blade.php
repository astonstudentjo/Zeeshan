<!DOCTYPE html>
@extends('layouts.main')
@section('body')
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ticket Selling Website</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/products.css') }}">


</head>

<body>


    <section class="icons-container">
        <div class="icons">
            <img src="{{ asset('images/icon-2.png') }}" alt="">
            <div class="info">
                <h3>10 days returns</h3>
                <span>moneyback guarantee</span>
            </div>
        </div>

        <div class="icons">
            <img src="{{ asset('images/icon-3.png') }}" alt="">

            <div class="info">
                <h3>offer & gifts</h3>
                <span>on all orders</span>
            </div>
        </div>

        <div class="icons">
            <img src="{{ asset('images/icon-4.png') }}" alt="">


            <div class="info">
                <h3>secure paymens</h3>
                <span>protected by paypal</span>
            </div>
        </div>

    </section>

    <!-- icons section ends -->
    <!-- catagory section starts -->
    <section class="Catergory">
        <h1 class="heading"> Categories </h1>
        <div class="categories">
            <a href='/products/category/price_ascending'>Price-Low to High</a>
            <a href='/products/category/price_descending'>Price-High to Low</a>
            <a href='/products/category/pop'>Pop</a>
            <a href='/products/category/metal'>Metal</a>
            <a href='/products/category/rap'>Rap</a>
            <a href='/products/category/rock'>Rock</a>
            <a href='/products/category/country'>Country</a>
        </div>
    </section>
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




    @if(isset($searchQuery))
    <p>Search results for: "{{ $searchQuery }}"</p>
    @endif





    <!-- prodcuts section starts  -->

    <section class="products" id="products">

        <h1 class="heading"> TICKETS AVAILABLE </h1>

        <div class="box-container">


            @foreach($products as $product)
            <div class="box">
                <!-- <span class="discount">-10%</span> -->
                <div class="image">
                    <!-- <img src="../images/tickets.png" alt=""> -->
                    <img src="/productImages/{{ $product->img }}" alt="../images/tickets.png" width="250px">
                    <!-- <img src="/productImages/{{ $product->img }}" alt="../images/tickets.png" width="300px"> -->

                    <div class="icons">
                        <a href="/products/{{$product->id}}" class="cart-btn">View More!</a>
                        <!-- <a href="#" class="fas fa-shopping-basket"></a>     -->

                    </div>
                </div>
                <div class="content">
                    <h3>{{$product->name}}</h3>
                    <h2> {{$product->artist}}</h2>
                    <h2>{{$product->category}}</h2>
                    <!-- <p> {{$product->description}}</p> -->
                    <div class="price">£{{$product->price}}</div>

                    @if ($product->stock <= 0) <h4 style="color: red">Out of Stock!</h4>
                        @elseif ($product-> stock< 10) <h4 style="color:orange">Only {{$product -> stock}} remaining buy now!</h4>
                            @endif
                </div>
            </div>
            @endforeach

            <!-- output the amount of products being shown -->

        </div>
        <br>
        <p>Showing {{$products->count()}} results</p>

    </section>

    <!-- prodcuts section ends -->

</body>

</html>
@endsection