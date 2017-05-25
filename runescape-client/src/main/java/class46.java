import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class46 {
   @ObfuscatedName("h")
   byte[][][] field587;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1334632939
   )
   int field589;
   @ObfuscatedName("fm")
   @Export("region")
   static Region region;

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1675500720"
   )
   static String method677(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1005171487"
   )
   void method679() {
      byte[] var1 = new byte[this.field589 * this.field589];
      boolean var2 = false;
      var1 = new byte[this.field589 * this.field589];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 <= var3 - this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[6][0] = var1;
      var1 = new byte[this.field589 * this.field589];
      var5 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 <= var3 - this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[6][1] = var1;
      var1 = new byte[this.field589 * this.field589];
      var5 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[6][2] = var1;
      var1 = new byte[this.field589 * this.field589];
      var5 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[6][3] = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1771615402"
   )
   void method680() {
      byte[] var1 = new byte[this.field589 * this.field589];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[4][0] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[4][1] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[4][2] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[4][3] = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2130987881"
   )
   void method681() {
      if(this.field587 == null) {
         this.field587 = new byte[8][4][];
         this.method704();
         this.method683();
         this.method684();
         this.method685();
         this.method680();
         this.method687();
         this.method679();
         this.method688();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "937725070"
   )
   void method683() {
      byte[] var1 = new byte[this.field589 * this.field589];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[1][0] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
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
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[1][2] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[1][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1655732201"
   )
   void method684() {
      byte[] var1 = new byte[this.field589 * this.field589];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[2][0] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[2][1] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[2][2] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[2][3] = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1278602907"
   )
   void method685() {
      byte[] var1 = new byte[this.field589 * this.field589];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[3][0] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[3][1] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[3][2] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[3][3] = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1015360627"
   )
   void method686(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field589 != 0 && this.field587 != null) {
         var8 = this.method699(var8, var7);
         var7 = this.method707(var7);
         Rasterizer2D.method5079(var1, var2, var5, var6, var3, var4, this.field587[var7 - 1][var8], this.field589);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1890591540"
   )
   void method687() {
      byte[] var1 = new byte[this.field589 * this.field589];
      boolean var2 = false;
      var1 = new byte[this.field589 * this.field589];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 <= this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[5][0] = var1;
      var1 = new byte[this.field589 * this.field589];
      var5 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var3 <= this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[5][1] = var1;
      var1 = new byte[this.field589 * this.field589];
      var5 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 >= this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[5][2] = var1;
      var1 = new byte[this.field589 * this.field589];
      var5 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var3 >= this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[5][3] = var1;
   }

   class46(int var1) {
      this.field589 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   void method688() {
      byte[] var1 = new byte[this.field589 * this.field589];
      boolean var2 = false;
      var1 = new byte[this.field589 * this.field589];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 >= var3 - this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[7][0] = var1;
      var1 = new byte[this.field589 * this.field589];
      var5 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 >= var3 - this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[7][1] = var1;
      var1 = new byte[this.field589 * this.field589];
      var5 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[7][2] = var1;
      var1 = new byte[this.field589 * this.field589];
      var5 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = this.field589 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field589 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field587[7][3] = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1849333138"
   )
   int method699(int var1, int var2) {
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
      garbageValue = "250547160"
   )
   void method704() {
      byte[] var1 = new byte[this.field589 * this.field589];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[0][0] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[0][1] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = 0; var3 < this.field589; ++var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[0][2] = var1;
      var1 = new byte[this.field589 * this.field589];
      var2 = 0;

      for(var3 = this.field589 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field589; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field587[0][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-853652054"
   )
   int method707(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-461739668"
   )
   static final boolean method710(Widget var0) {
      if(var0.field2755 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2755.length; ++var1) {
            int var2 = class71.method1124(var0, var1);
            int var3 = var0.field2756[var1];
            if(var0.field2755[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2755[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2755[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "195152389"
   )
   public static int method711(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "806246081"
   )
   static final void method712() {
      for(int var0 = 0; var0 < Client.field928; ++var0) {
         int var1 = Client.field1013[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class21.method149(var2, var2.composition.field3548);
         }
      }

   }
}
