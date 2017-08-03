import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static NodeCache field3265;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 600511317
   )
   public int field3264;

   static {
      field3265 = new NodeCache(64);
   }

   InvType() {
      this.field3264 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfw;IB)V",
      garbageValue = "43"
   )
   void method4250(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3264 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "-1883446509"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4250(var1, var2);
      }
   }
}
