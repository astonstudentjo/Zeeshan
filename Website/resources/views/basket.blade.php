<!DOCTYPE html>
@extends('layouts.header')
@section('body')

<html>

<head>
    <meta charset="utf-8">
    <title>Basket</title>
</head>

<div>
    <div>
        <h1>My Basket</h1>


        @if (count($product) == 0)
        <p>Your basket is empty</p>
        @else

        <table>
            <tr>
                <th>Product</th>
                <th>Price</th>
                <!-- <th>Quantity</th> -->
                <th>Total</th>
            </tr>
            @foreach ($product as $item)
            @if ($item != null)

            
                <tr>
                    <td>{{ $item->name }}</td>
                    <td>£{{ number_format($item->price, 2) }}</td>
                    <td>{{ $item->stock }}</td>
                    <td>£{{ number_format($item->price * $item->stock, 2) }}</td>
                </tr>
            @endif
        @endforeach
        </table>
        <p>There are {{ count($product) }} items in your basket</p>

        @endif


        <form action="/basket/clear" method="POST">
            @csrf
            <button type="submit">Clear Basket</button>
        </form>
    </div>
</div>










</html>
@endsection