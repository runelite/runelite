import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -692622523
   )
   @Export("width")
   int width;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1643099009
   )
   @Export("x")
   public int x;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -391387717
   )
   @Export("y")
   public int y;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1297417325
   )
   @Export("height")
   int height;
   @ObfuscatedName("ap")
   @Export("flags")
   public int[][] flags;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.x = 0;
      this.y = 0;
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method3022();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "509308130"
   )
   public void method3021(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method3025(var1, var2, 128);
            this.method3025(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method3025(var1, var2, 2);
            this.method3025(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method3025(var1, var2, 8);
            this.method3025(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method3025(var1, var2, 32);
            this.method3025(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method3025(var1, var2, 1);
            this.method3025(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method3025(var1, var2, 4);
            this.method3025(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method3025(var1, var2, 16);
            this.method3025(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method3025(var1, var2, 64);
            this.method3025(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method3025(var1, var2, 130);
            this.method3025(var1 - 1, var2, 8);
            this.method3025(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method3025(var1, var2, 10);
            this.method3025(var1, var2 + 1, 32);
            this.method3025(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method3025(var1, var2, 40);
            this.method3025(var1 + 1, var2, 128);
            this.method3025(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method3025(var1, var2, 160);
            this.method3025(var1, var2 - 1, 2);
            this.method3025(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method3025(var1, var2, 65536);
               this.method3025(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method3025(var1, var2, 1024);
               this.method3025(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method3025(var1, var2, 4096);
               this.method3025(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method3025(var1, var2, 16384);
               this.method3025(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method3025(var1, var2, 512);
               this.method3025(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method3025(var1, var2, 2048);
               this.method3025(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method3025(var1, var2, 8192);
               this.method3025(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method3025(var1, var2, '耀');
               this.method3025(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method3025(var1, var2, 66560);
               this.method3025(var1 - 1, var2, 4096);
               this.method3025(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method3025(var1, var2, 5120);
               this.method3025(var1, var2 + 1, 16384);
               this.method3025(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method3025(var1, var2, 20480);
               this.method3025(var1 + 1, var2, 65536);
               this.method3025(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method3025(var1, var2, 81920);
               this.method3025(var1, var2 - 1, 1024);
               this.method3025(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   public void method3022() {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-560298172"
   )
   public void method3023(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-63"
   )
   public void method3024(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method3025(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "18"
   )
   void method3025(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "470166375"
   )
   public void method3026(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method3031(var1, var2, 128);
            this.method3031(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method3031(var1, var2, 2);
            this.method3031(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method3031(var1, var2, 8);
            this.method3031(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method3031(var1, var2, 32);
            this.method3031(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method3031(var1, var2, 1);
            this.method3031(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method3031(var1, var2, 4);
            this.method3031(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method3031(var1, var2, 16);
            this.method3031(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method3031(var1, var2, 64);
            this.method3031(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method3031(var1, var2, 130);
            this.method3031(var1 - 1, var2, 8);
            this.method3031(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method3031(var1, var2, 10);
            this.method3031(var1, var2 + 1, 32);
            this.method3031(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method3031(var1, var2, 40);
            this.method3031(var1 + 1, var2, 128);
            this.method3031(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method3031(var1, var2, 160);
            this.method3031(var1, var2 - 1, 2);
            this.method3031(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method3031(var1, var2, 65536);
               this.method3031(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method3031(var1, var2, 1024);
               this.method3031(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method3031(var1, var2, 4096);
               this.method3031(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method3031(var1, var2, 16384);
               this.method3031(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method3031(var1, var2, 512);
               this.method3031(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method3031(var1, var2, 2048);
               this.method3031(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method3031(var1, var2, 8192);
               this.method3031(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method3031(var1, var2, '耀');
               this.method3031(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method3031(var1, var2, 66560);
               this.method3031(var1 - 1, var2, 4096);
               this.method3031(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method3031(var1, var2, 5120);
               this.method3031(var1, var2 + 1, 16384);
               this.method3031(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method3031(var1, var2, 20480);
               this.method3031(var1 + 1, var2, 65536);
               this.method3031(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method3031(var1, var2, 81920);
               this.method3031(var1, var2 - 1, 1024);
               this.method3031(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1002717726"
   )
   public void method3027(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method3031(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "91"
   )
   public void method3029(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1481098443"
   )
   void method3031(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2018791130"
   )
   public void method3050(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }
}
