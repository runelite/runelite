import java.awt.Font;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("r")
public class class22 extends class204 {
   @ObfuscatedName("x")
   int[] field597;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -367550875
   )
   int field598;
   @ObfuscatedName("t")
   int[] field599;
   @ObfuscatedName("p")
   String[] field600;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 284533385
   )
   protected static int field601;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 695287519
   )
   int field602;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -167805861
   )
   int field603;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1978793029
   )
   int field604;
   @ObfuscatedName("qg")
   protected static Font field606;
   @ObfuscatedName("w")
   static class193 field607 = new class193(128);
   @ObfuscatedName("bd")
   static class168 field608;

   @ObfuscatedName("w")
   public static class40 method592(int var0) {
      class40 var1 = (class40)class40.field928.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class40.field926.method3335(6, var0);
         var1 = new class40();
         var1.field936 = var0;
         if(null != var2) {
            var1.method823(new class119(var2));
         }

         var1.method822();
         if(var1.field965) {
            var1.field931 = 0;
            var1.field977 = false;
         }

         class40.field928.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   static class78[] method594() {
      class78[] var0 = new class78[class178.field2922];

      for(int var1 = 0; var1 < class178.field2922; ++var1) {
         class78 var2 = var0[var1] = new class78();
         var2.field1401 = class76.field1387;
         var2.field1409 = class76.field1385;
         var2.field1404 = class76.field1392[var1];
         var2.field1405 = class76.field1388[var1];
         var2.field1402 = class76.field1389[var1];
         var2.field1403 = class76.field1390[var1];
         int var3 = var2.field1402 * var2.field1403;
         byte[] var4 = class10.field180[var1];
         var2.field1406 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1406[var5] = class76.field1391[var4[var5] & 255];
         }
      }

      class21.method582();
      return var0;
   }

   @ObfuscatedName("w")
   public static String method596(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && 46 != var4 && var4 != 45 && 42 != var4 && 95 != var4) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class93.method2158(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
