package logic.item;

import logic.pal.BasePal;

public class BaseCapture extends BaseItem{
	protected double captureRate;
	
	public BaseCapture(String name, String description, double captureRate) {
		super(name, description);
		this.captureRate = captureRate;
	}
//	
//	public boolean tryCapture(BasePal target) {
//        if (!canUse()) {
//            System.out.println("No " + name + " left to use!");
//            return false;
//        }
//
//        // Calculate capture chance
//        double captureChance = calculateCaptureChance(target);
//        double randomValue = Math.random(); // Random number between 0 and 1
//
//        System.out.println("Throwing " + name + " at " + target.getName() + "...");
//        reduceQuantity(1);
//
//        if (randomValue < captureChance) {
//            System.out.println(target.getName() + " was captured!");
//            return true; // Capture successful
//        } else {
//            System.out.println(target.getName() + " broke free!");
//            return false; // Capture failed
//        }
//    }
//	
//	private double calculateCaptureChance(BasePal target) {
//        double healthFactor = (double) target.() / target.getMaxHP();
//        double chance = baseCaptureRate * (1 - healthFactor); // Lower HP increases capture chance
//        return Math.min(chance, 1.0); // Cap at 100% chance
//    }
}
