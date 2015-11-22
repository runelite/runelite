package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aa")
public class class26 {
   @ObfuscatedName("s")
   static void method675(class25 var0) {
      if(var0.method660() != client.field281) {
         client.field281 = var0.method660();
         boolean var1 = var0.method660();
         if(var1 != class102.field1750) {
            class20.method593();
            class102.field1750 = var1;
         }
      }

      class41.field959 = var0.field624;
      client.field421 = var0.field621;
      client.field277 = var0.field622;
      class10.field164 = client.field279 == 0?'ꩊ':var0.field621 + '鱀';
      class120.field1989 = 0 == client.field279?443:var0.field621 + '썐';
      class15.field219 = class10.field164;
   }

   @ObfuscatedName("n")
   static void method676(int var0) {
      if(var0 == -3) {
         class9.method143("Connection timed out.", "Please try using a different world.", "");
      } else if(-2 == var0) {
         class9.method143("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class9.method143("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class9.method143("", "Invalid username/email or password.", "");
      } else if(4 == var0) {
         class9.method143("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(5 == var0) {
         class9.method143("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(6 == var0) {
         class9.method143("RuneScape has been updated!", "Please reload this page.", "");
      } else if(7 == var0) {
         class9.method143("This world is full.", "Please use a different world.", "");
      } else if(8 == var0) {
         class9.method143("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class9.method143("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(10 == var0) {
         class9.method143("Unable to connect.", "Bad session id.", "");
      } else if(11 == var0) {
         class9.method143("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(12 == var0) {
         class9.method143("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class9.method143("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class9.method143("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(16 == var0) {
         class9.method143("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(17 == var0) {
         class9.method143("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class9.method143("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class9.method143("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class9.method143("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class9.method143("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class9.method143("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(24 == var0) {
         class9.method143("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class9.method143("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class9.method143("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(27 == var0) {
         class9.method143("", "Service unavailable.", "");
      } else if(31 == var0) {
         class9.method143("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class9.method143("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(37 == var0) {
         class9.method143("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class9.method143("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class9.method143("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(56 == var0) {
            class9.method143("Enter the 6-digit code generated by your", "authenticator app.", "");
            class31.method714(11);
            return;
         }

         if(57 == var0) {
            class9.method143("The code you entered was incorrect.", "Please try again.", "");
            class31.method714(11);
            return;
         }

         class9.method143("Unexpected server response", "Please try using a different world.", "");
      }

      class31.method714(10);
   }

   @ObfuscatedName("j")
   public static void method677(class166 var0) {
      class41.field963 = var0;
   }

   @ObfuscatedName("o")
   static final byte[] method678(byte[] var0) {
      class118 var1 = new class118(var0);
      int var2 = var1.method2536();
      int var3 = var1.method2541();
      if(var3 >= 0 && (0 == class166.field2654 || var3 <= class166.field2654)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2546(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2541();
            if(var4 < 0 || class166.field2654 != 0 && var4 > class166.field2654) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(1 == var2) {
                  class116.method2478(var5, var4, var0, 9);
               } else {
                  class166.field2665.method2469(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("l")
   public static void method679(int var0) {
      class139.field2129 = var0;
   }
}
