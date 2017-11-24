import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class31 {
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 85492183
   )
   static int field422;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "[Lkl;"
   )
   static IndexedSprite[] field423;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 111742967
   )
   final int field420;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1838234407
   )
   final int field426;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 662131539
   )
   final int field418;

   class31(int var1, int var2, int var3) {
      this.field420 = var1;
      this.field426 = var2;
      this.field418 = var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1853073775"
   )
   public static void method272(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }
}
