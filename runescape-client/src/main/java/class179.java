import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("PlayerComposition")
public class class179 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 527494677
   )
   public int field2911;
   @ObfuscatedName("g")
   @Export("bodyPartColours")
   int[] field2912;
   @ObfuscatedName("j")
   @Export("isFemale")
   public boolean field2913;
   @ObfuscatedName("n")
   static class193 field2914 = new class193(260);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 2582048277199019973L
   )
   @Export("hash")
   long field2915;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -5685839864339942181L
   )
   long field2916;
   @ObfuscatedName("r")
   public static short[] field2917;
   @ObfuscatedName("b")
   @Export("bodyParts")
   int[] field2918;
   @ObfuscatedName("u")
   public static short[][] field2919;
   @ObfuscatedName("p")
   static final int[] field2920 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("l")
   public static short[] field2922;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "0"
   )
   public void method3487(int var1, boolean var2) {
      if(var1 != 1 || !this.field2913) {
         int var3 = this.field2918[field2920[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class44 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class44.field1010 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class44.field1010) {
                     var3 = 0;
                  }
               }

               var4 = class85.method1919(var3);
            } while(var4 == null || var4.field1016 || var4.field1009 != (this.field2913?7:0) + var1);

            this.field2918[field2920[var1]] = var3 + 256;
            this.method3491();
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "-52"
   )
   public void method3488(int var1, boolean var2) {
      int var3 = this.field2912[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class34.field760[var1].length - 1;
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
            if(var3 >= class34.field760[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.field2912[var1] = var3;
      this.method3491();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1576987982"
   )
   void method3491() {
      long var1 = this.field2915;
      int var3 = this.field2918[5];
      int var4 = this.field2918[9];
      this.field2918[5] = var4;
      this.field2918[9] = var3;
      this.field2915 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2915 <<= 4;
         if(this.field2918[var5] >= 256) {
            this.field2915 += (long)(this.field2918[var5] - 256);
         }
      }

      if(this.field2918[0] >= 256) {
         this.field2915 += (long)(this.field2918[0] - 256 >> 4);
      }

      if(this.field2918[1] >= 256) {
         this.field2915 += (long)(this.field2918[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2915 <<= 3;
         this.field2915 += (long)this.field2912[var5];
      }

      this.field2915 <<= 1;
      this.field2915 += (long)(this.field2913?1:0);
      this.field2918[5] = var3;
      this.field2918[9] = var4;
      if(0L != var1 && this.field2915 != var1) {
         field2914.method3757(var1);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "710921882"
   )
   public void method3492(class119 var1) {
      var1.method2650(this.field2913?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2918[field2920[var2]];
         if(var3 == 0) {
            var1.method2650(-1);
         } else {
            var1.method2650(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2650(this.field2912[var2]);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-823389861"
   )
   public int method3494() {
      return this.field2911 == -1?this.field2918[1] + (this.field2918[8] << 10) + (this.field2918[0] << 15) + (this.field2912[0] << 25) + (this.field2912[4] << 20) + (this.field2918[11] << 5):305419896 + class176.method3460(this.field2911).field867;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "2135386523"
   )
   public void method3516(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field1010; ++var6) {
               class44 var7 = class85.method1919(var6);
               if(var7 != null && !var7.field1016 && var7.field1009 == var5 + (var3?7:0)) {
                  var1[field2920[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.field2918 = var1;
      this.field2912 = var2;
      this.field2913 = var3;
      this.field2911 = var4;
      this.method3491();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "77"
   )
   class100 method3518() {
      if(this.field2911 != -1) {
         return class176.method3460(this.field2911).method793();
      } else {
         boolean var1 = false;

         int var3;
         for(int var7 = 0; var7 < 12; ++var7) {
            var3 = this.field2918[var7];
            if(var3 >= 256 && var3 < 512 && !class85.method1919(var3 - 256).method935()) {
               var1 = true;
            }

            if(var3 >= 512 && !class35.method741(var3 - 512).method1029(this.field2913)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var2 = new class100[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.field2918[var4];
               class100 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class85.method1919(var5 - 256).method926();
                  if(null != var6) {
                     var2[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class35.method741(var5 - 512).method1028(this.field2913);
                  if(null != var6) {
                     var2[var3++] = var6;
                  }
               }
            }

            class100 var8 = new class100(var2, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2912[var5] < class34.field760[var5].length) {
                  var8.method2221(field2917[var5], class34.field760[var5][this.field2912[var5]]);
               }

               if(this.field2912[var5] < field2919[var5].length) {
                  var8.method2221(field2922[var5], field2919[var5][this.field2912[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;IB)Lclass105;",
      garbageValue = "4"
   )
   public class105 method3519(class42 var1, int var2, class42 var3, int var4) {
      if(this.field2911 != -1) {
         return class176.method3460(this.field2911).method771(var1, var2, var3, var4);
      } else {
         long var5 = this.field2915;
         int[] var7 = this.field2918;
         if(null != var1 && (var1.field974 >= 0 || var1.field975 >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.field2918[var15];
            }

            if(var1.field974 >= 0) {
               var5 += (long)(var1.field974 - this.field2918[5] << 40);
               var7[5] = var1.field974;
            }

            if(var1.field975 >= 0) {
               var5 += (long)(var1.field975 - this.field2918[3] << 48);
               var7[3] = var1.field975;
            }
         }

         class105 var8 = (class105)field2914.method3764(var5);
         if(var8 == null) {
            boolean var16 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class85.method1919(var11 - 256).method923()) {
                  var16 = true;
               }

               if(var11 >= 512 && !class35.method741(var11 - 512).method1025(this.field2913)) {
                  var16 = true;
               }
            }

            if(var16) {
               if(-1L != this.field2916) {
                  var8 = (class105)field2914.method3764(this.field2916);
               }

               if(null == var8) {
                  return null;
               }
            }

            if(null == var8) {
               class100[] var18 = new class100[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class100 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class85.method1919(var13 - 256).method924();
                     if(var14 != null) {
                        var18[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class35.method741(var13 - 512).method1026(this.field2913);
                     if(null != var14) {
                        var18[var11++] = var14;
                     }
                  }
               }

               class100 var17 = new class100(var18, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2912[var13] < class34.field760[var13].length) {
                     var17.method2221(field2917[var13], class34.field760[var13][this.field2912[var13]]);
                  }

                  if(this.field2912[var13] < field2919[var13].length) {
                     var17.method2221(field2922[var13], field2919[var13][this.field2912[var13]]);
                  }
               }

               var8 = var17.method2229(64, 850, -30, -50, -30);
               field2914.method3759(var8, var5);
               this.field2916 = var5;
            }
         }

         if(null == var1 && var3 == null) {
            return var8;
         } else {
            class105 var9;
            if(null != var1 && null != var3) {
               var9 = var1.method872(var8, var2, var3, var4);
            } else if(null != var1) {
               var9 = var1.method894(var8, var2);
            } else {
               var9 = var3.method894(var8, var4);
            }

            return var9;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "328753219"
   )
   public void method3520(boolean var1) {
      if(this.field2913 != var1) {
         this.method3516((int[])null, this.field2912, var1, -1);
      }
   }
}
