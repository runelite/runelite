import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class46 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 749932241
   )
   int field623;
   @ObfuscatedName("w")
   byte[][][] field624;
   @ObfuscatedName("z")
   static class158 field625;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1499830683
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("r")
   @Export("widgets")
   public static Widget[][] widgets;

   class46(int var1) {
      this.field623 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-93"
   )
   void method685(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field623 != 0 && this.field624 != null) {
         var8 = this.method702(var8, var7);
         var7 = this.method687(var7);
         Rasterizer2D.method4938(var1, var2, var5, var6, var3, var4, this.field624[var7 - 1][var8], this.field623);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1238539459"
   )
   int method687(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "992679975"
   )
   void method688() {
      byte[] var1 = new byte[this.field623 * this.field623];
      boolean var2 = false;
      var1 = new byte[this.field623 * this.field623];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 >= var3 - this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[7][0] = var1;
      var1 = new byte[this.field623 * this.field623];
      var5 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 >= var3 - this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[7][1] = var1;
      var1 = new byte[this.field623 * this.field623];
      var5 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[7][2] = var1;
      var1 = new byte[this.field623 * this.field623];
      var5 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[7][3] = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1329531016"
   )
   void method689() {
      byte[] var1 = new byte[this.field623 * this.field623];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[0][0] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[0][1] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[0][2] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[0][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1479783220"
   )
   void method690() {
      byte[] var1 = new byte[this.field623 * this.field623];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[1][0] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field624[1][1] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[1][2] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[1][3] = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1862397672"
   )
   void method691() {
      byte[] var1 = new byte[this.field623 * this.field623];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[2][0] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[2][1] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[2][2] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[2][3] = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1943342623"
   )
   void method692() {
      byte[] var1 = new byte[this.field623 * this.field623];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[3][0] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[3][1] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[3][2] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[3][3] = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-61"
   )
   void method693() {
      byte[] var1 = new byte[this.field623 * this.field623];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[4][0] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[4][1] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[4][2] = var1;
      var1 = new byte[this.field623 * this.field623];
      var2 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field624[4][3] = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-402779282"
   )
   void method694() {
      byte[] var1 = new byte[this.field623 * this.field623];
      boolean var2 = false;
      var1 = new byte[this.field623 * this.field623];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 <= this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[5][0] = var1;
      var1 = new byte[this.field623 * this.field623];
      var5 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var3 <= this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[5][1] = var1;
      var1 = new byte[this.field623 * this.field623];
      var5 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 >= this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[5][2] = var1;
      var1 = new byte[this.field623 * this.field623];
      var5 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var3 >= this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[5][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "124"
   )
   void method695() {
      byte[] var1 = new byte[this.field623 * this.field623];
      boolean var2 = false;
      var1 = new byte[this.field623 * this.field623];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 <= var3 - this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[6][0] = var1;
      var1 = new byte[this.field623 * this.field623];
      var5 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field623; ++var4) {
            if(var4 <= var3 - this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[6][1] = var1;
      var1 = new byte[this.field623 * this.field623];
      var5 = 0;

      for(var3 = this.field623 - 1; var3 >= 0; --var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[6][2] = var1;
      var1 = new byte[this.field623 * this.field623];
      var5 = 0;

      for(var3 = 0; var3 < this.field623; ++var3) {
         for(var4 = this.field623 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field623 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field624[6][3] = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1944026612"
   )
   int method702(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2055905543"
   )
   void method710() {
      if(this.field624 == null) {
         this.field624 = new byte[8][4][];
         this.method689();
         this.method690();
         this.method691();
         this.method692();
         this.method693();
         this.method694();
         this.method695();
         this.method688();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-242850862"
   )
   public static int method712(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
