import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("ah")
   static int[] field3383;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 985159855
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -755105553
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1073057617
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfg;IB)V",
      garbageValue = "92"
   )
   void method4521(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "1775628716"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4521(var1, var2);
      }
   }
}
