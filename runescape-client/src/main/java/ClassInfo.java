import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("u")
   public static short[][] field3729;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -481810017
   )
   public int field3730;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1561890603
   )
   @Export("count")
   public int count;
   @ObfuscatedName("y")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("g")
   @Export("type")
   public int[] type;
   @ObfuscatedName("w")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("k")
   public int[] field3731;
   @ObfuscatedName("v")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("z")
   @Export("args")
   public byte[][][] args;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lii;",
      garbageValue = "-1852233194"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class83.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4586(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4638(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3530 != -1) {
            var1.method4588(getItemDefinition(var1.field3530), getItemDefinition(var1.field3529));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3521 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3524 = 0;
            if(var1.field3525 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3525.getHead(); var4 != null; var4 = var1.field3525.getTail()) {
                  class252 var5 = Coordinates.method3948((int)var4.hash);
                  if(var5.field3382) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3525 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }
}
