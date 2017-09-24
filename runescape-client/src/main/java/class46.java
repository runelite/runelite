import java.io.File;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class46 {
   @ObfuscatedName("o")
   public static File field612;
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("j")
   byte[][][] field605;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -176268585
   )
   int field610;

   class46(int var1) {
      this.field610 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "45"
   )
   void method703() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[0][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[0][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[0][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[0][3] = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-76"
   )
   int method700(int var1, int var2) {
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
      signature = "(B)V",
      garbageValue = "81"
   )
   void method704() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[1][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
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

      this.field605[1][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[1][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[1][3] = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "103597869"
   )
   int method708(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1756510603"
   )
   void method705() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[2][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[2][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[2][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[2][3] = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1705528187"
   )
   void method702() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[3][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[3][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[3][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[3][3] = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1346878264"
   )
   void method718() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[4][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[4][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[4][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field605[4][3] = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-17786"
   )
   void method701() {
      byte[] var1 = new byte[this.field610 * this.field610];
      boolean var2 = false;
      var1 = new byte[this.field610 * this.field610];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[5][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var3 <= this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[5][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[5][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var3 >= this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[5][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "865804048"
   )
   void method709() {
      byte[] var1 = new byte[this.field610 * this.field610];
      boolean var2 = false;
      var1 = new byte[this.field610 * this.field610];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[6][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[6][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[6][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[6][3] = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1972342416"
   )
   void method699(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field610 != 0 && this.field605 != null) {
         var8 = this.method700(var8, var7);
         var7 = this.method708(var7);
         Rasterizer2D.method4896(var1, var2, var5, var6, var3, var4, this.field605[var7 - 1][var8], this.field610);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2004390851"
   )
   void method715() {
      byte[] var1 = new byte[this.field610 * this.field610];
      boolean var2 = false;
      var1 = new byte[this.field610 * this.field610];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[7][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[7][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[7][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field605[7][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1489355313"
   )
   void method707() {
      if(this.field605 == null) {
         this.field605 = new byte[8][4][];
         this.method703();
         this.method704();
         this.method705();
         this.method702();
         this.method718();
         this.method701();
         this.method709();
         this.method715();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Ljx;",
      garbageValue = "126"
   )
   static IndexedSprite method730() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class287.field3797;
      var0.originalHeight = class287.field3798;
      var0.offsetX = class271.field3679[0];
      var0.offsetY = class18.offsetsY[0];
      var0.originalWidth = class287.field3796[0];
      var0.height = class245.field3324[0];
      var0.palette = Varbit.field3387;
      var0.pixels = class274.spritePixels[0];
      Buffer.method3330();
      return var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILii;IIIZI)V",
      garbageValue = "455139264"
   )
   public static void method736(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class204.field2507 = 1;
      class204.field2508 = var1;
      class204.field2509 = var2;
      ItemContainer.field787 = var3;
      class204.field2510 = var4;
      Varcs.field1528 = var5;
      class115.field1694 = var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-914840726"
   )
   static int method727(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
         var4 = class82.intStack[--Ignore.intStackSize];
         class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var9;
         if(var0 == 4101) {
            class169.scriptStringStackSize -= 2;
            var3 = class82.scriptStringStack[class169.scriptStringStackSize];
            var9 = class82.scriptStringStack[class169.scriptStringStackSize + 1];
            class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3 + var9;
            return 1;
         } else if(var0 == 4102) {
            var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
            var4 = class82.intStack[--Ignore.intStackSize];
            class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3 + class2.method3(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
            class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var10;
            if(var0 == 4104) {
               var10 = class82.intStack[--Ignore.intStackSize];
               long var11 = (11745L + (long)var10) * 86400000L;
               class82.field1343.setTime(new Date(var11));
               var6 = class82.field1343.get(5);
               int var17 = class82.field1343.get(2);
               int var8 = class82.field1343.get(1);
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var6 + "-" + class82.field1353[var17] + "-" + var8;
               return 1;
            } else if(var0 != 4105) {
               if(var0 == 4106) {
                  var10 = class82.intStack[--Ignore.intStackSize];
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = Integer.toString(var10);
                  return 1;
               } else if(var0 == 4107) {
                  class169.scriptStringStackSize -= 2;
                  int[] var16 = class82.intStack;
                  var4 = ++Ignore.intStackSize - 1;
                  var6 = class284.method4980(class82.scriptStringStack[class169.scriptStringStackSize], class82.scriptStringStack[class169.scriptStringStackSize + 1], Client.languageId);
                  byte var18;
                  if(var6 > 0) {
                     var18 = 1;
                  } else if(var6 < 0) {
                     var18 = -1;
                  } else {
                     var18 = 0;
                  }

                  var16[var4] = var18;
                  return 1;
               } else {
                  int var5;
                  byte[] var13;
                  Font var14;
                  if(var0 == 4108) {
                     var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     Ignore.intStackSize -= 2;
                     var4 = class82.intStack[Ignore.intStackSize];
                     var5 = class82.intStack[Ignore.intStackSize + 1];
                     var13 = class216.field2644.getConfigData(var5, 0);
                     var14 = new Font(var13);
                     class82.intStack[++Ignore.intStackSize - 1] = var14.method4794(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     Ignore.intStackSize -= 2;
                     var4 = class82.intStack[Ignore.intStackSize];
                     var5 = class82.intStack[Ignore.intStackSize + 1];
                     var13 = class216.field2644.getConfigData(var5, 0);
                     var14 = new Font(var13);
                     class82.intStack[++Ignore.intStackSize - 1] = var14.method4717(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class169.scriptStringStackSize -= 2;
                     var3 = class82.scriptStringStack[class169.scriptStringStackSize];
                     var9 = class82.scriptStringStack[class169.scriptStringStackSize + 1];
                     if(class82.intStack[--Ignore.intStackSize] == 1) {
                        class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3;
                     } else {
                        class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var9;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     var4 = class82.intStack[--Ignore.intStackSize];
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if(var0 == 4113) {
                     var10 = class82.intStack[--Ignore.intStackSize];
                     class82.intStack[++Ignore.intStackSize - 1] = class41.method617((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4114) {
                     var10 = class82.intStack[--Ignore.intStackSize];
                     class82.intStack[++Ignore.intStackSize - 1] = class44.method660((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4115) {
                     var10 = class82.intStack[--Ignore.intStackSize];
                     class82.intStack[++Ignore.intStackSize - 1] = class229.method4117((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4116) {
                     var10 = class82.intStack[--Ignore.intStackSize];
                     class82.intStack[++Ignore.intStackSize - 1] = RSCanvas.method828((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4117) {
                     var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     if(var3 != null) {
                        class82.intStack[++Ignore.intStackSize - 1] = var3.length();
                     } else {
                        class82.intStack[++Ignore.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 4118) {
                     var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     Ignore.intStackSize -= 2;
                     var4 = class82.intStack[Ignore.intStackSize];
                     var5 = class82.intStack[Ignore.intStackSize + 1];
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3.substring(var4, var5);
                     return 1;
                  } else if(var0 == 4119) {
                     var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     StringBuilder var19 = new StringBuilder(var3.length());
                     boolean var15 = false;

                     for(var6 = 0; var6 < var3.length(); ++var6) {
                        char var7 = var3.charAt(var6);
                        if(var7 == 60) {
                           var15 = true;
                        } else if(var7 == 62) {
                           var15 = false;
                        } else if(!var15) {
                           var19.append(var7);
                        }
                     }

                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var19.toString();
                     return 1;
                  } else if(var0 == 4120) {
                     var3 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     var4 = class82.intStack[--Ignore.intStackSize];
                     class82.intStack[++Ignore.intStackSize - 1] = var3.indexOf(var4);
                     return 1;
                  } else if(var0 == 4121) {
                     class169.scriptStringStackSize -= 2;
                     var3 = class82.scriptStringStack[class169.scriptStringStackSize];
                     var9 = class82.scriptStringStack[class169.scriptStringStackSize + 1];
                     var5 = class82.intStack[--Ignore.intStackSize];
                     class82.intStack[++Ignore.intStackSize - 1] = var3.indexOf(var9, var5);
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               class169.scriptStringStackSize -= 2;
               var3 = class82.scriptStringStack[class169.scriptStringStackSize];
               var9 = class82.scriptStringStack[class169.scriptStringStackSize + 1];
               if(Player.localPlayer.composition != null && Player.localPlayer.composition.isFemale) {
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var9;
               } else {
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "657967758"
   )
   static void method735(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         class208.method3922(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }
}
