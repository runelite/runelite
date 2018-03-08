import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "[Llk;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public abstract void vmethod3325();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1292093981"
   )
   public abstract int vmethod3323(int var1, int var2);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)[Lkg;",
      garbageValue = "193530572"
   )
   public static Parameters[] method3332() {
      return new Parameters[]{Parameters.field3808, Parameters.field3801, Parameters.field3803, Parameters.field3797, Parameters.field3800, Parameters.field3805, Parameters.field3794, Parameters.field3806, Parameters.field3802, Parameters.field3798, Parameters.field3795, Parameters.field3799, Parameters.field3809, Parameters.field3807, Parameters.field3796, Parameters.field3804};
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1973381285"
   )
   public static void method3330(int var0, int var1) {
      Varbit var2 = VerticalAlignment.method4748(var0);
      int var3 = var2.configId;
      int var4 = var2.leastSignificantBit;
      int var5 = var2.mostSignificantBit;
      int var6 = class237.varpsMasks[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class237.widgetSettings[var3] = class237.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method3331() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }
}
