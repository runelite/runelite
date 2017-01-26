import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class1 {
   @ObfuscatedName("x")
   public static Comparator field8;
   @ObfuscatedName("q")
   public static Comparator field9;
   @ObfuscatedName("d")
   public static Comparator field10;
   @ObfuscatedName("p")
   public final List field11;
   @ObfuscatedName("az")
   static class184 field12;
   @ObfuscatedName("g")
   public static Comparator field13 = new class7();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-82192419"
   )
   public void method16(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field11, var1);
      } else {
         Collections.sort(this.field11, Collections.reverseOrder(var1));
      }

   }

   static {
      new class0();
      field8 = new class5();
      field9 = new class6();
      field10 = new class3();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "22465"
   )
   public static void method17() {
      PlayerComposition.field2166.reset();
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field11 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field11.add(new class2(var1, var5, var3));
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "322286063"
   )
   static void method19(int var0) {
      if(var0 == -3) {
         MessageNode.method204("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         MessageNode.method204("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         MessageNode.method204("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         MessageNode.method204("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         MessageNode.method204("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         MessageNode.method204("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         MessageNode.method204("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         MessageNode.method204("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         MessageNode.method204("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         MessageNode.method204("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         MessageNode.method204("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         MessageNode.method204("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         MessageNode.method204("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         MessageNode.method204("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         MessageNode.method204("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         MessageNode.method204("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         MessageNode.method204("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         MessageNode.method204("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         MessageNode.method204("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         MessageNode.method204("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         MessageNode.method204("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         MessageNode.method204("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         MessageNode.method204("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         MessageNode.method204("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         MessageNode.method204("", "Service unavailable.", "");
      } else if(var0 == 31) {
         MessageNode.method204("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         MessageNode.method204("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         MessageNode.method204("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         MessageNode.method204("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         MessageNode.method204("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            MessageNode.method204("Enter the 6-digit code generated by your", "authenticator app.", "");
            class212.setGameState(11);
            return;
         }

         if(var0 == 57) {
            MessageNode.method204("The code you entered was incorrect.", "Please try again.", "");
            class212.setGameState(11);
            return;
         }

         MessageNode.method204("Unexpected server response", "Please try using a different world.", "");
      }

      class212.setGameState(10);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-54"
   )
   public static void method20() {
      while(true) {
         Deque var1 = class183.field2727;
         class180 var0;
         synchronized(class183.field2727) {
            var0 = (class180)class183.field2720.method2422();
         }

         if(null == var0) {
            return;
         }

         var0.field2689.method3366(var0.field2690, (int)var0.hash, var0.field2693, false);
      }
   }
}
