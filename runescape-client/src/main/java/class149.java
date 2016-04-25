import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class149 {
   @ObfuscatedName("z")
   static File field2212;
   @ObfuscatedName("x")
   public static File field2213;
   @ObfuscatedName("u")
   public static class228 field2215 = null;
   @ObfuscatedName("r")
   public static class228 field2217 = null;
   @ObfuscatedName("a")
   public static class228 field2218 = null;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 396631321
   )
   public static int field2219;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      longValue = 1336091171908443015L
   )
   static long field2223;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1217732555"
   )
   public static void method3107() {
      Object var0 = class170.field2704;
      synchronized(class170.field2704) {
         if(class170.field2705 != 0) {
            class170.field2705 = 1;

            try {
               class170.field2704.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }
}
