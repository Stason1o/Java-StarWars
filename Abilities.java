
package starwars;

public interface Abilities {
    void criticalDamage(StarWars object);
    void fatalDamage(StarWars object);
    void counterAttack(StarWars object);
    boolean dodge();
}
