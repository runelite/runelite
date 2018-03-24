import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class38 {
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -593025733
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "[Llk;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljf;",
      garbageValue = "1152972080"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class241.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lla;IIII)V",
      garbageValue = "1118821020"
   )
   static void method550(SpritePixels var0, int var1, int var2, int var3) {
      class213 var4 = WorldMapRegion.field457;
      long var6 = (long)(var3 << 16 | var1 << 8 | var2);
      var4.method3954(var0, var6, var0.pixels.length * 4);
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-181624143"
   )
   static void method549() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(Script.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = GZipDecompressor.getWidget(var4);
               if(var5 != null) {
                  GameEngine.method1053(var5);
               }
            }
         }
      }

   }
}
