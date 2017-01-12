import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 137825561
   )
   @Export("width")
   int width;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1114382205
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1659958903
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1087094351
   )
   @Export("height")
   int height;
   @ObfuscatedName("az")
   @Export("flags")
   public int[][] flags;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CIB)Ljava/lang/String;",
      garbageValue = "-88"
   )
   static String method2228(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   public void method2229() {
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2135583754"
   )
   public void method2231(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method2244(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-169785611"
   )
   public void method2232(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1434543366"
   )
   public void method2233(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-832835501"
   )
   public void method2235(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2237(var1, var2, 128);
            this.method2237(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2237(var1, var2, 2);
            this.method2237(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2237(var1, var2, 8);
            this.method2237(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2237(var1, var2, 32);
            this.method2237(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2237(var1, var2, 1);
            this.method2237(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2237(var1, var2, 4);
            this.method2237(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2237(var1, var2, 16);
            this.method2237(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2237(var1, var2, 64);
            this.method2237(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2237(var1, var2, 130);
            this.method2237(var1 - 1, var2, 8);
            this.method2237(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2237(var1, var2, 10);
            this.method2237(var1, var2 + 1, 32);
            this.method2237(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2237(var1, var2, 40);
            this.method2237(var1 + 1, var2, 128);
            this.method2237(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2237(var1, var2, 160);
            this.method2237(var1, var2 - 1, 2);
            this.method2237(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2237(var1, var2, 65536);
               this.method2237(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2237(var1, var2, 1024);
               this.method2237(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2237(var1, var2, 4096);
               this.method2237(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2237(var1, var2, 16384);
               this.method2237(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2237(var1, var2, 512);
               this.method2237(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2237(var1, var2, 2048);
               this.method2237(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2237(var1, var2, 8192);
               this.method2237(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2237(var1, var2, '耀');
               this.method2237(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2237(var1, var2, 66560);
               this.method2237(var1 - 1, var2, 4096);
               this.method2237(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2237(var1, var2, 5120);
               this.method2237(var1, var2 + 1, 16384);
               this.method2237(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2237(var1, var2, 20480);
               this.method2237(var1 + 1, var2, 65536);
               this.method2237(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2237(var1, var2, 81920);
               this.method2237(var1, var2 - 1, 1024);
               this.method2237(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1851060829"
   )
   public void method2236(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method2237(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1645395183"
   )
   void method2237(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "71"
   )
   public void method2238(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "-12775"
   )
   void method2244(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1082840359"
   )
   public void method2252(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2244(var1, var2, 128);
            this.method2244(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2244(var1, var2, 2);
            this.method2244(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2244(var1, var2, 8);
            this.method2244(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2244(var1, var2, 32);
            this.method2244(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2244(var1, var2, 1);
            this.method2244(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2244(var1, var2, 4);
            this.method2244(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2244(var1, var2, 16);
            this.method2244(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2244(var1, var2, 64);
            this.method2244(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2244(var1, var2, 130);
            this.method2244(var1 - 1, var2, 8);
            this.method2244(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2244(var1, var2, 10);
            this.method2244(var1, 1 + var2, 32);
            this.method2244(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2244(var1, var2, 40);
            this.method2244(1 + var1, var2, 128);
            this.method2244(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2244(var1, var2, 160);
            this.method2244(var1, var2 - 1, 2);
            this.method2244(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2244(var1, var2, 65536);
               this.method2244(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2244(var1, var2, 1024);
               this.method2244(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2244(var1, var2, 4096);
               this.method2244(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2244(var1, var2, 16384);
               this.method2244(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2244(var1, var2, 512);
               this.method2244(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2244(var1, var2, 2048);
               this.method2244(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2244(var1, var2, 8192);
               this.method2244(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2244(var1, var2, '耀');
               this.method2244(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2244(var1, var2, 66560);
               this.method2244(var1 - 1, var2, 4096);
               this.method2244(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2244(var1, var2, 5120);
               this.method2244(var1, 1 + var2, 16384);
               this.method2244(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2244(var1, var2, 20480);
               this.method2244(1 + var1, var2, 65536);
               this.method2244(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2244(var1, var2, 81920);
               this.method2244(var1, var2 - 1, 1024);
               this.method2244(var1 - 1, var2, 4096);
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
      this.method2229();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-112"
   )
   public static int method2265(String var0) {
      return var0.length() + 2;
   }
}
