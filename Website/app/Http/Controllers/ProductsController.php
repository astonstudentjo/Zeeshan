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
            $products = Products::all()
                ->sortByDesc('price');
            return view('products', ['products' => $products]);


        } else {
        $products = Products::all()
            ->where('category', $category);
        

        return view('products', ['products' => $products]);
        }
       

    }



    // search function1111

    public function search($searchQuery){
        $searchQuery = $_GET['search'];
        $products = Products::query()
            ->where('name', 'LIKE', "%{$searchQuery}%")
            ->orWhere('category', 'LIKE', "%{$searchQuery}%")
            ->orWhere('artist', 'LIKE', "%{$searchQuery}%")
            ->get();
        return view('products', ['products' => $products]);
    }
    
    
    
    




}
