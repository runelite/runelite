import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -117809553
   )
   int field2068;
   @ObfuscatedName("e")
   int[] field2069;
   @ObfuscatedName("v")
   int[][] field2070;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 419765755
   )
   int field2071;
   @ObfuscatedName("z")
   static boolean field2072;

   FrameMap(int var1, byte[] var2) {
      this.field2071 = var1;
      Buffer var3 = new Buffer(var2);
      this.field2068 = var3.readUnsignedByte();
      this.field2069 = new int[this.field2068];
      this.field2070 = new int[this.field2068][];

      int var4;
      for(var4 = 0; var4 < this.field2068; ++var4) {
         this.field2069[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field2068; ++var4) {
         this.field2070[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field2068; ++var4) {
         for(int var5 = 0; var5 < this.field2070[var4].length; ++var5) {
            this.field2070[var4][var5] = var3.readUnsignedByte();
         }
      }

   }
}
