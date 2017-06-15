import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class243 extends CacheableNode {
   @ObfuscatedName("e")
   public boolean field3320;
   @ObfuscatedName("p")
   public static IndexDataBase field3321;
   @ObfuscatedName("m")
   static NodeCache field3322;
   @ObfuscatedName("kt")
   static class89 field3325;

   class243() {
      this.field3320 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1470307926"
   )
   void method4192(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3320 = true;
      }

   }

   static {
      field3322 = new NodeCache(64);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "34"
   )
   void method4200(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4192(var1, var2);
      }
   }
}
