Add notes here to see things we have done and things we need to do.

How to setup the site so it works locally.

Download the composer
Download xxamp if you don't have it already
clone the repository in htdocs
Make a seperate laraval project using Composer create-project laravel/laravel test
copy the vendor folder from the laravel project to the /website repository
copy the .env file from the laravel project to the /website repository
edit the .env file in the repository and make line 14 look like this:
DB_DATABASE=websitedb19

Once that is done open xxamp and start the apache and mysql servers
open git bash and navigate to the /website folder
run the command php artisan migrate
run the command php artisan serve
Copy the url presented
Paste the url into your browser and you should see the site.
