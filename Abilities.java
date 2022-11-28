/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gloomhaven;

/**
 *
 * @author Ricky
 */
class Abilities {
    String abilityName; 
    int topActionAttack; 
    int topActionDefense; 
    int topActionSpeed; 
    boolean topIsRanged; 
    int topRange = 0; 

   
    int bottomActionAttack; 
    int bottomActionDefense; 
    int bottomActionSpeed;
    boolean bottomIsRanged;
    int bottomRange = 0; 
    
    int initiativeNum; 
    int cardLevel; 
    
    public void defineAbility(String name , int topAttack, int topDefense, int topSpeed, boolean topR, int tRange , int bottomAttack, int bottomDefense, int bottomSpeed, boolean bottomR, int bRange , int initiative , int cardLevel){
        this.abilityName = name; 
        
        this.topActionAttack = topAttack; 
        this.topActionDefense = topDefense; 
        this.topActionSpeed = topSpeed; 
        this.topIsRanged = topR;
        this.topRange = tRange;
        
        this.bottomActionAttack = bottomAttack; 
        this.bottomActionDefense = bottomDefense; 
        this.bottomActionSpeed = bottomSpeed; 
        this.bottomIsRanged = bottomR; 
        this.bottomRange = bRange; 
        
        this.initiativeNum = initiative; 
        this.cardLevel = cardLevel; 
    }
    
    
  public String getAbilityName(){
      return this.abilityName; 
  }
  public int getInitiative(){
      return this.initiativeNum; 
  }
  public int getCardLevel(){
      return this.cardLevel; 
  }
  //Top actions
  public int getTopAttack(){
      return this.topActionAttack; 
  }
    public int getTopDefense(){
      return this.topActionDefense; 
  }
      public int getTopSpeed(){
      return this.topActionSpeed; 
  }
  public boolean getTopIsRanged(){
      return this.topIsRanged; 
  }
  public int getTopRange(){
      return this.topRange; 
  }
  // Bottom Actions
    public int getBottomAttack(){
      return this.bottomActionAttack; 
  }
    public int getBottomDefense(){
      return this.bottomActionDefense; 
  }
      public int getBottomSpeed(){
      return this.bottomActionSpeed; 
  }  
      public boolean getBottomIsRanged(){
      return this.bottomIsRanged; 
  }
     public int getBottomRange(){
      return this.bottomRange; 
  }
     //Setters
  public void setAbilityName(String aName){
       this.abilityName = aName; 
  }
  public void setInitiative(int initiativeVal){
     this.initiativeNum = initiativeVal; 
  }
  public void setCardLevel(int levelNum){
     this.cardLevel = levelNum ; 
  }
  //Top actions
  public void setTopAttack(int attack){
     this.topActionAttack = attack; 
  }
  public void setTopDefense(int defense){
     this.topActionDefense = defense; 
  }
  public void setTopSpeed(int speed){
     this.topActionSpeed = speed; 
  }
  public void setTopIsRanged(boolean isRanged){
     this.topIsRanged = isRanged; 
  }
  public void setTopRange(int range){
     this.topRange = range; 
  }
  // Bottom Actions
  public void setBottomAttack(int attack){
     this.bottomActionAttack = attack; 
  }
  public void setBottomDefense(int defense){
     this.bottomActionDefense = defense; 
  }
  public void setBottomSpeed(int speed){
     this.bottomActionSpeed = speed; 
  }  
  public void setBottomIsRanged(boolean isRanged){
     this.bottomIsRanged  = isRanged; 
  }
  public void setBottomRange(int range){
     this.bottomRange = range; 
  }
}
