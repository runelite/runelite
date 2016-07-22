import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("Item")
public final class class30 extends class88 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 501710023
   )
   @Export("quantity")
   int field694;
   @ObfuscatedName("v")
   static class83 field696;
   @ObfuscatedName("r")
   static class83 field698;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1061799141
   )
   @Export("id")
   int field699;
   @ObfuscatedName("gn")
   static class176 field701;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-990594109"
   )
   protected final class108 vmethod1992() {
      return class4.method42(this.field699).method1151(this.field694);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;B)V",
      garbageValue = "57"
   )
   static void method663(class227 var0, class227 var1) {
      if(null == class98.field1699) {
         class98.field1699 = class62.method1336(class42.field993, "sl_back", "");
      }

      if(null == class147.field2271) {
         class147.field2271 = class9.method121(class42.field993, "sl_flags", "");
      }

      if(null == class90.field1610) {
         class90.field1610 = class9.method121(class42.field993, "sl_arrows", "");
      }

      if(class4.field69 == null) {
         class4.field69 = class9.method121(class42.field993, "sl_stars", "");
      }

      class82.method1880(class33.field730, 23, 765, 480, 0);
      class82.method1885(class33.field730, 0, 125, 23, 12425273, 9135624);
      class82.method1885(class33.field730 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4116("Select a world", 62 + class33.field730, 15, 0, -1);
      if(null != class4.field69) {
         class4.field69[1].method1946(class33.field730 + 140, 1);
         var1.method4099("Members only world", 152 + class33.field730, 10, 16777215, -1);
         class4.field69[0].method1946(class33.field730 + 140, 12);
         var1.method4099("Free world", class33.field730 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class90.field1610 != null) {
         int var2 = 280 + class33.field730;
         if(class27.field649[0] == 0 && class27.field648[0] == 0) {
            class90.field1610[2].method1946(var2, 4);
         } else {
            class90.field1610[0].method1946(var2, 4);
         }

         if(class27.field649[0] == 0 && class27.field648[0] == 1) {
            class90.field1610[3].method1946(var2 + 15, 4);
         } else {
            class90.field1610[1].method1946(var2 + 15, 4);
         }

         var0.method4099("World", var2 + 32, 17, 16777215, -1);
         int var3 = 390 + class33.field730;
         if(class27.field649[0] == 1 && class27.field648[0] == 0) {
            class90.field1610[2].method1946(var3, 4);
         } else {
            class90.field1610[0].method1946(var3, 4);
         }

         if(class27.field649[0] == 1 && class27.field648[0] == 1) {
            class90.field1610[3].method1946(15 + var3, 4);
         } else {
            class90.field1610[1].method1946(var3 + 15, 4);
         }

         var0.method4099("Players", 32 + var3, 17, 16777215, -1);
         var4 = class33.field730 + 500;
         if(class27.field649[0] == 2 && class27.field648[0] == 0) {
            class90.field1610[2].method1946(var4, 4);
         } else {
            class90.field1610[0].method1946(var4, 4);
         }

         if(class27.field649[0] == 2 && class27.field648[0] == 1) {
            class90.field1610[3].method1946(15 + var4, 4);
         } else {
            class90.field1610[1].method1946(15 + var4, 4);
         }

         var0.method4099("Location", var4 + 32, 17, 16777215, -1);
         var5 = 610 + class33.field730;
         if(class27.field649[0] == 3 && class27.field648[0] == 0) {
            class90.field1610[2].method1946(var5, 4);
         } else {
            class90.field1610[0].method1946(var5, 4);
         }

         if(class27.field649[0] == 3 && class27.field648[0] == 1) {
            class90.field1610[3].method1946(var5 + 15, 4);
         } else {
            class90.field1610[1].method1946(var5 + 15, 4);
         }

         var0.method4099("Type", var5 + 32, 17, 16777215, -1);
      }

      class82.method1880(class33.field730 + 708, 4, 50, 16, 0);
      var1.method4116("Cancel", 25 + class33.field730 + 708, 16, 16777215, -1);
      class33.field734 = -1;
      if(class98.field1699 != null) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (var23 + 1);
         var5 = 480 / (1 + var24);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= class27.field646) {
               --var4;
            }

            if(var4 * (var5 - 1) >= class27.field646) {
               --var5;
            }

            if((var5 - 1) * var4 >= class27.field646) {
               --var5;
            }
         } while(var6 != var5 || var4 != var7);

         var6 = (765 - var4 * var23) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var24 * var5) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var24 * var5 - (var5 - 1) * var7) / 2;
         int var10 = 23 + var9;
         int var11 = var8 + class33.field730;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < class27.field646; ++var14) {
            class27 var15 = class219.field3210[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.field652);
            if(var15.field652 == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.field652 > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method630()) {
               if(var15.method614()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method622()) {
               var19 = 16711680;
               if(var15.method614()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method616()) {
               if(var15.method614()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method614()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class143.field2213 >= var11 && class143.field2214 >= var10 && class143.field2213 < var11 + var23 && class143.field2214 < var24 + var10 && var16) {
               class33.field734 = var14;
               class98.field1699[var18].method1807(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class98.field1699[var18].method1798(var11, var10);
            }

            if(null != class147.field2271) {
               class147.field2271[(var15.method614()?8:0) + var15.field655].method1946(var11 + 29, var10);
            }

            var0.method4116(Integer.toString(var15.field650), var11 + 15, 5 + var24 / 2 + var10, var19, -1);
            var1.method4116(var17, var11 + 60, 5 + var10 + var24 / 2, 268435455, -1);
            var10 += var7 + var24;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4094(class219.field3210[class33.field734].field645) + 6;
            int var20 = var1.field3237 + 8;
            class82.method1880(class143.field2213 - var14 / 2, 5 + class143.field2214 + 20, var14, var20, 16777120);
            class82.method1878(class143.field2213 - var14 / 2, 5 + class143.field2214 + 20, var14, var20, 0);
            var1.method4116(class219.field3210[class33.field734].field645, class143.field2213, var1.field3237 + class143.field2214 + 20 + 5 + 4, 0, -1);
         }
      }

      try {
         Graphics var21 = class112.field1965.getGraphics();
         class78.field1454.vmethod1959(var21, 0, 0);
      } catch (Exception var22) {
         class112.field1965.repaint();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1047991588"
   )
   static void method664(int var0) {
      if(var0 == -3) {
         class126.method2836("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class126.method2836("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class126.method2836("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class33.field759 = 3;
      } else if(var0 == 4) {
         class126.method2836("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class126.method2836("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class126.method2836("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class126.method2836("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class126.method2836("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class126.method2836("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class126.method2836("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class126.method2836("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class126.method2836("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class126.method2836("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class126.method2836("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class126.method2836("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class126.method2836("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class126.method2836("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class126.method2836("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class126.method2836("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class126.method2836("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class126.method2836("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class126.method2836("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class126.method2836("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class126.method2836("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class126.method2836("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class126.method2836("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class126.method2836("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class126.method2836("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class126.method2836("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class126.method2836("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class126.method2836("Enter the 6-digit code generated by your", "authenticator app.", "");
            class171.method3414(11);
            return;
         }

         if(var0 == 57) {
            class126.method2836("The code you entered was incorrect.", "Please try again.", "");
            class171.method3414(11);
            return;
         }

         class126.method2836("Unexpected server response", "Please try using a different world.", "");
      }

      class171.method3414(10);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-92"
   )
   public static boolean method665(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "43"
   )
   static void method666(int var0) {
      class15 var1 = (class15)class15.field204.method3856((long)var0);
      if(null != var1) {
         for(int var2 = 0; var2 < var1.field206.length; ++var2) {
            var1.field206[var2] = -1;
            var1.field199[var2] = 0;
         }

      }
   }
}
