<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Product</title>
    </head>


    <div>
       

        
        <img src = "/productImages/{{$concert->img}}"></div>
        <h1>{{$concert->artist}}</h1>
        <h4> {{$concert->name}}</h4>
        <h4> {{$concert->category}}</h4>
        <p>{{$concert->description}}</p>
        <p>£{{$concert->price}}</p>


        
        @if ($concert->stock > 0)
        <form action="/basket" method="POST">
            @csrf
            <input type="hidden" name="product_id" value="{{$concert->id}}">
            <button type="submit">Add to Basket</button>
        </form>
            
        @else
        <p>Out of stock</p>

        @endif
            
        
        

       








        
        

            
       
    </div>
</html>

@endsection