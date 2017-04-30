import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1255956327
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("d")
   static IndexDataBase field2866;
   @ObfuscatedName("c")
   static NodeCache field2867;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1967430679
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 479453047
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-703677951"
   )
   void method3568(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   static {
      field2867 = new NodeCache(64);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "413464348"
   )
   void method3581(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3568(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass121;I)V",
      garbageValue = "1982821861"
   )
   public static void method3582(class121 var0) {
      class209.field3127 = var0;
   }
}
