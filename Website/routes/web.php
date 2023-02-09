<?php

use App\Http\Controllers\RegistrationController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('home');
});

Route::get('/products', function(){
    return view('products');
});

Route::get('/aboutus', function(){
    return view('aboutus');
});

Route::get('/contactus', function(){
    return view('contactus');
});

/**Route::get('/signup', function(){
    return view('signup');
});
*/

Route::get('/signup', [RegistrationController::class, 'show']);

Route::post('/signup', [RegistrationController::class, 'create']);


Route::get('/login', function(){
    return view('login');
});
