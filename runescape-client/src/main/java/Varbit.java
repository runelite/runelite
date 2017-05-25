import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2120197371
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1482733855
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2111894343
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;
   @ObfuscatedName("b")
   static class112 field3377;
   @ObfuscatedName("h")
   public static NodeCache field3378;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 1256370663
   )
   static int field3379;
   @ObfuscatedName("v")
   public static IndexDataBase field3380;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-74106318"
   )
   void method4484(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2093500171"
   )
   void method4485(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4484(var1, var2);
      }
   }

   static {
      field3378 = new NodeCache(64);
   }
}
