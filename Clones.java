
package starwars;

public class Clones extends Warriors{
    boolean fly;
    Clones(){
        super();
        fly = false;
    }
    
    Clones(int _health, int _attack, String _name, float _accurancy, boolean _fly){
        super(_health, _attack, _name, _accurancy);
        fly = _fly;
    }
    Clones(Clones object){
        super();
        fly = object.fly;
    }
    public boolean getFly(){ return fly;}
    public void setFly(int num){
        if(num == 1 && fly == false)
            fly = !fly;
        else if(num == 0 && fly == true)
            fly = !fly;
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
//        if(this.fly == true && (k > 1 && k < 8))
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
                this.fear(object); 
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
    
    public void fear(StarWars object){//уникальный метод
        if (object.health > 7000)
            this.setAttackDamage(this.attackDamage / 3);
    }
}
