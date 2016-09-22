import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1128006963
   )
   @Export("width")
   public int width;
   @ObfuscatedName("t")
   @Export("image")
   public Image image;
   @ObfuscatedName("v")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -926978739
   )
   @Export("height")
   int height;
   @ObfuscatedName("co")
   static class146 field1475;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "-581029777"
   )
   public static boolean method1715(CharSequence var0) {
      return FrameMap.method2303(var0, 10, true);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1412575018"
   )
   public final void method1716() {
      class82.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "138016631"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "1"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-557590795"
   )
   abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "50"
   )
   static void method1729(int var0) {
      if(var0 == -3) {
         class192.method3774("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class192.method3774("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class192.method3774("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class33.loginIndex = 3;
      } else if(var0 == 4) {
         class192.method3774("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class192.method3774("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class192.method3774("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class192.method3774("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class192.method3774("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class192.method3774("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class192.method3774("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class192.method3774("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class192.method3774("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class192.method3774("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class192.method3774("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class192.method3774("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class192.method3774("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class192.method3774("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class192.method3774("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class192.method3774("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class192.method3774("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class192.method3774("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class192.method3774("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class192.method3774("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class192.method3774("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class192.method3774("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class192.method3774("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class192.method3774("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class192.method3774("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class192.method3774("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class192.method3774("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class192.method3774("Enter the 6-digit code generated by your", "authenticator app.", "");
            XItemContainer.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class192.method3774("The code you entered was incorrect.", "Please try again.", "");
            XItemContainer.setGameState(11);
            return;
         }

         class192.method3774("Unexpected server response", "Please try using a different world.", "");
      }

      XItemContainer.setGameState(10);
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "57"
   )
   static final void method1731(int var0) {
      if(class93.method2114(var0)) {
         class75.method1621(Widget.widgets[var0], -1);
      }
   }
}
