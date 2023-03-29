<!DOCTYPE html>
@extends('layouts.main')
@section('body')

<html>

<head>
    <meta charset="utf-8">
    <title>confirmation</title>
    <link rel="stylesheet" type="text/css" href="{{ asset('css/confirmation.css') }}">
</head>
<!-- only show this data if the user_id matches the current user -->



@if($confirmation->user_id == Auth::user()->id)

<br>
<br>
<!-- <h1>Thank you for your order!</h1> -->
<img src="{{ asset('images/Thanks.png') }}" alt="Thanks" width="500" height="500">
<h2>Order number: {{$confirmation->id}}</h2>
<h2>Order date: {{$confirmation->created_at}}</h2>
<h2>Order total: £{{$confirmation->total_price}}</h2>
<h2>Order status: {{$confirmation->status}}</h2>
<br>
<h2>Tickets Ordered:</h2>
<table>
    <thead>
        <tr>
            <th>Image</th>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total Price</th>
            
        </tr>
    </thead>
    <tbody>
        <?php $totalQuantity = 0; $totalPrice = 0; ?>
        @foreach($confirmation->items as $orderItem)
        <?php 
        $totalQuantity += $orderItem->quantity; 
        $totalPrice += $orderItem->price * $orderItem->quantity;
        // $FullPrice += $totalPrice;


        ?>
        <tr>
            <td><img src="{{ asset('productImages/' . $orderItem->product->img) }}" alt="product image" width="100" height="100"></td>
            <td>{{ $orderItem->product->name }}</td>
            <td>£{{ $orderItem->product->price }}</td>
            <td>{{ $orderItem->quantity }}</td>
            <th>£{{ number_format($orderItem->price * $orderItem->quantity, 2) }}</th>
        </tr>
        @endforeach
        <tr>
            <td>Total:</td>
            <td></td>
            <td></td>
            <td>{{$totalQuantity}}</td>
            <td>£{{ number_format($totalPrice, 2) }}</td>

        </tr>
    </tbody>
</table>

<br>



<br>
<!-- <a href="/orders">View Orders</a> --> 
<!-- make a view orders button -->
<a href="/orders" class="btn btn-primary">View Orders</a>
@endif

</html>
@endsection