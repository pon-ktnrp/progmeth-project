package utils;

import logic.pal.BasePal;

public interface Evolvable {
	boolean isEvolvable();
	BasePal evolve();
}