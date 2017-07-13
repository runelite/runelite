import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("j")
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("a")
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1456592655
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 394851503
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1216375649
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-6"
   )
   void method4369(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "45"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4369(var1, var2);
      }
   }
}
