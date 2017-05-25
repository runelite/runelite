import java.io.File;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class226 {
   @ObfuscatedName("q")
   static File field3126;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-93"
   )
   public static synchronized long method4147() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2396) {
         class175.field2400 += class175.field2396 - var0;
      }

      class175.field2396 = var0;
      return class175.field2400 + var0;
   }
}
