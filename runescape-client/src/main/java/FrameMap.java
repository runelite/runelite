import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2028777703
   )
   int field1459;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 992907279
   )
   int field1461;
   @ObfuscatedName("h")
   int[][] field1462;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 370804373
   )
   static int field1464;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2073197053
   )
   public static int field1465;
   @ObfuscatedName("m")
   int[] field1467;
   @ObfuscatedName("dp")
   @Export("mapRegions")
   static int[] mapRegions;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lclass195;",
      garbageValue = "-105"
   )
   public static class195 method1738(int var0) {
      class195 var1 = (class195)class195.field2855.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class195.field2864.method3329(8, var0);
         var1 = new class195();
         if(var2 != null) {
            var1.method3603(new Buffer(var2));
         }

         class195.field2855.put(var1, (long)var0);
         return var1;
      }
   }

   FrameMap(int var1, byte[] var2) {
      this.field1459 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1461 = var3.readUnsignedByte();
      this.field1467 = new int[this.field1461];
      this.field1462 = new int[this.field1461][];

      int var4;
      for(var4 = 0; var4 < this.field1461; ++var4) {
         this.field1467[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1461; ++var4) {
         this.field1462[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1461; ++var4) {
         for(int var5 = 0; var5 < this.field1462[var4].length; ++var5) {
            this.field1462[var4][var5] = var3.readUnsignedByte();
         }
      }

   }
}
