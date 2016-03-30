import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class185 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1880846697
   )
   int field3002;
   @ObfuscatedName("w")
   byte[] field3003;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1460353681
   )
   int field3004;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1443054393
   )
   int field3005;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1709446721
   )
   int field3006;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -557146669
   )
   int field3007;
   @ObfuscatedName("x")
   byte[] field3008;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1917133871
   )
   int field3009;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1945147307
   )
   int field3010;

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIZI)V",
      garbageValue = "1204123916"
   )
   static void method3728(class173[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class173 var6 = var0[var5];
         if(var6 != null && var1 == var6.field2786) {
            class24.method608(var6, var2, var3, var4);
            class10.method127(var6, var2, var3);
            if(var6.field2788 > var6.field2790 - var6.field2767) {
               var6.field2788 = var6.field2790 - var6.field2767;
            }

            if(var6.field2788 < 0) {
               var6.field2788 = 0;
            }

            if(var6.field2882 > var6.field2791 - var6.field2783) {
               var6.field2882 = var6.field2791 - var6.field2783;
            }

            if(var6.field2882 < 0) {
               var6.field2882 = 0;
            }

            if(var6.field2814 == 0) {
               class34.method746(var0, var6, var4);
            }
         }
      }

   }
}
