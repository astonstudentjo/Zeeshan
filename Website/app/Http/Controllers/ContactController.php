<?php

namespace App\Http\Controllers;

use App\Models\Contact;
use Illuminate\Http\Request;

class ContactController extends Controller
{
    
    public function create(Request $request){

        $this->validate($request,[
            'name' => ['required' , 'max:100', 'unique:newsletter,email,exists,0'],
            'email' => ['required', 'max:100'],
            'subject' => ['required', 'max: 100'],
            'message' => ['required', 'max: 250']          
        ]);

        Contact::create([
            'name' => $request->name,
            'email' => $request->email,
            'subject' => $request->subject,
            'message' => $request->message


        ]);

        
        return redirect()->back()->with('success', 'Your query has been received!');
        

    }
}
