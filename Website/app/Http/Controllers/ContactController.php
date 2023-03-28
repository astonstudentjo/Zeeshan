<?php

namespace App\Http\Controllers;

use App\Models\Contact;
use Illuminate\Http\Request;

class ContactController extends Controller
{
    
    public function create(Request $request){

        $this->validate($request,[
            'contactName' => ['required' , 'max:100'],
            'contactEmail' => ['required', 'max:100'],
            'contactSubject' => ['required', 'max: 100'],
            'contactMessage' => ['required', 'max: 250']          
        ], [
            'contactName.max' => 'You exceeded the word limit for name',
            'contactEmail.size' => 'You exceeded the word limit for email',
            'contactSubject.size' => 'You exceeded the word limit for subject',
            'contactMessage.size' => 'You exceeded the word limit for message'
        ]);

        Contact::create([
            'name' => $request->contactName,
            'email' => $request->contactEmail,
            'subject' => $request->contactSubject,
            'message' => $request->contactMessage


        ]);

        
        return redirect()->back()->with('success', 'Your query has been received!');
        

    }
}
