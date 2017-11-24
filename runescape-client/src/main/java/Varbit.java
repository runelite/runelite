import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("varbit_ref")
   static IndexDataBase varbit_ref;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -654770545
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -843777439
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -111709351
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "918237428"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4579(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "1685092790"
   )
   void method4579(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "255"
   )
   public static void method4577() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }
}
