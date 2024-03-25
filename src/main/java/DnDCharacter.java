import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DnDCharacter {

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;
    private final int hitpoints;

    public DnDCharacter() {
        strength = rollAbility();
        dexterity = rollAbility();
        constitution = rollAbility();
        intelligence = rollAbility();
        wisdom = rollAbility();
        charisma = rollAbility();
        hitpoints = calculateHitpoints();
    }

    int ability(List<Integer> scores) {
        int min = scores.stream().min(Integer::compareTo).orElse(0);
        return scores.stream().reduce(0, Integer::sum) - min;
    }

    List<Integer> rollDice() {
        var scores = new ArrayList<Integer>();
        var random = new Random();
        for (int i = 0; i < 4; i++)
            scores.add(random.nextInt(6) +1);
        return scores;
    }

    int modifier(int input) {
        if (input < 10 ) return (input -11) / 2;
        return (input - 10) / 2;
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }

    private int calculateHitpoints() {
        return 10 + modifier(constitution);
    }

    private int rollAbility() {
        return ability(rollDice());
    }
}
