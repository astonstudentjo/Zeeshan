<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

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


        User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password)
        ]);


        auth()->attempt($request->only('email', 'password'));

        return redirect('products');
    }
}
