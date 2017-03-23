import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class36 {
   @ObfuscatedName("o")
   static final BigInteger field784 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 1982946913
   )
   static int field786;
   @ObfuscatedName("bc")
   static ModIcon[] field789;
   @ObfuscatedName("pq")
   static short[] field794;
   @ObfuscatedName("au")
   static class102 field795;
   @ObfuscatedName("r")
   static final BigInteger field796 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1258546982"
   )
   static void method755(int var0) {
      if(var0 == -3) {
         class65.method1204("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class65.method1204("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class65.method1204("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         class65.method1204("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class65.method1204("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class65.method1204("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class65.method1204("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class65.method1204("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class65.method1204("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class65.method1204("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class65.method1204("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class65.method1204("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class65.method1204("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class65.method1204("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class65.method1204("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class65.method1204("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class65.method1204("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class65.method1204("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class65.method1204("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class65.method1204("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class65.method1204("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class65.method1204("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class65.method1204("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class65.method1204("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class65.method1204("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class65.method1204("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class65.method1204("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class65.method1204("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class65.method1204("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class65.method1204("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class65.method1204("Enter the 6-digit code generated by your", "authenticator app.", "");
            GameObject.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class65.method1204("The code you entered was incorrect.", "Please try again.", "");
            GameObject.setGameState(11);
            return;
         }

         class65.method1204("Unexpected server response", "Please try using a different world.", "");
      }

      GameObject.setGameState(10);
   }

   class36() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "27"
   )
   public static boolean method757(char var0) {
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         if(var0 != 0) {
            char[] var1 = class203.field3083;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
