package pokemon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FightingArena extends JFrame{

 private Image dbImage, background;
 private Graphics dbg;
 private Image pokemonfront, pokemonback,firstbar, arrow, fightbar1, fightbar2, bag, pokemonScreen;
 private Font font= new Font("Pokemon GB", Font.PLAIN, 15), font1= new Font("Pokemon GB", Font.PLAIN, 12), font2= new Font("Pokemon GB", Font.PLAIN, 20);
 private int enter=-1,x=280, y=282, x1=30, y1=285, xbag=205, ybag=60, originPhp, xpoke=75, ypoke=90;
 private PokemonMonster starter, pokemon1, pokemon2, pokemon3;
 PokemonMonster starterCPU;
 private String turn="player";
 private int attack=(int)(Math.random()*3+1);
 private double rectXP, rectXCPU;
 private Color green = new Color(8052346);
 private Potion heal, full, power;
 private Image field, left, right, main, back;
 private int fieldx, fieldy, yField;
 private String position;
 public FightingArena(PokemonMonster name1, PokemonMonster name2)
 {
  field =(new ImageIcon("images/background.png")).getImage();
  left  =(new ImageIcon("images/main left.png")).getImage();
  right =(new ImageIcon("images/main right.png")).getImage();
  main  =(new ImageIcon("images/main front.png")).getImage();
  back  = (new ImageIcon("images/main back.png")).getImage();
  
  fieldx=220;
  fieldy=120;
  yField=0;
  position="down";
  
  starter = name1;
  starterCPU = name2;
  pokemon1=starter;
  
  do
  {
   int pokemen=(int)(Math.random()*9+1), pokemen1=(int)(Math.random()*9+1);
   switch(pokemen)
   {
   case 1:
    pokemon2= new PokemonMonster("charmander");
    break;
   case 2:
    pokemon2 = new PokemonMonster("alakazam");
    break;
   case 3:
    pokemon2 = new PokemonMonster("squirtle");
    break;
   case 4:
    pokemon2 = new PokemonMonster("bulbasaur");
    break;
   case 5:
    pokemon2 = new PokemonMonster("lapras");
    break;
   case 6:
    pokemon2 = new PokemonMonster("Typhlosion");
    break;
   case 7:
    pokemon2 = new PokemonMonster("Mewtwo");
    break;
   case 8:
    pokemon2 = new PokemonMonster("snorlax");
    break;
   default:
    pokemon2 = new PokemonMonster("rapidash");
    break;
   }
   switch(pokemen1)
   {
   case 1:
    pokemon3= new PokemonMonster("charmander");
    break;
   case 2:
    pokemon3 = new PokemonMonster("alakazam");
    break;
   case 3:
    pokemon3 = new PokemonMonster("squirtle");
    break;
   case 4:
    pokemon3 = new PokemonMonster("bulbasaur");
    break;
   case 5:
    pokemon3 = new PokemonMonster("lapras");
    break;
   case 6:
    pokemon3 = new PokemonMonster("Typhlosion");
    break;
   case 7:
    pokemon3 = new PokemonMonster("Mewtwo");
    break;
   case 8:
    pokemon2 = new PokemonMonster("snorlax");
    break;
   default:
    pokemon3 = new PokemonMonster("rapidash");
    break;
   }
  }while(pokemon1.getName().equals(pokemon2.getName()) || pokemon1.getName().equals(pokemon3.getName()) || pokemon3.getName().equals(pokemon2.getName()));
  rectXCPU=111;
  rectXP=111;
  heal=new Potion("heal");
  full=new Potion("full heal");
  power=new Potion("pluspower");
  pokemonScreen =(new ImageIcon("images/pokemon screen.png")).getImage();
  bag= (new ImageIcon("images/first panel.png")).getImage();
  ImageIcon bar =new ImageIcon("images/firstbar.jpg");
  ImageIcon arr =new ImageIcon("images/arrow.png");
  ImageIcon bar2 =new ImageIcon("images/fightbar1.png");
  ImageIcon bar3 =new ImageIcon("images/fightbar2.png");
  fightbar1=bar2.getImage();
  fightbar2=bar3.getImage();
  arrow = arr.getImage();
  firstbar = bar.getImage();
  pokemonfront = (starterCPU.getFront()).getImage();
  pokemonback = (starter.getBack()).getImage();
  
  background = starter.background;
  
  addKeyListener(new AL());
  setTitle("Pokemon - Fighting Arena");
  setResizable(false);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 public FightingArena(PokemonMonster name1, PokemonMonster pokemon11, PokemonMonster pokemon12, PokemonMonster pokemon13)
 {
  starterCPU=name1;
  pokemon1=pokemon11;
  pokemon2=pokemon12;
  pokemon3=pokemon13;
  starter=pokemon1;
  starterCPU.setLvl(starter.getLvl()*2);
  field =(new ImageIcon("images/background.png")).getImage();
  left  =(new ImageIcon("images/main left.png")).getImage();
  right =(new ImageIcon("images/main right.png")).getImage();
  main  =(new ImageIcon("images/main front.png")).getImage();
  back  = (new ImageIcon("images/main back.png")).getImage();
  fieldx=220;
  fieldy=120;
  yField=0;
  position="down";
  rectXCPU=111;
  rectXP=111;
  heal=new Potion("heal");
  full=new Potion("full heal");
  power=new Potion("pluspower");
  pokemonScreen =(new ImageIcon("images/pokemon screen.png")).getImage();
  bag= (new ImageIcon("images/first panel.png")).getImage();
  ImageIcon bar =new ImageIcon("images/firstbar.jpg");
  ImageIcon arr =new ImageIcon("images/arrow.png");
  ImageIcon bar2 =new ImageIcon("images/fightbar1.png");
  ImageIcon bar3 =new ImageIcon("images/fightbar2.png");
  fightbar1=bar2.getImage();
  fightbar2=bar3.getImage();
  arrow = arr.getImage();
  firstbar = bar.getImage();
  pokemonfront = (starterCPU.getFront()).getImage();
  pokemonback = (starter.getBack()).getImage();
  
  background = starter.background;
  
  addKeyListener(new AL());
  setTitle("Pokemon - Fighting Arena");
  setResizable(false);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 public PokemonMonster getPokemon1()
 {
  return pokemon1;
 }
 public PokemonMonster getPokemon2()
 {
  return pokemon2;
 }
 public PokemonMonster getPokemon3()
 {
  return pokemon3;
 }
 public class AL extends KeyAdapter//AL=Action Listener
   {
     public void keyPressed(KeyEvent e)//e= button the user pressed//This method is automatically called everytime something is pressed 
     {
       int keyCode= e.getKeyCode();// key is stored as a integer
       if (keyCode==e.VK_LEFT)//after VK_ , you can enter anything from the keyboard
       {
        if(enter==0)
        {
         if(!(x<=280))
         {
          x-=160; 
            }
        }else if(enter==1)
        {
         x1=30;
        }else if(enter==-1)
        {
         if(!(fieldx<=5))
     {
      fieldx-=5;
     }
        position="left";
        }
       }else if(keyCode==e.VK_RIGHT)
       {
        if(enter==0)
        {
         if(!(x>=(280+160)))
         {
          x+=160; 
         }
        }else if(enter==1)
        {
         x1=255;
         y1=285;
        }else if(enter==-1)
        {
         if(!(fieldx>=1130))
     {
      fieldx+=5;
     }
        position="right";
        }
       }else if(keyCode==e.VK_UP)
       {
        if(enter==0)
        {
         if(!(y<=282))
         {
          y-=40;
         }
        }else if(enter==1)
        {
         y1=285;
         if((x==(280+160) && y==282))
         {
          if(!(ybag<=60))
          {
           ybag-=20;
          }
         }else if(x==280 && y==(282+40))
         {
          if(!(ypoke-30<90))
          {
           ypoke-=30;
          }
         }
        }else if(enter==-1)
        {
         if(yField<0 && fieldy==25)
     {
      yField+=5;
     }else if(!(fieldy<=25))
     {
      fieldy-=5;
     }
        position="up";
        }
       }else if(keyCode==e.VK_DOWN)
       {
        if(enter==0)
        {
         if(!(y>=(282+40)))
         {
          y+=40;
         }
        }else if(enter==1)
        {
         if(!(x1==255))
         {
          y1=325;
          if((x==(280+160) && y==282))
          {
           if(!(ybag>=200))
           {
            ybag+=20;
           }
          }else if(x==280 && y==(282+40))
          {
           if(!(ypoke+30>180))
           {
            ypoke+=30;
           }
          }
         }
        }else if(enter==-1)
        {
         if(fieldy>=825 && yField>=-30){
      yField-=5;
     }else if(fieldy<825)
     {
      fieldy+=5;
     }
        position="down";
        }
       }else if(keyCode==e.VK_ENTER)
       {
        enter++;
        if(enter==2)
        {
         if(x==280 && y==282)
         {
          if(x1==30 && y1==285)
      {
           if(!(starter.getNormalAttack().getPP()<=0))
           {
            rectXCPU-=((starter.getNormalAttack().attack()*111)/starterCPU.getOriginalHp());
           }else
           {
            enter=1;
           }
      }else if(y1==325)
      {
       if(!(starter.getSpecialAttack().getPP()<=0))
       {
        rectXCPU-=((starter.getSpecialAttack().attack()*111)/starterCPU.getOriginalHp());
       }else
       {
        enter=1;
       }
      }else if(x1==255)
      {
       if((rectXP+40)<=111)
       {
        rectXP+=40;
       }else
       {
        rectXP=111;
       }
      }
         }
        }else if(enter==3)
        {
         originPhp=(int)rectXP;
         switch(attack)
     {
     case 1:
      rectXP-=((starterCPU.getNormalAttack().attack()*111)/starter.getOriginalHp());
      break;
     case 2:
      rectXP-=((starterCPU.getSpecialAttack().attack()*111)/starter.getOriginalHp());
      break;
     default:
      if((rectXCPU+40)<=111)
      {
       rectXCPU+=40;
      }else
      {
       rectXCPU=111;
      }
      break;
     }
        }
       }
     }
     public void keyReleased(KeyEvent e)
     {
     }
   }
 public void paint(Graphics g)
 {
  dbImage = createImage(getWidth(), getHeight());// created an image of the current screen to the width and height of the screen
     dbg = dbImage.getGraphics();//Graphics are stored
     paintComponent(dbg);//paint graphics outside window
     g.drawImage(dbImage, 0, 0, this);//drawImage on window
 }
 public void paintComponent(Graphics g)
 {
  if(enter==-1)
  {
   setSize(1150, 850);
   g.drawImage(field, 0, yField, this);
   if(position=="left")
      {
        g.drawImage(left, fieldx, fieldy, this);
      }else if(position=="right")
      {
        g.drawImage(right, fieldx, fieldy, this);
      }else if(position=="down")
      {
        g.drawImage(main, fieldx, fieldy, this);
      }else if(position=="up")
      {
        g.drawImage(back, fieldx, fieldy, this);
      }
   g.fillRect(x1+169, y1+400, 23, 23);
   g.fillRect(289, 400, 23, 23);
   g.fillRect(409, 400, 23, 23);
   g.fillRect(650, 500, 75, 75);
   //doors closed; only door can go to is open
   if(fieldx>=650 && fieldx<=650+75 && fieldy>=500 && fieldy<=500+75)
   {
    starterCPU= new PokemonMonster("Mewtwo");
    enter=0;
   }
  }
   if(enter==0 || (enter==1 && x==280 && y==282) || (enter==2 && x==280 && y==282) || (enter==3 && x==280 && y==282))
   {
    g.setFont(font);
    setSize(550, 375);
    g.drawImage(background, 0, 0, this);
    g.setColor(green);
    g.fillRect(121, 77, (int)rectXCPU, 5);
    g.fillRect(404, 210, (int)rectXP, 5);
    g.setColor(Color.BLACK);
   }
   if(rectXCPU<=0)
   {
    enter=5;
    pokemon1.addGamesPlayed();
    pokemon2.addGamesPlayed();
    pokemon3.addGamesPlayed();
    dispose();
   }else if(rectXP<=0)
   {
    enter=5;
    dispose();
   }
   if(enter==0)
   {
    g.drawImage(firstbar, 260, 260, this);
    g.setColor(Color.WHITE);
    g.drawString("What will", 25, 300);
    g.drawString(starter.getName().toUpperCase()+" do?", 25, 340);
    g.setColor(Color.BLACK);
    g.drawString("FIGHT", 300, 300);
    g.drawString("POK�MON", 300, 340);
    g.drawString("BAG", 460, 300);
    g.drawString("RUN", 460, 340);
    g.drawImage(arrow, x, y, this);
   }else if(enter==1)
   {
    if(x==280 && y==282)
    {
     g.drawImage(fightbar1, 0, 260, this);
     g.drawImage(fightbar2, 360, 260 , this);
     g.drawString(starter.getNormalAttack().getAttackName(), 50, 300);
     g.drawString(starter.getSpecialAttack().getAttackName(), 50, 340);
     g.drawString("Heal", 275, 300);
     if(x1==30 && y1==285)
     {
      g.drawString("PP", 390, 300);
      g.drawString(starter.getNormalAttack().getRatio(), 440, 300);
      g.drawString("TYPE/NORMAL",375, 335);
     }else if(x1==30 && y1==325)
     {
      g.drawString("PP", 390, 300);
      g.drawString(starter.getSpecialAttack().getRatio(), 440, 300);
      g.drawString("TYPE/SPECIAL",370, 335);
     }else
     {
      g.drawString("PP", 390, 300);
      g.drawString("-", 440, 300);
      g.drawString("TYPE/HEAL",385, 335);
     }
     g.drawImage(arrow, x1, y1, this);
    }else if(x==(280+160) && y==282)
    {
     setSize(480, 350);
     g.drawImage(bag, 5, 25, this);
     g.setFont(font2);
     g.drawString("ITEMS", 50, 75);
     g.setFont(font1);
     g.drawString("CLOSE BAG", 225, 75);
     g.drawString(full.getType().toUpperCase(), 225, 95);
     g.drawString(heal.getType().toUpperCase(), 225, 115);
     g.drawString(power.getType().toUpperCase(), 225, 135);
     if(full.getUsed()==true)
     {
      g.drawString("(USED)", 350, 95);
     }
     if(heal.getUsed()==true)
     {
      g.drawString("(USED)", 350, 115);
     }
     if(power.getUsed()==true)
     {
      g.drawString("(USED)", 350, 135);
     }
     g.drawImage(arrow, xbag, ybag, this);
     if(ybag==60)
     {
      g.drawString("RETURNS TO MENU", 100, 280);
     }else if(ybag==80 && full.getUsed()==false)
     {
      g.drawImage(full.getImage(), 25, 259, this);
      g.drawString(full.getDescription(), 100, 280);
     }else if(ybag==100 && heal.getUsed()==false)
     {
      g.drawImage(heal.getImage(), 25, 259, this);
      g.drawString(heal.getDescription(), 100, 280);
     }else if(ybag==120 && power.getUsed()==false)
     {
      g.drawImage(power.getImage(), 25, 259, this);
      g.drawString(power.getDescription(), 100, 280);
     }
    }else if(x==280 && y==(282+40))
    {
     setSize(485, 380);
     g.drawImage(pokemonScreen, 0, 25, this);
     g.setFont(font2);
     g.drawString("RETURN TO MENU", 100, 110);
     g.drawString(pokemon1.getName().toUpperCase(), 100, 140);
     g.drawString(pokemon2.getName().toUpperCase(), 100, 170);
     g.drawString(pokemon3.getName().toUpperCase(), 100, 200);
     g.drawImage(arrow, xpoke, ypoke, this);
     if(ypoke==120)
     {
      g.drawImage(pokemon1.getFront().getImage(), 0, 250, this);
      g.drawImage(pokemon1.getFront().getImage(), 100, 250, this);
      g.drawImage(pokemon1.getFront().getImage(), 200, 250, this);
      g.drawImage(pokemon1.getFront().getImage(), 300, 250, this);
      g.drawImage(pokemon1.getFront().getImage(), 400, 250, this);
     }else if(ypoke==150)
     {
      g.drawImage(pokemon2.getFront().getImage(), 0, 250, this);
      g.drawImage(pokemon2.getFront().getImage(), 100, 250, this);
      g.drawImage(pokemon2.getFront().getImage(), 200, 250, this);
      g.drawImage(pokemon2.getFront().getImage(), 300, 250, this);
      g.drawImage(pokemon2.getFront().getImage(), 400, 250, this);
     }else if(ypoke==180)
     {
      g.drawImage(pokemon3.getFront().getImage(), 0, 250, this);
      g.drawImage(pokemon3.getFront().getImage(), 100, 250, this);
      g.drawImage(pokemon3.getFront().getImage(), 200, 250, this);
      g.drawImage(pokemon3.getFront().getImage(), 300, 250, this);
      g.drawImage(pokemon3.getFront().getImage(), 400, 250, this);
     }
    }else
    {
     fieldx=220;
     fieldy=120;
     enter=-1;
    }
   }else if(enter==2)
   {
    if(x==(280+160) && y==282)
    {
     if(ybag==80 && full.getUsed()==false)
     {
      full.setUsed(true);
      rectXP=111;
     }else if(ybag==100 && heal.getUsed()==false)
     {
      heal.setUsed(true);
      if(rectXP+40<=111)
      {
       rectXP+=40;
      }else
      {
       rectXP=111;
      }
     }else if(ybag==120 && power.getUsed()==false)
     {
      power.setUsed(true);
      power.usePotion(starter);
     }
     enter=0;
    }else if(x==280 && y==(282+40))
    {
     if(starter.getName().equalsIgnoreCase(pokemon1.getName()))
     {
      pokemon1.setHealth((int)(rectXP*pokemon1.getOriginalHp())/111);
     }else if(starter.getName().equalsIgnoreCase(pokemon2.getName()))
     {
      pokemon2.setHealth((int)(rectXP*pokemon2.getOriginalHp())/111);
     }else if(starter.getName().equalsIgnoreCase(pokemon3.getName()))
     {
      pokemon3.setHealth((int)(rectXP*pokemon3.getOriginalHp())/111);
     }
     if(ypoke==90+30)
     {
      starter=pokemon1;
      rectXP=(pokemon1.getHealth()*111)/pokemon1.getOriginalHp();
     }else if(ypoke==90+60)
     {
      starter=pokemon2;
      rectXP=(pokemon2.getHealth()*111)/pokemon2.getOriginalHp();
     }else if(ypoke==90+90)
     {
      starter=pokemon3;
      rectXP=(pokemon3.getHealth()*111)/pokemon3.getOriginalHp();
     }
     enter=0;
    }
    if(turn.equals("player"))
    {
     g.setColor(Color.WHITE);
     if(x1==30 && y1==285)
     {
      if(starter.getNormalAttack().getAttack()==0)
      {
       g.drawString(starter.getName().toUpperCase()+" missed!", 50, 315);
      }else
      {
       g.drawString(starter.getNormalAttack().getAttackName()+" was effective", 50, 315);
      }
     }else if(y1==325)
     {
      if(starter.getSpecialAttack().getAttack()==0)
      {
       g.drawString(starter.getName().toUpperCase()+" missed!", 50, 315);
      }else
      {
       g.drawString(starter.getSpecialAttack().getAttackName()+" was  very effective", 50, 315);
      }
     }else if(x1==255)
     {
      g.drawString(starter.getName().toUpperCase()+" use heal", 50, 315);
     }
     g.setColor(Color.BLACK);
    }
   }else if(enter==3)
   {
    g.setColor(Color.WHITE);
    switch(attack)
    {
    case 1:
     if(originPhp==rectXP)
     {
      g.drawString(starterCPU.getName().toUpperCase()+" used "+starterCPU.getNormalAttack().getAttackName(), 50, 300);
      g.drawString(starterCPU.getName().toUpperCase()+" missed!", 50, 335);
     }else
     {
      g.drawString(starterCPU.getName().toUpperCase()+" used "+starterCPU.getNormalAttack().getAttackName(), 50, 315);
     }
     break;
    case 2:
     g.drawString(starterCPU.getName().toUpperCase()+" used "+starterCPU.getSpecialAttack().getAttackName(), 50, 315);
     break;
    default:
     g.drawString(starterCPU.getName().toUpperCase()+" used Heal", 50, 315);
     break;
    }
    g.setColor(Color.BLACK); 
   }else if(enter==4)
   {
    enter=0;
    turn="player";
    attack=(int)(Math.random()*3+1);
   }
   if(enter==0 || (enter==1 && x==280 && y==282) || (enter==2 && x==280 && y==282) || (enter==3 && x==280 && y==282))
   {
    g.drawImage(starterCPU.getFront().getImage(), 350, 50, this);
    g.drawImage(starter.getBack().getImage(), 100, 162, this);
    g.setFont(font1);
    g.drawString(starter.getName().toUpperCase(), 330, 195);
    g.drawString(starterCPU.getName().toUpperCase(), 45, 63);
    g.setFont(font);
    g.drawString((int)(((rectXP*starter.getOriginalHp())/111))+"/"+starter.getOriginalHp(), 405, 235);
    g.drawString(starter.getLvl()+"", 493, 197);
    g.drawString(starterCPU.getLvl()+"", 208, 65);
   }
   repaint();
  }
 public static void main(String[]args)
 {
  PokemonMonster first = new PokemonMonster("bulbasaur");
  PokemonMonster second= new PokemonMonster("charmander");
  new FightingArena(first, second);
 }
}