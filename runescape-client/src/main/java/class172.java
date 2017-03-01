import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class172 {
   @ObfuscatedName("g")
   public static int[] field2354 = new int[99];
   @ObfuscatedName("n")
   public static final boolean[] field2356 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2832072"
   )
   public static void method3331(boolean var0) {
      if(null != class185.field2757) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2873(var0?2:3);
            var1.method2871(0);
            class185.field2757.method2148(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2757.method2139();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2747;
            class185.field2757 = null;
         }

      }
   }

   class172() throws Throwable {
      throw new Error();
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2354[var1] = var0 / 4;
      }

   }
}
