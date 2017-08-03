import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
public class class243 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static NodeCache field3297;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field3298;
   @ObfuscatedName("x")
   public boolean field3296;

   static {
      field3297 = new NodeCache(64);
   }

   public class243() {
      this.field3296 = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "2067490943"
   )
   void method4293(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3296 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "-111183920"
   )
   public void method4297(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4293(var1, var2);
      }
   }
}
