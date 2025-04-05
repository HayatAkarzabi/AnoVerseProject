package main;

import Dao.*;
import Metier.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        IUser dao = new ImplUser();
        ImplFilm film =  new ImplFilm();


        dao.AddUser(new User("nouhayousse@gmail.com","jjk7","admin"));
        dao.AddUser(new User("hayat@gmail.com","1234"));
        dao.AddUser(new User("imane@gmail.com","12345"));
        dao.AddUser(new User("layla@gmail.com","12346"));
        dao.AddUser(new User("wissal@gmail.com","12347"));



        // Remplir la table film par les animes
        Film film1=new Film(
                "Solo Leveling",
                "Action",
                2024,
                "Shunsuke Nakashige",
                "Taito Ban, Reina Ueda, Hiroki Touchi",
                "Noboru Kimura (Scénariste de l'anime), Chugong (Auteur du web novel)",
                "Dans un monde où des portails vers des donjons apparaissent, des chasseurs combattent des monstres pour protéger l'humanité. Sung Jin-Woo, un chasseur de rang E, découvre un pouvoir mystérieux qui lui permet de devenir le plus puissant de tous.",
                "Images/desc_img/sololeveling_desc.jpg","Images/home_img/sololeveling_home.png"
        );

        film.AddFilm(film1);

        Film film2=new Film(
                "Perfect Blue",
                "Child",
                1997,
                "Satoshi Kon",
                "Junko Iwao, Rica Matsumoto, Tomokazu Seki",
                "Sadayuki Murai (Scénariste), Yoshikazu Okada (Adaptation du manga)",
                "Mima Kirigoe, une idol pop, décide de quitter son groupe pour se lancer dans une carrière d'actrice. Cependant, elle commence à perdre sa propre identité lorsqu'elle est confrontée à un fan obsessionnel et à une série d'événements perturbants qui brouillent la ligne entre la réalité et l'illusion.",
                "Images/desc_img/perfect_blue_desc.jpg","Images/home_img/perfect_blue_home.jpg"
        );
        film.AddFilm(film2);

        Film film3=new Film(
                "Naruto Shippuden",
                "Action",
                2007,
                "Hayato Date",
                "Junko Takeuchi, Noriaki Sugiyama, Chie Nakamura",
                "Masashi Kishimoto (Manga), Yasunori Ebina (Musique)",
                "Après deux ans d'entraînement, Naruto Uzumaki revient dans son village et se lance dans une quête pour retrouver ses amis, tout en affrontant des ennemis puissants comme l'Akatsuki, qui menace la paix du monde ninja.",
                "Images/desc_img/naruto_desc.jpg","Images/home_img/Naruto_home.jpg"
        );
        film.AddFilm(film3);

        Film film4=new Film(
                "Bleach",
                "Action",
                2004,
                "Noriyuki Abe",
                "Masakazu Morita, Fumiko Orikasa, Hiroki Yasumoto",
                "Tite Kubo (Manga), Noriyuki Abe (Réalisateur)",
                "Ichigo Kurosaki, un adolescent ayant la capacité de voir les fantômes, devient un Soul Reaper et lutte contre les Hollows qui menacent le monde des vivants et des âmes. Il protège ses amis et affronte des ennemis de plus en plus puissants dans un monde surnaturel.",
                "Images/desc_img/bleach_desc.jpg","Images/home_img/bleach_home.jpg"
        );

        film.AddFilm(film4);

        Film film5=new Film(
                "Suzume",
                "Family",
                2022,
                "Makoto Shinkai",
                "Nanoka Hara, Hokuto Matsumura, Eri Fukatsu",
                "Makoto Shinkai (Scénariste et Réalisateur), Takumi Tanji (Adaptation)",
                "Suzume, une jeune fille, se lance dans une aventure pour fermer des portes mystérieuses qui apparaissent à travers le Japon, des portes qui menacent de libérer des catastrophes. L'histoire mêle drame et fantasy avec un message sur le deuil et la résilience.",
                "Images/desc_img/suzume_desc.jpg","Images/home_img/suzume_home.png"
        );

        film.AddFilm(film5);


        Film film6=new Film(
                "Blue Lock",
                "Child",
                2022,
                "Tetsuaki Watanabe",
                "Kazuki Ura, Yoichi Isagi, Takuya Yamaguchi",
                "Muneyuki Kaneshiro (Scénariste), Yusuke Nomura (Adaptation du manga)",
                "Après la défaite du Japon en Coupe du Monde, l'équipe nationale se lance dans un programme d'entraînement extrême appelé Blue Lock, dans lequel des jeunes attaquants sont confrontés à des défis intenses pour devenir le meilleur buteur du pays. Yoichi Isagi rêve de se prouver.",
                "Images/desc_img/BlueLock_desc.jpg","Images/home_img/BlueLock_home.jpg"
        );
        film.AddFilm(film6);


        Film film7=new Film(
                "Dr. Stone",
                "action",
                2019,
                "Shinya Iino",
                "Yusuke Kobayashi, Makoto Furukawa, Kana Ichinose",
                "Riichiro Inagaki (Scénariste), Boichi (Manga)",
                "Des siècles après un mystérieux événement qui pétrifie toute l'humanité, Senku Ishigami, un génie scientifique, tente de reconstruire la civilisation à partir de zéro, utilisant ses connaissances pour redécouvrir la science perdue.",
                "Images/desc_img/Dr_stone_desc.jpg","Images/home_img/dr_stone.jpg"
        );
        film.AddFilm(film7);


        Film film8=new Film(
                "Dandadan",
                "Child",
                2024,
                "Fuga Yamashiro",
                "Shion Wakayama, Natsuki Hanae, Mayumi Tanaka",
                "Yukinobu Tatsu",
                "Momo Ayase, une lycéenne croyant aux fantômes mais pas aux extraterrestres, fait équipe avec Okarun, un camarade passionné d'aliens mais sceptique vis-à-vis du surnaturel. Ensemble, ils découvrent un monde mêlant esprits et créatures d’un autre monde, et se retrouvent entraînés dans une série de batailles surnaturelles épiques.",
                "Images/desc_img/dandadan_desc.png","Images/home_img/dandadan_home.png"
        );
        film.AddFilm(film8);




        Film film9=new Film(
                "One Piece",
                "Child",
                1999,
                "Konosuke Uda",
                "Mayumi Tanaka, Kazuya Nakai, Akemi Okamura",
                "Eiichiro Oda",
                "Monkey D. Luffy, un jeune garçon au corps élastique, part à la recherche du légendaire trésor One Piece pour devenir le roi des pirates. Il forme un équipage unique et affronte de nombreux ennemis dans un monde vaste rempli d’îles et de mystères.",
                "Images/desc_img/one_piece_desc.jpg","Images/home_img/one_piece_home.jpg"
        );

        Film film10=new Film(
                "Demon Slayer",
                "Family",
                2019,
                "Haruo Sotozaki",
                "Natsuki Hanae, Akari Kitou, Hiro Shimono",
                "Koyoharu Gotouge",
                "Tanjiro Kamado rejoint les pourfendeurs de démons après que sa famille ait été massacrée par des démons et que sa sœur Nezuko ait été transformée. Il entreprend un voyage pour venger sa famille et sauver sa sœur.",
                "Images/desc_img/demon_slayer_desc.png","Images/home_img/demonSlayer.jpg"
        );

        Film film11=new Film(
                "Howl's Moving Castle",
                "Family",
                2004,
                "Hayao Miyazaki",
                "Chieko Baisho, Takuya Kimura, Akihiro Miwa",
                "Diana Wynne Jones (roman), Hayao Miyazaki (scénario)",
                "Sophie, une jeune femme transformée en vieille dame par une sorcière, rencontre le mystérieux magicien Howl et découvre un château magique en mouvement. Ensemble, ils luttent contre les forces obscures dans un monde en guerre.",
                "Images/desc_img/howl_desc.jpg","Images/home_img/howl_home.jpg"
        );


        Film film12=new Film(
                "Death Note",
                "Family",
                2006,
                "Tetsurō Araki",
                "Mamoru Miyano, Kappei Yamaguchi, Aya Hirano",
                "Tsugumi Ohba",
                "Light Yagami découvre un carnet surnaturel capable de tuer quiconque dont le nom est inscrit dedans. Il décide de purifier le monde du mal, mais un détective prodige nommé L s'oppose à lui dans une bataille d’intelligence.",
                "Images/desc_img/death_note_desc.jpg","Images/home_img/death_note_home.jpg"
        );

        film.AddFilm(film9);
        film.AddFilm(film10);
        film.AddFilm(film11);
        film.AddFilm(film12);


        System.out.println("✅ Données insérées avec succès !");

        /*ImplISalle salleDao = new ImplISalle();
        Salle salle1 = new Salle("1",45);
        salleDao.ajouterSalle(salle1);

        ImplIPlace placedao = new ImplIPlace();
        Place place1 =new Place(false,1,salle1);
        ImplISeance seanceDao = new ImplISeance();
        Seance seance1=new Seance(LocalDateTime.now(),film1,salle1,"vers1");
        seanceDao.ajouterSeance(seance1);


        System.out.println("✅ Données salle, place et séance insérées avec succès !");

*/







    }
}
