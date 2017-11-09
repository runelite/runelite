import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class182 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -1707623241076757545L
   )
   static long field2511;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -1205264072256891263L
   )
   static long field2510;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lik;IIIZB)V",
      garbageValue = "1"
   )
   public static void method3518(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class210.field2594 = 1;
      class184.field2516 = var0;
      class210.field2598 = var1;
      class210.field2599 = var2;
      class37.field485 = var3;
      class210.field2595 = var4;
      class47.field584 = 10000;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "674181144"
   )
   public static Object method3517(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.field2512) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.field2512 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-113"
   )
   static final void method3521(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field980; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1056[var4] = true;
         }
      }

   }
}
