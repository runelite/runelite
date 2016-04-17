import java.awt.Image;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class106 {
   @ObfuscatedName("do")
   static int[][] field1859;
   @ObfuscatedName("d")
   static int[][] field1860 = new int[128][128];
   @ObfuscatedName("c")
   static int[][] field1862 = new int[128][128];
   @ObfuscatedName("q")
   static int[] field1863 = new int[4096];
   @ObfuscatedName("ql")
   static Image field1864;
   @ObfuscatedName("p")
   static int[] field1866 = new int[4096];

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "775907357"
   )
   static void method2473(int var0, int var1, int var2) {
      if(client.field466 != 0 && 0 != var1 && client.field536 < 50) {
         client.field537[client.field536] = var0;
         client.field334[client.field536] = var1;
         client.field539[client.field536] = var2;
         client.field541[client.field536] = null;
         client.field540[client.field536] = 0;
         ++client.field536;
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "-975644409"
   )
   static final void method2478(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(0 == var0.field237) {
         var1 = class30.field717.method2034(var0.field242, var0.field238, var0.field243);
      }

      if(1 == var0.field237) {
         var1 = class30.field717.method2035(var0.field242, var0.field238, var0.field243);
      }

      if(var0.field237 == 2) {
         var1 = class30.field717.method2036(var0.field242, var0.field238, var0.field243);
      }

      if(var0.field237 == 3) {
         var1 = class30.field717.method2037(var0.field242, var0.field238, var0.field243);
      }

      if(0 != var1) {
         int var5 = class30.field717.method2038(var0.field242, var0.field238, var0.field243, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field240 = var2;
      var0.field249 = var3;
      var0.field245 = var4;
   }
}
