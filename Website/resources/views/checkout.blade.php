@extends('layouts.header')


@section('body')

    <h1>Checkout</h1>

    <table>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        @foreach ($products as $product)
            <tr>
                <td>{{ $product->name }}</td>
                <td>£{{ number_format($product->price, 2) }}</td>
                <td>{{ $product->quantity }}</td>
                <td>£{{ number_format($product->price * $product->quantity, 2) }}</td>
            </tr>
        @endforeach
        <tr>
            <td colspan="3"></td>
            <td>£{{ number_format($totalPrice, 2) }}</td>
        </tr>
    </table>

    <form action="/checkout" method="POST">
        @csrf
        <button type="submit">Place Order</button>
    </form>
@endsection