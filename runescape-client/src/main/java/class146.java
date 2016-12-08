import java.awt.Graphics;
import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class146 {
   @ObfuscatedName("k")
   static int[] field2032;
   @ObfuscatedName("kw")
   static class112 field2033;
   @ObfuscatedName("o")
   Inflater field2035;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "-110"
   )
   public void method2668(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2035 == null) {
            this.field2035 = new Inflater(true);
         }

         try {
            this.field2035.setInput(var1.payload, var1.offset + 10, var1.payload.length - (8 + var1.offset + 10));
            this.field2035.inflate(var2);
         } catch (Exception var4) {
            this.field2035.reset();
            throw new RuntimeException("");
         }

         this.field2035.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class146() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass208;Lclass208;Lclass208;ZI)V",
      garbageValue = "1495913881"
   )
   static void method2670(class208 var0, class208 var1, class208 var2, boolean var3) {
      if(var3) {
         class41.field860 = (TextureProvider.field1200 - Client.field499) / 2;
         class41.loginWindowX = 202 + class41.field860;
      }

      byte var4;
      int var5;
      int var7;
      int var10;
      int var11;
      int var12;
      int var13;
      Graphics var23;
      int var29;
      int var31;
      int var32;
      int var35;
      if(class41.worldSelectShown) {
         if(null == class140.field1991) {
            class140.field1991 = class99.method1900(class206.field3086, "sl_back", "");
         }

         if(null == class174.field2643) {
            class174.field2643 = class116.method2197(class206.field3086, "sl_flags", "");
         }

         if(null == class3.field26) {
            class3.field26 = class116.method2197(class206.field3086, "sl_arrows", "");
         }

         if(class97.field1630 == null) {
            class97.field1630 = class116.method2197(class206.field3086, "sl_stars", "");
         }

         class219.method3899(class41.field860, 23, 765, 480, 0);
         class219.method3910(class41.field860, 0, 125, 23, 12425273, 9135624);
         class219.method3910(class41.field860 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method3787("Select a world", class41.field860 + 62, 15, 0, -1);
         if(null != class97.field1630) {
            class97.field1630[1].method3995(class41.field860 + 140, 1);
            var1.method3784("Members only world", class41.field860 + 152, 10, 16777215, -1);
            class97.field1630[0].method3995(140 + class41.field860, 12);
            var1.method3784("Free world", class41.field860 + 152, 21, 16777215, -1);
         }

         if(null != class3.field26) {
            var29 = 280 + class41.field860;
            if(World.field696[0] == 0 && World.field675[0] == 0) {
               class3.field26[2].method3995(var29, 4);
            } else {
               class3.field26[0].method3995(var29, 4);
            }

            if(World.field696[0] == 0 && World.field675[0] == 1) {
               class3.field26[3].method3995(15 + var29, 4);
            } else {
               class3.field26[1].method3995(15 + var29, 4);
            }

            var0.method3784("World", 32 + var29, 17, 16777215, -1);
            var5 = 390 + class41.field860;
            if(World.field696[0] == 1 && World.field675[0] == 0) {
               class3.field26[2].method3995(var5, 4);
            } else {
               class3.field26[0].method3995(var5, 4);
            }

            if(World.field696[0] == 1 && World.field675[0] == 1) {
               class3.field26[3].method3995(var5 + 15, 4);
            } else {
               class3.field26[1].method3995(15 + var5, 4);
            }

            var0.method3784("Players", var5 + 32, 17, 16777215, -1);
            var31 = 500 + class41.field860;
            if(World.field696[0] == 2 && World.field675[0] == 0) {
               class3.field26[2].method3995(var31, 4);
            } else {
               class3.field26[0].method3995(var31, 4);
            }

            if(World.field696[0] == 2 && World.field675[0] == 1) {
               class3.field26[3].method3995(var31 + 15, 4);
            } else {
               class3.field26[1].method3995(15 + var31, 4);
            }

            var0.method3784("Location", 32 + var31, 17, 16777215, -1);
            var7 = 610 + class41.field860;
            if(World.field696[0] == 3 && World.field675[0] == 0) {
               class3.field26[2].method3995(var7, 4);
            } else {
               class3.field26[0].method3995(var7, 4);
            }

            if(World.field696[0] == 3 && World.field675[0] == 1) {
               class3.field26[3].method3995(var7 + 15, 4);
            } else {
               class3.field26[1].method3995(var7 + 15, 4);
            }

            var0.method3784("Type", var7 + 32, 17, 16777215, -1);
         }

         class219.method3899(708 + class41.field860, 4, 50, 16, 0);
         var1.method3787("Cancel", 25 + class41.field860 + 708, 16, 16777215, -1);
         class41.field857 = -1;
         if(class140.field1991 != null) {
            var4 = 88;
            byte var36 = 19;
            var31 = 765 / (var4 + 1);
            var7 = 480 / (1 + var36);

            do {
               var32 = var7;
               var35 = var31;
               if((var31 - 1) * var7 >= World.field679) {
                  --var31;
               }

               if(var31 * (var7 - 1) >= World.field679) {
                  --var7;
               }

               if(var31 * (var7 - 1) >= World.field679) {
                  --var7;
               }
            } while(var32 != var7 || var31 != var35);

            var32 = (765 - var4 * var31) / (1 + var31);
            if(var32 > 5) {
               var32 = 5;
            }

            var35 = (480 - var36 * var7) / (var7 + 1);
            if(var35 > 5) {
               var35 = 5;
            }

            var10 = (765 - var4 * var31 - var32 * (var31 - 1)) / 2;
            var11 = (480 - var7 * var36 - (var7 - 1) * var35) / 2;
            var12 = var11 + 23;
            var13 = var10 + class41.field860;
            int var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field679; ++var16) {
               World var17 = World.worldList[var16];
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
               if(var17.method610()) {
                  if(var17.method596()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method600()) {
                  var21 = 16711680;
                  if(var17.method596()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method598()) {
                  if(var17.method596()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method596()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class115.field1814 >= var13 && class115.field1821 >= var12 && class115.field1814 < var13 + var4 && class115.field1821 < var36 + var12 && var18) {
                  class41.field857 = var16;
                  class140.field1991[var20].method4052(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class140.field1991[var20].method4092(var13, var12);
               }

               if(class174.field2643 != null) {
                  class174.field2643[(var17.method596()?8:0) + var17.location].method3995(29 + var13, var12);
               }

               var0.method3787(Integer.toString(var17.id), var13 + 15, 5 + var36 / 2 + var12, var21, -1);
               var1.method3787(var19, var13 + 60, var36 / 2 + var12 + 5, 268435455, -1);
               var12 += var36 + var35;
               ++var14;
               if(var14 >= var7) {
                  var12 = 23 + var11;
                  var13 += var32 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method3774(World.worldList[class41.field857].activity) + 6;
               int var22 = var1.field3102 + 8;
               class219.method3899(class115.field1814 - var16 / 2, 20 + class115.field1821 + 5, var16, var22, 16777120);
               class219.method3905(class115.field1814 - var16 / 2, 5 + 20 + class115.field1821, var16, var22, 0);
               var1.method3787(World.worldList[class41.field857].activity, class115.field1814, 20 + class115.field1821 + 5 + var1.field3102 + 4, 0, -1);
            }
         }

         try {
            var23 = class36.canvas.getGraphics();
            TextureProvider.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var26) {
            class36.canvas.repaint();
         }

      } else {
         if(var3) {
            class41.field830.method4092(class41.field860, 0);
            RSCanvas.field1766.method4092(382 + class41.field860, 0);
            class41.field840.method3995(class41.field860 + 382 - class41.field840.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method3787("RuneScape is loading - please wait...", 180 + class41.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class219.method3905(class41.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            class219.method3905(180 + class41.loginWindowX - 151, 1 + var5, 302, 32, 0);
            class219.method3899(180 + class41.loginWindowX - 150, 2 + var5, class41.field837 * 3, 30, 9179409);
            class219.method3899(class41.field837 * 3 + (class41.loginWindowX + 180 - 150), var5 + 2, 300 - class41.field837 * 3, 30, 0);
            var0.method3787(class41.field843, class41.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var24;
         short var28;
         short var30;
         if(Client.gameState == 20) {
            class41.field828.method3995(180 + class41.loginWindowX - class41.field828.originalWidth / 2, 271 - class41.field828.height / 2);
            var28 = 211;
            var0.method3787(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
            var29 = var28 + 15;
            var0.method3787(class41.loginMessage2, class41.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var0.method3787(class41.loginMessage3, 180 + class41.loginWindowX, var29, 16776960, 0);
            var29 += 15;
            var29 += 10;
            if(class41.loginIndex != 4) {
               var0.method3784("Login: ", 180 + class41.loginWindowX - 110, var29, 16777215, 0);
               var30 = 200;

               for(var24 = class41.username; var0.method3774(var24) > var30; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method3784(class209.method3783(var24), 180 + class41.loginWindowX - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method3784("Password: " + class88.method1829(class41.field850), class41.loginWindowX + 180 - 108, var29, 16777215, 0);
               var29 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field828.method3995(class41.loginWindowX, 171);
            short var6;
            if(class41.loginIndex == 0) {
               var28 = 251;
               var0.method3787("Welcome to RuneScape", class41.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 30;
               var5 = 180 + class41.loginWindowX - 80;
               var6 = 291;
               ChatLineBuffer.field972.method3995(var5 - 73, var6 - 20);
               var0.method3827("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class41.loginWindowX + 180 + 80;
               ChatLineBuffer.field972.method3995(var5 - 73, var6 - 20);
               var0.method3827("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3787(class41.field845, class41.loginWindowX + 180, 211, 16776960, 0);
               var28 = 236;
               var0.method3787(class41.loginMessage1, class41.loginWindowX + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.method3787(class41.loginMessage2, 180 + class41.loginWindowX, var29, 16777215, 0);
               var29 += 15;
               var0.method3787(class41.loginMessage3, 180 + class41.loginWindowX, var29, 16777215, 0);
               var29 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var6 = 321;
               ChatLineBuffer.field972.method3995(var5 - 73, var6 - 20);
               var0.method3787("Continue", var5, 5 + var6, 16777215, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               ChatLineBuffer.field972.method3995(var5 - 73, var6 - 20);
               var0.method3787("Cancel", var5, 5 + var6, 16777215, 0);
            } else {
               short var8;
               if(class41.loginIndex == 2) {
                  var28 = 211;
                  var0.method3787(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method3787(class41.loginMessage2, class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.method3787(class41.loginMessage3, class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 10;
                  var0.method3784("Login: ", class41.loginWindowX + 180 - 110, var29, 16777215, 0);
                  var30 = 200;

                  for(var24 = class41.username; var0.method3774(var24) > var30; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method3784(class209.method3783(var24) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class16.method182(16776960) + "|":""), class41.loginWindowX + 180 - 70, var29, 16777215, 0);
                  var29 += 15;
                  var0.method3784("Password: " + class88.method1829(class41.field850) + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class16.method182(16776960) + "|":""), class41.loginWindowX + 180 - 108, var29, 16777215, 0);
                  var29 += 15;
                  var7 = 180 + class41.loginWindowX - 80;
                  var8 = 321;
                  ChatLineBuffer.field972.method3995(var7 - 73, var8 - 20);
                  var0.method3787("Login", var7, var8 + 5, 16777215, 0);
                  var7 = 80 + 180 + class41.loginWindowX;
                  ChatLineBuffer.field972.method3995(var7 - 73, var8 - 20);
                  var0.method3787("Cancel", var7, 5 + var8, 16777215, 0);
                  var28 = 357;
                  var1.method3787("Forgotten your password? <col=ffffff>Click here.", class41.loginWindowX + 180, var28, 16776960, 0);
               } else if(class41.loginIndex == 3) {
                  var28 = 201;
                  var0.method3787("Invalid username or password.", class41.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 20;
                  var1.method3787("For accounts created after 24th November 2010, please use your", class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var1.method3787("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var5 = 180 + class41.loginWindowX;
                  var6 = 276;
                  ChatLineBuffer.field972.method3995(var5 - 73, var6 - 20);
                  var2.method3787("Try again", var5, 5 + var6, 16777215, 0);
                  var5 = 180 + class41.loginWindowX;
                  var6 = 326;
                  ChatLineBuffer.field972.method3995(var5 - 73, var6 - 20);
                  var2.method3787("Forgotten password?", var5, 5 + var6, 16777215, 0);
               } else if(class41.loginIndex == 4) {
                  var0.method3787("Authenticator", class41.loginWindowX + 180, 211, 16776960, 0);
                  var28 = 236;
                  var0.method3787(class41.loginMessage1, class41.loginWindowX + 180, var28, 16777215, 0);
                  var29 = var28 + 15;
                  var0.method3787(class41.loginMessage2, 180 + class41.loginWindowX, var29, 16777215, 0);
                  var29 += 15;
                  var0.method3787(class41.loginMessage3, class41.loginWindowX + 180, var29, 16777215, 0);
                  var29 += 15;
                  var0.method3784("PIN: " + class88.method1829(ChatMessages.authCode) + (Client.gameCycle % 40 < 20?class16.method182(16776960) + "|":""), class41.loginWindowX + 180 - 108, var29, 16777215, 0);
                  var29 -= 8;
                  var0.method3784("Trust this computer", 180 + class41.loginWindowX - 9, var29, 16776960, 0);
                  var29 += 15;
                  var0.method3784("for 30 days: ", class41.loginWindowX + 180 - 9, var29, 16776960, 0);
                  var5 = 180 + class41.loginWindowX - 9 + var0.method3774("for 30 days: ") + 15;
                  var31 = var29 - var0.field3102;
                  ModIcon var25;
                  if(class41.field852) {
                     var25 = class231.field3280;
                  } else {
                     var25 = NPC.field769;
                  }

                  var25.method3995(var5, var31);
                  var29 += 15;
                  var32 = 180 + class41.loginWindowX - 80;
                  short var9 = 321;
                  ChatLineBuffer.field972.method3995(var32 - 73, var9 - 20);
                  var0.method3787("Continue", var32, 5 + var9, 16777215, 0);
                  var32 = 80 + 180 + class41.loginWindowX;
                  ChatLineBuffer.field972.method3995(var32 - 73, var9 - 20);
                  var0.method3787("Cancel", var32, 5 + var9, 16777215, 0);
                  var1.method3787("<u=ff>Can\'t Log In?</u>", 180 + class41.loginWindowX, var9 + 36, 255, 0);
               } else if(class41.loginIndex == 5) {
                  var0.method3787("Forgotten your password?", class41.loginWindowX + 180, 201, 16776960, 0);
                  var28 = 221;
                  var2.method3787(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var2.method3787(class41.loginMessage2, class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var2.method3787(class41.loginMessage3, 180 + class41.loginWindowX, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 14;
                  var0.method3784("Username/email: ", 180 + class41.loginWindowX - 145, var29, 16777215, 0);
                  var30 = 174;

                  for(var24 = class41.username; var0.method3774(var24) > var30; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method3784(class209.method3783(var24) + (Client.gameCycle % 40 < 20?class16.method182(16776960) + "|":""), 180 + class41.loginWindowX - 34, var29, 16777215, 0);
                  var29 += 15;
                  var7 = class41.loginWindowX + 180 - 80;
                  var8 = 321;
                  ChatLineBuffer.field972.method3995(var7 - 73, var8 - 20);
                  var0.method3787("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + class41.loginWindowX + 180;
                  ChatLineBuffer.field972.method3995(var7 - 73, var8 - 20);
                  var0.method3787("Back", var7, 5 + var8, 16777215, 0);
               } else if(class41.loginIndex == 6) {
                  var28 = 211;
                  var0.method3787(class41.loginMessage1, class41.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method3787(class41.loginMessage2, class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.method3787(class41.loginMessage3, class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var5 = 180 + class41.loginWindowX;
                  var6 = 321;
                  ChatLineBuffer.field972.method3995(var5 - 73, var6 - 20);
                  var0.method3787("Back", var5, 5 + var6, 16777215, 0);
               }
            }
         }

         if(class41.field834 > 0) {
            var29 = class41.field834;
            var30 = 256;
            class41.field838 += var29 * 128;
            if(class41.field838 > class2.field21.length) {
               class41.field838 -= class2.field21.length;
               var31 = (int)(Math.random() * 12.0D);
               class207.method3764(class41.field829[var31]);
            }

            var31 = 0;
            var7 = 128 * var29;
            var32 = 128 * (var30 - var29);

            for(var35 = 0; var35 < var32; ++var35) {
               var10 = MessageNode.field230[var7 + var31] - class2.field21[class41.field838 + var31 & class2.field21.length - 1] * var29 / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               MessageNode.field230[var31++] = var10;
            }

            for(var35 = var30 - var29; var35 < var30; ++var35) {
               var10 = var35 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     MessageNode.field230[var11 + var10] = 255;
                  } else {
                     MessageNode.field230[var11 + var10] = 0;
                  }
               }
            }

            if(class41.field836 > 0) {
               class41.field836 -= 4 * var29;
            }

            if(class41.field848 > 0) {
               class41.field848 -= var29 * 4;
            }

            if(class41.field836 == 0 && class41.field848 == 0) {
               var35 = (int)(Math.random() * (double)(2000 / var29));
               if(var35 == 0) {
                  class41.field836 = 1024;
               }

               if(var35 == 1) {
                  class41.field848 = 1024;
               }
            }

            for(var35 = 0; var35 < var30 - var29; ++var35) {
               class41.field851[var35] = class41.field851[var29 + var35];
            }

            for(var35 = var30 - var29; var35 < var30; ++var35) {
               class41.field851[var35] = (int)(Math.sin((double)class41.field831 / 14.0D) * 16.0D + Math.sin((double)class41.field831 / 15.0D) * 14.0D + Math.sin((double)class41.field831 / 16.0D) * 12.0D);
               ++class41.field831;
            }

            class41.field839 += var29;
            var35 = (var29 + (Client.gameCycle & 1)) / 2;
            if(var35 > 0) {
               for(var10 = 0; var10 < class41.field839 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  MessageNode.field230[var11 + (var12 << 7)] = 192;
               }

               class41.field839 = 0;
               var10 = 0;

               label526:
               while(true) {
                  if(var10 >= var30) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label526;
                        }

                        var11 = 0;

                        for(var12 = -var35; var12 < var30; ++var12) {
                           var13 = 128 * var12;
                           if(var12 + var35 < var30) {
                              var11 += ChatMessages.field931[var10 + var13 + var35 * 128];
                           }

                           if(var12 - (1 + var35) >= 0) {
                              var11 -= ChatMessages.field931[var10 + var13 - 128 * (var35 + 1)];
                           }

                           if(var12 >= 0) {
                              MessageNode.field230[var13 + var10] = var11 / (var35 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = 128 * var10;

                  for(var13 = -var35; var13 < 128; ++var13) {
                     if(var35 + var13 < 128) {
                        var11 += MessageNode.field230[var35 + var12 + var13];
                     }

                     if(var13 - (var35 + 1) >= 0) {
                        var11 -= MessageNode.field230[var13 + var12 - (1 + var35)];
                     }

                     if(var13 >= 0) {
                        ChatMessages.field931[var12 + var13] = var11 / (var35 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class41.field834 = 0;
         }

         class1.method15();
         class63.field1094[XGrandExchangeOffer.field35.field700?1:0].method3995(765 + class41.field860 - 40, 463);
         if(Client.gameState > 5 && Client.field509 == 0) {
            if(null != class49.field965) {
               var29 = class41.field860 + 5;
               var30 = 463;
               byte var34 = 100;
               byte var33 = 35;
               class49.field965.method3995(var29, var30);
               var0.method3787("World" + " " + Client.world, var29 + var34 / 2, var30 + var33 / 2 - 2, 16777215, 0);
               if(World.worldServersDownload != null) {
                  var1.method3787("Loading...", var34 / 2 + var29, var30 + var33 / 2 + 12, 16777215, 0);
               } else {
                  var1.method3787("Click to switch", var34 / 2 + var29, var30 + var33 / 2 + 12, 16777215, 0);
               }
            } else {
               class49.field965 = class211.method3870(class206.field3086, "sl_button", "");
            }
         }

         try {
            var23 = class36.canvas.getGraphics();
            TextureProvider.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var27) {
            class36.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1108646760"
   )
   static final void method2671() {
      for(class25 var0 = (class25)Client.field300.method2349(); null != var0; var0 = (class25)Client.field300.method2351()) {
         if(var0.field577 == -1) {
            var0.field580 = 0;
            Client.method400(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
