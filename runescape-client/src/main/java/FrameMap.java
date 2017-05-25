import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1746191737
   )
   int field2032;
   @ObfuscatedName("q")
   int[][] field2033;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1845403445
   )
   int field2034;
   @ObfuscatedName("u")
   int[] field2035;

   FrameMap(int var1, byte[] var2) {
      this.field2034 = var1;
      Buffer var3 = new Buffer(var2);
      this.field2032 = var3.readUnsignedByte();
      this.field2035 = new int[this.field2032];
      this.field2033 = new int[this.field2032][];

      int var4;
      for(var4 = 0; var4 < this.field2032; ++var4) {
         this.field2035[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field2032; ++var4) {
         this.field2033[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field2032; ++var4) {
         for(int var5 = 0; var5 < this.field2033[var4].length; ++var5) {
            this.field2033[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2112260142"
   )
   public static boolean method2707(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
