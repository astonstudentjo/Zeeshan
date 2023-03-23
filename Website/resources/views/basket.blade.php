<!DOCTYPE html>
@extends('layouts.main')
@section('body')


<head>
    <meta charset="utf-8">
    <title>Basket</title>
    <link rel="stylesheet" type="text/css" href="{{ asset('css/basket.css') }}">
</head>
<h1>My Basket</h1>

@if (count($product) == 0)
<p>Your basket is empty</p>

@else
<form action="/basket/update" method="POST">
    @csrf
    <table>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Remove</th>

        </tr>
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

    <div>
        <p>Total items: {{ $totalItems }}</p>
    </div>

    @if (session('error'))
    <div class="alert alert-danger">{{ session('error') }}</div>
    @endif
    <button type="submit">Update Basket</button>
</form>
@endif

<form action="/basket/clear" method="POST">
    @csrf
    <button type="submit">Clear Basket</button>
</form>


<br>
<div>
    <form action="/checkout" method="GET">
        <button type="submit">Checkout</button>
    </form>
</div>

<br>
<div>
    <form action="/products" method="GET">
        <button type="submit">Continue Shopping</button>
    </form>
</div>

<div class="empty-basket-Padder"></div>

<header>
		<h1>My Basket</h1>
	</header>
	<main>
		<section class="cart-items">
			<h2>Shopping Cart</h2>
			<ul>
				<li>
					<img src="https://via.placeholder.com/100x100" alt="Product Image">
					<div class="product-info">
						<h3>Product Name</h3>
						<p>Price: $9.99</p>
						<input type="number" value="1" min="1">
						<button>Remove</button>
					</div>
				</li>
				<li>
					<img src="https://via.placeholder.com/100x100" alt="Product Image">
					<div class="product-info">
						<h3>Product Name</h3>
						<p>Price: $14.99</p>
						<input type="number" value="1" min="1">
						<button>Remove</button>
					</div>
				</li>
			</ul>
		</section>
		<section class="total">
			<h2>Total</h2>
			<p>Subtotal: $24.98</p>
			<p>Shipping: $5.00</p>
			<p>Total: $29.98</p>
			<button>Checkout</button>
		</section>


@endsection