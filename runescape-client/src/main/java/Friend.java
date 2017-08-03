import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("l")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("s")
   static int[] field779;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1086465255
   )
   @Export("world")
   int world;
   @ObfuscatedName("e")
   boolean field782;
   @ObfuscatedName("f")
   boolean field780;
   @ObfuscatedName("q")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 262417747
   )
   @Export("rank")
   int rank;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lix;",
      garbageValue = "-2019209785"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4556(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4542(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3520 != -1) {
            var1.method4543(getItemDefinition(var1.field3520), getItemDefinition(var1.field3519));
         }

         if(!class37.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3516 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3515 = 0;
            if(var1.field3495 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3495.getHead(); var4 != null; var4 = var1.field3495.getTail()) {
                  class251 var5 = Script.method1857((int)var4.hash);
                  if(var5.field3370) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3495 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "-29"
   )
   static int method1108(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class214.field2615:class73.field851;
      if(var0 == 1800) {
         class83.intStack[++class83.intStackSize - 1] = MilliTimer.method2938(class169.getWidgetConfig(var3));
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class83.intStack[--class83.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-884845565"
   )
   static int method1105(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field946 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lcc;",
      garbageValue = "-2030215565"
   )
   static World method1106() {
      World.field1261 = 0;
      World var0;
      if(World.field1261 < World.worldCount) {
         var0 = World.worldList[++World.field1261 - 1];
      } else {
         var0 = null;
      }

      return var0;
   }
}
