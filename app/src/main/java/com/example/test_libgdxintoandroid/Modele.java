package com.example.test_libgdxintoandroid;

import java.util.Random;

public class Modele {
    // Attributs propres à libGDX
    public static String resultatpartie = "Partie non déterminée";
    public static Integer compteurDechetCollecte = 0;
    public static Integer compteurTonneau = 0;
    public static Integer random = 0;
    public static Boolean testBoolean = false;
    public static Integer tempsPartie = 0;
    public static Integer jetonRejouer = 1;

    // Attributs propres au jeu du coffre au trésor et à l'inventaire (backpack)
    public static boolean canAddHat2On = true;
    public static boolean canAddTorso2On = true;
    public static boolean firstInventoryLook = true;
    public static boolean jeuCoffreTresorGagne = true;
}
