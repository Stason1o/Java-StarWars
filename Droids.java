/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

public class Droids extends Warriors{
    int speed;
    Droids(){
        super();
        speed = 0;
    }
    
    Droids(int _health, int _attack, String _weapon, float _accurancy, int _speed){
        super(_health, _attack, _weapon, _accurancy);
        speed = _speed;
    }
    Droids(Droids object){
        super(object);
        speed = object.speed;
    }
    public int getSpeed() { return speed; }
    public void setSpeed(int _speed) {
        if(_speed > 0)
            speed = _speed;
    }
    
    @Override
    public void criticalDamage(StarWars object){ 
        int k;
        k = (int)(Math.random()*20);
        int rez;
        if(k < 6){
            rez = object.health - this.attackDamage * 2;
            object.setHealth(rez);
            //System.out.println(rez);
        }
    }
//    @Override
//    public boolean dodge(){
//        int k;
//        k = (int)(Math.random()*13);
//        if(k > 3 && k < 6)
//            return true;
//        return false;
//    }
    
    @Override
    public void fatalDamage(StarWars object){
        int k;
        k = (int)(Math.random()*300);
        if(k > 100 && k < 120)
            object.setHealth(0);
    }
    @Override
    void attack(StarWars object){
        int rez;
        this.runAway();
        if(object.dodge() == true){
            object.counterAttack(this);
            rez = this.health - object.attackDamage;
            if(rez < 0)
                this.setHealth(0);
            this.setHealth(rez);
            //System.out.println(rez);
        }
        if(this.accurancy >= 0.5f){
            this.criticalDamage(object);
            rez = object.health - this.attackDamage;
            if(rez < 0)
                object.setHealth(0);
            object.setHealth(rez);
        }
        else{
            this.criticalDamage(object);
            rez = object.health - this.attackDamage / 2;
            if(rez < 0)
                object.setHealth(0);
            object.setHealth(rez);
        }
    }
    @Override
    public void counterAttack(StarWars object){
        this.attack(object);
    }
    
    public void runAway(){
        if(this.speed > 200 && this.health < 20)
            System.out.println("Бежиииим");
        else System.out.println("Heeeeeeeelp");
    }
}
