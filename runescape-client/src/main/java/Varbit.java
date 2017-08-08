import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1284096809
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1680383001
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1085653157
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "2016255471"
   )
   void method4443(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "644844778"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4443(var1, var2);
      }
   }
}
