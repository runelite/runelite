import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
public enum class257 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3548(0, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3545(2, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3546(1, 2);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1595229445
   )
   final int field3544;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2049754605
   )
   public final int field3547;

   class257(int var3, int var4) {
      this.field3547 = var3;
      this.field3544 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field3544;
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "766856180"
   )
   static void method4723(int var0) {
      if(var0 == -3) {
         class36.method481("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class36.method481("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class36.method481("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class90.loginIndex = 3;
      } else if(var0 == 4) {
         class36.method481("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class36.method481("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class36.method481("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class36.method481("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class36.method481("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class36.method481("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class36.method481("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class36.method481("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class36.method481("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class36.method481("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class36.method481("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class36.method481("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class36.method481("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class36.method481("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class36.method481("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class36.method481("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class36.method481("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class36.method481("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class36.method481("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class36.method481("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class36.method481("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class36.method481("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class36.method481("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class36.method481("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class36.method481("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class36.method481("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class36.method481("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class36.method481("Enter the 6-digit code generated by your", "authenticator app.", "");
            class72.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class36.method481("The code you entered was incorrect.", "Please try again.", "");
            class72.setGameState(11);
            return;
         }

         class36.method481("Unexpected server response", "Please try using a different world.", "");
      }

      class72.setGameState(10);
   }
}
