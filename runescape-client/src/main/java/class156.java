import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class156 extends class297 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("c")
   final boolean field2140;

   public class156(boolean var1) {
      this.field2140 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "-612730371"
   )
   int method3173(ChatPlayer var1, ChatPlayer var2) {
      return var2.rank != var1.rank?(this.field2140?var1.rank - var2.rank:var2.rank - var1.rank):this.method5288(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3173((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
