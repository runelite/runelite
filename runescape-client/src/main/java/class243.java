import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class243 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public static NodeCache field3313;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3310;
   @ObfuscatedName("q")
   public boolean field3311;

   static {
      field3313 = new NodeCache(64);
   }

   public class243() {
      this.field3311 = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "1030138405"
   )
   void method4386(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3311 = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "-1931439074"
   )
   public void method4385(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4386(var1, var2);
      }
   }
}
