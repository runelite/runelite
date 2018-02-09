import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class46 {
   @ObfuscatedName("fk")
   static byte[][] field571;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1960592883
   )
   int field570;
   @ObfuscatedName("g")
   byte[][][] field568;

   class46(int var1) {
      this.field570 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "209201032"
   )
   void method636(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field570 != 0 && this.field568 != null) {
         var8 = this.method637(var8, var7);
         var7 = this.method638(var7);
         Rasterizer2D.method5570(var1, var2, var5, var6, var3, var4, this.field568[var7 - 1][var8], this.field570);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-1"
   )
   int method637(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1509643310"
   )
   int method638(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2127386034"
   )
   void method660() {
      if(this.field568 == null) {
         this.field568 = new byte[8][4][];
         this.method640();
         this.method648();
         this.method642();
         this.method667();
         this.method644();
         this.method639();
         this.method662();
         this.method647();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-901421066"
   )
   void method640() {
      byte[] var1 = new byte[this.field570 * this.field570];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[0][0] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[0][1] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[0][2] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[0][3] = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "126"
   )
   void method648() {
      byte[] var1 = new byte[this.field570 * this.field570];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[1][0] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field568[1][1] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[1][2] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[1][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "97"
   )
   void method642() {
      byte[] var1 = new byte[this.field570 * this.field570];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[2][0] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[2][1] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[2][2] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[2][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2067164676"
   )
   void method667() {
      byte[] var1 = new byte[this.field570 * this.field570];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[3][0] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[3][1] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[3][2] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[3][3] = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "888993260"
   )
   void method644() {
      byte[] var1 = new byte[this.field570 * this.field570];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[4][0] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[4][1] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[4][2] = var1;
      var1 = new byte[this.field570 * this.field570];
      var2 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field568[4][3] = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1617373463"
   )
   void method639() {
      byte[] var1 = new byte[this.field570 * this.field570];
      boolean var2 = false;
      var1 = new byte[this.field570 * this.field570];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 <= this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[5][0] = var1;
      var1 = new byte[this.field570 * this.field570];
      var5 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var3 <= this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[5][1] = var1;
      var1 = new byte[this.field570 * this.field570];
      var5 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 >= this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[5][2] = var1;
      var1 = new byte[this.field570 * this.field570];
      var5 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var3 >= this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[5][3] = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "125"
   )
   void method662() {
      byte[] var1 = new byte[this.field570 * this.field570];
      boolean var2 = false;
      var1 = new byte[this.field570 * this.field570];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 <= var3 - this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[6][0] = var1;
      var1 = new byte[this.field570 * this.field570];
      var5 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 <= var3 - this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[6][1] = var1;
      var1 = new byte[this.field570 * this.field570];
      var5 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[6][2] = var1;
      var1 = new byte[this.field570 * this.field570];
      var5 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[6][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-822727346"
   )
   void method647() {
      byte[] var1 = new byte[this.field570 * this.field570];
      boolean var2 = false;
      var1 = new byte[this.field570 * this.field570];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 >= var3 - this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[7][0] = var1;
      var1 = new byte[this.field570 * this.field570];
      var5 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field570; ++var4) {
            if(var4 >= var3 - this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[7][1] = var1;
      var1 = new byte[this.field570 * this.field570];
      var5 = 0;

      for(var3 = this.field570 - 1; var3 >= 0; --var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[7][2] = var1;
      var1 = new byte[this.field570 * this.field570];
      var5 = 0;

      for(var3 = 0; var3 < this.field570; ++var3) {
         for(var4 = this.field570 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field570 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field568[7][3] = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)V",
      garbageValue = "900851968"
   )
   static void method675(Font var0, Font var1) {
      if(class85.field1291 == null) {
         class85.field1291 = class36.getSprites(class37.indexSprites, "sl_back", "");
      }

      if(class89.slFlagSprites == null) {
         class89.slFlagSprites = class233.getIndexedSprites(class37.indexSprites, "sl_flags", "");
      }

      if(class89.slArrowSprites == null) {
         class89.slArrowSprites = class233.getIndexedSprites(class37.indexSprites, "sl_arrows", "");
      }

      if(class222.slStarSprites == null) {
         class222.slStarSprites = class233.getIndexedSprites(class37.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.Rasterizer2D_fillRectangle(class89.field1356, 23, 765, 480, 0);
      Rasterizer2D.method5569(class89.field1356, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method5569(class89.field1356 + 125, 0, 640, 23, 5197647, 2697513);
      var0.drawTextCentered("Select a world", class89.field1356 + 62, 15, 0, -1);
      if(class222.slStarSprites != null) {
         class222.slStarSprites[1].method5653(class89.field1356 + 140, 1);
         var1.method5384("Members only world", class89.field1356 + 152, 10, 16777215, -1);
         class222.slStarSprites[0].method5653(class89.field1356 + 140, 12);
         var1.method5384("Free world", class89.field1356 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class89.slArrowSprites != null) {
         int var2 = class89.field1356 + 280;
         if(World.field1187[0] == 0 && World.field1186[0] == 0) {
            class89.slArrowSprites[2].method5653(var2, 4);
         } else {
            class89.slArrowSprites[0].method5653(var2, 4);
         }

         if(World.field1187[0] == 0 && World.field1186[0] == 1) {
            class89.slArrowSprites[3].method5653(var2 + 15, 4);
         } else {
            class89.slArrowSprites[1].method5653(var2 + 15, 4);
         }

         var0.method5384("World", var2 + 32, 17, 16777215, -1);
         int var3 = class89.field1356 + 390;
         if(World.field1187[0] == 1 && World.field1186[0] == 0) {
            class89.slArrowSprites[2].method5653(var3, 4);
         } else {
            class89.slArrowSprites[0].method5653(var3, 4);
         }

         if(World.field1187[0] == 1 && World.field1186[0] == 1) {
            class89.slArrowSprites[3].method5653(var3 + 15, 4);
         } else {
            class89.slArrowSprites[1].method5653(var3 + 15, 4);
         }

         var0.method5384("Players", var3 + 32, 17, 16777215, -1);
         var4 = class89.field1356 + 500;
         if(World.field1187[0] == 2 && World.field1186[0] == 0) {
            class89.slArrowSprites[2].method5653(var4, 4);
         } else {
            class89.slArrowSprites[0].method5653(var4, 4);
         }

         if(World.field1187[0] == 2 && World.field1186[0] == 1) {
            class89.slArrowSprites[3].method5653(var4 + 15, 4);
         } else {
            class89.slArrowSprites[1].method5653(var4 + 15, 4);
         }

         var0.method5384("Location", var4 + 32, 17, 16777215, -1);
         var5 = class89.field1356 + 610;
         if(World.field1187[0] == 3 && World.field1186[0] == 0) {
            class89.slArrowSprites[2].method5653(var5, 4);
         } else {
            class89.slArrowSprites[0].method5653(var5, 4);
         }

         if(World.field1187[0] == 3 && World.field1186[0] == 1) {
            class89.slArrowSprites[3].method5653(var5 + 15, 4);
         } else {
            class89.slArrowSprites[1].method5653(var5 + 15, 4);
         }

         var0.method5384("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.Rasterizer2D_fillRectangle(class89.field1356 + 708, 4, 50, 16, 0);
      var1.drawTextCentered("Cancel", class89.field1356 + 708 + 25, 16, 16777215, -1);
      class89.field1353 = -1;
      if(class85.field1291 != null) {
         byte var21 = 88;
         byte var22 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (var22 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= World.worldCount) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }
         } while(var6 != var5 || var7 != var4);

         var6 = (765 - var21 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var22 * var5) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var21 * var4 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var22 * var5 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class89.field1356;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.worldCount; ++var14) {
            World var15 = class31.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method1627()) {
               if(var15.method1621()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1654()) {
               var19 = 16711680;
               if(var15.method1621()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1635()) {
               if(var15.method1621()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1621()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(MouseInput.mouseLastX >= var11 && MouseInput.mouseLastY >= var10 && MouseInput.mouseLastX < var11 + var21 && MouseInput.mouseLastY < var10 + var22 && var16) {
               class89.field1353 = var14;
               class85.field1291[var18].method5688(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class85.field1291[var18].method5682(var11, var10);
            }

            if(class89.slFlagSprites != null) {
               class89.slFlagSprites[(var15.method1621()?8:0) + var15.location].method5653(var11 + 29, var10);
            }

            var0.drawTextCentered(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
            var1.drawTextCentered(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
            var10 = var10 + var22 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 = var11 + var21 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.getTextWidth(class31.worldList[class89.field1353].activity) + 6;
            int var20 = var1.verticalSpace + 8;
            Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - var14 / 2, MouseInput.mouseLastY + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.drawRectangle(MouseInput.mouseLastX - var14 / 2, MouseInput.mouseLastY + 20 + 5, var14, var20, 0);
            var1.drawTextCentered(class31.worldList[class89.field1353].activity, MouseInput.mouseLastX, MouseInput.mouseLastY + var1.verticalSpace + 20 + 5 + 4, 0, -1);
         }
      }

      class22.rasterProvider.drawFull(0, 0);
   }
}
