import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 745043371
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1947237693
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1117100567
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1771751251
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1504871541
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 358911685
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 234724397
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-253232753"
   )
   public static void method2872() {
      Varbit.varbits.reset();
   }
}
