import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2121938487
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("c")
   public static NodeCache field3379;
   @ObfuscatedName("i")
   public static IndexDataBase field3380;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -618212039
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 503160633
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1344583863"
   )
   public void method4425(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4428(var1, var2);
      }
   }

   static {
      field3379 = new NodeCache(64);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1768518756"
   )
   void method4428(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }
}
