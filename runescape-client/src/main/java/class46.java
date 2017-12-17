import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class46 {
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -1917457925
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1605037371
   )
   static int field558;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1660306989
   )
   static int field557;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -235353067
   )
   int field554;
   @ObfuscatedName("w")
   byte[][][] field553;

   class46(int var1) {
      this.field554 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-308830065"
   )
   void method660(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field554 != 0 && this.field553 != null) {
         var8 = this.method661(var8, var7);
         var7 = this.method693(var7);
         Rasterizer2D.method5095(var1, var2, var5, var6, var3, var4, this.field553[var7 - 1][var8], this.field554);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-259281741"
   )
   int method661(int var1, int var2) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1400735357"
   )
   int method693(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1478321731"
   )
   void method663() {
      if(this.field553 == null) {
         this.field553 = new byte[8][4][];
         this.method682();
         this.method665();
         this.method692();
         this.method667();
         this.method668();
         this.method669();
         this.method666();
         this.method664();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void method682() {
      byte[] var1 = new byte[this.field554 * this.field554];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[0][0] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[0][1] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[0][2] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[0][3] = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1501824224"
   )
   void method665() {
      byte[] var1 = new byte[this.field554 * this.field554];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[1][0] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
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

      this.field553[1][1] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[1][2] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[1][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-264370382"
   )
   void method692() {
      byte[] var1 = new byte[this.field554 * this.field554];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[2][0] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[2][1] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[2][2] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[2][3] = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   void method667() {
      byte[] var1 = new byte[this.field554 * this.field554];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[3][0] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[3][1] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[3][2] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[3][3] = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "82"
   )
   void method668() {
      byte[] var1 = new byte[this.field554 * this.field554];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[4][0] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[4][1] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[4][2] = var1;
      var1 = new byte[this.field554 * this.field554];
      var2 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field553[4][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1402157530"
   )
   void method669() {
      byte[] var1 = new byte[this.field554 * this.field554];
      boolean var2 = false;
      var1 = new byte[this.field554 * this.field554];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 <= this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[5][0] = var1;
      var1 = new byte[this.field554 * this.field554];
      var5 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var3 <= this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[5][1] = var1;
      var1 = new byte[this.field554 * this.field554];
      var5 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 >= this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[5][2] = var1;
      var1 = new byte[this.field554 * this.field554];
      var5 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var3 >= this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[5][3] = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-106"
   )
   void method666() {
      byte[] var1 = new byte[this.field554 * this.field554];
      boolean var2 = false;
      var1 = new byte[this.field554 * this.field554];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 <= var3 - this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[6][0] = var1;
      var1 = new byte[this.field554 * this.field554];
      var5 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 <= var3 - this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[6][1] = var1;
      var1 = new byte[this.field554 * this.field554];
      var5 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[6][2] = var1;
      var1 = new byte[this.field554 * this.field554];
      var5 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[6][3] = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "885091633"
   )
   void method664() {
      byte[] var1 = new byte[this.field554 * this.field554];
      boolean var2 = false;
      var1 = new byte[this.field554 * this.field554];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 >= var3 - this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[7][0] = var1;
      var1 = new byte[this.field554 * this.field554];
      var5 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field554; ++var4) {
            if(var4 >= var3 - this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[7][1] = var1;
      var1 = new byte[this.field554 * this.field554];
      var5 = 0;

      for(var3 = this.field554 - 1; var3 >= 0; --var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[7][2] = var1;
      var1 = new byte[this.field554 * this.field554];
      var5 = 0;

      for(var3 = 0; var3 < this.field554; ++var3) {
         for(var4 = this.field554 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field554 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field553[7][3] = var1;
   }
}
