import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1690929427
   )
   int field1481;
   @ObfuscatedName("p")
   int[][] field1482;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1606626979
   )
   int field1483;
   @ObfuscatedName("h")
   int[] field1484;

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "1870363051"
   )
   static Widget method1746(Widget var0) {
      int var2 = class196.method3614(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class179.method3296(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   FrameMap(int var1, byte[] var2) {
      this.field1483 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1481 = var3.readUnsignedByte();
      this.field1484 = new int[this.field1481];
      this.field1482 = new int[this.field1481][];

      int var4;
      for(var4 = 0; var4 < this.field1481; ++var4) {
         this.field1484[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1481; ++var4) {
         this.field1482[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1481; ++var4) {
         for(int var5 = 0; var5 < this.field1482[var4].length; ++var5) {
            this.field1482[var4][var5] = var3.readUnsignedByte();
         }
      }

   }
}
