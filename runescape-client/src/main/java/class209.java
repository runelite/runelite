import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class209 extends class120 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   class103 field2589;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   class205 field2590;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   Deque field2591;

   @ObfuscatedSignature(
      signature = "(Lgx;)V"
   )
   class209(class205 var1) {
      this.field2591 = new Deque();
      this.field2589 = new class103();
      this.field2590 = var1;
   }

   @ObfuscatedName("w")
   protected void vmethod3904(int[] var1, int var2, int var3) {
      this.field2589.vmethod3904(var1, var2, var3);

      for(class206 var6 = (class206)this.field2591.getFront(); var6 != null; var6 = (class206)this.field2591.getNext()) {
         if(!this.field2590.method3695(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2558) {
                  this.method3898(var6, var1, var4, var5, var4 + var5);
                  var6.field2558 -= var5;
                  break;
               }

               this.method3898(var6, var1, var4, var6.field2558, var5 + var4);
               var4 += var6.field2558;
               var5 -= var6.field2558;
            } while(!this.field2590.method3807(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("o")
   protected void vmethod3893(int var1) {
      this.field2589.vmethod3893(var1);

      for(class206 var3 = (class206)this.field2591.getFront(); var3 != null; var3 = (class206)this.field2591.getNext()) {
         if(!this.field2590.method3695(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2558) {
                  this.method3887(var3, var2);
                  var3.field2558 -= var2;
                  break;
               }

               this.method3887(var3, var3.field2558);
               var2 -= var3.field2558;
            } while(!this.field2590.method3807(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected class120 vmethod3888() {
      class206 var1;
      do {
         var1 = (class206)this.field2591.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2557 == null);

      return var1.field2557;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgm;II)V",
      garbageValue = "2021773379"
   )
   void method3887(class206 var1, int var2) {
      if((this.field2590.field2523[var1.field2544] & 4) != 0 && var1.field2553 < 0) {
         int var3 = this.field2590.field2516[var1.field2544] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2560) / var3;
         var1.field2560 = var1.field2560 + var3 * var2 & 1048575;
         if(var4 <= var2) {
            if(this.field2590.field2526[var1.field2544] == 0) {
               var1.field2557 = class118.method2261(var1.field2542, var1.field2557.method2158(), var1.field2557.method2149(), var1.field2557.method2183());
            } else {
               var1.field2557 = class118.method2261(var1.field2542, var1.field2557.method2158(), 0, var1.field2557.method2183());
               this.field2590.method3710(var1, var1.field2540.field2579[var1.field2559] < 0);
            }

            if(var1.field2540.field2579[var1.field2559] < 0) {
               var1.field2557.method2184(-1);
            }

            var2 = var1.field2560 / var3;
         }
      }

      var1.field2557.vmethod3893(var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgm;[IIIII)V",
      garbageValue = "1700005359"
   )
   void method3898(class206 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2590.field2523[var1.field2544] & 4) != 0 && var1.field2553 < 0) {
         int var6 = this.field2590.field2516[var1.field2544] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2560) / var6;
            if(var7 > var4) {
               var1.field2560 += var6 * var4;
               break;
            }

            var1.field2557.vmethod3904(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2560 += var7 * var6 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class118 var10 = var1.field2557;
            if(this.field2590.field2526[var1.field2544] == 0) {
               var1.field2557 = class118.method2261(var1.field2542, var10.method2158(), var10.method2149(), var10.method2183());
            } else {
               var1.field2557 = class118.method2261(var1.field2542, var10.method2158(), 0, var10.method2183());
               this.field2590.method3710(var1, var1.field2540.field2579[var1.field2559] < 0);
               var1.field2557.method2154(var8, var10.method2149());
            }

            if(var1.field2540.field2579[var1.field2559] < 0) {
               var1.field2557.method2184(-1);
            }

            var10.method2199(var8);
            var10.vmethod3904(var2, var3, var5 - var3);
            if(var10.method2204()) {
               this.field2589.method1894(var10);
            }
         }
      }

      var1.field2557.vmethod3904(var2, var3, var4);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected class120 vmethod3894() {
      class206 var1 = (class206)this.field2591.getFront();
      return (class120)(var1 == null?null:(var1.field2557 != null?var1.field2557:this.vmethod3888()));
   }

   @ObfuscatedName("l")
   protected int vmethod3889() {
      return 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljh;Ljh;Ljh;ZB)V",
      garbageValue = "-29"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class93.field1434 = (GameEngine.canvasWidth - 765) / 2;
         class93.loginWindowX = class93.field1434 + 202;
      }

      byte var4;
      int var5;
      int var7;
      int var12;
      int var14;
      int var25;
      int var26;
      int var27;
      int var32;
      int var34;
      int var41;
      int var42;
      if(class93.worldSelectShown) {
         if(WorldMapType2.field534 == null) {
            WorldMapType2.field534 = class54.method833(class176.indexSprites, "sl_back", "");
         }

         if(class93.field1466 == null) {
            class93.field1466 = class25.method197(class176.indexSprites, "sl_flags", "");
         }

         if(class39.field538 == null) {
            class39.field538 = class25.method197(class176.indexSprites, "sl_arrows", "");
         }

         if(CombatInfoListHolder.field1372 == null) {
            CombatInfoListHolder.field1372 = class25.method197(class176.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.method4968(class93.field1434, 23, 765, 480, 0);
         Rasterizer2D.method4973(class93.field1434, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4973(class93.field1434 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4843("Select a world", class93.field1434 + 62, 15, 0, -1);
         if(CombatInfoListHolder.field1372 != null) {
            CombatInfoListHolder.field1372[1].method5058(class93.field1434 + 140, 1);
            var1.method4780("Members only world", class93.field1434 + 152, 10, 16777215, -1);
            CombatInfoListHolder.field1372[0].method5058(class93.field1434 + 140, 12);
            var1.method4780("Free world", class93.field1434 + 152, 21, 16777215, -1);
         }

         if(class39.field538 != null) {
            var32 = class93.field1434 + 280;
            if(World.field1293[0] == 0 && World.field1292[0] == 0) {
               class39.field538[2].method5058(var32, 4);
            } else {
               class39.field538[0].method5058(var32, 4);
            }

            if(World.field1293[0] == 0 && World.field1292[0] == 1) {
               class39.field538[3].method5058(var32 + 15, 4);
            } else {
               class39.field538[1].method5058(var32 + 15, 4);
            }

            var0.method4780("World", var32 + 32, 17, 16777215, -1);
            var5 = class93.field1434 + 390;
            if(World.field1293[0] == 1 && World.field1292[0] == 0) {
               class39.field538[2].method5058(var5, 4);
            } else {
               class39.field538[0].method5058(var5, 4);
            }

            if(World.field1293[0] == 1 && World.field1292[0] == 1) {
               class39.field538[3].method5058(var5 + 15, 4);
            } else {
               class39.field538[1].method5058(var5 + 15, 4);
            }

            var0.method4780("Players", var5 + 32, 17, 16777215, -1);
            var34 = class93.field1434 + 500;
            if(World.field1293[0] == 2 && World.field1292[0] == 0) {
               class39.field538[2].method5058(var34, 4);
            } else {
               class39.field538[0].method5058(var34, 4);
            }

            if(World.field1293[0] == 2 && World.field1292[0] == 1) {
               class39.field538[3].method5058(var34 + 15, 4);
            } else {
               class39.field538[1].method5058(var34 + 15, 4);
            }

            var0.method4780("Location", var34 + 32, 17, 16777215, -1);
            var7 = class93.field1434 + 610;
            if(World.field1293[0] == 3 && World.field1292[0] == 0) {
               class39.field538[2].method5058(var7, 4);
            } else {
               class39.field538[0].method5058(var7, 4);
            }

            if(World.field1293[0] == 3 && World.field1292[0] == 1) {
               class39.field538[3].method5058(var7 + 15, 4);
            } else {
               class39.field538[1].method5058(var7 + 15, 4);
            }

            var0.method4780("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4968(class93.field1434 + 708, 4, 50, 16, 0);
         var1.method4843("Cancel", class93.field1434 + 708 + 25, 16, 16777215, -1);
         class93.field1463 = -1;
         if(WorldMapType2.field534 != null) {
            var4 = 88;
            byte var40 = 19;
            var34 = 765 / (var4 + 1);
            var7 = 480 / (var40 + 1);

            do {
               var41 = var7;
               var25 = var34;
               if(var7 * (var34 - 1) >= World.worldCount) {
                  --var34;
               }

               if(var34 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }

               if(var34 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }
            } while(var7 != var41 || var34 != var25);

            var41 = (765 - var34 * var4) / (var34 + 1);
            if(var41 > 5) {
               var41 = 5;
            }

            var25 = (480 - var40 * var7) / (var7 + 1);
            if(var25 > 5) {
               var25 = 5;
            }

            var26 = (765 - var4 * var34 - var41 * (var34 - 1)) / 2;
            var27 = (480 - var40 * var7 - var25 * (var7 - 1)) / 2;
            var12 = var27 + 23;
            var42 = var26 + class93.field1434;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.worldCount; ++var16) {
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
               if(var17.method1560()) {
                  if(var17.method1579()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1559()) {
                  var21 = 16711680;
                  if(var17.method1579()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1557()) {
                  if(var17.method1579()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1579()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.field734 >= var42 && MouseInput.field735 >= var12 && MouseInput.field734 < var4 + var42 && MouseInput.field735 < var40 + var12 && var18) {
                  class93.field1463 = var16;
                  WorldMapType2.field534[var20].method5160(var42, var12, 128, 16777215);
                  var15 = true;
               } else {
                  WorldMapType2.field534[var20].method5107(var42, var12);
               }

               if(class93.field1466 != null) {
                  class93.field1466[(var17.method1579()?8:0) + var17.location].method5058(var42 + 29, var12);
               }

               var0.method4843(Integer.toString(var17.id), var42 + 15, var40 / 2 + var12 + 5, var21, -1);
               var1.method4843(var19, var42 + 60, var40 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var25 + var40;
               ++var14;
               if(var14 >= var7) {
                  var12 = var27 + 23;
                  var42 = var42 + var41 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4775(World.worldList[class93.field1463].activity) + 6;
               int var30 = var1.verticalSpace + 8;
               Rasterizer2D.method4968(MouseInput.field734 - var16 / 2, MouseInput.field735 + 20 + 5, var16, var30, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.field734 - var16 / 2, MouseInput.field735 + 20 + 5, var16, var30, 0);
               var1.method4843(World.worldList[class93.field1463].activity, MouseInput.field734, MouseInput.field735 + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         IndexFile.field2286.vmethod5043(0, 0);
      } else {
         if(var3) {
            class244.field3300.method5107(class93.field1434, 0);
            class92.field1425.method5107(class93.field1434 + 382, 0);
            class12.logoSprite.method5058(class93.field1434 + 382 - class12.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4843("RuneScape is loading - please wait...", class93.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class93.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class93.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4968(class93.loginWindowX + 180 - 150, var5 + 2, class93.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method4968(class93.loginWindowX + 180 - 150 + class93.loadingBarPercentage * 3, var5 + 2, 300 - class93.loadingBarPercentage * 3, 30, 0);
            var0.method4843(class93.loadingText, class93.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var8;
         String var10;
         String var11;
         char[] var13;
         String var22;
         short var31;
         short var33;
         if(Client.gameState == 20) {
            class93.field1446.method5058(class93.loginWindowX + 180 - class93.field1446.originalWidth / 2, 271 - class93.field1446.height / 2);
            var31 = 211;
            var0.method4843(class93.loginMessage1, class93.loginWindowX + 180, var31, 16776960, 0);
            var32 = var31 + 15;
            var0.method4843(class93.loginMessage2, class93.loginWindowX + 180, var32, 16776960, 0);
            var32 += 15;
            var0.method4843(class93.loginMessage3, class93.loginWindowX + 180, var32, 16776960, 0);
            var32 += 15;
            var32 += 10;
            if(class93.loginIndex != 4) {
               var0.method4780("Login: ", class93.loginWindowX + 180 - 110, var32, 16777215, 0);
               var33 = 200;

               for(var22 = class93.username; var0.method4775(var22) > var33; var22 = var22.substring(0, var22.length() - 1)) {
                  ;
               }

               var0.method4780(FontTypeFace.appendTags(var22), class93.loginWindowX + 180 - 70, var32, 16777215, 0);
               var32 += 15;
               var8 = "Password: ";
               var10 = class93.password;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method4780(var8 + var11, class93.loginWindowX + 180 - 108, var32, 16777215, 0);
               var32 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class93.field1446.method5058(class93.loginWindowX, 171);
            short var6;
            if(class93.loginIndex == 0) {
               var31 = 251;
               var0.method4843("Welcome to RuneScape", class93.loginWindowX + 180, var31, 16776960, 0);
               var32 = var31 + 30;
               var5 = class93.loginWindowX + 180 - 80;
               var6 = 291;
               class93.field1436.method5058(var5 - 73, var6 - 20);
               var0.method4784("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class93.loginWindowX + 180 + 80;
               class93.field1436.method5058(var5 - 73, var6 - 20);
               var0.method4784("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class93.loginIndex == 1) {
               var0.method4843(class93.field1452, class93.loginWindowX + 180, 211, 16776960, 0);
               var31 = 236;
               var0.method4843(class93.loginMessage1, class93.loginWindowX + 180, var31, 16777215, 0);
               var32 = var31 + 15;
               var0.method4843(class93.loginMessage2, class93.loginWindowX + 180, var32, 16777215, 0);
               var32 += 15;
               var0.method4843(class93.loginMessage3, class93.loginWindowX + 180, var32, 16777215, 0);
               var32 += 15;
               var5 = class93.loginWindowX + 180 - 80;
               var6 = 321;
               class93.field1436.method5058(var5 - 73, var6 - 20);
               var0.method4843("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class93.loginWindowX + 180 + 80;
               class93.field1436.method5058(var5 - 73, var6 - 20);
               var0.method4843("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class93.loginIndex == 2) {
               var31 = 211;
               var0.method4843(class93.loginMessage1, class93.loginWindowX + 180, var31, 16776960, 0);
               var32 = var31 + 15;
               var0.method4843(class93.loginMessage2, class93.loginWindowX + 180, var32, 16776960, 0);
               var32 += 15;
               var0.method4843(class93.loginMessage3, class93.loginWindowX + 180, var32, 16776960, 0);
               var32 += 15;
               var32 += 10;
               var0.method4780("Login: ", class93.loginWindowX + 180 - 110, var32, 16777215, 0);
               var33 = 200;

               for(var22 = class93.username; var0.method4775(var22) > var33; var22 = var22.substring(1)) {
                  ;
               }

               var0.method4780(FontTypeFace.appendTags(var22) + (class93.loginIndex2 == 0 & Client.gameCycle % 40 < 20?Tile.getColTags(16776960) + "|":""), class93.loginWindowX + 180 - 70, var32, 16777215, 0);
               var32 += 15;
               var8 = "Password: ";
               var10 = class93.password;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method4780(var8 + var11 + (class93.loginIndex2 == 1 & Client.gameCycle % 40 < 20?Tile.getColTags(16776960) + "|":""), class93.loginWindowX + 180 - 108, var32, 16777215, 0);
               var32 += 15;
               var27 = class93.loginWindowX + 180 - 80;
               short var39 = 321;
               class93.field1436.method5058(var27 - 73, var39 - 20);
               var0.method4843("Login", var27, var39 + 5, 16777215, 0);
               var27 = class93.loginWindowX + 180 + 80;
               class93.field1436.method5058(var27 - 73, var39 - 20);
               var0.method4843("Cancel", var27, var39 + 5, 16777215, 0);
               var31 = 357;
               var1.method4843("Forgotten your password? <col=ffffff>Click here.", class93.loginWindowX + 180, var31, 16776960, 0);
            } else if(class93.loginIndex == 3) {
               var31 = 201;
               var0.method4843("Invalid username or password.", class93.loginWindowX + 180, var31, 16776960, 0);
               var32 = var31 + 20;
               var1.method4843("For accounts created after 24th November 2010, please use your", class93.loginWindowX + 180, var32, 16776960, 0);
               var32 += 15;
               var1.method4843("email address to login. Otherwise please login with your username.", class93.loginWindowX + 180, var32, 16776960, 0);
               var32 += 15;
               var5 = class93.loginWindowX + 180;
               var6 = 276;
               class93.field1436.method5058(var5 - 73, var6 - 20);
               var2.method4843("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class93.loginWindowX + 180;
               var6 = 326;
               class93.field1436.method5058(var5 - 73, var6 - 20);
               var2.method4843("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class93.loginIndex == 4) {
               var0.method4843("Authenticator", class93.loginWindowX + 180, 211, 16776960, 0);
               var31 = 236;
               var0.method4843(class93.loginMessage1, class93.loginWindowX + 180, var31, 16777215, 0);
               var32 = var31 + 15;
               var0.method4843(class93.loginMessage2, class93.loginWindowX + 180, var32, 16777215, 0);
               var32 += 15;
               var0.method4843(class93.loginMessage3, class93.loginWindowX + 180, var32, 16777215, 0);
               var32 += 15;
               var22 = "PIN: ";
               var8 = Preferences.authCode;
               var26 = var8.length();
               char[] var37 = new char[var26];

               for(var12 = 0; var12 < var26; ++var12) {
                  var37[var12] = 42;
               }

               String var9 = new String(var37);
               var0.method4780(var22 + var9 + (Client.gameCycle % 40 < 20?Tile.getColTags(16776960) + "|":""), class93.loginWindowX + 180 - 108, var32, 16777215, 0);
               var32 -= 8;
               var0.method4780("Trust this computer", class93.loginWindowX + 180 - 9, var32, 16776960, 0);
               var32 += 15;
               var0.method4780("for 30 days: ", class93.loginWindowX + 180 - 9, var32, 16776960, 0);
               var25 = class93.loginWindowX + 180 - 9 + var0.method4775("for 30 days: ") + 15;
               var26 = var32 - var0.verticalSpace;
               IndexedSprite var38;
               if(class93.field1435) {
                  var38 = class3.field17;
               } else {
                  var38 = class47.field601;
               }

               var38.method5058(var25, var26);
               var32 += 15;
               var12 = class93.loginWindowX + 180 - 80;
               short var28 = 321;
               class93.field1436.method5058(var12 - 73, var28 - 20);
               var0.method4843("Continue", var12, var28 + 5, 16777215, 0);
               var12 = class93.loginWindowX + 180 + 80;
               class93.field1436.method5058(var12 - 73, var28 - 20);
               var0.method4843("Cancel", var12, var28 + 5, 16777215, 0);
               var1.method4843("<u=ff>Can\'t Log In?</u>", class93.loginWindowX + 180, var28 + 36, 255, 0);
            } else if(class93.loginIndex == 5) {
               var0.method4843("Forgotten your password?", class93.loginWindowX + 180, 201, 16776960, 0);
               var31 = 221;
               var2.method4843(class93.loginMessage1, class93.loginWindowX + 180, var31, 16776960, 0);
               var32 = var31 + 15;
               var2.method4843(class93.loginMessage2, class93.loginWindowX + 180, var32, 16776960, 0);
               var32 += 15;
               var2.method4843(class93.loginMessage3, class93.loginWindowX + 180, var32, 16776960, 0);
               var32 += 15;
               var32 += 14;
               var0.method4780("Username/email: ", class93.loginWindowX + 180 - 145, var32, 16777215, 0);
               var33 = 174;

               for(var22 = class93.username; var0.method4775(var22) > var33; var22 = var22.substring(1)) {
                  ;
               }

               var0.method4780(FontTypeFace.appendTags(var22) + (Client.gameCycle % 40 < 20?Tile.getColTags(16776960) + "|":""), class93.loginWindowX + 180 - 34, var32, 16777215, 0);
               var32 += 15;
               var7 = class93.loginWindowX + 180 - 80;
               short var24 = 321;
               class93.field1436.method5058(var7 - 73, var24 - 20);
               var0.method4843("Recover", var7, var24 + 5, 16777215, 0);
               var7 = class93.loginWindowX + 180 + 80;
               class93.field1436.method5058(var7 - 73, var24 - 20);
               var0.method4843("Back", var7, var24 + 5, 16777215, 0);
            } else if(class93.loginIndex == 6) {
               var31 = 211;
               var0.method4843(class93.loginMessage1, class93.loginWindowX + 180, var31, 16776960, 0);
               var32 = var31 + 15;
               var0.method4843(class93.loginMessage2, class93.loginWindowX + 180, var32, 16776960, 0);
               var32 += 15;
               var0.method4843(class93.loginMessage3, class93.loginWindowX + 180, var32, 16776960, 0);
               var32 += 15;
               var5 = class93.loginWindowX + 180;
               var6 = 321;
               class93.field1436.method5058(var5 - 73, var6 - 20);
               var0.method4843("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class93.field1433 > 0) {
            PendingSpawn.method1521(class93.field1433);
            class93.field1433 = 0;
         }

         var31 = 256;
         if(class93.field1441 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class93.field1441 > 768) {
                  BaseVarType.field28[var5] = class11.method55(WorldMapData.field473[var5], WorldMapType3.field399[var5], 1024 - class93.field1441);
               } else if(class93.field1441 > 256) {
                  BaseVarType.field28[var5] = WorldMapType3.field399[var5];
               } else {
                  BaseVarType.field28[var5] = class11.method55(WorldMapType3.field399[var5], WorldMapData.field473[var5], 256 - class93.field1441);
               }
            }
         } else if(class93.field1442 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class93.field1442 > 768) {
                  BaseVarType.field28[var5] = class11.method55(WorldMapData.field473[var5], class93.field1440[var5], 1024 - class93.field1442);
               } else if(class93.field1442 > 256) {
                  BaseVarType.field28[var5] = class93.field1440[var5];
               } else {
                  BaseVarType.field28[var5] = class11.method55(class93.field1440[var5], WorldMapData.field473[var5], 256 - class93.field1442);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               BaseVarType.field28[var5] = WorldMapData.field473[var5];
            }
         }

         Rasterizer2D.setDrawRegion(class93.field1434, 9, class93.field1434 + 128, var31 + 7);
         class244.field3300.method5107(class93.field1434, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var34 = IndexFile.field2286.width * 9 + class93.field1434;

         for(var7 = 1; var7 < var31 - 1; ++var7) {
            var41 = class93.field1439[var7] * (var31 - var7) / var31;
            var25 = var41 + 22;
            if(var25 < 0) {
               var25 = 0;
            }

            var5 += var25;

            for(var26 = var25; var26 < 128; ++var26) {
               var27 = Ignore.field871[var5++];
               if(var27 != 0) {
                  var12 = var27;
                  var42 = 256 - var27;
                  var27 = BaseVarType.field28[var27];
                  var14 = IndexFile.field2286.pixels[var34];
                  IndexFile.field2286.pixels[var34++] = ((var14 & 16711935) * var42 + (var27 & 16711935) * var12 & -16711936) + (var12 * (var27 & '\uff00') + var42 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var34;
               }
            }

            var34 += var25 + IndexFile.field2286.width - 128;
         }

         Rasterizer2D.setDrawRegion(class93.field1434 + 765 - 128, 9, class93.field1434 + 765, var31 + 7);
         class92.field1425.method5107(class93.field1434 + 382, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var34 = IndexFile.field2286.width * 9 + 24 + 637 + class93.field1434;

         for(var7 = 1; var7 < var31 - 1; ++var7) {
            var41 = class93.field1439[var7] * (var31 - var7) / var31;
            var25 = 103 - var41;
            var34 += var41;

            for(var26 = 0; var26 < var25; ++var26) {
               var27 = Ignore.field871[var5++];
               if(var27 != 0) {
                  var12 = var27;
                  var42 = 256 - var27;
                  var27 = BaseVarType.field28[var27];
                  var14 = IndexFile.field2286.pixels[var34];
                  IndexFile.field2286.pixels[var34++] = (var42 * (var14 & '\uff00') + var12 * (var27 & '\uff00') & 16711680) + ((var27 & 16711935) * var12 + (var14 & 16711935) * var42 & -16711936) >> 8;
               } else {
                  ++var34;
               }
            }

            var5 += 128 - var25;
            var34 += IndexFile.field2286.width - var25 - var41;
         }

         class233.titlemuteSprite[class3.preferences.muted?1:0].method5058(class93.field1434 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class44.field590 != null) {
               var32 = class93.field1434 + 5;
               var33 = 463;
               byte var36 = 100;
               byte var35 = 35;
               class44.field590.method5058(var32, var33);
               var0.method4843("World" + " " + Client.world, var36 / 2 + var32, var35 / 2 + var33 - 2, 16777215, 0);
               if(class67.listFetcher != null) {
                  var1.method4843("Loading...", var36 / 2 + var32, var35 / 2 + var33 + 12, 16777215, 0);
               } else {
                  var1.method4843("Click to switch", var36 / 2 + var32, var35 / 2 + var33 + 12, 16777215, 0);
               }
            } else {
               class44.field590 = Projectile.getSprite(class176.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lil;",
      garbageValue = "522504713"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class156.field2257 != null) {
         var4 = new IndexFile(var0, class156.field2257, ISAACCipher.field2429[var0], 1000000);
      }

      return new IndexData(var4, XClanMember.field929, var0, var1, var2, var3);
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "119"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class35.plane][var0][var1];
      if(var2 == null) {
         class36.region.method2723(class35.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = SoundTask.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class36.region.method2723(class35.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class36.region.addItemPile(class35.plane, var0, var1, class25.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class35.plane), var5, var9, var11, var10);
         }
      }
   }
}
