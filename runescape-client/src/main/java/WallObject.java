import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 721700685
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1069278695
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1402981939
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -120467245
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1569356951
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1091466637
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -650877531
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-26914"
   )
   @Export("nextPowerOfTwo")
   public static int nextPowerOfTwo(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-875562035"
   )
   static void method3074() {
      class157.field2146 = new int[2000];
      int var0 = 0;
      int var1 = 240;

      int var3;
      for(byte var2 = 12; var0 < 16; var1 -= var2) {
         var3 = Area.method4771((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)(0.075F + 0.425F * (float)var0 / 16.0F));
         class157.field2146[var0] = var3;
         ++var0;
      }

      var1 = 48;

      for(int var5 = var1 / 6; var0 < class157.field2146.length; var1 -= var5) {
         var3 = var0 * 2;

         for(int var4 = Area.method4771((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < class157.field2146.length; ++var0) {
            class157.field2146[var0] = var4;
         }
      }

   }
}
