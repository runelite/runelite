import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
public class class244 extends CacheableNode {
   @ObfuscatedName("e")
   public boolean field3326;
   @ObfuscatedName("m")
   public static NodeCache field3328;

   static {
      field3328 = new NodeCache(64);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-305059761"
   )
   public void method4201(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4202(var1, var2);
      }
   }

   public class244() {
      this.field3326 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-37"
   )
   void method4202(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3326 = true;
      }

   }
}
