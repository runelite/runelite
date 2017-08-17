import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class46 {
   @ObfuscatedName("rp")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("h")
   byte[][][] field598;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 623757103
   )
   int field600;

   class46(int var1) {
      this.field600 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1854152195"
   )
   void method696() {
      byte[] var1 = new byte[this.field600 * this.field600];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[0][0] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[0][1] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[0][2] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[0][3] = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-69"
   )
   int method693(int var1, int var2) {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1229576495"
   )
   void method697() {
      byte[] var1 = new byte[this.field600 * this.field600];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[1][0] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
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

      this.field598[1][1] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[1][2] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[1][3] = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "4"
   )
   int method694(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void method698() {
      byte[] var1 = new byte[this.field600 * this.field600];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[2][0] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[2][1] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[2][2] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[2][3] = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1655840047"
   )
   void method699() {
      byte[] var1 = new byte[this.field600 * this.field600];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[3][0] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[3][1] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[3][2] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[3][3] = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void method700() {
      byte[] var1 = new byte[this.field600 * this.field600];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[4][0] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[4][1] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[4][2] = var1;
      var1 = new byte[this.field600 * this.field600];
      var2 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field598[4][3] = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   void method701() {
      byte[] var1 = new byte[this.field600 * this.field600];
      boolean var2 = false;
      var1 = new byte[this.field600 * this.field600];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 <= this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[5][0] = var1;
      var1 = new byte[this.field600 * this.field600];
      var5 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var3 <= this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[5][1] = var1;
      var1 = new byte[this.field600 * this.field600];
      var5 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 >= this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[5][2] = var1;
      var1 = new byte[this.field600 * this.field600];
      var5 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var3 >= this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[5][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-451537769"
   )
   void method715() {
      byte[] var1 = new byte[this.field600 * this.field600];
      boolean var2 = false;
      var1 = new byte[this.field600 * this.field600];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 <= var3 - this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[6][0] = var1;
      var1 = new byte[this.field600 * this.field600];
      var5 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 <= var3 - this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[6][1] = var1;
      var1 = new byte[this.field600 * this.field600];
      var5 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[6][2] = var1;
      var1 = new byte[this.field600 * this.field600];
      var5 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[6][3] = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1558088095"
   )
   void method692(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field600 != 0 && this.field598 != null) {
         var8 = this.method693(var8, var7);
         var7 = this.method694(var7);
         Rasterizer2D.method4974(var1, var2, var5, var6, var3, var4, this.field598[var7 - 1][var8], this.field600);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1937779087"
   )
   void method734() {
      byte[] var1 = new byte[this.field600 * this.field600];
      boolean var2 = false;
      var1 = new byte[this.field600 * this.field600];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 >= var3 - this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[7][0] = var1;
      var1 = new byte[this.field600 * this.field600];
      var5 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field600; ++var4) {
            if(var4 >= var3 - this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[7][1] = var1;
      var1 = new byte[this.field600 * this.field600];
      var5 = 0;

      for(var3 = this.field600 - 1; var3 >= 0; --var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[7][2] = var1;
      var1 = new byte[this.field600 * this.field600];
      var5 = 0;

      for(var3 = 0; var3 < this.field600; ++var3) {
         for(var4 = this.field600 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field600 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field598[7][3] = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "566857091"
   )
   void method706() {
      if(this.field598 == null) {
         this.field598 = new byte[8][4][];
         this.method696();
         this.method697();
         this.method698();
         this.method699();
         this.method700();
         this.method701();
         this.method715();
         this.method734();
      }
   }
}
