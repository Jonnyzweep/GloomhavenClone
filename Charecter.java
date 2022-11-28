/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gloomhaven;

/**
 *
 * @author Ricky
 */
public class Charecter {
    String name; 
    int health; 
    int attack; 
    int speed; 
    int gold = 0; 
    int currentExp = 0; 
    int maxExp = 45; 
    int perkProgress = 0; 
   Abilities[] abilityCards = new Abilities[3];
 
   public Charecter(String name , int chosenClass){
       if (chosenClass == 1){
           this.health = 25; 
           this.attack = 2;
           this.speed = 1; 
           abilityCards[0].defineAbility("Sheild Bash", 1, 3 ,0 ,false, 0 ,2 ,1, 2,false, 0 ,60, 1);
           abilityCards[1].defineAbility("Slash", 4,2,0, false,0 ,3,1,1, false ,0,50,1);
           abilityCards[2].defineAbility("Forceful Swing", 7,0,0, false,0 ,5,1,0,false,0,80,1);
       } 
       if(chosenClass == 2){
           this.health = 20; 
           this.attack = 2; 
           this.speed = 2; 
          // abilityCards[0].defineAbility("Frostbolt");
           //abilityCards[1].defineAbility("Slash", 4,2,0,3,1,1,50,1);
          // abilityCards[2].defineAbility("Forceful Swing", 7,0,0,5,1,0,80,1);
           
       }
       if(chosenClass == 3){
           this.health = 15; 
           this.attack = 3; 
           this.speed = 3; 
           //abilityCards[0].defineAbility("Sheild Bash", 1, 3 ,0 ,2 ,1, 2, 60, 1);
          // abilityCards[1].defineAbility("Slash", 4,2,0,3,1,1,50,1);
           //abilityCards[2].defineAbility("Forceful Swing", 7,0,0,5,1,0,80,1);
       }
   }
}
