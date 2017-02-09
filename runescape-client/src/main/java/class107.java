import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class107 {
   @ObfuscatedName("y")
   static File field1727;
   @ObfuscatedName("k")
   static boolean field1728 = false;
   @ObfuscatedName("o")
   static Hashtable field1729 = new Hashtable(16);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "115"
   )
   static void method2031(int var0) {
      if(var0 == -3) {
         PlayerComposition.method2762("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         PlayerComposition.method2762("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         PlayerComposition.method2762("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         PlayerComposition.method2762("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         PlayerComposition.method2762("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         PlayerComposition.method2762("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         PlayerComposition.method2762("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         PlayerComposition.method2762("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         PlayerComposition.method2762("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         PlayerComposition.method2762("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         PlayerComposition.method2762("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         PlayerComposition.method2762("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         PlayerComposition.method2762("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         PlayerComposition.method2762("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         PlayerComposition.method2762("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         PlayerComposition.method2762("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         PlayerComposition.method2762("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         PlayerComposition.method2762("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         PlayerComposition.method2762("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         PlayerComposition.method2762("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         PlayerComposition.method2762("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         PlayerComposition.method2762("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         PlayerComposition.method2762("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         PlayerComposition.method2762("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         PlayerComposition.method2762("", "Service unavailable.", "");
      } else if(var0 == 31) {
         PlayerComposition.method2762("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         PlayerComposition.method2762("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         PlayerComposition.method2762("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         PlayerComposition.method2762("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         PlayerComposition.method2762("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            PlayerComposition.method2762("Enter the 6-digit code generated by your", "authenticator app.", "");
            class11.setGameState(11);
            return;
         }

         if(var0 == 57) {
            PlayerComposition.method2762("The code you entered was incorrect.", "Please try again.", "");
            class11.setGameState(11);
            return;
         }

         PlayerComposition.method2762("Unexpected server response", "Please try using a different world.", "");
      }

      class11.setGameState(10);
   }

   class107() throws Throwable {
      throw new Error();
   }
}
