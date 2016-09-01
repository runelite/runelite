import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1713709245
   )
   public static int field1826;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -1437594837
   )
   static int field1827;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 1988579627
   )
   static int field1831;
   @ObfuscatedName("x")
   Frame[] field1832;
   @ObfuscatedName("e")
   public static String field1833;
   @ObfuscatedName("an")
   static int[] field1835;
   @ObfuscatedName("cb")
   static class149 field1836;

   Frames(class170 var1, class170 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3299(var3);
      this.field1832 = new Frame[var6];
      int[] var7 = var1.method3289(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3290(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3850(); var12 != null; var12 = (FrameMap)var5.method3852()) {
            if(var12.field1820 == var11) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3295(0, var11);
            } else {
               var13 = var2.method3295(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method3844(var10);
         }

         this.field1832[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "118"
   )
   public boolean method2351(int var1) {
      return this.field1832[var1].field1591;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CIS)I",
      garbageValue = "15002"
   )
   static int method2355(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
