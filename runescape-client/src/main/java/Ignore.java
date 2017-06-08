import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("p")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("n")
   @Export("name")
   String name;

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "-11"
   )
   static boolean method1079(Widget var0) {
      if(Client.field1086) {
         if(class251.method4472(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "198590217"
   )
   static void method1080(World var0) {
      if(var0.method1518() != Client.isMembers) {
         Client.isMembers = var0.method1518();
         boolean var1 = var0.method1518();
         if(var1 != ItemComposition.isMembersWorld) {
            ItemComposition.field3501.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            ItemComposition.isMembersWorld = var1;
         }
      }

      WallObject.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class36.field506 = Client.field915 == 0?'ꩊ':var0.id + '鱀';
      class177.field2423 = Client.field915 == 0?443:var0.id + '썐';
      class66.field803 = class36.field506;
   }
}
