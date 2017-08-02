import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public abstract class class163 {
   @ObfuscatedName("s")
   @Export("validInterfaces")
   static boolean[] validInterfaces;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1854780565
   )
   public int field2274;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1593368737
   )
   public int field2272;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1916007497
   )
   public int field2273;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 534552955
   )
   public int field2275;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILfu;I)Z",
      garbageValue = "2144325259"
   )
   protected abstract boolean vmethod2998(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Liy;",
      garbageValue = "-1424986909"
   )
   public static FloorUnderlayDefinition method3000(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "24"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class112.font_p12full.method4637(var0, 250);
      int var6 = class112.font_p12full.method4638(var0, 250) * 13;
      Rasterizer2D.method4828(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2, 16777215);
      class112.font_p12full.method4644(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class140.method2793(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2);
      if(var1) {
         WorldMapType1.field417.vmethod4917(0, 0);
      } else {
         int var7 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field1107; ++var11) {
            if(Client.widgetBoundsWidth[var11] + Client.widgetPositionX[var11] > var7 && Client.widgetPositionX[var11] < var7 + var9 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
               Client.field1064[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1666451503"
   )
   static boolean method2999(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1704605380"
   )
   static final int method2994() {
      if(class34.preferences.hideRoofs) {
         return class10.plane;
      } else {
         int var0 = class23.getTileHeight(class73.cameraX, Client.cameraY, class10.plane);
         return var0 - WidgetNode.cameraZ < 800 && (class61.tileSettings[class10.plane][class73.cameraX >> 7][Client.cameraY >> 7] & 4) != 0?class10.plane:3;
      }
   }
}
