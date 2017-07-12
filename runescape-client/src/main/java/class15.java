import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class15 implements Comparator {
   @ObfuscatedName("i")
   static IndexDataBase field298;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2048602787
   )
   static int field294;
   @ObfuscatedName("rs")
   static short[] field296;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;B)I",
      garbageValue = "-74"
   )
   int method83(class14 var1, class14 var2) {
      return var1.field285.totalQuantity < var2.field285.totalQuantity?-1:(var2.field285.totalQuantity == var1.field285.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method83((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1542283489"
   )
   static void method86(int var0) {
      if(var0 == -3) {
         class13.method64("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class13.method64("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class13.method64("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class92.loginIndex = 3;
      } else if(var0 == 4) {
         class13.method64("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class13.method64("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class13.method64("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class13.method64("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class13.method64("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class13.method64("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class13.method64("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class13.method64("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class13.method64("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class13.method64("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class13.method64("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class13.method64("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class13.method64("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class13.method64("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class13.method64("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class13.method64("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class13.method64("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class13.method64("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class13.method64("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class13.method64("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class13.method64("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class13.method64("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class13.method64("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class13.method64("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class13.method64("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class13.method64("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class13.method64("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class13.method64("Enter the 6-digit code generated by your", "authenticator app.", "");
            TextureProvider.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class13.method64("The code you entered was incorrect.", "Please try again.", "");
            TextureProvider.setGameState(11);
            return;
         }

         class13.method64("Unexpected server response", "Please try using a different world.", "");
      }

      TextureProvider.setGameState(10);
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "3"
   )
   static final void method79(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class3.method10(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1223 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
