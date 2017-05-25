import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class51 implements class103 {
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 571190575
   )
   static int field646;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -1377958395
   )
   static int field647;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1653705985
   )
   static int field648;
   @ObfuscatedName("k")
   static int[] field650;
   @ObfuscatedName("dc")
   static class153 field654;
   @ObfuscatedName("u")
   static IndexDataBase field656;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-474278847"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field3485.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field3516.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method4644();
         if(var1.notedTemplate != -1) {
            var1.method4649(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field3533 != -1) {
            var1.method4661(getItemDefinition(var1.field3533), getItemDefinition(var1.field3529));
         }

         if(var1.field3535 != -1) {
            var1.method4634(getItemDefinition(var1.field3535), getItemDefinition(var1.field3534));
         }

         if(!class231.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3531 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3491 = 0;
            if(var1.field3530 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3530.method3562(); var4 != null; var4 = var1.field3530.method3558()) {
                  class251 var5 = class54.method790((int)var4.hash);
                  if(var5.field3384) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3530 = null;
               }
            }
         }

         ItemComposition.field3485.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lclass109;",
      garbageValue = "1077254174"
   )
   public class109 vmethod1947() {
      return new class55();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-477670398"
   )
   static int method772(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3615((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }
}
