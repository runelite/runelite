import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class191 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-1482121214"
   )
   static final int method3736(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class91.field1597[1024 * var2 / var3] >> 1;
      return (var1 * var4 >> 16) + (var0 * (65536 - var4) >> 16);
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIZB)V",
      garbageValue = "1"
   )
   static void method3737(class173[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class173 var6 = var0[var5];
         if(var6 != null && var1 == var6.field2784) {
            class99.method2180(var6, var2, var3, var4);
            class72.method1553(var6, var2, var3);
            if(var6.field2786 > var6.field2848 - var6.field2886) {
               var6.field2786 = var6.field2848 - var6.field2886;
            }

            if(var6.field2786 < 0) {
               var6.field2786 = 0;
            }

            if(var6.field2787 > var6.field2858 - var6.field2781) {
               var6.field2787 = var6.field2858 - var6.field2781;
            }

            if(var6.field2787 < 0) {
               var6.field2787 = 0;
            }

            if(0 == var6.field2767) {
               class125.method2796(var0, var6, var4);
            }
         }
      }

   }
}
