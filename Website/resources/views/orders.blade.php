<!DOCTYPE html>
@extends('layouts.main')
@section('body')

<html>

<head>
    <meta charset="utf-8">
    <title>orders</title>
    <link rel="stylesheet" type="text/css" href="{{ asset('css/orders.css') }}">

</head>


<!-- show them a list of all places orders and when they click on the order they can see all the items they have ordered -->

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>Orders</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Order Date</th>
                        <th>Order Total (£)</th>
                        <th>Order Status</th>
                        <th>Order Details</th>
                    </tr>
                </thead>
                <tbody>
                    @foreach ($orders as $order)
                    <tr>
                        <td>{{ $order->id }}</td>
                        <td>{{ $order->created_at }}</td>
                        <td>£ {{ $order->total_price }}</td>
                        <td>{{ $order->status }}</td>
                        <td><a href="{{ route('confirmation', $order->id) }}">View</a></td>
                    </tr>
                    @endforeach
                </tbody>
            </table>
        </div>
    </div>
</div>


<div class="padder"></div>

</html>
@endsection