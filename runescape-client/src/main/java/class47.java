import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class47 {
   @ObfuscatedName("od")
   static boolean field588;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1767763447
   )
   int field590;
   @ObfuscatedName("z")
   byte[][][] field587;

   class47(int var1) {
      this.field590 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1592203409"
   )
   void method667(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field590 != 0 && this.field587 != null) {
         var8 = this.method669(var8, var7);
         var7 = this.method670(var7);
         Rasterizer2D.method5811(var1, var2, var5, var6, var3, var4, this.field587[var7 - 1][var8], this.field590);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   int method669(int var1, int var2) {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "952731092"
   )
   int method670(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   void method671() {
      if(this.field587 == null) {
         this.field587 = new byte[8][4][];
         this.method684();
         this.method673();
         this.method674();
         this.method675();
         this.method704();
         this.method680();
         this.method668();
         this.method679();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1806653807"
   )
   void method684() {
      byte[] var1 = new byte[this.field590 * this.field590];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[0][0] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[0][1] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[0][2] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[0][3] = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1655572446"
   )
   void method673() {
      byte[] var1 = new byte[this.field590 * this.field590];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[1][0] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
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

      this.field587[1][1] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[1][2] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[1][3] = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1491760827"
   )
   void method674() {
      byte[] var1 = new byte[this.field590 * this.field590];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[2][0] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[2][1] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[2][2] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[2][3] = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   void method675() {
      byte[] var1 = new byte[this.field590 * this.field590];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[3][0] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[3][1] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[3][2] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[3][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "81"
   )
   void method704() {
      byte[] var1 = new byte[this.field590 * this.field590];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[4][0] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[4][1] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[4][2] = var1;
      var1 = new byte[this.field590 * this.field590];
      var2 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[4][3] = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "413"
   )
   void method680() {
      byte[] var1 = new byte[this.field590 * this.field590];
      boolean var2 = false;
      var1 = new byte[this.field590 * this.field590];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 <= this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[5][0] = var1;
      var1 = new byte[this.field590 * this.field590];
      var5 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var3 <= this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[5][1] = var1;
      var1 = new byte[this.field590 * this.field590];
      var5 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 >= this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[5][2] = var1;
      var1 = new byte[this.field590 * this.field590];
      var5 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var3 >= this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[5][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-9872"
   )
   void method668() {
      byte[] var1 = new byte[this.field590 * this.field590];
      boolean var2 = false;
      var1 = new byte[this.field590 * this.field590];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 <= var3 - this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[6][0] = var1;
      var1 = new byte[this.field590 * this.field590];
      var5 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 <= var3 - this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[6][1] = var1;
      var1 = new byte[this.field590 * this.field590];
      var5 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[6][2] = var1;
      var1 = new byte[this.field590 * this.field590];
      var5 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[6][3] = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1671844850"
   )
   void method679() {
      byte[] var1 = new byte[this.field590 * this.field590];
      boolean var2 = false;
      var1 = new byte[this.field590 * this.field590];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 >= var3 - this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[7][0] = var1;
      var1 = new byte[this.field590 * this.field590];
      var5 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field590; ++var4) {
            if(var4 >= var3 - this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[7][1] = var1;
      var1 = new byte[this.field590 * this.field590];
      var5 = 0;

      for(var3 = this.field590 - 1; var3 >= 0; --var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[7][2] = var1;
      var1 = new byte[this.field590 * this.field590];
      var5 = 0;

      for(var3 = 0; var3 < this.field590; ++var3) {
         for(var4 = this.field590 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field590 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[7][3] = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lhd;III)I",
      garbageValue = "-1734374718"
   )
   static int method699(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }
}
