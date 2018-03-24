import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class156 extends class297 {
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "Llk;"
   )
   static IndexedSprite field2117;
   @ObfuscatedName("t")
   final boolean field2119;

   public class156(boolean var1) {
      this.field2119 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)I",
      garbageValue = "-600724840"
   )
   int method3162(ChatPlayer var1, ChatPlayer var2) {
      return var2.rank != var1.rank?(this.field2119?var1.rank - var2.rank:var2.rank - var1.rank):this.method5273(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3162((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
