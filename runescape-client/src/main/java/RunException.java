import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("m")
   @Export("applet")
   public static Applet applet;
   @ObfuscatedName("f")
   @Export("localPlayerName")
   public static String localPlayerName;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -787495321
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 121013503
   )
   @Export("__fx_w")
   public static int __fx_w;
   @ObfuscatedName("o")
   @Export("string")
   String string;
   @ObfuscatedName("u")
   @Export("throwable")
   Throwable throwable;

   RunException(Throwable var1, String var2) {
      this.string = var2;
      this.throwable = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lgf;",
      garbageValue = "1701309452"
   )
   public static class190[] method3430() {
      return new class190[]{class190.field2346, class190.field2352, class190.field2342, class190.field2341, class190.field2344, class190.field2345, class190.field2350, class190.field2347, class190.field2343, class190.field2349};
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2146928006"
   )
   public static void method3431() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      Object var1 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.__iv_q != 0) {
            IndexStoreActionHandler.__iv_q = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }

      }
   }
}
