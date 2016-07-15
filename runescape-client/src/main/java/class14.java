import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class14 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1156062823
   )
   int field221 = -1;
   @ObfuscatedName("c")
   int[] field222;
   @ObfuscatedName("e")
   class23 field223;
   @ObfuscatedName("h")
   String[] field225;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1448203611"
   )
   static final void method154() {
      if(client.field478 > 0) {
         class49.method1076();
      } else {
         class92.method2179(40);
         class13.field219 = class8.field150;
         class8.field150 = null;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   static int method155() {
      return client.field509?2:1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;Lclass227;ZI)V",
      garbageValue = "668714013"
   )
   static void method156(class227 var0, class227 var1, class227 var2, boolean var3) {
      if(var3) {
         class33.field758 = (class142.field2191 - client.field510) / 2;
         class33.field765 = class33.field758 + 202;
      }

      if(class33.field757) {
         class30.method669(var0, var1);
      } else {
         if(var3) {
            class33.field761.method1800(class33.field758, 0);
            class8.field151.method1800(class33.field758 + 382, 0);
            class33.field762.method1952(class33.field758 + 382 - class33.field762.field1486 / 2, 18);
         }

         int var5;
         if(client.field301 == 0 || client.field301 == 5) {
            byte var4 = 20;
            var0.method4119("RuneScape is loading - please wait...", class33.field765 + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1925(class33.field765 + 180 - 152, var5, 304, 34, 9179409);
            class82.method1925(180 + class33.field765 - 151, 1 + var5, 302, 32, 0);
            class82.method1911(180 + class33.field765 - 150, 2 + var5, class33.field776 * 3, 30, 9179409);
            class82.method1911(class33.field776 * 3 + (180 + class33.field765 - 150), var5 + 2, 300 - class33.field776 * 3, 30, 0);
            var0.method4119(class33.field777, 180 + class33.field765, 276 - var4, 16777215, -1);
         }

         String var6;
         String var8;
         String var10;
         String var11;
         int var12;
         char[] var13;
         int var14;
         short var25;
         int var26;
         short var27;
         if(client.field301 == 20) {
            class33.field759.method1952(class33.field765 + 180 - class33.field759.field1486 / 2, 271 - class33.field759.field1489 / 2);
            var25 = 211;
            var0.method4119(class33.field772, 180 + class33.field765, var25, 16776960, 0);
            var26 = var25 + 15;
            var0.method4119(class33.field781, class33.field765 + 180, var26, 16776960, 0);
            var26 += 15;
            var0.method4119(class33.field791, class33.field765 + 180, var26, 16776960, 0);
            var26 += 15;
            var26 += 10;
            if(class33.field778 != 4) {
               var0.method4177("Login: ", class33.field765 + 180 - 110, var26, 16777215, 0);
               var27 = 200;

               for(var6 = class33.field784; var0.method4179(var6) > var27; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4177(class226.method4139(var6), class33.field765 + 180 - 70, var26, 16777215, 0);
               var26 += 15;
               var8 = "Password: ";
               var10 = class33.field780;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method4177(var8 + var11, 180 + class33.field765 - 108, var26, 16777215, 0);
               var26 += 15;
            }
         }

         if(client.field301 == 10 || client.field301 == 11) {
            class33.field759.method1952(class33.field765, 171);
            short var15;
            if(class33.field778 == 0) {
               var25 = 251;
               var0.method4119("Welcome to RuneScape", 180 + class33.field765, var25, 16776960, 0);
               var26 = var25 + 30;
               var5 = 180 + class33.field765 - 80;
               var15 = 291;
               class33.field760.method1952(var5 - 73, var15 - 20);
               var0.method4116("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class33.field765 + 180;
               class33.field760.method1952(var5 - 73, var15 - 20);
               var0.method4116("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.field778 == 1) {
               var0.method4119(class33.field779, 180 + class33.field765, 211, 16776960, 0);
               var25 = 236;
               var0.method4119(class33.field772, class33.field765 + 180, var25, 16777215, 0);
               var26 = var25 + 15;
               var0.method4119(class33.field781, class33.field765 + 180, var26, 16777215, 0);
               var26 += 15;
               var0.method4119(class33.field791, class33.field765 + 180, var26, 16777215, 0);
               var26 += 15;
               var5 = 180 + class33.field765 - 80;
               var15 = 321;
               class33.field760.method1952(var5 - 73, var15 - 20);
               var0.method4119("Continue", var5, 5 + var15, 16777215, 0);
               var5 = 180 + class33.field765 + 80;
               class33.field760.method1952(var5 - 73, var15 - 20);
               var0.method4119("Cancel", var5, 5 + var15, 16777215, 0);
            } else if(class33.field778 == 2) {
               var25 = 211;
               var0.method4119(class33.field772, 180 + class33.field765, var25, 16776960, 0);
               var26 = var25 + 15;
               var0.method4119(class33.field781, 180 + class33.field765, var26, 16776960, 0);
               var26 += 15;
               var0.method4119(class33.field791, 180 + class33.field765, var26, 16776960, 0);
               var26 += 15;
               var26 += 10;
               var0.method4177("Login: ", 180 + class33.field765 - 110, var26, 16777215, 0);
               var27 = 200;

               for(var6 = class33.field784; var0.method4179(var6) > var27; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4177(class226.method4139(var6) + (class33.field788 == 0 & client.field567 % 40 < 20?class117.method2530(16776960) + "|":""), class33.field765 + 180 - 70, var26, 16777215, 0);
               var26 += 15;
               var8 = "Password: ";
               var10 = class33.field780;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method4177(var8 + var11 + (class33.field788 == 1 & client.field567 % 40 < 20?class117.method2530(16776960) + "|":""), 180 + class33.field765 - 108, var26, 16777215, 0);
               var26 += 15;
               int var16 = class33.field765 + 180 - 80;
               short var30 = 321;
               class33.field760.method1952(var16 - 73, var30 - 20);
               var0.method4119("Login", var16, 5 + var30, 16777215, 0);
               var16 = class33.field765 + 180 + 80;
               class33.field760.method1952(var16 - 73, var30 - 20);
               var0.method4119("Cancel", var16, var30 + 5, 16777215, 0);
               var25 = 357;
               var1.method4119("Forgotten your password? <col=ffffff>Click here.", class33.field765 + 180, var25, 16776960, 0);
            } else if(class33.field778 == 3) {
               var25 = 201;
               var0.method4119("Invalid username or password.", class33.field765 + 180, var25, 16776960, 0);
               var26 = var25 + 20;
               var1.method4119("For accounts created after 24th November 2010, please use your", 180 + class33.field765, var26, 16776960, 0);
               var26 += 15;
               var1.method4119("email address to login. Otherwise please login with your username.", class33.field765 + 180, var26, 16776960, 0);
               var26 += 15;
               var5 = 180 + class33.field765;
               var15 = 276;
               class33.field760.method1952(var5 - 73, var15 - 20);
               var2.method4119("Try again", var5, 5 + var15, 16777215, 0);
               var5 = 180 + class33.field765;
               var15 = 326;
               class33.field760.method1952(var5 - 73, var15 - 20);
               var2.method4119("Forgotten password?", var5, 5 + var15, 16777215, 0);
            } else if(class33.field778 == 4) {
               var0.method4119("Authenticator", 180 + class33.field765, 211, 16776960, 0);
               var25 = 236;
               var0.method4119(class33.field772, 180 + class33.field765, var25, 16777215, 0);
               var26 = var25 + 15;
               var0.method4119(class33.field781, class33.field765 + 180, var26, 16777215, 0);
               var26 += 15;
               var0.method4119(class33.field791, 180 + class33.field765, var26, 16777215, 0);
               var26 += 15;
               var6 = "PIN: ";
               var8 = class33.field786;
               int var18 = var8.length();
               char[] var28 = new char[var18];

               for(var12 = 0; var12 < var18; ++var12) {
                  var28[var12] = 42;
               }

               String var9 = new String(var28);
               var0.method4177(var6 + var9 + (client.field567 % 40 < 20?class117.method2530(16776960) + "|":""), 180 + class33.field765 - 108, var26, 16777215, 0);
               var26 -= 8;
               var0.method4177("Trust this computer", 180 + class33.field765 - 9, var26, 16776960, 0);
               var26 += 15;
               var0.method4177("for 30 days: ", class33.field765 + 180 - 9, var26, 16776960, 0);
               int var19 = class33.field765 + 180 - 9 + var0.method4179("for 30 days: ") + 15;
               var18 = var26 - var0.field3242;
               class83 var29;
               if(class33.field787) {
                  var29 = class3.field61;
               } else {
                  var29 = class192.field3095;
               }

               var29.method1952(var19, var18);
               var26 += 15;
               var12 = 180 + class33.field765 - 80;
               short var20 = 321;
               class33.field760.method1952(var12 - 73, var20 - 20);
               var0.method4119("Continue", var12, 5 + var20, 16777215, 0);
               var12 = class33.field765 + 180 + 80;
               class33.field760.method1952(var12 - 73, var20 - 20);
               var0.method4119("Cancel", var12, 5 + var20, 16777215, 0);
               var1.method4119("<u=ff>Can\'t Log In?</u>", class33.field765 + 180, 36 + var20, 255, 0);
            } else if(class33.field778 == 5) {
               var0.method4119("Forgotten your password?", class33.field765 + 180, 201, 16776960, 0);
               var25 = 221;
               var2.method4119(class33.field772, 180 + class33.field765, var25, 16776960, 0);
               var26 = var25 + 15;
               var2.method4119(class33.field781, class33.field765 + 180, var26, 16776960, 0);
               var26 += 15;
               var2.method4119(class33.field791, class33.field765 + 180, var26, 16776960, 0);
               var26 += 15;
               var26 += 14;
               var0.method4177("Username/email: ", 180 + class33.field765 - 145, var26, 16777215, 0);
               var27 = 174;

               for(var6 = class33.field784; var0.method4179(var6) > var27; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4177(class226.method4139(var6) + (client.field567 % 40 < 20?class117.method2530(16776960) + "|":""), class33.field765 + 180 - 34, var26, 16777215, 0);
               var26 += 15;
               int var21 = 180 + class33.field765 - 80;
               short var22 = 321;
               class33.field760.method1952(var21 - 73, var22 - 20);
               var0.method4119("Recover", var21, 5 + var22, 16777215, 0);
               var21 = 80 + class33.field765 + 180;
               class33.field760.method1952(var21 - 73, var22 - 20);
               var0.method4119("Back", var21, var22 + 5, 16777215, 0);
            } else if(class33.field778 == 6) {
               var25 = 211;
               var0.method4119(class33.field772, class33.field765 + 180, var25, 16776960, 0);
               var26 = var25 + 15;
               var0.method4119(class33.field781, 180 + class33.field765, var26, 16776960, 0);
               var26 += 15;
               var0.method4119(class33.field791, 180 + class33.field765, var26, 16776960, 0);
               var26 += 15;
               var5 = 180 + class33.field765;
               var15 = 321;
               class33.field760.method1952(var5 - 73, var15 - 20);
               var0.method4119("Back", var5, 5 + var15, 16777215, 0);
            }
         }

         if(class33.field774 > 0) {
            class18.method174(class33.field774);
            class33.field774 = 0;
         }

         class25.method584();
         class29.field712[client.field571.field144?1:0].method1952(765 + class33.field758 - 40, 463);
         if(client.field301 > 5 && client.field299 == 0) {
            if(null != class26.field660) {
               var26 = class33.field758 + 5;
               var27 = 463;
               byte var31 = 100;
               byte var32 = 35;
               class26.field660.method1952(var26, var27);
               var0.method4119("World" + " " + client.field468, var26 + var31 / 2, var32 / 2 + var27 - 2, 16777215, 0);
               if(class27.field672 != null) {
                  var1.method4119("Loading...", var31 / 2 + var26, var32 / 2 + var27 + 12, 16777215, 0);
               } else {
                  var1.method4119("Click to switch", var26 + var31 / 2, var32 / 2 + var27 + 12, 16777215, 0);
               }
            } else {
               class26.field660 = class24.method580(class230.field3263, "sl_button", "");
            }
         }

         try {
            Graphics var23 = class158.field2346.getGraphics();
            class44.field1039.vmethod1975(var23, 0, 0);
         } catch (Exception var24) {
            class158.field2346.repaint();
         }

      }
   }
}
