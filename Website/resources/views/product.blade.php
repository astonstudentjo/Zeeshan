<!DOCTYPE html>
@extends('layouts.main')
@section('body')


<html>

<head>
    <meta charset="utf-8">
    <title>Product</title>

    <style>


    </style>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/product.css') }}">
</head>
<div class = "page">
     <div class = heading>
        <h1>{{$concert->artist}}</h1>
        <h2> {{$concert->name}}</h2>
    </div>
    <div class = "product">
        <div class = "display">
            <img src="/productImages/{{$concert->img}}">
        </div>
        <div class = "BasketHandler">
        <div class = "info">
                    <h5> {{$concert->category}}</h5>
                    <p>{{$concert->description}}</p>
                </div>
            @if ($concert->stock > 0)
            <h4>£{{$concert->price}}</h4>
                <form action="/basket" method="POST">
                    @csrf
                <select class = "BasketHandler" name="quantity">
                    <option value=1>1</option>
                    <option value=2>2</option>
                    <option value=3>3</option>
                    <option value=4>4</option>
                    <option value=5>5</option>
                    <option value=6>6</option>
                    <option value=7>7</option>
                    <option value=8>8</option>
                    <option value=9>9</option>
                    <option value=10>10</option>
                </select>
                <input type="hidden" name="product_id" value="{{$concert->id}}">
                <button class = "btn" type="submit">Add to Basket</button>
                @else
                <h3>Out of stock</h3>
            @endif
        </div>
        </form>
    </div>

    <section class = "recomendations">
        <div class = "container">
        </div>
    </section>

<!-- back -->
<div class = "back">
        <form action="/products" method="GET">
        <button class = "btn"type="submit">Back</button>
        </form>
</div>
 



</div>

</html>
@endsection