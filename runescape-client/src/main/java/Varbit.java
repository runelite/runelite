import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 198184027
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("m")
   public static NodeCache field3389;
   @ObfuscatedName("p")
   public static IndexDataBase field3390;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -934267941
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1356671155
   )
   @Export("configId")
   public int configId;

   static {
      field3389 = new NodeCache(64);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1978931081"
   )
   public void method4296(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4298(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1610225823"
   )
   void method4298(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }
}
