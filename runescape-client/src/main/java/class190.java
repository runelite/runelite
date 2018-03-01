import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class190 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2063247758"
   )
   public static void method3547(int var0) {
      if(class229.field2694 != 0) {
         class229.field2692 = var0;
      } else {
         class229.field2690.method4305(var0);
      }

   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "236155952"
   )
   static final void method3548() {
      for(int var0 = 0; var0 < Client.npcIndexesCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class171.method3367(var2, var2.composition.field3709);
         }
      }

   }
}
