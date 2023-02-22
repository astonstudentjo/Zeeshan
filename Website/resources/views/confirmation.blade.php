<!DOCTYPE html>
@extends('layouts.header')
@section('body')

<html>

<head>
    <meta charset="utf-8">
    <title>confirmation</title>
</head>
<!-- only show this data if the user_id matches the current user -->



@if($confirmation->user_id == Auth::user()->id)

<div>
    <h1>Thank you for your order!</h1>
    <h2>Order number: {{$confirmation->id}}</h2>
    <h2>Order date: {{$confirmation->created_at}}</h2>
    <h2>Order total: £{{$confirmation->total_price}}</h2>
    <h2>Order status: {{$confirmation->status}}</h2>
    <h2>Tickets Ordered:</h2>
</div>
<div>
    <table>
        <thead>
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <?php $totalQuantity = 0; ?>
            @foreach($confirmation->items as $orderItem)
            <?php $totalQuantity += $orderItem->quantity; ?>
            <tr>
                <td>{{ $orderItem->product->name }}</td>
                <td>£{{ $orderItem->product->price }}</td>
                <td>{{ $orderItem->quantity }}</td>
            </tr>
            @endforeach
            <tr>
                <td><br>Total Quantity:</td>
                <td></td>
                <td>{{$totalQuantity}}</td>
            </tr>
        </tbody>
    </table>


    <br>
    <br>
    <a href="/orders">View Orders</a>
</div>
@endif








</html>
@endsection