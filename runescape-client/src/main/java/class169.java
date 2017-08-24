import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class169 {
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -1334146753
   )
   static int field2340;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1277835151
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;

   static {
      new HashMap();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lix;",
      garbageValue = "-127"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FileOnDisk.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4555(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4609(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3497 != -1) {
            var1.method4570(getItemDefinition(var1.field3497), getItemDefinition(var1.field3536));
         }

         if(!class2.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3487 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3531 = 0;
            if(var1.field3532 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3532.getHead(); var4 != null; var4 = var1.field3532.getTail()) {
                  class252 var5 = class48.method774((int)var4.hash);
                  if(var5.field3391) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3532 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "400569116"
   )
   static int method3211(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "5348"
   )
   public static boolean method3212(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
