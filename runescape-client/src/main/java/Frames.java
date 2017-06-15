import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("p")
   Frame[] field2151;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public boolean method2766(int var1) {
      return this.field2151[var1].showing;
   }

   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method4075(var3);
      this.field2151 = new Frame[var6];
      int[] var7 = var1.method4005(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3487(); var12 != null; var12 = (FrameMap)var5.method3512()) {
            if(var12.field2057 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method4002(0, var11);
            } else {
               var13 = var2.method4002(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method3505(var10);
         }

         this.field2151[var7[var8]] = new Frame(var9, var10);
      }

   }
}
