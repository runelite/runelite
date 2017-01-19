import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class149 {
   @ObfuscatedName("mm")
   static byte field2046;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "-973836463"
   )
   public static final void method2693(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class57.field1057 = var0;
         class57.field1052 = var1;
         class231.field3281 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
