import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class103 extends class204 {
   @ObfuscatedName("w")
   class88[] field1780;
   @ObfuscatedName("lx")
   static class130 field1785;

   @ObfuscatedName("aq")
   static final void method2284(class37 var0, int var1) {
      class1.method9(var0.field849, var0.field819, var1);
   }

   @ObfuscatedName("w")
   public boolean method2285(int var1) {
      return this.field1780[var1].field1553;
   }

   @ObfuscatedName("x")
   static void method2289(int var0, String var1, String var2) {
      class104.method2293(var0, var1, var2, (String)null);
   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IZ)V",
      garbageValue = "0"
   )
   public class103(class167 var1, class167 var2, int var3, boolean var4) {
      class199 var5 = new class199();
      int var6 = var1.method3330(var3);
      this.field1780 = new class88[var6];
      int[] var7 = var1.method3332(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3335(var3, var7[var8]);
         class102 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class102 var12 = (class102)var5.method3836(); null != var12; var12 = (class102)var5.method3841()) {
            if(var12.field1777 == var11) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3294(var11, 0);
            var10 = new class102(var11, var13);
            var5.method3834(var10);
         }

         this.field1780[var7[var8]] = new class88(var9, var10);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1879622169"
   )
   static void method2290(int var0, int var1, int var2) {
      if(client.field534 != 0 && 0 != var1 && client.field536 < 50) {
         client.field350[client.field536] = var0;
         client.field538[client.field536] = var1;
         client.field543[client.field536] = var2;
         client.field552[client.field536] = null;
         client.field540[client.field536] = 0;
         ++client.field536;
      }

   }
}
