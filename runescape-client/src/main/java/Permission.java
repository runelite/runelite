import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("a")
   field3176(0, -1, true, false, true),
   @ObfuscatedName("j")
   field3174(1, 0, true, true, true),
   @ObfuscatedName("n")
   field3179(2, 1, true, true, false),
   @ObfuscatedName("r")
   field3175(3, 2, false, false, true),
   @ObfuscatedName("v")
   field3177(4, 3, false, false, true),
   @ObfuscatedName("e")
   field3180(5, 10, false, false, true);

   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 79589525
   )
   final int field3173;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1913823705
   )
   public final int field3178;
   @ObfuscatedName("w")
   public final boolean field3181;
   @ObfuscatedName("p")
   public final boolean field3182;

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3173 = var3;
      this.field3178 = var4;
      this.field3181 = var6;
      this.field3182 = var7;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field3173;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1551289977"
   )
   public static boolean method4073(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
