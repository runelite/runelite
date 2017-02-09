import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class151 {
   @ObfuscatedName("k")
   static class182 field2186;

   class151() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("y")
   public static String method2837(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3075[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "-473356460"
   )
   public static class196 method2847(int var0) {
      class196 var1 = (class196)class196.field2857.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class196.field2871.getConfigData(32, var0);
         var1 = new class196();
         if(var2 != null) {
            var1.method3580(new Buffer(var2));
         }

         class196.field2857.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "17"
   )
   public static void method2849() {
      Widget.field2043.reset();
      Widget.field2044.reset();
      Widget.field2045.reset();
      Widget.field2046.reset();
   }
}
