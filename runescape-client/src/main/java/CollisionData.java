import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -617329845
   )
   @Export("width")
   int width;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -529289855
   )
   @Export("x")
   public int x = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1180350361
   )
   @Export("y")
   public int y = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1420825931
   )
   @Export("height")
   int height;
   @ObfuscatedName("ar")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("qh")
   static class136 field1963;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1231709576"
   )
   public void method2449(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2458(var1, var2, 128);
            this.method2458(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2458(var1, var2, 2);
            this.method2458(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2458(var1, var2, 8);
            this.method2458(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2458(var1, var2, 32);
            this.method2458(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2458(var1, var2, 1);
            this.method2458(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2458(var1, var2, 4);
            this.method2458(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2458(var1, var2, 16);
            this.method2458(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2458(var1, var2, 64);
            this.method2458(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2458(var1, var2, 130);
            this.method2458(var1 - 1, var2, 8);
            this.method2458(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2458(var1, var2, 10);
            this.method2458(var1, 1 + var2, 32);
            this.method2458(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2458(var1, var2, 40);
            this.method2458(var1 + 1, var2, 128);
            this.method2458(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2458(var1, var2, 160);
            this.method2458(var1, var2 - 1, 2);
            this.method2458(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2458(var1, var2, 65536);
               this.method2458(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2458(var1, var2, 1024);
               this.method2458(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2458(var1, var2, 4096);
               this.method2458(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2458(var1, var2, 16384);
               this.method2458(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2458(var1, var2, 512);
               this.method2458(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2458(var1, var2, 2048);
               this.method2458(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2458(var1, var2, 8192);
               this.method2458(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2458(var1, var2, '耀');
               this.method2458(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2458(var1, var2, 66560);
               this.method2458(var1 - 1, var2, 4096);
               this.method2458(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2458(var1, var2, 5120);
               this.method2458(var1, var2 + 1, 16384);
               this.method2458(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2458(var1, var2, 20480);
               this.method2458(1 + var1, var2, 65536);
               this.method2458(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2458(var1, var2, 81920);
               this.method2458(var1, var2 - 1, 1024);
               this.method2458(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1498948403"
   )
   public void method2450(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2458(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-99"
   )
   public void method2451(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "6"
   )
   public void method2453(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "0"
   )
   public void method2454(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2456(var1, var2, 128);
            this.method2456(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2456(var1, var2, 2);
            this.method2456(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2456(var1, var2, 8);
            this.method2456(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2456(var1, var2, 32);
            this.method2456(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2456(var1, var2, 1);
            this.method2456(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2456(var1, var2, 4);
            this.method2456(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2456(var1, var2, 16);
            this.method2456(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2456(var1, var2, 64);
            this.method2456(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2456(var1, var2, 130);
            this.method2456(var1 - 1, var2, 8);
            this.method2456(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2456(var1, var2, 10);
            this.method2456(var1, 1 + var2, 32);
            this.method2456(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2456(var1, var2, 40);
            this.method2456(1 + var1, var2, 128);
            this.method2456(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2456(var1, var2, 160);
            this.method2456(var1, var2 - 1, 2);
            this.method2456(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2456(var1, var2, 65536);
               this.method2456(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2456(var1, var2, 1024);
               this.method2456(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2456(var1, var2, 4096);
               this.method2456(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2456(var1, var2, 16384);
               this.method2456(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2456(var1, var2, 512);
               this.method2456(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2456(var1, var2, 2048);
               this.method2456(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2456(var1, var2, 8192);
               this.method2456(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2456(var1, var2, '耀');
               this.method2456(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2456(var1, var2, 66560);
               this.method2456(var1 - 1, var2, 4096);
               this.method2456(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2456(var1, var2, 5120);
               this.method2456(var1, var2 + 1, 16384);
               this.method2456(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2456(var1, var2, 20480);
               this.method2456(1 + var1, var2, 65536);
               this.method2456(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2456(var1, var2, 81920);
               this.method2456(var1, var2 - 1, 1024);
               this.method2456(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-1225906606"
   )
   public void method2455(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method2456(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "420133030"
   )
   void method2456(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "800153021"
   )
   public void method2457(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-939394662"
   )
   void method2458(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2469();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   public void method2469() {
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
}
