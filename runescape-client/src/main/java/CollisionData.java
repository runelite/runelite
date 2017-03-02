import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -388623167
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("ay")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1555372513
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 74050409
   )
   @Export("width")
   int width;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -765703213
   )
   @Export("height")
   int height;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   public void method2316() {
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-151656818"
   )
   public void method2317(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2321(var1, var2, 128);
            this.method2321(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2321(var1, var2, 2);
            this.method2321(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2321(var1, var2, 8);
            this.method2321(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2321(var1, var2, 32);
            this.method2321(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2321(var1, var2, 1);
            this.method2321(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2321(var1, var2, 4);
            this.method2321(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2321(var1, var2, 16);
            this.method2321(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2321(var1, var2, 64);
            this.method2321(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2321(var1, var2, 130);
            this.method2321(var1 - 1, var2, 8);
            this.method2321(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2321(var1, var2, 10);
            this.method2321(var1, var2 + 1, 32);
            this.method2321(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2321(var1, var2, 40);
            this.method2321(1 + var1, var2, 128);
            this.method2321(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2321(var1, var2, 160);
            this.method2321(var1, var2 - 1, 2);
            this.method2321(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2321(var1, var2, 65536);
               this.method2321(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2321(var1, var2, 1024);
               this.method2321(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2321(var1, var2, 4096);
               this.method2321(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2321(var1, var2, 16384);
               this.method2321(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2321(var1, var2, 512);
               this.method2321(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2321(var1, var2, 2048);
               this.method2321(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2321(var1, var2, 8192);
               this.method2321(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2321(var1, var2, '耀');
               this.method2321(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2321(var1, var2, 66560);
               this.method2321(var1 - 1, var2, 4096);
               this.method2321(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2321(var1, var2, 5120);
               this.method2321(var1, var2 + 1, 16384);
               this.method2321(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2321(var1, var2, 20480);
               this.method2321(var1 + 1, var2, 65536);
               this.method2321(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2321(var1, var2, 81920);
               this.method2321(var1, var2 - 1, 1024);
               this.method2321(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-112"
   )
   public void method2318(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method2321(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2091447870"
   )
   public void method2319(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "764275563"
   )
   public void method2320(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "247"
   )
   void method2321(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "-260797199"
   )
   public static Widget method2322(int var0, int var1) {
      Widget var2 = class140.method2681(var0);
      return var1 == -1?var2:(var2 != null && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-983325087"
   )
   void method2324(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-89"
   )
   public void method2325(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "101"
   )
   public void method2327(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2324(var1, var2, 128);
            this.method2324(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2324(var1, var2, 2);
            this.method2324(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2324(var1, var2, 8);
            this.method2324(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2324(var1, var2, 32);
            this.method2324(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2324(var1, var2, 1);
            this.method2324(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2324(var1, var2, 4);
            this.method2324(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2324(var1, var2, 16);
            this.method2324(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2324(var1, var2, 64);
            this.method2324(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2324(var1, var2, 130);
            this.method2324(var1 - 1, var2, 8);
            this.method2324(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2324(var1, var2, 10);
            this.method2324(var1, var2 + 1, 32);
            this.method2324(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2324(var1, var2, 40);
            this.method2324(var1 + 1, var2, 128);
            this.method2324(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2324(var1, var2, 160);
            this.method2324(var1, var2 - 1, 2);
            this.method2324(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2324(var1, var2, 65536);
               this.method2324(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2324(var1, var2, 1024);
               this.method2324(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2324(var1, var2, 4096);
               this.method2324(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2324(var1, var2, 16384);
               this.method2324(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2324(var1, var2, 512);
               this.method2324(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2324(var1, var2, 2048);
               this.method2324(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2324(var1, var2, 8192);
               this.method2324(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2324(var1, var2, '耀');
               this.method2324(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2324(var1, var2, 66560);
               this.method2324(var1 - 1, var2, 4096);
               this.method2324(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2324(var1, var2, 5120);
               this.method2324(var1, var2 + 1, 16384);
               this.method2324(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2324(var1, var2, 20480);
               this.method2324(var1 + 1, var2, 65536);
               this.method2324(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2324(var1, var2, 81920);
               this.method2324(var1, var2 - 1, 1024);
               this.method2324(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-1171483091"
   )
   public void method2332(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method2324(var8, var9, var7);
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
      this.method2316();
   }
}
