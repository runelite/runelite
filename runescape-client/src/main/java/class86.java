import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class86 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 831517577
   )
   public static int field1330;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Ljg;",
      garbageValue = "2117568439"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(I)Llp;",
      garbageValue = "-875959999"
   )
   static RenderOverview method1892() {
      return Preferences.renderOverview;
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "([Lin;Lin;ZI)V",
      garbageValue = "1596851149"
   )
   static void method1889(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      KeyFocusListener.method787(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         KeyFocusListener.method787(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         class44.method666(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
