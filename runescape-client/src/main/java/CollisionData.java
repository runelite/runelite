import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -682642447
   )
   @Export("width")
   int width;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1657524499
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 530534563
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1766919467
   )
   @Export("height")
   int height;
   @ObfuscatedName("ar")
   @Export("flags")
   public int[][] flags;

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1391698879"
   )
   static final void method2178(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field359.method2330(); null != var10; var10 = (class25)Client.field359.method2346()) {
         if(var0 == var10.field584 && var10.field579 == var1 && var10.field583 == var2 && var10.field578 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field584 = var0;
         var9.field578 = var3;
         var9.field579 = var1;
         var9.field583 = var2;
         Player.method221(var9);
         Client.field359.method2333(var9);
      }

      var9.field581 = var4;
      var9.field592 = var5;
      var9.field585 = var6;
      var9.field586 = var7;
      var9.field588 = var8;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1888435990"
   )
   public void method2179() {
      for(int var1 = 0; var1 < this.width; ++var1) {
         for(int var2 = 0; var2 < this.height; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.width - 5 && var2 < this.height - 5) {
               this.flags[var1][var2] = 16777216;
            } else {
               this.flags[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1810937901"
   )
   public void method2180(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-402476981"
   )
   public void method2181(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2184(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-81"
   )
   public void method2182(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "5"
   )
   void method2183(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "12590"
   )
   void method2184(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIZS)V",
      garbageValue = "23689"
   )
   public void method2185(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2184(var1, var2, 128);
            this.method2184(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2184(var1, var2, 2);
            this.method2184(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2184(var1, var2, 8);
            this.method2184(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2184(var1, var2, 32);
            this.method2184(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2184(var1, var2, 1);
            this.method2184(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2184(var1, var2, 4);
            this.method2184(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2184(var1, var2, 16);
            this.method2184(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2184(var1, var2, 64);
            this.method2184(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2184(var1, var2, 130);
            this.method2184(var1 - 1, var2, 8);
            this.method2184(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2184(var1, var2, 10);
            this.method2184(var1, 1 + var2, 32);
            this.method2184(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2184(var1, var2, 40);
            this.method2184(var1 + 1, var2, 128);
            this.method2184(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2184(var1, var2, 160);
            this.method2184(var1, var2 - 1, 2);
            this.method2184(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2184(var1, var2, 65536);
               this.method2184(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2184(var1, var2, 1024);
               this.method2184(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2184(var1, var2, 4096);
               this.method2184(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2184(var1, var2, 16384);
               this.method2184(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2184(var1, var2, 512);
               this.method2184(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2184(var1, var2, 2048);
               this.method2184(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2184(var1, var2, 8192);
               this.method2184(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2184(var1, var2, '耀');
               this.method2184(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2184(var1, var2, 66560);
               this.method2184(var1 - 1, var2, 4096);
               this.method2184(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2184(var1, var2, 5120);
               this.method2184(var1, var2 + 1, 16384);
               this.method2184(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2184(var1, var2, 20480);
               this.method2184(var1 + 1, var2, 65536);
               this.method2184(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2184(var1, var2, 81920);
               this.method2184(var1, var2 - 1, 1024);
               this.method2184(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)V",
      garbageValue = "-37"
   )
   public void method2186(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.width) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method2183(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2179();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1359401538"
   )
   public void method2204(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2043946847"
   )
   public void method2213(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2183(var1, var2, 128);
            this.method2183(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2183(var1, var2, 2);
            this.method2183(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2183(var1, var2, 8);
            this.method2183(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2183(var1, var2, 32);
            this.method2183(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2183(var1, var2, 1);
            this.method2183(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2183(var1, var2, 4);
            this.method2183(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2183(var1, var2, 16);
            this.method2183(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2183(var1, var2, 64);
            this.method2183(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2183(var1, var2, 130);
            this.method2183(var1 - 1, var2, 8);
            this.method2183(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2183(var1, var2, 10);
            this.method2183(var1, var2 + 1, 32);
            this.method2183(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2183(var1, var2, 40);
            this.method2183(1 + var1, var2, 128);
            this.method2183(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2183(var1, var2, 160);
            this.method2183(var1, var2 - 1, 2);
            this.method2183(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2183(var1, var2, 65536);
               this.method2183(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2183(var1, var2, 1024);
               this.method2183(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2183(var1, var2, 4096);
               this.method2183(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2183(var1, var2, 16384);
               this.method2183(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2183(var1, var2, 512);
               this.method2183(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2183(var1, var2, 2048);
               this.method2183(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2183(var1, var2, 8192);
               this.method2183(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2183(var1, var2, '耀');
               this.method2183(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2183(var1, var2, 66560);
               this.method2183(var1 - 1, var2, 4096);
               this.method2183(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2183(var1, var2, 5120);
               this.method2183(var1, 1 + var2, 16384);
               this.method2183(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2183(var1, var2, 20480);
               this.method2183(var1 + 1, var2, 65536);
               this.method2183(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2183(var1, var2, 81920);
               this.method2183(var1, var2 - 1, 1024);
               this.method2183(var1 - 1, var2, 4096);
            }
         }
      }

   }
}
