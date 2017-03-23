import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1798727211
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;
   @ObfuscatedName("i")
   public static NodeCache field2856 = new NodeCache(64);
   @ObfuscatedName("f")
   public static class182 field2857;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 883867267
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1658770173
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1252685300"
   )
   void method3591(Buffer var1, int var2) {
      if(var2 == 1) {
         this.leastSignificantBit = var1.readUnsignedShort();
         this.configId = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-16711936"
   )
   void method3596(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3591(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-90"
   )
   public static void method3598() {
      class115 var0 = class115.mouse;
      synchronized(class115.mouse) {
         class115.field1811 = class115.field1829;
         class115.field1817 = class115.field1814;
         class115.field1818 = class115.field1815;
         class115.field1823 = class115.field1819;
         class115.field1825 = class115.field1820;
         class115.field1813 = class115.field1821;
         class115.field1826 = class115.field1816;
         class115.field1819 = 0;
      }
   }
}
