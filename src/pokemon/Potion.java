package pokemon;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Potion {

	private String type, description;
	private Image potion;
	private boolean used;
	public String getType()
	{
		return type;
	}
	public Image getImage()
	{
		return potion;
	}
	public String getDescription()
	{
		return description;
	}
	public Potion(String inputType)
	{
		type=inputType;
		used=false;
		if(type.equalsIgnoreCase("Heal"))
		{
			potion = (new ImageIcon("images/Potion.png")).getImage();
			description="Heals your Pokemon the equivalent to  25% of that Pokemon's health points.";
			
		}else if (type.equalsIgnoreCase("Full Heal"))
		{
			potion = (new ImageIcon("images/Full_Heal.png")).getImage();
			description="Fully heals any status \nproblems that a Pokémon holds.";
			
		}else if (type.equalsIgnoreCase("PlusPower"))
		{
			potion = (new ImageIcon("images/PlusPower.png")).getImage();
			description="Your Pokemon's attacks does 10 more damage to the Active Pokemon";
			
		}
	}
	public void usePotion(PokemonMonster pokemon)
	{
		if(type.equalsIgnoreCase("heal"))
		{
			pokemon.setHealth((int)(pokemon.getHealth()/4)+(pokemon.getHealth()));
		}else if(type.equalsIgnoreCase("full heal"))
		{
			pokemon.setHealth(pokemon.getOriginalHp());
		}else if(type.equalsIgnoreCase("pluspower"))
		{
			pokemon.setNormalAttack(pokemon.getNormalAttack().getAttackValue()+10);
			pokemon.setSpecialAttack(pokemon.getSpecialAttack().getAttackValue()+10);
		}
	}
	public boolean getUsed()
	{
		return used;
	}
	public void setUsed(boolean input)
	{
		used=input;
	}
}
