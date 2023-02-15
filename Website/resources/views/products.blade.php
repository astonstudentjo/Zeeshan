<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Products</title>
    </head>


    <div>
        @foreach($products as $product)

            <div>
                <a href = "/products/{{$product->id}}">
                <img src = "/productImages/{{$product->img}}"></div>
                <h4> {{$product->category}}</h4>
                <h1>{{$product->artist}}</h1>
                <h4> {{$product->name}}</h4>
                </a>
            </div>
        @endforeach
    </div>
</html>

@endsection