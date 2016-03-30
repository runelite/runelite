import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("CollisionData")
public class class108 {
   @ObfuscatedName("az")
   @Export("flags")
   public int[][] field1894;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1045972943
   )
   int field1895;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -61447503
   )
   public int field1902 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1321950935
   )
   public int field1903 = 0;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 810629797
   )
   int field1905;
   @ObfuscatedName("di")
   static int[] field1909;
   @ObfuscatedName("bu")
   static class168 field1913;

   @ObfuscatedName("v")
   void method2392(int var1, int var2, int var3) {
      this.field1894[var1][var2] &= ~var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1245044091"
   )
   public void method2394() {
      for(int var1 = 0; var1 < this.field1895; ++var1) {
         for(int var2 = 0; var2 < this.field1905; ++var2) {
            if(0 != var1 && 0 != var2 && var1 < this.field1895 - 5 && var2 < this.field1905 - 5) {
               this.field1894[var1][var2] = 16777216;
            } else {
               this.field1894[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("p")
   public void method2395(int var1, int var2) {
      var1 -= this.field1902;
      var2 -= this.field1903;
      this.field1894[var1][var2] |= 2097152;
   }

   @ObfuscatedName("e")
   public void method2396(int var1, int var2) {
      var1 -= this.field1902;
      var2 -= this.field1903;
      this.field1894[var1][var2] |= 262144;
   }

   @ObfuscatedName("y")
   void method2397(int var1, int var2, int var3) {
      this.field1894[var1][var2] |= var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)V",
      garbageValue = "-23"
   )
   public void method2399(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1902;
      var2 -= this.field1903;
      int var8;
      if(1 == var5 || 3 == var5) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.field1895) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.field1905) {
                  this.method2392(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   public void method2401(int var1, int var2) {
      var1 -= this.field1902;
      var2 -= this.field1903;
      this.field1894[var1][var2] &= -262145;
   }

   @ObfuscatedName("t")
   public void method2408(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1902;
      var2 -= this.field1903;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.field1895) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.field1905) {
                  this.method2397(var7, var8, var6);
               }
            }
         }
      }

   }

   public class108(int var1, int var2) {
      this.field1895 = var1;
      this.field1905 = var2;
      this.field1894 = new int[this.field1895][this.field1905];
      this.method2394();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2098542533"
   )
   public void method2421(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1902;
      var2 -= this.field1903;
      if(0 == var3) {
         if(var4 == 0) {
            this.method2397(var1, var2, 128);
            this.method2397(var1 - 1, var2, 8);
         }

         if(1 == var4) {
            this.method2397(var1, var2, 2);
            this.method2397(var1, var2 + 1, 32);
         }

         if(2 == var4) {
            this.method2397(var1, var2, 8);
            this.method2397(var1 + 1, var2, 128);
         }

         if(3 == var4) {
            this.method2397(var1, var2, 32);
            this.method2397(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || 3 == var3) {
         if(0 == var4) {
            this.method2397(var1, var2, 1);
            this.method2397(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2397(var1, var2, 4);
            this.method2397(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2397(var1, var2, 16);
            this.method2397(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2397(var1, var2, 64);
            this.method2397(var1 - 1, var2 - 1, 4);
         }
      }

      if(2 == var3) {
         if(0 == var4) {
            this.method2397(var1, var2, 130);
            this.method2397(var1 - 1, var2, 8);
            this.method2397(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2397(var1, var2, 10);
            this.method2397(var1, 1 + var2, 32);
            this.method2397(var1 + 1, var2, 128);
         }

         if(2 == var4) {
            this.method2397(var1, var2, 40);
            this.method2397(1 + var1, var2, 128);
            this.method2397(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2397(var1, var2, 160);
            this.method2397(var1, var2 - 1, 2);
            this.method2397(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(0 == var4) {
               this.method2397(var1, var2, 65536);
               this.method2397(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2397(var1, var2, 1024);
               this.method2397(var1, 1 + var2, 16384);
            }

            if(2 == var4) {
               this.method2397(var1, var2, 4096);
               this.method2397(1 + var1, var2, 65536);
            }

            if(3 == var4) {
               this.method2397(var1, var2, 16384);
               this.method2397(var1, var2 - 1, 1024);
            }
         }

         if(1 == var3 || 3 == var3) {
            if(0 == var4) {
               this.method2397(var1, var2, 512);
               this.method2397(var1 - 1, 1 + var2, 8192);
            }

            if(1 == var4) {
               this.method2397(var1, var2, 2048);
               this.method2397(var1 + 1, var2 + 1, '耀');
            }

            if(2 == var4) {
               this.method2397(var1, var2, 8192);
               this.method2397(1 + var1, var2 - 1, 512);
            }

            if(3 == var4) {
               this.method2397(var1, var2, '耀');
               this.method2397(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(0 == var4) {
               this.method2397(var1, var2, 66560);
               this.method2397(var1 - 1, var2, 4096);
               this.method2397(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2397(var1, var2, 5120);
               this.method2397(var1, var2 + 1, 16384);
               this.method2397(1 + var1, var2, 65536);
            }

            if(2 == var4) {
               this.method2397(var1, var2, 20480);
               this.method2397(var1 + 1, var2, 65536);
               this.method2397(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2397(var1, var2, 81920);
               this.method2397(var1, var2 - 1, 1024);
               this.method2397(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1928878080"
   )
   public void method2423(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1902;
      var2 -= this.field1903;
      if(0 == var3) {
         if(var4 == 0) {
            this.method2392(var1, var2, 128);
            this.method2392(var1 - 1, var2, 8);
         }

         if(1 == var4) {
            this.method2392(var1, var2, 2);
            this.method2392(var1, var2 + 1, 32);
         }

         if(2 == var4) {
            this.method2392(var1, var2, 8);
            this.method2392(1 + var1, var2, 128);
         }

         if(3 == var4) {
            this.method2392(var1, var2, 32);
            this.method2392(var1, var2 - 1, 2);
         }
      }

      if(1 == var3 || var3 == 3) {
         if(0 == var4) {
            this.method2392(var1, var2, 1);
            this.method2392(var1 - 1, var2 + 1, 16);
         }

         if(1 == var4) {
            this.method2392(var1, var2, 4);
            this.method2392(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2392(var1, var2, 16);
            this.method2392(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2392(var1, var2, 64);
            this.method2392(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(0 == var4) {
            this.method2392(var1, var2, 130);
            this.method2392(var1 - 1, var2, 8);
            this.method2392(var1, var2 + 1, 32);
         }

         if(1 == var4) {
            this.method2392(var1, var2, 10);
            this.method2392(var1, var2 + 1, 32);
            this.method2392(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2392(var1, var2, 40);
            this.method2392(var1 + 1, var2, 128);
            this.method2392(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2392(var1, var2, 160);
            this.method2392(var1, var2 - 1, 2);
            this.method2392(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(0 == var3) {
            if(0 == var4) {
               this.method2392(var1, var2, 65536);
               this.method2392(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2392(var1, var2, 1024);
               this.method2392(var1, 1 + var2, 16384);
            }

            if(2 == var4) {
               this.method2392(var1, var2, 4096);
               this.method2392(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2392(var1, var2, 16384);
               this.method2392(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || 3 == var3) {
            if(0 == var4) {
               this.method2392(var1, var2, 512);
               this.method2392(var1 - 1, var2 + 1, 8192);
            }

            if(1 == var4) {
               this.method2392(var1, var2, 2048);
               this.method2392(var1 + 1, 1 + var2, '耀');
            }

            if(2 == var4) {
               this.method2392(var1, var2, 8192);
               this.method2392(var1 + 1, var2 - 1, 512);
            }

            if(3 == var4) {
               this.method2392(var1, var2, '耀');
               this.method2392(var1 - 1, var2 - 1, 2048);
            }
         }

         if(2 == var3) {
            if(0 == var4) {
               this.method2392(var1, var2, 66560);
               this.method2392(var1 - 1, var2, 4096);
               this.method2392(var1, var2 + 1, 16384);
            }

            if(1 == var4) {
               this.method2392(var1, var2, 5120);
               this.method2392(var1, 1 + var2, 16384);
               this.method2392(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2392(var1, var2, 20480);
               this.method2392(var1 + 1, var2, 65536);
               this.method2392(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2392(var1, var2, 81920);
               this.method2392(var1, var2 - 1, 1024);
               this.method2392(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("x")
   public static void method2424() {
      if(class140.field2163 != null) {
         class140 var0 = class140.field2163;
         synchronized(class140.field2163) {
            class140.field2163 = null;
         }
      }

   }
}
