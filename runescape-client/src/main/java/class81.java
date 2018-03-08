import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class81 {
   @ObfuscatedName("l")
   static int[] field1254;
   @ObfuscatedName("b")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("e")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("p")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1799584561
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lby;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static Widget field1260;
   @ObfuscatedName("u")
   static Calendar field1262;
   @ObfuscatedName("j")
   static final String[] field1264;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1435432191
   )
   static int field1263;
   @ObfuscatedName("fu")
   static byte[][] field1253;

   static {
      field1254 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1262 = Calendar.getInstance();
      field1264 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1263 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Ljy;",
      garbageValue = "2"
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
            var1.method5042(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method5043(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.int3 != -1) {
            var1.method5073(getItemDefinition(var1.int3), getItemDefinition(var1.int2));
         }

         if(!UnitPriceComparator.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.int1 = 0;
            if(var1.field3694 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3694.getHead(); var4 != null; var4 = var1.field3694.getTail()) {
                  class278 var5 = class88.method1916((int)var4.hash);
                  if(var5.field3552) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3694 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1877894027"
   )
   public static boolean method1814(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }
}
