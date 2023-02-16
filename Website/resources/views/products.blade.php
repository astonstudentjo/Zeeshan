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
                


                <img src="/productImages/{{ $product->img }}" width="300px">
                
            </div>
                <h1> {{$product->name}}</h1>
                <h1>{{$product->artist}}</h1>
                <h4> {{$product->category}}</h4>


                </a>
            </div>
        @endforeach
    </div>
</html>

@endsection