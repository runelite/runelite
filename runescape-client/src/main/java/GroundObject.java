import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1289556679
   )
   int field1288;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 625875297
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 608308585
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 713006955
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 457027439
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("pf")
   static class116 field1294;

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1955183370"
   )
   static void method1506(int var0, int var1) {
      class38 var2 = class154.field2120;
      class109.menuAction(var2.field807, var2.field803, var2.field804, var2.field802, var2.field805, var2.field805, var0, var1);
      class154.field2120 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-90"
   )
   static void method1507(int var0) {
      if(var0 == -3) {
         class47.method861("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class47.method861("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class47.method861("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         class47.method861("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class47.method861("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class47.method861("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class47.method861("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class47.method861("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class47.method861("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class47.method861("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class47.method861("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class47.method861("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class47.method861("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class47.method861("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class47.method861("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class47.method861("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class47.method861("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class47.method861("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class47.method861("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class47.method861("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class47.method861("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class47.method861("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class47.method861("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class47.method861("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class47.method861("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class47.method861("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class47.method861("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class47.method861("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class47.method861("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class47.method861("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class47.method861("Enter the 6-digit code generated by your", "authenticator app.", "");
            class20.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class47.method861("The code you entered was incorrect.", "Please try again.", "");
            class20.setGameState(11);
            return;
         }

         class47.method861("Unexpected server response", "Please try using a different world.", "");
      }

      class20.setGameState(10);
   }
}
