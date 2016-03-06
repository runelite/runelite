package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fa")
@Implements("PlayerComposition")
public class class178 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -6425039840716441441L
   )
   long field2913;
   @ObfuscatedName("l")
   @Export("bodyPartColours")
   int[] field2914;
   @ObfuscatedName("j")
   @Export("bodyParts")
   int[] field2915;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -874637635
   )
   public int field2916;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -3023041778308901967L
   )
   long field2917;
   @ObfuscatedName("b")
   public static class192 field2918 = new class192(260);
   @ObfuscatedName("o")
   public static short[] field2919;
   @ObfuscatedName("n")
   public static short[] field2920;
   @ObfuscatedName("r")
   static final int[] field2921 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("a")
   @Export("isFemale")
   public boolean field2922;

   @ObfuscatedName("m")
   void method3432() {
      long var1 = this.field2917;
      int var3 = this.field2915[5];
      int var4 = this.field2915[9];
      this.field2915[5] = var4;
      this.field2915[9] = var3;
      this.field2917 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2917 <<= 4;
         if(this.field2915[var5] >= 256) {
            this.field2917 += (long)(this.field2915[var5] - 256);
         }
      }

      if(this.field2915[0] >= 256) {
         this.field2917 += (long)(this.field2915[0] - 256 >> 4);
      }

      if(this.field2915[1] >= 256) {
         this.field2917 += (long)(this.field2915[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2917 <<= 3;
         this.field2917 += (long)this.field2914[var5];
      }

      this.field2917 <<= 1;
      this.field2917 += (long)(this.field2922?1:0);
      this.field2915[5] = var3;
      this.field2915[9] = var4;
      if(0L != var1 && var1 != this.field2917) {
         field2918.method3712(var1);
      }

   }

   @ObfuscatedName("j")
   public void method3433(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field1032; ++var6) {
               class44 var7 = class114.method2399(var6);
               if(null != var7 && !var7.field1023 && var7.field1027 == var5 + (var3?7:0)) {
                  var1[field2921[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.field2915 = var1;
      this.field2914 = var2;
      this.field2922 = var3;
      this.field2916 = var4;
      this.method3432();
   }

   @ObfuscatedName("a")
   public void method3434(int var1, boolean var2) {
      int var3 = this.field2914[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class133.field2079[var1].length - 1;
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
            if(var3 >= class133.field2079[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.field2914[var1] = var3;
      this.method3432();
   }

   @ObfuscatedName("l")
   public void method3436(int var1, boolean var2) {
      if(1 != var1 || !this.field2922) {
         int var3 = this.field2915[field2921[var1]];
         if(0 != var3) {
            var3 -= 256;

            class44 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class44.field1032 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class44.field1032) {
                     var3 = 0;
                  }
               }

               var4 = class114.method2399(var3);
            } while(var4 == null || var4.field1023 || var4.field1027 != (this.field2922?7:0) + var1);

            this.field2915[field2921[var1]] = 256 + var3;
            this.method3432();
         }
      }
   }

   @ObfuscatedName("o")
   public class104 method3438(class42 var1, int var2, class42 var3, int var4) {
      if(this.field2916 != -1) {
         return class14.method162(this.field2916).method769(var1, var2, var3, var4);
      } else {
         long var5 = this.field2917;
         int[] var7 = this.field2915;
         if(var1 != null && (var1.field994 >= 0 || var1.field1004 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2915[var8];
            }

            if(var1.field994 >= 0) {
               var5 += (long)(var1.field994 - this.field2915[5] << 40);
               var7[5] = var1.field994;
            }

            if(var1.field1004 >= 0) {
               var5 += (long)(var1.field1004 - this.field2915[3] << 48);
               var7[3] = var1.field1004;
            }
         }

         class104 var15 = (class104)field2918.method3711(var5);
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class114.method2399(var11 - 256).method917()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class22.method581(var11 - 512).method1033(this.field2922)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2913 != -1L) {
                  var15 = (class104)field2918.method3711(this.field2913);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               class99[] var17 = new class99[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class99 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class114.method2399(var13 - 256).method918();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class22.method581(var13 - 512).method1075(this.field2922);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class99 var18 = new class99(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2914[var13] < class133.field2079[var13].length) {
                     var18.method2189(field2919[var13], class133.field2079[var13][this.field2914[var13]]);
                  }

                  if(this.field2914[var13] < class52.field1173[var13].length) {
                     var18.method2189(field2920[var13], class52.field1173[var13][this.field2914[var13]]);
                  }
               }

               var15 = var18.method2169(64, 850, -30, -50, -30);
               field2918.method3713(var15, var5);
               this.field2913 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            class104 var16;
            if(var1 != null && var3 != null) {
               var16 = var1.method870(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method866(var15, var2);
            } else {
               var16 = var3.method866(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("h")
   class99 method3439() {
      if(this.field2916 != -1) {
         return class14.method162(this.field2916).method770();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2915[var2];
            if(var3 >= 256 && var3 < 512 && !class114.method2399(var3 - 256).method919()) {
               var1 = true;
            }

            if(var3 >= 512 && !class22.method581(var3 - 512).method1027(this.field2922)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class99[] var7 = new class99[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.field2915[var4];
               class99 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class114.method2399(var5 - 256).method920();
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class22.method581(var5 - 512).method1045(this.field2922);
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }
            }

            class99 var8 = new class99(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2914[var5] < class133.field2079[var5].length) {
                  var8.method2189(field2919[var5], class133.field2079[var5][this.field2914[var5]]);
               }

               if(this.field2914[var5] < class52.field1173[var5].length) {
                  var8.method2189(field2920[var5], class52.field1173[var5][this.field2914[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("i")
   public void method3441(boolean var1) {
      if(this.field2922 != var1) {
         this.method3433((int[])null, this.field2914, var1, -1);
      }
   }

   @ObfuscatedName("n")
   public int method3445() {
      return this.field2916 == -1?this.field2915[1] + (this.field2915[11] << 5) + (this.field2915[0] << 15) + (this.field2914[0] << 25) + (this.field2914[4] << 20) + (this.field2915[8] << 10):305419896 + class14.method162(this.field2916).field896;
   }

   @ObfuscatedName("f")
   public void method3454(class118 var1) {
      var1.method2438(this.field2922?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2915[field2921[var2]];
         if(0 == var3) {
            var1.method2438(-1);
         } else {
            var1.method2438(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2438(this.field2914[var2]);
      }

   }
}
