import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class160 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "5"
   )
   public static int method3215(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lclass157;",
      garbageValue = "-1663087003"
   )
   public static class157[] method3216() {
      return new class157[]{class157.field2341, class157.field2342, class157.field2338, class157.field2339, class157.field2347, class157.field2340};
   }
}
