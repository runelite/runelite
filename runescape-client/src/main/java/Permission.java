import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3271(0, -1, true, false, true),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3265(1, 0, true, true, true),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3266(2, 1, true, true, false),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3267(3, 2, false, false, true),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3264(4, 3, false, false, true),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3268(5, 10, false, false, true);

   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2109155543
   )
   static int field3274;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 698388719
   )
   final int field3269;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -272598109
   )
   public final int field3270;
   @ObfuscatedName("z")
   public final boolean field3272;
   @ObfuscatedName("k")
   public final boolean field3273;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3269 = var3;
      this.field3270 = var4;
      this.field3272 = var6;
      this.field3273 = var7;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.field3269;
   }
}
