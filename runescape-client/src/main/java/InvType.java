import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3336;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("inventoryCache")
   public static NodeCache inventoryCache;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1546624351
   )
   static int field3334;
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "Lef;"
   )
   static class148 field3331;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1807433875
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   public InvType() {
      this.size = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfs;B)V",
      garbageValue = "-120"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4252(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "148306162"
   )
   void method4252(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }
}
