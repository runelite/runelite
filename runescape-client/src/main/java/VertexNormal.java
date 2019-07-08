import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("pe")
   static boolean field945;
   @ObfuscatedName("rq")
   @ObfuscatedGetter(
      intValue = 1351620693
   )
   static int field946;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1414310131
   )
   int field947;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1493845293
   )
   int field948;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1575149515
   )
   int field949;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -487323631
   )
   int field950;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Ldq;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.field947 = var1.field947;
      this.field948 = var1.field948;
      this.field949 = var1.field949;
      this.field950 = var1.field950;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-86"
   )
   static synchronized void method2984(byte[] var0) {
      if (var0.length == 100 && ByteArrayPool.ByteArrayPool_smallCount < 1000) {
         ByteArrayPool.ByteArrayPool_small[++ByteArrayPool.ByteArrayPool_smallCount - 1] = var0;
      } else if (var0.length == 5000 && ByteArrayPool.ByteArrayPool_mediumCount < 250) {
         ByteArrayPool.ByteArrayPool_medium[++ByteArrayPool.ByteArrayPool_mediumCount - 1] = var0;
      } else if (var0.length == 30000 && ByteArrayPool.ByteArrayPool_largeCount < 50) {
         ByteArrayPool.ByteArrayPool_large[++ByteArrayPool.ByteArrayPool_largeCount - 1] = var0;
      } else if (RouteStrategy.field760 != null) {
         for (int var1 = 0; var1 < ByteArrayPool.field55.length; ++var1) {
            if (var0.length == ByteArrayPool.field55[var1] && WorldMapSection0.field1082[var1] < RouteStrategy.field760[var1].length) {
               RouteStrategy.field760[var1][WorldMapSection0.field1082[var1]++] = var0;
               return;
            }
         }
      }

   }
}
