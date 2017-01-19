import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public final class class207 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1397783883
   )
   public static int field3097;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass184;II)V",
      garbageValue = "460358798"
   )
   static void method3710(class184 var0, int var1) {
      if(null != class15.field172) {
         class15.field172.offset = 8 * var1 + 5;
         int var2 = class15.field172.method2727();
         int var3 = class15.field172.method2727();
         var0.method3273(var2, var3);
      } else {
         class140.method2547((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2764[var1] = var0;
      }
   }
}
