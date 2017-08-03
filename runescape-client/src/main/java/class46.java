import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class46 {
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 1748733933
   )
   static int field559;
   @ObfuscatedName("q")
   byte[][][] field563;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1403001375
   )
   int field561;

   class46(int var1) {
      this.field561 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   void method700() {
      byte[] var1 = new byte[this.field561 * this.field561];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[0][0] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[0][1] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[0][2] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[0][3] = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2138653143"
   )
   int method667(int var1, int var2) {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "273792784"
   )
   void method671() {
      byte[] var1 = new byte[this.field561 * this.field561];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[1][0] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
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

      this.field563[1][1] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[1][2] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[1][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1027678445"
   )
   int method668(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "647204524"
   )
   void method672() {
      byte[] var1 = new byte[this.field561 * this.field561];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[2][0] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[2][1] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[2][2] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[2][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1650211095"
   )
   void method673() {
      byte[] var1 = new byte[this.field561 * this.field561];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[3][0] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[3][1] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[3][2] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[3][3] = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2104731475"
   )
   void method670() {
      byte[] var1 = new byte[this.field561 * this.field561];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[4][0] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[4][1] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[4][2] = var1;
      var1 = new byte[this.field561 * this.field561];
      var2 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field563[4][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1700197620"
   )
   void method705() {
      byte[] var1 = new byte[this.field561 * this.field561];
      boolean var2 = false;
      var1 = new byte[this.field561 * this.field561];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 <= this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[5][0] = var1;
      var1 = new byte[this.field561 * this.field561];
      var5 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var3 <= this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[5][1] = var1;
      var1 = new byte[this.field561 * this.field561];
      var5 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 >= this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[5][2] = var1;
      var1 = new byte[this.field561 * this.field561];
      var5 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var3 >= this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[5][3] = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1114203726"
   )
   void method676() {
      byte[] var1 = new byte[this.field561 * this.field561];
      boolean var2 = false;
      var1 = new byte[this.field561 * this.field561];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 <= var3 - this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[6][0] = var1;
      var1 = new byte[this.field561 * this.field561];
      var5 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 <= var3 - this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[6][1] = var1;
      var1 = new byte[this.field561 * this.field561];
      var5 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[6][2] = var1;
      var1 = new byte[this.field561 * this.field561];
      var5 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[6][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1074857997"
   )
   void method666(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field561 != 0 && this.field563 != null) {
         var8 = this.method667(var8, var7);
         var7 = this.method668(var7);
         Rasterizer2D.method4943(var1, var2, var5, var6, var3, var4, this.field563[var7 - 1][var8], this.field561);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-697600367"
   )
   void method677() {
      byte[] var1 = new byte[this.field561 * this.field561];
      boolean var2 = false;
      var1 = new byte[this.field561 * this.field561];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 >= var3 - this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[7][0] = var1;
      var1 = new byte[this.field561 * this.field561];
      var5 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field561; ++var4) {
            if(var4 >= var3 - this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[7][1] = var1;
      var1 = new byte[this.field561 * this.field561];
      var5 = 0;

      for(var3 = this.field561 - 1; var3 >= 0; --var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[7][2] = var1;
      var1 = new byte[this.field561 * this.field561];
      var5 = 0;

      for(var3 = 0; var3 < this.field561; ++var3) {
         for(var4 = this.field561 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field561 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field563[7][3] = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "80"
   )
   void method690() {
      if(this.field563 == null) {
         this.field563 = new byte[8][4][];
         this.method700();
         this.method671();
         this.method672();
         this.method673();
         this.method670();
         this.method705();
         this.method676();
         this.method677();
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "([Lhn;IIIZB)V",
      garbageValue = "-116"
   )
   static void method686(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class152.method2947(var6, var2, var3, var4);
            class134.method2600(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               WorldListFetcher.method1530(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)Lji;",
      garbageValue = "-65"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = Friend.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = Friend.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(var19 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.notedTemplate != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var20 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field3520 != -1) {
            var20 = createSprite(var9.field3519, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.method2605();
         Graphics3D.method2686(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.field3520 != -1) {
            var20.method5069(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var19.method2509();
         var19.method2522(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var17 + var19.modelHeight / 2 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var20.method5069(0, 0);
         }

         if(var2 >= 1) {
            var8.method5065(1);
         }

         if(var2 >= 2) {
            var8.method5065(16777215);
         }

         if(var3 != 0) {
            var8.method5066(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.method5069(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class207.field2551.method4751(Varcs.method1836(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.method2605();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1621730289"
   )
   static final void method704(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class62.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var1][var3 + var2] = class62.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var3 + var1][var2] = class62.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class62.tileHeights[var0][var1 - 1][var2] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class62.tileHeights[var0][var1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class62.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-7"
   )
   public static boolean method699() {
      return class203.field2475 != 0?true:class203.field2473.method3716();
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(Lcj;I)V",
      garbageValue = "-1235803183"
   )
   static final void method697(Actor var0) {
      if(var0.field1207 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1223 + 1 > class40.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1207 - var0.field1235;
         int var2 = Client.gameCycle - var0.field1235;
         int var3 = var0.field1204 * 128 + var0.field1216 * 64;
         int var4 = var0.field1216 * 64 + var0.field1233 * 128;
         int var5 = var0.field1216 * 64 + var0.field1232 * 128;
         int var6 = var0.field1201 * 128 + var0.field1216 * 64;
         var0.x = (var3 * (var1 - var2) + var5 * var2) / var1;
         var0.y = (var4 * (var1 - var2) + var2 * var6) / var1;
      }

      var0.field1247 = 0;
      var0.orientation = var0.field1208;
      var0.angle = var0.orientation;
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-582467247"
   )
   static final void method665(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class7.loadWidget(var0)) {
         class37.method510(class170.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
