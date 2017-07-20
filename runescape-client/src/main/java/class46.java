import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class46 {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -2047036087
   )
   static int field595;
   @ObfuscatedName("o")
   byte[][][] field591;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 635381113
   )
   int field597;

   class46(int var1) {
      this.field597 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "764998520"
   )
   void method632() {
      byte[] var1 = new byte[this.field597 * this.field597];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[0][0] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[0][1] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[0][2] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[0][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1964771557"
   )
   int method636(int var1, int var2) {
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "85"
   )
   void method633() {
      byte[] var1 = new byte[this.field597 * this.field597];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[1][0] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
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

      this.field591[1][1] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[1][2] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[1][3] = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   int method647(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "146408821"
   )
   void method634() {
      byte[] var1 = new byte[this.field597 * this.field597];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[2][0] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[2][1] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[2][2] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[2][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1519388344"
   )
   void method658() {
      byte[] var1 = new byte[this.field597 * this.field597];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[3][0] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[3][1] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[3][2] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[3][3] = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1910216258"
   )
   void method631() {
      byte[] var1 = new byte[this.field597 * this.field597];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[4][0] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[4][1] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[4][2] = var1;
      var1 = new byte[this.field597 * this.field597];
      var2 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field591[4][3] = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1970785983"
   )
   void method637() {
      byte[] var1 = new byte[this.field597 * this.field597];
      boolean var2 = false;
      var1 = new byte[this.field597 * this.field597];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 <= this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[5][0] = var1;
      var1 = new byte[this.field597 * this.field597];
      var5 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var3 <= this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[5][1] = var1;
      var1 = new byte[this.field597 * this.field597];
      var5 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 >= this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[5][2] = var1;
      var1 = new byte[this.field597 * this.field597];
      var5 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var3 >= this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[5][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-781125396"
   )
   void method638() {
      byte[] var1 = new byte[this.field597 * this.field597];
      boolean var2 = false;
      var1 = new byte[this.field597 * this.field597];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 <= var3 - this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[6][0] = var1;
      var1 = new byte[this.field597 * this.field597];
      var5 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 <= var3 - this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[6][1] = var1;
      var1 = new byte[this.field597 * this.field597];
      var5 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[6][2] = var1;
      var1 = new byte[this.field597 * this.field597];
      var5 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[6][3] = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-860728371"
   )
   void method628(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field597 != 0 && this.field591 != null) {
         var8 = this.method636(var8, var7);
         var7 = this.method647(var7);
         Rasterizer2D.method4834(var1, var2, var5, var6, var3, var4, this.field591[var7 - 1][var8], this.field597);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   void method639() {
      byte[] var1 = new byte[this.field597 * this.field597];
      boolean var2 = false;
      var1 = new byte[this.field597 * this.field597];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 >= var3 - this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[7][0] = var1;
      var1 = new byte[this.field597 * this.field597];
      var5 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field597; ++var4) {
            if(var4 >= var3 - this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[7][1] = var1;
      var1 = new byte[this.field597 * this.field597];
      var5 = 0;

      for(var3 = this.field597 - 1; var3 >= 0; --var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[7][2] = var1;
      var1 = new byte[this.field597 * this.field597];
      var5 = 0;

      for(var3 = 0; var3 < this.field597; ++var3) {
         for(var4 = this.field597 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field597 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field591[7][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "63"
   )
   void method648() {
      if(this.field591 == null) {
         this.field591 = new byte[8][4][];
         this.method632();
         this.method633();
         this.method634();
         this.method658();
         this.method631();
         this.method637();
         this.method638();
         this.method639();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1668941161"
   )
   static void method668(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      FileRequest var4 = (FileRequest)class238.field3227.get(var2);
      if(var4 != null) {
         class238.field3232.setHead(var4);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfp;Lgk;B)Lgk;",
      garbageValue = "0"
   )
   static final class186 method629(Buffer var0, class186 var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class43.method593(var2);
         var1 = new class186(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new class185(var0.readString());
         } else {
            var6 = new WidgetConfig(var0.readInt());
         }

         var1.method3440((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lir;",
      garbageValue = "-1942391666"
   )
   static class239[] method669() {
      return new class239[]{class239.field3244, class239.field3245, class239.field3246};
   }
}
