import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class173 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass178;",
      garbageValue = "-1538210831"
   )
   public static class178 method3177(int var0) {
      class178[] var1 = ItemLayer.method1432();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class178 var3 = var1[var2];
         if(var0 == var3.field2686) {
            return var3;
         }
      }

      return null;
   }
}
