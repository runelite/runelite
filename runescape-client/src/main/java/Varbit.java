import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("varbit_ref")
   static IndexDataBase varbit_ref;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("varbits")
   static NodeCache varbits;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1193583161
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2092595029
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1544369675
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "1110030908"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4423(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfs;IB)V",
      garbageValue = "-99"
   )
   void method4423(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lij;IB)Lks;",
      garbageValue = "-16"
   )
   public static IndexedSprite method4421(IndexDataBase var0, int var1) {
      byte[] var3 = var0.method4114(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         PendingSpawn.decodeSprite(var3);
         var2 = true;
      }

      return !var2?null:class272.method4852();
   }
}
