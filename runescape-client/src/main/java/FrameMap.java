import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -979696289
   )
   static int field1960;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1871317659
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 160060337
   )
   @Export("count")
   int count;
   @ObfuscatedName("n")
   @Export("types")
   int[] types;
   @ObfuscatedName("r")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }
}
