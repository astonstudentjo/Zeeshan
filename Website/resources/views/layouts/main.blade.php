<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/styles.css') }}">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.0.7/css/boxicons.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>
    <div class="header-container">
        <div class="left-header">
            <img class = "logo" src="{{ asset('images/logo.png') }}" width="150" height="30">       
            <a href="{{ url('/') }}">Home</a>
            <a href="{{ url('/products') }}">Products</a>
            <a href="{{ url('/aboutus') }}">About Us</a>
            <a href="{{ url('/contactus') }}">Contact Us</a>
        </div>

        @guest
        <div class="right-header">
            <a href="{{ url('/basket') }}"> <i class='bx bxs-cart'></i>
                @if (Session::has('basketQuantities'))
                Items: {{ array_sum(Session::get('basketQuantities')) }}
                @else
                (EMPTY)
                @endif
            </a>
            <a href="{{ url('/signup') }}">Sign Up</a>
            <a href="{{ url('/login') }}">Login</a>
        </div>
        @endguest

        @auth
        <div class="right-header">
            <span class = "auth-name"> {{auth()->user()->name}} </span>
            <a href="{{ url('/basket') }}"> <i class='bx bxs-cart'></i>
                @if (Session::has('basketQuantities'))
                Items: {{ array_sum(Session::get('basketQuantities')) }}
                @else
                (EMPTY)
                @endif
            </a>
            <a href="{{ url('/orders') }}">Orders</a>
            <a href="{{ url('/signout') }}">Signout</a>
        </div>
        @endauth
    </div>

    <div class="body">
        @if(session('success'))
        <div class="alert alert-success" role="alert">
            {{ session('success') }}
        </div>
        @endif
        @error('newsletteremail')
        <div class="alert alert-danger">
            {{ $message }}
        </div>
        @endif  
        @yield('body')
    </div>

    <footer>
        <div class="footer-box">
            <div class="footer-area">
                <div class="footer-component 1">
                    <h3>Quick Links</h3>
                    <a href="{{ url('/') }}">Home</a>
                    <a href="{{ url('/products') }}">Products</a>
                    <a href="{{ url('/aboutus') }}">About Us</a>
                    <a href="{{ url('/contactus') }}">Contact Us</a>
                    <a href="{{ url('/basket') }}">Basket</a>
                </div>

                <div class="footer-component 2">
                    <h3>Contact Info</h3>
                    <a href="tel:+0121 204 3000">+0121 204 3000</a>
                    <a href="mailto:EventTick@aston.ac.uk">EventTick@aston.ac.uk</a>
                    <a href="https://goo.gl/maps/7FpErGeDp9EyaoHp6">Birmingham, United Kingdom</a>
                </div>

                <div class="footer-component-newsletter">
                    <h3>Subscribe to our newsletter</h3>
                    <form class="newsletter-form" action="/newsletter" method="post">
                        @csrf
                        <input type="email" id="footer-newsletter-email" name="newsletteremail" placeholder="Enter email address" required>
                        <input type="submit" id="footer-newsletter-btn">
                    </form>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>