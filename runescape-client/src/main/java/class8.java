import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public final class class8 extends class9 {
   @ObfuscatedName("m")
   @Export("highMemory")
   public static boolean highMemory;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 995536819
   )
   static int field232;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -317167573
   )
   final int field229;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 121129421
   )
   final int field227;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 616311813
   )
   final int field226;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 523867599
   )
   final int field230;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -776939015
   )
   final int field228;

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field229 = var1;
      this.field227 = var2;
      this.field226 = var3;
      this.field230 = var4;
      this.field228 = var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   public final void vmethod49() {
      Rasterizer2D.drawRectangle(this.field229 + Rasterizer2D.draw_region_x, this.field227 + Rasterizer2D.drawingAreaTop, this.field226 - this.field229, this.field230 - this.field227, this.field228);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-551515375"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
