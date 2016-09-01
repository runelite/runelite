import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public abstract class class110 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 214350509
   )
   static int field1938;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1334562985
   )
   public int field1939;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -534554047
   )
   public int field1940;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1757876947
   )
   public int field1943;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -980587581
   )
   static int field1944;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 514978509
   )
   public int field1945;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "6"
   )
   static void method2438(int var0) {
      if(var0 == -3) {
         class20.method546("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class20.method546("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class20.method546("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class33.loginIndex = 3;
      } else if(var0 == 4) {
         class20.method546("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class20.method546("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class20.method546("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class20.method546("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class20.method546("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class20.method546("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class20.method546("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class20.method546("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class20.method546("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class20.method546("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class20.method546("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class20.method546("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class20.method546("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class20.method546("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class20.method546("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class20.method546("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class20.method546("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class20.method546("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class20.method546("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class20.method546("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class20.method546("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class20.method546("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class20.method546("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class20.method546("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class20.method546("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class20.method546("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class20.method546("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class20.method546("Enter the 6-digit code generated by your", "authenticator app.", "");
            class130.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class20.method546("The code you entered was incorrect.", "Please try again.", "");
            class130.setGameState(11);
            return;
         }

         class20.method546("Unexpected server response", "Please try using a different world.", "");
      }

      class130.setGameState(10);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "31"
   )
   protected abstract boolean vmethod2439(int var1, int var2, int var3, CollisionData var4);
}
