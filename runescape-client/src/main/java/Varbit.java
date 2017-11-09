import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("fq")
   static int[] field3438;
   @ObfuscatedName("fp")
   static int[] field3439;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1161268307
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1774287533
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1111708313
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "-1468485951"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4601(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;IB)V",
      garbageValue = "-120"
   )
   void method4601(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }
}
