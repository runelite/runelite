import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public class class254 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   static IndexDataBase field3400;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field3399;
   @ObfuscatedName("m")
   public boolean field3398;

   static {
      field3399 = new NodeCache(64);
   }

   class254() {
      this.field3398 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "364659138"
   )
   void method4718(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4709(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "2138285681"
   )
   void method4709(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3398 = true;
      }

   }
}
