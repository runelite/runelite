import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class40 implements class158 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2128924431
   )
   final int field805;
   @ObfuscatedName("ai")
   static int[] field806;
   @ObfuscatedName("x")
   static final class40 field807 = new class40(2);
   @ObfuscatedName("q")
   static final class40 field808 = new class40(3);
   @ObfuscatedName("k")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("g")
   static final class40 field812 = new class40(1);
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 1114540013
   )
   protected static int field813;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1387926431
   )
   static int field814;
   @ObfuscatedName("p")
   static final class40 field815 = new class40(0);
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -404137453
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "9241"
   )
   public int vmethod4074() {
      return this.field805;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "7882254"
   )
   static final int method741(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1452[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field805 = var1;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Lclass38;III)V",
      garbageValue = "403917316"
   )
   static final void method746(class38 var0, int var1, int var2) {
      class5.menuAction(var0.field794, var0.field791, var0.field790, var0.field793, var0.field796, var0.field796, var1, var2);
   }
}
