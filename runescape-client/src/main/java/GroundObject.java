import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -778423073
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1638591795
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1000585405
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 690011649
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1323309637
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-11"
   )
   public static final void method2599(int var0, int var1, int var2, int var3, int var4) {
      class7.field228.method3749(new class8(var0, var1, var2, var3, var4));
   }
}
