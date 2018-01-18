import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1848151097
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 208382339
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -759227175
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;B)V",
      garbageValue = "29"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "629019333"
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
