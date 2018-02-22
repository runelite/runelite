import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 480982071
   )
   static int field231;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 770552695
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1298375753
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1414374519
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1815011307
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -152790199
   )
   @Export("color")
   final int color;

   public BoundingBox2D(int var1, int var2, int var3, int var4, int var5) {
      this.xMin = var1;
      this.yMin = var2;
      this.xMax = var3;
      this.yMax = var4;
      this.color = var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2133791811"
   )
   public final void vmethod48() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "0"
   )
   static void method33(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   static void method36() {
      class272.method4902();
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuBooleanArray[0] = false;
      Client.menuOptionCount = 1;
   }
}
