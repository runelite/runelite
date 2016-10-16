import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1520744015
   )
   @Export("width")
   int width;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 743814603
   )
   @Export("x")
   public int x = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -74458255
   )
   @Export("y")
   public int y = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1581061303
   )
   @Export("height")
   int height;
   @ObfuscatedName("av")
   @Export("flags")
   public int[][] flags;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1194545122"
   )
   public void method2360() {
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1683012054"
   )
   public void method2361(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2365(var1, var2, 128);
            this.method2365(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2365(var1, var2, 2);
            this.method2365(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2365(var1, var2, 8);
            this.method2365(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2365(var1, var2, 32);
            this.method2365(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2365(var1, var2, 1);
            this.method2365(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2365(var1, var2, 4);
            this.method2365(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2365(var1, var2, 16);
            this.method2365(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2365(var1, var2, 64);
            this.method2365(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2365(var1, var2, 130);
            this.method2365(var1 - 1, var2, 8);
            this.method2365(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2365(var1, var2, 10);
            this.method2365(var1, 1 + var2, 32);
            this.method2365(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2365(var1, var2, 40);
            this.method2365(1 + var1, var2, 128);
            this.method2365(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2365(var1, var2, 160);
            this.method2365(var1, var2 - 1, 2);
            this.method2365(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2365(var1, var2, 65536);
               this.method2365(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2365(var1, var2, 1024);
               this.method2365(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2365(var1, var2, 4096);
               this.method2365(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2365(var1, var2, 16384);
               this.method2365(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2365(var1, var2, 512);
               this.method2365(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2365(var1, var2, 2048);
               this.method2365(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2365(var1, var2, 8192);
               this.method2365(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2365(var1, var2, '耀');
               this.method2365(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2365(var1, var2, 66560);
               this.method2365(var1 - 1, var2, 4096);
               this.method2365(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2365(var1, var2, 5120);
               this.method2365(var1, 1 + var2, 16384);
               this.method2365(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2365(var1, var2, 20480);
               this.method2365(var1 + 1, var2, 65536);
               this.method2365(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2365(var1, var2, 81920);
               this.method2365(var1, var2 - 1, 1024);
               this.method2365(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "76"
   )
   public void method2362(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2365(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "165648078"
   )
   public void method2363(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1752713310"
   )
   void method2365(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1795107549"
   )
   public void method2366(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2375(var1, var2, 128);
            this.method2375(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2375(var1, var2, 2);
            this.method2375(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2375(var1, var2, 8);
            this.method2375(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2375(var1, var2, 32);
            this.method2375(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2375(var1, var2, 1);
            this.method2375(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2375(var1, var2, 4);
            this.method2375(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2375(var1, var2, 16);
            this.method2375(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2375(var1, var2, 64);
            this.method2375(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2375(var1, var2, 130);
            this.method2375(var1 - 1, var2, 8);
            this.method2375(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2375(var1, var2, 10);
            this.method2375(var1, var2 + 1, 32);
            this.method2375(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2375(var1, var2, 40);
            this.method2375(1 + var1, var2, 128);
            this.method2375(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2375(var1, var2, 160);
            this.method2375(var1, var2 - 1, 2);
            this.method2375(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2375(var1, var2, 65536);
               this.method2375(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2375(var1, var2, 1024);
               this.method2375(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2375(var1, var2, 4096);
               this.method2375(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2375(var1, var2, 16384);
               this.method2375(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2375(var1, var2, 512);
               this.method2375(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2375(var1, var2, 2048);
               this.method2375(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2375(var1, var2, 8192);
               this.method2375(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2375(var1, var2, '耀');
               this.method2375(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2375(var1, var2, 66560);
               this.method2375(var1 - 1, var2, 4096);
               this.method2375(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2375(var1, var2, 5120);
               this.method2375(var1, 1 + var2, 16384);
               this.method2375(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2375(var1, var2, 20480);
               this.method2375(1 + var1, var2, 65536);
               this.method2375(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2375(var1, var2, 81920);
               this.method2375(var1, var2 - 1, 1024);
               this.method2375(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1906298281"
   )
   public void method2367(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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

      for(var8 = var1; var8 < var1 + var3; ++var8) {
         if(var8 >= 0 && var8 < this.width) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method2375(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1336259374"
   )
   public void method2369(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "351410916"
   )
   void method2375(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-49"
   )
   public void method2377(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2360();
   }
}
