import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3350(0, -1, true, false, true),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3344(1, 0, true, true, true),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3345(2, 1, true, true, false),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3346(3, 2, false, false, true),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3347(4, 3, false, false, true),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3349(5, 10, false, false, true);

   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1511288651
   )
   final int field3343;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 464821425
   )
   public final int field3348;
   @ObfuscatedName("u")
   public final boolean field3351;
   @ObfuscatedName("x")
   public final boolean field3352;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3343 = var3;
      this.field3348 = var4;
      this.field3351 = var6;
      this.field3352 = var7;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-369819377"
   )
   public int rsOrdinal() {
      return this.field3343;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([Lgt;IB)Lgt;",
      garbageValue = "63"
   )
   @Export("forOrdinal")
   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }
}
