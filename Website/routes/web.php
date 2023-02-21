<?php

use App\Http\Controllers\BasketController;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\ProductController;
use App\Http\Controllers\ProductsController;
use App\Http\Controllers\RegistrationController;
use App\Http\Controllers\SignoutController;
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



Route::get('/aboutus', function(){
    return view('aboutus');
});

Route::get('/contactus', function(){
    return view('contactus');
});

Route::get('/products/{id}',[ProductController::class, 'show']);

Route::get('/products/category/{category}',[ProductsController::class, 'showCategory']);

Route::get('/products', [ProductsController::class, 'show']);

Route::get('/basket', [BasketController::class, 'show']);

Route::post('/basket', [BasketController::class, 'addBasket']);

Route::post('/basket/clear', [BasketController::class, 'clearBasket']);

Route::post('/basket/update', [BasketController::class, 'update']);

Route::post('/signout', [SignoutController::class, 'signout']);

Route::get('/login', [LoginController::class, 'show']);

Route::post('/login', [LoginController::class, 'login']);

Route::get('/signup', [RegistrationController::class, 'show']);

Route::post('/signup', [RegistrationController::class, 'create']);




