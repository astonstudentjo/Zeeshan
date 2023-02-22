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
        <form action="/basket/update" method="POST">
            @csrf
            <table>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
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
                        <select name="quantity[{{ $itemId }}]">
                            @for ($i = 1; $i <= 10; $i++) <option value="{{ $i }}" {{ $i == $quantity ? 'selected' : '' }}>{{ $i }}</option>
                                @endfor
                        </select>
                    </td>
                    <td>£{{ number_format($item->price * $quantity, 2) }}</td>
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
    </div>


    <br>
    <div>
        <form action="/checkout" method="GET">
            <button type="submit">Checkout</button>
        </form>
    </div>
</div>










</html>
@endsection