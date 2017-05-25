import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
public class class241 extends CacheableNode {
   @ObfuscatedName("u")
   public static NodeCache field3270;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1038607875
   )
   public int field3272;
   @ObfuscatedName("i")
   static IndexDataBase field3273;
   @ObfuscatedName("s")
   static Buffer field3274;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-193477370"
   )
   void method4356(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4361(var1, var2);
      }
   }

   class241() {
      this.field3272 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-564434006"
   )
   void method4361(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field3272 = var1.readUnsignedShort();
      }

   }

   static {
      field3270 = new NodeCache(64);
   }
}
