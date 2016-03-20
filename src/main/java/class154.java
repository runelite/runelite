import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
public class class154 {
   @ObfuscatedName("f")
   public static int[] field2279 = new int[99];
   @ObfuscatedName("r")
   public static final boolean[] field2280 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2279[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("y")
   public static void method3173(int var0) {
      class182.field2947 = 1;
      class182.field2946 = null;
      class182.field2945 = -1;
      class182.field2948 = -1;
      class134.field2077 = 0;
      class182.field2949 = false;
      class45.field1043 = var0;
   }
}
