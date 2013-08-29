package herbologica.fluid;

import net.minecraftforge.fluids.Fluid;

/**
 * Ars Herbologica
 * 
 * ModFluids
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModFluids {
	
	public static Fluid fluidCoffee;
	
	public static void addFluids() {
		fluidCoffee = new FluidCoffee("fluidCoffee");
	}

}
