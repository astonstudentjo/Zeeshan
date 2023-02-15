<?php

namespace App\Http\Controllers;

use App\Models\Products;
use Illuminate\Http\Request;

class ProductsController extends Controller
{
    public function Show(){

        $products = Products::all();
        return view('products', ['products' => $products]);
    }




}
