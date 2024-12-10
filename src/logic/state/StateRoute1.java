package logic.state;

import java.util.Random;

import logic.pal.*;

public class StateRoute1 {
	private static final Class<?>[] PAL_CLASSES = {
			Caterpie.class, Pidgey.class, Rattata.class, Spearow.class, Meowth.class, Zigzagoon.class, Bidoof.class
	};
	
	public static BasePal generateRandomPal(int level) {
		 try {
	            Random random = new Random();
	            // Choose a random Pokémon class
	            Class<?> pokemonClass = PAL_CLASSES[random.nextInt(PAL_CLASSES.length)];

	            // Call the constructor of the chosen class with level as parameter
	            return (BasePal) pokemonClass.getConstructor(int.class).newInstance(level);

	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error generating random Pokémon.");
	        }
	}
}
