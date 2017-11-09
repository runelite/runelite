import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class250 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   static NodeCache field3371;
   @ObfuscatedName("i")
   public boolean field3370;

   static {
      field3371 = new NodeCache(64);
   }

   class250() {
      this.field3370 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "-892885908"
   )
   void method4491(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4496(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "1005303401"
   )
   void method4496(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3370 = true;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljx;",
      garbageValue = "-567064807"
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
            var1.method4753(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4752(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3594 != -1) {
            var1.method4784(getItemDefinition(var1.field3594), getItemDefinition(var1.field3593));
         }

         if(!class246.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3590 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3588 = 0;
            if(var1.field3576 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3576.getHead(); var4 != null; var4 = var1.field3576.getTail()) {
                  class258 var5 = PacketBuffer.method3597((int)var4.hash);
                  if(var5.field3445) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3576 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;Ljava/lang/String;I)Lko;",
      garbageValue = "-1820090326"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!class72.method1184(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class34.method511();
      }

      return var5;
   }
}
