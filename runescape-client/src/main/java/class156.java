import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class156 extends class297 {
   @ObfuscatedName("g")
   final boolean field2132;

   public class156(boolean var1) {
      this.field2132 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "505142966"
   )
   int method3241(ChatPlayer var1, ChatPlayer var2) {
      return var2.rank != var1.rank?(this.field2132?var1.rank - var2.rank:var2.rank - var1.rank):this.method5341(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3241((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
