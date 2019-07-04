import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("CollisionMap")
public class CollisionMap {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 264774249
   )
   @Export("xInset")
   int xInset;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1037712787
   )
   @Export("yInset")
   int yInset;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 674483785
   )
   @Export("xSize")
   int xSize;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -871458249
   )
   @Export("ySize")
   int ySize;
   @ObfuscatedName("ab")
   @Export("flags")
   public int[][] flags;

   public CollisionMap(int var1, int var2) {
      this.xInset = 0;
      this.yInset = 0;
      this.xSize = var1;
      this.ySize = var2;
      this.flags = new int[this.xSize][this.ySize];
      this.clear();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1687025486"
   )
   @Export("clear")
   public void clear() {
      for (int var1 = 0; var1 < this.xSize; ++var1) {
         for (int var2 = 0; var2 < this.ySize; ++var2) {
            if (var1 != 0 && var2 != 0 && var1 < this.xSize - 5 && var2 < this.ySize - 5) {
               this.flags[var1][var2] = 16777216;
            } else {
               this.flags[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "2"
   )
   public void method90(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      if (var3 == 0) {
         if (var4 == 0) {
            this.method94(var1, var2, 128);
            this.method94(var1 - 1, var2, 8);
         }

         if (var4 == 1) {
            this.method94(var1, var2, 2);
            this.method94(var1, var2 + 1, 32);
         }

         if (var4 == 2) {
            this.method94(var1, var2, 8);
            this.method94(var1 + 1, var2, 128);
         }

         if (var4 == 3) {
            this.method94(var1, var2, 32);
            this.method94(var1, var2 - 1, 2);
         }
      }

      if (var3 == 1 || var3 == 3) {
         if (var4 == 0) {
            this.method94(var1, var2, 1);
            this.method94(var1 - 1, var2 + 1, 16);
         }

         if (var4 == 1) {
            this.method94(var1, var2, 4);
            this.method94(var1 + 1, var2 + 1, 64);
         }

         if (var4 == 2) {
            this.method94(var1, var2, 16);
            this.method94(var1 + 1, var2 - 1, 1);
         }

         if (var4 == 3) {
            this.method94(var1, var2, 64);
            this.method94(var1 - 1, var2 - 1, 4);
         }
      }

      if (var3 == 2) {
         if (var4 == 0) {
            this.method94(var1, var2, 130);
            this.method94(var1 - 1, var2, 8);
            this.method94(var1, var2 + 1, 32);
         }

         if (var4 == 1) {
            this.method94(var1, var2, 10);
            this.method94(var1, var2 + 1, 32);
            this.method94(var1 + 1, var2, 128);
         }

         if (var4 == 2) {
            this.method94(var1, var2, 40);
            this.method94(var1 + 1, var2, 128);
            this.method94(var1, var2 - 1, 2);
         }

         if (var4 == 3) {
            this.method94(var1, var2, 160);
            this.method94(var1, var2 - 1, 2);
            this.method94(var1 - 1, var2, 8);
         }
      }

      if (var5) {
         if (var3 == 0) {
            if (var4 == 0) {
               this.method94(var1, var2, 65536);
               this.method94(var1 - 1, var2, 4096);
            }

            if (var4 == 1) {
               this.method94(var1, var2, 1024);
               this.method94(var1, var2 + 1, 16384);
            }

            if (var4 == 2) {
               this.method94(var1, var2, 4096);
               this.method94(var1 + 1, var2, 65536);
            }

            if (var4 == 3) {
               this.method94(var1, var2, 16384);
               this.method94(var1, var2 - 1, 1024);
            }
         }

         if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
               this.method94(var1, var2, 512);
               this.method94(var1 - 1, var2 + 1, 8192);
            }

            if (var4 == 1) {
               this.method94(var1, var2, 2048);
               this.method94(var1 + 1, var2 + 1, 32768);
            }

            if (var4 == 2) {
               this.method94(var1, var2, 8192);
               this.method94(var1 + 1, var2 - 1, 512);
            }

            if (var4 == 3) {
               this.method94(var1, var2, 32768);
               this.method94(var1 - 1, var2 - 1, 2048);
            }
         }

         if (var3 == 2) {
            if (var4 == 0) {
               this.method94(var1, var2, 66560);
               this.method94(var1 - 1, var2, 4096);
               this.method94(var1, var2 + 1, 16384);
            }

            if (var4 == 1) {
               this.method94(var1, var2, 5120);
               this.method94(var1, var2 + 1, 16384);
               this.method94(var1 + 1, var2, 65536);
            }

            if (var4 == 2) {
               this.method94(var1, var2, 20480);
               this.method94(var1 + 1, var2, 65536);
               this.method94(var1, var2 - 1, 1024);
            }

            if (var4 == 3) {
               this.method94(var1, var2, 81920);
               this.method94(var1, var2 - 1, 1024);
               this.method94(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1813281219"
   )
   public void method91(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if (var5) {
         var6 += 131072;
      }

      var1 -= this.xInset;
      var2 -= this.yInset;

      for (int var7 = var1; var7 < var3 + var1; ++var7) {
         if (var7 >= 0 && var7 < this.xSize) {
            for (int var8 = var2; var8 < var2 + var4; ++var8) {
               if (var8 >= 0 && var8 < this.ySize) {
                  this.method94(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1082834717"
   )
   public void method92(int var1, int var2) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      int[] var10000 = this.flags[var1];
      var10000[var2] |= 2097152;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2022671149"
   )
   public void method93(int var1, int var2) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      int[] var10000 = this.flags[var1];
      var10000[var2] |= 262144;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "953350100"
   )
   void method94(int var1, int var2, int var3) {
      int[] var10000 = this.flags[var1];
      var10000[var2] |= var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "54"
   )
   public void method95(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      if (var3 == 0) {
         if (var4 == 0) {
            this.method97(var1, var2, 128);
            this.method97(var1 - 1, var2, 8);
         }

         if (var4 == 1) {
            this.method97(var1, var2, 2);
            this.method97(var1, var2 + 1, 32);
         }

         if (var4 == 2) {
            this.method97(var1, var2, 8);
            this.method97(var1 + 1, var2, 128);
         }

         if (var4 == 3) {
            this.method97(var1, var2, 32);
            this.method97(var1, var2 - 1, 2);
         }
      }

      if (var3 == 1 || var3 == 3) {
         if (var4 == 0) {
            this.method97(var1, var2, 1);
            this.method97(var1 - 1, var2 + 1, 16);
         }

         if (var4 == 1) {
            this.method97(var1, var2, 4);
            this.method97(var1 + 1, var2 + 1, 64);
         }

         if (var4 == 2) {
            this.method97(var1, var2, 16);
            this.method97(var1 + 1, var2 - 1, 1);
         }

         if (var4 == 3) {
            this.method97(var1, var2, 64);
            this.method97(var1 - 1, var2 - 1, 4);
         }
      }

      if (var3 == 2) {
         if (var4 == 0) {
            this.method97(var1, var2, 130);
            this.method97(var1 - 1, var2, 8);
            this.method97(var1, var2 + 1, 32);
         }

         if (var4 == 1) {
            this.method97(var1, var2, 10);
            this.method97(var1, var2 + 1, 32);
            this.method97(var1 + 1, var2, 128);
         }

         if (var4 == 2) {
            this.method97(var1, var2, 40);
            this.method97(var1 + 1, var2, 128);
            this.method97(var1, var2 - 1, 2);
         }

         if (var4 == 3) {
            this.method97(var1, var2, 160);
            this.method97(var1, var2 - 1, 2);
            this.method97(var1 - 1, var2, 8);
         }
      }

      if (var5) {
         if (var3 == 0) {
            if (var4 == 0) {
               this.method97(var1, var2, 65536);
               this.method97(var1 - 1, var2, 4096);
            }

            if (var4 == 1) {
               this.method97(var1, var2, 1024);
               this.method97(var1, var2 + 1, 16384);
            }

            if (var4 == 2) {
               this.method97(var1, var2, 4096);
               this.method97(var1 + 1, var2, 65536);
            }

            if (var4 == 3) {
               this.method97(var1, var2, 16384);
               this.method97(var1, var2 - 1, 1024);
            }
         }

         if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
               this.method97(var1, var2, 512);
               this.method97(var1 - 1, var2 + 1, 8192);
            }

            if (var4 == 1) {
               this.method97(var1, var2, 2048);
               this.method97(var1 + 1, var2 + 1, 32768);
            }

            if (var4 == 2) {
               this.method97(var1, var2, 8192);
               this.method97(var1 + 1, var2 - 1, 512);
            }

            if (var4 == 3) {
               this.method97(var1, var2, 32768);
               this.method97(var1 - 1, var2 - 1, 2048);
            }
         }

         if (var3 == 2) {
            if (var4 == 0) {
               this.method97(var1, var2, 66560);
               this.method97(var1 - 1, var2, 4096);
               this.method97(var1, var2 + 1, 16384);
            }

            if (var4 == 1) {
               this.method97(var1, var2, 5120);
               this.method97(var1, var2 + 1, 16384);
               this.method97(var1 + 1, var2, 65536);
            }

            if (var4 == 2) {
               this.method97(var1, var2, 20480);
               this.method97(var1 + 1, var2, 65536);
               this.method97(var1, var2 - 1, 1024);
            }

            if (var4 == 3) {
               this.method97(var1, var2, 81920);
               this.method97(var1, var2 - 1, 1024);
               this.method97(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)V",
      garbageValue = "23"
   )
   public void method96(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if (var6) {
         var7 += 131072;
      }

      var1 -= this.xInset;
      var2 -= this.yInset;
      int var8;
      if (var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for (var8 = var1; var8 < var3 + var1; ++var8) {
         if (var8 >= 0 && var8 < this.xSize) {
            for (int var9 = var2; var9 < var2 + var4; ++var9) {
               if (var9 >= 0 && var9 < this.ySize) {
                  this.method97(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "52290294"
   )
   void method97(int var1, int var2, int var3) {
      int[] var10000 = this.flags[var1];
      var10000[var2] &= ~var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "37"
   )
   public void method98(int var1, int var2) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      int[] var10000 = this.flags[var1];
      var10000[var2] &= -262145;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "108"
   )
   public static int method3632(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0 ? var0 : (var2 == 1 ? var1 : (var2 == 2 ? 7 - var0 : 7 - var1));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "616878226"
   )
   static int method3631(char var0, int var1) {
      int var2 = var0 << 4;
      if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
