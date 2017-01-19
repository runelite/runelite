import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("s")
   Frame[] field1568;
   @ObfuscatedName("a")
   static class182 field1570;

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZ)V",
      garbageValue = "0"
   )
   public Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3192(var3);
      this.field1568 = new Frame[var6];
      int[] var7 = var1.method3191(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3182(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2330(); var12 != null; var12 = (FrameMap)var5.method2346()) {
            if(var11 == var12.field1467) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method3237(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method2333(var10);
         }

         this.field1568[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lclass109;",
      garbageValue = "1206948903"
   )
   static class109 method1837() {
      try {
         return new class98();
      } catch (Throwable var1) {
         return new class99();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1444903045"
   )
   public boolean method1839(int var1) {
      return this.field1568[var1].field1329;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1314294583"
   )
   static final void method1841() {
      int var0 = class45.field894;
      int[] var1 = class45.field896;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(null != var3) {
            class7.method87(var3, 1);
         }
      }

   }
}
