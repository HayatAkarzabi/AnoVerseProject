package main;

import Dao.*;
import Metier.Film;
import Metier.Reservation;
import Metier.User;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        IUser dao = new ImplUser();
        ImplFilm film =  new ImplFilm();


        dao.AddUser(new User("nouhayousse@gmail.com","jjk7","admin"));
        dao.AddUser(new User("hayat@gmail.com","1234"));
        dao.AddUser(new User("imane@gmail.com","12345"));
        dao.AddUser(new User("layla@gmail.com","12346"));
        dao.AddUser(new User("wissal@gmail.com","12347"));



        // Remplir la table film par les animes

        film.AddFilm(new Film(
                "Solo Leveling",
                "Action, Fantasy",
                2024,
                "Shunsuke Nakashige",
                "Taito Ban, Reina Ueda, Hiroki Touchi",
                "Noboru Kimura (Scénariste de l'anime), Chugong (Auteur du web novel)",
                "Dans un monde où des portails vers des donjons apparaissent, des chasseurs combattent des monstres pour protéger l'humanité. Sung Jin-Woo, un chasseur de rang E, découvre un pouvoir mystérieux qui lui permet de devenir le plus puissant de tous.",
                "Images/desc_img/sololeveling_desc.jpg"
        ));

        film.AddFilm(new Film(
                "Perfect Blue",
                "Psychological thriller, Horror, Drama",
                1997,
                "Satoshi Kon",
                "Junko Iwao, Rica Matsumoto, Tomokazu Seki",
                "Sadayuki Murai (Scénariste), Yoshikazu Okada (Adaptation du manga)",
                "Mima Kirigoe, une idol pop, décide de quitter son groupe pour se lancer dans une carrière d'actrice. Cependant, elle commence à perdre sa propre identité lorsqu'elle est confrontée à un fan obsessionnel et à une série d'événements perturbants qui brouillent la ligne entre la réalité et l'illusion.",
                "Images/desc_img/perfect_blue_desc.jpg"
        ));

        film.AddFilm(new Film(
                "Naruto Shippuden",
                "Action, Adventure, Ninja, Shounen",
                2007,
                "Hayato Date",
                "Junko Takeuchi, Noriaki Sugiyama, Chie Nakamura",
                "Masashi Kishimoto (Manga), Yasunori Ebina (Musique)",
                "Après deux ans d'entraînement, Naruto Uzumaki revient dans son village et se lance dans une quête pour retrouver ses amis, tout en affrontant des ennemis puissants comme l'Akatsuki, qui menace la paix du monde ninja.",
                "Images/desc_img/naruto_desc.jpg"
        ));

        film.AddFilm(new Film(
                "Bleach",
                "Action, Supernatural, Adventure, Shounen",
                2004,
                "Noriyuki Abe",
                "Masakazu Morita, Fumiko Orikasa, Hiroki Yasumoto",
                "Tite Kubo (Manga), Noriyuki Abe (Réalisateur)",
                "Ichigo Kurosaki, un adolescent ayant la capacité de voir les fantômes, devient un Soul Reaper et lutte contre les Hollows qui menacent le monde des vivants et des âmes. Il protège ses amis et affronte des ennemis de plus en plus puissants dans un monde surnaturel.",
                "Images/desc_img/bleach_desc.jpg"
        ));

        film.AddFilm(new Film(
                "Suzume",
                "Adventure, Drama, Fantasy",
                2022,
                "Makoto Shinkai",
                "Nanoka Hara, Hokuto Matsumura, Eri Fukatsu",
                "Makoto Shinkai (Scénariste et Réalisateur), Takumi Tanji (Adaptation)",
                "Suzume, une jeune fille, se lance dans une aventure pour fermer des portes mystérieuses qui apparaissent à travers le Japon, des portes qui menacent de libérer des catastrophes. L'histoire mêle drame et fantasy avec un message sur le deuil et la résilience.",
                "Images/desc_img/suzume_desc.jpg"
        ));

        film.AddFilm(new Film(
                "Blue Lock",
                "Sports, Action, Shounen",
                2022,
                "Tetsuaki Watanabe",
                "Kazuki Ura, Yoichi Isagi, Takuya Yamaguchi",
                "Muneyuki Kaneshiro (Scénariste), Yusuke Nomura (Adaptation du manga)",
                "Après la défaite du Japon en Coupe du Monde, l'équipe nationale se lance dans un programme d'entraînement extrême appelé Blue Lock, dans lequel des jeunes attaquants sont confrontés à des défis intenses pour devenir le meilleur buteur du pays. Yoichi Isagi rêve de se prouver.",
                "Images/desc_img/BlueLock_desc.jpg"
        ));

        film.AddFilm(new Film(
                "Dr. Stone",
                "Sci-Fi, Adventure, Shounen",
                2019,
                "Shinya Iino",
                "Yusuke Kobayashi, Makoto Furukawa, Kana Ichinose",
                "Riichiro Inagaki (Scénariste), Boichi (Manga)",
                "Des siècles après un mystérieux événement qui pétrifie toute l'humanité, Senku Ishigami, un génie scientifique, tente de reconstruire la civilisation à partir de zéro, utilisant ses connaissances pour redécouvrir la science perdue.",
                "Images/desc_img/Dr_stone_desc.jpg"
        ));
    }
}
