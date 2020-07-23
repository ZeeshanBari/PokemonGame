package pokemon;

import java.awt.Image;

import javax.swing.ImageIcon;


public class PokemonMonster {
	private Attacks normalAttack, specialAttack;
	private int hp, lvl, heal, originalhp;
	private String name, type;
	private boolean starter;
	private int gamesPlayed;
	ImageIcon front, back;
	ImageIcon backgrnd= new ImageIcon ("images/pokemon arena.png");
	Image background = backgrnd.getImage();

	public void addGamesPlayed()
	{
		gamesPlayed++;
		if(gamesPlayed>lvl)
		{
			lvl++;
			originalhp+=5;
			hp+=5;
			normalAttack.setAttackValue(normalAttack.getAttackValue()+5);
			specialAttack.setAttackValue(specialAttack.getAttackValue()+5);
			heal+=5;
			normalAttack.setPP(normalAttack.getOriginPP());
			specialAttack.setPP(specialAttack.getOriginPP());
		}
	}
	public void setLvl(int level)
	{
		lvl=level;
		originalhp+=(lvl*5);
		hp+=(lvl*5);
		normalAttack.setAttackValue(normalAttack.getAttackValue()+(5*lvl));
		specialAttack.setAttackValue(specialAttack.getAttackValue()+(5*lvl));
		heal+=(5*lvl);
	}
	public PokemonMonster(String inputName)
	{
		lvl=0;
		gamesPlayed=0;
		if(inputName.equalsIgnoreCase("Bulbasaur"))
		{
			name=inputName;
			hp=200+(lvl*5);
			starter=true;	
			type="Grass";
			
			normalAttack= new Attacks("Poison Powder", false, 92+(lvl*5));
			specialAttack=new Attacks("Razor Leaf", true, 121+(lvl*5));
			heal=40+(lvl*5);
			
			front= new ImageIcon ("images/bulbasaur front.gif");
			back= new ImageIcon ("images/bulbasaur back real.png");
			
		}else if(inputName.equalsIgnoreCase("Charmander"))
		{
			name=inputName;
			hp=188+(lvl*5);
			starter=true;	
			type="Fire";
			
			normalAttack=new Attacks("Scratch", false, 98+(lvl*5));
			specialAttack=new Attacks("Ember", true, 112+(lvl*5));
			heal=39+(lvl*5);
			
			front= new ImageIcon ("images/charmander front.gif");
			back= new ImageIcon ("images/charmander back real.png");
			
		}else if(inputName.equalsIgnoreCase("Squirtle"))
		{
			name=inputName;
			hp=198+(lvl*5);
			starter=true;	
			type="Water";
			
			normalAttack=new Attacks("Water Gun", false, 90+(lvl*5));
			specialAttack=new Attacks("Hydro Pump", true, 94+(lvl*5));
			heal=40+(lvl*5);
			
			front= new ImageIcon ("images/squirtle front.gif");
			back= new ImageIcon ("images/squirtle back real.png");
			
		}else if(inputName.equalsIgnoreCase("Mewtwo"))
		{
			name=inputName;
			hp=322+(lvl*5);
			starter=true;	
			type="?";
			
			normalAttack=new Attacks("Confusion", false, 202+(lvl*5));
			specialAttack=new Attacks("Shadow Ball", true, 281+(lvl*5));
			heal=40+(lvl*5);
			
			front= new ImageIcon ("images/mewtwo front.gif");
			back= new ImageIcon ("images/mewtwo back.png");
		}else if(inputName.equalsIgnoreCase("Rapidash"))
		{
			name=inputName;
			hp=240+(lvl*5);
			starter=true;	
			type="Fire";
			
			normalAttack=new Attacks("Fire Spin", false, 184+(lvl*5));
			specialAttack=new Attacks("Flare Blitz", true, 148+(lvl*5));
			heal=40+(lvl*5);
			
			front= new ImageIcon ("images/horse front.png");
			back= new ImageIcon ("images/horse back.png");
			
		}else if(inputName.equalsIgnoreCase("Typhlosion"))
		{
			name=inputName;
			hp=266+(lvl*5);
			starter=true;	
			type="Fire";
			
			normalAttack=new Attacks("Covet", false, 155+(lvl*5));
			specialAttack=new Attacks("Crush Claw", true, 200+(lvl*5));
			heal=40+(lvl*5);
			
			front= new ImageIcon ("images/fire front.png");
			back= new ImageIcon ("images/fire back.png");
		}else if(inputName.equalsIgnoreCase("Lapras"))
		{
			name=inputName;
			hp=370+(lvl*5);
			starter=true;	
			type="Water";
			
			normalAttack=new Attacks("Aqua Tail", false, 157+(lvl*5));
			specialAttack=new Attacks("Dragon Pulse", true, 157+(lvl*5));
			heal=40+(lvl*5);
			
			front= new ImageIcon ("images/turtle front.png");
			back= new ImageIcon ("images/turtle back.png");
		}else if(inputName.equalsIgnoreCase("Alakazam"))
		{
			name=inputName;
			hp=220+(lvl*5);
			starter=true;	
			type="Psychic";
			
			normalAttack=new Attacks("Telekinesis", false, 94+(lvl*5));
			specialAttack=new Attacks("Future Sight", true, 247+(lvl*5));
			heal=40+(lvl*5);
			
			front= new ImageIcon ("images/alakazam front.png");
			back= new ImageIcon ("images/alakazam back.png");
		}else if(inputName.equalsIgnoreCase("snorlax"))
		{
			name=inputName;
			hp=430+(lvl*5);
			starter=true;	
			type="Normal";
			
			normalAttack=new Attacks("Telekinesis", false, 202+(lvl*5));
			specialAttack=new Attacks("Future Sight", true, 121+(lvl*5));
			heal=40+(lvl*5);
			
			front= new ImageIcon ("images/snorlax front.png");
			back= new ImageIcon ("images/snorlax back.png");
		}
		
		originalhp=hp;
	}
	public ImageIcon getFront()
	{
		return (front);
	}
	public ImageIcon getBack()
	{
		return (back);
	}
	public int getOriginalHp()
	{
		return originalhp;
	}
	public Attacks getNormalAttack() {
		return normalAttack;
	}

	public Attacks getSpecialAttack() {
		return specialAttack;
	}

	public int getLvl() {
		return lvl;
	}

	public String getName()
	{
		return name;
	}
	public int getHeal()
	{
		return heal;
	}
	public void setHealth(int health)
	{
		hp=health;
	}
	public void setNormalAttack(int attack)
	{
		normalAttack.setAttackValue(attack);
	}
	public void setSpecialAttack(int attack)
	{
		specialAttack.setAttackValue(attack);
	}
	public int getHealth()
	{
		return hp;
	}
	public String cpuAttackType()
	{
		int chances = (int)(Math.random()*5+1);
		switch(chances)
		{
		case 1:
			return "heal";
		default:
			return "attack";
		}
	}
	public Attacks cpuAttack()
	{
		Attacks cpuAttack;
		int ranAttack= (int)(Math.random()*5+1);
		switch(ranAttack)
		{
		case 1: case 2: case 3: case 4:
			cpuAttack=normalAttack;
			break;
		default:
			cpuAttack=specialAttack;
			break;
		}
		return cpuAttack;
	}
	public void attacked(Attacks attack)
	{
		hp-=attack.attack();
	}
	public void heal()
	{
		hp+=heal;
	}
	public boolean readyEvolve()
	{
		if((lvl*2)>=gamesPlayed)
		{
			return true;
		}else
		{
			return false;
		}
	}
}
