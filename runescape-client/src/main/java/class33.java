import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class33 {
   @ObfuscatedName("i")
   static final class33 field758 = new class33();
   @ObfuscatedName("g")
   static final class33 field759 = new class33();
   @ObfuscatedName("h")
   static final class33 field760 = new class33();
   @ObfuscatedName("z")
   public static class167 field761;
   @ObfuscatedName("af")
   static class168 field765;
   @ObfuscatedName("t")
   static final class33 field766 = new class33();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "16"
   )
   public static boolean method701(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1403907808"
   )
   @Export("sendGameMessage")
   static void method702(int var0, String var1, String var2) {
      client.method325(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;Lclass224;ZI)V",
      garbageValue = "-1101633612"
   )
   static void method703(class224 var0, class224 var1, class224 var2, boolean var3) {
      if(var3) {
         class31.field703 = (class10.field162 - client.field565) / 2;
         class31.field721 = 202 + class31.field703;
      }

      if(class31.field702) {
         class30.method650(var0, var1);
      } else {
         if(var3) {
            class49.field1100.method1727(class31.field703, 0);
            class31.field705.method1727(class31.field703 + 382, 0);
            class135.field2101.method1822(382 + class31.field703 - class135.field2101.field1424 / 2, 18);
         }

         int var5;
         if(client.field462 == 0 || client.field462 == 5) {
            byte var4 = 20;
            var0.method3970("RuneScape is loading - please wait...", 180 + class31.field721, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1772(class31.field721 + 180 - 152, var5, 304, 34, 9179409);
            class79.method1772(class31.field721 + 180 - 151, 1 + var5, 302, 32, 0);
            class79.method1785(180 + class31.field721 - 150, var5 + 2, class31.field715 * 3, 30, 9179409);
            class79.method1785(class31.field721 + 180 - 150 + class31.field715 * 3, 2 + var5, 300 - class31.field715 * 3, 30, 0);
            var0.method3970(class31.field735, class31.field721 + 180, 276 - var4, 16777215, -1);
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
         if(client.field462 == 20) {
            class131.field2081.method1822(180 + class31.field721 - class131.field2081.field1424 / 2, 271 - class131.field2081.field1425 / 2);
            var25 = 211;
            var0.method3970(class31.field719, class31.field721 + 180, var25, 16776960, 0);
            var26 = var25 + 15;
            var0.method3970(class31.field734, 180 + class31.field721, var26, 16776960, 0);
            var26 += 15;
            var0.method3970(class31.field712, 180 + class31.field721, var26, 16776960, 0);
            var26 += 15;
            var26 += 10;
            if(class31.field717 != 4) {
               var0.method3968("Login: ", class31.field721 + 180 - 110, var26, 16777215, 0);
               var27 = 200;

               for(var6 = class31.field722; var0.method3963(var6) > var27; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method3968(class223.method3967(var6), 180 + class31.field721 - 70, var26, 16777215, 0);
               var26 += 15;
               var8 = "Password: ";
               var10 = class31.field723;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method3968(var8 + var11, 180 + class31.field721 - 108, var26, 16777215, 0);
               var26 += 15;
            }
         }

         int var16;
         int var18;
         int var19;
         int var21;
         if(client.field462 == 10 || client.field462 == 11) {
            class131.field2081.method1822(class31.field721, 171);
            short var15;
            if(class31.field717 == 0) {
               var25 = 251;
               var0.method3970("Welcome to RuneScape", class31.field721 + 180, var25, 16776960, 0);
               var26 = var25 + 30;
               var5 = 180 + class31.field721 - 80;
               var15 = 291;
               class31.field704.method1822(var5 - 73, var15 - 20);
               var0.method3985("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + 180 + class31.field721;
               class31.field704.method1822(var5 - 73, var15 - 20);
               var0.method3985("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class31.field717 == 1) {
               var0.method3970(class31.field708, class31.field721 + 180, 211, 16776960, 0);
               var25 = 236;
               var0.method3970(class31.field719, class31.field721 + 180, var25, 16777215, 0);
               var26 = var25 + 15;
               var0.method3970(class31.field734, 180 + class31.field721, var26, 16777215, 0);
               var26 += 15;
               var0.method3970(class31.field712, class31.field721 + 180, var26, 16777215, 0);
               var26 += 15;
               var5 = class31.field721 + 180 - 80;
               var15 = 321;
               class31.field704.method1822(var5 - 73, var15 - 20);
               var0.method3970("Continue", var5, 5 + var15, 16777215, 0);
               var5 = 80 + class31.field721 + 180;
               class31.field704.method1822(var5 - 73, var15 - 20);
               var0.method3970("Cancel", var5, var15 + 5, 16777215, 0);
            } else if(class31.field717 == 2) {
               var25 = 211;
               var0.method3970(class31.field719, 180 + class31.field721, var25, 16776960, 0);
               var26 = var25 + 15;
               var0.method3970(class31.field734, 180 + class31.field721, var26, 16776960, 0);
               var26 += 15;
               var0.method3970(class31.field712, class31.field721 + 180, var26, 16776960, 0);
               var26 += 15;
               var26 += 10;
               var0.method3968("Login: ", 180 + class31.field721 - 110, var26, 16777215, 0);
               var27 = 200;

               for(var6 = class31.field722; var0.method3963(var6) > var27; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3968(class223.method3967(var6) + (class31.field726 == 0 & client.field332 % 40 < 20?class155.method3132(16776960) + "|":""), 180 + class31.field721 - 70, var26, 16777215, 0);
               var26 += 15;
               var8 = "Password: ";
               var10 = class31.field723;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method3968(var8 + var11 + (class31.field726 == 1 & client.field332 % 40 < 20?class155.method3132(16776960) + "|":""), class31.field721 + 180 - 108, var26, 16777215, 0);
               var26 += 15;
               var16 = 180 + class31.field721 - 80;
               short var30 = 321;
               class31.field704.method1822(var16 - 73, var30 - 20);
               var0.method3970("Login", var16, 5 + var30, 16777215, 0);
               var16 = class31.field721 + 180 + 80;
               class31.field704.method1822(var16 - 73, var30 - 20);
               var0.method3970("Cancel", var16, 5 + var30, 16777215, 0);
               var25 = 357;
               var1.method3970("Forgotten your password? <col=ffffff>Click here.", class31.field721 + 180, var25, 16776960, 0);
            } else if(class31.field717 == 3) {
               var25 = 201;
               var0.method3970("Invalid username or password.", 180 + class31.field721, var25, 16776960, 0);
               var26 = var25 + 20;
               var1.method3970("For accounts created after 24th November 2010, please use your", 180 + class31.field721, var26, 16776960, 0);
               var26 += 15;
               var1.method3970("email address to login. Otherwise please login with your username.", 180 + class31.field721, var26, 16776960, 0);
               var26 += 15;
               var5 = 180 + class31.field721;
               var15 = 276;
               class31.field704.method1822(var5 - 73, var15 - 20);
               var2.method3970("Try again", var5, 5 + var15, 16777215, 0);
               var5 = 180 + class31.field721;
               var15 = 326;
               class31.field704.method1822(var5 - 73, var15 - 20);
               var2.method3970("Forgotten password?", var5, var15 + 5, 16777215, 0);
            } else if(class31.field717 == 4) {
               var0.method3970("Authenticator", class31.field721 + 180, 211, 16776960, 0);
               var25 = 236;
               var0.method3970(class31.field719, class31.field721 + 180, var25, 16777215, 0);
               var26 = var25 + 15;
               var0.method3970(class31.field734, 180 + class31.field721, var26, 16777215, 0);
               var26 += 15;
               var0.method3970(class31.field712, 180 + class31.field721, var26, 16777215, 0);
               var26 += 15;
               var6 = "PIN: ";
               var8 = class96.field1643;
               var18 = var8.length();
               char[] var28 = new char[var18];

               for(var12 = 0; var12 < var18; ++var12) {
                  var28[var12] = 42;
               }

               String var9 = new String(var28);
               var0.method3968(var6 + var9 + (client.field332 % 40 < 20?class155.method3132(16776960) + "|":""), class31.field721 + 180 - 108, var26, 16777215, 0);
               var26 -= 8;
               var0.method3968("Trust this computer", 180 + class31.field721 - 9, var26, 16776960, 0);
               var26 += 15;
               var0.method3968("for 30 days: ", 180 + class31.field721 - 9, var26, 16776960, 0);
               var19 = class31.field721 + 180 - 9 + var0.method3963("for 30 days: ") + 15;
               var18 = var26 - var0.field3193;
               class80 var29;
               if(class31.field725) {
                  var29 = class84.field1465;
               } else {
                  var29 = class4.field71;
               }

               var29.method1822(var19, var18);
               var26 += 15;
               var12 = 180 + class31.field721 - 80;
               short var20 = 321;
               class31.field704.method1822(var12 - 73, var20 - 20);
               var0.method3970("Continue", var12, 5 + var20, 16777215, 0);
               var12 = 180 + class31.field721 + 80;
               class31.field704.method1822(var12 - 73, var20 - 20);
               var0.method3970("Cancel", var12, var20 + 5, 16777215, 0);
               var1.method3970("<u=ff>Can\'t Log In?</u>", 180 + class31.field721, 36 + var20, 255, 0);
            } else if(class31.field717 == 5) {
               var0.method3970("Forgotten your password?", 180 + class31.field721, 201, 16776960, 0);
               var25 = 221;
               var2.method3970(class31.field719, 180 + class31.field721, var25, 16776960, 0);
               var26 = var25 + 15;
               var2.method3970(class31.field734, 180 + class31.field721, var26, 16776960, 0);
               var26 += 15;
               var2.method3970(class31.field712, class31.field721 + 180, var26, 16776960, 0);
               var26 += 15;
               var26 += 14;
               var0.method3968("Username/email: ", class31.field721 + 180 - 145, var26, 16777215, 0);
               var27 = 174;

               for(var6 = class31.field722; var0.method3963(var6) > var27; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3968(class223.method3967(var6) + (client.field332 % 40 < 20?class155.method3132(16776960) + "|":""), class31.field721 + 180 - 34, var26, 16777215, 0);
               var26 += 15;
               var21 = 180 + class31.field721 - 80;
               short var22 = 321;
               class31.field704.method1822(var21 - 73, var22 - 20);
               var0.method3970("Recover", var21, var22 + 5, 16777215, 0);
               var21 = class31.field721 + 180 + 80;
               class31.field704.method1822(var21 - 73, var22 - 20);
               var0.method3970("Back", var21, var22 + 5, 16777215, 0);
            } else if(class31.field717 == 6) {
               var25 = 211;
               var0.method3970(class31.field719, class31.field721 + 180, var25, 16776960, 0);
               var26 = var25 + 15;
               var0.method3970(class31.field734, 180 + class31.field721, var26, 16776960, 0);
               var26 += 15;
               var0.method3970(class31.field712, class31.field721 + 180, var26, 16776960, 0);
               var26 += 15;
               var5 = 180 + class31.field721;
               var15 = 321;
               class31.field704.method1822(var5 - 73, var15 - 20);
               var0.method3970("Back", var5, var15 + 5, 16777215, 0);
            }
         }

         if(class31.field713 > 0) {
            class59.method1228(class31.field713);
            class31.field713 = 0;
         }

         var25 = 256;
         if(class31.field709 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class31.field709 > 768) {
                  class46.field1064[var5] = class11.method131(class119.field2005[var5], class95.field1634[var5], 1024 - class31.field709);
               } else if(class31.field709 > 256) {
                  class46.field1064[var5] = class95.field1634[var5];
               } else {
                  class46.field1064[var5] = class11.method131(class95.field1634[var5], class119.field2005[var5], 256 - class31.field709);
               }
            }
         } else if(class31.field710 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class31.field710 > 768) {
                  class46.field1064[var5] = class11.method131(class119.field2005[var5], class19.field271[var5], 1024 - class31.field710);
               } else if(class31.field710 > 256) {
                  class46.field1064[var5] = class19.field271[var5];
               } else {
                  class46.field1064[var5] = class11.method131(class19.field271[var5], class119.field2005[var5], 256 - class31.field710);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class46.field1064[var5] = class119.field2005[var5];
            }
         }

         class79.method1753(class31.field703, 9, 128 + class31.field703, 7 + var25);
         class49.field1100.method1727(class31.field703, 0);
         class79.method1794();
         var5 = 0;
         int var31 = class31.field703 + class96.field1646.field1402 * 9;

         int var33;
         int var34;
         for(var21 = 1; var21 < var25 - 1; ++var21) {
            var34 = class31.field707[var21] * (var25 - var21) / var25;
            var19 = 22 + var34;
            if(var19 < 0) {
               var19 = 0;
            }

            var5 += var19;

            for(var18 = var19; var18 < 128; ++var18) {
               var16 = class32.field752[var5++];
               if(var16 != 0) {
                  var12 = var16;
                  var33 = 256 - var16;
                  var16 = class46.field1064[var16];
                  var14 = class96.field1646.field1401[var31];
                  class96.field1646.field1401[var31++] = (var33 * (var14 & '\uff00') + (var16 & '\uff00') * var12 & 16711680) + (var12 * (var16 & 16711935) + var33 * (var14 & 16711935) & -16711936) >> 8;
               } else {
                  ++var31;
               }
            }

            var31 += class96.field1646.field1402 + var19 - 128;
         }

         class79.method1753(765 + class31.field703 - 128, 9, class31.field703 + 765, var25 + 7);
         class31.field705.method1727(382 + class31.field703, 0);
         class79.method1794();
         var5 = 0;
         var31 = class31.field703 + 24 + class96.field1646.field1402 * 9 + 637;

         for(var21 = 1; var21 < var25 - 1; ++var21) {
            var34 = class31.field707[var21] * (var25 - var21) / var25;
            var19 = 103 - var34;
            var31 += var34;

            for(var18 = 0; var18 < var19; ++var18) {
               var16 = class32.field752[var5++];
               if(var16 != 0) {
                  var12 = var16;
                  var33 = 256 - var16;
                  var16 = class46.field1064[var16];
                  var14 = class96.field1646.field1401[var31];
                  class96.field1646.field1401[var31++] = ((var14 & 16711935) * var33 + (var16 & 16711935) * var12 & -16711936) + (var33 * (var14 & '\uff00') + (var16 & '\uff00') * var12 & 16711680) >> 8;
               } else {
                  ++var31;
               }
            }

            var5 += 128 - var19;
            var31 += class96.field1646.field1402 - var19 - var34;
         }

         class31.field711[class116.field1988.field145?1:0].method1822(class31.field703 + 765 - 40, 463);
         if(client.field462 > 5 && client.field288 == 0) {
            if(class87.field1541 != null) {
               var26 = class31.field703 + 5;
               var27 = 463;
               byte var32 = 100;
               byte var35 = 35;
               class87.field1541.method1822(var26, var27);
               var0.method3970("World" + " " + client.field478, var26 + var32 / 2, var27 + var35 / 2 - 2, 16777215, 0);
               if(null != class41.field969) {
                  var1.method3970("Loading...", var26 + var32 / 2, 12 + var27 + var35 / 2, 16777215, 0);
               } else {
                  var1.method3970("Click to switch", var32 / 2 + var26, 12 + var27 + var35 / 2, 16777215, 0);
               }
            } else {
               class87.field1541 = class32.method691(class13.field203, "sl_button", "");
            }
         }

         try {
            Graphics var23 = class59.field1221.getGraphics();
            class96.field1646.vmethod1829(var23, 0, 0);
         } catch (Exception var24) {
            class59.field1221.repaint();
         }

      }
   }
}
