package wordadvgame;
import java.util.*;

public class WordAdvGame {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Random rand = new Random();                 //comes with util package like Scanner
       
       //Game variables
       String[] enemies = {"Skeleton","Zombie","Evil Warrior","Assassin"};
       int maxEnemyHealth = 75;
       int enemyAttackDamage = 25;
       
       //Player variable
       int health = 100;
       int attackDamage = 45;
       int numHealthPotions = 5;
       int healthPotionHealAmount = 30;
       int healthPotionDropChance = 50;    //percent chance
       
       boolean running = true;
       
       System.out.println("Welcome to the Dungeon!");
       
       GAME:
       while(running){
           System.out.println("-----------------------------------------------------");
           
           int enemyHealth = rand.nextInt(maxEnemyHealth);
           String enemy = enemies[rand.nextInt(enemies.length)];
           System.out.println("\t# " + enemy + "has appeared! #\n");
           
           while(enemyHealth > 0){
               System.out.println("\tYour HP: " + health);
               System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
               System.out.println("\n\tWhat would you like to do now?");
               System.out.println("\t1.Attack");
               System.out.println("\t2.Drink Health Potion");
               System.out.println("\t3.Run");
               
               String input = in.nextLine();
               if(input.equals("1")){
                   int damageDealt = rand.nextInt(attackDamage);
                   int damageTaken = rand.nextInt(enemyAttackDamage);
                   
                   enemyHealth -= damageDealt;
                   health -= damageTaken;
                   
                   System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage");
                   System.out.println("\t> Enemy striked you with " + damageTaken + " damage in return");
                   
                   if(health < 1)
                   {
                       System.out.println("You have taken too much damage. You cannot proceed as you are too weak to go on!");
                       break;
                   }
               }
               else if(input.equals("2")){
                   if(numHealthPotions > 0)
                   {
                       health += healthPotionHealAmount;
                       numHealthPotions--;
                       System.out.println("You drank the health potion. Health recovered: " + healthPotionHealAmount + "!" 
                               + "\n\t>You now have " + health + " HP"
                               + "\n\t>You have " + numHealthPotions + "health potions left.\n");
                   }
                   else
                   {
                       System.out.println("You have no health potions left! Defeat an enemy for a chance to obtain health potion!!");
                   }
               }
               else if(input.equals("3")){
                   System.out.println("You ran away from " + enemy);
                   continue GAME;
                   
               }
               else{
                   System.out.println("\tInvalid Input!");
               }
           }
           if(health < 1)
           {
               System.out.println("You limp out the dungeon because you were very weak after battle");
               break;
           }
           System.out.println("-----------------------------------------------------");
           System.out.println(" # " + enemy + "was defeated! ");
           System.out.println(" # You have " + health + "HP left #");
           if(rand.nextInt(100) < healthPotionDropChance)
           {
               numHealthPotions++;
               System.out.println("# The " + enemy + " dropped a health potion! #");
               System.out.println("# You now have " + numHealthPotions + " health potion(s) #");
           }
           System.out.println("-----------------------------------------------------");
           System.out.println("What would you like to do now?");
           System.out.println("1. Continue Fighting");
           System.out.println("2. Exit Dungeon");
           
           String input = in.nextLine();
           while(!input.equals("1") && !input.equals("2")){
               System.out.println("Invalid Command!");
               input=in.nextLine();
           }
           if(input.equals("1")){
               System.out.println("You continue your adenture!");
           }
           else if(input.equals("2")){
               System.out.println("You exit the dungeon safely!");
               break;
           }
       }
       System.out.println("###########################");
       System.out.println("#    THANKS FOR PLAYING!  #");
       System.out.println("###########################");
    }
    
}
