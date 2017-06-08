import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class46 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1103565739
   )
   int field588;
   @ObfuscatedName("p")
   byte[][][] field589;
   @ObfuscatedName("aj")
   static Client field590;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-82"
   )
   int method649(int var1, int var2) {
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "98844364"
   )
   int method650(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "223938359"
   )
   void method651() {
      if(this.field589 == null) {
         this.field589 = new byte[8][4][];
         this.method670();
         this.method652();
         this.method679();
         this.method655();
         this.method656();
         this.method657();
         this.method658();
         this.method659();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "100"
   )
   void method652() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[1][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
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

      this.field589[1][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[1][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[1][3] = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1533317692"
   )
   void method655() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[3][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[3][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[3][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[3][3] = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1275698842"
   )
   void method656() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[4][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[4][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[4][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[4][3] = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   void method657() {
      byte[] var1 = new byte[this.field588 * this.field588];
      boolean var2 = false;
      var1 = new byte[this.field588 * this.field588];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[5][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var3 <= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[5][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[5][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var3 >= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[5][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "359470056"
   )
   void method658() {
      byte[] var1 = new byte[this.field588 * this.field588];
      boolean var2 = false;
      var1 = new byte[this.field588 * this.field588];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[6][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[6][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[6][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[6][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1820934180"
   )
   void method659() {
      byte[] var1 = new byte[this.field588 * this.field588];
      boolean var2 = false;
      var1 = new byte[this.field588 * this.field588];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[7][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[7][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[7][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field589[7][3] = var1;
   }

   class46(int var1) {
      this.field588 = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-936419558"
   )
   static final int method664(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "27"
   )
   void method670() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[0][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[0][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[0][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[0][3] = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1157184973"
   )
   void method671(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field588 != 0 && this.field589 != null) {
         var8 = this.method649(var8, var7);
         var7 = this.method650(var7);
         Rasterizer2D.method5017(var1, var2, var5, var6, var3, var4, this.field589[var7 - 1][var8], this.field588);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-101"
   )
   void method679() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[2][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[2][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[2][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field589[2][3] = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "-1767552196"
   )
   static final void method685(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var2 + var9 < 103 && var10 + var3 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var2 + var9][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  World.method1563(var13, var1, var2 + class165.method3078(var11 & 7, var12 & 7, var7), var3 + MessageNode.method1086(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  World.method1563(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }
}
