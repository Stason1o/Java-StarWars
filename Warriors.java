/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

public class Warriors extends StarWars{
    float accurancy; //от 0 - 1 
    Warriors(){
        super();
        accurancy = 0f;
    }
    
    Warriors(int _health, int _attack, String _weapon, float _accurancy){
        super(_health, _attack, _weapon);
        accurancy = _accurancy;
    }
    
    Warriors(Warriors object){
        super(object);
        accurancy = object.accurancy;
    }
    
    public float getAccurancy() { return accurancy; }
    public void setAccurancy(float _accurancy){
        if(_accurancy >= 0f && _accurancy <= 1f)
            accurancy = _accurancy;
    }
    
    @Override
    public void criticalDamage(StarWars object){ 
//        int k;
//        k = (int)(Math.random()*20);
//        int rez;
//        if(k < 6){
//            if(this.accurancy >= 0.5f){
//                rez = object.health - this.attackDamage*3;
//                object.setHealth(rez);
//            }
//            rez = object.health - this.attackDamage*2;
//            object.setHealth(rez);
//            //System.out.println(rez);
//        }
    }
    @Override
    public boolean dodge(){
        int k;
        k = (int)(Math.random()*13);
        if(k > 3 && k < 6)
            return true;
        return false;
    }
    
    @Override
    public void fatalDamage(StarWars object){
//        int k;
//        k = (int)(Math.random()*300);
//        if(k > 100 && k < 120)
//            object.setHealth(0);
    }
    @Override
    void attack(StarWars object){
//        int rez;
//        if(object.dodge() == true){
//            object.counterAttack(this);
//            
//            rez = this.health - object.attackDamage;
//            if(rez < 0)
//                this.setHealth(0);
//            this.setHealth(rez);
//            //System.out.println(rez);
//        }
//        if(this.accurancy >= 0.5f){
//            this.criticalDamage(object);
//            rez = object.health - this.attackDamage;
//            if(rez < 0)
//                object.setHealth(0);
//            object.setHealth(rez);
//        }
//        else{
//            this.criticalDamage(object);
//            rez = object.health - this.attackDamage / 2;
//            if(rez < 0)
//                object.setHealth(0);
//            object.setHealth(rez);
//        }
    }
    @Override
    public void counterAttack(StarWars object){}
//        this.attack(object);
//    }
    
}
