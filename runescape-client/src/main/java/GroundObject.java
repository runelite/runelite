import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("ry")
   @ObfuscatedGetter(
      intValue = -1962381895
   )
   static int field1789;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -1089723487
   )
   static int field1786;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -868930993
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1587041179
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1653875779
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2109063959
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1055237259
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2035506082"
   )
   public static void method2667() {
      class281.field3566.reset();
      class281.field3567.reset();
      class281.field3568.reset();
   }
}
