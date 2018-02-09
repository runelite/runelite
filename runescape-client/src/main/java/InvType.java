import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 915443269
   )
   static int field3363;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field3366;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("inventoryCache")
   public static NodeCache inventoryCache;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1472057091
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   public InvType() {
      this.size = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-2090494221"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4658(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-2147337409"
   )
   void method4658(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }
}
