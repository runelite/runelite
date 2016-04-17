import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("PlayerComposition")
public class class179 {
   @ObfuscatedName("m")
   public static short[][] field2922;
   @ObfuscatedName("w")
   @Export("bodyPartColours")
   int[] field2923;
   @ObfuscatedName("d")
   @Export("isFemale")
   public boolean field2924;
   @ObfuscatedName("p")
   public static short[][] field2925;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -4423296764047098945L
   )
   long field2926;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -5930778580649804545L
   )
   long field2927;
   @ObfuscatedName("a")
   @Export("bodyParts")
   int[] field2928;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -19629737
   )
   public int field2929;
   @ObfuscatedName("e")
   static final int[] field2930 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("x")
   public static class193 field2931 = new class193(260);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IZS)V",
      garbageValue = "1"
   )
   public void method3561(int var1, boolean var2) {
      int var3 = this.field2923[var1];

      do {
         ++var3;
         if(var3 >= field2925[var1].length) {
            var3 = 0;
         }
      } while(!class150.method3240(var1, var3));

      this.field2923[var1] = var3;
      this.method3585();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "66"
   )
   public void method3563(class119 var1) {
      var1.method2603(this.field2924?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2928[field2930[var2]];
         if(0 == var3) {
            var1.method2603(-1);
         } else {
            var1.method2603(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2603(this.field2923[var2]);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "-66"
   )
   public void method3564(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field1038; ++var6) {
               class44 var7 = class160.method3275(var6);
               if(null != var7 && !var7.field1047 && var5 + (var3?7:0) == var7.field1040) {
                  var1[field2930[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.field2928 = var1;
      this.field2923 = var2;
      this.field2924 = var3;
      this.field2929 = var4;
      this.method3585();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;II)Lclass105;",
      garbageValue = "-1956651514"
   )
   public class105 method3565(class42 var1, int var2, class42 var3, int var4) {
      if(this.field2929 != -1) {
         return class28.method734(this.field2929).method860(var1, var2, var3, var4);
      } else {
         long var5 = this.field2926;
         int[] var7 = this.field2928;
         if(var1 != null && (var1.field994 >= 0 || var1.field1001 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2928[var8];
            }

            if(var1.field994 >= 0) {
               var5 += (long)(var1.field994 - this.field2928[5] << 40);
               var7[5] = var1.field994;
            }

            if(var1.field1001 >= 0) {
               var5 += (long)(var1.field1001 - this.field2928[3] << 48);
               var7[3] = var1.field1001;
            }
         }

         class105 var15 = (class105)field2931.method3840(var5);
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class160.method3275(var11 - 256).method1033()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class11.method178(var11 - 512).method1134(this.field2924)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2927 != -1L) {
                  var15 = (class105)field2931.method3840(this.field2927);
               }

               if(null == var15) {
                  return null;
               }
            }

            if(null == var15) {
               class100[] var17 = new class100[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class100 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class160.method3275(var13 - 256).method1029();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class11.method178(var13 - 512).method1148(this.field2924);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class100 var18 = new class100(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2923[var13] < field2925[var13].length) {
                     var18.method2303(class17.field264[var13], field2925[var13][this.field2923[var13]]);
                  }

                  if(this.field2923[var13] < field2922[var13].length) {
                     var18.method2303(class186.field3018[var13], field2922[var13][this.field2923[var13]]);
                  }
               }

               var15 = var18.method2368(64, 850, -30, -50, -30);
               field2931.method3842(var15, var5);
               this.field2927 = var5;
            }
         }

         if(null == var1 && null == var3) {
            return var15;
         } else {
            class105 var16;
            if(null != var1 && var3 != null) {
               var16 = var1.method957(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method954(var15, var2);
            } else {
               var16 = var3.method954(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "16"
   )
   class100 method3566() {
      if(this.field2929 != -1) {
         return class28.method734(this.field2929).method861();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2928[var2];
            if(var3 >= 256 && var3 < 512 && !class160.method3275(var3 - 256).method1017()) {
               var1 = true;
            }

            if(var3 >= 512 && !class11.method178(var3 - 512).method1131(this.field2924)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var7 = new class100[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.field2928[var4];
               class100 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class160.method3275(var5 - 256).method1028();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class11.method178(var5 - 512).method1137(this.field2924);
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }
            }

            class100 var8 = new class100(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2923[var5] < field2925[var5].length) {
                  var8.method2303(class17.field264[var5], field2925[var5][this.field2923[var5]]);
               }

               if(this.field2923[var5] < field2922[var5].length) {
                  var8.method2303(class186.field3018[var5], field2922[var5][this.field2923[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-93"
   )
   public int method3567() {
      return -1 == this.field2929?this.field2928[1] + (this.field2928[8] << 10) + (this.field2923[4] << 20) + (this.field2923[0] << 25) + (this.field2928[0] << 15) + (this.field2928[11] << 5):305419896 + class28.method734(this.field2929).field890;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)I",
      garbageValue = "-976235717"
   )
   static int method3568(class122 var0) {
      int var1 = var0.method2863(2);
      int var2;
      if(0 == var1) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2863(5);
      } else if(2 == var1) {
         var2 = var0.method2863(8);
      } else {
         var2 = var0.method2863(11);
      }

      return var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   public void method3569(boolean var1) {
      if(this.field2924 != var1) {
         this.method3564((int[])null, this.field2923, var1, -1);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1"
   )
   public void method3584(int var1, boolean var2) {
      if(1 != var1 || !this.field2924) {
         int var3 = this.field2928[field2930[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class44 var4;
            do {
               ++var3;
               if(var3 >= class44.field1038) {
                  var3 = 0;
               }

               var4 = class160.method3275(var3);
            } while(null == var4 || var4.field1047 || var4.field1040 != (this.field2924?7:0) + var1);

            this.field2928[field2930[var1]] = 256 + var3;
            this.method3585();
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "461663883"
   )
   void method3585() {
      long var1 = this.field2926;
      int var3 = this.field2928[5];
      int var4 = this.field2928[9];
      this.field2928[5] = var4;
      this.field2928[9] = var3;
      this.field2926 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2926 <<= 4;
         if(this.field2928[var5] >= 256) {
            this.field2926 += (long)(this.field2928[var5] - 256);
         }
      }

      if(this.field2928[0] >= 256) {
         this.field2926 += (long)(this.field2928[0] - 256 >> 4);
      }

      if(this.field2928[1] >= 256) {
         this.field2926 += (long)(this.field2928[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2926 <<= 3;
         this.field2926 += (long)this.field2923[var5];
      }

      this.field2926 <<= 1;
      this.field2926 += (long)(this.field2924?1:0);
      this.field2928[5] = var3;
      this.field2928[9] = var4;
      if(0L != var1 && var1 != this.field2926) {
         field2931.method3841(var1);
      }

   }
}
