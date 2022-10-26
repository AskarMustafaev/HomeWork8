package kg.geektech.game.players;

import kg.geektech.game.genaral.RPG_Game;

public class Magic extends Hero{
    private int boostDamage;
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coefficient = RPG_Game.random.nextInt(20)+1;
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() + coefficient);
        }
        System.out.println(this.getName()+": Mag damage: " + coefficient);



    }
}
