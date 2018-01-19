import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements TaskDataProvider {
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -506042647
   )
   static int field624;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1670658229
   )
   static int field623;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ldd;",
      garbageValue = "384581081"
   )
   public AbstractSoundSystem taskData() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)[Lkg;",
      garbageValue = "1794938953"
   )
   static SpritePixels[] method758() {
      SpritePixels[] var0 = new SpritePixels[class299.field3872];

      for(int var1 = 0; var1 < class299.field3872; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class299.field3868;
         var2.maxHeight = class299.field3867;
         var2.offsetX = class299.field3870[var1];
         var2.offsetY = class299.offsetsY[var1];
         var2.width = class54.field635[var1];
         var2.height = UrlRequester.field2099[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class188.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class299.field3869[var4[var5] & 255];
         }
      }

      class139.method2922();
      return var0;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-129728281"
   )
   static final void method761(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4828()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1153 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field958[var4][var5] == Client.field919) {
                     continue;
                  }

                  Client.field958[var4][var5] = Client.field919;
               }

               if(!var2.composition.field3666) {
                  var3 -= Integer.MIN_VALUE;
               }

               class45.region.method2829(class7.plane, var2.x, var2.y, MouseInput.getTileHeight(var2.field1153 * 64 - 64 + var2.x, var2.field1153 * 64 - 64 + var2.y, class7.plane), var2.field1153 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1152);
            }
         }
      }

   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "([Lhq;II)V",
      garbageValue = "-1193984410"
   )
   static final void method762(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method762(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(FontName.loadWidget(var5)) {
                     method762(Widget.widgets[var5], var1);
                  }
               }
            }

            ScriptEvent var6;
            if(var1 == 0 && var3.field2878 != null) {
               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.objs = var3.field2878;
               Preferences.method1633(var6);
            }

            if(var1 == 1 && var3.field2870 != null) {
               if(var3.index >= 0) {
                  Widget var7 = UrlRequester.getWidget(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.objs = var3.field2870;
               Preferences.method1633(var6);
            }
         }
      }

   }
}
