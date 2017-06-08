import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class240 extends CacheableNode {
   @ObfuscatedName("n")
   public static IndexDataBase field3283;
   @ObfuscatedName("p")
   static NodeCache field3284;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1104678105
   )
   public int field3285;

   class240() {
      this.field3285 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1464379269"
   )
   void method4291(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4294(var1, var2);
      }
   }

   static {
      field3284 = new NodeCache(64);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-704311108"
   )
   void method4294(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3285 = var1.readUnsignedShort();
      }

   }
}
