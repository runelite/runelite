import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
final class class216 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1067148747"
   )
   int method4015(class217 var1, class217 var2) {
      return var1.method4029().compareTo(var2.method4029());
   }

   public int compare(Object var1, Object var2) {
      return this.method4015((class217)var1, (class217)var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;S)V",
      garbageValue = "-3267"
   )
   public static void method4021(class170 var0, class170 var1) {
      class49.field1080 = var0;
      class117.field2025 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-6"
   )
   static final int method4025(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) + (var2 * (var1 & '\uff00') + var3 * (var0 & '\uff00') & 16711680) >> 8;
   }
}
