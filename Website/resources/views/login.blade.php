<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
    </head>

    <div>
        <form action = "/login" method = "post">

            @csrf
            @error('email')
            {{$message}}
            <br>
            @enderror

            <label for = "email"> Email: </label>
            <input type = "text" placeholder = "Email" name = "email">
            <br><br>

            
            @error('password')
            {{$message}}
            <br>
             @enderror
         
            <label for  = "password"> Password: </label>
            <input type = "password" placeholder =  "Password" name = "password">
            <br><br>

            <button type = "submit">Login </button>

        </form>


    </div>

    
</html>
@endsection