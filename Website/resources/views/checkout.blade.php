@extends('layouts.main')


@section('body')

<head>
    <meta charset="utf-8">
    <title>Checkout</title>
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/basket.css') }}">
</head>

<header>
    <h1>Checkout</h1>
</header>


<?php
$totalQuantity = 0;
?>

<table class="table">
    <thead>
        <tr>
            <th>image</th>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
    </thead>
    @foreach ($products as $product)
    <tr>
        <td><img src="{{ asset('productImages/' . $product->img) }}" alt="product image" width="100" height="100"></td>
        <td>{{ $product->name }}</td>
        <td>£{{ number_format($product->price, 2) }}</td>
        <td>{{ $product->quantity }}</td>
        <td>£{{ number_format($product->price * $product->quantity, 2) }}</td>
    </tr>
    <?php
    $totalQuantity += $product->quantity;

    ?>

    @endforeach
    <tr>
        <td colspan="2"></td>
        <td>Total</td>
        <td>{{$totalQuantity}}</td>
        <td>£{{ number_format($totalPrice, 2) }}</td>
    </tr>
</table>

@if (session('error'))
<div class="alert alert-danger">{{ session('error') }}</div>
@endif
<div class="right-bar">
    <form action="/checkout" method="POST">
        @csrf
        <!-- post the totalprice -->
        <input type="hidden" name="totalPrice" value="{{ $totalPrice }}">
        <button type="submit">Place Order</button>
    </form>
</div>

@endsection