import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class157 extends class297 {
   @ObfuscatedName("o")
   final boolean field2168;

   public class157(boolean var1) {
      this.field2168 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "-41816309"
   )
   int method3177(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2168?var1.method5271().compareCleanName(var2.method5271()):var2.method5271().compareCleanName(var1.method5271())):this.method5282(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3177((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
