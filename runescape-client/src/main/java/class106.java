import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("Frames")
public class class106 extends class207 {
   @ObfuscatedName("l")
   static class170 field1846;
   @ObfuscatedName("e")
   class91[] field1848;

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IZ)V",
      garbageValue = "0"
   )
   public class106(class170 var1, class170 var2, int var3, boolean var4) {
      class202 var5 = new class202();
      int var6 = var1.method3352(var3);
      this.field1848 = new class91[var6];
      int[] var7 = var1.method3346(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3340(var3, var7[var8]);
         class105 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class105 var12 = (class105)var5.method3899(); var12 != null; var12 = (class105)var5.method3918()) {
            if(var12.field1837 == var11) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3398(var11, 0);
            var10 = new class105(var11, var13);
            var5.method3895(var10);
         }

         this.field1848[var7[var8]] = new class91(var9, var10);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1593208045"
   )
   public boolean method2372(int var1) {
      return this.field1848[var1].field1615;
   }
}
