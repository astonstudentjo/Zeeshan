<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class LoginController extends Controller
{
    public function login(Request $request){
        $this->validate($request,[
            'email' => ['required', 'email'],
            'password' => 'required'
        ]);

        if(!auth()->attempt($request->only('email', 'password'))){
            return back()-> with('status', 'Your login details are invalid');
        }

        return redirect('products');

    }

    public function show(){
        return view('login');
    }
}
