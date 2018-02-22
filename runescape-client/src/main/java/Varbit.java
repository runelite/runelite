import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 902554677
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1912850407
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 221548713
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "-1311099820"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "1618829731"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZZI)Llv;",
      garbageValue = "-1126100091"
   )
   static IndexedSprite method4859(boolean var0, boolean var1) {
      return var0?(var1?Nameable.field3702:class89.field1302):(var1?class40.field504:WorldComparator.field259);
   }
}
