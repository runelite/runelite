import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -2074550483
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 499458129
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1383156897
   )
   @Export("width")
   int width;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1579734447
   )
   @Export("height")
   int height;
   @ObfuscatedName("am")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("qm")
   @Export("canvas")
   public static Canvas canvas;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2128468747"
   )
   public void method2291(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2310(var1, var2, 128);
            this.method2310(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2310(var1, var2, 2);
            this.method2310(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2310(var1, var2, 8);
            this.method2310(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2310(var1, var2, 32);
            this.method2310(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2310(var1, var2, 1);
            this.method2310(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2310(var1, var2, 4);
            this.method2310(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2310(var1, var2, 16);
            this.method2310(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2310(var1, var2, 64);
            this.method2310(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2310(var1, var2, 130);
            this.method2310(var1 - 1, var2, 8);
            this.method2310(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2310(var1, var2, 10);
            this.method2310(var1, 1 + var2, 32);
            this.method2310(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2310(var1, var2, 40);
            this.method2310(var1 + 1, var2, 128);
            this.method2310(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2310(var1, var2, 160);
            this.method2310(var1, var2 - 1, 2);
            this.method2310(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2310(var1, var2, 65536);
               this.method2310(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2310(var1, var2, 1024);
               this.method2310(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2310(var1, var2, 4096);
               this.method2310(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2310(var1, var2, 16384);
               this.method2310(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2310(var1, var2, 512);
               this.method2310(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2310(var1, var2, 2048);
               this.method2310(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2310(var1, var2, 8192);
               this.method2310(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2310(var1, var2, '耀');
               this.method2310(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2310(var1, var2, 66560);
               this.method2310(var1 - 1, var2, 4096);
               this.method2310(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2310(var1, var2, 5120);
               this.method2310(var1, 1 + var2, 16384);
               this.method2310(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2310(var1, var2, 20480);
               this.method2310(1 + var1, var2, 65536);
               this.method2310(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2310(var1, var2, 81920);
               this.method2310(var1, var2 - 1, 1024);
               this.method2310(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "2115239842"
   )
   public void method2292(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2310(var7, var8, var6);
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
      this.method2300();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-1798944727"
   )
   public void method2294(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method2297(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1765537046"
   )
   public void method2295(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2297(var1, var2, 128);
            this.method2297(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2297(var1, var2, 2);
            this.method2297(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2297(var1, var2, 8);
            this.method2297(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2297(var1, var2, 32);
            this.method2297(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2297(var1, var2, 1);
            this.method2297(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2297(var1, var2, 4);
            this.method2297(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2297(var1, var2, 16);
            this.method2297(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2297(var1, var2, 64);
            this.method2297(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2297(var1, var2, 130);
            this.method2297(var1 - 1, var2, 8);
            this.method2297(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2297(var1, var2, 10);
            this.method2297(var1, 1 + var2, 32);
            this.method2297(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2297(var1, var2, 40);
            this.method2297(1 + var1, var2, 128);
            this.method2297(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2297(var1, var2, 160);
            this.method2297(var1, var2 - 1, 2);
            this.method2297(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2297(var1, var2, 65536);
               this.method2297(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2297(var1, var2, 1024);
               this.method2297(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2297(var1, var2, 4096);
               this.method2297(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2297(var1, var2, 16384);
               this.method2297(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2297(var1, var2, 512);
               this.method2297(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2297(var1, var2, 2048);
               this.method2297(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2297(var1, var2, 8192);
               this.method2297(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2297(var1, var2, '耀');
               this.method2297(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2297(var1, var2, 66560);
               this.method2297(var1 - 1, var2, 4096);
               this.method2297(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2297(var1, var2, 5120);
               this.method2297(var1, var2 + 1, 16384);
               this.method2297(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2297(var1, var2, 20480);
               this.method2297(var1 + 1, var2, 65536);
               this.method2297(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2297(var1, var2, 81920);
               this.method2297(var1, var2 - 1, 1024);
               this.method2297(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-587178136"
   )
   void method2297(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1032372060"
   )
   public void method2298(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1110184486"
   )
   public void method2300() {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1623939299"
   )
   public void method2303(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1934140294"
   )
   static final void method2308(int var0, int var1, int var2, int var3, int var4) {
      GroundObject.field1309[0].method4090(var0, var1);
      GroundObject.field1309[1].method4090(var0, var3 + var1 - 16);
      Rasterizer2D.method4028(var0, 16 + var1, 16, var3 - 32, Client.field390);
      int var5 = (var3 - 32) * var3 / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.method4028(var0, var6 + 16 + var1, 16, var5, Client.field417);
      Rasterizer2D.method4014(var0, var6 + var1 + 16, var5, Client.field393);
      Rasterizer2D.method4014(var0 + 1, var1 + 16 + var6, var5, Client.field393);
      Rasterizer2D.method4012(var0, var6 + var1 + 16, 16, Client.field393);
      Rasterizer2D.method4012(var0, var6 + var1 + 17, 16, Client.field393);
      Rasterizer2D.method4014(var0 + 15, var1 + 16 + var6, var5, Client.field418);
      Rasterizer2D.method4014(var0 + 14, var1 + 17 + var6, var5 - 1, Client.field418);
      Rasterizer2D.method4012(var0, var5 + var6 + 15 + var1, 16, Client.field418);
      Rasterizer2D.method4012(var0 + 1, var5 + var6 + 14 + var1, 15, Client.field418);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-891587588"
   )
   void method2310(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "70"
   )
   static World method2318() {
      return World.field700 < World.field697?World.worldList[++World.field700 - 1]:null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1823853526"
   )
   public void method2320(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }
}
