import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class15 implements Comparator {
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -418827559
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("fu")
   static byte[][] field298;
   @ObfuscatedName("fg")
   @Export("landRegionFielIds")
   static int[] landRegionFielIds;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lr;Lr;I)I",
      garbageValue = "-1927755384"
   )
   int method87(class14 var1, class14 var2) {
      return var1.field291.totalQuantity < var2.field291.totalQuantity?-1:(var2.field291.totalQuantity == var1.field291.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method87((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lhn;IIB)Lcj;",
      garbageValue = "-88"
   )
   static Script method97(class220 var0, int var1, int var2) {
      int var3 = (var1 << 8) + var0.field2796;
      Script var5 = class212.method3936(var3, var0);
      if(var5 != null) {
         return var5;
      } else {
         int var6 = (var2 + '鱀' << 8) + var0.field2796;
         var5 = class212.method3936(var6, var0);
         return var5 != null?var5:null;
      }
   }
}
