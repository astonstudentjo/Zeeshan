<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Newsletter extends Model
{
    use HasFactory;
    public $timestamps = false;

    protected $table = 'newsletter';

    protected $key = 'id';

    protected $fillable = [
        'email'
    ];
}
