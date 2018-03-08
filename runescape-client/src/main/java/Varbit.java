import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("varbits")
   static NodeCache varbits;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1683686481
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 569480575
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1273491247
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "-588955908"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;IB)V",
      garbageValue = "9"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }
}
