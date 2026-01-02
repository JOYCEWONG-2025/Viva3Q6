/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva3q6;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author User
 */
public class Game {
    private String[] elements = {"Water", "Fire", "Earth", "Light", "Dark"};

    public void battle(Team team, Villain enemy) {
        team.resetTeamHp();
        enemy.resetHp();
        enemy.resetCd();

        Random rand = new Random();
        int round = 1;

        while (team.getHp() > 0 && enemy.getHp() > 0) {
            System.out.println("Round " + round++);
            System.out.println("Enemy's current CD: " + enemy.getCurrentCd());

            HashMap<String, Integer> runestones = new HashMap<>();
            for (int i = 0; i < 3; i++) {
                String rs = elements[rand.nextInt(elements.length)];
                runestones.put(rs, runestones.getOrDefault(rs, 0) + 1);
            }

            System.out.println("Runestones dissolved:");
            for (String rs : runestones.keySet()) {
                for (int i = 0; i < runestones.get(rs); i++) {
                    System.out.println(" - " + rs);
                }
            }

            boolean heroAttacked = false;

            for (Hero h : team.getHeroList()) {
                int count = runestones.getOrDefault(h.getElement(), 0);
                if (count > 0) {
                    double dmg = h.calculateDamage(enemy, count);
                    enemy.getDamaged(dmg);
                    heroAttacked = true;
                    System.out.println(h.getName() + " dealt " + dmg +
                            " damage to "+ enemy.getName());
                }
            }

            if (!heroAttacked) {
                System.out.println("No hero attacked in this round");
            }

            if (enemy.getCurrentCd() == 1 && enemy.getHp() > 0) {
                team.getDamaged(enemy.getAttack());
                System.out.println(enemy.getName()+"dealt " + enemy.getAttack() +
                        " damage to the team");
                enemy.resetCd();
            } else {
                enemy.decreaseCd();
            }

            System.out.println("\nTeam's remaining HP: " + team.getHp());
            System.out.println("Enemy's remaining HP: " + enemy.getHp());
            System.out.println();
        }

        if (enemy.getHp() <= 0)
            System.out.println("The team won!");
        else
            System.out.println("The team lose.");
    }
}


