import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class4 {
   @ObfuscatedName("r")
   static final BigInteger field64 = new BigInteger("a1076a4b7faa535479a71726623f9d45d42c91b510a982b3dbfda01b4e09541fe115fe8439eb19e2099e5f7862ecdaeb5e6654f5072451cee8659d70549be65f3dfdfd1b1ceec91f2e4bbf4af2b27b068df9b7389894f35bbfc9ab884870f384229b527bcf66cd7068d2c029ba687769752962e41faa2b6637a86bd24856e225", 16);
   @ObfuscatedName("y")
   public static class166 field65;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = -105500129
   )
   static int field66;
   @ObfuscatedName("a")
   static final BigInteger field70 = new BigInteger("10001", 16);

   @ObfuscatedName("ae")
   static final int method52(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.field90[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class5.field86[var5][var3][var4] + var6 * class5.field86[var5][1 + var3][var4] >> 7;
         int var9 = class5.field86[var5][var3][1 + var4] * (128 - var6) + var6 * class5.field86[var5][1 + var3][1 + var4] >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Lclass25;II[I[II)V",
      garbageValue = "2092768918"
   )
   static void method53(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var1 + var2) / 2;
         class25 var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(2 == var3[var10]) {
                     var11 = var0[var6].field641;
                     var12 = var8.field641;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field635;
                     var12 = var8.field635;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(-1 == var12 && 1 == var4[var10]) {
                        var12 = 2001;
                     }
                  } else if(3 == var3[var10]) {
                     var11 = var0[var6].method599()?1:0;
                     var12 = var8.method599()?1:0;
                  } else {
                     var11 = var0[var6].field638;
                     var12 = var8.field638;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(2 == var3[var10]) {
                     var11 = var0[var5].field641;
                     var12 = var8.field641;
                  } else if(1 == var3[var10]) {
                     var11 = var0[var5].field635;
                     var12 = var8.field635;
                     if(-1 == var11 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method599()?1:0;
                     var12 = var8.method599()?1:0;
                  } else {
                     var11 = var0[var5].field638;
                     var12 = var8.field638;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (0 != var4[var10] || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method53(var0, var1, var6, var3, var4);
         method53(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("af")
   static final void method54() {
      client.field414 = 0;
      int var0 = (class151.field2253.field870 >> 7) + class147.field2214;
      int var1 = class17.field257 + (class151.field2253.field813 >> 7);
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         client.field414 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         client.field414 = 1;
      }

      if(1 == client.field414 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         client.field414 = 0;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "84"
   )
   static void method55(int var0) {
      if(var0 == -3) {
         method56("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         method56("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         method56("No response from server.", "Please try using a different world.", "");
      } else if(3 == var0) {
         class31.field733 = 3;
      } else if(var0 == 4) {
         method56("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         method56("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         method56("RuneScape has been updated!", "Please reload this page.", "");
      } else if(7 == var0) {
         method56("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         method56("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         method56("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(10 == var0) {
         method56("Unable to connect.", "Bad session id.", "");
      } else if(11 == var0) {
         method56("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(12 == var0) {
         method56("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         method56("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         method56("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         method56("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         method56("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(18 == var0) {
         method56("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         method56("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(20 == var0) {
         method56("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         method56("Malformed login packet.", "Please try again.", "");
      } else if(23 == var0) {
         method56("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         method56("Error loading your profile.", "Please contact customer support.", "");
      } else if(25 == var0) {
         method56("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         method56("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(27 == var0) {
         method56("", "Service unavailable.", "");
      } else if(var0 == 31) {
         method56("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         method56("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         method56("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(38 == var0) {
         method56("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         method56("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            method56("Enter the 6-digit code generated by your", "authenticator app.", "");
            class1.method9(11);
            return;
         }

         if(var0 == 57) {
            method56("The code you entered was incorrect.", "Please try again.", "");
            class1.method9(11);
            return;
         }

         method56("Unexpected server response", "Please try using a different world.", "");
      }

      class1.method9(10);
   }

   @ObfuscatedName("e")
   static void method56(String var0, String var1, String var2) {
      class31.field735 = var0;
      class31.field736 = var1;
      class31.field737 = var2;
   }
}
