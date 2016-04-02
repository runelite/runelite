import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cl")
public class class103 extends class204 {
   @ObfuscatedName("e")
   class88[] field1747;

   @ObfuscatedName("w")
   public boolean method2315(int var1) {
      return this.field1747[var1].field1528;
   }

   class103(class167 var1, class167 var2, int var3, boolean var4) {
      class199 var5 = new class199();
      int var6 = var1.method3307(var3);
      this.field1747 = new class88[var6];
      int[] var7 = var1.method3265(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3280(var3, var7[var8]);
         class102 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class102 var12 = (class102)var5.method3825(); var12 != null; var12 = (class102)var5.method3827()) {
            if(var12.field1739 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3261(0, var11);
            } else {
               var13 = var2.method3261(var11, 0);
            }

            var10 = new class102(var11, var13);
            var5.method3834(var10);
         }

         this.field1747[var7[var8]] = new class88(var9, var10);
      }

   }
}
