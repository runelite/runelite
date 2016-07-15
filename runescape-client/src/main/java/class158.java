import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class158 {
   @ObfuscatedName("c")
   public static int[] field2343 = new int[99];
   @ObfuscatedName("l")
   public static final boolean[] field2344 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("qw")
   @Export("canvas")
   public static Canvas field2346;
   @ObfuscatedName("qf")
   protected static class136 field2347;

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2343[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1259954598"
   )
   public static void method3258() {
      class56.field1232.method3835();
   }
}
