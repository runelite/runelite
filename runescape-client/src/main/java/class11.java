import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class11 {
   @ObfuscatedName("e")
   static final class201 field167 = new class201(1024);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 803651737
   )
   static int field169 = 0;
   @ObfuscatedName("f")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("n")
   static final class203 field174 = new class203();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-993395771"
   )
   public static boolean method136(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-51"
   )
   static void method138(int var0) {
      if(var0 == -3) {
         class59.method1273("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class59.method1273("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class59.method1273("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class33.loginIndex = 3;
      } else if(var0 == 4) {
         class59.method1273("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class59.method1273("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class59.method1273("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class59.method1273("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class59.method1273("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class59.method1273("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class59.method1273("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class59.method1273("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class59.method1273("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class59.method1273("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class59.method1273("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class59.method1273("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class59.method1273("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class59.method1273("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class59.method1273("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class59.method1273("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class59.method1273("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class59.method1273("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class59.method1273("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class59.method1273("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class59.method1273("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class59.method1273("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class59.method1273("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class59.method1273("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class59.method1273("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class59.method1273("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class59.method1273("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class59.method1273("Enter the 6-digit code generated by your", "authenticator app.", "");
            KitDefinition.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class59.method1273("The code you entered was incorrect.", "Please try again.", "");
            KitDefinition.setGameState(11);
            return;
         }

         class59.method1273("Unexpected server response", "Please try using a different world.", "");
      }

      KitDefinition.setGameState(10);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-538890176"
   )
   public static synchronized long method139() {
      long var0 = System.currentTimeMillis();
      if(var0 < class118.field2033) {
         class118.field2034 += class118.field2033 - var0;
      }

      class118.field2033 = var0;
      return class118.field2034 + var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1336"
   )
   public static void method140() {
      NPCComposition.field885.reset();
      NPCComposition.npcModelCache.reset();
   }
}
