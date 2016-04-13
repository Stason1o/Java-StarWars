
package starwars;

public class Humans extends StarWars{
    int intellect;
    
    Humans(){
        super();
        intellect = 0;
    }
    Humans(int _health, int _attack, String _weapon, int _intellect){
        super(_health, _attack, _weapon);
        intellect = _intellect;
    }
    
    Humans(Humans object){
        super(object);
        intellect = object.intellect;
    }
    
    public int getIntellect() { return intellect;}
    public void setIntellect(int _intellect){
        if(_intellect > 0)
            intellect = _intellect;
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
        int k;
        k = (int)(Math.random()*300);
        if(k > 100 && k < 120)
            object.setHealth(0);
    }
    @Override
    void attack(StarWars object){
        int rez;
        
        if(object.dodge() == true){
            object.counterAttack(this);
            
            rez = this.health - object.attackDamage;
            if(rez < 0)
                this.setHealth(0);
            this.setHealth(rez);
            //System.out.println(rez);
        }
        if(this.intellect >= 130){
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
}
