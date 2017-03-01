import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class3 implements Comparator {
   @ObfuscatedName("p")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("z")
   static int[] field19;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "97"
   )
   static final void method37() {
      KitDefinition.method3558();
      FloorUnderlayDefinition.field2816.reset();
      KitDefinition.field2830.reset();
      GameEngine.method2276();
      NPCComposition.field3008.reset();
      NPCComposition.npcModelCache.reset();
      Frames.method1995();
      Sequence.field3078.reset();
      Sequence.field3064.reset();
      Widget.method3312();
      class159.method3164();
      class187.field2778.reset();
      class196.field2874.reset();
      class196.spriteCache.reset();
      class196.field2876.reset();
      class40.method831();
      PlayerComposition.field2176.reset();
      class101.method2050();
      ((TextureProvider)class84.field1457).method1539();
      Script.field951.reset();
      class5.field38.method3367();
      class0.field0.method3367();
      class40.field818.method3367();
      class150.field2041.method3367();
      class154.field2094.method3367();
      Client.field306.method3367();
      class9.field74.method3367();
      class39.field808.method3367();
      class8.field68.method3367();
      Friend.field146.method3367();
      WidgetNode.field175.method3367();
      Tile.field1358.method3367();
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(Lclass38;III)V",
      garbageValue = "96349449"
   )
   static final void method38(class38 var0, int var1, int var2) {
      class37.menuAction(var0.field795, var0.field791, var0.field792, var0.field798, var0.field794, var0.field794, var1, var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method41((class2)var1, (class2)var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "2117647438"
   )
   int method41(class2 var1, class2 var2) {
      return var1.field13.totalQuantity < var2.field13.totalQuantity?-1:(var1.field13.totalQuantity == var2.field13.totalQuantity?0:1);
   }
}
