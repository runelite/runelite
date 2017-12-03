import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class254 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   public static IndexDataBase field3400;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static NodeCache field3401;
   @ObfuscatedName("e")
   public boolean field3402;

   static {
      field3401 = new NodeCache(64);
   }

   public class254() {
      this.field3402 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;B)V",
      garbageValue = "-82"
   )
   public void method4463(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4461(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "-1543158015"
   )
   void method4461(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3402 = true;
      }

   }
}
