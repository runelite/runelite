import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1611751211
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -268952743
   )
   @Export("id")
   int id;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1125822805
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 1218269057
   )
   static int field709;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "-2072324224"
   )
   static final void method677(class69 var0) {
      var0.field1338 = false;
      if(null != var0.field1335) {
         var0.field1335.field1334 = 0;
      }

      for(class69 var1 = var0.vmethod3745(); var1 != null; var1 = var0.vmethod3756()) {
         method677(var1);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1853658170"
   )
   protected final Model getModel() {
      return MessageNode.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;I)V",
      garbageValue = "-1974979189"
   )
   static final void method680(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class94.field1670[var7];
         int var9 = class94.field1676[var7];
         var8 = var8 * 256 / (256 + Client.mapScaleDelta);
         var9 = var9 * 256 / (256 + Client.mapScaleDelta);
         int var10 = var3 * var8 + var9 * var2 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         NPC.field811.method1784(var0 + 94 + var14 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         Friend.method192(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("a")
   public static final void method681(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class143.method2978(var0 - 1L);
            class143.method2978(1L);
         } else {
            class143.method2978(var0);
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "13828101"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field1012.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         var1 = class33.method713(Sequence.field1023, Sequence.field1025, var0, false);
         if(var1 != null) {
            Sequence.field1012.put(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;Lclass227;ZI)V",
      garbageValue = "929604255"
   )
   static void method684(class227 var0, class227 var1, class227 var2, boolean var3) {
      if(var3) {
         class33.field736 = (class159.field2374 - Client.field346) / 2;
         class33.loginWindowX = class33.field736 + 202;
      }

      byte var4;
      int var5;
      int var7;
      Graphics var23;
      int var29;
      int var31;
      int var34;
      if(class33.worldSelectShown) {
         if(null == class47.field1069) {
            class47.field1069 = XClanMember.method605(ItemComposition.field1230, "sl_back", "");
         }

         if(null == Client.field566) {
            Client.field566 = class119.method2474(ItemComposition.field1230, "sl_flags", "");
         }

         if(null == class79.field1466) {
            class79.field1466 = class119.method2474(ItemComposition.field1230, "sl_arrows", "");
         }

         if(class1.field27 == null) {
            class1.field27 = class119.method2474(ItemComposition.field1230, "sl_stars", "");
         }

         class82.method1883(class33.field736, 23, 765, 480, 0);
         class82.method1833(class33.field736, 0, 125, 23, 12425273, 9135624);
         class82.method1833(125 + class33.field736, 0, 640, 23, 5197647, 2697513);
         var0.method4080("Select a world", 62 + class33.field736, 15, 0, -1);
         if(class1.field27 != null) {
            class1.field27[1].method1900(140 + class33.field736, 1);
            var1.method4157("Members only world", class33.field736 + 152, 10, 16777215, -1);
            class1.field27[0].method1900(140 + class33.field736, 12);
            var1.method4157("Free world", class33.field736 + 152, 21, 16777215, -1);
         }

         if(null != class79.field1466) {
            var29 = 280 + class33.field736;
            if(World.field660[0] == 0 && World.field661[0] == 0) {
               class79.field1466[2].method1900(var29, 4);
            } else {
               class79.field1466[0].method1900(var29, 4);
            }

            if(World.field660[0] == 0 && World.field661[0] == 1) {
               class79.field1466[3].method1900(15 + var29, 4);
            } else {
               class79.field1466[1].method1900(15 + var29, 4);
            }

            var0.method4157("World", 32 + var29, 17, 16777215, -1);
            var5 = class33.field736 + 390;
            if(World.field660[0] == 1 && World.field661[0] == 0) {
               class79.field1466[2].method1900(var5, 4);
            } else {
               class79.field1466[0].method1900(var5, 4);
            }

            if(World.field660[0] == 1 && World.field661[0] == 1) {
               class79.field1466[3].method1900(15 + var5, 4);
            } else {
               class79.field1466[1].method1900(var5 + 15, 4);
            }

            var0.method4157("Players", 32 + var5, 17, 16777215, -1);
            var31 = class33.field736 + 500;
            if(World.field660[0] == 2 && World.field661[0] == 0) {
               class79.field1466[2].method1900(var31, 4);
            } else {
               class79.field1466[0].method1900(var31, 4);
            }

            if(World.field660[0] == 2 && World.field661[0] == 1) {
               class79.field1466[3].method1900(var31 + 15, 4);
            } else {
               class79.field1466[1].method1900(var31 + 15, 4);
            }

            var0.method4157("Location", var31 + 32, 17, 16777215, -1);
            var7 = 610 + class33.field736;
            if(World.field660[0] == 3 && World.field661[0] == 0) {
               class79.field1466[2].method1900(var7, 4);
            } else {
               class79.field1466[0].method1900(var7, 4);
            }

            if(World.field660[0] == 3 && World.field661[0] == 1) {
               class79.field1466[3].method1900(15 + var7, 4);
            } else {
               class79.field1466[1].method1900(15 + var7, 4);
            }

            var0.method4157("Type", 32 + var7, 17, 16777215, -1);
         }

         class82.method1883(708 + class33.field736, 4, 50, 16, 0);
         var1.method4080("Cancel", 25 + 708 + class33.field736, 16, 16777215, -1);
         class33.field765 = -1;
         if(class47.field1069 != null) {
            var4 = 88;
            byte var36 = 19;
            var31 = 765 / (1 + var4);
            var7 = 480 / (1 + var36);

            int var35;
            do {
               var34 = var7;
               var35 = var31;
               if((var31 - 1) * var7 >= World.field659) {
                  --var31;
               }

               if((var7 - 1) * var31 >= World.field659) {
                  --var7;
               }

               if((var7 - 1) * var31 >= World.field659) {
                  --var7;
               }
            } while(var7 != var34 || var35 != var31);

            var34 = (765 - var4 * var31) / (1 + var31);
            if(var34 > 5) {
               var34 = 5;
            }

            var35 = (480 - var7 * var36) / (1 + var7);
            if(var35 > 5) {
               var35 = 5;
            }

            int var10 = (765 - var31 * var4 - var34 * (var31 - 1)) / 2;
            int var11 = (480 - var7 * var36 - (var7 - 1) * var35) / 2;
            int var12 = var11 + 23;
            int var13 = class33.field736 + var10;
            int var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field659; ++var16) {
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
               if(var17.method624()) {
                  if(var17.method619()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method623()) {
                  var21 = 16711680;
                  if(var17.method619()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method643()) {
                  if(var17.method619()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method619()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class143.field2225 >= var13 && class143.field2222 >= var12 && class143.field2225 < var13 + var4 && class143.field2222 < var36 + var12 && var18) {
                  class33.field765 = var16;
                  class47.field1069[var20].method1753(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class47.field1069[var20].method1807(var13, var12);
               }

               if(null != Client.field566) {
                  Client.field566[(var17.method619()?8:0) + var17.location].method1900(29 + var13, var12);
               }

               var0.method4080(Integer.toString(var17.id), var13 + 15, var12 + var36 / 2 + 5, var21, -1);
               var1.method4080(var19, var13 + 60, 5 + var36 / 2 + var12, 268435455, -1);
               var12 += var35 + var36;
               ++var14;
               if(var14 >= var7) {
                  var12 = var11 + 23;
                  var13 += var34 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4065(World.worldList[class33.field765].activity) + 6;
               int var22 = 8 + var1.field3237;
               class82.method1883(class143.field2225 - var16 / 2, 5 + class143.field2222 + 20, var16, var22, 16777120);
               class82.method1834(class143.field2225 - var16 / 2, 20 + class143.field2222 + 5, var16, var22, 0);
               var1.method4080(World.worldList[class33.field765].activity, class143.field2225, var1.field3237 + 5 + 20 + class143.field2222 + 4, 0, -1);
            }
         }

         try {
            var23 = class79.canvas.getGraphics();
            Buffer.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var26) {
            class79.canvas.repaint();
         }

      } else {
         if(var3) {
            class130.field2124.method1807(class33.field736, 0);
            class137.field2153.method1807(class33.field736 + 382, 0);
            class33.field739.method1900(382 + class33.field736 - class33.field739.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4080("RuneScape is loading - please wait...", 180 + class33.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1834(180 + class33.loginWindowX - 152, var5, 304, 34, 9179409);
            class82.method1834(180 + class33.loginWindowX - 151, 1 + var5, 302, 32, 0);
            class82.method1883(class33.loginWindowX + 180 - 150, var5 + 2, class33.field750 * 3, 30, 9179409);
            class82.method1883(180 + class33.loginWindowX - 150 + class33.field750 * 3, 2 + var5, 300 - class33.field750 * 3, 30, 0);
            var0.method4080(class33.field751, 180 + class33.loginWindowX, 276 - var4, 16777215, -1);
         }

         String var24;
         short var28;
         short var30;
         if(Client.gameState == 20) {
            class33.field737.method1900(180 + class33.loginWindowX - class33.field737.originalWidth / 2, 271 - class33.field737.height / 2);
            var28 = 211;
            var0.method4080(class33.loginMessage1, 180 + class33.loginWindowX, var28, 16776960, 0);
            var29 = var28 + 15;
            var0.method4080(class33.loginMessage2, class33.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var0.method4080(class33.loginMessage3, 180 + class33.loginWindowX, var29, 16776960, 0);
            var29 += 15;
            var29 += 10;
            if(class33.loginIndex != 4) {
               var0.method4157("Login: ", 180 + class33.loginWindowX - 110, var29, 16777215, 0);
               var30 = 200;

               for(var24 = class33.username; var0.method4065(var24) > var30; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method4157(class226.method4069(var24), 180 + class33.loginWindowX - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method4157("Password: " + KitDefinition.method967(class33.field758), 180 + class33.loginWindowX - 108, var29, 16777215, 0);
               var29 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class33.field737.method1900(class33.loginWindowX, 171);
            short var6;
            if(class33.loginIndex == 0) {
               var28 = 251;
               var0.method4080("Welcome to RuneScape", 180 + class33.loginWindowX, var28, 16776960, 0);
               var29 = var28 + 30;
               var5 = 180 + class33.loginWindowX - 80;
               var6 = 291;
               class154.field2317.method1900(var5 - 73, var6 - 20);
               var0.method4073("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + 180 + class33.loginWindowX;
               class154.field2317.method1900(var5 - 73, var6 - 20);
               var0.method4073("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.loginIndex == 1) {
               var0.method4080(class33.field767, 180 + class33.loginWindowX, 211, 16776960, 0);
               var28 = 236;
               var0.method4080(class33.loginMessage1, class33.loginWindowX + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.method4080(class33.loginMessage2, class33.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.method4080(class33.loginMessage3, 180 + class33.loginWindowX, var29, 16777215, 0);
               var29 += 15;
               var5 = 180 + class33.loginWindowX - 80;
               var6 = 321;
               class154.field2317.method1900(var5 - 73, var6 - 20);
               var0.method4080("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class33.loginWindowX + 180 + 80;
               class154.field2317.method1900(var5 - 73, var6 - 20);
               var0.method4080("Cancel", var5, var6 + 5, 16777215, 0);
            } else {
               short var8;
               if(class33.loginIndex == 2) {
                  var28 = 211;
                  var0.method4080(class33.loginMessage1, 180 + class33.loginWindowX, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method4080(class33.loginMessage2, class33.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.method4080(class33.loginMessage3, 180 + class33.loginWindowX, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 10;
                  var0.method4157("Login: ", 180 + class33.loginWindowX - 110, var29, 16777215, 0);
                  var30 = 200;

                  for(var24 = class33.username; var0.method4065(var24) > var30; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method4157(class226.method4069(var24) + (class33.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class153.method3186(16776960) + "|":""), 180 + class33.loginWindowX - 70, var29, 16777215, 0);
                  var29 += 15;
                  var0.method4157("Password: " + KitDefinition.method967(class33.field758) + (class33.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class153.method3186(16776960) + "|":""), class33.loginWindowX + 180 - 108, var29, 16777215, 0);
                  var29 += 15;
                  var7 = 180 + class33.loginWindowX - 80;
                  var8 = 321;
                  class154.field2317.method1900(var7 - 73, var8 - 20);
                  var0.method4080("Login", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + 180 + class33.loginWindowX;
                  class154.field2317.method1900(var7 - 73, var8 - 20);
                  var0.method4080("Cancel", var7, var8 + 5, 16777215, 0);
                  var28 = 357;
                  var1.method4080("Forgotten your password? <col=ffffff>Click here.", class33.loginWindowX + 180, var28, 16776960, 0);
               } else if(class33.loginIndex == 3) {
                  var28 = 201;
                  var0.method4080("Invalid username or password.", 180 + class33.loginWindowX, var28, 16776960, 0);
                  var29 = var28 + 20;
                  var1.method4080("For accounts created after 24th November 2010, please use your", class33.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var1.method4080("email address to login. Otherwise please login with your username.", 180 + class33.loginWindowX, var29, 16776960, 0);
                  var29 += 15;
                  var5 = class33.loginWindowX + 180;
                  var6 = 276;
                  class154.field2317.method1900(var5 - 73, var6 - 20);
                  var2.method4080("Try again", var5, 5 + var6, 16777215, 0);
                  var5 = 180 + class33.loginWindowX;
                  var6 = 326;
                  class154.field2317.method1900(var5 - 73, var6 - 20);
                  var2.method4080("Forgotten password?", var5, 5 + var6, 16777215, 0);
               } else if(class33.loginIndex == 4) {
                  var0.method4080("Authenticator", 180 + class33.loginWindowX, 211, 16776960, 0);
                  var28 = 236;
                  var0.method4080(class33.loginMessage1, 180 + class33.loginWindowX, var28, 16777215, 0);
                  var29 = var28 + 15;
                  var0.method4080(class33.loginMessage2, 180 + class33.loginWindowX, var29, 16777215, 0);
                  var29 += 15;
                  var0.method4080(class33.loginMessage3, 180 + class33.loginWindowX, var29, 16777215, 0);
                  var29 += 15;
                  var0.method4157("PIN: " + KitDefinition.method967(SecondaryBufferProvider.authCode) + (Client.gameCycle % 40 < 20?class153.method3186(16776960) + "|":""), 180 + class33.loginWindowX - 108, var29, 16777215, 0);
                  var29 -= 8;
                  var0.method4157("Trust this computer", 180 + class33.loginWindowX - 9, var29, 16776960, 0);
                  var29 += 15;
                  var0.method4157("for 30 days: ", 180 + class33.loginWindowX - 9, var29, 16776960, 0);
                  var5 = class33.loginWindowX + 180 - 9 + var0.method4065("for 30 days: ") + 15;
                  var31 = var29 - var0.field3237;
                  ModIcon var25;
                  if(class33.field747) {
                     var25 = class93.field1651;
                  } else {
                     var25 = class33.field741;
                  }

                  var25.method1900(var5, var31);
                  var29 += 15;
                  var34 = 180 + class33.loginWindowX - 80;
                  short var9 = 321;
                  class154.field2317.method1900(var34 - 73, var9 - 20);
                  var0.method4080("Continue", var34, var9 + 5, 16777215, 0);
                  var34 = 180 + class33.loginWindowX + 80;
                  class154.field2317.method1900(var34 - 73, var9 - 20);
                  var0.method4080("Cancel", var34, 5 + var9, 16777215, 0);
                  var1.method4080("<u=ff>Can\'t Log In?</u>", class33.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class33.loginIndex == 5) {
                  var0.method4080("Forgotten your password?", class33.loginWindowX + 180, 201, 16776960, 0);
                  var28 = 221;
                  var2.method4080(class33.loginMessage1, 180 + class33.loginWindowX, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var2.method4080(class33.loginMessage2, class33.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var2.method4080(class33.loginMessage3, class33.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 14;
                  var0.method4157("Username/email: ", class33.loginWindowX + 180 - 145, var29, 16777215, 0);
                  var30 = 174;

                  for(var24 = class33.username; var0.method4065(var24) > var30; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method4157(class226.method4069(var24) + (Client.gameCycle % 40 < 20?class153.method3186(16776960) + "|":""), class33.loginWindowX + 180 - 34, var29, 16777215, 0);
                  var29 += 15;
                  var7 = class33.loginWindowX + 180 - 80;
                  var8 = 321;
                  class154.field2317.method1900(var7 - 73, var8 - 20);
                  var0.method4080("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class33.loginWindowX + 180 + 80;
                  class154.field2317.method1900(var7 - 73, var8 - 20);
                  var0.method4080("Back", var7, 5 + var8, 16777215, 0);
               } else if(class33.loginIndex == 6) {
                  var28 = 211;
                  var0.method4080(class33.loginMessage1, class33.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method4080(class33.loginMessage2, class33.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.method4080(class33.loginMessage3, class33.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var5 = 180 + class33.loginWindowX;
                  var6 = 321;
                  class154.field2317.method1900(var5 - 73, var6 - 20);
                  var0.method4080("Back", var5, var6 + 5, 16777215, 0);
               }
            }
         }

         if(class33.field745 > 0) {
            class93.method2116(class33.field745);
            class33.field745 = 0;
         }

         class113.method2448();
         class172.field2765[class116.field2039.field133?1:0].method1900(class33.field736 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field489 == 0) {
            if(class157.field2356 != null) {
               var29 = class33.field736 + 5;
               var30 = 463;
               byte var32 = 100;
               byte var33 = 35;
               class157.field2356.method1900(var29, var30);
               var0.method4080("World" + " " + Client.world, var32 / 2 + var29, var33 / 2 + var30 - 2, 16777215, 0);
               if(class133.worldServersDownload != null) {
                  var1.method4080("Loading...", var29 + var32 / 2, var30 + var33 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4080("Click to switch", var29 + var32 / 2, var30 + var33 / 2 + 12, 16777215, 0);
               }
            } else {
               class157.field2356 = class118.method2468(ItemComposition.field1230, "sl_button", "");
            }
         }

         try {
            var23 = class79.canvas.getGraphics();
            Buffer.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var27) {
            class79.canvas.repaint();
         }

      }
   }
}
