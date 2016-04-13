package starwars;

public abstract class StarWars implements Abilities{
    int health;
    int attackDamage;
    String name;
    static int nelem;
    static int wins;
    static int looses;
    
    StarWars(){
        health = 0;
        attackDamage = 0;
        name = "";
        wins = 0;
        looses = 0;
        nelem++;
    }
    
    StarWars(int _health, int _attackDamage, String _weapon){
        health = _health;
        attackDamage = _attackDamage;
        name = _weapon;
        wins = 0;
        looses = 0;
        nelem++;
    }
    
    StarWars(StarWars object){
        health = object.health;
        attackDamage = object.attackDamage;
        name = object.name;
        wins = object.wins;
        looses = object.looses;
        nelem++;
    }
     void print(){
        System.out.println("Здоровье: " + health);
        System.out.println("Атака: " + attackDamage);
        System.out.println("Имя: " + name);
    }
    abstract void attack(StarWars object);
    
    public int getHealth()          { return health;}
    public float getAttackDamage()  { return attackDamage;}
    public String getName()         { return name; } 
    
    public void setHealth(int _health){ 
        if(_health >= 0)
            health = _health;
    }
    public void setAttackDamage(int _damage){
        if(_damage > 0)
            attackDamage = _damage;
    }
    
    public void setName(String _name){
        name = _name;
    }

}
