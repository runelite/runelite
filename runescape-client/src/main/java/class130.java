import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class130 {
   @ObfuscatedName("b")
   static final class130 field2042 = new class130(0);
   @ObfuscatedName("g")
   public static final class130 field2043 = new class130(1);
   @ObfuscatedName("j")
   static final class130 field2044 = new class130(2);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1897431363
   )
   public final int field2045;
   @ObfuscatedName("cm")
   static class146 field2046;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -1210819093
   )
   static int field2047;

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "28"
   )
   static final void method2858(int var0, int var1, int var2, int var3, int var4) {
      class177.field2905[0].method1873(var0, var1);
      class177.field2905[1].method1873(var0, var1 + var3 - 16);
      class79.method1865(var0, 16 + var1, 16, var3 - 32, client.field366);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = var2 * (var3 - 32 - var5) / (var4 - var3);
      class79.method1865(var0, 16 + var1 + var6, 16, var5, client.field367);
      class79.method1809(var0, var1 + 16 + var6, var5, client.field325);
      class79.method1809(var0 + 1, 16 + var1 + var6, var5, client.field325);
      class79.method1839(var0, var6 + 16 + var1, 16, client.field325);
      class79.method1839(var0, 17 + var1 + var6, 16, client.field325);
      class79.method1809(15 + var0, 16 + var1 + var6, var5, client.field368);
      class79.method1809(var0 + 14, 17 + var1 + var6, var5 - 1, client.field368);
      class79.method1839(var0, var5 + var6 + var1 + 15, 16, client.field368);
      class79.method1839(1 + var0, var5 + var1 + 14 + var6, 15, client.field368);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass66;B)V",
      garbageValue = "-105"
   )
   static final void method2861(class66 var0) {
      var0.field1234 = false;
      if(var0.field1233 != null) {
         var0.field1233.field1230 = 0;
      }

      for(class66 var1 = var0.vmethod3722(); var1 != null; var1 = var0.vmethod3736()) {
         method2861(var1);
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class130(int var1) {
      this.field2045 = var1;
   }
}
