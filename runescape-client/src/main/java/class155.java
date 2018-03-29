import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class155 extends class297 {
   @ObfuscatedName("c")
   final boolean field2138;

   public class155(boolean var1) {
      this.field2138 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;B)I",
      garbageValue = "15"
   )
   int method3165(ChatPlayer var1, ChatPlayer var2) {
      return var2.world != var1.world?(this.field2138?var1.world - var2.world:var2.world - var1.world):this.method5288(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3165((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lhz;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1738562914"
   )
   static String method3172(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }
}
