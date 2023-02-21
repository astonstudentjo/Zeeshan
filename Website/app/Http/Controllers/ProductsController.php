<?php

namespace App\Http\Controllers;

use App\Models\Products;
use Illuminate\Http\Request;

class ProductsController extends Controller
{
    public function show(){

        $products = Products::all();
        return view('products', ['products' => $products]);
    }

    public function showCategory($category){

        if($category == 'price_ascending'){
            $products = Products::all()
            ->sortBy('price');

        return view('products', ['products' => $products]);

        } elseif($category == 'price_descending'){

        } else {
        $products = Products::all()
            ->where('category', $category);
        

        return view('products', ['products' => $products]);
        }
       

    }




}
