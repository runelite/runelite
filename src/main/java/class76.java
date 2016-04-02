import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public class class76 {
   @ObfuscatedName("r")
   public static byte[][] field1352;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1113984157
   )
   public static int field1354;
   @ObfuscatedName("g")
   public static int[] field1355;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1304508253
   )
   public static int field1356;
   @ObfuscatedName("s")
   public static int[] field1357;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1039882807
   )
   static int field1359;

   @ObfuscatedName("f")
   public static String method1672(class119 var0, int var1) {
      try {
         int var2 = var0.method2536();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.field1976 += class222.field3180.method2453(var0.field1980, var0.field1976, var3, 0, var2);
         String var4 = class87.method2094(var3, 0, var2);
         return var4;
      } catch (Exception var5) {
         return "Cabbage";
      }
   }
}
