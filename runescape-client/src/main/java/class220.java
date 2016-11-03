import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
final class class220 implements Comparator {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "8657"
   )
   static void method3996(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3828((long)var0);
      if(null != var1) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1486464541"
   )
   int method3998(class217 var1, class217 var2) {
      return var1.field3198.price < var2.field3198.price?-1:(var1.field3198.price == var2.field3198.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3998((class217)var1, (class217)var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZI)I",
      garbageValue = "-747059031"
   )
   static int method4001(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class12.method143(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class12.method143(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
