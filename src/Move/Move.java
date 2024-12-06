package Move;

import Pal.BasePal;
import Pal.Type;

public class Move {
    private String name;
    private Type type;
    private int power; // Base damage
    private int accuracy; // Percentage chance to hit

    public Move(String name, Type type, int power, int accuracy) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
    }

    // Getters
    public String getName() { return name; }
    public Type getType() { return type; }
    public int getPower() { return power; }
    public int getAccuracy() { return accuracy; }

    // Execute the move
    public void execute(BasePal attacker, BasePal target) {
        // Accuracy check
        if (Math.random() * 100 < accuracy) {
            // Calculate damage
            int damage = calculateDamage(attacker, target);
            System.out.println(attacker.getName() + " used " + name + "!");
            System.out.println("It dealt " + damage + " damage!");
            target.takeDamage(damage);
        } else {
            System.out.println(attacker.getName() + " used " + name + " but missed!");
        }
    }

    private int calculateDamage(BasePal attacker, BasePal target) {
        // Basic damage formula: (Power * Attack / Target Defense)
        double modifier = getTypeEffectiveness(type, target.getType());
        return (int) ((power * attacker.getAtk() / (double) target.getDef()) * modifier);
    }

    private double getTypeEffectiveness(Type moveType, Type targetType) {
        // Simplified type effectiveness (you can expand this with a full type chart)
        if (moveType.equals(Type.FIRE) && targetType.equals(Type.GRASS)) return 2.0;
        if (moveType.equals(Type.WATER) && targetType.equals(Type.FIRE)) return 2.0;
        if (moveType.equals(Type.GRASS) && targetType.equals(Type.WATER)) return 2.0;
        if (moveType.equals(Type.NORMAL) && targetType.equals(Type.DRAGON)) return 2.0;
        if (moveType.equals(Type.DRAGON) && !targetType.equals(Type.NORMAL)) return 2.0;
        return 1.0; // Neutral effectiveness
    }
}
