import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
@Implements("PlayerComposition")
public class class179 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -677001042659322087L
   )
   @Export("hash")
   long field2938;
   @ObfuscatedName("i")
   @Export("bodyPartColours")
   int[] field2939;
   @ObfuscatedName("l")
   public static short[][] field2940;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1371252885
   )
   public int field2941;
   @ObfuscatedName("g")
   @Export("isFemale")
   public boolean field2942;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 6344465649925430957L
   )
   long field2943;
   @ObfuscatedName("p")
   public static class193 field2944 = new class193(260);
   @ObfuscatedName("y")
   static final int[] field2945 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("t")
   @Export("bodyParts")
   int[] field2946;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "81"
   )
   public void method3431(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field1030; ++var6) {
               class44 var7 = class102.method2236(var6);
               if(null != var7 && !var7.field1034 && var7.field1027 == var5 + (var3?7:0)) {
                  var1[field2945[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.field2946 = var1;
      this.field2939 = var2;
      this.field2942 = var3;
      this.field2941 = var4;
      this.method3435();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1"
   )
   public void method3432(int var1, boolean var2) {
      if(var1 != 1 || !this.field2942) {
         int var3 = this.field2946[field2945[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class44 var4;
            do {
               ++var3;
               if(var3 >= class44.field1030) {
                  var3 = 0;
               }

               var4 = class102.method2236(var3);
            } while(var4 == null || var4.field1034 || var4.field1027 != (this.field2942?7:0) + var1);

            this.field2946[field2945[var1]] = var3 + 256;
            this.method3435();
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1351320515"
   )
   void method3435() {
      long var1 = this.field2938;
      int var3 = this.field2946[5];
      int var4 = this.field2946[9];
      this.field2946[5] = var4;
      this.field2946[9] = var3;
      this.field2938 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2938 <<= 4;
         if(this.field2946[var5] >= 256) {
            this.field2938 += (long)(this.field2946[var5] - 256);
         }
      }

      if(this.field2946[0] >= 256) {
         this.field2938 += (long)(this.field2946[0] - 256 >> 4);
      }

      if(this.field2946[1] >= 256) {
         this.field2938 += (long)(this.field2946[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2938 <<= 3;
         this.field2938 += (long)this.field2939[var5];
      }

      this.field2938 <<= 1;
      this.field2938 += (long)(this.field2942?1:0);
      this.field2946[5] = var3;
      this.field2946[9] = var4;
      if(0L != var1 && this.field2938 != var1) {
         field2944.method3715(var1);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;IB)Lclass105;",
      garbageValue = "110"
   )
   public class105 method3436(class42 var1, int var2, class42 var3, int var4) {
      if(this.field2941 != -1) {
         return class17.method169(this.field2941).method746(var1, var2, var3, var4);
      } else {
         long var5 = this.field2938;
         int[] var7 = this.field2946;
         if(var1 != null && (var1.field982 >= 0 || var1.field994 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2946[var8];
            }

            if(var1.field982 >= 0) {
               var5 += (long)(var1.field982 - this.field2946[5] << 40);
               var7[5] = var1.field982;
            }

            if(var1.field994 >= 0) {
               var5 += (long)(var1.field994 - this.field2946[3] << 48);
               var7[3] = var1.field994;
            }
         }

         class105 var15 = (class105)field2944.method3716(var5);
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class102.method2236(var11 - 256).method900()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class123.method2743(var11 - 512).method1021(this.field2942)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2943) {
                  var15 = (class105)field2944.method3716(this.field2943);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               class100[] var17 = new class100[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class100 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class102.method2236(var13 - 256).method898();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class123.method2743(var13 - 512).method1000(this.field2942);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class100 var18 = new class100(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2939[var13] < class127.field2060[var13].length) {
                     var18.method2201(class45.field1049[var13], class127.field2060[var13][this.field2939[var13]]);
                  }

                  if(this.field2939[var13] < field2940[var13].length) {
                     var18.method2201(class135.field2106[var13], field2940[var13][this.field2939[var13]]);
                  }
               }

               var15 = var18.method2181(64, 850, -30, -50, -30);
               field2944.method3724(var15, var5);
               this.field2943 = var5;
            }
         }

         if(null == var1 && null == var3) {
            return var15;
         } else {
            class105 var16;
            if(null != var1 && null != var3) {
               var16 = var1.method855(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method848(var15, var2);
            } else {
               var16 = var3.method848(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "1905973062"
   )
   class100 method3437() {
      if(this.field2941 != -1) {
         return class17.method169(this.field2941).method751();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2946[var2];
            if(var3 >= 256 && var3 < 512 && !class102.method2236(var3 - 256).method899()) {
               var1 = true;
            }

            if(var3 >= 512 && !class123.method2743(var3 - 512).method1002(this.field2942)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var8 = new class100[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.field2946[var4];
               class100 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class102.method2236(var5 - 256).method901();
                  if(var6 != null) {
                     var8[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class123.method2743(var5 - 512).method1003(this.field2942);
                  if(var6 != null) {
                     var8[var3++] = var6;
                  }
               }
            }

            class100 var7 = new class100(var8, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2939[var5] < class127.field2060[var5].length) {
                  var7.method2201(class45.field1049[var5], class127.field2060[var5][this.field2939[var5]]);
               }

               if(this.field2939[var5] < field2940[var5].length) {
                  var7.method2201(class135.field2106[var5], field2940[var5][this.field2939[var5]]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1687935882"
   )
   public int method3438() {
      return this.field2941 == -1?(this.field2946[11] << 5) + (this.field2946[8] << 10) + (this.field2939[0] << 25) + (this.field2939[4] << 20) + (this.field2946[0] << 15) + this.field2946[1]:305419896 + class17.method169(this.field2941).field911;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1430831363"
   )
   public void method3441(class119 var1) {
      var1.method2453(this.field2942?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2946[field2945[var2]];
         if(var3 == 0) {
            var1.method2453(-1);
         } else {
            var1.method2453(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2453(this.field2939[var2]);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "1"
   )
   public void method3449(int var1, boolean var2) {
      int var3 = this.field2939[var1];

      boolean var4;
      do {
         ++var3;
         if(var3 >= class127.field2060[var1].length) {
            var3 = 0;
         }

         if(var1 == 4 && var3 >= 8) {
            var4 = false;
         } else {
            var4 = true;
         }
      } while(!var4);

      this.field2939[var1] = var3;
      this.method3435();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   public void method3452(boolean var1) {
      if(var1 != this.field2942) {
         this.method3431((int[])null, this.field2939, var1, -1);
      }
   }
}
