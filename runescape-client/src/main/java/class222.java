import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class222 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1761428611
   )
   static int field2837;
   @ObfuscatedName("i")
   public static int[] field2839;
   @ObfuscatedName("p")
   public static final boolean[] field2840;

   static {
      field2840 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2839 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2839[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-50"
   )
   public static void method4092(boolean var0) {
      if(class238.field3272 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class238.field3272.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class238.field3272.method2989();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3271;
            class238.field3272 = null;
         }

      }
   }
}
