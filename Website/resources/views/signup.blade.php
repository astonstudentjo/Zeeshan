@extends('layouts.main')
@section('body')
<div>
    <span class="Title">
        <p> Register an account!</p>
    </span>
    <link rel="stylesheet" href="{{ asset('css/signup.css') }}">
    <div class="signup">
        <form action="{{ route('signup') }}" method="post">
            <p> Already have an account? <a href="{{ route('login') }}">Login</a></p>
            <label for="name"> Full Name: </label>
            <input type="text" placeholder="Full name" name="name">
            <p class="error">
                @csrf
                @error('name')
                {{$message}}
                @enderror
            </p>
            <br>
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
                <br>
                @enderror
            </p>
            <br>
            <label for="password_confirmation"> Password Confirmation: </label>
            <input type="password" placeholder="Password Again" name="password_confirmation">
            <br>
            <br>
            <br>

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