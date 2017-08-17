import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 470707047
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -793452713
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 905451293
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfb;IB)V",
      garbageValue = "-50"
   )
   void method4443(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "1910956176"
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
