import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class40 extends class210 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 125028233
   )
   int field893 = (int)(class193.method3805() / 1000L);
   @ObfuscatedName("w")
   String field894;
   @ObfuscatedName("bq")
   static class171 field895;
   @ObfuscatedName("e")
   short field898;
   @ObfuscatedName("ba")
   static class171 field899;
   @ObfuscatedName("pp")
   public static class139 field900;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2099696177
   )
   public static int field903;

   class40(String var1, int var2) {
      this.field894 = var1;
      this.field898 = (short)var2;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "2020353822"
   )
   static final void method788(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field277 && var0 != class51.field1119) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class5.field91.method2025(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class5.field91.method2007(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class5.field91.method2137(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class5.field91.method2027(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class5.field91.method2028(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            class42 var12;
            if(var1 == 0) {
               class5.field91.method2016(var0, var2, var3);
               var12 = class7.method100(var13);
               if(var12.field959 != 0) {
                  client.field331[var0].method2457(var2, var3, var14, var15, var12.field960);
               }
            }

            if(var1 == 1) {
               class5.field91.method2017(var0, var2, var3);
            }

            if(var1 == 2) {
               class5.field91.method2006(var0, var2, var3);
               var12 = class7.method100(var13);
               if(var2 + var12.field976 > 103 || var3 + var12.field976 > 103 || var2 + var12.field980 > 103 || var12.field980 + var3 > 103) {
                  return;
               }

               if(var12.field959 != 0) {
                  client.field331[var0].method2458(var2, var3, var12.field976, var12.field980, var15, var12.field960);
               }
            }

            if(var1 == 3) {
               class5.field91.method2094(var0, var2, var3);
               var12 = class7.method100(var13);
               if(var12.field959 == 1) {
                  client.field331[var0].method2474(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field78[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class1.method11(var0, var11, var2, var3, var4, var5, var6, class5.field91, client.field331[var0]);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "-88"
   )
   public static int method789(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var6 + var4] = -128;
            } else if(var7 == 8218) {
               var3[var6 + var4] = -126;
            } else if(var7 == 402) {
               var3[var6 + var4] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var4 + var6] = -123;
            } else if(var7 == 8224) {
               var3[var4 + var6] = -122;
            } else if(var7 == 8225) {
               var3[var6 + var4] = -121;
            } else if(var7 == 710) {
               var3[var6 + var4] = -120;
            } else if(var7 == 8240) {
               var3[var6 + var4] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var6 + var4] = -114;
            } else if(var7 == 8216) {
               var3[var6 + var4] = -111;
            } else if(var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if(var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if(var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if(var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if(var7 == 8211) {
               var3[var6 + var4] = -106;
            } else if(var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(var7 == 8482) {
               var3[var4 + var6] = -103;
            } else if(var7 == 353) {
               var3[var6 + var4] = -102;
            } else if(var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if(var7 == 339) {
               var3[var4 + var6] = -100;
            } else if(var7 == 382) {
               var3[var6 + var4] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1256346941"
   )
   static final int method790(int var0, int var1) {
      int var2 = class51.method1080(var0 - 1, var1 - 1) + class51.method1080(1 + var0, var1 - 1) + class51.method1080(var0 - 1, var1 + 1) + class51.method1080(var0 + 1, 1 + var1);
      int var3 = class51.method1080(var0 - 1, var1) + class51.method1080(1 + var0, var1) + class51.method1080(var0, var1 - 1) + class51.method1080(var0, var1 + 1);
      int var4 = class51.method1080(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }
}
