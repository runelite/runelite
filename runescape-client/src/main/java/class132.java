import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public final class class132 {
   @ObfuscatedName("d")
   static int[] field2104;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "-54"
   )
   public static Object method2879(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class128.field2088) {
            try {
               class121 var2 = new class121();
               var2.vmethod2843(var0);
               return var2;
            } catch (Throwable var3) {
               class128.field2088 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)Lclass184;",
      garbageValue = "-1317534235"
   )
   static class184 method2880(class170 var0, int var1) {
      byte[] var2 = var0.method3309(var1);
      return null == var2?null:new class184(var2);
   }
}
