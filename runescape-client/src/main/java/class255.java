import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class255 extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static NodeCache field3410;
   @ObfuscatedName("y")
   public boolean field3411;

   static {
      field3410 = new NodeCache(64);
   }

   public class255() {
      this.field3411 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "-1402643533"
   )
   public void method4514(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4515(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "-1666211037"
   )
   void method4515(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3411 = true;
      }

   }
}
