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
        <p>{{$concert->descriptiton}}</p>
        <p>£{{$concert->price}}</p>
        

            
       
    </div>
</html>

@endsection