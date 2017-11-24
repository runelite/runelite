import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexDataBase field3355;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("inventoryCache")
   static NodeCache inventoryCache;
   @ObfuscatedName("bz")
   static String field3356;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -39910121
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   InvType() {
      this.size = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "-1283666949"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4424(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "2033793817"
   )
   void method4424(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }
}
