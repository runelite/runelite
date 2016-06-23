import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("CollisionData")
public class class108 {
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 645366873
   )
   @Export("width")
   int field1891;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -2112553497
   )
   @Export("x")
   int field1904 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 194666823
   )
   @Export("y")
   int field1905 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -384807593
   )
   @Export("height")
   int field1907;
   @ObfuscatedName("ai")
   @Export("flags")
   public int[][] field1908;
   @ObfuscatedName("ba")
   static class168 field1909;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public class108(int var1, int var2) {
      this.field1891 = var1;
      this.field1907 = var2;
      this.field1908 = new int[this.field1891][this.field1907];
      this.method2432();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-997920669"
   )
   public void method2432() {
      for(int var1 = 0; var1 < this.field1891; ++var1) {
         for(int var2 = 0; var2 < this.field1907; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.field1891 - 5 && var2 < this.field1907 - 5) {
               this.field1908[var1][var2] = 16777216;
            } else {
               this.field1908[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-13"
   )
   public void method2433(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1904;
      var2 -= this.field1905;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2460(var1, var2, 128);
            this.method2460(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2460(var1, var2, 2);
            this.method2460(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2460(var1, var2, 8);
            this.method2460(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2460(var1, var2, 32);
            this.method2460(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2460(var1, var2, 1);
            this.method2460(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2460(var1, var2, 4);
            this.method2460(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2460(var1, var2, 16);
            this.method2460(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2460(var1, var2, 64);
            this.method2460(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2460(var1, var2, 130);
            this.method2460(var1 - 1, var2, 8);
            this.method2460(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2460(var1, var2, 10);
            this.method2460(var1, 1 + var2, 32);
            this.method2460(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2460(var1, var2, 40);
            this.method2460(1 + var1, var2, 128);
            this.method2460(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2460(var1, var2, 160);
            this.method2460(var1, var2 - 1, 2);
            this.method2460(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2460(var1, var2, 65536);
               this.method2460(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2460(var1, var2, 1024);
               this.method2460(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2460(var1, var2, 4096);
               this.method2460(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2460(var1, var2, 16384);
               this.method2460(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2460(var1, var2, 512);
               this.method2460(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2460(var1, var2, 2048);
               this.method2460(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2460(var1, var2, 8192);
               this.method2460(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2460(var1, var2, '耀');
               this.method2460(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2460(var1, var2, 66560);
               this.method2460(var1 - 1, var2, 4096);
               this.method2460(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2460(var1, var2, 5120);
               this.method2460(var1, 1 + var2, 16384);
               this.method2460(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2460(var1, var2, 20480);
               this.method2460(1 + var1, var2, 65536);
               this.method2460(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2460(var1, var2, 81920);
               this.method2460(var1, var2 - 1, 1024);
               this.method2460(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-377226854"
   )
   public void method2434(int var1, int var2) {
      var1 -= this.field1904;
      var2 -= this.field1905;
      this.field1908[var1][var2] |= 262144;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-692835510"
   )
   public void method2437(int var1, int var2) {
      var1 -= this.field1904;
      var2 -= this.field1905;
      this.field1908[var1][var2] |= 2097152;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1844794899"
   )
   void method2440(int var1, int var2, int var3) {
      this.field1908[var1][var2] &= ~var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1491532455"
   )
   public void method2441(int var1, int var2) {
      var1 -= this.field1904;
      var2 -= this.field1905;
      this.field1908[var1][var2] &= -262145;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "0"
   )
   public void method2448(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1904;
      var2 -= this.field1905;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2440(var1, var2, 128);
            this.method2440(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2440(var1, var2, 2);
            this.method2440(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2440(var1, var2, 8);
            this.method2440(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2440(var1, var2, 32);
            this.method2440(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2440(var1, var2, 1);
            this.method2440(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2440(var1, var2, 4);
            this.method2440(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2440(var1, var2, 16);
            this.method2440(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2440(var1, var2, 64);
            this.method2440(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2440(var1, var2, 130);
            this.method2440(var1 - 1, var2, 8);
            this.method2440(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2440(var1, var2, 10);
            this.method2440(var1, var2 + 1, 32);
            this.method2440(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2440(var1, var2, 40);
            this.method2440(var1 + 1, var2, 128);
            this.method2440(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2440(var1, var2, 160);
            this.method2440(var1, var2 - 1, 2);
            this.method2440(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2440(var1, var2, 65536);
               this.method2440(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2440(var1, var2, 1024);
               this.method2440(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2440(var1, var2, 4096);
               this.method2440(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2440(var1, var2, 16384);
               this.method2440(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2440(var1, var2, 512);
               this.method2440(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2440(var1, var2, 2048);
               this.method2440(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2440(var1, var2, 8192);
               this.method2440(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2440(var1, var2, '耀');
               this.method2440(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2440(var1, var2, 66560);
               this.method2440(var1 - 1, var2, 4096);
               this.method2440(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2440(var1, var2, 5120);
               this.method2440(var1, var2 + 1, 16384);
               this.method2440(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2440(var1, var2, 20480);
               this.method2440(1 + var1, var2, 65536);
               this.method2440(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2440(var1, var2, 81920);
               this.method2440(var1, var2 - 1, 1024);
               this.method2440(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "196060102"
   )
   public void method2457(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1904;
      var2 -= this.field1905;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.field1891) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.field1907) {
                  this.method2440(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "22137"
   )
   void method2460(int var1, int var2, int var3) {
      this.field1908[var1][var2] |= var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "73"
   )
   public void method2462(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1904;
      var2 -= this.field1905;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.field1891) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.field1907) {
                  this.method2460(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIII)V",
      garbageValue = "758010221"
   )
   static final void method2468(class173 var0, int var1, int var2, int var3) {
      class175 var4 = var0.method3454(false);
      if(var4 != null) {
         if(client.field523 < 3) {
            class9.field165.method1774(var1, var2, var4.field2900, var4.field2901, 25, 25, client.field374, 256, var4.field2898, var4.field2899);
         } else {
            class79.method1867(var1, var2, 0, var4.field2898, var4.field2899);
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-107932613"
   )
   public static boolean method2469(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
