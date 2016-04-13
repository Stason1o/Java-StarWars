
package starwars;

public class Jedi extends Humans{
    int intellectForce;
    Jedi(){
        super();
        intellectForce = 0;
    }
    
    Jedi(int _health, int _attack, String _weapon, int _intellect, int _force){
        super(_health, _attack, _weapon, _intellect);
        intellectForce = _force;
    }
    
    Jedi(Jedi object){
        super(object);
        intellectForce = object.intellectForce;
    }
    
    public int getIntellectForce(){ return intellectForce;}
    public void setIntellectForce(int _intellectForce){
        if(_intellectForce > 0)
            intellectForce = _intellectForce;
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
        this.power(object);
        if(object.dodge() == true){
            object.counterAttack(this);
            
            rez = this.health - object.attackDamage;
            if(rez < 0)
                this.setHealth(0);
            this.setHealth(rez);
            //System.out.println(rez);
        }
        if(this.intellectForce >= 0.5f){
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
    
    public void power(StarWars object){
        if(this.health < 100)
            object.setHealth(this.health);
    }
}
