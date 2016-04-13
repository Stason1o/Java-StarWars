
package starwars;


public class Gungans extends Warriors{
    Gungans(){
        super();
    }
    
    Gungans(int _health, int _attackDamage, String _weapon, float _accurancy){
        super(_health, _attackDamage, _weapon, _accurancy);
    }
    
    Gungans(Gungans object){
        super(object);
    }
    @Override
    public void criticalDamage(StarWars object){ 
        int k;
        k = (int)(Math.random()*20);
        int rez;
        if(k < 6){
            rez = object.health - this.attackDamage*3;
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
    
    public void scream(){
        System.out.println("Ура Ура Ура, танцуем индийский танец");
    }
}
