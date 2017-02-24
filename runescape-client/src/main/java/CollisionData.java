import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1204905411
   )
   @Export("width")
   int width;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 273288273
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -401637357
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -188450253
   )
   @Export("height")
   int height;
   @ObfuscatedName("ah")
   @Export("flags")
   public int[][] flags;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-672183195"
   )
   public void method2305(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method2314(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1294731137"
   )
   public void method2306() {
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
      signature = "(IIIIZB)V",
      garbageValue = "-79"
   )
   public void method2307(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2311(var1, var2, 128);
            this.method2311(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2311(var1, var2, 2);
            this.method2311(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2311(var1, var2, 8);
            this.method2311(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2311(var1, var2, 32);
            this.method2311(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2311(var1, var2, 1);
            this.method2311(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2311(var1, var2, 4);
            this.method2311(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2311(var1, var2, 16);
            this.method2311(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2311(var1, var2, 64);
            this.method2311(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2311(var1, var2, 130);
            this.method2311(var1 - 1, var2, 8);
            this.method2311(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2311(var1, var2, 10);
            this.method2311(var1, 1 + var2, 32);
            this.method2311(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2311(var1, var2, 40);
            this.method2311(1 + var1, var2, 128);
            this.method2311(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2311(var1, var2, 160);
            this.method2311(var1, var2 - 1, 2);
            this.method2311(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2311(var1, var2, 65536);
               this.method2311(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2311(var1, var2, 1024);
               this.method2311(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2311(var1, var2, 4096);
               this.method2311(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2311(var1, var2, 16384);
               this.method2311(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2311(var1, var2, 512);
               this.method2311(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2311(var1, var2, 2048);
               this.method2311(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2311(var1, var2, 8192);
               this.method2311(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2311(var1, var2, '耀');
               this.method2311(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2311(var1, var2, 66560);
               this.method2311(var1 - 1, var2, 4096);
               this.method2311(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2311(var1, var2, 5120);
               this.method2311(var1, var2 + 1, 16384);
               this.method2311(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2311(var1, var2, 20480);
               this.method2311(var1 + 1, var2, 65536);
               this.method2311(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2311(var1, var2, 81920);
               this.method2311(var1, var2 - 1, 1024);
               this.method2311(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-949031688"
   )
   public void method2309(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-445937930"
   )
   public void method2310(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-993640959"
   )
   void method2311(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "520628157"
   )
   public void method2312(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2314(var1, var2, 128);
            this.method2314(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2314(var1, var2, 2);
            this.method2314(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2314(var1, var2, 8);
            this.method2314(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2314(var1, var2, 32);
            this.method2314(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2314(var1, var2, 1);
            this.method2314(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2314(var1, var2, 4);
            this.method2314(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2314(var1, var2, 16);
            this.method2314(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2314(var1, var2, 64);
            this.method2314(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2314(var1, var2, 130);
            this.method2314(var1 - 1, var2, 8);
            this.method2314(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2314(var1, var2, 10);
            this.method2314(var1, 1 + var2, 32);
            this.method2314(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2314(var1, var2, 40);
            this.method2314(1 + var1, var2, 128);
            this.method2314(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2314(var1, var2, 160);
            this.method2314(var1, var2 - 1, 2);
            this.method2314(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2314(var1, var2, 65536);
               this.method2314(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2314(var1, var2, 1024);
               this.method2314(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2314(var1, var2, 4096);
               this.method2314(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2314(var1, var2, 16384);
               this.method2314(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2314(var1, var2, 512);
               this.method2314(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2314(var1, var2, 2048);
               this.method2314(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2314(var1, var2, 8192);
               this.method2314(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2314(var1, var2, '耀');
               this.method2314(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2314(var1, var2, 66560);
               this.method2314(var1 - 1, var2, 4096);
               this.method2314(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2314(var1, var2, 5120);
               this.method2314(var1, var2 + 1, 16384);
               this.method2314(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2314(var1, var2, 20480);
               this.method2314(var1 + 1, var2, 65536);
               this.method2314(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2314(var1, var2, 81920);
               this.method2314(var1, var2 - 1, 1024);
               this.method2314(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1514443227"
   )
   void method2314(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-354858078"
   )
   public void method2321(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2306();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1154826932"
   )
   public void method2331(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method2311(var7, var8, var6);
               }
            }
         }
      }

   }
}
