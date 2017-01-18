import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class88 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -921443657
   )
   static int field1530;
   @ObfuscatedName("o")
   static int[] field1531;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LItemComposition;",
      garbageValue = "-112"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2938.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field2935.method3272(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3652();
         if(var1.notedTemplate != -1) {
            var1.method3636(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field2983 != -1) {
            var1.method3637(getItemDefinition(var1.field2983), getItemDefinition(var1.field2941));
         }

         if(var1.field2942 != -1) {
            var1.method3679(getItemDefinition(var1.field2942), getItemDefinition(var1.field2984));
         }

         if(!Buffer.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2981 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = 0;
         }

         ItemComposition.field2938.put(var1, (long)var0);
         return var1;
      }
   }
}
