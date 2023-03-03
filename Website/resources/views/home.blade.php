<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Home</title>

        <style>
            .categories{
            
            display: flex;
            padding: 10px;
            justify-content: space-between;
            
            
            
        }
        </style>
    </head>

    <br>
    <div class = "categories">
    <a href = '/products/category/pop'>Pop</a>
    <a href = '/products/category/metal'>Metal</a>
    <a href = '/products/category/rap'>Rap</a>
    <a href = '/products/category/rock'>Rock</a>
    <a href = '/products/category/country'>Country</a>
    </div>




    
</html>
@endsection