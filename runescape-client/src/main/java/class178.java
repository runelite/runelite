import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class178 {
   @ObfuscatedName("mk")
   static class78 field2911;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass119;IS)Ljava/lang/String;",
      garbageValue = "20476"
   )
   public static String method3498(class119 var0, int var1) {
      try {
         int var2 = var0.method2567();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.field1998 += class222.field3181.method2488(var0.field2000, var0.field1998, var3, 0, var2);
         String var4 = class150.method3165(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
