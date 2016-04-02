import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class59 {
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 350101897
   )
   static int field1185;
   @ObfuscatedName("f")
   class196 field1186 = new class196(256);
   @ObfuscatedName("s")
   class196 field1187 = new class196(256);
   @ObfuscatedName("e")
   class167 field1188;
   @ObfuscatedName("by")
   static class168 field1189;
   @ObfuscatedName("w")
   class167 field1192;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -1030187143
   )
   static int field1193;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-3"
   )
   public static void method1253(class119 var0, int var1) {
      if(class149.field2232 != null) {
         try {
            class149.field2232.method4135(0L);
            class149.field2232.method4137(var0.field1980, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("w")
   class62 method1254(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1187.method3788(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1186.method3788(var5);
         if(null == var8) {
            var8 = class70.method1531(this.field1192, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1186.method3789(var8, var5);
         }

         var7 = var8.method1541(var3);
         if(null == var7) {
            return null;
         } else {
            var8.method3913();
            this.field1187.method3789(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   public class62 method1255(int var1, int[] var2) {
      if(this.field1188.method3257() == 1) {
         return this.method1261(0, var1, var2);
      } else if(this.field1188.method3307(var1) == 1) {
         return this.method1261(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   public class62 method1256(int var1, int[] var2) {
      if(this.field1192.method3257() == 1) {
         return this.method1254(0, var1, var2);
      } else if(this.field1192.method3307(var1) == 1) {
         return this.method1254(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class59(class167 var1, class167 var2) {
      this.field1188 = var1;
      this.field1192 = var2;
   }

   @ObfuscatedName("i")
   static final int method1259(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
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

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lclass37;II)V",
      garbageValue = "945124673"
   )
   static final void method1260(class37 var0) {
      if(var0.field833 > client.field289) {
         class4.method47(var0);
      } else if(var0.field820 >= client.field289) {
         class3.method43(var0);
      } else {
         class19.method223(var0);
      }

      if(var0.field804 < 128 || var0.field814 < 128 || var0.field804 >= 13184 || var0.field814 >= 13184) {
         var0.field819 = -1;
         var0.field824 = -1;
         var0.field833 = 0;
         var0.field820 = 0;
         var0.field804 = var0.field842[0] * 128 + var0.field792 * 64;
         var0.field814 = 128 * var0.field843[0] + var0.field792 * 64;
         var0.method747();
      }

      if(var0 == class20.field572 && (var0.field804 < 1536 || var0.field814 < 1536 || var0.field804 >= 11776 || var0.field814 >= 11776)) {
         var0.field819 = -1;
         var0.field824 = -1;
         var0.field833 = 0;
         var0.field820 = 0;
         var0.field804 = 128 * var0.field842[0] + var0.field792 * 64;
         var0.field814 = var0.field843[0] * 128 + var0.field792 * 64;
         var0.method747();
      }

      class153.method3158(var0);
      var0.field791 = false;
      class42 var1;
      if(-1 != var0.field838) {
         var1 = class46.method974(var0.field838);
         if(null != var1 && var1.field975 != null) {
            ++var0.field825;
            if(var0.field839 < var1.field975.length && var0.field825 > var1.field968[var0.field839]) {
               var0.field825 = 1;
               ++var0.field839;
               class0.method4(var1, var0.field839, var0.field804, var0.field814);
            }

            if(var0.field839 >= var1.field975.length) {
               var0.field825 = 0;
               var0.field839 = 0;
               class0.method4(var1, var0.field839, var0.field804, var0.field814);
            }
         } else {
            var0.field838 = -1;
         }
      }

      if(var0.field824 != -1 && client.field289 >= var0.field827) {
         if(var0.field817 < 0) {
            var0.field817 = 0;
         }

         int var3 = class82.method1906(var0.field824).field988;
         if(var3 != -1) {
            class42 var2 = class46.method974(var3);
            if(var2 != null && null != var2.field975) {
               ++var0.field826;
               if(var0.field817 < var2.field975.length && var0.field826 > var2.field968[var0.field817]) {
                  var0.field826 = 1;
                  ++var0.field817;
                  class0.method4(var2, var0.field817, var0.field804, var0.field814);
               }

               if(var0.field817 >= var2.field975.length && (var0.field817 < 0 || var0.field817 >= var2.field975.length)) {
                  var0.field824 = -1;
               }
            } else {
               var0.field824 = -1;
            }
         } else {
            var0.field824 = -1;
         }
      }

      if(var0.field819 != -1 && var0.field822 <= 1) {
         var1 = class46.method974(var0.field819);
         if(1 == var1.field977 && var0.field811 > 0 && var0.field833 <= client.field289 && var0.field820 < client.field289) {
            var0.field822 = 1;
            return;
         }
      }

      if(var0.field819 != -1 && var0.field822 == 0) {
         var1 = class46.method974(var0.field819);
         if(null != var1 && null != var1.field975) {
            ++var0.field821;
            if(var0.field789 < var1.field975.length && var0.field821 > var1.field968[var0.field789]) {
               var0.field821 = 1;
               ++var0.field789;
               class0.method4(var1, var0.field789, var0.field804, var0.field814);
            }

            if(var0.field789 >= var1.field975.length) {
               var0.field789 -= var1.field965;
               ++var0.field823;
               if(var0.field823 >= var1.field976) {
                  var0.field819 = -1;
               } else if(var0.field789 >= 0 && var0.field789 < var1.field975.length) {
                  class0.method4(var1, var0.field789, var0.field804, var0.field814);
               } else {
                  var0.field819 = -1;
               }
            }

            var0.field791 = var1.field979;
         } else {
            var0.field819 = -1;
         }
      }

      if(var0.field822 > 0) {
         --var0.field822;
      }

   }

   @ObfuscatedName("e")
   class62 method1261(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1187.method3788(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1244(this.field1188, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1246();
            this.field1187.method3789(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1203.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   public static class153[] method1262() {
      return new class153[]{class153.field2270, class153.field2269, class153.field2265, class153.field2266};
   }

   @ObfuscatedName("bo")
   static final int method1263(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && 2 == (class5.field80[1][var3][var4] & 2)) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class5.field90[var5][var3][var4] * (128 - var6) + var6 * class5.field90[var5][1 + var3][var4] >> 7;
         int var9 = class5.field90[var5][var3][1 + var4] * (128 - var6) + class5.field90[var5][var3 + 1][1 + var4] * var6 >> 7;
         return (128 - var7) * var8 + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("f")
   public static boolean method1264(int var0) {
      return 0 != (var0 >> 20 & 1);
   }

   @ObfuscatedName("s")
   public static boolean method1265(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
