
package starwars;
/**
 *
 * @author Stas
 */
public class main {
    public static final void fight(StarWars first, StarWars second){//война миров
        int f1 = first.getHealth();
        int f2 = second.getHealth();
        while(first.health > 0 || second.health > 0){
            first.attack(second);
            second.attack(first);
            if(first.health <= 0 && second.health > 0){
                if(second instanceof Gungans)
                    ((Gungans) second).scream();
                System.out.println(second.name +" wins");
                second.wins++;
                first.looses++;
                first.setHealth(f1);
                second.setHealth(f2);
                break;
            }
            else if(second.health <= 0 && first.health > 0){
                if(first instanceof Gungans)
                    ((Gungans) first).scream();
                System.out.println(first.name +" wins");
                first.wins++;
                second.looses++;
                first.setHealth(f1);
                second.setHealth(f2);
                break;
            }
            else if(first.health <= 0 && second.health <= 0){
                System.out.println("draw");
                break;
            }
        }    
        first.setHealth(f1);
        second.setHealth(f2);
    }
    
    public static void main(String args[]){
        StarWars heroes[] = new StarWars[6];
//        StarWars losers[] = new StarWars[3];
//        StarWars winers[] = new StarWars[3];
//        Clones clone = new Clones(200,60,"Клон",0.6f,false);
//        Droids droid = new Droids(300,65,"Дроид",0.6f, 190);
//        Evocs evocs = new Evocs(300,50,"Эвокиииии",200,0.2f);
//        Jedi jedi = new Jedi(500, 70, "Люк",170, 80);
//        Sith sith = new Sith(600, 55, "Вэйдер",160,100);
//        Gungans gungan = new Gungans(400, 40,"Джа Джа Бинс", 0.6f);
        heroes[0] = new Clones(200,60,"Клон",0.6f,false);//clone;
        heroes[1] = new Droids(300,65,"Дроид",0.6f, 190);//droid;
        heroes[2] = new Evocs(300,50,"Эвокиииии",200,0.2f);//evocs;
        heroes[3] = new Jedi(500, 70, "Люк",170, 80);//jedi;
        heroes[4] = new Sith(600, 55, "Вэйдер",160,100);//sith;
        heroes[5] = new Gungans(400, 40,"Джа Джа Бинс", 0.6f);//gungan;
        
        fight(heroes[5], heroes[1]);
        
        for (int i = 0; i < 6; i++)
            if(heroes[i] instanceof Droids)
                ((Droids)heroes[i]).runAway();
//        jedi.print();
    }
}
