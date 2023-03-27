<!DOCTYPE html>
@extends('layouts.main')
@section('body')


<head>
    <meta charset="utf-8">
    <title>Basket</title>
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/basket.css') }}">
</head>

<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->
<br>
<header>
    <h1>My Basket</h1>
</header>

<br>

@if (count($product) == 0)
<p class="empty">Your basket is empty</p>

@else
<form action="/basket/update" method="POST">
    @csrf
    <table class="table">
        <thead>
        <tr>
            
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>delete items</th>

        </tr>
</thead>
        @php
        $total = 0;
        $productQuantities = Session::get('basketQuantities', []);
        @endphp
        @foreach ($product as $item)
        @php
        $itemId = $item->id;
        $quantity = $productQuantities[$itemId] ?? 0;
        $total += $item->price * $quantity;
        @endphp
        @if ($quantity > 0)
        
        <br>
        <tr>
      
            <td>{{ $item->name }}</td>
            <td>£{{ number_format($item->price, 2) }}</td>
            <td>
                <!-- auto update without pressing submit button -->

                <select name="quantity[{{ $itemId }}]">
                    @for ($i = 1; $i <= 10; $i++) <option value="{{ $i }}" {{ $i == $quantity ? 'selected' : '' }}>{{ $i }}</option>
                        @endfor
                </select>
            </td>
         
            <td>£{{ number_format($item->price * $quantity, 2) }}</td>
</div>
            <td hidden>
                <form action="/basket/remove" method="POST" hidden>
                    @csrf
                    <input type="hidden" name="product_id" value="{{ $itemId }}">
                    <button type="submit" hidden>Remove</button>
                </form>
            </td>

            <!-- remove item for basket -->
            <td>
                <form action="/basket/remove" method="POST">
                    @csrf
                    <input type="hidden" name="product_id" value="{{ $itemId }}">
                    <button type="submit">Remove</button>
                </form>
            </td>
        </tr>
        @endif
        @endforeach

        <tr>
            <td colspan="3"></td>
            <td>£{{ number_format($total, 2) }}</td>
        </tr>
    </table>
    <br>
    <div class="">
    <div>
        <p class="items">Total items: {{ $totalItems }}</p>
    </div>

    @if (session('error'))
  
    <div class="alert alert-danger">{{ session('error') }}</div>
    @endif
    <div class="button-update">
    <button type="submit">Update Basket</button>
</div>
</form>
@endif
<br>
<div class="button-clear">
<form action="/basket/clear" method="POST">
    @csrf
    <button type="submit">Clear Basket</button>
</form>
</div>

<div class="right-bar">
    <form action="/checkout" method="GET">
 <button type="submit"><i class="fa fa-shopping-cart"></i>Checkout</a></button>
    </form>
</div>
</div>
<br>
<div class="total">
    <form action="/products" method="GET">
        <button type="submit">Continue Shopping</button>
    </form>
</div>




<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->



</main>





@endsection