import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("dk")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("n")
   Component field1757;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 1398172771
   )
   static int field1758;

   public final void paint(Graphics var1) {
      this.field1757.paint(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1981967192"
   )
   public static boolean method2124(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   RSCanvas(Component var1) {
      this.field1757 = var1;
   }

   public final void update(Graphics var1) {
      this.field1757.update(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "48"
   )
   static void method2130(int var0) {
      if(var0 == -3) {
         class3.method44("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class3.method44("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class3.method44("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         class3.method44("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class3.method44("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class3.method44("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class3.method44("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class3.method44("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class3.method44("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class3.method44("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class3.method44("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class3.method44("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class3.method44("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class3.method44("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class3.method44("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class3.method44("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class3.method44("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class3.method44("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class3.method44("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class3.method44("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class3.method44("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class3.method44("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class3.method44("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class3.method44("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class3.method44("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class3.method44("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class3.method44("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class3.method44("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class3.method44("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class3.method44("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class3.method44("Enter the 6-digit code generated by your", "authenticator app.", "");
            class186.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class3.method44("The code you entered was incorrect.", "Please try again.", "");
            class186.setGameState(11);
            return;
         }

         class3.method44("Unexpected server response", "Please try using a different world.", "");
      }

      class186.setGameState(10);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-382"
   )
   public static void method2131() {
      class193.field2833.reset();
      class193.field2831.reset();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-288926594"
   )
   public static int method2132(String var0) {
      return var0.length() + 1;
   }
}
