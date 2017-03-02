import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class188 extends CacheableNode {
   @ObfuscatedName("pl")
   static GarbageCollectorMXBean field2774;
   @ObfuscatedName("i")
   public boolean field2780 = false;
   @ObfuscatedName("l")
   public static NodeCache field2781 = new NodeCache(64);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2144865049"
   )
   public void method3516(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3517(var1, var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "128"
   )
   void method3517(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2780 = true;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "-20876"
   )
   public static boolean method3518(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }
}
