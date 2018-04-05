import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 51653105
   )
   public static int field1931;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 909698261
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -517319707
   )
   @Export("y")
   int y;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -987713281
   )
   @Export("z")
   int z;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -514131039
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lea;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZZI)Lll;",
      garbageValue = "1690207821"
   )
   static IndexedSprite method2778(boolean var0, boolean var1) {
      return var0?(var1?class246.field2979:class90.field1393):(var1?Frames.field2074:class90.field1363);
   }
}
