package kg.geektech.game.genaral;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();
    public static void start(){
        Boss boss = new Boss(1000, 50, "Kronos");
        Warrior warrior = new Warrior(290, 10, "Avrora");
        Medic doc = new Medic(250, 5, 15,"Darius");
        Magic magic = new Magic(280, 20, "Veil");
        Medic junior = new Medic(260, 5, 5, "Valir");
        Berserk berserk = new Berserk(270, 15, "Mia");
        Hero[] heroes = {warrior, doc, magic, junior, berserk};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)){
            playRound(boss, heroes);
        }

    }
    private static void playRound(Boss boss, Hero[] heroes){
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getDefence() != heroes[i].getAbility()){
            heroes[i].attack(boss);
            heroes[i].applySuperPower(boss, heroes);
        }
        }
        printStatistics(boss, heroes);
    }
    private static boolean isGameFinished(Boss boss, Hero[] heroes){
        if (boss.getHealth() <= 0){
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead){
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println("ROUND " + roundNumber + " --------------- ");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);

        }
    }
}
