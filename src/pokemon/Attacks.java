package pokemon;

public class Attacks {

	private boolean specialOrNot;
	private String attackName;
	private int attackValue;
	private int accuracy;
	private int attack, pp, originpp;
	public int getPP()
	{
		return pp;
	}
	public void setPP(int p)
	{
		pp=p;
	}
	public int getOriginPP()
	{
		return originpp;
	}
	public String getRatio()
	{
		return (pp+"/"+originpp);
	}
	public boolean isSpecialOrNot() {
		return specialOrNot;
	}
	public String getAttackName() {
		return attackName;
	}
	public void setAttackValue(int attack)
	{
		attackValue=attack;
	}
	public int getAttackValue() {
		return attackValue;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public int getAttack()
	{
		return attack;
	}
	public Attacks(String name, boolean special, int attack)
	{
		attackName=name;
		specialOrNot=special;
		attackValue=attack;
		
		if(specialOrNot==true)
		{
			pp=5;
			accuracy=95;
		}else
		{
			pp=10;
			accuracy=75;
		}
		originpp=pp;
	}
	public int attack()
	{
		pp--;
		int hit = (int)(Math.random()*100+1);
		if (hit < accuracy)
		{
			hit = attackValue;
		}else
		{
			hit = 0;
		}
		attack=hit;
		return hit;
	}
}
