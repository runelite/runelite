import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class156 {
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 1148430825
   )
   @Export("cameraPitch")
   static int field2286;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -1280894771
   )
   @Export("menuWidth")
   static int field2288;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "-690519864"
   )
   public static String method3177(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return null == var3?"null":var3.toString();
      } else {
         int var10 = var2 + var1;
         int var4 = 0;

         for(int var8 = var1; var8 < var10; ++var8) {
            CharSequence var6 = var0[var8];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var9 = var1; var9 < var10; ++var9) {
            CharSequence var7 = var0[var9];
            if(null == var7) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)[Lclass78;",
      garbageValue = "12"
   )
   static class78[] method3178() {
      class78[] var0 = new class78[class76.field1361];

      for(int var1 = 0; var1 < class76.field1361; ++var1) {
         class78 var2 = var0[var1] = new class78();
         var2.field1370 = class109.field1890;
         var2.field1372 = class76.field1351;
         var2.field1369 = class76.field1353[var1];
         var2.field1373 = class131.field2048[var1];
         var2.field1374 = class76.field1354[var1];
         var2.field1371 = class28.field674[var1];
         int var3 = var2.field1374 * var2.field1371;
         byte[] var4 = class76.field1355[var1];
         var2.field1380 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1380[var5] = class8.field135[var4[var5] & 255];
         }
      }

      class7.method95();
      return var0;
   }
}
