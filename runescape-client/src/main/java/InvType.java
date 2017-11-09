import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3340;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("inventoryCache")
   static NodeCache inventoryCache;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1864196567
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
      signature = "(Lfv;I)V",
      garbageValue = "1106570618"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4445(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "1148810146"
   )
   void method4445(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }
}
