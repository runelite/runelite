import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("inventoryCache")
   static NodeCache inventoryCache;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static IndexDataBase field3268;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 155725293
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   InvType() {
      this.size = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "-2076147853"
   )
   void method4276(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-736968780"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4276(var1, var2);
      }
   }
}
