import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cn")
public class class90 {
   @ObfuscatedName("z")
   static class80 field1566;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -169559129
   )
   static int field1567;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -818735329
   )
   protected static int field1568;

   @ObfuscatedName("e")
   static int method2078(class25 var0, class25 var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class38.method782(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class38.method782(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("ds")
   static class173 method2079(class173 var0) {
      int var2 = class169.method3395(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(0 == var1) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class52.method1115(var0.field2786);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("w")
   public static String method2080(byte[] var0) {
      return class119.method2609(var0, 0, var0.length);
   }
}
