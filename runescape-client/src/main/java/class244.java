import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class244 extends CacheableNode {
   @ObfuscatedName("h")
   static NodeCache field3306;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 729986531
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("i")
   static IndexDataBase field3308;
   @ObfuscatedName("u")
   public boolean field3309;

   class244() {
      this.field3309 = false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2064835765"
   )
   void method4392(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4393(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1131790020"
   )
   void method4393(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3309 = true;
      }

   }

   static {
      field3306 = new NodeCache(64);
   }
}
