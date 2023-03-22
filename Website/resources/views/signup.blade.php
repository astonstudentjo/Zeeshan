@extends('layouts.main')
@section('body')

<span class="image-container">
    <img src="{{ asset('images/welcome.jpg') }}" alt="image" width="550" height="115">

</span>
<div>

    <span class="Title">
        <p> Register an account!</p>
    </span>

    <link rel="stylesheet" href="{{ asset('css/signup.css') }}">
    <div class="signup">
        <form action="/signup" method="post">

        
            <label for="name"> Full Name: </label>
            <input type="text" placeholder="Full name" name="name">
            <br><br>

            @csrf
            @error('name')
            {{$message}}
            <br>
            @enderror

            <label for="email"> Email: </label>
            <input type="text" placeholder="Email" name="email">
            <br><br>

            @error('email')
            {{$message}}
            <br>
            @enderror


            <label for="password"> Password: </label>
            <input type="password" placeholder="Password" name="password">
            <br><br>

            @error('password')
            {{$message}}
            <br>
            @enderror


            <label for="password_confirmation"> Password Confirmation: </label>
            <input type="password" placeholder="Password Again" name="password_confirmation">
            <br><br>

            <button type="submit">Sign Up </button>
            <br>
            <!-- <span class="description">
                <p>By continuing past this page, you agree to the <u>Terms of Use</u> Purchase Policy and understand that 
                    information will be used as described in our <u>Privacy Policy.</u></p>
                </span>
                
                <span class="description2">
                   <p> Need helping logging in, contact us: <br> 
                    <br>
                   <u> +44 7508156819</u> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <u>200060828@aston.ac.uk </u>
                    </p>
                </span> -->
        </form>


    </div>

</div>
@endsection