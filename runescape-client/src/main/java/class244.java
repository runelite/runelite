import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
public class class244 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field3318;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field3320;
   @ObfuscatedName("n")
   public boolean field3321;

   static {
      field3318 = new NodeCache(64);
   }

   class244() {
      this.field3321 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfe;II)V",
      garbageValue = "-712453"
   )
   void method4278(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3321 = true;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfe;B)V",
      garbageValue = "-1"
   )
   void method4272(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4278(var1, var2);
      }
   }
}
