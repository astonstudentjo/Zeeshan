<?php

namespace App\Http\Controllers;

use App\Models\Products;
use Illuminate\Http\Request;

class ProductController extends Controller
{

    public function show($id){
        $concert = Products::findOrFail($id);
        return view('product', ['concert' => $concert]);
    }
    public function showRecomendations($concert)
    {
        $category = $concert->category;
        $id = $concert->id;
        $products = Products::all()
            ->where('category', $category)
            -> whereNotIn('id',$id);
        return $products;
    }
}