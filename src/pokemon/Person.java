package pokemon;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Person {
	private PokemonMonster [] pokemen;
	//private Bag bag;
	private Image front, back, left, right;
	private String name;
	public Person(String person1)
	{
		if(person1.equalsIgnoreCase("main"))
		{
			left  =(new ImageIcon("images/main left.png")).getImage();
			right =(new ImageIcon("images/main right.png")).getImage();
			front =(new ImageIcon("images/main front.png")).getImage();
			back  =	(new ImageIcon("images/main back.png")).getImage();
		}
		pokemen= new PokemonMonster[5];
	}
	public void setName(String name1)
	{
		name=name1;
	}
	public Image getImagePosition(String position)
	{
		if(position.equalsIgnoreCase("left"))
		{
			return left;
		}else if(position.equalsIgnoreCase("right"))
		{
			return right;
		}else if(position.equalsIgnoreCase("up"))
		{
			return back;
		}else
		{
			return front;
		}
	}
	public boolean checkAddPokemon(PokemonMonster pokemon)
	{
		for(int x=0; x<pokemen.length;x++)
		{
			if(pokemen[x]!=null)
			{
				return false;
			}
		}
		return true;
	}
	public void addPokemon(PokemonMonster pokemon)
	{
		for(int x=0; x<pokemen.length;x++)
		{
			if(pokemen[x]==null)
			{
				pokemen[x]=pokemon;
				break;
			}
		}
	}
}
