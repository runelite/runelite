import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class48 extends class204 {
   @ObfuscatedName("w")
   public static class167 field1087;
   @ObfuscatedName("x")
   static class193 field1088 = new class193(64);
   @ObfuscatedName("t")
   public char field1089;
   @ObfuscatedName("v")
   public int[] field1090;
   @ObfuscatedName("e")
   public String field1091 = "null";
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -435081989
   )
   public int field1092;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -823418893
   )
   public int field1093 = 0;
   @ObfuscatedName("p")
   public char field1094;
   @ObfuscatedName("c")
   public int[] field1095;
   @ObfuscatedName("l")
   public String[] field1096;
   @ObfuscatedName("af")
   static int[] field1097;
   @ObfuscatedName("f")
   public static String field1098;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;Lclass224;ZI)V",
      garbageValue = "1495560198"
   )
   static void method1026(class224 var0, class224 var1, class224 var2, boolean var3) {
      if(var3) {
         class31.field720 = (class15.field235 - client.field509) / 2;
         class31.field718 = class31.field720 + 202;
      }

      byte var4;
      int var5;
      int var11;
      int var25;
      int var28;
      int var33;
      int var36;
      int var38;
      Graphics var41;
      if(class31.field741) {
         if(null == class76.field1393) {
            class76.field1393 = class23.method598(class35.field795, "sl_back", "");
         }

         if(class30.field712 == null) {
            class30.field712 = class56.method1236(class35.field795, "sl_flags", "");
         }

         if(null == class134.field2089) {
            class134.field2089 = class56.method1236(class35.field795, "sl_arrows", "");
         }

         if(null == class129.field2063) {
            class129.field2063 = class56.method1236(class35.field795, "sl_stars", "");
         }

         class79.method1800(class31.field720, 23, 765, 480, 0);
         class79.method1784(class31.field720, 0, 125, 23, 12425273, 9135624);
         class79.method1784(class31.field720 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4039("Select a world", class31.field720 + 62, 15, 0, -1);
         if(null != class129.field2063) {
            class129.field2063[1].method1855(140 + class31.field720, 1);
            var1.method4037("Members only world", 152 + class31.field720, 10, 16777215, -1);
            class129.field2063[0].method1855(class31.field720 + 140, 12);
            var1.method4037("Free world", 152 + class31.field720, 21, 16777215, -1);
         }

         int var35;
         if(class134.field2089 != null) {
            var25 = class31.field720 + 280;
            if(class25.field645[0] == 0 && 0 == class25.field644[0]) {
               class134.field2089[2].method1855(var25, 4);
            } else {
               class134.field2089[0].method1855(var25, 4);
            }

            if(0 == class25.field645[0] && class25.field644[0] == 1) {
               class134.field2089[3].method1855(15 + var25, 4);
            } else {
               class134.field2089[1].method1855(var25 + 15, 4);
            }

            var0.method4037("World", var25 + 32, 17, 16777215, -1);
            var5 = 390 + class31.field720;
            if(class25.field645[0] == 1 && class25.field644[0] == 0) {
               class134.field2089[2].method1855(var5, 4);
            } else {
               class134.field2089[0].method1855(var5, 4);
            }

            if(1 == class25.field645[0] && class25.field644[0] == 1) {
               class134.field2089[3].method1855(15 + var5, 4);
            } else {
               class134.field2089[1].method1855(15 + var5, 4);
            }

            var0.method4037("Players", var5 + 32, 17, 16777215, -1);
            var35 = 500 + class31.field720;
            if(class25.field645[0] == 2 && class25.field644[0] == 0) {
               class134.field2089[2].method1855(var35, 4);
            } else {
               class134.field2089[0].method1855(var35, 4);
            }

            if(2 == class25.field645[0] && class25.field644[0] == 1) {
               class134.field2089[3].method1855(var35 + 15, 4);
            } else {
               class134.field2089[1].method1855(var35 + 15, 4);
            }

            var0.method4037("Location", var35 + 32, 17, 16777215, -1);
            var28 = 610 + class31.field720;
            if(3 == class25.field645[0] && 0 == class25.field644[0]) {
               class134.field2089[2].method1855(var28, 4);
            } else {
               class134.field2089[0].method1855(var28, 4);
            }

            if(3 == class25.field645[0] && class25.field644[0] == 1) {
               class134.field2089[3].method1855(15 + var28, 4);
            } else {
               class134.field2089[1].method1855(15 + var28, 4);
            }

            var0.method4037("Type", 32 + var28, 17, 16777215, -1);
         }

         class79.method1800(708 + class31.field720, 4, 50, 16, 0);
         var1.method4039("Cancel", 25 + class31.field720 + 708, 16, 16777215, -1);
         class31.field742 = -1;
         if(class76.field1393 != null) {
            var4 = 88;
            byte var31 = 19;
            var35 = 765 / (1 + var4);
            var28 = 480 / (1 + var31);

            int var32;
            do {
               var32 = var28;
               var33 = var35;
               if(var28 * (var35 - 1) >= class25.field642) {
                  --var35;
               }

               if(var35 * (var28 - 1) >= class25.field642) {
                  --var28;
               }

               if(var35 * (var28 - 1) >= class25.field642) {
                  --var28;
               }
            } while(var32 != var28 || var35 != var33);

            var32 = (765 - var35 * var4) / (1 + var35);
            if(var32 > 5) {
               var32 = 5;
            }

            var33 = (480 - var28 * var31) / (1 + var28);
            if(var33 > 5) {
               var33 = 5;
            }

            var36 = (765 - var4 * var35 - (var35 - 1) * var32) / 2;
            var11 = (480 - var31 * var28 - var33 * (var28 - 1)) / 2;
            var38 = var11 + 23;
            int var39 = class31.field720 + var36;
            int var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < class25.field642; ++var16) {
               class25 var17 = class189.field3062[var16];
               boolean var18 = true;
               String var19 = Integer.toString(var17.field638);
               if(var17.field638 == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.field638 > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var20;
               if(var17.method626()) {
                  if(var17.method635()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method617()) {
                  var21 = 16711680;
                  if(var17.method635()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method622()) {
                  if(var17.method635()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method635()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class140.field2168 >= var39 && class140.field2182 >= var38 && class140.field2168 < var39 + var4 && class140.field2182 < var38 + var31 && var18) {
                  class31.field742 = var16;
                  class76.field1393[var20].method1712(var39, var38, 128, 16777215);
                  var15 = true;
               } else {
                  class76.field1393[var20].method1697(var39, var38);
               }

               if(null != class30.field712) {
                  class30.field712[(var17.method635()?8:0) + var17.field648].method1855(var39 + 29, var38);
               }

               var0.method4039(Integer.toString(var17.field650), 15 + var39, var38 + var31 / 2 + 5, var21, -1);
               var1.method4039(var19, 60 + var39, 5 + var31 / 2 + var38, 268435455, -1);
               var38 += var31 + var33;
               ++var14;
               if(var14 >= var28) {
                  var38 = var11 + 23;
                  var39 += var32 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4032(class189.field3062[class31.field742].field639) + 6;
               int var40 = var1.field3194 + 8;
               class79.method1800(class140.field2168 - var16 / 2, 5 + 20 + class140.field2182, var16, var40, 16777120);
               class79.method1790(class140.field2168 - var16 / 2, 5 + 20 + class140.field2182, var16, var40, 0);
               var1.method4039(class189.field3062[class31.field742].field639, class140.field2168, var1.field3194 + 5 + 20 + class140.field2182 + 4, 0, -1);
            }
         }

         try {
            var41 = class87.field1537.getGraphics();
            class42.field991.vmethod1870(var41, 0, 0);
         } catch (Exception var22) {
            class87.field1537.repaint();
         }

      } else {
         if(var3) {
            class161.field2668.method1697(class31.field720, 0);
            class213.field3152.method1697(class31.field720 + 382, 0);
            class139.field2156.method1855(382 + class31.field720 - class139.field2156.field1425 / 2, 18);
         }

         if(0 == client.field303 || 5 == client.field303) {
            var4 = 20;
            var0.method4039("RuneScape is loading - please wait...", class31.field718 + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1790(180 + class31.field718 - 152, var5, 304, 34, 9179409);
            class79.method1790(180 + class31.field718 - 151, var5 + 1, 302, 32, 0);
            class79.method1800(180 + class31.field718 - 150, var5 + 2, class31.field727 * 3, 30, 9179409);
            class79.method1800(class31.field727 * 3 + (180 + class31.field718 - 150), var5 + 2, 300 - class31.field727 * 3, 30, 0);
            var0.method4039(class31.field728, class31.field718 + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         String var8;
         String var9;
         String var10;
         short var24;
         short var26;
         if(20 == client.field303) {
            class31.field731.method1855(class31.field718 + 180 - class31.field731.field1425 / 2, 271 - class31.field731.field1423 / 2);
            var24 = 211;
            var0.method4039(class31.field714, class31.field718 + 180, var24, 16776960, 0);
            var25 = var24 + 15;
            var0.method4039(class31.field732, class31.field718 + 180, var25, 16776960, 0);
            var25 += 15;
            var0.method4039(class31.field739, 180 + class31.field718, var25, 16776960, 0);
            var25 += 15;
            var25 += 10;
            if(class31.field729 != 4) {
               var0.method4037("Login: ", class31.field718 + 180 - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class31.field734; var0.method4032(var6) > var26; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4037(class223.method4103(var6), 180 + class31.field718 - 70, var25, 16777215, 0);
               var25 += 15;
               var8 = "Password: ";
               var10 = class31.field735;
               var9 = class40.method852('*', var10.length());
               var0.method4037(var8 + var9, 180 + class31.field718 - 108, var25, 16777215, 0);
               var25 += 15;
            }
         }

         if(10 == client.field303 || client.field303 == 11) {
            class31.field731.method1855(class31.field718, 171);
            short var27;
            if(class31.field729 == 0) {
               var24 = 251;
               var0.method4039("Welcome to RuneScape", 180 + class31.field718, var24, 16776960, 0);
               var25 = var24 + 30;
               var5 = class31.field718 + 180 - 80;
               var27 = 291;
               class31.field717.method1855(var5 - 73, var27 - 20);
               var0.method4066("New User", var5 - 73, var27 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 180 + class31.field718 + 80;
               class31.field717.method1855(var5 - 73, var27 - 20);
               var0.method4066("Existing User", var5 - 73, var27 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class31.field729 == 1) {
               var0.method4039(class31.field730, class31.field718 + 180, 211, 16776960, 0);
               var24 = 236;
               var0.method4039(class31.field714, class31.field718 + 180, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method4039(class31.field732, class31.field718 + 180, var25, 16777215, 0);
               var25 += 15;
               var0.method4039(class31.field739, class31.field718 + 180, var25, 16777215, 0);
               var25 += 15;
               var5 = class31.field718 + 180 - 80;
               var27 = 321;
               class31.field717.method1855(var5 - 73, var27 - 20);
               var0.method4039("Continue", var5, 5 + var27, 16777215, 0);
               var5 = 80 + class31.field718 + 180;
               class31.field717.method1855(var5 - 73, var27 - 20);
               var0.method4039("Cancel", var5, 5 + var27, 16777215, 0);
            } else if(2 == class31.field729) {
               var24 = 211;
               var0.method4039(class31.field714, 180 + class31.field718, var24, 16776960, 0);
               var25 = var24 + 15;
               var0.method4039(class31.field732, 180 + class31.field718, var25, 16776960, 0);
               var25 += 15;
               var0.method4039(class31.field739, class31.field718 + 180, var25, 16776960, 0);
               var25 += 15;
               var25 += 10;
               var0.method4037("Login: ", class31.field718 + 180 - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class31.field734; var0.method4032(var6) > var26; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4037(class223.method4103(var6) + (0 == class31.field738 & client.field305 % 40 < 20?class72.method1574(16776960) + "|":""), 180 + class31.field718 - 70, var25, 16777215, 0);
               var25 += 15;
               var8 = "Password: ";
               var10 = class31.field735;
               var9 = class40.method852('*', var10.length());
               var0.method4037(var8 + var9 + (class31.field738 == 1 & client.field305 % 40 < 20?class72.method1574(16776960) + "|":""), class31.field718 + 180 - 108, var25, 16777215, 0);
               var25 += 15;
               var11 = class31.field718 + 180 - 80;
               short var12 = 321;
               class31.field717.method1855(var11 - 73, var12 - 20);
               var0.method4039("Login", var11, 5 + var12, 16777215, 0);
               var11 = 80 + 180 + class31.field718;
               class31.field717.method1855(var11 - 73, var12 - 20);
               var0.method4039("Cancel", var11, var12 + 5, 16777215, 0);
               var24 = 357;
               var1.method4039("Forgotten your password? <col=ffffff>Click here.", class31.field718 + 180, var24, 16776960, 0);
            } else if(class31.field729 == 3) {
               var24 = 201;
               var0.method4039("Invalid username or password.", 180 + class31.field718, var24, 16776960, 0);
               var25 = var24 + 20;
               var1.method4039("For accounts created after 24th November 2010, please use your", 180 + class31.field718, var25, 16776960, 0);
               var25 += 15;
               var1.method4039("email address to login. Otherwise please login with your username.", 180 + class31.field718, var25, 16776960, 0);
               var25 += 15;
               var5 = 180 + class31.field718;
               var27 = 276;
               class31.field717.method1855(var5 - 73, var27 - 20);
               var2.method4039("Try again", var5, 5 + var27, 16777215, 0);
               var5 = 180 + class31.field718;
               var27 = 326;
               class31.field717.method1855(var5 - 73, var27 - 20);
               var2.method4039("Forgotten password?", var5, 5 + var27, 16777215, 0);
            } else if(class31.field729 == 4) {
               var0.method4039("Authenticator", class31.field718 + 180, 211, 16776960, 0);
               var24 = 236;
               var0.method4039(class31.field714, class31.field718 + 180, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method4039(class31.field732, class31.field718 + 180, var25, 16777215, 0);
               var25 += 15;
               var0.method4039(class31.field739, 180 + class31.field718, var25, 16777215, 0);
               var25 += 15;
               var6 = "PIN: ";
               var8 = class26.field668;
               String var7 = class40.method852('*', var8.length());
               var0.method4037(var6 + var7 + (client.field305 % 40 < 20?class72.method1574(16776960) + "|":""), 180 + class31.field718 - 108, var25, 16777215, 0);
               var25 -= 8;
               var0.method4037("Trust this computer", class31.field718 + 180 - 9, var25, 16776960, 0);
               var25 += 15;
               var0.method4037("for 30 days: ", class31.field718 + 180 - 9, var25, 16776960, 0);
               var33 = class31.field718 + 180 - 9 + var0.method4032("for 30 days: ") + 15;
               var36 = var25 - var0.field3194;
               class80 var37;
               if(class31.field722) {
                  var37 = class90.field1566;
               } else {
                  var37 = class189.field3061;
               }

               var37.method1855(var33, var36);
               var25 += 15;
               var38 = class31.field718 + 180 - 80;
               short var13 = 321;
               class31.field717.method1855(var38 - 73, var13 - 20);
               var0.method4039("Continue", var38, 5 + var13, 16777215, 0);
               var38 = 80 + 180 + class31.field718;
               class31.field717.method1855(var38 - 73, var13 - 20);
               var0.method4039("Cancel", var38, 5 + var13, 16777215, 0);
               var1.method4039("<u=ff>Can\'t Log In?</u>", 180 + class31.field718, var13 + 36, 255, 0);
            } else if(5 == class31.field729) {
               var0.method4039("Forgotten your password?", class31.field718 + 180, 201, 16776960, 0);
               var24 = 221;
               var2.method4039(class31.field714, class31.field718 + 180, var24, 16776960, 0);
               var25 = var24 + 15;
               var2.method4039(class31.field732, class31.field718 + 180, var25, 16776960, 0);
               var25 += 15;
               var2.method4039(class31.field739, class31.field718 + 180, var25, 16776960, 0);
               var25 += 15;
               var25 += 14;
               var0.method4037("Username/email: ", class31.field718 + 180 - 145, var25, 16777215, 0);
               var26 = 174;

               for(var6 = class31.field734; var0.method4032(var6) > var26; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4037(class223.method4103(var6) + (client.field305 % 40 < 20?class72.method1574(16776960) + "|":""), class31.field718 + 180 - 34, var25, 16777215, 0);
               var25 += 15;
               var28 = class31.field718 + 180 - 80;
               short var30 = 321;
               class31.field717.method1855(var28 - 73, var30 - 20);
               var0.method4039("Recover", var28, var30 + 5, 16777215, 0);
               var28 = 180 + class31.field718 + 80;
               class31.field717.method1855(var28 - 73, var30 - 20);
               var0.method4039("Back", var28, 5 + var30, 16777215, 0);
            } else if(6 == class31.field729) {
               var24 = 211;
               var0.method4039(class31.field714, class31.field718 + 180, var24, 16776960, 0);
               var25 = var24 + 15;
               var0.method4039(class31.field732, class31.field718 + 180, var25, 16776960, 0);
               var25 += 15;
               var0.method4039(class31.field739, 180 + class31.field718, var25, 16776960, 0);
               var25 += 15;
               var5 = 180 + class31.field718;
               var27 = 321;
               class31.field717.method1855(var5 - 73, var27 - 20);
               var0.method4039("Back", var5, var27 + 5, 16777215, 0);
            }
         }

         if(class31.field725 > 0) {
            class38.method784(class31.field725);
            class31.field725 = 0;
         }

         class0.method2();
         class33.field779[class41.field989.field157?1:0].method1855(class31.field720 + 765 - 40, 463);
         if(client.field303 > 5 && 0 == client.field302) {
            if(null != class95.field1627) {
               var25 = 5 + class31.field720;
               var26 = 463;
               byte var34 = 100;
               byte var29 = 35;
               class95.field1627.method1855(var25, var26);
               var0.method4039("World" + " " + client.field296, var34 / 2 + var25, var26 + var29 / 2 - 2, 16777215, 0);
               if(class47.field1080 != null) {
                  var1.method4039("Loading...", var25 + var34 / 2, 12 + var29 / 2 + var26, 16777215, 0);
               } else {
                  var1.method4039("Click to switch", var34 / 2 + var25, 12 + var26 + var29 / 2, 16777215, 0);
               }
            } else {
               class95.field1627 = class126.method2818(class35.field795, "sl_button", "");
            }
         }

         try {
            var41 = class87.field1537.getGraphics();
            class42.field991.vmethod1870(var41, 0, 0);
         } catch (Exception var23) {
            class87.field1537.repaint();
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-5"
   )
   void method1027(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1089 = (char)var1.method2506();
      } else if(var2 == 2) {
         this.field1094 = (char)var1.method2506();
      } else if(3 == var2) {
         this.field1091 = var1.method2683();
      } else if(4 == var2) {
         this.field1092 = var1.method2511();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1093 = var1.method2508();
            this.field1095 = new int[this.field1093];
            this.field1096 = new String[this.field1093];

            for(var3 = 0; var3 < this.field1093; ++var3) {
               this.field1095[var3] = var1.method2511();
               this.field1096[var3] = var1.method2683();
            }
         } else if(var2 == 6) {
            this.field1093 = var1.method2508();
            this.field1095 = new int[this.field1093];
            this.field1090 = new int[this.field1093];

            for(var3 = 0; var3 < this.field1093; ++var3) {
               this.field1095[var3] = var1.method2511();
               this.field1090[var3] = var1.method2511();
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "192799411"
   )
   public static void method1033(int var0) {
      if(-1 != var0) {
         if(class173.field2759[var0]) {
            class138.field2153.method3300(var0);
            if(null != class173.field2830[var0]) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class173.field2830[var0].length; ++var2) {
                  if(class173.field2830[var0][var2] != null) {
                     if(2 != class173.field2830[var0][var2].field2814) {
                        class173.field2830[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class173.field2830[var0] = null;
               }

               class173.field2759[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("x")
   void method1034(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(var2 == 0) {
            return;
         }

         this.method1027(var1, var2);
      }
   }
}
