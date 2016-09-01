import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class124 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2104318703
   )
   static int field2062 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 293066235
   )
   static int field2063 = 0;
   @ObfuscatedName("z")
   static byte[][] field2064 = new byte[1000][];
   @ObfuscatedName("i")
   static byte[][] field2065 = new byte[250][];
   @ObfuscatedName("b")
   static byte[][] field2066 = new byte[50][];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1700405695
   )
   static int field2067 = 0;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-885523943"
   )
   static synchronized byte[] method2812(int var0) {
      byte[] var1;
      if(var0 == 100 && field2067 > 0) {
         var1 = field2064[--field2067];
         field2064[field2067] = null;
         return var1;
      } else if(var0 == 5000 && field2062 > 0) {
         var1 = field2065[--field2062];
         field2065[field2062] = null;
         return var1;
      } else if(var0 == 30000 && field2063 > 0) {
         var1 = field2066[--field2063];
         field2066[field2063] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-774042215"
   )
   static final void method2815(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field547; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field484[var4] = true;
         }
      }

   }
}
