import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public final class class29 {
   @ObfuscatedName("i")
   static byte[][][] field403;
   @ObfuscatedName("cv")
   @Export("middleMouseMovesCamera")
   static boolean middleMouseMovesCamera;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1743649979
   )
   int field401;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -824069623
   )
   int field404;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 772933467
   )
   int field402;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1887606341
   )
   int field400;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   final class41 this$0;

   @ObfuscatedSignature(
      signature = "(Laz;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIS)Lbx;",
      garbageValue = "255"
   )
   static MessageNode method244(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class94.chatLineMap.get(Integer.valueOf(var0));
      return var2.getMessage(var1);
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2044259215"
   )
   static void method242(int var0) {
      if(var0 == -3) {
         class47.method679("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class47.method679("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class47.method679("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class89.loginIndex = 3;
      } else if(var0 == 4) {
         class47.method679("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class47.method679("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class47.method679("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class47.method679("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class47.method679("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class47.method679("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class47.method679("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class47.method679("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class47.method679("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class47.method679("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class47.method679("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class47.method679("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class47.method679("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class47.method679("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class47.method679("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class47.method679("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class47.method679("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class47.method679("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class47.method679("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class47.method679("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class47.method679("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class47.method679("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class47.method679("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class47.method679("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class47.method679("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class47.method679("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class47.method679("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class47.method679("Enter the 6-digit code generated by your", "authenticator app.", "");
            class87.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class47.method679("The code you entered was incorrect.", "Please try again.", "");
            class87.setGameState(11);
            return;
         }

         class47.method679("Unexpected server response", "Please try using a different world.", "");
      }

      class87.setGameState(10);
   }

   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "(Lhs;IS)Ljava/lang/String;",
      garbageValue = "-12910"
   )
   static String method243(Widget var0, int var1) {
      int var3 = WorldComparator.getWidgetConfig(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2846 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
