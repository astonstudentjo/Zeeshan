<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Product</title>

        <style>
            

        </style>
    </head>


    
       

        
        <img src = "/productImages/{{$concert->img}}"></div>
        <h1>{{$concert->artist}}</h1>
        <h4> {{$concert->name}}</h4>
        <h4> {{$concert->category}}</h4>
        <p>{{$concert->description}}</p>
        <p>£{{$concert->price}}</p>


        
        @if ($concert->stock > 0)
        <form action="/basket" method="POST">
            @csrf
            <select name = "quantity">
                <option value  = 1>1</option>
                <option value  = 2>2</option>
                <option value  = 3>3</option>
                <option value  = 4>4</option>
                <option value  = 5>5</option>
                <option value  = 6>6</option>
                <option value  = 7>7</option>
                <option value  = 8>8</option>
                <option value  = 9>9</option>
                <option value  = 10>10</option>


            </select>
            <input type="hidden" name="product_id" value="{{$concert->id}}">
            <button type="submit">Add to Basket</button>
        </form>
            
        @else
        <p>Out of stock</p>

        @endif
      

            
    
</html>

@endsection