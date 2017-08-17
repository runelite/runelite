import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   static class47 field1666;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Ldc;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2031();
            }
         }
      } catch (Exception var4) {
         Varcs.method1853((String)null, var4);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lif;",
      garbageValue = "614409981"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class18.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4597(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4598(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3530 != -1) {
            var1.method4632(getItemDefinition(var1.field3530), getItemDefinition(var1.field3529));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3508 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3524 = 0;
            if(var1.field3525 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3525.getHead(); var4 != null; var4 = var1.field3525.getTail()) {
                  class252 var5 = BuildType.method4100((int)var4.hash);
                  if(var5.field3378) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lch;I)V",
      garbageValue = "-1315136639"
   )
   static void method2101(World var0) {
      if(var0.method1579() != Client.isMembers) {
         Client.isMembers = var0.method1579();
         boolean var1 = var0.method1579();
         if(var1 != ItemComposition.isMembersWorld) {
            ItemComposition.items.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            ItemComposition.isMembersWorld = var1;
         }
      }

      class165.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class281.field3741 = Client.socketType == 0?'ꩊ':var0.id + '鱀';
      class25.field377 = Client.socketType == 0?443:var0.id + '썐';
      WidgetNode.myWorldPort = class281.field3741;
   }
}
