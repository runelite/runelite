import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1418857365
   )
   int field1488;
   @ObfuscatedName("u")
   int[] field1489;
   @ObfuscatedName("h")
   int[][] field1490;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1062062883
   )
   int field1494;
   @ObfuscatedName("rj")
   protected static String field1495;

   FrameMap(int var1, byte[] var2) {
      this.field1494 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1488 = var3.readUnsignedByte();
      this.field1489 = new int[this.field1488];
      this.field1490 = new int[this.field1488][];

      int var4;
      for(var4 = 0; var4 < this.field1488; ++var4) {
         this.field1489[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1488; ++var4) {
         this.field1490[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1488; ++var4) {
         for(int var5 = 0; var5 < this.field1490[var4].length; ++var5) {
            this.field1490[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "35"
   )
   public static boolean method1734(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
