import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class23 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1353011367
   )
   int field589;
   @ObfuscatedName("f")
   int[] field591;
   @ObfuscatedName("c")
   String[] field592;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -293982771
   )
   int field593;
   @ObfuscatedName("a")
   static int[] field594;
   @ObfuscatedName("k")
   static NodeCache field595 = new NodeCache(128);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1917623685
   )
   int field596;
   @ObfuscatedName("q")
   int[] field597;
   @ObfuscatedName("af")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 536801755
   )
   int field600;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1206439097"
   )
   static void method587(int var0) {
      if(var0 == -3) {
         class51.method1075("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class51.method1075("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class51.method1075("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class33.loginIndex = 3;
      } else if(var0 == 4) {
         class51.method1075("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class51.method1075("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class51.method1075("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class51.method1075("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class51.method1075("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class51.method1075("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class51.method1075("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class51.method1075("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class51.method1075("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class51.method1075("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class51.method1075("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class51.method1075("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class51.method1075("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class51.method1075("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class51.method1075("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class51.method1075("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class51.method1075("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class51.method1075("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class51.method1075("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class51.method1075("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class51.method1075("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class51.method1075("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class51.method1075("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class51.method1075("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class51.method1075("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class51.method1075("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class51.method1075("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class51.method1075("Enter the 6-digit code generated by your", "authenticator app.", "");
            class127.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class51.method1075("The code you entered was incorrect.", "Please try again.", "");
            class127.setGameState(11);
            return;
         }

         class51.method1075("Unexpected server response", "Please try using a different world.", "");
      }

      class127.setGameState(10);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "688440447"
   )
   static void method590() {
      Client.field324.method2828(136);
      class125 var0 = Client.field324;
      int var1 = Client.isResized?2:1;
      var0.method2556(var1);
      Client.field324.method2638(GroundObject.field1652);
      Client.field324.method2638(VertexNormal.field1689);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "-38"
   )
   public static int method591(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;B)V",
      garbageValue = "0"
   )
   static final void method592(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class94.field1650[var7];
         int var9 = class94.field1651[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = 256 * var9 / (Client.mapScaleDelta + 256);
         int var10 = var8 * var3 + var9 * var2 >> 16;
         int var11 = var9 * var3 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class28.field678.method1741(var14 + 94 + var0 + 4 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class31.method687(var0, var1, var2, var3, var4, var5);
      }

   }
}
