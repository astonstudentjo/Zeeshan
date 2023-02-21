<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Products</title>
    </head>

    <div>
        <a href = '/products/category/price_ascending'>Price-Low to High</a>
        <a href = '/products/category/price_descending'>Price-High to Low</a>
        <a href = '/products/category/pop'>Pop</a>
        <a href = '/products/category/metal'>Metal</a>
        <a href = '/products/category/rap'>Rap</a>
        <a href = '/products/category/rock'>Rock</a>
        <a href = '/products/category/country'>Country</a>


    </div>
    <div>
        @foreach($products as $product)

            <div>
                <a href = "/products/{{$product->id}}">
                


                <img src="/productImages/{{ $product->img }}" width="300px">
                
            </div>
                <h1> {{$product->name}}</h1>
                <h1>{{$product->artist}}</h1>
                <h4> {{$product->category}}</h4>
                <h4> £{{$product->price}}</h4>


                </a>
            </div>
        @endforeach
    </div>
</html>

@endsection