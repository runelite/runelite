import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("PlayerComposition")
public class class182 {
   @ObfuscatedName("e")
   @Export("bodyParts")
   int[] field2956;
   @ObfuscatedName("c")
   @Export("isFemale")
   public boolean field2957;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -556733649
   )
   public int field2958;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -90503264541207797L
   )
   @Export("hash")
   long field2959;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -8639624028548084765L
   )
   long field2960;
   @ObfuscatedName("i")
   static final int[] field2961 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("l")
   @Export("bodyPartColours")
   int[] field2962;
   @ObfuscatedName("q")
   static class196 field2964 = new class196(260);
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -1568814051
   )
   static int field2965;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-213457573"
   )
   public void method3569(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class46.field1061; ++var6) {
               class46 var7 = class93.method2182(var6);
               if(var7 != null && !var7.field1070 && var5 + (var3?7:0) == var7.field1067) {
                  var1[field2961[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.field2956 = var1;
      this.field2962 = var2;
      this.field2957 = var3;
      this.field2958 = var4;
      this.method3574();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "2113296799"
   )
   public void method3570(int var1, boolean var2) {
      if(var1 != 1 || !this.field2957) {
         int var3 = this.field2956[field2961[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class46 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class46.field1061 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class46.field1061) {
                     var3 = 0;
                  }
               }

               var4 = class93.method2182(var3);
            } while(null == var4 || var4.field1070 || var1 + (this.field2957?7:0) != var4.field1067);

            this.field2956[field2961[var1]] = 256 + var3;
            this.method3574();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-857434316"
   )
   public void method3571(int var1, boolean var2) {
      int var3 = this.field2962[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class40.field916[var1].length - 1;
            }
         } while(!class166.method3314(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class40.field916[var1].length) {
               var3 = 0;
            }
         } while(!class166.method3314(var1, var3));
      }

      this.field2962[var1] = var3;
      this.method3574();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1289342068"
   )
   public void method3572(boolean var1) {
      if(var1 != this.field2957) {
         this.method3569((int[])null, this.field2962, var1, -1);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "14"
   )
   public void method3573(class122 var1) {
      var1.method2795(this.field2957?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2956[field2961[var2]];
         if(var3 == 0) {
            var1.method2795(-1);
         } else {
            var1.method2795(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2795(this.field2962[var2]);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1307584069"
   )
   void method3574() {
      long var1 = this.field2959;
      int var3 = this.field2956[5];
      int var4 = this.field2956[9];
      this.field2956[5] = var4;
      this.field2956[9] = var3;
      this.field2959 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2959 <<= 4;
         if(this.field2956[var5] >= 256) {
            this.field2959 += (long)(this.field2956[var5] - 256);
         }
      }

      if(this.field2956[0] >= 256) {
         this.field2959 += (long)(this.field2956[0] - 256 >> 4);
      }

      if(this.field2956[1] >= 256) {
         this.field2959 += (long)(this.field2956[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2959 <<= 3;
         this.field2959 += (long)this.field2962[var5];
      }

      this.field2959 <<= 1;
      this.field2959 += (long)(this.field2957?1:0);
      this.field2956[5] = var3;
      this.field2956[9] = var4;
      if(0L != var1 && this.field2959 != var1) {
         field2964.method3833(var1);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass103;",
      garbageValue = "-462165808"
   )
   class103 method3575() {
      if(this.field2958 != -1) {
         return class59.method1282(this.field2958).method811();
      } else {
         boolean var1 = false;

         int var3;
         for(int var7 = 0; var7 < 12; ++var7) {
            var3 = this.field2956[var7];
            if(var3 >= 256 && var3 < 512 && !class93.method2182(var3 - 256).method988()) {
               var1 = true;
            }

            if(var3 >= 512 && !class9.method108(var3 - 512).method1172(this.field2957)) {
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
               var5 = this.field2956[var8];
               class103 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class93.method2182(var5 - 256).method987();
                  if(null != var6) {
                     var2[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class9.method108(var5 - 512).method1216(this.field2957);
                  if(null != var6) {
                     var2[var3++] = var6;
                  }
               }
            }

            class103 var4 = new class103(var2, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2962[var5] < class40.field916[var5].length) {
                  var4.method2350(class62.field1287[var5], class40.field916[var5][this.field2962[var5]]);
               }

               if(this.field2962[var5] < class212.field3168[var5].length) {
                  var4.method2350(class157.field2340[var5], class212.field3168[var5][this.field2962[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "74"
   )
   public int method3578() {
      return this.field2958 == -1?(this.field2956[11] << 5) + (this.field2962[0] << 25) + (this.field2962[4] << 20) + (this.field2956[0] << 15) + (this.field2956[8] << 10) + this.field2956[1]:305419896 + class59.method1282(this.field2958).field922;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass44;ILclass44;II)Lclass108;",
      garbageValue = "-1702094541"
   )
   public class108 method3583(class44 var1, int var2, class44 var3, int var4) {
      if(this.field2958 != -1) {
         return class59.method1282(this.field2958).method828(var1, var2, var3, var4);
      } else {
         long var5 = this.field2959;
         int[] var7 = this.field2956;
         if(var1 != null && (var1.field1019 >= 0 || var1.field1032 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2956[var8];
            }

            if(var1.field1019 >= 0) {
               var5 += (long)(var1.field1019 - this.field2956[5] << 40);
               var7[5] = var1.field1019;
            }

            if(var1.field1032 >= 0) {
               var5 += (long)(var1.field1032 - this.field2956[3] << 48);
               var7[3] = var1.field1032;
            }
         }

         class108 var15 = (class108)field2964.method3834(var5);
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var16 = 0; var16 < 12; ++var16) {
               var11 = var7[var16];
               if(var11 >= 256 && var11 < 512 && !class93.method2182(var11 - 256).method986()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class9.method108(var11 - 512).method1170(this.field2957)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2960 != -1L) {
                  var15 = (class108)field2964.method3834(this.field2960);
               }

               if(null == var15) {
                  return null;
               }
            }

            if(var15 == null) {
               class103[] var10 = new class103[12];
               var11 = 0;

               int var13;
               for(int var17 = 0; var17 < 12; ++var17) {
                  var13 = var7[var17];
                  class103 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class93.method2182(var13 - 256).method1013();
                     if(null != var14) {
                        var10[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class9.method108(var13 - 512).method1207(this.field2957);
                     if(var14 != null) {
                        var10[var11++] = var14;
                     }
                  }
               }

               class103 var12 = new class103(var10, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2962[var13] < class40.field916[var13].length) {
                     var12.method2350(class62.field1287[var13], class40.field916[var13][this.field2962[var13]]);
                  }

                  if(this.field2962[var13] < class212.field3168[var13].length) {
                     var12.method2350(class157.field2340[var13], class212.field3168[var13][this.field2962[var13]]);
                  }
               }

               var15 = var12.method2308(64, 850, -30, -50, -30);
               field2964.method3836(var15, var5);
               this.field2960 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            class108 var18;
            if(var1 != null && null != var3) {
               var18 = var1.method932(var15, var2, var3, var4);
            } else if(null != var1) {
               var18 = var1.method919(var15, var2);
            } else {
               var18 = var3.method919(var15, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-23"
   )
   public static void method3600(int var0) {
      class186.field2993 = 1;
      class186.field2998 = null;
      class119.field2041 = -1;
      class145.field2223 = -1;
      class28.field695 = 0;
      class102.field1760 = false;
      class186.field2999 = var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1091155838"
   )
   public static int method3601(int var0) {
      return var0 >> 11 & 63;
   }
}
