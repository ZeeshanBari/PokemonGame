package pokemon;

import java.awt.Font;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Fresh extends JFrame{
 
 private Graphics dbg;
 private Image dbImage, titlepage, pokeBallPage, firstPokemon, field; //backgrounds
 private Image firstArrow;//arrows
 private Image left, right, main, back;
 private Font font = new Font("Pokemon GB", Font.PLAIN, 20);
 private int enter=0, x, y;
 private String position="down";
 private PokemonMonster starter, starterCPU, pokemon1, pokemon2, pokemon3;
 private FightingArena fight;
 private int first=0, pokemen;
 private Person character;
 public Fresh()
 {
  character= new Person("main");
  pokemen = (int)(Math.random()*9+1);
  starterCPU= new PokemonMonster("charmander");
  titlepage = (new ImageIcon("images/titlepage.png")).getImage();
  pokeBallPage= (new ImageIcon("images/pokeballpage.png")).getImage();
  firstArrow= (new ImageIcon("images/firstarrow.png")).getImage();
  firstPokemon= (new ImageIcon("images/pokestarter.jpg")).getImage();
  field =(new ImageIcon("images/background.png")).getImage();
  left  =(new ImageIcon("images/main left.png")).getImage();
  right =(new ImageIcon("images/main right.png")).getImage();
  main  =(new ImageIcon("images/main front.png")).getImage();
  back  = (new ImageIcon("images/main back.png")).getImage();
    
  x=100;
  y=75;
  
  addKeyListener(new AL());
  setTitle("Pokemon - By Zeeshan Bari");
  setSize(500, 700);
  setResizable(false);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 public class AL extends KeyAdapter
 {
  public void keyPressed(KeyEvent e)
  {
   int keyCode= e.getKeyCode();
   if(keyCode==e.VK_ENTER)
   {
    enter++;
   }else if(keyCode==e.VK_LEFT)
   {
    if(enter==1)
    {
     if(!(x==100))
     {
      x-=200;
     }
    }
    
   }else if(keyCode==e.VK_RIGHT)
   {
    if(enter==1)
    {
     if(!(x==500)){
      x+=200;
     }
    }
   }
  }
 }
 public void paint(Graphics g)
 {
  dbImage = createImage(getWidth(), getHeight());
     dbg = dbImage.getGraphics();
     paintComponent(dbg);
     g.drawImage(dbImage, 0, 0, this);
 }
 public void paintComponent(Graphics g)
 {
  g.setFont(font);
  if(enter==0)
  {
   g.drawImage(titlepage, 0, 0, this);
  }else if (enter==1)
  {
   setSize(675, 350);
   g.drawImage(pokeBallPage, 0, 0, this);
   g.drawString("Choose your starter Pokemon", 50, 50);
   g.drawImage(firstArrow, x, y, this);
  }else if(enter==2)
  {
   setSize(600, 400);
   g.drawImage(firstPokemon, 0, 0, this);
   g.drawString("Your starter Pokemon is...", 50, 50);
   switch(pokemen)
   {
   case 1:
    starter= new PokemonMonster("charmander");
    break;
   case 2:
    starter = new PokemonMonster("alakazam");
    break;
   case 3:
    starter = new PokemonMonster("squirtle");
    break;
   case 4:
    starter = new PokemonMonster("bulbasaur");
    break;
   case 5:
    starter = new PokemonMonster("lapras");
    break;
   case 6:
    starter = new PokemonMonster("Typhlosion");
    break;
   case 7:
    starter = new PokemonMonster("Mewtwo");
    break;
   case 8:
    starter = new PokemonMonster("snorlax");
    break;
   default:
    starter = new PokemonMonster("rapidash");
    break;
   }
   if(x==100 || x==300 || x==500)
   {
    g.drawString(starter.getName().toUpperCase(), 100, 300);
    g.drawImage(starter.front.getImage(), 200, 150, this);
   }
  }else if(enter==3)
  {
   setSize(0,0);
   if(first==0)
   {
    fight=new FightingArena(starter, starterCPU);
    first++;
   }else
   {
    fight= new FightingArena(starterCPU, pokemon1, pokemon2, pokemon3);
   }
   enter=4;
  }else if(enter==5)
  {
   pokemon1=fight.getPokemon1();
   pokemon2=fight.getPokemon2();
   pokemon3=fight.getPokemon3();
   enter=3;
  }
  repaint();
 }
 public static void main(String[]args)
 {
  new Fresh();
 }
}
