import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class47 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1920637669
   )
   int field564;
   @ObfuscatedName("q")
   byte[][][] field567;

   class47(int var1) {
      this.field564 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "3"
   )
   void method750(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field564 != 0 && this.field567 != null) {
         var8 = this.method720(var8, var7);
         var7 = this.method721(var7);
         Rasterizer2D.method5715(var1, var2, var5, var6, var3, var4, this.field567[var7 - 1][var8], this.field564);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "584568329"
   )
   int method720(int var1, int var2) {
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
      garbageValue = "1035686147"
   )
   int method721(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1164052647"
   )
   void method722() {
      if(this.field567 == null) {
         this.field567 = new byte[8][4][];
         this.method718();
         this.method724();
         this.method725();
         this.method736();
         this.method727();
         this.method742();
         this.method729();
         this.method741();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "171085030"
   )
   void method718() {
      byte[] var1 = new byte[this.field564 * this.field564];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[0][0] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[0][1] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[0][2] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[0][3] = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1973"
   )
   void method724() {
      byte[] var1 = new byte[this.field564 * this.field564];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[1][0] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
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

      this.field567[1][1] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[1][2] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[1][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-122710201"
   )
   void method725() {
      byte[] var1 = new byte[this.field564 * this.field564];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[2][0] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[2][1] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[2][2] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[2][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   void method736() {
      byte[] var1 = new byte[this.field564 * this.field564];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[3][0] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[3][1] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[3][2] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[3][3] = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2143542986"
   )
   void method727() {
      byte[] var1 = new byte[this.field564 * this.field564];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[4][0] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[4][1] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[4][2] = var1;
      var1 = new byte[this.field564 * this.field564];
      var2 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field567[4][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-100"
   )
   void method742() {
      byte[] var1 = new byte[this.field564 * this.field564];
      boolean var2 = false;
      var1 = new byte[this.field564 * this.field564];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 <= this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[5][0] = var1;
      var1 = new byte[this.field564 * this.field564];
      var5 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var3 <= this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[5][1] = var1;
      var1 = new byte[this.field564 * this.field564];
      var5 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 >= this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[5][2] = var1;
      var1 = new byte[this.field564 * this.field564];
      var5 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var3 >= this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[5][3] = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-256585513"
   )
   void method729() {
      byte[] var1 = new byte[this.field564 * this.field564];
      boolean var2 = false;
      var1 = new byte[this.field564 * this.field564];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 <= var3 - this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[6][0] = var1;
      var1 = new byte[this.field564 * this.field564];
      var5 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 <= var3 - this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[6][1] = var1;
      var1 = new byte[this.field564 * this.field564];
      var5 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[6][2] = var1;
      var1 = new byte[this.field564 * this.field564];
      var5 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[6][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1109859627"
   )
   void method741() {
      byte[] var1 = new byte[this.field564 * this.field564];
      boolean var2 = false;
      var1 = new byte[this.field564 * this.field564];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 >= var3 - this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[7][0] = var1;
      var1 = new byte[this.field564 * this.field564];
      var5 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field564; ++var4) {
            if(var4 >= var3 - this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[7][1] = var1;
      var1 = new byte[this.field564 * this.field564];
      var5 = 0;

      for(var3 = this.field564 - 1; var3 >= 0; --var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[7][2] = var1;
      var1 = new byte[this.field564 * this.field564];
      var5 = 0;

      for(var3 = 0; var3 < this.field564; ++var3) {
         for(var4 = this.field564 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field564 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field567[7][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;I)V",
      garbageValue = "1642824812"
   )
   public static void method756(IndexDataBase var0) {
      class271.field3485 = var0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "-19498"
   )
   static void method752(boolean var0) {
      class90.loginMessage1 = "";
      class90.loginMessage2 = "Enter your username/email & password.";
      class90.loginMessage3 = "";
      class90.loginIndex = 2;
      if(var0) {
         class90.password = "";
      }

      Tile.method2682();
      if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
         class90.field1351 = 1;
      } else {
         class90.field1351 = 0;
      }

   }
}
