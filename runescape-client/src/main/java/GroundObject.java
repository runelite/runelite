import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 950595223
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1302060085
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 326033797
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1395110931
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 908974953
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lij;",
      garbageValue = "1162437718"
   )
   public static Permission[] method2493() {
      return new Permission[]{Permission.field3276, Permission.field3277, Permission.field3274, Permission.field3275, Permission.field3273, Permission.field3281};
   }
}
