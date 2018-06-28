import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 891453119
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1326445313
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1608300809
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1967383850"
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
      signature = "(Lgy;IB)V",
      garbageValue = "-22"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("a")
   static boolean method4946(long var0) {
      return (int)(var0 >>> 16 & 1L) == 1;
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1750572180"
   )
   static final void method4951() {
      if(class191.soundSystem1 != null) {
         class191.soundSystem1.method2192();
      }

      if(GrandExchangeEvent.soundSystem0 != null) {
         GrandExchangeEvent.soundSystem0.method2192();
      }

   }
}
