-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 17, 2023 at 12:32 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `websitedb19`
--

-- --------------------------------------------------------

--
-- Table structure for table `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `uuid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `connection` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1),
(3, '2019_08_19_000000_create_failed_jobs_table', 1),
(4, '2019_12_14_000001_create_personal_access_tokens_table', 1);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `total_price` decimal(8,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;





-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) unsigned NOT NULL,
  `product_id` bigint(20) unsigned NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;



-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `personal_access_tokens`
--

CREATE TABLE `personal_access_tokens` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tokenable_type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tokenable_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `abilities` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(45) DEFAULT 'Null',
  `description` varchar(1000) DEFAULT 'Null',
  `img` varchar(45) DEFAULT 'Null',
  `price` decimal(10,2) DEFAULT 0.00,
  `stock` int(11) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `img`, `price`, `stock`, `sales`, `category`, `artist`) VALUES
(1, 'Adriana Grande Live Performance!', 'Ariana Grande is set to take the stage on her tour with a mesmerizing collection of hit songs that will leave audiences spellbound. Her powerhouse vocals and dynamic range will shine on tracks like \"7 Rings\", the irresistible ode to self-empowerment and materialism. The crowd will be swaying and singing along to the catchy chorus of \"Thank U, Next\", a heartfelt expression of gratitude for past relationships. \"Into You\" will bring the heat with its sultry beats and seductive lyrics, while \"God is a Woman\" will be a fierce declaration of female strength and sexuality. Other tour highlights include the pop bop \"Side to Side\" featuring Nicki Minaj, and the soulful ballad \"Love Me Harder\". Get ready to experience the magic of Ariana Grande\'s music, live and in person!', 'Ariana-Grande-2.png', 20.00, 200, 5, 'pop', 'Ariana Grande'),
(2, 'Justin Bieber\'s Live Show!', 'Justin Bieber is a pop sensation known for his smooth vocals and catchy tunes. Some of his biggest hits include \"Baby\", \"Sorry\", \"Love Yourself\", and \"What Do You Mean?\". With a blend of R&B, pop, and hip-hop influences, Justin\'s music will get you dancing and singing along. He continues to captivate audiences worldwide with his electrifying live performances.', 'Justin-Bieber-2.png', 20.00, 200, 10, 'pop', 'Justin Bieber'),
(3, 'Dua Lipa on tour!', 'Dua Lipa is a British pop star known for her electrifying vocals and bold fashion sense. Her discography includes chart-topping hits like \"New Rules,\" \"Levitating,\" and \"Don\'t Start Now.\" These empowering anthems, infused with Dua\'s unique blend of pop, R&B, and dance music, are sure to have fans grooving in their seats during her electrifying performances. Whether she\'s singing about self-love and independence or belting out catchy pop hooks, Dua\'s energy and confidence shine through in every note.\r\n', 'Dua-Lipa-2.png', 50.00, 50, 4, 'pop', 'Dua Lipa'),
(4, 'Billie Eilish to the moon!', 'Billie Eilish is a Grammy-winning singer and songwriter known for her unique, haunting voice and introspective lyrics. She burst onto the music scene with her hit single \"Ocean Eyes\" and has since become one of the biggest names in pop music. Some of her top songs include \"Bad Guy,\" \"When The Party\'s Over,\" and \"Bury A Friend.\" Eilish\'s music is characterized by its ethereal, atmospheric soundscapes and introspective themes that explore the complexities of youth, mental health, and relationships. With her captivating stage presence and powerful performances, Eilish promises to deliver an unforgettable live experience to fans on her upcoming tour.', 'Billie-Eilish-1.png', 200.00, 200, 2, 'pop', 'Billie Eillish'),
(5, 'Ed\'s Finale ', 'Ed Sheeran is a pop sensation known for his smooth vocals and catchy tunes. Some of his biggest hits include \"Shape of You\", \"Perfect\", \"Thinking Out Loud\", and \"Photograph\". With a blend of R&B, pop, and hip-hop influences, Ed\'s music will get you dancing and singing along. He continues to captivate audiences worldwide with his electrifying live performances.', 'Ed-Sheeran-1.png', 20.00, 200, 10, 'pop', 'Ed Sheeran'),
(6, 'Metallica\'s Bang', 'Metallica is an American heavy metal band formed in 1981. With their hard-hitting and heavy sound, they have been one of the most influential bands in the genre, paving the way for countless other metal acts. Some of their most popular tracks include \"Enter Sandman,\" \"The Unforgiven,\" \"Master of Puppets,\" and \"Nothing Else Matters.\" When they perform live, they bring their iconic sound and high-energy stage presence, delivering a show that is sure to leave fans headbanging and screaming for more.', 'Metallica-1.png', 50.00, 123, 3, 'metal', 'Metallica'),
(7, 'To The Iron Side?', 'Iron Maiden is a legendary heavy metal band hailing from England, formed in 1975. With their unique blend of metal, punk, and classical music, they have become one of the most iconic bands in metal history. Their extensive discography includes some of the genre\'s most famous tracks, including \"Hallowed Be Thy Name,\" \"The Trooper,\" and \"Fear of the Dark.\" Iron Maiden is known for their high-energy live shows and iconic stage presence, featuring vocalist Bruce Dickinson\'s powerful voice and guitarist Dave Murray\'s virtuosic playing. If you\'re a fan of metal, Iron Maiden is a must-see live experience.', 'Iron-Maiden-2.png', 50.00, 213, 2, 'metal', 'Iron Maiden'),
(8, 'Sabbath Days', 'Black Sabbath, one of the pioneers of heavy metal, will surely unleash a thunderous performance of their iconic hits like \"Iron Man,\" \"Paranoid,\" and \"Black Sabbath.\" With their distinctive sound, Black Sabbath will have the crowd headbanging and singing along to classic metal anthems that have stood the test of time. Whether you\'re a longtime fan or a newcomer, a Black Sabbath concert is a must-see event for anyone who loves hard-hitting music with a powerful message.', 'Black-Sabbath-1.png', 10.00, 200, 2, 'metal', 'Black Sabbath'),
(9, 'Slayer\'s Be Slayin!', 'Slayer is an American thrash metal band that formed in 1981. With their aggressive, fast-paced sound and powerful lyrics, they have become one of the most influential and successful bands in the heavy metal genre. Some of their top tracks include \"Angel of Death,\" \"Raining Blood,\" and \"Seasons in the Abyss.\" The band\'s live shows are renowned for their high energy, and fans can expect to hear these classic tracks, along with others from their extensive catalog, when they perform on tour.', 'Slayer-2.png', 25.00, 200, 2, 'metal', 'Slayer'),
(10, 'Judas Contract!', 'Judas Priest is an English heavy metal band formed in Birmingham, England in 1969. They are considered one of the pioneers of the heavy metal genre and have inspired countless musicians and bands over the years. The band is well-known for their powerful vocals, driving guitar riffs, and dynamic song structures. Some of their top picks include \"Breaking the Law,\" \"Painkiller,\" and \"You\'ve Got Another Thing Comin\'.\" Expect a high-energy performance full of headbanging and screaming guitar solos when seeing Judas Priest live.', 'Judas-Priest-2.png', 50.00, 100, 20, 'metal', 'Judas Priest'),
(11, 'Stormzy On Tour', 'Stormzy, also known as Michael Ebenazer Kwadjo Omari Owuo Jr., is a British grime and hip-hop artist known for his socially conscious lyrics and electrifying live performances. His top tracks include \"Shut Up,\" \"Vossi Bop,\" and \"Own It,\" which showcase his signature smooth flow and thought-provoking lyrics. With his powerful stage presence and politically charged music, Stormzy has become one of the UK\'s leading voices in hip-hop, and continues to inspire and captivate audiences around the world.', 'Stormzy-1.png', 50.00, 400, 80, 'rap', 'Stormzy'),
(12, 'Skepta teppas tour!', 'Skepta is a British grime rapper and producer, known for his raw and energetic lyrics that often touch on themes of inner-city life, social and political issues, and his struggles and triumphs as a black man in the UK. Some of his top tracks include \"Shutdown,\" \"That\'s Not Me,\" \"Man,\" and \"Konnichiwa.\" Skepta\'s live shows are characterized by his high-energy performances, dynamic beats, and socially conscious lyrics, which have made him a beloved and influential figure in the grime and hip-hop communities. Whether he\'s performing in a packed stadium or an intimate club, Skepta always brings his A-game, delivering powerful, thought-provoking lyrics that resonate with audiences of all ages and backgrounds.', 'Skepa-1.png', 40.00, 200, 2, 'rap', 'Skepta'),
(13, 'J Hustle ', 'J Hus is a British rapper and singer known for his distinctive blend of Afrobeat, grime, and hip-hop. He rose to prominence with the release of his hit single \"Dem Boy Paigon\" in 2015, which quickly went viral and established him as one of the UK\'s hottest new talents. He has since released several critically acclaimed albums, including \"Common Sense\" in 2017 and \"Big Conspiracy\" in 2020, both of which showcased his unique style and sharp, socially conscious lyrics. J Hus\'s live performances are known for their high energy and engaging stage presence, making him one of the most sought-after acts on the UK music scene. Some of his top tracks include \"Did You See,\" \"Playing Sports,\" and \"Bouff Daddy.\"', 'J-Hus-2.png', 25.00, 20, 200, 'rap', 'J Hus'),
(14, 'DBE SHARDS', 'Young Adz and DBE are a UK grime duo known for their energetic, dynamic, and lyrically intricate tracks. With their unique blend of UK rap and grime, they have established themselves as one of the hottest rising talents in the UK music scene. Their top picks include tracks like \"Demons & Angels,\" \"No Love,\" and \"I Dunno.\" With their powerful, thought-provoking lyrics and catchy beats, Young Adz and DBE are sure to deliver a high-energy, unforgettable performance at any live show.\r\n', 'DBE-1.png', 100.00, 200, 40, 'rap', 'DBE'),
(15, 'Lil Durk', 'Lil Durk is a popular American rapper hailing from Chicago, Illinois. He is known for his smooth flow and intense, introspective lyrics that often touch upon themes of street life, crime, and struggle. Some of his most popular songs include \"Like Me,\" \"My Beyoncé,\" and \"Signed to the Streets 2.\" He has collaborated with some of the biggest names in rap, including Lil Baby, Lil Wayne, and Future, and his music has been praised for its honesty, raw energy, and storytelling prowess. With his captivating voice and thought-provoking lyrics, Lil Durk is a force to be reckoned with in the world of hip-hop.', 'Lil-Durk-1.png', 40.00, 400, 20, 'rap', 'Lil Durk'),
(16, 'The Beatles On Tour!', 'The Beatles are one of the most iconic and influential bands in the history of popular music. Formed in Liverpool, England in the early 1960s, The Beatles consists of John Lennon, Paul McCartney, George Harrison, and Ringo Starr. Their innovative music and iconic image helped usher in the \"British Invasion\" of the United States, and they remain one of the best-selling and most-loved bands of all time. Some of their most popular songs include \"Hey Jude,\" \"Let It Be,\" \"Yesterday,\" and \"A Hard Day\'s Night.\" The Beatles\' music continues to be a staple of popular culture, and their influence on the world of music can be seen in countless artists who have followed in their wake.', 'Beatles-1.png', 100.00, 200, 20, 'rock', 'The Beatles'),
(17, 'Led Zeppelin Performance', 'Led Zeppelin is an English rock band formed in 1968 and is widely considered one of the most influential bands in the history of rock music. The band\'s unique blend of blues, folk, and Eastern music combined with powerful guitar riffs, creative drumming, and soaring vocals make their music instantly recognizable. Some of Led Zeppelin\'s most popular songs include \"Stairway to Heaven,\" \"Kashmir,\" \"Whole Lotta Love,\" and \"Black Dog.\" Their music continues to be a staple of rock radio and live performance, inspiring countless musicians and fans alike with its raw energy and innovative spirit.', 'Led-Zepplin-2.png', 100.00, 20, 2, 'rock', 'Led Zepplin'),
(18, 'Pink Floyd tourin', 'Pink Floyd is a legendary British rock band, widely regarded as one of the greatest and most influential bands of all time. With a distinct psychedelic sound and thought-provoking lyrics, Pink Floyd redefined the boundaries of rock music and created a genre of their own. Some of their top tracks include \"Wish You Were Here,\" \"Another Brick in the Wall,\" \"Comfortably Numb,\" \"Money,\" and \"Time.\" The band\'s legendary live shows were a mesmerizing blend of music, light, and visuals, creating a unique experience for their fans. Pink Floyd\'s impact on rock music is immeasurable, and their music continues to be celebrated by fans of all ages around the world.', 'Pink-Floyd-2.png', 10.00, 20, 40, 'rock', 'Pink Floyd'),
(19, 'The Rolling Stones Live Show!', 'The Rolling Stones are a legendary British rock band formed in London in 1962. Over the years, they have become one of the most influential and enduring rock bands of all time. Their music is characterized by blues-inspired rock and roll, and their live shows are known for their high energy and raw power. Some of their most famous songs include \"Satisfaction,\" \"Jumpin\' Jack Flash,\" \"Gimme Shelter,\" \"Brown Sugar,\" and \"Start Me Up.\" With a career that spans over five decades, the Rolling Stones continue to tour and perform, thrilling audiences all over the world with their iconic sound.', 'The-Rolling-Stones-1.png', 5.00, 100, 40, 'rock', 'The Rolling Stones'),
(20, 'Queen\'s Live Show', 'Queen is a legendary British rock band formed in London in 1970. The band consists of lead vocalist Freddie Mercury, guitarist Brian May, drummer Roger Taylor, and bassist John Deacon. Queen\'s music is known for its eclectic mix of hard rock, heavy metal, and progressive rock, and the band\'s live performances are renowned for their high energy and theatricality. Some of their most famous songs include \"Bohemian Rhapsody,\" \"We Will Rock You,\" \"We Are the Champions,\" \"Somebody to Love,\" \"Don\'t Stop Me Now,\" and \"Another One Bites the Dust.\" Queen\'s influence on the music industry continues to be felt today, and their music continues to be popular with fans of all ages.', 'Queen-2.png', 100.00, 200, 2, 'rock', 'Queen'),
(21, 'Cash Live Now!', 'Johnny Cash, also known as the \"Man in Black,\" was an American singer-songwriter and actor. He is widely considered as one of the most influential musicians of the 20th century, and is remembered for his deep, distinctive voice and his pioneering role in the development of modern country music. Some of his top songs include \"I Walk the Line,\" \"Ring of Fire,\" and \"Folsom Prison Blues.\" His music continues to be widely loved and his influence on various genres, from rock and pop to hip-hop and folk, can still be felt today.', 'Johnny-Cash-1.png', 50.00, 200, 20, 'country', 'Johnny Cash'),
(22, 'Dolly Parton\'s Show!', 'Dolly Parton is an American singer, songwriter, and actress known for her country music and her contributions to the entertainment industry. She has been active in the music industry since the 1960s and has released numerous albums throughout her career. Some of Dolly\'s top picks include \"Jolene\", \"I Will Always Love You\", and \"Coat of Many Colors\". She is known for her powerful voice, her ability to bring emotions to life through her music, and her cheerful personality. Her music is a mix of country, pop, and bluegrass, and she has been a major influence on many musicians throughout the years.', 'Dolly-Parton-1.png', 200.00, 20, 10, 'country', 'Dolly Parton'),
(23, 'Garth Brooks Performance Live', 'Garth Brooks is an American country singer, songwriter and performer known for his signature blend of traditional country, rock and roll and pop music. With a career spanning over 30 years, he is one of the best-selling music artists of all time, with more than 170 million records sold worldwide. Some of his most popular hits include \"The Dance,\" \"Friends in Low Places,\" \"Standing Outside the Fire\" and \"If Tomorrow Never Comes.\" Brooks is recognized for his emotional performances, relatable lyrics, and his energetic stage presence, making him a must-see live performer.', 'Garth-Brooks-1.png', 200.00, 200, 40, 'country', 'Garth Brooks'),
(24, 'Willie Nelson On Tour!', 'Willie Nelson is a legendary country singer-songwriter known for his distinct voice and contributions to the outlaw country movement. He has released over 200 albums, including the iconic \"Red Headed Stranger\" and \"Stardust.\" Nelson has written numerous hit songs, including \"Crazy,\" \"Always On My Mind,\" and \"On The Road Again.\" He is also known for his activism and support of organizations such as Farm Aid.', 'Willie-Nelson-2.png', 20.00, 200, 20, 'country', 'Willie Nelson'),
(25, 'George Strait  Live Performance!', 'George Strait is an American country music singer, songwriter, and actor known for his traditional country sound and iconic western wear. He has been active in the industry since the 1970s and has recorded over 60 albums, including classic hits like \"Amarillo by Morning\" and \"All My Ex\'s Live in Texas.\" Strait is considered a living legend in the world of country music and has been referred to as the \"King of Country.\" He is one of the best-selling music artists of all time, with over 100 million records sold worldwide. Despite his immense success, Strait remains true to his roots and continues to perform and record country music that speaks to the heart of his fans.', 'George-Strait-2.png', 10.00, 200, 20, 'country', 'George Strait');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `email_verified_at`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'Muniib Ali', '200103424@aston.ac.uk', NULL, '$2y$10$hw0g6WofWIuFP6hESZK/KOY9ZLmG39ih3G.MLNlHcXIfY/zyOKmKe', NULL, '2023-02-09 16:06:03', '2023-02-09 16:06:03'),
(2, 'testaccount', 'testaccount@gmail.com', NULL, '$2y$10$OMwa82kvxRB92IicWtRU6.srbZJwiXK8NAK6mehqW/m5TkMxIQx3G', NULL, '2023-02-09 16:09:15', '2023-02-09 16:09:15'),
(3, 'John Doe', 'johndoe@gmail.com', NULL, '$2y$10$ZpkLHCygJ6lqs2LLCx0.o.CSj31TraCvkXLPxTs0ZYIyx1nijX1fe', NULL, '2023-02-11 12:48:06', '2023-02-11 12:48:06'),
(4, 'testaccount', 'alimuniib@gmail.com', NULL, '$2y$10$8tItx5WDh/p5amJXHnJm7Oxd1Iif2fwVAtpdg5XsaIWnSrVcxJoZ2', NULL, '2023-02-11 12:52:57', '2023-02-11 12:52:57');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  ADD KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
