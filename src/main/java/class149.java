import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class149 {
   @ObfuscatedName("z")
   public static class228 field2252 = null;
   @ObfuscatedName("e")
   public static File field2255;
   @ObfuscatedName("p")
   static File field2259;
   @ObfuscatedName("s")
   public static class228 field2260 = null;
   @ObfuscatedName("j")
   public static class228 field2261 = null;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1865809729
   )
   public static int field2262;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -901711805
   )
   public static int field2263;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "36"
   )
   static void method3145(byte[] var0) {
      class119 var1 = new class119(var0);
      var1.field2011 = var0.length - 2;
      class178.field2922 = var1.method2508();
      class76.field1392 = new int[class178.field2922];
      class76.field1388 = new int[class178.field2922];
      class76.field1389 = new int[class178.field2922];
      class76.field1390 = new int[class178.field2922];
      class10.field180 = new byte[class178.field2922][];
      var1.field2011 = var0.length - 7 - class178.field2922 * 8;
      class76.field1387 = var1.method2508();
      class76.field1385 = var1.method2508();
      int var2 = (var1.method2506() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class178.field2922; ++var3) {
         class76.field1392[var3] = var1.method2508();
      }

      for(var3 = 0; var3 < class178.field2922; ++var3) {
         class76.field1388[var3] = var1.method2508();
      }

      for(var3 = 0; var3 < class178.field2922; ++var3) {
         class76.field1389[var3] = var1.method2508();
      }

      for(var3 = 0; var3 < class178.field2922; ++var3) {
         class76.field1390[var3] = var1.method2508();
      }

      var1.field2011 = var0.length - 7 - class178.field2922 * 8 - (var2 - 1) * 3;
      class76.field1391 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class76.field1391[var3] = var1.method2510();
         if(0 == class76.field1391[var3]) {
            class76.field1391[var3] = 1;
         }
      }

      var1.field2011 = 0;

      for(var3 = 0; var3 < class178.field2922; ++var3) {
         int var4 = class76.field1389[var3];
         int var5 = class76.field1390[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class10.field180[var3] = var7;
         int var8 = var1.method2506();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2524();
            }
         } else if(1 == var8) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.method2524();
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)Z",
      garbageValue = "1"
   )
   public static boolean method3169(CharSequence var0, int var1) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6);
         if(var6 == 0) {
            if(var7 == 45) {
               var2 = true;
               continue;
            }

            if(43 == var7) {
               continue;
            }
         }

         int var9;
         if(var7 >= 48 && var7 <= 57) {
            var9 = var7 - 48;
         } else if(var7 >= 65 && var7 <= 90) {
            var9 = var7 - 55;
         } else {
            if(var7 < 97 || var7 > 122) {
               return false;
            }

            var9 = var7 - 87;
         }

         if(var9 >= var1) {
            return false;
         }

         if(var2) {
            var9 = -var9;
         }

         int var8 = var4 * var1 + var9;
         if(var4 != var8 / var1) {
            return false;
         }

         var4 = var8;
         var3 = true;
      }

      return var3;
   }
}
