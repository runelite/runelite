import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("CollisionData")
public class class108 {
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -679278799
   )
   int field1866;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -746817761
   )
   int field1876 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1414670439
   )
   int field1878;
   @ObfuscatedName("av")
   @Export("flags")
   public int[][] field1879;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 725060105
   )
   int field1880 = 0;
   @ObfuscatedName("ej")
   static class78[] field1881;
   @ObfuscatedName("ny")
   static class74 field1886;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2093004013"
   )
   public void method2378() {
      for(int var1 = 0; var1 < this.field1866; ++var1) {
         for(int var2 = 0; var2 < this.field1878; ++var2) {
            if(var1 != 0 && 0 != var2 && var1 < this.field1866 - 5 && var2 < this.field1878 - 5) {
               this.field1879[var1][var2] = 16777216;
            } else {
               this.field1879[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "690734818"
   )
   public void method2379(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1880;
      var2 -= this.field1876;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.field1866) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.field1878) {
                  this.method2405(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1000517717"
   )
   public void method2381(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1880;
      var2 -= this.field1876;
      if(var3 == 0) {
         if(0 == var4) {
            this.method2386(var1, var2, 128);
            this.method2386(var1 - 1, var2, 8);
         }

         if(1 == var4) {
            this.method2386(var1, var2, 2);
            this.method2386(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2386(var1, var2, 8);
            this.method2386(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2386(var1, var2, 32);
            this.method2386(var1, var2 - 1, 2);
         }
      }

      if(1 == var3 || var3 == 3) {
         if(var4 == 0) {
            this.method2386(var1, var2, 1);
            this.method2386(var1 - 1, var2 + 1, 16);
         }

         if(1 == var4) {
            this.method2386(var1, var2, 4);
            this.method2386(1 + var1, 1 + var2, 64);
         }

         if(2 == var4) {
            this.method2386(var1, var2, 16);
            this.method2386(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2386(var1, var2, 64);
            this.method2386(var1 - 1, var2 - 1, 4);
         }
      }

      if(2 == var3) {
         if(0 == var4) {
            this.method2386(var1, var2, 130);
            this.method2386(var1 - 1, var2, 8);
            this.method2386(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2386(var1, var2, 10);
            this.method2386(var1, 1 + var2, 32);
            this.method2386(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2386(var1, var2, 40);
            this.method2386(1 + var1, var2, 128);
            this.method2386(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2386(var1, var2, 160);
            this.method2386(var1, var2 - 1, 2);
            this.method2386(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(0 == var3) {
            if(var4 == 0) {
               this.method2386(var1, var2, 65536);
               this.method2386(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2386(var1, var2, 1024);
               this.method2386(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2386(var1, var2, 4096);
               this.method2386(var1 + 1, var2, 65536);
            }

            if(3 == var4) {
               this.method2386(var1, var2, 16384);
               this.method2386(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || 3 == var3) {
            if(var4 == 0) {
               this.method2386(var1, var2, 512);
               this.method2386(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2386(var1, var2, 2048);
               this.method2386(1 + var1, var2 + 1, '耀');
            }

            if(2 == var4) {
               this.method2386(var1, var2, 8192);
               this.method2386(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2386(var1, var2, '耀');
               this.method2386(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(0 == var4) {
               this.method2386(var1, var2, 66560);
               this.method2386(var1 - 1, var2, 4096);
               this.method2386(var1, 1 + var2, 16384);
            }

            if(1 == var4) {
               this.method2386(var1, var2, 5120);
               this.method2386(var1, 1 + var2, 16384);
               this.method2386(1 + var1, var2, 65536);
            }

            if(2 == var4) {
               this.method2386(var1, var2, 20480);
               this.method2386(var1 + 1, var2, 65536);
               this.method2386(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2386(var1, var2, 81920);
               this.method2386(var1, var2 - 1, 1024);
               this.method2386(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "158023657"
   )
   public void method2382(int var1, int var2) {
      var1 -= this.field1880;
      var2 -= this.field1876;
      this.field1879[var1][var2] |= 262144;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1294021676"
   )
   public void method2383(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1880;
      var2 -= this.field1876;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2405(var1, var2, 128);
            this.method2405(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2405(var1, var2, 2);
            this.method2405(var1, var2 + 1, 32);
         }

         if(2 == var4) {
            this.method2405(var1, var2, 8);
            this.method2405(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2405(var1, var2, 32);
            this.method2405(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || 3 == var3) {
         if(0 == var4) {
            this.method2405(var1, var2, 1);
            this.method2405(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2405(var1, var2, 4);
            this.method2405(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2405(var1, var2, 16);
            this.method2405(var1 + 1, var2 - 1, 1);
         }

         if(3 == var4) {
            this.method2405(var1, var2, 64);
            this.method2405(var1 - 1, var2 - 1, 4);
         }
      }

      if(2 == var3) {
         if(0 == var4) {
            this.method2405(var1, var2, 130);
            this.method2405(var1 - 1, var2, 8);
            this.method2405(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2405(var1, var2, 10);
            this.method2405(var1, 1 + var2, 32);
            this.method2405(var1 + 1, var2, 128);
         }

         if(2 == var4) {
            this.method2405(var1, var2, 40);
            this.method2405(var1 + 1, var2, 128);
            this.method2405(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2405(var1, var2, 160);
            this.method2405(var1, var2 - 1, 2);
            this.method2405(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2405(var1, var2, 65536);
               this.method2405(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2405(var1, var2, 1024);
               this.method2405(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2405(var1, var2, 4096);
               this.method2405(var1 + 1, var2, 65536);
            }

            if(3 == var4) {
               this.method2405(var1, var2, 16384);
               this.method2405(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(0 == var4) {
               this.method2405(var1, var2, 512);
               this.method2405(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2405(var1, var2, 2048);
               this.method2405(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2405(var1, var2, 8192);
               this.method2405(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2405(var1, var2, '耀');
               this.method2405(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2405(var1, var2, 66560);
               this.method2405(var1 - 1, var2, 4096);
               this.method2405(var1, var2 + 1, 16384);
            }

            if(1 == var4) {
               this.method2405(var1, var2, 5120);
               this.method2405(var1, 1 + var2, 16384);
               this.method2405(1 + var1, var2, 65536);
            }

            if(2 == var4) {
               this.method2405(var1, var2, 20480);
               this.method2405(var1 + 1, var2, 65536);
               this.method2405(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2405(var1, var2, 81920);
               this.method2405(var1, var2 - 1, 1024);
               this.method2405(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "2053155086"
   )
   public void method2385(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1880;
      var2 -= this.field1876;
      int var8;
      if(1 == var5 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var1 + var3; ++var8) {
         if(var8 >= 0 && var8 < this.field1866) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.field1878) {
                  this.method2386(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-451487977"
   )
   void method2386(int var1, int var2, int var3) {
      this.field1879[var1][var2] &= ~var3;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2092620999"
   )
   public void method2387(int var1, int var2) {
      var1 -= this.field1880;
      var2 -= this.field1876;
      this.field1879[var1][var2] &= -262145;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1265891683"
   )
   public static int method2399(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class45.method947(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1649929377"
   )
   void method2405(int var1, int var2, int var3) {
      this.field1879[var1][var2] |= var3;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public class108(int var1, int var2) {
      this.field1866 = var1;
      this.field1878 = var2;
      this.field1879 = new int[this.field1866][this.field1878];
      this.method2378();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1477290552"
   )
   public void method2407(int var1, int var2) {
      var1 -= this.field1880;
      var2 -= this.field1876;
      this.field1879[var1][var2] |= 2097152;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "241912"
   )
   static final void method2414(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class107.method2374(var0)) {
         class74.method1595(class173.field2735[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
