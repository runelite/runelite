import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class255 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   public static IndexDataBase field3405;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static NodeCache field3403;
   @ObfuscatedName("e")
   public boolean field3404;

   static {
      field3403 = new NodeCache(64);
   }

   public class255() {
      this.field3404 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "849384138"
   )
   public void method4470(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4471(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "1255619838"
   )
   void method4471(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3404 = true;
      }

   }
}
