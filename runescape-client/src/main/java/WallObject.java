import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1808888379
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1987614443
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1854590965
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1749495747
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1080317993
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 18406019
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1731653373
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;Lid;I)V",
      garbageValue = "-602277259"
   )
   public static void method2995(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      Sequence.seq_ref = var0;
      Sequence.skel_ref = var1;
      class273.skin_ref = var2;
   }
}
