import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("CollisionData")
public class class107 {
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1535007773
   )
   int field1873;
   @ObfuscatedName("n")
   static class18 field1879;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 967291459
   )
   int field1884 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1104499189
   )
   int field1885 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -924137565
   )
   int field1887;
   @ObfuscatedName("ab")
   @Export("flags")
   public int[][] field1888;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -820747477
   )
   static int field1891;
   @ObfuscatedName("kg")
   static class130 field1894;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "125"
   )
   public void method2396() {
      for(int var1 = 0; var1 < this.field1873; ++var1) {
         for(int var2 = 0; var2 < this.field1887; ++var2) {
            if(0 != var1 && var2 != 0 && var1 < this.field1873 - 5 && var2 < this.field1887 - 5) {
               this.field1888[var1][var2] = 16777216;
            } else {
               this.field1888[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "2051295550"
   )
   public void method2397(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1884;
      var2 -= this.field1885;
      if(var3 == 0) {
         if(0 == var4) {
            this.method2404(var1, var2, 128);
            this.method2404(var1 - 1, var2, 8);
         }

         if(1 == var4) {
            this.method2404(var1, var2, 2);
            this.method2404(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2404(var1, var2, 8);
            this.method2404(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2404(var1, var2, 32);
            this.method2404(var1, var2 - 1, 2);
         }
      }

      if(1 == var3 || var3 == 3) {
         if(var4 == 0) {
            this.method2404(var1, var2, 1);
            this.method2404(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2404(var1, var2, 4);
            this.method2404(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2404(var1, var2, 16);
            this.method2404(var1 + 1, var2 - 1, 1);
         }

         if(3 == var4) {
            this.method2404(var1, var2, 64);
            this.method2404(var1 - 1, var2 - 1, 4);
         }
      }

      if(2 == var3) {
         if(var4 == 0) {
            this.method2404(var1, var2, 130);
            this.method2404(var1 - 1, var2, 8);
            this.method2404(var1, var2 + 1, 32);
         }

         if(1 == var4) {
            this.method2404(var1, var2, 10);
            this.method2404(var1, 1 + var2, 32);
            this.method2404(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2404(var1, var2, 40);
            this.method2404(1 + var1, var2, 128);
            this.method2404(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2404(var1, var2, 160);
            this.method2404(var1, var2 - 1, 2);
            this.method2404(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(0 == var3) {
            if(var4 == 0) {
               this.method2404(var1, var2, 65536);
               this.method2404(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2404(var1, var2, 1024);
               this.method2404(var1, 1 + var2, 16384);
            }

            if(2 == var4) {
               this.method2404(var1, var2, 4096);
               this.method2404(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2404(var1, var2, 16384);
               this.method2404(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || 3 == var3) {
            if(0 == var4) {
               this.method2404(var1, var2, 512);
               this.method2404(var1 - 1, 1 + var2, 8192);
            }

            if(1 == var4) {
               this.method2404(var1, var2, 2048);
               this.method2404(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2404(var1, var2, 8192);
               this.method2404(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2404(var1, var2, '耀');
               this.method2404(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(0 == var4) {
               this.method2404(var1, var2, 66560);
               this.method2404(var1 - 1, var2, 4096);
               this.method2404(var1, var2 + 1, 16384);
            }

            if(1 == var4) {
               this.method2404(var1, var2, 5120);
               this.method2404(var1, 1 + var2, 16384);
               this.method2404(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2404(var1, var2, 20480);
               this.method2404(var1 + 1, var2, 65536);
               this.method2404(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2404(var1, var2, 81920);
               this.method2404(var1, var2 - 1, 1024);
               this.method2404(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "926154484"
   )
   public void method2398(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1884;
      var2 -= this.field1885;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.field1873) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.field1887) {
                  this.method2409(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   public void method2399(int var1, int var2) {
      var1 -= this.field1884;
      var2 -= this.field1885;
      this.field1888[var1][var2] |= 2097152;
   }

   @ObfuscatedName("y")
   public void method2400(int var1, int var2) {
      var1 -= this.field1884;
      var2 -= this.field1885;
      this.field1888[var1][var2] |= 262144;
   }

   @ObfuscatedName("j")
   void method2404(int var1, int var2, int var3) {
      this.field1888[var1][var2] &= ~var3;
   }

   @ObfuscatedName("n")
   public void method2405(int var1, int var2) {
      var1 -= this.field1884;
      var2 -= this.field1885;
      this.field1888[var1][var2] &= -262145;
   }

   @ObfuscatedName("e")
   void method2409(int var1, int var2, int var3) {
      this.field1888[var1][var2] |= var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "376816632"
   )
   public void method2410(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1884;
      var2 -= this.field1885;
      int var8;
      if(var5 == 1 || 3 == var5) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.field1873) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.field1887) {
                  this.method2404(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "241278068"
   )
   public void method2416(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1884;
      var2 -= this.field1885;
      if(var3 == 0) {
         if(0 == var4) {
            this.method2409(var1, var2, 128);
            this.method2409(var1 - 1, var2, 8);
         }

         if(1 == var4) {
            this.method2409(var1, var2, 2);
            this.method2409(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2409(var1, var2, 8);
            this.method2409(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2409(var1, var2, 32);
            this.method2409(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || 3 == var3) {
         if(0 == var4) {
            this.method2409(var1, var2, 1);
            this.method2409(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2409(var1, var2, 4);
            this.method2409(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2409(var1, var2, 16);
            this.method2409(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2409(var1, var2, 64);
            this.method2409(var1 - 1, var2 - 1, 4);
         }
      }

      if(2 == var3) {
         if(0 == var4) {
            this.method2409(var1, var2, 130);
            this.method2409(var1 - 1, var2, 8);
            this.method2409(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2409(var1, var2, 10);
            this.method2409(var1, var2 + 1, 32);
            this.method2409(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2409(var1, var2, 40);
            this.method2409(1 + var1, var2, 128);
            this.method2409(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2409(var1, var2, 160);
            this.method2409(var1, var2 - 1, 2);
            this.method2409(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(0 == var3) {
            if(var4 == 0) {
               this.method2409(var1, var2, 65536);
               this.method2409(var1 - 1, var2, 4096);
            }

            if(1 == var4) {
               this.method2409(var1, var2, 1024);
               this.method2409(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2409(var1, var2, 4096);
               this.method2409(1 + var1, var2, 65536);
            }

            if(3 == var4) {
               this.method2409(var1, var2, 16384);
               this.method2409(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || 3 == var3) {
            if(var4 == 0) {
               this.method2409(var1, var2, 512);
               this.method2409(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2409(var1, var2, 2048);
               this.method2409(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2409(var1, var2, 8192);
               this.method2409(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2409(var1, var2, '耀');
               this.method2409(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(0 == var4) {
               this.method2409(var1, var2, 66560);
               this.method2409(var1 - 1, var2, 4096);
               this.method2409(var1, var2 + 1, 16384);
            }

            if(1 == var4) {
               this.method2409(var1, var2, 5120);
               this.method2409(var1, var2 + 1, 16384);
               this.method2409(1 + var1, var2, 65536);
            }

            if(2 == var4) {
               this.method2409(var1, var2, 20480);
               this.method2409(var1 + 1, var2, 65536);
               this.method2409(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2409(var1, var2, 81920);
               this.method2409(var1, var2 - 1, 1024);
               this.method2409(var1 - 1, var2, 4096);
            }
         }
      }

   }

   public class107(int var1, int var2) {
      this.field1873 = var1;
      this.field1887 = var2;
      this.field1888 = new int[this.field1873][this.field1887];
      this.method2396();
   }
}
