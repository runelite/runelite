import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class115 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -4785747503223726703L
   )
   static long field1978;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 4464194058692910383L
   )
   static long field1979;
   @ObfuscatedName("dg")
   static byte[][] field1980;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2125870978"
   )
   static final int method2408(int var0, int var1) {
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

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)[Lclass80;",
      garbageValue = "-693864730"
   )
   static class80[] method2409(class167 var0, int var1, int var2) {
      if(!class21.method551(var0, var1, var2)) {
         return null;
      } else {
         class80[] var4 = new class80[class76.field1387];

         for(int var5 = 0; var5 < class76.field1387; ++var5) {
            class80 var6 = var4[var5] = new class80();
            var6.field1426 = class76.field1386;
            var6.field1422 = class76.field1392;
            var6.field1429 = class76.field1388[var5];
            var6.field1427 = class165.field2689[var5];
            var6.field1424 = class76.field1385[var5];
            var6.field1425 = class14.field209[var5];
            var6.field1423 = class14.field213;
            var6.field1428 = class45.field1045[var5];
         }

         class16.method164();
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)Ljava/lang/String;",
      garbageValue = "32767"
   )
   static String method2410(class119 var0, int var1) {
      try {
         int var2 = var0.method2481();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.field2000 += class222.field3185.method2397(var0.field2001, var0.field2000, var3, 0, var2);
         String var4 = class141.method2946(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
