import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("CollisionData")
public class class108 {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1319950403
   )
   @Export("y")
   int field1903 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 728780057
   )
   @Export("width")
   int field1904;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -997247797
   )
   @Export("height")
   int field1905;
   @ObfuscatedName("ap")
   @Export("flags")
   public int[][] field1906;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 298519047
   )
   @Export("x")
   int field1907 = 0;
   @ObfuscatedName("ey")
   static class78[] field1908;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-951516483"
   )
   public void method2352() {
      for(int var1 = 0; var1 < this.field1904; ++var1) {
         for(int var2 = 0; var2 < this.field1905; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.field1904 - 5 && var2 < this.field1905 - 5) {
               this.field1906[var1][var2] = 16777216;
            } else {
               this.field1906[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1699941717"
   )
   void method2354(int var1, int var2, int var3) {
      this.field1906[var1][var2] |= var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2066076749"
   )
   public void method2356(int var1, int var2) {
      var1 -= this.field1907;
      var2 -= this.field1903;
      this.field1906[var1][var2] |= 262144;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-63"
   )
   public void method2357(int var1, int var2) {
      var1 -= this.field1907;
      var2 -= this.field1903;
      this.field1906[var1][var2] |= 2097152;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1846454793"
   )
   public void method2358(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1907;
      var2 -= this.field1903;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2360(var1, var2, 128);
            this.method2360(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2360(var1, var2, 2);
            this.method2360(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2360(var1, var2, 8);
            this.method2360(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2360(var1, var2, 32);
            this.method2360(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2360(var1, var2, 1);
            this.method2360(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2360(var1, var2, 4);
            this.method2360(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2360(var1, var2, 16);
            this.method2360(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2360(var1, var2, 64);
            this.method2360(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2360(var1, var2, 130);
            this.method2360(var1 - 1, var2, 8);
            this.method2360(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2360(var1, var2, 10);
            this.method2360(var1, 1 + var2, 32);
            this.method2360(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2360(var1, var2, 40);
            this.method2360(1 + var1, var2, 128);
            this.method2360(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2360(var1, var2, 160);
            this.method2360(var1, var2 - 1, 2);
            this.method2360(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2360(var1, var2, 65536);
               this.method2360(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2360(var1, var2, 1024);
               this.method2360(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2360(var1, var2, 4096);
               this.method2360(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2360(var1, var2, 16384);
               this.method2360(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2360(var1, var2, 512);
               this.method2360(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2360(var1, var2, 2048);
               this.method2360(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2360(var1, var2, 8192);
               this.method2360(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2360(var1, var2, '耀');
               this.method2360(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2360(var1, var2, 66560);
               this.method2360(var1 - 1, var2, 4096);
               this.method2360(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2360(var1, var2, 5120);
               this.method2360(var1, var2 + 1, 16384);
               this.method2360(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2360(var1, var2, 20480);
               this.method2360(1 + var1, var2, 65536);
               this.method2360(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2360(var1, var2, 81920);
               this.method2360(var1, var2 - 1, 1024);
               this.method2360(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1658466052"
   )
   public void method2359(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1907;
      var2 -= this.field1903;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2354(var1, var2, 128);
            this.method2354(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2354(var1, var2, 2);
            this.method2354(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2354(var1, var2, 8);
            this.method2354(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2354(var1, var2, 32);
            this.method2354(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2354(var1, var2, 1);
            this.method2354(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2354(var1, var2, 4);
            this.method2354(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2354(var1, var2, 16);
            this.method2354(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2354(var1, var2, 64);
            this.method2354(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2354(var1, var2, 130);
            this.method2354(var1 - 1, var2, 8);
            this.method2354(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2354(var1, var2, 10);
            this.method2354(var1, var2 + 1, 32);
            this.method2354(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2354(var1, var2, 40);
            this.method2354(var1 + 1, var2, 128);
            this.method2354(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2354(var1, var2, 160);
            this.method2354(var1, var2 - 1, 2);
            this.method2354(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2354(var1, var2, 65536);
               this.method2354(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2354(var1, var2, 1024);
               this.method2354(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2354(var1, var2, 4096);
               this.method2354(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2354(var1, var2, 16384);
               this.method2354(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2354(var1, var2, 512);
               this.method2354(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2354(var1, var2, 2048);
               this.method2354(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2354(var1, var2, 8192);
               this.method2354(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2354(var1, var2, '耀');
               this.method2354(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2354(var1, var2, 66560);
               this.method2354(var1 - 1, var2, 4096);
               this.method2354(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2354(var1, var2, 5120);
               this.method2354(var1, 1 + var2, 16384);
               this.method2354(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2354(var1, var2, 20480);
               this.method2354(1 + var1, var2, 65536);
               this.method2354(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2354(var1, var2, 81920);
               this.method2354(var1, var2 - 1, 1024);
               this.method2354(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-89"
   )
   void method2360(int var1, int var2, int var3) {
      this.field1906[var1][var2] &= ~var3;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "172388325"
   )
   public void method2361(int var1, int var2) {
      var1 -= this.field1907;
      var2 -= this.field1903;
      this.field1906[var1][var2] &= -262145;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1509811383"
   )
   public void method2363(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1907;
      var2 -= this.field1903;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.field1904) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.field1905) {
                  this.method2354(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-1631262109"
   )
   public void method2374(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1907;
      var2 -= this.field1903;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.field1904) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.field1905) {
                  this.method2360(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public class108(int var1, int var2) {
      this.field1904 = var1;
      this.field1905 = var2;
      this.field1906 = new int[this.field1904][this.field1905];
      this.method2352();
   }
}
