package net.runelite.rs.client;

import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("w")
public class class11 {
   @ObfuscatedName("p")
   static String field165;
   @ObfuscatedName("m")
   static final class197 field166 = new class197(1024);
   @ObfuscatedName("l")
   static int field167 = 0;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 1926067081
   )
   static int field169;
   @ObfuscatedName("ch")
   static class142 field170;
   @ObfuscatedName("j")
   static final Map field171 = new HashMap();
   @ObfuscatedName("f")
   static final class199 field172 = new class199();

   @ObfuscatedName("k")
   static final void method160() {
      short var0 = 256;
      int var1;
      if(class31.field697 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field697 > 768) {
               class31.field699[var1] = class86.method2098(class105.field1841[var1], class147.field2210[var1], 1024 - class31.field697);
            } else if(class31.field697 > 256) {
               class31.field699[var1] = class147.field2210[var1];
            } else {
               class31.field699[var1] = class86.method2098(class147.field2210[var1], class105.field1841[var1], 256 - class31.field697);
            }
         }
      } else if(class31.field702 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field702 > 768) {
               class31.field699[var1] = class86.method2098(class105.field1841[var1], class31.field703[var1], 1024 - class31.field702);
            } else if(class31.field702 > 256) {
               class31.field699[var1] = class31.field703[var1];
            } else {
               class31.field699[var1] = class86.method2098(class31.field703[var1], class105.field1841[var1], 256 - class31.field702);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class31.field699[var1] = class105.field1841[var1];
         }
      }

      class79.method1816(class31.field691, 9, class31.field691 + 128, 7 + var0);
      class150.field2240.method1728(class31.field691, 0);
      class79.method1875();
      var1 = 0;
      int var2 = class84.field1440.field1381 * 9 + class31.field691;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class31.field698[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class86.field1514[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class31.field699[var7];
               var10 = class84.field1440.field1387[var2];
               class84.field1440.field1387[var2++] = ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) + (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += class84.field1440.field1381 + var5 - 128;
      }

      class79.method1816(765 + class31.field691 - 128, 9, 765 + class31.field691, 7 + var0);
      class31.field693.method1728(382 + class31.field691, 0);
      class79.method1875();
      var1 = 0;
      var2 = class31.field691 + class84.field1440.field1381 * 9 + 24 + 637;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class31.field698[var3] / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class86.field1514[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class31.field699[var7];
               var10 = class84.field1440.field1387[var2];
               class84.field1440.field1387[var2++] = (var9 * (var10 & 16711935) + (var7 & 16711935) * var8 & -16711936) + (var8 * (var7 & '\uff00') + (var10 & '\uff00') * var9 & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class84.field1440.field1381 - var5 - var4;
      }

   }

   @ObfuscatedName("l")
   public static final boolean method180() {
      class136 var0 = class136.field2100;
      synchronized(class136.field2100) {
         if(class136.field2109 == class136.field2111) {
            return false;
         } else {
            class136.field2095 = class136.field2091[class136.field2109];
            class14.field208 = class136.field2113[class136.field2109];
            class136.field2109 = 1 + class136.field2109 & 127;
            return true;
         }
      }
   }
}
