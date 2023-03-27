<!DOCTYPE html>
@extends('layouts.main')
@section('body')


<html>

<head>
    <meta charset="utf-8">
    <title>Login</title>
    <!-- <link rel="stylesheet" href="../css/login.css"> -->
    <link rel="stylesheet" type="text/css" href="{{ asset('css/login.css') }}">

</head>
<!-- placement for the image-->


<br>
<heading class="Title">Welcome back! </heading>
<br>

<div class = "login">
    <form class = "login-form" action="{{ route('login') }}" method="post">

    <h> Log in to your account </h>
<p> New to EventTick? <a href="{{ route('signup') }}">Register an account</a></p>
<br>

        <div class="error">

            @csrf

            @if(session('status'))

            {{session('status')}}
            <br>


            @endif


        </div>


        <label for="email"> Email: </label>
        <input type="text" placeholder="Email" name="email">

        <p class="error">
            @error('email')
            {{$message}}
            @enderror
        </p>
        <br>




        <label for="password"> Password: </label>
        <input type="password" placeholder="Password" name="password">

        <p class="error">
            @error('password')
            {{$message}}

            @enderror
        </p>
        <br>
        <br>
        <button class="loginsubmit" type="submit">Login to view your account</button>
        <br>


    </form>
    <br>

</div>


</html>
@endsection
