<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Products</title>
        <style>
        .products{
            display: flex;
            padding-top: 20px;
            float:inline-end;
            
            
        }

        .product{
            padding: 10px;
        }

        .categories{
            display: flex;
            padding: 10px;
            justify-content: space-between;
        }

        
        </style>
    </head>

    <div class = "categories">
        <a href = '/products/category/price_ascending'>Price-Low to High</a>
        <a href = '/products/category/price_descending'>Price-High to Low</a>
        <a href = '/products/category/pop'>Pop</a>
        <a href = '/products/category/metal'>Metal</a>
        <a href = '/products/category/rap'>Rap</a>
        <a href = '/products/category/rock'>Rock</a>
        <a href = '/products/category/country'>Country</a>


    </div>
    <div class = "products">
        @foreach($products as $product)

            <div class = "product">
                <a href = "/products/{{$product->id}}">               
                <img src="/productImages/{{ $product->img }}" width="300px">
                <h1> {{$product->name}}</h1>
                <h1>{{$product->artist}}</h1>
                <h4> {{$product->category}}</h4>
                <h4> £{{$product->price}}</h4>
                @if ($product->stock <= 0)

                <h4>Out of Stock!</h4>
                @elseif ($product-> stock< 20)
                <h4>Only {{$product -> stock}} remaining buy now!!!</h4>  
                @endif


                </a>
            </div>
        @endforeach
    </div>
</html>

@endsection