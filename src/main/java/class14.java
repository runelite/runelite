import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("p")
public class class14 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -312193997
   )
   int field198 = -1;
   @ObfuscatedName("m")
   int[] field199;
   @ObfuscatedName("z")
   String[] field200;
   @ObfuscatedName("d")
   static String field201;
   @ObfuscatedName("er")
   static class78 field202;
   @ObfuscatedName("nb")
   static class56 field203;
   @ObfuscatedName("j")
   class22 field205;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1242545199
   )
   static int field207;

   @ObfuscatedName("j")
   public static final void method170(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var5) {
               ;
            }
         }

      }
   }
}
