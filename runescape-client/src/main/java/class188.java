import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class188 extends CacheableNode {
   @ObfuscatedName("d")
   public static NodeCache field2786 = new NodeCache(64);
   @ObfuscatedName("h")
   public boolean field2788 = false;
   @ObfuscatedName("q")
   public static class182 field2789;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "394841320"
   )
   public void method3452(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3458(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1039591520"
   )
   static int method3457(int var0) {
      MessageNode var1 = (MessageNode)class47.field951.method2372((long)var0);
      return null == var1?-1:(class47.field948.field1900 == var1.next?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-88"
   )
   void method3458(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2788 = true;
      }

   }
}
