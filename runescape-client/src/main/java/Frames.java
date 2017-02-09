import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("k")
   Frame[] field1568;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1052097137
   )
   static int field1569;

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZ)V",
      garbageValue = "0"
   )
   public Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3283(var3);
      this.field1568 = new Frame[var6];
      int[] var7 = var1.method3282(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2403(); null != var12; var12 = (FrameMap)var5.method2398()) {
            if(var12.field1467 == var11) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3279(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method2380(var10);
         }

         this.field1568[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-416404683"
   )
   public boolean method1887(int var1) {
      return this.field1568[var1].field1322;
   }
}
