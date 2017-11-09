import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class46 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1263524573
   )
   int field572;
   @ObfuscatedName("p")
   byte[][][] field571;

   class46(int var1) {
      this.field572 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "1"
   )
   void method724(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field572 != 0 && this.field571 != null) {
         var8 = this.method722(var8, var7);
         var7 = this.method723(var7);
         Rasterizer2D.method5170(var1, var2, var5, var6, var3, var4, this.field571[var7 - 1][var8], this.field572);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "815992399"
   )
   int method722(int var1, int var2) {
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
      garbageValue = "-440411525"
   )
   int method723(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method739() {
      if(this.field571 == null) {
         this.field571 = new byte[8][4][];
         this.method725();
         this.method726();
         this.method768();
         this.method746();
         this.method745();
         this.method730();
         this.method731();
         this.method732();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1214960681"
   )
   void method725() {
      byte[] var1 = new byte[this.field572 * this.field572];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[0][0] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[0][1] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[0][2] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[0][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1307901353"
   )
   void method726() {
      byte[] var1 = new byte[this.field572 * this.field572];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[1][0] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
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

      this.field571[1][1] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[1][2] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[1][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1477081013"
   )
   void method768() {
      byte[] var1 = new byte[this.field572 * this.field572];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[2][0] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[2][1] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[2][2] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[2][3] = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "70"
   )
   void method746() {
      byte[] var1 = new byte[this.field572 * this.field572];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[3][0] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[3][1] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[3][2] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[3][3] = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1648777614"
   )
   void method745() {
      byte[] var1 = new byte[this.field572 * this.field572];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[4][0] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[4][1] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[4][2] = var1;
      var1 = new byte[this.field572 * this.field572];
      var2 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field571[4][3] = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "108"
   )
   void method730() {
      byte[] var1 = new byte[this.field572 * this.field572];
      boolean var2 = false;
      var1 = new byte[this.field572 * this.field572];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 <= this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[5][0] = var1;
      var1 = new byte[this.field572 * this.field572];
      var5 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var3 <= this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[5][1] = var1;
      var1 = new byte[this.field572 * this.field572];
      var5 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 >= this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[5][2] = var1;
      var1 = new byte[this.field572 * this.field572];
      var5 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var3 >= this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[5][3] = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   void method731() {
      byte[] var1 = new byte[this.field572 * this.field572];
      boolean var2 = false;
      var1 = new byte[this.field572 * this.field572];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 <= var3 - this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[6][0] = var1;
      var1 = new byte[this.field572 * this.field572];
      var5 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 <= var3 - this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[6][1] = var1;
      var1 = new byte[this.field572 * this.field572];
      var5 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[6][2] = var1;
      var1 = new byte[this.field572 * this.field572];
      var5 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[6][3] = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "93"
   )
   void method732() {
      byte[] var1 = new byte[this.field572 * this.field572];
      boolean var2 = false;
      var1 = new byte[this.field572 * this.field572];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 >= var3 - this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[7][0] = var1;
      var1 = new byte[this.field572 * this.field572];
      var5 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field572; ++var4) {
            if(var4 >= var3 - this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[7][1] = var1;
      var1 = new byte[this.field572 * this.field572];
      var5 = 0;

      for(var3 = this.field572 - 1; var3 >= 0; --var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[7][2] = var1;
      var1 = new byte[this.field572 * this.field572];
      var5 = 0;

      for(var3 = 0; var3 < this.field572; ++var3) {
         for(var4 = this.field572 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field572 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field571[7][3] = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "473824677"
   )
   public static void method758() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field619 = KeyFocusListener.field621;
         KeyFocusListener.field605 = 0;
         int var1;
         if(KeyFocusListener.field611 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.field618[var1] = false;
            }

            KeyFocusListener.field611 = KeyFocusListener.field617;
         } else {
            while(KeyFocusListener.field617 != KeyFocusListener.field611) {
               var1 = KeyFocusListener.field612[KeyFocusListener.field617];
               KeyFocusListener.field617 = KeyFocusListener.field617 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.field618[~var1] = false;
               } else {
                  if(!KeyFocusListener.field618[var1] && KeyFocusListener.field605 < KeyFocusListener.field614.length - 1) {
                     KeyFocusListener.field614[++KeyFocusListener.field605 - 1] = var1;
                  }

                  KeyFocusListener.field618[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field605 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field621 = KeyFocusListener.field615;
      }
   }
}
