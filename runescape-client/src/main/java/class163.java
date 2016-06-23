import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public final class class163 {
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = -2052839373
   )
   static int field2647;
   @ObfuscatedName("d")
   static class167 field2648;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1071988368"
   )
   public static void method3250(boolean var0) {
      if(class171.field2722 != null) {
         try {
            class119 var1 = new class119(4);
            var1.method2654(var0?2:3);
            var1.method2541(0);
            class171.field2722.method3018(var1.field2000, 0, 4);
         } catch (IOException var4) {
            try {
               class171.field2722.method3013();
            } catch (Exception var3) {
               ;
            }

            ++class171.field2716;
            class171.field2722 = null;
         }

      }
   }
}
