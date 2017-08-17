import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class221 {
   @ObfuscatedName("cs")
   public static char field2807;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1897086126"
   )
   public static void method4072() {
      Object var0 = class237.field3222;
      synchronized(class237.field3222) {
         if(class237.field3219 != 0) {
            class237.field3219 = 1;

            try {
               class237.field3222.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1477019721"
   )
   public static boolean method4073(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
