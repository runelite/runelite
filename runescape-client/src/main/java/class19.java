import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class19 implements Comparator {
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;B)I",
      garbageValue = "-78"
   )
   int method157(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field278 < var2.field278?-1:(var2.field278 == var1.field278?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method157((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "2111948654"
   )
   static int method158(int var0, Script var1, boolean var2) {
      Widget var3 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
      if(var0 == 2500) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1143133677"
   )
   static void method168(int var0) {
      if(var0 == -3) {
         class33.method385("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class33.method385("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class33.method385("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class90.loginIndex = 3;
      } else if(var0 == 4) {
         class33.method385("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class33.method385("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class33.method385("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class33.method385("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class33.method385("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class33.method385("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class33.method385("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class33.method385("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class33.method385("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class33.method385("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class33.method385("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class33.method385("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class33.method385("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class33.method385("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class33.method385("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class33.method385("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class33.method385("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class33.method385("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class33.method385("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class33.method385("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class33.method385("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class33.method385("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class33.method385("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class33.method385("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class33.method385("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class33.method385("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class33.method385("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class33.method385("Enter the 6-digit code generated by your", "authenticator app.", "");
            MapIconReference.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class33.method385("The code you entered was incorrect.", "Please try again.", "");
            MapIconReference.setGameState(11);
            return;
         }

         class33.method385("Unexpected server response", "Please try using a different world.", "");
      }

      MapIconReference.setGameState(10);
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1636068339"
   )
   static void method166() {
      if(Client.field982 >= 0 && Client.cachedPlayers[Client.field982] != null) {
         class37.method523(Client.cachedPlayers[Client.field982], false);
      }

   }
}
