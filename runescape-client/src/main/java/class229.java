import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public final class class229 {
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -453035021
   )
   static int field3149;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1737578803"
   )
   public static void method4093() {
      class270.field3666 = null;
      class286.offsetsY = null;
      class286.field3778 = null;
      class286.field3782 = null;
      class286.field3783 = null;
      class177.spritePixels = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-93"
   )
   public static void method4094() {
      Object var0 = class236.field3213;
      synchronized(class236.field3213) {
         if(class236.field3216 != 0) {
            class236.field3216 = 1;

            try {
               class236.field3213.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }
}
