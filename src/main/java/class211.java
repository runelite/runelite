import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class211 {
   @ObfuscatedName("j")
   static class202 field3140 = new class202();

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-127"
   )
   static final void method3905(int var0) {
      if(class107.method2374(var0)) {
         class173[] var1 = class173.field2735[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class173 var3 = var1[var2];
            if(var3 != null) {
               var3.field2866 = 0;
               var3.field2867 = 0;
            }
         }

      }
   }
}
