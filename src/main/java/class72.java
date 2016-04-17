import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class72 implements Runnable {
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -293329619
   )
   static int field1355;
   @ObfuscatedName("a")
   class136 field1357;
   @ObfuscatedName("c")
   volatile boolean field1358 = false;
   @ObfuscatedName("dk")
   static int[] field1359;
   @ObfuscatedName("w")
   volatile class56[] field1360 = new class56[2];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2031862371
   )
   public static int field1361;
   @ObfuscatedName("d")
   volatile boolean field1362 = false;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;Lclass224;ZI)V",
      garbageValue = "829039927"
   )
   static void method1676(class224 var0, class224 var1, class224 var2, boolean var3) {
      if(var3) {
         class31.field723 = (class37.field876 - client.field438) / 2;
         class31.field730 = class31.field723 + 202;
      }

      byte var4;
      int var5;
      int var7;
      int var25;
      int var29;
      int var30;
      Graphics var36;
      if(class31.field748) {
         if(null == class56.field1204) {
            class56.field1204 = class18.method227(class103.field1768, "sl_back", "");
         }

         if(null == class28.field688) {
            class28.field688 = class84.method1995(class103.field1768, "sl_flags", "");
         }

         if(class46.field1066 == null) {
            class46.field1066 = class84.method1995(class103.field1768, "sl_arrows", "");
         }

         if(class31.field754 == null) {
            class31.field754 = class84.method1995(class103.field1768, "sl_stars", "");
         }

         class79.method1929(class31.field723, 23, 765, 480, 0);
         class79.method1900(class31.field723, 0, 125, 23, 12425273, 9135624);
         class79.method1900(125 + class31.field723, 0, 640, 23, 5197647, 2697513);
         var0.method4118("Select a world", 62 + class31.field723, 15, 0, -1);
         if(null != class31.field754) {
            class31.field754[1].method1962(class31.field723 + 140, 1);
            var1.method4116("Members only world", class31.field723 + 152, 10, 16777215, -1);
            class31.field754[0].method1962(class31.field723 + 140, 12);
            var1.method4116("Free world", 152 + class31.field723, 21, 16777215, -1);
         }

         if(null != class46.field1066) {
            var25 = 280 + class31.field723;
            if(class25.field652[0] == 0 && 0 == class25.field643[0]) {
               class46.field1066[2].method1962(var25, 4);
            } else {
               class46.field1066[0].method1962(var25, 4);
            }

            if(class25.field652[0] == 0 && class25.field643[0] == 1) {
               class46.field1066[3].method1962(15 + var25, 4);
            } else {
               class46.field1066[1].method1962(15 + var25, 4);
            }

            var0.method4116("World", var25 + 32, 17, 16777215, -1);
            var5 = 390 + class31.field723;
            if(1 == class25.field652[0] && class25.field643[0] == 0) {
               class46.field1066[2].method1962(var5, 4);
            } else {
               class46.field1066[0].method1962(var5, 4);
            }

            if(class25.field652[0] == 1 && class25.field643[0] == 1) {
               class46.field1066[3].method1962(var5 + 15, 4);
            } else {
               class46.field1066[1].method1962(var5 + 15, 4);
            }

            var0.method4116("Players", var5 + 32, 17, 16777215, -1);
            var30 = class31.field723 + 500;
            if(2 == class25.field652[0] && class25.field643[0] == 0) {
               class46.field1066[2].method1962(var30, 4);
            } else {
               class46.field1066[0].method1962(var30, 4);
            }

            if(class25.field652[0] == 2 && class25.field643[0] == 1) {
               class46.field1066[3].method1962(15 + var30, 4);
            } else {
               class46.field1066[1].method1962(15 + var30, 4);
            }

            var0.method4116("Location", 32 + var30, 17, 16777215, -1);
            var7 = 610 + class31.field723;
            if(3 == class25.field652[0] && class25.field643[0] == 0) {
               class46.field1066[2].method1962(var7, 4);
            } else {
               class46.field1066[0].method1962(var7, 4);
            }

            if(3 == class25.field652[0] && class25.field643[0] == 1) {
               class46.field1066[3].method1962(var7 + 15, 4);
            } else {
               class46.field1066[1].method1962(15 + var7, 4);
            }

            var0.method4116("Type", 32 + var7, 17, 16777215, -1);
         }

         class79.method1929(708 + class31.field723, 4, 50, 16, 0);
         var1.method4118("Cancel", 708 + class31.field723 + 25, 16, 16777215, -1);
         class31.field755 = -1;
         if(class56.field1204 != null) {
            var4 = 88;
            byte var33 = 19;
            var30 = 765 / (var4 + 1);
            var7 = 480 / (1 + var33);

            int var32;
            do {
               var29 = var7;
               var32 = var30;
               if((var30 - 1) * var7 >= class25.field650) {
                  --var30;
               }

               if((var7 - 1) * var30 >= class25.field650) {
                  --var7;
               }

               if((var7 - 1) * var30 >= class25.field650) {
                  --var7;
               }
            } while(var7 != var29 || var30 != var32);

            var29 = (765 - var30 * var4) / (var30 + 1);
            if(var29 > 5) {
               var29 = 5;
            }

            var32 = (480 - var7 * var33) / (var7 + 1);
            if(var32 > 5) {
               var32 = 5;
            }

            int var10 = (765 - var30 * var4 - (var30 - 1) * var29) / 2;
            int var11 = (480 - var7 * var33 - (var7 - 1) * var32) / 2;
            int var12 = 23 + var11;
            int var13 = var10 + class31.field723;
            int var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < class25.field650; ++var16) {
               class25 var17 = class129.field2051[var16];
               boolean var18 = true;
               String var19 = Integer.toString(var17.field648);
               if(-1 == var17.field648) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.field648 > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var20;
               if(var17.method684()) {
                  if(var17.method679()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method706()) {
                  var21 = 16711680;
                  if(var17.method679()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method681()) {
                  if(var17.method679()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method679()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class140.field2151 >= var13 && class140.field2161 >= var12 && class140.field2151 < var4 + var13 && class140.field2161 < var12 + var33 && var18) {
                  class31.field755 = var16;
                  class56.field1204[var20].method1802(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class56.field1204[var20].method1796(var13, var12);
               }

               if(class28.field688 != null) {
                  class28.field688[(var17.method679()?8:0) + var17.field651].method1962(29 + var13, var12);
               }

               var0.method4118(Integer.toString(var17.field646), 15 + var13, var33 / 2 + var12 + 5, var21, -1);
               var1.method4118(var19, 60 + var13, var12 + var33 / 2 + 5, 268435455, -1);
               var12 += var33 + var32;
               ++var14;
               if(var14 >= var7) {
                  var12 = var11 + 23;
                  var13 += var4 + var29;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4111(class129.field2051[class31.field755].field649) + 6;
               int var35 = 8 + var1.field3190;
               class79.method1929(class140.field2151 - var16 / 2, class140.field2161 + 20 + 5, var16, var35, 16777120);
               class79.method1941(class140.field2151 - var16 / 2, class140.field2161 + 20 + 5, var16, var35, 0);
               var1.method4118(class129.field2051[class31.field755].field649, class140.field2151, 4 + var1.field3190 + 5 + 20 + class140.field2161, 0, -1);
            }
         }

         try {
            var36 = class158.field2585.getGraphics();
            class28.field695.vmethod1970(var36, 0, 0);
         } catch (Exception var22) {
            class158.field2585.repaint();
         }

      } else {
         if(var3) {
            class31.field727.method1796(class31.field723, 0);
            class31.field728.method1796(382 + class31.field723, 0);
            class30.field715.method1962(382 + class31.field723 - class30.field715.field1419 / 2, 18);
         }

         if(0 == client.field554 || 5 == client.field554) {
            var4 = 20;
            var0.method4118("RuneScape is loading - please wait...", 180 + class31.field730, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1941(class31.field730 + 180 - 152, var5, 304, 34, 9179409);
            class79.method1941(180 + class31.field730 - 151, 1 + var5, 302, 32, 0);
            class79.method1929(180 + class31.field730 - 150, var5 + 2, class31.field746 * 3, 30, 9179409);
            class79.method1929(class31.field746 * 3 + (class31.field730 + 180 - 150), 2 + var5, 300 - class31.field746 * 3, 30, 0);
            var0.method4118(class31.field744, 180 + class31.field730, 276 - var4, 16777215, -1);
         }

         String var6;
         short var24;
         short var26;
         if(client.field554 == 20) {
            class31.field747.method1962(180 + class31.field730 - class31.field747.field1419 / 2, 271 - class31.field747.field1420 / 2);
            var24 = 211;
            var0.method4118(class31.field743, 180 + class31.field730, var24, 16776960, 0);
            var25 = var24 + 15;
            var0.method4118(class31.field724, class31.field730 + 180, var25, 16776960, 0);
            var25 += 15;
            var0.method4118(class31.field745, class31.field730 + 180, var25, 16776960, 0);
            var25 += 15;
            var25 += 10;
            if(class31.field726 != 4) {
               var0.method4116("Login: ", 180 + class31.field730 - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class31.field749; var0.method4111(var6) > var26; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4116(class223.method4115(var6), 180 + class31.field730 - 70, var25, 16777215, 0);
               var25 += 15;
               var0.method4116("Password: " + class13.method199(class31.field740), class31.field730 + 180 - 108, var25, 16777215, 0);
               var25 += 15;
            }
         }

         if(client.field554 == 10 || 11 == client.field554) {
            class31.field747.method1962(class31.field730, 171);
            short var27;
            if(class31.field726 == 0) {
               var24 = 251;
               var0.method4118("Welcome to RuneScape", class31.field730 + 180, var24, 16776960, 0);
               var25 = var24 + 30;
               var5 = class31.field730 + 180 - 80;
               var27 = 291;
               class31.field725.method1962(var5 - 73, var27 - 20);
               var0.method4119("New User", var5 - 73, var27 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 180 + class31.field730 + 80;
               class31.field725.method1962(var5 - 73, var27 - 20);
               var0.method4119("Existing User", var5 - 73, var27 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(1 == class31.field726) {
               var0.method4118(class31.field742, 180 + class31.field730, 211, 16776960, 0);
               var24 = 236;
               var0.method4118(class31.field743, 180 + class31.field730, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method4118(class31.field724, 180 + class31.field730, var25, 16777215, 0);
               var25 += 15;
               var0.method4118(class31.field745, class31.field730 + 180, var25, 16777215, 0);
               var25 += 15;
               var5 = 180 + class31.field730 - 80;
               var27 = 321;
               class31.field725.method1962(var5 - 73, var27 - 20);
               var0.method4118("Continue", var5, 5 + var27, 16777215, 0);
               var5 = 80 + class31.field730 + 180;
               class31.field725.method1962(var5 - 73, var27 - 20);
               var0.method4118("Cancel", var5, var27 + 5, 16777215, 0);
            } else {
               short var8;
               if(2 == class31.field726) {
                  var24 = 211;
                  var0.method4118(class31.field743, 180 + class31.field730, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var0.method4118(class31.field724, class31.field730 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4118(class31.field745, 180 + class31.field730, var25, 16776960, 0);
                  var25 += 15;
                  var25 += 10;
                  var0.method4116("Login: ", 180 + class31.field730 - 110, var25, 16777215, 0);
                  var26 = 200;

                  for(var6 = class31.field749; var0.method4111(var6) > var26; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4116(class223.method4115(var6) + (class31.field750 == 0 & client.field306 % 40 < 20?class139.method3046(16776960) + "|":""), class31.field730 + 180 - 70, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4116("Password: " + class13.method199(class31.field740) + (1 == class31.field750 & client.field306 % 40 < 20?class139.method3046(16776960) + "|":""), class31.field730 + 180 - 108, var25, 16777215, 0);
                  var25 += 15;
                  var7 = class31.field730 + 180 - 80;
                  var8 = 321;
                  class31.field725.method1962(var7 - 73, var8 - 20);
                  var0.method4118("Login", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + 180 + class31.field730;
                  class31.field725.method1962(var7 - 73, var8 - 20);
                  var0.method4118("Cancel", var7, var8 + 5, 16777215, 0);
                  var24 = 357;
                  var1.method4118("Forgotten your password? <col=ffffff>Click here.", class31.field730 + 180, var24, 16776960, 0);
               } else if(3 == class31.field726) {
                  var24 = 201;
                  var0.method4118("Invalid username or password.", class31.field730 + 180, var24, 16776960, 0);
                  var25 = var24 + 20;
                  var1.method4118("For accounts created after 24th November 2010, please use your", 180 + class31.field730, var25, 16776960, 0);
                  var25 += 15;
                  var1.method4118("email address to login. Otherwise please login with your username.", class31.field730 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var5 = class31.field730 + 180;
                  var27 = 276;
                  class31.field725.method1962(var5 - 73, var27 - 20);
                  var2.method4118("Try again", var5, var27 + 5, 16777215, 0);
                  var5 = class31.field730 + 180;
                  var27 = 326;
                  class31.field725.method1962(var5 - 73, var27 - 20);
                  var2.method4118("Forgotten password?", var5, 5 + var27, 16777215, 0);
               } else if(class31.field726 == 4) {
                  var0.method4118("Authenticator", class31.field730 + 180, 211, 16776960, 0);
                  var24 = 236;
                  var0.method4118(class31.field743, class31.field730 + 180, var24, 16777215, 0);
                  var25 = var24 + 15;
                  var0.method4118(class31.field724, 180 + class31.field730, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4118(class31.field745, 180 + class31.field730, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4116("PIN: " + class13.method199(class25.field653) + (client.field306 % 40 < 20?class139.method3046(16776960) + "|":""), class31.field730 + 180 - 108, var25, 16777215, 0);
                  var25 -= 8;
                  var0.method4116("Trust this computer", 180 + class31.field730 - 9, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4116("for 30 days: ", class31.field730 + 180 - 9, var25, 16776960, 0);
                  var5 = 180 + class31.field730 - 9 + var0.method4111("for 30 days: ") + 15;
                  var30 = var25 - var0.field3190;
                  class80 var28;
                  if(class31.field735) {
                     var28 = class115.field1971;
                  } else {
                     var28 = class14.field221;
                  }

                  var28.method1962(var5, var30);
                  var25 += 15;
                  var29 = class31.field730 + 180 - 80;
                  short var9 = 321;
                  class31.field725.method1962(var29 - 73, var9 - 20);
                  var0.method4118("Continue", var29, 5 + var9, 16777215, 0);
                  var29 = class31.field730 + 180 + 80;
                  class31.field725.method1962(var29 - 73, var9 - 20);
                  var0.method4118("Cancel", var29, var9 + 5, 16777215, 0);
                  var1.method4118("<u=ff>Can\'t Log In?</u>", class31.field730 + 180, 36 + var9, 255, 0);
               } else if(5 == class31.field726) {
                  var0.method4118("Forgotten your password?", class31.field730 + 180, 201, 16776960, 0);
                  var24 = 221;
                  var2.method4118(class31.field743, 180 + class31.field730, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var2.method4118(class31.field724, class31.field730 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var2.method4118(class31.field745, class31.field730 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var25 += 14;
                  var0.method4116("Username/email: ", 180 + class31.field730 - 145, var25, 16777215, 0);
                  var26 = 174;

                  for(var6 = class31.field749; var0.method4111(var6) > var26; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4116(class223.method4115(var6) + (client.field306 % 40 < 20?class139.method3046(16776960) + "|":""), 180 + class31.field730 - 34, var25, 16777215, 0);
                  var25 += 15;
                  var7 = class31.field730 + 180 - 80;
                  var8 = 321;
                  class31.field725.method1962(var7 - 73, var8 - 20);
                  var0.method4118("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + class31.field730 + 180;
                  class31.field725.method1962(var7 - 73, var8 - 20);
                  var0.method4118("Back", var7, 5 + var8, 16777215, 0);
               } else if(6 == class31.field726) {
                  var24 = 211;
                  var0.method4118(class31.field743, class31.field730 + 180, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var0.method4118(class31.field724, class31.field730 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4118(class31.field745, 180 + class31.field730, var25, 16776960, 0);
                  var25 += 15;
                  var5 = 180 + class31.field730;
                  var27 = 321;
                  class31.field725.method1962(var5 - 73, var27 - 20);
                  var0.method4118("Back", var5, 5 + var27, 16777215, 0);
               }
            }
         }

         if(class31.field737 > 0) {
            class5.method118(class31.field737);
            class31.field737 = 0;
         }

         class17.method221();
         class31.field729[class134.field2078.field154?1:0].method1962(class31.field723 + 765 - 40, 463);
         if(client.field554 > 5 && client.field372 == 0) {
            if(class39.field923 != null) {
               var25 = 5 + class31.field723;
               var26 = 463;
               byte var34 = 100;
               byte var31 = 35;
               class39.field923.method1962(var25, var26);
               var0.method4118("World" + " " + client.field296, var34 / 2 + var25, var26 + var31 / 2 - 2, 16777215, 0);
               if(class25.field645 != null) {
                  var1.method4118("Loading...", var34 / 2 + var25, 12 + var26 + var31 / 2, 16777215, 0);
               } else {
                  var1.method4118("Click to switch", var34 / 2 + var25, var31 / 2 + var26 + 12, 16777215, 0);
               }
            } else {
               class39.field923 = class6.method133(class103.field1768, "sl_button", "");
            }
         }

         try {
            var36 = class158.field2585.getGraphics();
            class28.field695.vmethod1970(var36, 0, 0);
         } catch (Exception var23) {
            class158.field2585.repaint();
         }

      }
   }

   public void run() {
      this.field1358 = true;

      try {
         while(!this.field1362) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class56 var2 = this.field1360[var1];
               if(null != var2) {
                  var2.method1277();
               }
            }

            class4.method55(10L);
            class121.method2860(this.field1357, (Object)null);
         }
      } catch (Exception var6) {
         class22.method655((String)null, var6);
      } finally {
         this.field1358 = false;
      }

   }
}
