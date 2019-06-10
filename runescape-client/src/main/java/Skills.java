import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
@Implements("Skills")
public class Skills {
   @ObfuscatedName("f")
   @Export("Skills_enabled")
   public static final boolean[] Skills_enabled;
   @ObfuscatedName("q")
   @Export("Skills_experienceTable")
   public static int[] Skills_experienceTable;
   @ObfuscatedName("ef")
   @Export("__hc_ef")
   static int[] __hc_ef;

   static {
      Skills_enabled = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      Skills_experienceTable = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         Skills_experienceTable[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljv;",
      garbageValue = "-1410801622"
   )
   @Export("getItemDefinition")
   public static ItemDefinition getItemDefinition(int var0) {
      ItemDefinition var1 = (ItemDefinition)ItemDefinition.ItemDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemDefinition.ItemDefinition_indexCache.takeRecord(10, var0);
         var1 = new ItemDefinition();
         var1.id = var0;
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         var1.post();
         if(var1.noteTemplate != -1) {
            var1.__o_426(getItemDefinition(var1.noteTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.__u_427(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.placeholderTemplate != -1) {
            var1.__g_428(getItemDefinition(var1.placeholderTemplate), getItemDefinition(var1.placeholder));
         }

         if(!class30.inMembersWorld && var1.isMembersOnly) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.shiftClickIndex0 = -1;
            var1.int1 = 0;
            if(var1.params != null) {
               boolean var3 = false;

               for(Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
                  ParamKeyDefinition var5 = class229.getParamKeyDefinition((int)var4.key);
                  if(var5.isMembersOnly) {
                     var4.remove();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.params = null;
               }
            }
         }

         ItemDefinition.ItemDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }
}
