import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("inventoryCache")
   static NodeCache inventoryCache;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3283;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 934778583
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
      signature = "(Lfg;II)V",
      garbageValue = "1017655659"
   )
   void method4369(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "64"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4369(var1, var2);
      }
   }
}
