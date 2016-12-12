import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class7 implements Comparator {
   @ObfuscatedName("w")
   static int[][] field65;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 71461715
   )
   static int field66;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1908275865"
   )
   int method87(class2 var1, class2 var2) {
      return var1.field26 < var2.field26?-1:(var2.field26 == var1.field26?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method87((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1943620849"
   )
   static final boolean method94(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-345616876"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2949.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field2952.method3211(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3617();
         if(var1.field2985 != -1) {
            var1.method3585(getItemDefinition(var1.field2985), getItemDefinition(var1.note));
         }

         if(var1.field2994 != -1) {
            var1.method3606(getItemDefinition(var1.field2994), getItemDefinition(var1.field2973));
         }

         if(var1.field2996 != -1) {
            var1.method3595(getItemDefinition(var1.field2996), getItemDefinition(var1.field2995));
         }

         if(!CombatInfoListHolder.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2992 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field2991 = 0;
         }

         ItemComposition.field2949.put(var1, (long)var0);
         return var1;
      }
   }
}
