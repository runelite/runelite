import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class168 implements class165 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static final class168 field2406;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   static final class168 field2401;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static final class168 field2402;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static final class168 field2400;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lfp;"
   )
   static final class168[] field2405;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "[Lkl;"
   )
   static IndexedSprite[] field2407;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1929065247
   )
   public final int field2403;

   static {
      field2406 = new class168(14, 0);
      field2401 = new class168(15, 4);
      field2402 = new class168(16, -2);
      field2400 = new class168(18, -2);
      field2405 = new class168[32];
      class168[] var0 = class45.method665();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2405[var0[var1].field2403] = var0[var1];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class168(int var1, int var2) {
      this.field2403 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;I)V",
      garbageValue = "1975032326"
   )
   public static void method3196(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3442 = var0;
      class74.field864 = var1;
   }
}
