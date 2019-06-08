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
      for(int var1 = 0; var1 < this.xSize; ++var1) {
         for(int var2 = 0; var2 < this.ySize; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.xSize - 5 && var2 < this.ySize - 5) {
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
   @Export("__f_283")
   public void __f_283(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      if(var3 == 0) {
         if(var4 == 0) {
            this.__u_287(var1, var2, 128);
            this.__u_287(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.__u_287(var1, var2, 2);
            this.__u_287(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.__u_287(var1, var2, 8);
            this.__u_287(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.__u_287(var1, var2, 32);
            this.__u_287(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.__u_287(var1, var2, 1);
            this.__u_287(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.__u_287(var1, var2, 4);
            this.__u_287(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.__u_287(var1, var2, 16);
            this.__u_287(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.__u_287(var1, var2, 64);
            this.__u_287(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.__u_287(var1, var2, 130);
            this.__u_287(var1 - 1, var2, 8);
            this.__u_287(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.__u_287(var1, var2, 10);
            this.__u_287(var1, var2 + 1, 32);
            this.__u_287(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.__u_287(var1, var2, 40);
            this.__u_287(var1 + 1, var2, 128);
            this.__u_287(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.__u_287(var1, var2, 160);
            this.__u_287(var1, var2 - 1, 2);
            this.__u_287(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.__u_287(var1, var2, 65536);
               this.__u_287(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.__u_287(var1, var2, 1024);
               this.__u_287(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.__u_287(var1, var2, 4096);
               this.__u_287(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.__u_287(var1, var2, 16384);
               this.__u_287(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.__u_287(var1, var2, 512);
               this.__u_287(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.__u_287(var1, var2, 2048);
               this.__u_287(var1 + 1, var2 + 1, 32768);
            }

            if(var4 == 2) {
               this.__u_287(var1, var2, 8192);
               this.__u_287(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.__u_287(var1, var2, 32768);
               this.__u_287(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.__u_287(var1, var2, 66560);
               this.__u_287(var1 - 1, var2, 4096);
               this.__u_287(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.__u_287(var1, var2, 5120);
               this.__u_287(var1, var2 + 1, 16384);
               this.__u_287(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.__u_287(var1, var2, 20480);
               this.__u_287(var1 + 1, var2, 65536);
               this.__u_287(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.__u_287(var1, var2, 81920);
               this.__u_287(var1, var2 - 1, 1024);
               this.__u_287(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1813281219"
   )
   @Export("__q_284")
   public void __q_284(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.xInset;
      var2 -= this.yInset;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.xSize) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.ySize) {
                  this.__u_287(var7, var8, var6);
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
   @Export("__w_285")
   public void __w_285(int var1, int var2) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2022671149"
   )
   @Export("__o_286")
   public void __o_286(int var1, int var2) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "953350100"
   )
   @Export("__u_287")
   void __u_287(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "54"
   )
   @Export("__g_288")
   public void __g_288(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      if(var3 == 0) {
         if(var4 == 0) {
            this.__e_290(var1, var2, 128);
            this.__e_290(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.__e_290(var1, var2, 2);
            this.__e_290(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.__e_290(var1, var2, 8);
            this.__e_290(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.__e_290(var1, var2, 32);
            this.__e_290(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.__e_290(var1, var2, 1);
            this.__e_290(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.__e_290(var1, var2, 4);
            this.__e_290(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.__e_290(var1, var2, 16);
            this.__e_290(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.__e_290(var1, var2, 64);
            this.__e_290(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.__e_290(var1, var2, 130);
            this.__e_290(var1 - 1, var2, 8);
            this.__e_290(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.__e_290(var1, var2, 10);
            this.__e_290(var1, var2 + 1, 32);
            this.__e_290(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.__e_290(var1, var2, 40);
            this.__e_290(var1 + 1, var2, 128);
            this.__e_290(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.__e_290(var1, var2, 160);
            this.__e_290(var1, var2 - 1, 2);
            this.__e_290(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.__e_290(var1, var2, 65536);
               this.__e_290(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.__e_290(var1, var2, 1024);
               this.__e_290(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.__e_290(var1, var2, 4096);
               this.__e_290(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.__e_290(var1, var2, 16384);
               this.__e_290(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.__e_290(var1, var2, 512);
               this.__e_290(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.__e_290(var1, var2, 2048);
               this.__e_290(var1 + 1, var2 + 1, 32768);
            }

            if(var4 == 2) {
               this.__e_290(var1, var2, 8192);
               this.__e_290(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.__e_290(var1, var2, 32768);
               this.__e_290(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.__e_290(var1, var2, 66560);
               this.__e_290(var1 - 1, var2, 4096);
               this.__e_290(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.__e_290(var1, var2, 5120);
               this.__e_290(var1, var2 + 1, 16384);
               this.__e_290(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.__e_290(var1, var2, 20480);
               this.__e_290(var1 + 1, var2, 65536);
               this.__e_290(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.__e_290(var1, var2, 81920);
               this.__e_290(var1, var2 - 1, 1024);
               this.__e_290(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)V",
      garbageValue = "23"
   )
   @Export("__l_289")
   public void __l_289(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.xInset;
      var2 -= this.yInset;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.xSize) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.ySize) {
                  this.__e_290(var8, var9, var7);
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
   @Export("__e_290")
   void __e_290(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "37"
   )
   @Export("__x_291")
   public void __x_291(int var1, int var2) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "108"
   )
   public static int method3632(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "616878226"
   )
   static int method3631(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
