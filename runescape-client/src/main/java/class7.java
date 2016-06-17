import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("g")
   @Export("previousName")
   String field122;
   @ObfuscatedName("iw")
   static class30 field123;
   @ObfuscatedName("b")
   @Export("name")
   String field124;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -1812500841
   )
   static int field125;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-118"
   )
   public static int method90(int var0) {
      class47 var2 = (class47)class47.field1042.method3764((long)var0);
      class47 var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var3 = class47.field1044.method3266(14, var0);
         var2 = new class47();
         if(null != var3) {
            var2.method976(new class119(var3));
         }

         class47.field1042.method3759(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.field1043;
      int var4 = var1.field1045;
      int var5 = var1.field1047;
      int var6 = class176.field2898[var5 - var4];
      return class176.field2896[var7] >> var4 & var6;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   static void method91() {
      class11.field166.clear();
      class11.field169.method3812();
      class11.field164.method3861();
      class11.field168 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;Lclass224;ZI)V",
      garbageValue = "71643277"
   )
   static void method92(class224 var0, class224 var1, class224 var2, boolean var3) {
      if(var3) {
         class31.field695 = (class45.field1026 - client.field502) / 2;
         class31.field711 = 202 + class31.field695;
      }

      if(class31.field727) {
         class8.method101(var0, var1);
      } else {
         if(var3) {
            class31.field699.method1771(class31.field695, 0);
            class31.field730.method1771(class31.field695 + 382, 0);
            class31.field696.method1873(class31.field695 + 382 - class31.field696.field1390 / 2, 18);
         }

         int var5;
         if(client.field294 == 0 || client.field294 == 5) {
            byte var4 = 20;
            var0.method4035("RuneScape is loading - please wait...", 180 + class31.field711, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1852(180 + class31.field711 - 152, var5, 304, 34, 9179409);
            class79.method1852(180 + class31.field711 - 151, 1 + var5, 302, 32, 0);
            class79.method1865(class31.field711 + 180 - 150, var5 + 2, class31.field700 * 3, 30, 9179409);
            class79.method1865(class31.field711 + 180 - 150 + class31.field700 * 3, var5 + 2, 300 - class31.field700 * 3, 30, 0);
            var0.method4035(class31.field709, class31.field711 + 180, 276 - var4, 16777215, -1);
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
         if(client.field294 == 20) {
            class31.field708.method1873(class31.field711 + 180 - class31.field708.field1390 / 2, 271 - class31.field708.field1391 / 2);
            var25 = 211;
            var0.method4035(class31.field717, class31.field711 + 180, var25, 16776960, 0);
            var26 = var25 + 15;
            var0.method4035(class31.field718, 180 + class31.field711, var26, 16776960, 0);
            var26 += 15;
            var0.method4035(class31.field719, 180 + class31.field711, var26, 16776960, 0);
            var26 += 15;
            var26 += 10;
            if(class31.field715 != 4) {
               var0.method4033("Login: ", 180 + class31.field711 - 110, var26, 16777215, 0);
               var27 = 200;

               for(var6 = class31.field726; var0.method4028(var6) > var27; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4033(class223.method4032(var6), class31.field711 + 180 - 70, var26, 16777215, 0);
               var26 += 15;
               var8 = "Password: ";
               var10 = class31.field716;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method4033(var8 + var11, 180 + class31.field711 - 108, var26, 16777215, 0);
               var26 += 15;
            }
         }

         int var16;
         int var18;
         int var19;
         int var21;
         if(client.field294 == 10 || client.field294 == 11) {
            class31.field708.method1873(class31.field711, 171);
            short var15;
            if(class31.field715 == 0) {
               var25 = 251;
               var0.method4035("Welcome to RuneScape", 180 + class31.field711, var25, 16776960, 0);
               var26 = var25 + 30;
               var5 = 180 + class31.field711 - 80;
               var15 = 291;
               class31.field714.method1873(var5 - 73, var15 - 20);
               var0.method4036("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + 180 + class31.field711;
               class31.field714.method1873(var5 - 73, var15 - 20);
               var0.method4036("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class31.field715 == 1) {
               var0.method4035(class31.field705, 180 + class31.field711, 211, 16776960, 0);
               var25 = 236;
               var0.method4035(class31.field717, 180 + class31.field711, var25, 16777215, 0);
               var26 = var25 + 15;
               var0.method4035(class31.field718, class31.field711 + 180, var26, 16777215, 0);
               var26 += 15;
               var0.method4035(class31.field719, 180 + class31.field711, var26, 16777215, 0);
               var26 += 15;
               var5 = 180 + class31.field711 - 80;
               var15 = 321;
               class31.field714.method1873(var5 - 73, var15 - 20);
               var0.method4035("Continue", var5, 5 + var15, 16777215, 0);
               var5 = 80 + class31.field711 + 180;
               class31.field714.method1873(var5 - 73, var15 - 20);
               var0.method4035("Cancel", var5, 5 + var15, 16777215, 0);
            } else if(class31.field715 == 2) {
               var25 = 211;
               var0.method4035(class31.field717, class31.field711 + 180, var25, 16776960, 0);
               var26 = var25 + 15;
               var0.method4035(class31.field718, class31.field711 + 180, var26, 16776960, 0);
               var26 += 15;
               var0.method4035(class31.field719, 180 + class31.field711, var26, 16776960, 0);
               var26 += 15;
               var26 += 10;
               var0.method4033("Login: ", 180 + class31.field711 - 110, var26, 16777215, 0);
               var27 = 200;

               for(var6 = class31.field726; var0.method4028(var6) > var27; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4033(class223.method4032(var6) + (class31.field724 == 0 & client.field296 % 40 < 20?class158.method3184(16776960) + "|":""), class31.field711 + 180 - 70, var26, 16777215, 0);
               var26 += 15;
               var8 = "Password: ";
               var10 = class31.field716;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method4033(var8 + var11 + (class31.field724 == 1 & client.field296 % 40 < 20?class158.method3184(16776960) + "|":""), class31.field711 + 180 - 108, var26, 16777215, 0);
               var26 += 15;
               var16 = class31.field711 + 180 - 80;
               short var30 = 321;
               class31.field714.method1873(var16 - 73, var30 - 20);
               var0.method4035("Login", var16, 5 + var30, 16777215, 0);
               var16 = class31.field711 + 180 + 80;
               class31.field714.method1873(var16 - 73, var30 - 20);
               var0.method4035("Cancel", var16, var30 + 5, 16777215, 0);
               var25 = 357;
               var1.method4035("Forgotten your password? <col=ffffff>Click here.", 180 + class31.field711, var25, 16776960, 0);
            } else if(class31.field715 == 3) {
               var25 = 201;
               var0.method4035("Invalid username or password.", 180 + class31.field711, var25, 16776960, 0);
               var26 = var25 + 20;
               var1.method4035("For accounts created after 24th November 2010, please use your", 180 + class31.field711, var26, 16776960, 0);
               var26 += 15;
               var1.method4035("email address to login. Otherwise please login with your username.", 180 + class31.field711, var26, 16776960, 0);
               var26 += 15;
               var5 = 180 + class31.field711;
               var15 = 276;
               class31.field714.method1873(var5 - 73, var15 - 20);
               var2.method4035("Try again", var5, var15 + 5, 16777215, 0);
               var5 = class31.field711 + 180;
               var15 = 326;
               class31.field714.method1873(var5 - 73, var15 - 20);
               var2.method4035("Forgotten password?", var5, var15 + 5, 16777215, 0);
            } else if(class31.field715 == 4) {
               var0.method4035("Authenticator", class31.field711 + 180, 211, 16776960, 0);
               var25 = 236;
               var0.method4035(class31.field717, class31.field711 + 180, var25, 16777215, 0);
               var26 = var25 + 15;
               var0.method4035(class31.field718, class31.field711 + 180, var26, 16777215, 0);
               var26 += 15;
               var0.method4035(class31.field719, class31.field711 + 180, var26, 16777215, 0);
               var26 += 15;
               var6 = "PIN: ";
               var8 = class170.field2705;
               var18 = var8.length();
               char[] var28 = new char[var18];

               for(var12 = 0; var12 < var18; ++var12) {
                  var28[var12] = 42;
               }

               String var9 = new String(var28);
               var0.method4033(var6 + var9 + (client.field296 % 40 < 20?class158.method3184(16776960) + "|":""), 180 + class31.field711 - 108, var26, 16777215, 0);
               var26 -= 8;
               var0.method4033("Trust this computer", 180 + class31.field711 - 9, var26, 16776960, 0);
               var26 += 15;
               var0.method4033("for 30 days: ", 180 + class31.field711 - 9, var26, 16776960, 0);
               var19 = 180 + class31.field711 - 9 + var0.method4028("for 30 days: ") + 15;
               var18 = var26 - var0.field3190;
               class80 var29;
               if(class31.field723) {
                  var29 = class209.field3117;
               } else {
                  var29 = class38.field855;
               }

               var29.method1873(var19, var18);
               var26 += 15;
               var12 = class31.field711 + 180 - 80;
               short var20 = 321;
               class31.field714.method1873(var12 - 73, var20 - 20);
               var0.method4035("Continue", var12, var20 + 5, 16777215, 0);
               var12 = 180 + class31.field711 + 80;
               class31.field714.method1873(var12 - 73, var20 - 20);
               var0.method4035("Cancel", var12, 5 + var20, 16777215, 0);
               var1.method4035("<u=ff>Can\'t Log In?</u>", class31.field711 + 180, var20 + 36, 255, 0);
            } else if(class31.field715 == 5) {
               var0.method4035("Forgotten your password?", 180 + class31.field711, 201, 16776960, 0);
               var25 = 221;
               var2.method4035(class31.field717, 180 + class31.field711, var25, 16776960, 0);
               var26 = var25 + 15;
               var2.method4035(class31.field718, 180 + class31.field711, var26, 16776960, 0);
               var26 += 15;
               var2.method4035(class31.field719, class31.field711 + 180, var26, 16776960, 0);
               var26 += 15;
               var26 += 14;
               var0.method4033("Username/email: ", 180 + class31.field711 - 145, var26, 16777215, 0);
               var27 = 174;

               for(var6 = class31.field726; var0.method4028(var6) > var27; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4033(class223.method4032(var6) + (client.field296 % 40 < 20?class158.method3184(16776960) + "|":""), class31.field711 + 180 - 34, var26, 16777215, 0);
               var26 += 15;
               var21 = 180 + class31.field711 - 80;
               short var22 = 321;
               class31.field714.method1873(var21 - 73, var22 - 20);
               var0.method4035("Recover", var21, var22 + 5, 16777215, 0);
               var21 = 80 + 180 + class31.field711;
               class31.field714.method1873(var21 - 73, var22 - 20);
               var0.method4035("Back", var21, 5 + var22, 16777215, 0);
            } else if(class31.field715 == 6) {
               var25 = 211;
               var0.method4035(class31.field717, class31.field711 + 180, var25, 16776960, 0);
               var26 = var25 + 15;
               var0.method4035(class31.field718, class31.field711 + 180, var26, 16776960, 0);
               var26 += 15;
               var0.method4035(class31.field719, 180 + class31.field711, var26, 16776960, 0);
               var26 += 15;
               var5 = 180 + class31.field711;
               var15 = 321;
               class31.field714.method1873(var5 - 73, var15 - 20);
               var0.method4035("Back", var5, var15 + 5, 16777215, 0);
            }
         }

         if(class31.field697 > 0) {
            class5.method45(class31.field697);
            class31.field697 = 0;
         }

         var25 = 256;
         if(class31.field725 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class31.field725 > 768) {
                  class12.field184[var5] = class127.method2851(class11.field165[var5], class31.field706[var5], 1024 - class31.field725);
               } else if(class31.field725 > 256) {
                  class12.field184[var5] = class31.field706[var5];
               } else {
                  class12.field184[var5] = class127.method2851(class31.field706[var5], class11.field165[var5], 256 - class31.field725);
               }
            }
         } else if(class31.field707 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class31.field707 > 768) {
                  class12.field184[var5] = class127.method2851(class11.field165[var5], class164.field2650[var5], 1024 - class31.field707);
               } else if(class31.field707 > 256) {
                  class12.field184[var5] = class164.field2650[var5];
               } else {
                  class12.field184[var5] = class127.method2851(class164.field2650[var5], class11.field165[var5], 256 - class31.field707);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class12.field184[var5] = class11.field165[var5];
            }
         }

         class79.method1793(class31.field695, 9, class31.field695 + 128, 7 + var25);
         class31.field699.method1771(class31.field695, 0);
         class79.method1827();
         var5 = 0;
         int var31 = class31.field695 + class48.field1049.field1363 * 9;

         int var33;
         int var34;
         for(var21 = 1; var21 < var25 - 1; ++var21) {
            var34 = (var25 - var21) * class31.field721[var21] / var25;
            var19 = var34 + 22;
            if(var19 < 0) {
               var19 = 0;
            }

            var5 += var19;

            for(var18 = var19; var18 < 128; ++var18) {
               var16 = class36.field788[var5++];
               if(var16 != 0) {
                  var12 = var16;
                  var33 = 256 - var16;
                  var16 = class12.field184[var16];
                  var14 = class48.field1049.field1368[var31];
                  class48.field1049.field1368[var31++] = ((var14 & 16711935) * var33 + var12 * (var16 & 16711935) & -16711936) + (var12 * (var16 & '\uff00') + var33 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var31;
               }
            }

            var31 += class48.field1049.field1363 + var19 - 128;
         }

         class79.method1793(class31.field695 + 765 - 128, 9, 765 + class31.field695, 7 + var25);
         class31.field730.method1771(382 + class31.field695, 0);
         class79.method1827();
         var5 = 0;
         var31 = class31.field695 + class48.field1049.field1363 * 9 + 24 + 637;

         for(var21 = 1; var21 < var25 - 1; ++var21) {
            var34 = class31.field721[var21] * (var25 - var21) / var25;
            var19 = 103 - var34;
            var31 += var34;

            for(var18 = 0; var18 < var19; ++var18) {
               var16 = class36.field788[var5++];
               if(var16 != 0) {
                  var12 = var16;
                  var33 = 256 - var16;
                  var16 = class12.field184[var16];
                  var14 = class48.field1049.field1368[var31];
                  class48.field1049.field1368[var31++] = ((var14 & 16711935) * var33 + (var16 & 16711935) * var12 & -16711936) + (var33 * (var14 & '\uff00') + var12 * (var16 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var31;
               }
            }

            var5 += 128 - var19;
            var31 += class48.field1049.field1363 - var19 - var34;
         }

         class90.field1539[class162.field2637.field128?1:0].method1873(class31.field695 + 765 - 40, 463);
         if(client.field294 > 5 && client.field292 == 0) {
            if(null != class23.field614) {
               var26 = class31.field695 + 5;
               var27 = 463;
               byte var32 = 100;
               byte var35 = 35;
               class23.field614.method1873(var26, var27);
               var0.method4035("World" + " " + client.field286, var32 / 2 + var26, var27 + var35 / 2 - 2, 16777215, 0);
               if(class155.field2283 != null) {
                  var1.method4035("Loading...", var32 / 2 + var26, var35 / 2 + var27 + 12, 16777215, 0);
               } else {
                  var1.method4035("Click to switch", var26 + var32 / 2, 12 + var27 + var35 / 2, 16777215, 0);
               }
            } else {
               class23.field614 = class153.method3168(class129.field2038, "sl_button", "");
            }
         }

         try {
            Graphics var23 = class46.field1040.getGraphics();
            class48.field1049.vmethod1887(var23, 0, 0);
         } catch (Exception var24) {
            class46.field1040.repaint();
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "815188043"
   )
   @Export("selectWorld")
   static void method93(class25 var0) {
      if(var0.method627() != client.field290) {
         client.field290 = var0.method627();
         class48.method992(var0.method627());
      }

      class43.field1002 = var0.field637;
      client.field286 = var0.field636;
      client.field477 = var0.field640;
      class13.field200 = client.field548 == 0?'ꩊ':'鱀' + var0.field636;
      client.field472 = client.field548 == 0?443:'썐' + var0.field636;
      class16.field239 = class13.field200;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "44"
   )
   public static void method94(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(var1 != null) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class148) {
               class148 var6 = (class148)var1;
               var5 = var6.field2208 + " | ";
               var4 = var6.field2209;
            } else {
               var5 = "";
            }

            StringWriter var18 = new StringWriter();
            PrintWriter var7 = new PrintWriter(var18);
            var4.printStackTrace(var7);
            var7.close();
            String var8 = var18.toString();
            BufferedReader var9 = new BufferedReader(new StringReader(var8));
            String var10 = var9.readLine();

            while(true) {
               String var11 = var9.readLine();
               if(null == var11) {
                  var5 = var5 + "| " + var10;
                  var2 = var5;
                  break;
               }

               int var12 = var11.indexOf(40);
               int var13 = var11.indexOf(41, var12 + 1);
               if(var12 >= 0 && var13 >= 0) {
                  String var14 = var11.substring(1 + var12, var13);
                  int var15 = var14.indexOf(".java:");
                  if(var15 >= 0) {
                     var14 = var14.substring(0, var15) + var14.substring(var15 + 5);
                     var5 = var5 + var14 + ' ';
                     continue;
                  }

                  var11 = var11.substring(0, var12);
               }

               var11 = var11.trim();
               var11 = var11.substring(var11.lastIndexOf(32) + 1);
               var11 = var11.substring(var11.lastIndexOf(9) + 1);
               var5 = var5 + var11 + ' ';
            }
         }

         if(var0 != null) {
            if(null != var1) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(null == class148.field2210) {
            return;
         }

         URL var3 = new URL(class148.field2210.getCodeBase(), "clienterror.ws?c=" + class148.field2206 + "&u=" + class148.field2207 + "&v1=" + class26.field659 + "&v2=" + class136.field2079 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "156684678"
   )
   public static void method95() {
      class76.field1353 = null;
      class131.field2048 = null;
      class76.field1354 = null;
      class28.field674 = null;
      class8.field135 = null;
      class76.field1355 = (byte[][])null;
   }
}
