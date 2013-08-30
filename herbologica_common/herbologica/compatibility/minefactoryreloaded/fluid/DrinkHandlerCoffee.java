package herbologica.compatibility.minefactoryreloaded.fluid;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import powercrystals.minefactoryreloaded.api.ILiquidDrinkHandler;

/**
 * Ars Herbologica
 * 
 * DrinkHandlerCoffee
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class DrinkHandlerCoffee implements ILiquidDrinkHandler {
	
	@Override
	public void onDrink(EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1200, 1));
	}

}
