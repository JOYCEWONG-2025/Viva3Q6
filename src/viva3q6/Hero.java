/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva3q6;

/**
 *
 * @author User
 */
public class Hero {
    private String name;
    private String element;
    private double hp;
    private double attack;

    public Hero(String name, String element, double hp, double attack) {
        this.name = name;
        this.element = element;
        this.hp = hp;
        this.attack = attack;
    }

    public String getElement() {
        return element;
    }
    
    public String getName(){
        return name;
    }

    public double getHp() {
        return hp;
    }

    public double getAttack() {
        return attack;
    }

    public double calculateDamage(Villain enemy, int rsMultiplier) {
        if (rsMultiplier == 0) return 0;

        double dominance = getDominanceMultiplier(enemy.getElement());
        double damage = attack * dominance * rsMultiplier - enemy.getDefense();

        if (damage < 1) damage = 1;
        return damage;
    }

    private double getDominanceMultiplier(String enemyElement) {
        if (element.equals("Water") && enemyElement.equals("Fire")) return 1.5;
        if (element.equals("Water") && enemyElement.equals("Earth")) return 0.5;

        if (element.equals("Fire") && enemyElement.equals("Earth")) return 1.5;
        if (element.equals("Fire") && enemyElement.equals("Water")) return 0.5;

        if (element.equals("Earth") && enemyElement.equals("Water")) return 1.5;
        if (element.equals("Earth") && enemyElement.equals("Fire")) return 0.5;

        if (element.equals("Light") && enemyElement.equals("Dark")) return 1.5;
        if (element.equals("Dark") && enemyElement.equals("Light")) return 1.5;

        return 1.0;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               "\nElement: " + element +
               "\nHP: " + hp +
               "\nAttack: " + attack + "\n";
    }
}


