<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class RegistrationController extends Controller
{
    public function show(){
        return view('signup');
    }

    public function create(Request $request){

        $this->validate($request,[
            'name' => 'required|max:150',
            'email' => ['required' , 'max:150', 'unique:users,email,exists,0'],
            'password' => 'required|confirmed|min:8'
        ]);

        dd(123);
    }
}
