import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("h")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("u")
   @Export("stackSizes")
   int[] stackSizes;
   @ObfuscatedName("i")
   @Export("itemContainers")
   static XHashTable itemContainers;

   static {
      itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1682461083"
   )
   public static SpritePixels[] method1083(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4189(var1);
      int var4 = var0.method4190(var3, var2);
      SpritePixels[] var5;
      if(!class228.method4155(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class286.field3786];

         for(int var8 = 0; var8 < class286.field3786; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.maxWidth = class286.field3784;
            var9.maxHeight = class286.field3787;
            var9.offsetX = class286.field3785[var8];
            var9.offsetY = class286.field3783[var8];
            var9.width = class252.field3387[var8];
            var9.height = class267.field3667[var8];
            int var10 = var9.width * var9.height;
            byte[] var11 = MessageNode.field843[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class87.field1355[var11[var12] & 255];
            }
         }

         class69.method1117();
         var5 = var7;
      }

      return var5;
   }

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Lclass241;",
      garbageValue = "-128"
   )
   public static class241 method1091(int var0) {
      class241 var1 = (class241)class241.field3270.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class241.field3273.getConfigData(16, var0);
         var1 = new class241();
         if(var2 != null) {
            var1.method4356(new Buffer(var2));
         }

         class241.field3270.put(var1, (long)var0);
         return var1;
      }
   }
}
