import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 700578585
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1742280241
   )
   @Export("height")
   int height;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 823892543
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -961737963
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1429840503
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1576345027
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -683998103
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -314169043
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1308771995
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1014084627
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2026204851
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -374780921
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1445617631
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Ljh;",
      garbageValue = "125"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class156.item_ref.getConfigData(10, var0);
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
            var1.method5058(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.int3 != -1) {
            var1.method5059(getItemDefinition(var1.int3), getItemDefinition(var1.int2));
         }

         if(!class154.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.int1 = 0;
            if(var1.field3683 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3683.getHead(); var4 != null; var4 = var1.field3683.getTail()) {
                  class278 var5 = Client.method1577((int)var4.hash);
                  if(var5.field3547) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3683 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1322308763"
   )
   static int method3098(int var0) {
      MessageNode var1 = (MessageNode)class95.messages.get((long)var0);
      return var1 == null?-1:(var1.next == class95.field1434.sentinel?-1:((MessageNode)var1.next).id);
   }
}
