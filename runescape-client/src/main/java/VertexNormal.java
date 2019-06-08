import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("pe")
   @Export("__dq_pe")
   static boolean __dq_pe;
   @ObfuscatedName("rq")
   @ObfuscatedGetter(
      intValue = 1351620693
   )
   @Export("__dq_rq")
   static int __dq_rq;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1414310131
   )
   @Export("__m")
   int __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1493845293
   )
   @Export("__f")
   int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1575149515
   )
   @Export("__q")
   int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -487323631
   )
   @Export("__w")
   int __w;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Ldq;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.__m = var1.__m;
      this.__f = var1.__f;
      this.__q = var1.__q;
      this.__w = var1.__w;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-86"
   )
   static synchronized void method2984(byte[] var0) {
      if(var0.length == 100 && ByteArrayPool.ByteArrayPool_smallCount < 1000) {
         ByteArrayPool.ByteArrayPool_small[++ByteArrayPool.ByteArrayPool_smallCount - 1] = var0;
      } else if(var0.length == 5000 && ByteArrayPool.ByteArrayPool_mediumCount < 250) {
         ByteArrayPool.ByteArrayPool_medium[++ByteArrayPool.ByteArrayPool_mediumCount - 1] = var0;
      } else if(var0.length == 30000 && ByteArrayPool.ByteArrayPool_largeCount < 50) {
         ByteArrayPool.ByteArrayPool_large[++ByteArrayPool.ByteArrayPool_largeCount - 1] = var0;
      } else {
         if(class179.__fe_e != null) {
            for(int var1 = 0; var1 < ByteArrayPool.__gi_g.length; ++var1) {
               if(var0.length == ByteArrayPool.__gi_g[var1] && WorldMapSection2.__ah_l[var1] < class179.__fe_e[var1].length) {
                  class179.__fe_e[var1][WorldMapSection2.__ah_l[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }
}
