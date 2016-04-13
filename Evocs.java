
package starwars;

public class Evocs extends Warriors{
    int quantity;//количество эвоков
    
    Evocs(){
        super();
        accurancy = 0f;
        quantity = 0;
    }
    
    Evocs(int _health, int _attack, String _weapon, int _quantity, float _accurancy){
        super(_health, _attack, _weapon, _accurancy);
        quantity = _quantity;
    }
    
    Evocs(Evocs object){
        super();
        quantity = object.quantity;
        accurancy = object.accurancy;
    }
    public int getQuantity()    { return quantity;}
    public float getAccurancy() { return accurancy;}
    
    public void setQuantity(int _quantity){
        if(_quantity > 0)
            quantity = _quantity;
    }
    public void setAccurancy(float _accurancy){
        if(_accurancy <= 1 && _accurancy >= 0)
            accurancy = _accurancy;
    }
    
    @Override
    public void criticalDamage(StarWars object){ 
        int k;
        k = (int)(Math.random()*20);
        int rez;
        if(k < 6){
            if(this.accurancy >= 0.5f){
                rez = object.health - this.attackDamage * 3 * this.quantity;
                object.setHealth(rez);
            }
            rez = object.health - this.attackDamage * 2 * this.quantity;
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
        if(k > 10 && k < 12)
            object.setHealth(0);
    }
    @Override
    void attack(StarWars object){
        int rez;
//        if(this instanceof Evocs)
            this.epicComeBack(object);
        if(object.dodge() == true){
            object.counterAttack(this);
            
            rez = this.health - object.attackDamage * this.quantity;
            if(rez < 0)
                this.setHealth(0);
            this.setHealth(rez);
            //System.out.println(rez);
        }
        if(this.accurancy >= 0.5f){
            this.criticalDamage(object);
            rez = object.health - this.attackDamage * this.quantity;
            if(rez < 0)
                object.setHealth(0);
            object.setHealth(rez);
        }
        else{
            this.criticalDamage(object);
            rez = object.health - this.attackDamage * this.quantity / 2;
            if(rez < 0)
                object.setHealth(0);
            object.setHealth(rez);
        }
    }
    @Override
    public void counterAttack(StarWars object){
        this.attack(object);
    }
    
    public void epicComeBack(StarWars object){//уникальная функция для этого класса
        if(object.health / this.health > 4 )
            this.setQuantity(this.quantity * 5);
    }
}
