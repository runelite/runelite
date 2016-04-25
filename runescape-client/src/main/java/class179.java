import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("PlayerComposition")
public class class179 {
   @ObfuscatedName("j")
   @Export("bodyParts")
   int[] field2918;
   @ObfuscatedName("h")
   @Export("bodyPartColours")
   int[] field2919;
   @ObfuscatedName("m")
   @Export("isFemale")
   public boolean field2920;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1214492141
   )
   public int field2921;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 115234132193032119L
   )
   long field2922;
   @ObfuscatedName("u")
   static final int[] field2923 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("i")
   public static short[] field2924;
   @ObfuscatedName("id")
   static class30 field2925;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 2830157425881231801L
   )
   long field2926;
   @ObfuscatedName("r")
   static class193 field2927 = new class193(260);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "896930222"
   )
   public void method3438(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class229.field3232; ++var6) {
               class44 var7 = class134.method2830(var6);
               if(null != var7 && !var7.field1019 && (var3?7:0) + var5 == var7.field1015) {
                  var1[field2923[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.field2918 = var1;
      this.field2919 = var2;
      this.field2920 = var3;
      this.field2921 = var4;
      this.method3443();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "0"
   )
   public void method3439(boolean var1) {
      if(this.field2920 != var1) {
         this.method3438((int[])null, this.field2919, var1, -1);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1"
   )
   public void method3440(int var1, boolean var2) {
      int var3 = this.field2919[var1];

      do {
         ++var3;
         if(var3 >= class89.field1535[var1].length) {
            var3 = 0;
         }
      } while(!class47.method973(var1, var3));

      this.field2919[var1] = var3;
      this.method3443();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "792567714"
   )
   public void method3442(class119 var1) {
      var1.method2503(this.field2920?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2918[field2923[var2]];
         if(var3 == 0) {
            var1.method2503(-1);
         } else {
            var1.method2503(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2503(this.field2919[var2]);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2054553253"
   )
   void method3443() {
      long var1 = this.field2922;
      int var3 = this.field2918[5];
      int var4 = this.field2918[9];
      this.field2918[5] = var4;
      this.field2918[9] = var3;
      this.field2922 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2922 <<= 4;
         if(this.field2918[var5] >= 256) {
            this.field2922 += (long)(this.field2918[var5] - 256);
         }
      }

      if(this.field2918[0] >= 256) {
         this.field2922 += (long)(this.field2918[0] - 256 >> 4);
      }

      if(this.field2918[1] >= 256) {
         this.field2922 += (long)(this.field2918[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2922 <<= 3;
         this.field2922 += (long)this.field2919[var5];
      }

      this.field2922 <<= 1;
      this.field2922 += (long)(this.field2920?1:0);
      this.field2918[5] = var3;
      this.field2918[9] = var4;
      if(0L != var1 && var1 != this.field2922) {
         field2927.method3709(var1);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;II)Lclass105;",
      garbageValue = "-2045542521"
   )
   public class105 method3444(class42 var1, int var2, class42 var3, int var4) {
      if(this.field2921 != -1) {
         return class156.method3130(this.field2921).method755(var1, var2, var3, var4);
      } else {
         long var5 = this.field2922;
         int[] var7 = this.field2918;
         if(var1 != null && (var1.field981 >= 0 || var1.field979 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2918[var8];
            }

            if(var1.field981 >= 0) {
               var5 += (long)(var1.field981 - this.field2918[5] << 40);
               var7[5] = var1.field981;
            }

            if(var1.field979 >= 0) {
               var5 += (long)(var1.field979 - this.field2918[3] << 48);
               var7[3] = var1.field979;
            }
         }

         class105 var15 = (class105)field2927.method3704(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class134.method2830(var11 - 256).method905()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class89.method2081(var11 - 512).method1027(this.field2920)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2926) {
                  var15 = (class105)field2927.method3704(this.field2926);
               }

               if(null == var15) {
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
                     var14 = class134.method2830(var13 - 256).method906();
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class89.method2081(var13 - 512).method1021(this.field2920);
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class100 var18 = new class100(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2919[var13] < class89.field1535[var13].length) {
                     var18.method2202(field2924[var13], class89.field1535[var13][this.field2919[var13]]);
                  }

                  if(this.field2919[var13] < class35.field767[var13].length) {
                     var18.method2202(class90.field1545[var13], class35.field767[var13][this.field2919[var13]]);
                  }
               }

               var15 = var18.method2218(64, 850, -30, -50, -30);
               field2927.method3706(var15, var5);
               this.field2926 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            class105 var16;
            if(var1 != null && var3 != null) {
               var16 = var1.method856(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method858(var15, var2);
            } else {
               var16 = var3.method858(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   public static void method3445() {
      class51.field1092.method3707();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "237818912"
   )
   public int method3446() {
      return this.field2921 == -1?this.field2918[1] + (this.field2918[11] << 5) + (this.field2918[8] << 10) + (this.field2919[0] << 25) + (this.field2919[4] << 20) + (this.field2918[0] << 15):305419896 + class156.method3130(this.field2921).field898;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "1"
   )
   public void method3456(int var1, boolean var2) {
      if(var1 != 1 || !this.field2920) {
         int var3 = this.field2918[field2923[var1]];
         if(0 != var3) {
            var3 -= 256;

            class44 var4;
            do {
               ++var3;
               if(var3 >= class229.field3232) {
                  var3 = 0;
               }

               var4 = class134.method2830(var3);
            } while(null == var4 || var4.field1019 || var1 + (this.field2920?7:0) != var4.field1015);

            this.field2918[field2923[var1]] = var3 + 256;
            this.method3443();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "44"
   )
   class100 method3458() {
      if(this.field2921 != -1) {
         return class156.method3130(this.field2921).method758();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2918[var2];
            if(var3 >= 256 && var3 < 512 && !class134.method2830(var3 - 256).method907()) {
               var1 = true;
            }

            if(var3 >= 512 && !class89.method2081(var3 - 512).method1060(this.field2920)) {
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
               var5 = this.field2918[var4];
               class100 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class134.method2830(var5 - 256).method912();
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class89.method2081(var5 - 512).method1030(this.field2920);
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }
            }

            class100 var8 = new class100(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2919[var5] < class89.field1535[var5].length) {
                  var8.method2202(field2924[var5], class89.field1535[var5][this.field2919[var5]]);
               }

               if(this.field2919[var5] < class35.field767[var5].length) {
                  var8.method2202(class90.field1545[var5], class35.field767[var5][this.field2919[var5]]);
               }
            }

            return var8;
         }
      }
   }
}
