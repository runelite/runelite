import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 714609933
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -635706115
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -554820235
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 600979589
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 116232835
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -337797081
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1852052911
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1258761623
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1479818253
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-911388025"
   )
   static final String method2908(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "147177740"
   )
   static final void method2907(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(GraphicsObject.loadWidget(var0)) {
         class21.method156(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
