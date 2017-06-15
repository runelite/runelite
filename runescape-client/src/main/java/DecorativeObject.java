import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ee")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("f")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 282319735
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -76913143
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -261437359
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 585686975
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 99000595
   )
   static int field2178;
   @ObfuscatedName("i")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 204357811
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -813852631
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1747068861
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2052355811
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1792931977
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("m")
   static final void method2786(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }
}
