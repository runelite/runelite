import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class164 extends CacheableNode {
   @ObfuscatedName("i")
   public final int[] field2145;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2088510515
   )
   public final int field2146;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1871909867
   )
   public final int field2148;
   @ObfuscatedName("t")
   public final int[] field2149;
   @ObfuscatedName("ef")
   static SpritePixels[] field2152;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-579462835"
   )
   public boolean method3211(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2149.length) {
         int var3 = this.field2149[var2];
         if(var1 >= var3 && var1 <= this.field2145[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-985659097"
   )
   static void method3212(int var0) {
      if(var0 == -3) {
         class108.method2095("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class108.method2095("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class108.method2095("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         class108.method2095("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class108.method2095("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class108.method2095("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class108.method2095("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class108.method2095("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class108.method2095("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class108.method2095("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class108.method2095("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class108.method2095("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class108.method2095("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class108.method2095("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class108.method2095("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class108.method2095("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class108.method2095("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class108.method2095("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class108.method2095("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class108.method2095("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class108.method2095("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class108.method2095("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class108.method2095("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class108.method2095("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class108.method2095("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class108.method2095("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class108.method2095("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class108.method2095("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class108.method2095("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class108.method2095("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class108.method2095("Enter the 6-digit code generated by your", "authenticator app.", "");
            GameObject.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class108.method2095("The code you entered was incorrect.", "Please try again.", "");
            GameObject.setGameState(11);
            return;
         }

         class108.method2095("Unexpected server response", "Please try using a different world.", "");
      }

      GameObject.setGameState(10);
   }

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2148 = var1;
      this.field2146 = var2;
      this.field2145 = var3;
      this.field2149 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IZIB)V",
      garbageValue = "-73"
   )
   public static final void method3214(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class202.field3079 = var0;
         class57.field1032 = var1;
         class57.field1025 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-1247795607"
   )
   public static void method3215(class182 var0) {
      class187.field2770 = var0;
      class187.field2768 = class187.field2770.method3398(16);
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1062845562"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class47.method945(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "1934573739"
   )
   public static ModIcon[] method3217(class182 var0, String var1, String var2) {
      int var3 = var0.method3363(var1);
      int var4 = var0.method3407(var3, var2);
      ModIcon[] var5;
      if(!class185.method3467(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = CombatInfoListHolder.method776();
      }

      return var5;
   }
}
