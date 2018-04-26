import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class1 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   static final class1 field6;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   static final class1 field1;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   static final class1 field2;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   static final class1 field3;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   static final class1 field0;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   static final class1 field7;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   static final class1 field5;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1144417733
   )
   final int field4;

   static {
      field6 = new class1(2);
      field1 = new class1(6);
      field2 = new class1(4);
      field3 = new class1(1);
      field0 = new class1(3);
      field7 = new class1(0);
      field5 = new class1(5);
   }

   class1(int var1) {
      this.field4 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "-100"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1215173221"
   )
   static final void method1() {
      Client.field911.close();
      VarCInt.method4881();
      FloorUnderlayDefinition.underlays.reset();
      KitDefinition.identKits.reset();
      ScriptVarType.method23();
      class23.method182();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      LoginPacket.method3505();
      class152.method3204();
      Varbit.varbits.reset();
      class71.method1205();
      GameSocket.method3447();
      class36.method546();
      class279.field3553.reset();
      class278.field3545.reset();
      TotalQuantityComparator.method91();
      PlayerComposition.field2802.reset();
      class171.method3395();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1437.reset();
      MouseInput.indexInterfaces.reset();
      CombatInfoListHolder.indexSoundEffects.reset();
      class7.indexCache3.reset();
      class27.indexCache4.reset();
      SoundTaskDataProvider.indexMaps.reset();
      class7.indexTrack1.reset();
      class28.indexModels.reset();
      UnitPriceComparator.indexSprites.reset();
      WorldMapRectangle.indexTextures.reset();
      Occluder.indexCache10.reset();
      class190.indexTrack2.reset();
      MapIcon.indexScripts.reset();
      GameSocket.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class229.field2694 = 1;
      class132.field1905 = null;
      class321.field3940 = -1;
      class132.field1897 = -1;
      AttackOption.field1334 = 0;
      Signlink.field2193 = false;
      class20.field335 = 2;
      Client.field1084 = -1;
      Client.field1085 = false;
      NetWriter.method2150();
      class55.setGameState(10);
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-180781084"
   )
   static final void method2(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1125 - Client.field1100) * var5 / 100 + Client.field1100;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1106) {
         var15 = Client.field1106;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1026) {
            var6 = Client.field1026;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field940) {
         var15 = Client.field940;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field883) {
            var6 = Client.field883;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1103 - Client.field1102) * var5 / 100 + Client.field1102;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.buildVisibilityMaps(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Liz;I)Ljava/lang/String;",
      garbageValue = "21208401"
   )
   static String method3(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + MouseRecorder.method1166(MapIconReference.method758(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }

   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "(Liz;I)I",
      garbageValue = "414903591"
   )
   @Export("getWidgetClickMask")
   static int getWidgetClickMask(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.value:var0.clickMask;
   }
}
