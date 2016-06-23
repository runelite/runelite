import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class20 implements class112 {
   @ObfuscatedName("f")
   static final class20 field573 = new class20(0);
   @ObfuscatedName("u")
   static final class20 field574 = new class20(1);
   @ObfuscatedName("b")
   static final class20 field575 = new class20(3);
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -1969721939
   )
   @Export("baseY")
   static int field576;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 174649229
   )
   final int field577;
   @ObfuscatedName("x")
   static final class20 field578 = new class20(2);
   @ObfuscatedName("pf")
   static class8 field580;
   @ObfuscatedName("d")
   public static class167 field582;
   @ObfuscatedName("r")
   public static boolean field583;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public int vmethod3194() {
      return this.field577;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZIZI)I",
      garbageValue = "-538523298"
   )
   static int method598(class25 var0, class25 var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class212.method3963(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class212.method3963(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class20(int var1) {
      this.field577 = var1;
   }
}
