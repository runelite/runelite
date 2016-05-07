import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class155 {
   @ObfuscatedName("p")
   public static int[] field2301 = new int[99];
   @ObfuscatedName("j")
   public static final boolean[] field2302 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "1047806493"
   )
   public static void method3144(class167 var0) {
      class45.field1044 = var0;
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2301[var1] = var0 / 4;
      }

   }
}
