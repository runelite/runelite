import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("g")
public class class14 {
   @ObfuscatedName("j")
   class22 field212;
   @ObfuscatedName("i")
   String[] field214;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1738076241
   )
   int field216 = -1;
   @ObfuscatedName("a")
   int[] field220;

   @ObfuscatedName("ak")
   static final void method160() {
      int var0 = 64 + class7.field135 * 128;
      int var1 = 64 + class108.field1910 * 128;
      int var2 = class105.method2335(var0, var1, class75.field1386) - class59.field1220;
      if(class142.field2197 < var0) {
         class142.field2197 += (var0 - class142.field2197) * class218.field3163 / 1000 + class115.field1977;
         if(class142.field2197 > var0) {
            class142.field2197 = var0;
         }
      }

      if(class142.field2197 > var0) {
         class142.field2197 -= (class142.field2197 - var0) * class218.field3163 / 1000 + class115.field1977;
         if(class142.field2197 < var0) {
            class142.field2197 = var0;
         }
      }

      if(class36.field797 < var2) {
         class36.field797 += class115.field1977 + (var2 - class36.field797) * class218.field3163 / 1000;
         if(class36.field797 > var2) {
            class36.field797 = var2;
         }
      }

      if(class36.field797 > var2) {
         class36.field797 -= class218.field3163 * (class36.field797 - var2) / 1000 + class115.field1977;
         if(class36.field797 < var2) {
            class36.field797 = var2;
         }
      }

      if(class147.field2228 < var1) {
         class147.field2228 += class218.field3163 * (var1 - class147.field2228) / 1000 + class115.field1977;
         if(class147.field2228 > var1) {
            class147.field2228 = var1;
         }
      }

      if(class147.field2228 > var1) {
         class147.field2228 -= class218.field3163 * (class147.field2228 - var1) / 1000 + class115.field1977;
         if(class147.field2228 < var1) {
            class147.field2228 = var1;
         }
      }

      var0 = 64 + class101.field1769 * 128;
      var1 = 64 + class50.field1102 * 128;
      var2 = class105.method2335(var0, var1, class75.field1386) - class105.field1883;
      int var3 = var0 - class142.field2197;
      int var4 = var2 - class36.field797;
      int var5 = var1 - class147.field2228;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(client.field556 < var7) {
         client.field556 += class16.field233 * (var7 - client.field556) / 1000 + class22.field597;
         if(client.field556 > var7) {
            client.field556 = var7;
         }
      }

      if(client.field556 > var7) {
         client.field556 -= class22.field597 + class16.field233 * (client.field556 - var7) / 1000;
         if(client.field556 < var7) {
            client.field556 = var7;
         }
      }

      int var9 = var8 - class74.field1371;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class74.field1371 += class22.field597 + var9 * class16.field233 / 1000;
         class74.field1371 &= 2047;
      }

      if(var9 < 0) {
         class74.field1371 -= class22.field597 + class16.field233 * -var9 / 1000;
         class74.field1371 &= 2047;
      }

      int var10 = var8 - class74.field1371;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class74.field1371 = var8;
      }

   }

   @ObfuscatedName("q")
   static final int method161(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("l")
   public static class39 method162(int var0) {
      class39 var1 = (class39)class39.field879.method3711((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class39.field913.method3214(9, var0);
         var1 = new class39();
         var1.field896 = var0;
         if(null != var2) {
            var1.method774(new class118(var2));
         }

         var1.method766();
         class39.field879.method3713(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   public static void method163(class166 var0, class166 var1) {
      class39.field913 = var0;
      class39.field880 = var1;
   }

   @ObfuscatedName("ax")
   static void method164(class2 var0, int var1, int var2) {
      if(var0.field820 == var1 && -1 != var1) {
         int var3 = class36.method741(var1).field990;
         if(1 == var3) {
            var0.field827 = 0;
            var0.field837 = 0;
            var0.field844 = var2;
            var0.field845 = 0;
         }

         if(var3 == 2) {
            var0.field845 = 0;
         }
      } else if(var1 == -1 || var0.field820 == -1 || class36.method741(var1).field993 >= class36.method741(var0.field820).field993) {
         var0.field820 = var1;
         var0.field827 = 0;
         var0.field837 = 0;
         var0.field844 = var2;
         var0.field845 = 0;
         var0.field868 = var0.field824;
      }

   }

   @ObfuscatedName("g")
   static final boolean method165(int var0, int var1) {
      class40 var2 = class48.method996(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method822(var1);
   }
}
