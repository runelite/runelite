import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class157 extends class297 {
   @ObfuscatedName("t")
   final boolean field2121;

   public class157(boolean var1) {
      this.field2121 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)I",
      garbageValue = "1766170923"
   )
   int method3167(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2121?var1.method5246().method5420(var2.method5246()):var2.method5246().method5420(var1.method5246())):this.method5273(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3167((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1139030992"
   )
   static String method3168(int var0) {
      return "<img=" + var0 + ">";
   }
}
