import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public abstract class class156 {
   @ObfuscatedName("m")
   static boolean field2130 = false;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "601702101"
   )
   abstract byte[] vmethod2937();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "542069126"
   )
   abstract void vmethod2938(byte[] var1);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)I",
      garbageValue = "1916030796"
   )
   static int method2948(class159 var0) {
      int var1 = var0.method2986(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2986(5);
      } else if(var1 == 2) {
         var2 = var0.method2986(8);
      } else {
         var2 = var0.method2986(11);
      }

      return var2;
   }
}
