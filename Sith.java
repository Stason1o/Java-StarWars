/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

public class Sith extends Humans{
    int force;
    Sith(){
        super();
        force = 0;
    }
    
    Sith(int _health, int _attack, String _weapon, int _intellect, int _force){
        super(_health, _attack, _weapon, _intellect);
        force = _force;
    }
    
    Sith(Sith object){
        super(object);
        force = object.force;
    }
    public int getForce(){ return force;}
    public void setForce(int _force){
        if(_force > 0)
            force = _force;
    }
    
    @Override
    public void criticalDamage(StarWars object){ 
        int k;
        k = (int)(Math.random()*20);
        int rez;
        if(k < 6){
            rez = object.health - this.attackDamage*2;
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
        this.empower(object);
        if(object.dodge() == true){
            object.counterAttack(this);
            
            rez = this.health - object.attackDamage;
            if(rez < 0)
                this.setHealth(0);
            this.setHealth(rez);
            //System.out.println(rez);
        }
        if(this.force >= 80){
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
    
    public void empower(StarWars object){
        int k;
        k = (int)(Math.random()*400);
        if(k > 20 && k < 60 || k > 100 && k < 120)
            object.setHealth(object.health - this.attackDamage*6);
    }
}
