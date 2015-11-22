package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fw")
public class class178 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1944551143
   )
   public int field2898;
   @ObfuscatedName("m")
   int[] field2899;
   @ObfuscatedName("f")
   public boolean field2900;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 739262071523977881L
   )
   long field2902;
   @ObfuscatedName("j")
   int[] field2903;
   @ObfuscatedName("k")
   public static short[][] field2904;
   @ObfuscatedName("s")
   static final int[] field2905 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("w")
   public static class192 field2906 = new class192(260);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 4156603600898585253L
   )
   long field2908;

   @ObfuscatedName("j")
   public void method3537(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field1008; ++var6) {
               class44 var7 = client.method583(var6);
               if(null != var7 && !var7.field1010 && var7.field1011 == (var3?7:0) + var5) {
                  var1[field2905[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.field2903 = var1;
      this.field2899 = var2;
      this.field2900 = var3;
      this.field2898 = var4;
      this.method3542();
   }

   @ObfuscatedName("m")
   public void method3538(int var1, boolean var2) {
      if(1 != var1 || !this.field2900) {
         int var3 = this.field2903[field2905[var1]];
         if(0 != var3) {
            var3 -= 256;

            class44 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class44.field1008 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class44.field1008) {
                     var3 = 0;
                  }
               }

               var4 = client.method583(var3);
            } while(var4 == null || var4.field1010 || var1 + (this.field2900?7:0) != var4.field1011);

            this.field2903[field2905[var1]] = 256 + var3;
            this.method3542();
         }
      }
   }

   @ObfuscatedName("l")
   public void method3540(boolean var1) {
      if(this.field2900 != var1) {
         this.method3537((int[])null, this.field2899, var1, -1);
      }
   }

   @ObfuscatedName("u")
   public void method3541(class118 var1) {
      var1.method2521(this.field2900?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2903[field2905[var2]];
         if(0 == var3) {
            var1.method2521(-1);
         } else {
            var1.method2521(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2521(this.field2899[var2]);
      }

   }

   @ObfuscatedName("a")
   void method3542() {
      long var1 = this.field2902;
      int var3 = this.field2903[5];
      int var4 = this.field2903[9];
      this.field2903[5] = var4;
      this.field2903[9] = var3;
      this.field2902 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2902 <<= 4;
         if(this.field2903[var5] >= 256) {
            this.field2902 += (long)(this.field2903[var5] - 256);
         }
      }

      if(this.field2903[0] >= 256) {
         this.field2902 += (long)(this.field2903[0] - 256 >> 4);
      }

      if(this.field2903[1] >= 256) {
         this.field2902 += (long)(this.field2903[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2902 <<= 3;
         this.field2902 += (long)this.field2899[var5];
      }

      this.field2902 <<= 1;
      this.field2902 += (long)(this.field2900?1:0);
      this.field2903[5] = var3;
      this.field2903[9] = var4;
      if(0L != var1 && this.field2902 != var1) {
         field2906.method3804(var1);
      }

   }

   @ObfuscatedName("h")
   public class104 method3543(class42 var1, int var2, class42 var3, int var4) {
      if(this.field2898 != -1) {
         return class22.method618(this.field2898).method823(var1, var2, var3, var4);
      } else {
         long var5 = this.field2902;
         int[] var7 = this.field2903;
         if(null != var1 && (var1.field981 >= 0 || var1.field982 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2903[var8];
            }

            if(var1.field981 >= 0) {
               var5 += (long)(var1.field981 - this.field2903[5] << 40);
               var7[5] = var1.field981;
            }

            if(var1.field982 >= 0) {
               var5 += (long)(var1.field982 - this.field2903[3] << 48);
               var7[3] = var1.field982;
            }
         }

         class104 var15 = (class104)field2906.method3808(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !client.method583(var11 - 256).method973()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class10.method158(var11 - 512).method1075(this.field2900)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2908) {
                  var15 = (class104)field2906.method3808(this.field2908);
               }

               if(null == var15) {
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
                     var14 = client.method583(var13 - 256).method960();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class10.method158(var13 - 512).method1076(this.field2900);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class99 var18 = new class99(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2899[var13] < class118.field1979[var13].length) {
                     var18.method2298(class9.field154[var13], class118.field1979[var13][this.field2899[var13]]);
                  }

                  if(this.field2899[var13] < field2904[var13].length) {
                     var18.method2298(class45.field1023[var13], field2904[var13][this.field2899[var13]]);
                  }
               }

               var15 = var18.method2247(64, 850, -30, -50, -30);
               field2906.method3805(var15, var5);
               this.field2908 = var5;
            }
         }

         if(null == var1 && var3 == null) {
            return var15;
         } else {
            class104 var16;
            if(var1 != null && var3 != null) {
               var16 = var1.method918(var15, var2, var3, var4);
            } else if(var1 != null) {
               var16 = var1.method905(var15, var2);
            } else {
               var16 = var3.method905(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("f")
   public void method3544(int var1, boolean var2) {
      int var3 = this.field2899[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class118.field1979[var1].length - 1;
            }
         } while(!class72.method1599(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class118.field1979[var1].length) {
               var3 = 0;
            }
         } while(!class72.method1599(var1, var3));
      }

      this.field2899[var1] = var3;
      this.method3542();
   }

   @ObfuscatedName("i")
   class99 method3552() {
      if(this.field2898 != -1) {
         return class22.method618(this.field2898).method812();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2903[var2];
            if(var3 >= 256 && var3 < 512 && !client.method583(var3 - 256).method963()) {
               var1 = true;
            }

            if(var3 >= 512 && !class10.method158(var3 - 512).method1077(this.field2900)) {
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
               var5 = this.field2903[var4];
               class99 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = client.method583(var5 - 256).method964();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class10.method158(var5 - 512).method1096(this.field2900);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            class99 var8 = new class99(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2899[var5] < class118.field1979[var5].length) {
                  var8.method2298(class9.field154[var5], class118.field1979[var5][this.field2899[var5]]);
               }

               if(this.field2899[var5] < field2904[var5].length) {
                  var8.method2298(class45.field1023[var5], field2904[var5][this.field2899[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("t")
   public int method3558() {
      return -1 == this.field2898?(this.field2899[4] << 20) + (this.field2899[0] << 25) + (this.field2903[0] << 15) + (this.field2903[8] << 10) + (this.field2903[11] << 5) + this.field2903[1]:305419896 + class22.method618(this.field2898).field869;
   }
}
