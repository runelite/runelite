import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class120 {
   @ObfuscatedName("w")
   @Export("Viewport_containsMouse")
   static boolean Viewport_containsMouse;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1071935907
   )
   @Export("Viewport_mouseX")
   static int Viewport_mouseX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -831543585
   )
   @Export("Viewport_mouseY")
   static int Viewport_mouseY;
   @ObfuscatedName("b")
   @Export("Viewport_false0")
   static boolean Viewport_false0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1611736783
   )
   static int field1684;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2958943
   )
   static int field1685;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1128491825
   )
   static int field1682;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -817355445
   )
   @Export("Viewport_entityCountAtMouse")
   public static int Viewport_entityCountAtMouse;
   @ObfuscatedName("g")
   public static long[] field1688;

   static {
      Viewport_containsMouse = false;
      Viewport_mouseX = 0;
      Viewport_mouseY = 0;
      Viewport_false0 = false;
      Viewport_entityCountAtMouse = 0;
      field1688 = new long[1000];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)J",
      garbageValue = "2020124957"
   )
   static long method2812(int var0, int var1, int var2) {
      return (long)(var2 << 16 | var0 << 8 | var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Ljm;",
      garbageValue = "60"
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
            var1.updateNote(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method5106(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.placeholderTemplateId != -1) {
            var1.method5137(getItemDefinition(var1.placeholderTemplateId), getItemDefinition(var1.placeholderId));
         }

         if(!GrandExchangeOffer.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.shiftClickIndex = -1;
            var1.team = 0;
            if(var1.params != null) {
               boolean var3 = false;

               for(Node var4 = var1.params.getHead(); var4 != null; var4 = var1.params.getTail()) {
                  class264 var5 = Buffer.method3811((int)var4.hash);
                  if(var5.field3349) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.params = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1058200071"
   )
   public static void method2815() {
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "780822000"
   )
   static final void method2813(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method5194()) {
            int var3 = var2.x >> 7;
            int var4 = var2.y >> 7;
            if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
               if(var2.field885 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field689[var3][var4] == Client.field690) {
                     continue;
                  }

                  Client.field689[var3][var4] = Client.field690;
               }

               long var5 = class59.method1129(0, 0, 1, !var2.composition.field3535, Client.npcIndices[var1]);
               var2.field905 = Client.gameCycle;
               ScriptEvent.region.method2945(class192.plane, var2.x, var2.y, class264.getTileHeight(var2.field885 * 64 - 64 + var2.x, var2.field885 * 64 - 64 + var2.y, class192.plane), var2.field885 * 64 - 64 + 60, var2, var2.angle, var5, var2.field884);
            }
         }
      }

   }
}
