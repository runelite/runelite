import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class152 implements class112 {
   @ObfuscatedName("h")
   static final class152 field2246 = new class152(1, 0, true, true, true);
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 210286181
   )
   static int field2247;
   @ObfuscatedName("z")
   static final class152 field2248 = new class152(3, 2, false, false, true);
   @ObfuscatedName("m")
   static final class152 field2249 = new class152(2, 1, true, true, false);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1558489145
   )
   final int field2250;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 966653425
   )
   public final int field2251;
   @ObfuscatedName("c")
   public final boolean field2252;
   @ObfuscatedName("n")
   public final boolean field2253;
   @ObfuscatedName("j")
   static final class152 field2254 = new class152(0, -1, true, false, true);
   @ObfuscatedName("x")
   static final class152 field2256 = new class152(4, 3, false, false, true);

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "0"
   )
   class152(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2250 = var1;
      this.field2251 = var2;
      this.field2252 = var4;
      this.field2253 = var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "23"
   )
   public int vmethod3136() {
      return this.field2250;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1971485799"
   )
   static void method3122(int var0) {
      if(var0 == -3) {
         class114.method2436("Connection timed out.", "Please try using a different world.", "");
      } else if(-2 == var0) {
         class114.method2436("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class114.method2436("No response from server.", "Please try using a different world.", "");
      } else if(3 == var0) {
         class31.field712 = 3;
      } else if(4 == var0) {
         class114.method2436("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class114.method2436("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(6 == var0) {
         class114.method2436("RuneScape has been updated!", "Please reload this page.", "");
      } else if(7 == var0) {
         class114.method2436("This world is full.", "Please use a different world.", "");
      } else if(8 == var0) {
         class114.method2436("Unable to connect.", "Login server offline.", "");
      } else if(9 == var0) {
         class114.method2436("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(10 == var0) {
         class114.method2436("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class114.method2436("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class114.method2436("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class114.method2436("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class114.method2436("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class114.method2436("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(17 == var0) {
         class114.method2436("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(18 == var0) {
         class114.method2436("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(19 == var0) {
         class114.method2436("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class114.method2436("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(22 == var0) {
         class114.method2436("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class114.method2436("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class114.method2436("Error loading your profile.", "Please contact customer support.", "");
      } else if(25 == var0) {
         class114.method2436("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class114.method2436("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class114.method2436("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class114.method2436("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(32 == var0) {
         class114.method2436("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class114.method2436("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(38 == var0) {
         class114.method2436("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(55 == var0) {
         class114.method2436("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(56 == var0) {
            class114.method2436("Enter the 6-digit code generated by your", "authenticator app.", "");
            class13.method162(11);
            return;
         }

         if(var0 == 57) {
            class114.method2436("The code you entered was incorrect.", "Please try again.", "");
            class13.method162(11);
            return;
         }

         class114.method2436("Unexpected server response", "Please try using a different world.", "");
      }

      class13.method162(10);
   }
}
