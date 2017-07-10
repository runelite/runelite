import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("ce")
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("s")
   public static File field2158;
   @ObfuscatedName("i")
   Frame[] field2160;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "937027647"
   )
   public boolean method2872(int var1) {
      return this.field2160[var1].showing;
   }

   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method4133(var3);
      this.field2160 = new Frame[var6];
      int[] var7 = var1.method4121(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3584(); var12 != null; var12 = (FrameMap)var5.method3578()) {
            if(var11 == var12.field2057) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method4185(0, var11);
            } else {
               var13 = var2.method4185(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method3603(var10);
         }

         this.field2160[var7[var8]] = new Frame(var9, var10);
      }

   }
}
