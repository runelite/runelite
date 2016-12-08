import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("b")
   int[] field1456;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1704882191
   )
   int field1457;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -402745283
   )
   int field1459;
   @ObfuscatedName("g")
   int[][] field1460;
   @ObfuscatedName("k")
   public static short[][] field1461;

   FrameMap(int var1, byte[] var2) {
      this.field1459 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1457 = var3.readUnsignedByte();
      this.field1456 = new int[this.field1457];
      this.field1460 = new int[this.field1457][];

      int var4;
      for(var4 = 0; var4 < this.field1457; ++var4) {
         this.field1456[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1457; ++var4) {
         this.field1460[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1457; ++var4) {
         for(int var5 = 0; var5 < this.field1460[var4].length; ++var5) {
            this.field1460[var4][var5] = var3.readUnsignedByte();
         }
      }

   }
}
