<?php

use App\Http\Controllers\BasketController;
use App\Http\Controllers\CheckoutController;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\ProductController;
use App\Http\Controllers\ProductsController;
use App\Http\Controllers\RegistrationController;
use App\Http\Controllers\SignoutController;
use App\Http\Controllers\ConfirmationController;
use App\Http\Controllers\NewsletterController;
use App\Http\Controllers\OrdersController;
use Illuminate\Support\Facades\Redirect;
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

// typical routes everyone has access too.

Route::get('/', function () {
    return view('home');
});

Route::get('/aboutus', function () {
    return view('aboutus');
});

Route::get('/contactus', function () {
    return view('contactus');
});



Route::get('/products/{id}', [ProductController::class, 'show'])->name('product.show');
Route::get('/products/category/{category}', [ProductsController::class, 'showCategory'])->name('product.category');
Route::get('/products', [ProductsController::class, 'show'])->name('products');


Route::get('/products/search/{searchQuery}', [ProductsController::class, 'search'])->name('products.search');



Route::post('/newsletter', [NewsletterController::class, 'create']);

Route::get('/basket', [BasketController::class, 'show'])->name('basket.show');

Route::post('/basket', [BasketController::class, 'addBasket'])->name('basket.add');

Route::post('/basket/clear', [BasketController::class, 'clearBasket'])->name('basket.clear');

Route::post('/basket/update', [BasketController::class, 'update'])->name('basket.update');

Route::post('/basket/remove', [BasketController::class, 'remove'])->name('basket.remove');





//Routes that's only guests should be able to access
Route::middleware(['GuestAuthentication'])->group(function () {

    Route::get('/login', [LoginController::class, 'show']);
    // Route::name('login')->post('/login', [LoginController::class, 'login']);


    // Route::post('/login', [LoginController::class, 'login']);

    // Route::post('/login', [LoginController::class, 'login']);
    Route::post('/login', [LoginController::class, 'login'])->name('login');






    Route::get('/signup', [RegistrationController::class, 'show']);

    Route::post('/signup', [RegistrationController::class, 'create'])->name('signup');
});

//Routes that only signed in customers should be able to access
Route::middleware(['CustomerAuthentication'])->group(function () {
    Route::get('/signout', [SignoutController::class, 'signout']);
});

Route::prefix('checkout')->group(function () {
    Route::get('/', [CheckoutController::class, 'show'])->name('checkout.show');
    Route::post('/', [CheckoutController::class, 'placeOrder'])->name('checkout.placeOrder');
});

Route::middleware(['CustomerAuthentication'])->group(function () {

    Route::post('/signout', [SignoutController::class, 'signout']);

    Route::get('/confirmation/{order}', [ConfirmationController::class, 'show'])->name('confirmation');

    Route::get('/orders', [OrdersController::class, 'show'])->name('orders.show');
});
