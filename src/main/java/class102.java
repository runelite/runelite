import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cw")
public class class102 extends class203 {
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = 743359911
   )
   static int field1761;
   @ObfuscatedName("e")
   static int[] field1764;
   @ObfuscatedName("a")
   class87[] field1765;

   class102(class166 var1, class166 var2, int var3, boolean var4) {
      class198 var5 = new class198();
      int var6 = var1.method3273(var3);
      this.field1765 = new class87[var6];
      int[] var7 = var1.method3272(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3263(var3, var7[var8]);
         class101 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class101 var12 = (class101)var5.method3860(); var12 != null; var12 = (class101)var5.method3861()) {
            if(var12.field1752 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3299(0, var11);
            } else {
               var13 = var2.method3299(var11, 0);
            }

            var10 = new class101(var11, var13);
            var5.method3855(var10);
         }

         this.field1765[var7[var8]] = new class87(var9, var10);
      }

   }

   @ObfuscatedName("r")
   public boolean method2295(int var1) {
      return this.field1765[var1].field1521;
   }
}
