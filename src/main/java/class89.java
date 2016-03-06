import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cd")
public class class89 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -2132335616385817669L
   )
   static long field1562;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -1274313311
   )
   public static int field1566;

   @ObfuscatedName("bu")
   static final void method2055(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class149.method3102(var0)) {
         class75.field1381 = null;
         class33.method723(class172.field2757[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class75.field1381 != null) {
            class33.method723(class75.field1381, -1412584499, var1, var2, var3, var4, class6.field131, class19.field279, var7);
            class75.field1381 = null;
         }

      } else {
         if(var7 != -1) {
            client.field493[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field493[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("k")
   static final void method2056() {
      short var0 = 256;
      int var1;
      if(class31.field717 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field717 > 768) {
               class134.field2085[var1] = class21.method575(class4.field75[var1], class28.field674[var1], 1024 - class31.field717);
            } else if(class31.field717 > 256) {
               class134.field2085[var1] = class28.field674[var1];
            } else {
               class134.field2085[var1] = class21.method575(class28.field674[var1], class4.field75[var1], 256 - class31.field717);
            }
         }
      } else if(class31.field707 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field707 > 768) {
               class134.field2085[var1] = class21.method575(class4.field75[var1], class23.field617[var1], 1024 - class31.field707);
            } else if(class31.field707 > 256) {
               class134.field2085[var1] = class23.field617[var1];
            } else {
               class134.field2085[var1] = class21.method575(class23.field617[var1], class4.field75[var1], 256 - class31.field707);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class134.field2085[var1] = class4.field75[var1];
         }
      }

      class79.method1778(class31.field732, 9, 128 + class31.field732, var0 + 7);
      class24.field625.method1744(class31.field732, 0);
      class79.method1769();
      var1 = 0;
      int var2 = class75.field1385.field1400 * 9 + class31.field732;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class31.field716[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class31.field719[var1++];
            if(0 != var7) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class134.field2085[var7];
               var10 = class75.field1385.field1402[var2];
               class75.field1385.field1402[var2++] = (var8 * (var7 & '\uff00') + (var10 & '\uff00') * var9 & 16711680) + ((var10 & 16711935) * var9 + var8 * (var7 & 16711935) & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += class75.field1385.field1400 + var5 - 128;
      }

      class79.method1778(class31.field732 + 765 - 128, 9, class31.field732 + 765, 7 + var0);
      class31.field712.method1744(382 + class31.field732, 0);
      class79.method1769();
      var1 = 0;
      var2 = class31.field732 + class75.field1385.field1400 * 9 + 24 + 637;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class31.field716[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class31.field719[var1++];
            if(0 != var7) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class134.field2085[var7];
               var10 = class75.field1385.field1402[var2];
               class75.field1385.field1402[var2++] = (var8 * (var7 & 16711935) + (var10 & 16711935) * var9 & -16711936) + ((var10 & '\uff00') * var9 + var8 * (var7 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class75.field1385.field1400 - var5 - var4;
      }

   }

   @ObfuscatedName("ck")
   static class172 method2057(class172 var0) {
      class172 var2 = var0;
      int var4 = class42.method898(var0);
      int var3 = var4 >> 17 & 7;
      int var5 = var3;
      class172 var1;
      if(0 == var3) {
         var1 = null;
      } else {
         int var6 = 0;

         while(true) {
            if(var6 >= var5) {
               var1 = var2;
               break;
            }

            var2 = class31.method698(var2.field2778);
            if(var2 == null) {
               var1 = null;
               break;
            }

            ++var6;
         }
      }

      class172 var7 = var1;
      if(var1 == null) {
         var7 = var0.field2843;
      }

      return var7;
   }
}
