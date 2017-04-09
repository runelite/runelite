import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -2022375189
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -521499429
   )
   @Export("width")
   int width;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1635142023
   )
   @Export("height")
   int height;
   @ObfuscatedName("bk")
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("bj")
   static ModIcon field1858;
   @ObfuscatedName("qs")
   protected static java.awt.Frame field1860;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1846446975
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("ap")
   @Export("flags")
   public int[][] flags;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-68"
   )
   void method2316(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "25"
   )
   public void method2317(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2316(var1, var2, 128);
            this.method2316(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2316(var1, var2, 2);
            this.method2316(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2316(var1, var2, 8);
            this.method2316(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2316(var1, var2, 32);
            this.method2316(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2316(var1, var2, 1);
            this.method2316(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2316(var1, var2, 4);
            this.method2316(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2316(var1, var2, 16);
            this.method2316(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2316(var1, var2, 64);
            this.method2316(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2316(var1, var2, 130);
            this.method2316(var1 - 1, var2, 8);
            this.method2316(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2316(var1, var2, 10);
            this.method2316(var1, var2 + 1, 32);
            this.method2316(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2316(var1, var2, 40);
            this.method2316(var1 + 1, var2, 128);
            this.method2316(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2316(var1, var2, 160);
            this.method2316(var1, var2 - 1, 2);
            this.method2316(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2316(var1, var2, 65536);
               this.method2316(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2316(var1, var2, 1024);
               this.method2316(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2316(var1, var2, 4096);
               this.method2316(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2316(var1, var2, 16384);
               this.method2316(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2316(var1, var2, 512);
               this.method2316(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2316(var1, var2, 2048);
               this.method2316(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2316(var1, var2, 8192);
               this.method2316(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2316(var1, var2, '耀');
               this.method2316(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2316(var1, var2, 66560);
               this.method2316(var1 - 1, var2, 4096);
               this.method2316(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2316(var1, var2, 5120);
               this.method2316(var1, var2 + 1, 16384);
               this.method2316(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2316(var1, var2, 20480);
               this.method2316(var1 + 1, var2, 65536);
               this.method2316(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2316(var1, var2, 81920);
               this.method2316(var1, var2 - 1, 1024);
               this.method2316(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1683548762"
   )
   public void method2319(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1918312749"
   )
   public void method2320(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1437682301"
   )
   public void method2322(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2324(var1, var2, 128);
            this.method2324(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2324(var1, var2, 2);
            this.method2324(var1, var2 + 1, 32);
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
            this.method2324(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2324(var1, var2, 4);
            this.method2324(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2324(var1, var2, 16);
            this.method2324(var1 + 1, var2 - 1, 1);
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
            this.method2324(var1 + 1, var2, 128);
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
               this.method2324(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2324(var1, var2, 16384);
               this.method2324(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2324(var1, var2, 512);
               this.method2324(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2324(var1, var2, 2048);
               this.method2324(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2324(var1, var2, 8192);
               this.method2324(var1 + 1, var2 - 1, 512);
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-1599519797"
   )
   public void method2323(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-74548383"
   )
   void method2324(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "32"
   )
   public void method2325(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-75"
   )
   public void method2330(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method2316(var7, var8, var6);
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
      this.method2346();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1651408462"
   )
   public void method2346() {
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1832530956"
   )
   public static void method2347(int var0) {
      class138.field1940 = 1;
      class149.field2061 = null;
      class138.field1941 = -1;
      RSCanvas.field1777 = -1;
      NPC.field783 = 0;
      class138.field1938 = false;
      class138.field1937 = var0;
   }
}
