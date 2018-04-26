import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("VarCInt")
public class VarCInt extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static NodeCache field3476;
   @ObfuscatedName("b")
   public boolean field3473;

   static {
      field3476 = new NodeCache(64);
   }

   VarCInt() {
      this.field3473 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "1515624073"
   )
   void method4879(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4876(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;IB)V",
      garbageValue = "1"
   )
   void method4876(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3473 = true;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method4881() {
      Overlay.overlays.reset();
   }
}
