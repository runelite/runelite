import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class251 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Ljx;",
      garbageValue = "-111"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = WorldComparator.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method5220(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method5161(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.int3 != -1) {
            var1.method5162(getItemDefinition(var1.int3), getItemDefinition(var1.int2));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.int1 = 0;
            if(var1.field3689 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3689.getHead(); var4 != null; var4 = var1.field3689.getTail()) {
                  class278 var5 = Timer.method3375((int)var4.hash);
                  if(var5.field3545) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3689 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljk;Ljk;B)V",
      garbageValue = "-117"
   )
   public static void method4637(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      Sequence.seq_ref = var0;
      UnitPriceComparator.skel_ref = var1;
      class314.skin_ref = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Liz;",
      garbageValue = "-52"
   )
   public static BuildType method4636(int var0) {
      BuildType[] var1 = DecorativeObject.method3165();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         BuildType var3 = var1[var2];
         if(var0 == var3.field3348) {
            return var3;
         }
      }

      return null;
   }
}
