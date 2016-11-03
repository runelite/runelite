import java.awt.Graphics;
import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class38 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 744032831
   )
   static int field810 = 0;
   @ObfuscatedName("v")
   static int[] field811 = new int[5];
   @ObfuscatedName("m")
   static int[] field812 = new int[1000];
   @ObfuscatedName("y")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2084737631
   )
   static int field815 = 0;
   @ObfuscatedName("h")
   static class14[] field816 = new class14[50];
   @ObfuscatedName("g")
   static Calendar field817 = Calendar.getInstance();
   @ObfuscatedName("e")
   static final String[] field818 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("f")
   static int[] field819;
   @ObfuscatedName("bq")
   static class171 field820;
   @ObfuscatedName("rm")
   protected static String field821;
   @ObfuscatedName("j")
   static int[][] field823 = new int[5][5000];

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass125;S)I",
      garbageValue = "31267"
   )
   static int method762(class125 var0) {
      int var1 = var0.method2807(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2807(5);
      } else if(var1 == 2) {
         var2 = var0.method2807(8);
      } else {
         var2 = var0.method2807(11);
      }

      return var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;Lclass227;ZI)V",
      garbageValue = "-1410325978"
   )
   static void method763(class227 var0, class227 var1, class227 var2, boolean var3) {
      if(var3) {
         class33.field729 = (GroundObject.field1652 - Client.field495) / 2;
         class33.loginWindowX = class33.field729 + 202;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      int var14;
      Graphics var23;
      int var34;
      int var36;
      int var37;
      int var40;
      int var41;
      if(class33.worldSelectShown) {
         if(null == FrameMap.field1828) {
            FrameMap.field1828 = Buffer.method2769(class127.field2092, "sl_back", "");
         }

         if(class11.field165 == null) {
            class11.field165 = class48.method984(class127.field2092, "sl_flags", "");
         }

         if(null == class110.field1944) {
            class110.field1944 = class48.method984(class127.field2092, "sl_arrows", "");
         }

         if(class110.field1942 == null) {
            class110.field1942 = class48.method984(class127.field2092, "sl_stars", "");
         }

         class82.method1885(class33.field729, 23, 765, 480, 0);
         class82.method1863(class33.field729, 0, 125, 23, 12425273, 9135624);
         class82.method1863(125 + class33.field729, 0, 640, 23, 5197647, 2697513);
         var0.method4059("Select a world", class33.field729 + 62, 15, 0, -1);
         if(class110.field1942 != null) {
            class110.field1942[1].method1911(class33.field729 + 140, 1);
            var1.method4118("Members only world", class33.field729 + 152, 10, 16777215, -1);
            class110.field1942[0].method1911(140 + class33.field729, 12);
            var1.method4118("Free world", class33.field729 + 152, 21, 16777215, -1);
         }

         if(class110.field1944 != null) {
            var34 = 280 + class33.field729;
            if(World.field645[0] == 0 && World.field644[0] == 0) {
               class110.field1944[2].method1911(var34, 4);
            } else {
               class110.field1944[0].method1911(var34, 4);
            }

            if(World.field645[0] == 0 && World.field644[0] == 1) {
               class110.field1944[3].method1911(15 + var34, 4);
            } else {
               class110.field1944[1].method1911(var34 + 15, 4);
            }

            var0.method4118("World", var34 + 32, 17, 16777215, -1);
            var5 = class33.field729 + 390;
            if(World.field645[0] == 1 && World.field644[0] == 0) {
               class110.field1944[2].method1911(var5, 4);
            } else {
               class110.field1944[0].method1911(var5, 4);
            }

            if(World.field645[0] == 1 && World.field644[0] == 1) {
               class110.field1944[3].method1911(15 + var5, 4);
            } else {
               class110.field1944[1].method1911(var5 + 15, 4);
            }

            var0.method4118("Players", 32 + var5, 17, 16777215, -1);
            var36 = class33.field729 + 500;
            if(World.field645[0] == 2 && World.field644[0] == 0) {
               class110.field1944[2].method1911(var36, 4);
            } else {
               class110.field1944[0].method1911(var36, 4);
            }

            if(World.field645[0] == 2 && World.field644[0] == 1) {
               class110.field1944[3].method1911(var36 + 15, 4);
            } else {
               class110.field1944[1].method1911(15 + var36, 4);
            }

            var0.method4118("Location", var36 + 32, 17, 16777215, -1);
            var7 = class33.field729 + 610;
            if(World.field645[0] == 3 && World.field644[0] == 0) {
               class110.field1944[2].method1911(var7, 4);
            } else {
               class110.field1944[0].method1911(var7, 4);
            }

            if(World.field645[0] == 3 && World.field644[0] == 1) {
               class110.field1944[3].method1911(15 + var7, 4);
            } else {
               class110.field1944[1].method1911(var7 + 15, 4);
            }

            var0.method4118("Type", 32 + var7, 17, 16777215, -1);
         }

         class82.method1885(708 + class33.field729, 4, 50, 16, 0);
         var1.method4059("Cancel", 708 + class33.field729 + 25, 16, 16777215, -1);
         class33.field762 = -1;
         if(null != FrameMap.field1828) {
            var4 = 88;
            byte var42 = 19;
            var36 = 765 / (var4 + 1);
            var7 = 480 / (1 + var42);

            do {
               var37 = var7;
               var9 = var36;
               if((var36 - 1) * var7 >= World.field656) {
                  --var36;
               }

               if(var36 * (var7 - 1) >= World.field656) {
                  --var7;
               }

               if((var7 - 1) * var36 >= World.field656) {
                  --var7;
               }
            } while(var37 != var7 || var36 != var9);

            var37 = (765 - var36 * var4) / (1 + var36);
            if(var37 > 5) {
               var37 = 5;
            }

            var9 = (480 - var42 * var7) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var4 * var36 - (var36 - 1) * var37) / 2;
            var11 = (480 - var7 * var42 - (var7 - 1) * var9) / 2;
            var40 = 23 + var11;
            var41 = class33.field729 + var10;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field656; ++var16) {
               World var17 = ItemComposition.worldList[var16];
               boolean var18 = true;
               String var19 = Integer.toString(var17.playerCount);
               if(var17.playerCount == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.playerCount > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var20;
               if(var17.method626()) {
                  if(var17.method621()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method625()) {
                  var21 = 16711680;
                  if(var17.method621()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method649()) {
                  if(var17.method621()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method621()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class143.field2200 >= var41 && class143.field2204 >= var40 && class143.field2200 < var41 + var4 && class143.field2204 < var40 + var42 && var18) {
                  class33.field762 = var16;
                  FrameMap.field1828[var20].method1753(var41, var40, 128, 16777215);
                  var15 = true;
               } else {
                  FrameMap.field1828[var20].method1767(var41, var40);
               }

               if(null != class11.field165) {
                  class11.field165[(var17.method621()?8:0) + var17.location].method1911(29 + var41, var40);
               }

               var0.method4059(Integer.toString(var17.id), var41 + 15, var42 / 2 + var40 + 5, var21, -1);
               var1.method4059(var19, var41 + 60, 5 + var42 / 2 + var40, 268435455, -1);
               var40 += var9 + var42;
               ++var14;
               if(var14 >= var7) {
                  var40 = var11 + 23;
                  var41 += var37 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4047(ItemComposition.worldList[class33.field762].activity) + 6;
               int var22 = 8 + var1.field3240;
               class82.method1885(class143.field2200 - var16 / 2, 20 + class143.field2204 + 5, var16, var22, 16777120);
               class82.method1845(class143.field2200 - var16 / 2, class143.field2204 + 20 + 5, var16, var22, 0);
               var1.method4059(ItemComposition.worldList[class33.field762].activity, class143.field2200, var1.field3240 + 20 + class143.field2204 + 5 + 4, 0, -1);
            }
         }

         try {
            var23 = VertexNormal.canvas.getGraphics();
            Sequence.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var31) {
            VertexNormal.canvas.repaint();
         }

      } else {
         if(var3) {
            class33.field748.method1767(class33.field729, 0);
            class33.field732.method1767(class33.field729 + 382, 0);
            class33.field733.method1911(class33.field729 + 382 - class33.field733.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4059("RuneScape is loading - please wait...", class33.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1845(180 + class33.loginWindowX - 152, var5, 304, 34, 9179409);
            class82.method1845(class33.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            class82.method1885(class33.loginWindowX + 180 - 150, var5 + 2, class33.field744 * 3, 30, 9179409);
            class82.method1885(class33.field744 * 3 + (180 + class33.loginWindowX - 150), 2 + var5, 300 - class33.field744 * 3, 30, 0);
            var0.method4059(class33.field742, class33.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var24;
         String var26;
         String var27;
         String var28;
         short var33;
         short var35;
         if(Client.gameState == 20) {
            class33.field730.method1911(180 + class33.loginWindowX - class33.field730.originalWidth / 2, 271 - class33.field730.height / 2);
            var33 = 211;
            var0.method4059(class33.loginMessage1, class33.loginWindowX + 180, var33, 16776960, 0);
            var34 = var33 + 15;
            var0.method4059(class33.loginMessage2, class33.loginWindowX + 180, var34, 16776960, 0);
            var34 += 15;
            var0.method4059(class33.loginMessage3, class33.loginWindowX + 180, var34, 16776960, 0);
            var34 += 15;
            var34 += 10;
            if(class33.loginIndex != 4) {
               var0.method4118("Login: ", class33.loginWindowX + 180 - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class33.username; var0.method4047(var24) > var35; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method4118(class226.method4060(var24), class33.loginWindowX + 180 - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class33.field754;
               var28 = VertexNormal.method2266('*', var27.length());
               var0.method4118(var26 + var28, class33.loginWindowX + 180 - 108, var34, 16777215, 0);
               var34 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class33.field730.method1911(class33.loginWindowX, 171);
            short var6;
            if(class33.loginIndex == 0) {
               var33 = 251;
               var0.method4059("Welcome to RuneScape", 180 + class33.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 30;
               var5 = class33.loginWindowX + 180 - 80;
               var6 = 291;
               class232.field3280.method1911(var5 - 73, var6 - 20);
               var0.method4055("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class33.loginWindowX + 180;
               class232.field3280.method1911(var5 - 73, var6 - 20);
               var0.method4055("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.loginIndex == 1) {
               var0.method4059(class33.field736, 180 + class33.loginWindowX, 211, 16776960, 0);
               var33 = 236;
               var0.method4059(class33.loginMessage1, class33.loginWindowX + 180, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method4059(class33.loginMessage2, 180 + class33.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var0.method4059(class33.loginMessage3, 180 + class33.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var5 = class33.loginWindowX + 180 - 80;
               var6 = 321;
               class232.field3280.method1911(var5 - 73, var6 - 20);
               var0.method4059("Continue", var5, 5 + var6, 16777215, 0);
               var5 = 180 + class33.loginWindowX + 80;
               class232.field3280.method1911(var5 - 73, var6 - 20);
               var0.method4059("Cancel", var5, 5 + var6, 16777215, 0);
            } else if(class33.loginIndex == 2) {
               var33 = 211;
               var0.method4059(class33.loginMessage1, 180 + class33.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method4059(class33.loginMessage2, 180 + class33.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var0.method4059(class33.loginMessage3, 180 + class33.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var34 += 10;
               var0.method4118("Login: ", 180 + class33.loginWindowX - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class33.username; var0.method4047(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method4118(class226.method4060(var24) + (class33.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class144.method3013(16776960) + "|":""), 180 + class33.loginWindowX - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class33.field754;
               var28 = VertexNormal.method2266('*', var27.length());
               var0.method4118(var26 + var28 + (class33.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class144.method3013(16776960) + "|":""), 180 + class33.loginWindowX - 108, var34, 16777215, 0);
               var34 += 15;
               var11 = class33.loginWindowX + 180 - 80;
               short var12 = 321;
               class232.field3280.method1911(var11 - 73, var12 - 20);
               var0.method4059("Login", var11, 5 + var12, 16777215, 0);
               var11 = 80 + class33.loginWindowX + 180;
               class232.field3280.method1911(var11 - 73, var12 - 20);
               var0.method4059("Cancel", var11, 5 + var12, 16777215, 0);
               var33 = 357;
               var1.method4059("Forgotten your password? <col=ffffff>Click here.", 180 + class33.loginWindowX, var33, 16776960, 0);
            } else if(class33.loginIndex == 3) {
               var33 = 201;
               var0.method4059("Invalid username or password.", class33.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 20;
               var1.method4059("For accounts created after 24th November 2010, please use your", 180 + class33.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var1.method4059("email address to login. Otherwise please login with your username.", class33.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var5 = class33.loginWindowX + 180;
               var6 = 276;
               class232.field3280.method1911(var5 - 73, var6 - 20);
               var2.method4059("Try again", var5, var6 + 5, 16777215, 0);
               var5 = 180 + class33.loginWindowX;
               var6 = 326;
               class232.field3280.method1911(var5 - 73, var6 - 20);
               var2.method4059("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class33.loginIndex == 4) {
               var0.method4059("Authenticator", 180 + class33.loginWindowX, 211, 16776960, 0);
               var33 = 236;
               var0.method4059(class33.loginMessage1, 180 + class33.loginWindowX, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method4059(class33.loginMessage2, 180 + class33.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var0.method4059(class33.loginMessage3, class33.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var24 = "PIN: ";
               var26 = class23.authCode;
               String var25 = VertexNormal.method2266('*', var26.length());
               var0.method4118(var24 + var25 + (Client.gameCycle % 40 < 20?class144.method3013(16776960) + "|":""), class33.loginWindowX + 180 - 108, var34, 16777215, 0);
               var34 -= 8;
               var0.method4118("Trust this computer", 180 + class33.loginWindowX - 9, var34, 16776960, 0);
               var34 += 15;
               var0.method4118("for 30 days: ", 180 + class33.loginWindowX - 9, var34, 16776960, 0);
               var9 = 180 + class33.loginWindowX - 9 + var0.method4047("for 30 days: ") + 15;
               var10 = var34 - var0.field3240;
               ModIcon var30;
               if(class33.field757) {
                  var30 = class50.field1109;
               } else {
                  var30 = Ignore.field128;
               }

               var30.method1911(var9, var10);
               var34 += 15;
               var40 = class33.loginWindowX + 180 - 80;
               short var13 = 321;
               class232.field3280.method1911(var40 - 73, var13 - 20);
               var0.method4059("Continue", var40, 5 + var13, 16777215, 0);
               var40 = 80 + class33.loginWindowX + 180;
               class232.field3280.method1911(var40 - 73, var13 - 20);
               var0.method4059("Cancel", var40, var13 + 5, 16777215, 0);
               var1.method4059("<u=ff>Can\'t Log In?</u>", 180 + class33.loginWindowX, var13 + 36, 255, 0);
            } else if(class33.loginIndex == 5) {
               var0.method4059("Forgotten your password?", 180 + class33.loginWindowX, 201, 16776960, 0);
               var33 = 221;
               var2.method4059(class33.loginMessage1, 180 + class33.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 15;
               var2.method4059(class33.loginMessage2, 180 + class33.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var2.method4059(class33.loginMessage3, 180 + class33.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var34 += 14;
               var0.method4118("Username/email: ", 180 + class33.loginWindowX - 145, var34, 16777215, 0);
               var35 = 174;

               for(var24 = class33.username; var0.method4047(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method4118(class226.method4060(var24) + (Client.gameCycle % 40 < 20?class144.method3013(16776960) + "|":""), 180 + class33.loginWindowX - 34, var34, 16777215, 0);
               var34 += 15;
               var7 = class33.loginWindowX + 180 - 80;
               short var8 = 321;
               class232.field3280.method1911(var7 - 73, var8 - 20);
               var0.method4059("Recover", var7, 5 + var8, 16777215, 0);
               var7 = 80 + 180 + class33.loginWindowX;
               class232.field3280.method1911(var7 - 73, var8 - 20);
               var0.method4059("Back", var7, 5 + var8, 16777215, 0);
            } else if(class33.loginIndex == 6) {
               var33 = 211;
               var0.method4059(class33.loginMessage1, class33.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method4059(class33.loginMessage2, 180 + class33.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var0.method4059(class33.loginMessage3, 180 + class33.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var5 = 180 + class33.loginWindowX;
               var6 = 321;
               class232.field3280.method1911(var5 - 73, var6 - 20);
               var0.method4059("Back", var5, 5 + var6, 16777215, 0);
            }
         }

         if(class33.field755 > 0) {
            var34 = class33.field755;
            var35 = 256;
            class33.field734 += 128 * var34;
            if(class33.field734 > class217.field3202.length) {
               class33.field734 -= class217.field3202.length;
               var36 = (int)(Math.random() * 12.0D);
               XItemContainer.method160(class14.field209[var36]);
            }

            var36 = 0;
            var7 = var34 * 128;
            var37 = (var35 - var34) * 128;

            for(var9 = 0; var9 < var37; ++var9) {
               var10 = class9.field153[var36 + var7] - var34 * class217.field3202[class33.field734 + var36 & class217.field3202.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class9.field153[var36++] = var10;
            }

            for(var9 = var35 - var34; var9 < var35; ++var9) {
               var10 = 128 * var9;

               for(var11 = 0; var11 < 128; ++var11) {
                  var40 = (int)(Math.random() * 100.0D);
                  if(var40 < 50 && var11 > 10 && var11 < 118) {
                     class9.field153[var11 + var10] = 255;
                  } else {
                     class9.field153[var10 + var11] = 0;
                  }
               }
            }

            if(class33.field739 > 0) {
               class33.field739 -= var34 * 4;
            }

            if(class33.field740 > 0) {
               class33.field740 -= 4 * var34;
            }

            if(class33.field739 == 0 && class33.field740 == 0) {
               var9 = (int)(Math.random() * (double)(2000 / var34));
               if(var9 == 0) {
                  class33.field739 = 1024;
               }

               if(var9 == 1) {
                  class33.field740 = 1024;
               }
            }

            for(var9 = 0; var9 < var35 - var34; ++var9) {
               class33.field737[var9] = class33.field737[var9 + var34];
            }

            for(var9 = var35 - var34; var9 < var35; ++var9) {
               class33.field737[var9] = (int)(Math.sin((double)class33.field747 / 14.0D) * 16.0D + Math.sin((double)class33.field747 / 15.0D) * 14.0D + Math.sin((double)class33.field747 / 16.0D) * 12.0D);
               ++class33.field747;
            }

            class33.field743 += var34;
            var9 = (var34 + (Client.gameCycle & 1)) / 2;
            if(var9 > 0) {
               for(var10 = 0; var10 < class33.field743 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var40 = (int)(Math.random() * 128.0D) + 128;
                  class9.field153[(var40 << 7) + var11] = 192;
               }

               class33.field743 = 0;
               var10 = 0;

               label624:
               while(true) {
                  if(var10 >= var35) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label624;
                        }

                        var11 = 0;

                        for(var40 = -var9; var40 < var35; ++var40) {
                           var41 = var40 * 128;
                           if(var9 + var40 < var35) {
                              var11 += class33.field741[128 * var9 + var10 + var41];
                           }

                           if(var40 - (1 + var9) >= 0) {
                              var11 -= class33.field741[var41 + var10 - (1 + var9) * 128];
                           }

                           if(var40 >= 0) {
                              class9.field153[var10 + var41] = var11 / (var9 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var40 = 128 * var10;

                  for(var41 = -var9; var41 < 128; ++var41) {
                     if(var41 + var9 < 128) {
                        var11 += class9.field153[var41 + var40 + var9];
                     }

                     if(var41 - (1 + var9) >= 0) {
                        var11 -= class9.field153[var41 + var40 - (1 + var9)];
                     }

                     if(var41 >= 0) {
                        class33.field741[var41 + var40] = var11 / (var9 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class33.field755 = 0;
         }

         var33 = 256;
         if(class33.field739 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field739 > 768) {
                  class178.field2945[var5] = class50.method1042(class23.field594[var5], class33.field738[var5], 1024 - class33.field739);
               } else if(class33.field739 > 256) {
                  class178.field2945[var5] = class33.field738[var5];
               } else {
                  class178.field2945[var5] = class50.method1042(class33.field738[var5], class23.field594[var5], 256 - class33.field739);
               }
            }
         } else if(class33.field740 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field740 > 768) {
                  class178.field2945[var5] = class50.method1042(class23.field594[var5], class21.field582[var5], 1024 - class33.field740);
               } else if(class33.field740 > 256) {
                  class178.field2945[var5] = class21.field582[var5];
               } else {
                  class178.field2945[var5] = class50.method1042(class21.field582[var5], class23.field594[var5], 256 - class33.field740);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class178.field2945[var5] = class23.field594[var5];
            }
         }

         class82.method1834(class33.field729, 9, class33.field729 + 128, var33 + 7);
         class33.field748.method1767(class33.field729, 0);
         class82.method1833();
         var5 = 0;
         var36 = Sequence.bufferProvider.width * 9 + class33.field729;

         for(var7 = 1; var7 < var33 - 1; ++var7) {
            var37 = (var33 - var7) * class33.field737[var7] / var33;
            var9 = 22 + var37;
            if(var9 < 0) {
               var9 = 0;
            }

            var5 += var9;

            for(var10 = var9; var10 < 128; ++var10) {
               var11 = class9.field153[var5++];
               if(var11 != 0) {
                  var40 = var11;
                  var41 = 256 - var11;
                  var11 = class178.field2945[var11];
                  var14 = Sequence.bufferProvider.pixels[var36];
                  Sequence.bufferProvider.pixels[var36++] = ((var14 & '\uff00') * var41 + var40 * (var11 & '\uff00') & 16711680) + ((var14 & 16711935) * var41 + (var11 & 16711935) * var40 & -16711936) >> 8;
               } else {
                  ++var36;
               }
            }

            var36 += var9 + Sequence.bufferProvider.width - 128;
         }

         class82.method1834(class33.field729 + 765 - 128, 9, class33.field729 + 765, 7 + var33);
         class33.field732.method1767(382 + class33.field729, 0);
         class82.method1833();
         var5 = 0;
         var36 = class33.field729 + 24 + Sequence.bufferProvider.width * 9 + 637;

         for(var7 = 1; var7 < var33 - 1; ++var7) {
            var37 = class33.field737[var7] * (var33 - var7) / var33;
            var9 = 103 - var37;
            var36 += var37;

            for(var10 = 0; var10 < var9; ++var10) {
               var11 = class9.field153[var5++];
               if(var11 != 0) {
                  var40 = var11;
                  var41 = 256 - var11;
                  var11 = class178.field2945[var11];
                  var14 = Sequence.bufferProvider.pixels[var36];
                  Sequence.bufferProvider.pixels[var36++] = ((var14 & '\uff00') * var41 + (var11 & '\uff00') * var40 & 16711680) + (var41 * (var14 & 16711935) + var40 * (var11 & 16711935) & -16711936) >> 8;
               } else {
                  ++var36;
               }
            }

            var5 += 128 - var9;
            var36 += Sequence.bufferProvider.width - var9 - var37;
         }

         class5.field76[class130.field2102.field140?1:0].method1911(class33.field729 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field283 == 0) {
            if(null != WidgetNode.field59) {
               var34 = 5 + class33.field729;
               var35 = 463;
               byte var39 = 100;
               byte var38 = 35;
               WidgetNode.field59.method1911(var34, var35);
               var0.method4059("World" + " " + Client.world, var39 / 2 + var34, var38 / 2 + var35 - 2, 16777215, 0);
               if(class93.worldServersDownload != null) {
                  var1.method4059("Loading...", var39 / 2 + var34, 12 + var35 + var38 / 2, 16777215, 0);
               } else {
                  var1.method4059("Click to switch", var39 / 2 + var34, 12 + var38 / 2 + var35, 16777215, 0);
               }
            } else {
               WidgetNode.field59 = VertexNormal.method2267(class127.field2092, "sl_button", "");
            }
         }

         try {
            var23 = VertexNormal.canvas.getGraphics();
            Sequence.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var32) {
            VertexNormal.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   public static void method770() {
      if(class140.keyboard != null) {
         class140 var0 = class140.keyboard;
         synchronized(class140.keyboard) {
            class140.keyboard = null;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1153400368"
   )
   static void method771(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class79.field1441 = var1.method2691();
      class134.field2117 = new int[class79.field1441];
      class79.field1438 = new int[class79.field1441];
      class79.field1439 = new int[class79.field1441];
      ChatLineBuffer.field693 = new int[class79.field1441];
      class110.field1936 = new byte[class79.field1441][];
      var1.offset = var0.length - 7 - class79.field1441 * 8;
      class79.field1436 = var1.method2691();
      class79.field1437 = var1.method2691();
      int var2 = (var1.method2571() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class79.field1441; ++var3) {
         class134.field2117[var3] = var1.method2691();
      }

      for(var3 = 0; var3 < class79.field1441; ++var3) {
         class79.field1438[var3] = var1.method2691();
      }

      for(var3 = 0; var3 < class79.field1441; ++var3) {
         class79.field1439[var3] = var1.method2691();
      }

      for(var3 = 0; var3 < class79.field1441; ++var3) {
         ChatLineBuffer.field693[var3] = var1.method2691();
      }

      var1.offset = var0.length - 7 - class79.field1441 * 8 - 3 * (var2 - 1);
      class26.field634 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class26.field634[var3] = var1.method2575();
         if(class26.field634[var3] == 0) {
            class26.field634[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class79.field1441; ++var3) {
         int var4 = class79.field1439[var3];
         int var5 = ChatLineBuffer.field693[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class110.field1936[var3] = var7;
         int var8 = var1.method2571();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2572();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.method2572();
               }
            }
         }
      }

   }
}
