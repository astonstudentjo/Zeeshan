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
}
