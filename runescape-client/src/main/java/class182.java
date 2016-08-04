import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
@Implements("PlayerComposition")
public class class182 {
   @ObfuscatedName("k")
   public static short[] field2969;
   @ObfuscatedName("as")
   static int[] field2970;
   @ObfuscatedName("r")
   @Export("isFemale")
   public boolean field2971;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 218582835
   )
   public int field2972;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -6499637505182612365L
   )
   @Export("hash")
   long field2973;
   @ObfuscatedName("g")
   @Export("bodyPartColours")
   int[] field2974;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 1454066421934414707L
   )
   long field2975;
   @ObfuscatedName("n")
   public static short[] field2976;
   @ObfuscatedName("m")
   static final int[] field2977 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("q")
   static class196 field2978 = new class196(260);
   @ObfuscatedName("l")
   @Export("bodyParts")
   int[] field2979;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "-99"
   )
   public void method3634(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class46.field1054; ++var6) {
               class46 var7 = class105.method2385(var6);
               if(null != var7 && !var7.field1053 && var7.field1056 == (var3?7:0) + var5) {
                  var1[field2977[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.field2979 = var1;
      this.field2974 = var2;
      this.field2971 = var3;
      this.field2972 = var4;
      this.method3639();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1083371902"
   )
   public void method3635(int var1, boolean var2) {
      if(var1 != 1 || !this.field2971) {
         int var3 = this.field2979[field2977[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class46 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class46.field1054 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class46.field1054) {
                     var3 = 0;
                  }
               }

               var4 = class105.method2385(var3);
            } while(null == var4 || var4.field1053 || (this.field2971?7:0) + var1 != var4.field1056);

            this.field2979[field2977[var1]] = var3 + 256;
            this.method3639();
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1427355202"
   )
   public void method3636(int var1, boolean var2) {
      int var3 = this.field2974[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class175.field2794[var1].length - 1;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      } else {
         do {
            ++var3;
            if(var3 >= class175.field2794[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.field2974[var1] = var3;
      this.method3639();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1533187066"
   )
   public void method3637(boolean var1) {
      if(this.field2971 != var1) {
         this.method3634((int[])null, this.field2974, var1, -1);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "204185956"
   )
   public void method3638(class122 var1) {
      var1.method2783(this.field2971?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2979[field2977[var2]];
         if(var3 == 0) {
            var1.method2783(-1);
         } else {
            var1.method2783(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2783(this.field2974[var2]);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "122"
   )
   void method3639() {
      long var1 = this.field2973;
      int var3 = this.field2979[5];
      int var4 = this.field2979[9];
      this.field2979[5] = var4;
      this.field2979[9] = var3;
      this.field2973 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2973 <<= 4;
         if(this.field2979[var5] >= 256) {
            this.field2973 += (long)(this.field2979[var5] - 256);
         }
      }

      if(this.field2979[0] >= 256) {
         this.field2973 += (long)(this.field2979[0] - 256 >> 4);
      }

      if(this.field2979[1] >= 256) {
         this.field2973 += (long)(this.field2979[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2973 <<= 3;
         this.field2973 += (long)this.field2974[var5];
      }

      this.field2973 <<= 1;
      this.field2973 += (long)(this.field2971?1:0);
      this.field2979[5] = var3;
      this.field2979[9] = var4;
      if(var1 != 0L && var1 != this.field2973) {
         field2978.method3906(var1);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass103;",
      garbageValue = "2041125131"
   )
   class103 method3641() {
      if(this.field2972 != -1) {
         return class16.method202(this.field2972).method819();
      } else {
         boolean var1 = false;

         int var3;
         for(int var7 = 0; var7 < 12; ++var7) {
            var3 = this.field2979[var7];
            if(var3 >= 256 && var3 < 512 && !class105.method2385(var3 - 256).method991()) {
               var1 = true;
            }

            if(var3 >= 512 && !class1.method14(var3 - 512).method1232(this.field2971)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class103[] var2 = new class103[12];
            var3 = 0;

            int var5;
            for(int var8 = 0; var8 < 12; ++var8) {
               var5 = this.field2979[var8];
               class103 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class105.method2385(var5 - 256).method974();
                  if(null != var6) {
                     var2[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class1.method14(var5 - 512).method1183(this.field2971);
                  if(var6 != null) {
                     var2[var3++] = var6;
                  }
               }
            }

            class103 var4 = new class103(var2, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2974[var5] < class175.field2794[var5].length) {
                  var4.method2305(field2969[var5], class175.field2794[var5][this.field2974[var5]]);
               }

               if(this.field2974[var5] < class105.field1840[var5].length) {
                  var4.method2305(field2976[var5], class105.field1840[var5][this.field2974[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "760818026"
   )
   public int method3642() {
      return this.field2972 == -1?this.field2979[1] + (this.field2979[11] << 5) + (this.field2974[0] << 25) + (this.field2974[4] << 20) + (this.field2979[0] << 15) + (this.field2979[8] << 10):305419896 + class16.method202(this.field2972).field924;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass44;ILclass44;II)Lclass108;",
      garbageValue = "-2059410991"
   )
   public class108 method3667(class44 var1, int var2, class44 var3, int var4) {
      if(this.field2972 != -1) {
         return class16.method202(this.field2972).method818(var1, var2, var3, var4);
      } else {
         long var5 = this.field2973;
         int[] var7 = this.field2979;
         if(null != var1 && (var1.field1024 >= 0 || var1.field1025 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2979[var8];
            }

            if(var1.field1024 >= 0) {
               var5 += (long)(var1.field1024 - this.field2979[5] << 40);
               var7[5] = var1.field1024;
            }

            if(var1.field1025 >= 0) {
               var5 += (long)(var1.field1025 - this.field2979[3] << 48);
               var7[3] = var1.field1025;
            }
         }

         class108 var15 = (class108)field2978.method3905(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class105.method2385(var11 - 256).method971()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class1.method14(var11 - 512).method1171(this.field2971)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2975 != -1L) {
                  var15 = (class108)field2978.method3905(this.field2975);
               }

               if(null == var15) {
                  return null;
               }
            }

            if(null == var15) {
               class103[] var17 = new class103[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class103 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class105.method2385(var13 - 256).method972();
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class1.method14(var13 - 512).method1181(this.field2971);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class103 var18 = new class103(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2974[var13] < class175.field2794[var13].length) {
                     var18.method2305(field2969[var13], class175.field2794[var13][this.field2974[var13]]);
                  }

                  if(this.field2974[var13] < class105.field1840[var13].length) {
                     var18.method2305(field2976[var13], class105.field1840[var13][this.field2974[var13]]);
                  }
               }

               var15 = var18.method2321(64, 850, -30, -50, -30);
               field2978.method3907(var15, var5);
               this.field2975 = var5;
            }
         }

         if(var1 == null && null == var3) {
            return var15;
         } else {
            class108 var16;
            if(null != var1 && null != var3) {
               var16 = var1.method914(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method943(var15, var2);
            } else {
               var16 = var3.method943(var15, var4);
            }

            return var16;
         }
      }
   }
}
