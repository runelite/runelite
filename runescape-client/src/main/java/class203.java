import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class203 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -6166028446082638015L
   )
   @Export("currentTimeMsOffset")
   static long currentTimeMsOffset;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 994298267
   )
   @Export("port3")
   static int port3;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "340448023"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < ModelData0.currentTimeMsLast) {
         currentTimeMsOffset += ModelData0.currentTimeMsLast - var0;
      }

      ModelData0.currentTimeMsLast = var0;
      return var0 + currentTimeMsOffset;
   }

   @ObfuscatedName("m")
   public static final void method4010(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "571835999"
   )
   public static void method4008(int var0) {
      if(class214.__hf_o != 0) {
         WorldMapLabel.__aj_e = var0;
      } else {
         class214.midiPcmStream.__m_340(var0);
      }

   }
}
