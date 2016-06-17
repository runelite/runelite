import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class215 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2123564745"
   )
   static final void method3954() {
      int[] var0 = class32.field739;

      int var1;
      for(var1 = 0; var1 < class32.field738; ++var1) {
         class2 var2 = client.field410[var0[var1]];
         if(null != var2 && var2.field806 > 0) {
            --var2.field806;
            if(var2.field806 == 0) {
               var2.field803 = null;
            }
         }
      }

      for(var1 = 0; var1 < client.field449; ++var1) {
         int var4 = client.field318[var1];
         class34 var3 = client.field326[var4];
         if(null != var3 && var3.field806 > 0) {
            --var3.field806;
            if(var3.field806 == 0) {
               var3.field803 = null;
            }
         }
      }

   }
}
