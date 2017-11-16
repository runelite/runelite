import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class46 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 575718167
   )
   int field549;
   @ObfuscatedName("s")
   byte[][][] field550;

   class46(int var1) {
      this.field549 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1736060762"
   )
   void method625(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field549 != 0 && this.field550 != null) {
         var8 = this.method626(var8, var7);
         var7 = this.method627(var7);
         Rasterizer2D.method4987(var1, var2, var5, var6, var3, var4, this.field550[var7 - 1][var8], this.field549);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1688567461"
   )
   int method626(int var1, int var2) {
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   int method627(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1367213028"
   )
   void method641() {
      if(this.field550 == null) {
         this.field550 = new byte[8][4][];
         this.method649();
         this.method629();
         this.method639();
         this.method638();
         this.method632();
         this.method636();
         this.method634();
         this.method630();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1993857032"
   )
   void method649() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[0][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[0][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[0][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[0][3] = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2120028930"
   )
   void method629() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[1][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
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

      this.field550[1][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[1][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[1][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "624554887"
   )
   void method639() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[2][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[2][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[2][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[2][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-839985083"
   )
   void method638() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[3][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[3][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[3][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[3][3] = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "446702485"
   )
   void method632() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[4][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[4][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[4][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field550[4][3] = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "871285617"
   )
   void method636() {
      byte[] var1 = new byte[this.field549 * this.field549];
      boolean var2 = false;
      var1 = new byte[this.field549 * this.field549];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[5][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var3 <= this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[5][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[5][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var3 >= this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[5][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-80"
   )
   void method634() {
      byte[] var1 = new byte[this.field549 * this.field549];
      boolean var2 = false;
      var1 = new byte[this.field549 * this.field549];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[6][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[6][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[6][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[6][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-655393588"
   )
   void method630() {
      byte[] var1 = new byte[this.field549 * this.field549];
      boolean var2 = false;
      var1 = new byte[this.field549 * this.field549];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[7][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[7][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[7][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field550[7][3] = var1;
   }
}
