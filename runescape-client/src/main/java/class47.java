import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class47 {
   @ObfuscatedName("c")
   static final class142 field924;
   @ObfuscatedName("d")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -216656953
   )
   static int field926;
   @ObfuscatedName("n")
   static final class157 field927;
   @ObfuscatedName("bk")
   static ModIcon field928;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "2037884848"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2982.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field2979.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3736();
         if(var1.notedTemplate != -1) {
            var1.method3739(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field3030 != -1) {
            var1.method3767(getItemDefinition(var1.field3030), getItemDefinition(var1.field3029));
         }

         if(var1.field3000 != -1) {
            var1.method3745(getItemDefinition(var1.field3000), getItemDefinition(var1.field3016));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3017 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field2995 = 0;
            if(var1.field2988 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field2988.method2730(); var4 != null; var4 = var1.field2988.method2732()) {
                  class198 var5 = class183.method3292((int)var4.hash);
                  if(var5.field2875) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field2988 = null;
               }
            }
         }

         ItemComposition.field2982.put(var1, (long)var0);
         return var1;
      }
   }

   static {
      chatLineMap = new HashMap();
      field924 = new class142(1024);
      field927 = new class157();
      field926 = 0;
   }

   class47() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "78239739"
   )
   static final void method901() {
      for(int var0 = 0; var0 < Client.field321; ++var0) {
         int var1 = Client.field350[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            WidgetNode.method198(var2, var2.composition.field3042);
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-90"
   )
   static void method902() {
      chatLineMap.clear();
      field924.method2746();
      field927.method2884();
      field926 = 0;
   }
}
