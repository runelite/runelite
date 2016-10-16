import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class85 implements class115 {
   @ObfuscatedName("z")
   static final class85 field1468 = new class85(1, 1);
   @ObfuscatedName("t")
   static final class85 field1469 = new class85(2, 2);
   @ObfuscatedName("p")
   static final class85 field1471 = new class85(4, 4);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -154478425
   )
   public final int field1472;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 902605661
   )
   final int field1473;
   @ObfuscatedName("s")
   public static final class85 field1474 = new class85(0, 0);
   @ObfuscatedName("ri")
   protected static boolean field1475;
   @ObfuscatedName("y")
   static final class85 field1476 = new class85(3, 3);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lclass133;",
      garbageValue = "2095569242"
   )
   public static class133[] method1888() {
      return new class133[]{class133.field2100, class133.field2097, class133.field2095};
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int vmethod3162() {
      return this.field1473;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "473956064"
   )
   static int method1893(int var0, int var1, int var2) {
      return (class5.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class5.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class85(int var1, int var2) {
      this.field1472 = var1;
      this.field1473 = var2;
   }
}
