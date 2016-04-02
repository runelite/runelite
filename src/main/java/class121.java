import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class121 {
   @ObfuscatedName("h")
   static byte[][] field1989 = new byte[50][];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1194788587
   )
   static int field1990 = 0;
   @ObfuscatedName("s")
   static byte[][] field1991 = new byte[1000][];
   @ObfuscatedName("p")
   static byte[][] field1992 = new byte[250][];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1396049981
   )
   static int field1993 = 0;
   @ObfuscatedName("pr")
   static short[] field1994;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 179873519
   )
   static int field1995 = 0;
   @ObfuscatedName("ev")
   static class78[] field1997;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1709426712"
   )
   public static void method2747(byte[] var0) {
      class119 var1 = new class119(var0);
      var1.field1976 = var0.length - 2;
      class76.field1359 = var1.method2700();
      class76.field1357 = new int[class76.field1359];
      class84.field1437 = new int[class76.field1359];
      class5.field86 = new int[class76.field1359];
      class76.field1355 = new int[class76.field1359];
      class76.field1352 = new byte[class76.field1359][];
      var1.field1976 = var0.length - 7 - class76.field1359 * 8;
      class76.field1356 = var1.method2700();
      class76.field1354 = var1.method2700();
      int var2 = (var1.method2523() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class76.field1359; ++var3) {
         class76.field1357[var3] = var1.method2700();
      }

      for(var3 = 0; var3 < class76.field1359; ++var3) {
         class84.field1437[var3] = var1.method2700();
      }

      for(var3 = 0; var3 < class76.field1359; ++var3) {
         class5.field86[var3] = var1.method2700();
      }

      for(var3 = 0; var3 < class76.field1359; ++var3) {
         class76.field1355[var3] = var1.method2700();
      }

      var1.field1976 = var0.length - 7 - class76.field1359 * 8 - 3 * (var2 - 1);
      class215.field3152 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class215.field3152[var3] = var1.method2527();
         if(0 == class215.field3152[var3]) {
            class215.field3152[var3] = 1;
         }
      }

      var1.field1976 = 0;

      for(var3 = 0; var3 < class76.field1359; ++var3) {
         int var4 = class5.field86[var3];
         int var5 = class76.field1355[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class76.field1352[var3] = var7;
         int var8 = var1.method2523();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2633();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.method2633();
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   static void method2750(String var0, String var1, String var2) {
      class31.field711 = var0;
      class31.field712 = var1;
      class31.field713 = var2;
   }

   @ObfuscatedName("e")
   static synchronized byte[] method2751(int var0) {
      byte[] var1;
      if(var0 == 100 && field1993 > 0) {
         var1 = field1991[--field1993];
         field1991[field1993] = null;
         return var1;
      } else if(5000 == var0 && field1995 > 0) {
         var1 = field1992[--field1995];
         field1992[field1995] = null;
         return var1;
      } else if(var0 == 30000 && field1990 > 0) {
         var1 = field1989[--field1990];
         field1989[field1990] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
