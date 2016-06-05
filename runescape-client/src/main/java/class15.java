import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("XItemContainer")
public class class15 extends class208 {
   @ObfuscatedName("i")
   @Export("itemIds")
   int[] field220 = new int[]{-1};
   @ObfuscatedName("g")
   @Export("stackSizes")
   int[] field221 = new int[]{0};
   @ObfuscatedName("t")
   @Export("itemContainers")
   static class196 field222 = new class196(32);
   @ObfuscatedName("az")
   static class168 field223;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "1170772956"
   )
   static void method159(class173 var0) {
      class173 var1 = var0.field2795 == -1?null:class170.method3344(var0.field2795);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class10.field162;
         var3 = class41.field966;
      } else {
         var2 = var1.field2791;
         var3 = var1.field2792;
      }

      class191.method3708(var0, var2, var3, false);
      class173.method3410(var0, var2, var3);
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1909321381"
   )
   static void method160() {
      for(class3 var0 = (class3)client.field443.method3751(); var0 != null; var0 = (class3)client.field443.method3752()) {
         int var1 = var0.field65;
         if(class173.method3380(var1)) {
            boolean var2 = true;
            class173[] var3 = class216.field3168[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2775;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3125;
               class173 var5 = class170.method3344(var4);
               if(var5 != null) {
                  class20.method547(var5);
               }
            }
         }
      }

   }
}
