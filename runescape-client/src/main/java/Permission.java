import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3161(0, -1, true, false, true),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3153(1, 0, true, true, true),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3154(2, 1, true, true, false),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3155(3, 2, false, false, true),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3159(4, 3, false, false, true),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   field3157(5, 10, false, false, true);

   @ObfuscatedName("u")
   public final boolean field3152;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -898783891
   )
   public final int field3158;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1802234199
   )
   final int field3160;
   @ObfuscatedName("r")
   public final boolean field3163;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3160 = var3;
      this.field3158 = var4;
      this.field3163 = var6;
      this.field3152 = var7;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field3160;
   }
}
