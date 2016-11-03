import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("dw")
   @Export("region")
   static Region region;
   @ObfuscatedName("k")
   Frame[] field1831;

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IZ)V",
      garbageValue = "0"
   )
   public Frames(class170 var1, class170 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3290(var3);
      this.field1831 = new Frame[var6];
      int[] var7 = var1.method3289(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3305(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3864(); var12 != null; var12 = (FrameMap)var5.method3851()) {
            if(var11 == var12.field1824) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method3286(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method3844(var10);
         }

         this.field1831[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-234313721"
   )
   public boolean method2357(int var1) {
      return this.field1831[var1].field1602;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "54"
   )
   static final void method2358(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         Friend.menuAction(var1, var2, var3, var4, var5, var6, class143.field2207, class143.field2196);
      }
   }
}
