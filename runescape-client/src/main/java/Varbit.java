import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("y")
   public static NodeCache field2830 = new NodeCache(64);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2112841095
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 623992719
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 1652054623
   )
   static int field2835;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1554122999
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1711477390"
   )
   void method3534(Buffer var1, int var2) {
      if(var2 == 1) {
         this.leastSignificantBit = var1.readUnsignedShort();
         this.configId = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "239569453"
   )
   void method3537(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3534(var1, var2);
      }
   }
}
