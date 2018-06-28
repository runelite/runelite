import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class185 {
   @ObfuscatedName("x")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("a")
   static final int[] field2387;
   @ObfuscatedName("l")
   static final int[] field2388;

   static {
      field2387 = new int[2048];
      field2388 = new int[2048];
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field2387[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
         field2388[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
      }

   }
}
