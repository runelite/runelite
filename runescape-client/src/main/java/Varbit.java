import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1132565087
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1344468855
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1239467697
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "-2085991396"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4496(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "395008886"
   )
   void method4496(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }
}
