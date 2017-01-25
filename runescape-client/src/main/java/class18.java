import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class18 extends Node {
   @ObfuscatedName("x")
   String field202;
   @ObfuscatedName("c")
   boolean field203;
   @ObfuscatedName("f")
   Widget field204;
   @ObfuscatedName("s")
   Object[] field205;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1101317389
   )
   int field206;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 953007239
   )
   int field207;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 655829589
   )
   int field208;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 146478053
   )
   int field209;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1018553603
   )
   int field212;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1508428439
   )
   int field214;
   @ObfuscatedName("k")
   Widget field216;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1271816264"
   )
   public static void method160() {
      class190.field2807.reset();
      class190.field2798.reset();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1819918279"
   )
   static void method161(int var0) {
      if(var0 == -3) {
         class1.method8("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class1.method8("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class1.method8("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         class1.method8("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class1.method8("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class1.method8("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class1.method8("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class1.method8("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class1.method8("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class1.method8("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class1.method8("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class1.method8("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class1.method8("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class1.method8("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class1.method8("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class1.method8("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class1.method8("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class1.method8("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class1.method8("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class1.method8("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class1.method8("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class1.method8("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class1.method8("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class1.method8("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class1.method8("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class1.method8("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class1.method8("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class1.method8("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class1.method8("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class1.method8("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class1.method8("Enter the 6-digit code generated by your", "authenticator app.", "");
            class103.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class1.method8("The code you entered was incorrect.", "Please try again.", "");
            class103.setGameState(11);
            return;
         }

         class1.method8("Unexpected server response", "Please try using a different world.", "");
      }

      class103.setGameState(10);
   }

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "344030935"
   )
   static final void method162(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field415 == 1) && Client.friendCount < 400) {
            String var1 = class137.method2397(var0, class1.field15);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class137.method2397(var3.name, class1.field15);
                  if(null != var4 && var4.equals(var1)) {
                     Player.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(null != var3.previousName) {
                     var5 = class137.method2397(var3.previousName, class1.field15);
                     if(var5 != null && var5.equals(var1)) {
                        Player.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var8 = Client.ignores[var2];
                  var4 = class137.method2397(var8.name, class1.field15);
                  if(null != var4 && var4.equals(var1)) {
                     Player.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var8.previousName != null) {
                     var5 = class137.method2397(var8.previousName, class1.field15);
                     if(var5 != null && var5.equals(var1)) {
                        Player.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class137.method2397(XItemContainer.localPlayer.name, class1.field15).equals(var1)) {
                  Player.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.field336.method2963(81);
                  class159 var6 = Client.field336;
                  int var7 = var0.length() + 1;
                  var6.method2708(var7);
                  Client.field336.method2714(var0);
               }
            }
         } else {
            Player.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)I",
      garbageValue = "-1014784234"
   )
   static int method163(class159 var0) {
      int var1 = var0.method2973(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2973(5);
      } else if(var1 == 2) {
         var2 = var0.method2973(8);
      } else {
         var2 = var0.method2973(11);
      }

      return var2;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1360050671"
   )
   static final void method164(Actor var0) {
      if(Client.gameCycle == var0.field651 || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field638 + 1 > class110.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field651 - var0.field661;
         int var2 = Client.gameCycle - var0.field661;
         int var3 = var0.field645 * 64 + var0.field606 * 128;
         int var4 = var0.field645 * 64 + var0.field650 * 128;
         int var5 = var0.field657 * 128 + var0.field645 * 64;
         int var6 = var0.field620 * 128 + var0.field645 * 64;
         var0.x = ((var1 - var2) * var3 + var5 * var2) / var1;
         var0.y = (var4 * (var1 - var2) + var2 * var6) / var1;
      }

      var0.field647 = 0;
      var0.field655 = var0.field652;
      var0.angle = var0.field655;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "2"
   )
   static int method165(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2098[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
