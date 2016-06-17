import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("CollisionData")
public class class108 {
   @ObfuscatedName("ru")
   protected static boolean field1871;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1571692039
   )
   @Export("y")
   public int field1873 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1618399611
   )
   @Export("x")
   public int field1880 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -113742621
   )
   @Export("width")
   int field1881;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1824495735
   )
   @Export("height")
   int field1882;
   @ObfuscatedName("aq")
   @Export("flags")
   public int[][] field1884;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public class108(int var1, int var2) {
      this.field1881 = var1;
      this.field1882 = var2;
      this.field1884 = new int[this.field1881][this.field1882];
      this.method2419();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "774502092"
   )
   public void method2392(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1880;
      var2 -= this.field1873;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2408(var1, var2, 128);
            this.method2408(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2408(var1, var2, 2);
            this.method2408(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2408(var1, var2, 8);
            this.method2408(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2408(var1, var2, 32);
            this.method2408(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2408(var1, var2, 1);
            this.method2408(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2408(var1, var2, 4);
            this.method2408(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2408(var1, var2, 16);
            this.method2408(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2408(var1, var2, 64);
            this.method2408(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2408(var1, var2, 130);
            this.method2408(var1 - 1, var2, 8);
            this.method2408(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2408(var1, var2, 10);
            this.method2408(var1, var2 + 1, 32);
            this.method2408(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2408(var1, var2, 40);
            this.method2408(var1 + 1, var2, 128);
            this.method2408(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2408(var1, var2, 160);
            this.method2408(var1, var2 - 1, 2);
            this.method2408(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2408(var1, var2, 65536);
               this.method2408(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2408(var1, var2, 1024);
               this.method2408(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2408(var1, var2, 4096);
               this.method2408(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2408(var1, var2, 16384);
               this.method2408(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2408(var1, var2, 512);
               this.method2408(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2408(var1, var2, 2048);
               this.method2408(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2408(var1, var2, 8192);
               this.method2408(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2408(var1, var2, '耀');
               this.method2408(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2408(var1, var2, 66560);
               this.method2408(var1 - 1, var2, 4096);
               this.method2408(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2408(var1, var2, 5120);
               this.method2408(var1, var2 + 1, 16384);
               this.method2408(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2408(var1, var2, 20480);
               this.method2408(1 + var1, var2, 65536);
               this.method2408(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2408(var1, var2, 81920);
               this.method2408(var1, var2 - 1, 1024);
               this.method2408(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1978067111"
   )
   public void method2393(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1880;
      var2 -= this.field1873;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.field1881) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.field1882) {
                  this.method2408(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1930596607"
   )
   public void method2394(int var1, int var2) {
      var1 -= this.field1880;
      var2 -= this.field1873;
      this.field1884[var1][var2] |= 2097152;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-352156545"
   )
   public void method2395(int var1, int var2) {
      var1 -= this.field1880;
      var2 -= this.field1873;
      this.field1884[var1][var2] |= 262144;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-99"
   )
   public void method2397(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1880;
      var2 -= this.field1873;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2399(var1, var2, 128);
            this.method2399(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2399(var1, var2, 2);
            this.method2399(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2399(var1, var2, 8);
            this.method2399(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2399(var1, var2, 32);
            this.method2399(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2399(var1, var2, 1);
            this.method2399(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2399(var1, var2, 4);
            this.method2399(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2399(var1, var2, 16);
            this.method2399(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2399(var1, var2, 64);
            this.method2399(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2399(var1, var2, 130);
            this.method2399(var1 - 1, var2, 8);
            this.method2399(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2399(var1, var2, 10);
            this.method2399(var1, var2 + 1, 32);
            this.method2399(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2399(var1, var2, 40);
            this.method2399(var1 + 1, var2, 128);
            this.method2399(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2399(var1, var2, 160);
            this.method2399(var1, var2 - 1, 2);
            this.method2399(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2399(var1, var2, 65536);
               this.method2399(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2399(var1, var2, 1024);
               this.method2399(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2399(var1, var2, 4096);
               this.method2399(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2399(var1, var2, 16384);
               this.method2399(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2399(var1, var2, 512);
               this.method2399(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2399(var1, var2, 2048);
               this.method2399(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2399(var1, var2, 8192);
               this.method2399(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2399(var1, var2, '耀');
               this.method2399(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2399(var1, var2, 66560);
               this.method2399(var1 - 1, var2, 4096);
               this.method2399(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2399(var1, var2, 5120);
               this.method2399(var1, var2 + 1, 16384);
               this.method2399(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2399(var1, var2, 20480);
               this.method2399(1 + var1, var2, 65536);
               this.method2399(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2399(var1, var2, 81920);
               this.method2399(var1, var2 - 1, 1024);
               this.method2399(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-51990920"
   )
   public void method2398(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1880;
      var2 -= this.field1873;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.field1881) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.field1882) {
                  this.method2399(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2142015863"
   )
   void method2399(int var1, int var2, int var3) {
      this.field1884[var1][var2] &= ~var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-392036379"
   )
   public void method2400(int var1, int var2) {
      var1 -= this.field1880;
      var2 -= this.field1873;
      this.field1884[var1][var2] &= -262145;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "25226"
   )
   void method2408(int var1, int var2, int var3) {
      this.field1884[var1][var2] |= var3;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-840506927"
   )
   static final int method2413(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.field69[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class5.field83[var5][var3 + 1][var4] + (128 - var6) * class5.field83[var5][var3][var4] >> 7;
         int var9 = var6 * class5.field83[var5][var3 + 1][1 + var4] + (128 - var6) * class5.field83[var5][var3][1 + var4] >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "-644406467"
   )
   public static String method2414(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class161.field2634[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class161.field2634[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[2 + var4] & 255;
               var3.append(class161.field2634[(var6 & 15) << 2 | var7 >>> 6]).append(class161.field2634[var7 & 63]);
            } else {
               var3.append(class161.field2634[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class161.field2634[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-183496286"
   )
   public void method2419() {
      for(int var1 = 0; var1 < this.field1881; ++var1) {
         for(int var2 = 0; var2 < this.field1882; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.field1881 - 5 && var2 < this.field1882 - 5) {
               this.field1884[var1][var2] = 16777216;
            } else {
               this.field1884[var1][var2] = 16777215;
            }
         }
      }

   }
}
