import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class188 extends CacheableNode {
   @ObfuscatedName("u")
   public boolean field2794 = false;
   @ObfuscatedName("i")
   public static NodeCache field2795 = new NodeCache(64);
   @ObfuscatedName("f")
   public static IndexDataBase field2797;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-605228415"
   )
   void method3499(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2794 = true;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "91"
   )
   public void method3500(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3499(var1, var2);
      }
   }
}
