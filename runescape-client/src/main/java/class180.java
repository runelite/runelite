import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class180 {
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIB)V",
      garbageValue = "-121"
   )
   static final void method3521(class176 var0, int var1, int var2) {
      if(client.field506 == 0 || client.field506 == 3) {
         if(class143.field2224 == 1 || !class17.field235 && class143.field2224 == 4) {
            class178 var3 = var0.method3453(true);
            if(var3 == null) {
               return;
            }

            int var4 = class143.field2220 - var1;
            int var5 = class143.field2222 - var2;
            if(var3.method3499(var4, var5)) {
               var4 -= var3.field2948 / 2;
               var5 -= var3.field2938 / 2;
               int var6 = client.field342 + client.field357 & 2047;
               int var7 = class94.field1660[var6];
               int var8 = class94.field1661[var6];
               var7 = (256 + client.field484) * var7 >> 8;
               var8 = var8 * (256 + client.field484) >> 8;
               int var9 = var5 * var7 + var4 * var8 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = class114.field2010.field864 + var9 >> 7;
               int var12 = class114.field2010.field831 - var10 >> 7;
               client.field313.method2797(33);
               client.field313.method2557(18);
               client.field313.method2605(var12 + class13.field184);
               client.field313.method2596(class140.field2186[82]?(class140.field2186[81]?2:1):0);
               client.field313.method2605(var11 + class39.field838);
               client.field313.method2557(var4);
               client.field313.method2557(var5);
               client.field313.method2558(client.field357);
               client.field313.method2557(57);
               client.field313.method2557(client.field342);
               client.field313.method2557(client.field484);
               client.field313.method2557(89);
               client.field313.method2558(class114.field2010.field864);
               client.field313.method2558(class114.field2010.field831);
               client.field313.method2557(63);
               client.field504 = var11;
               client.field464 = var12;
            }
         }

      }
   }
}
