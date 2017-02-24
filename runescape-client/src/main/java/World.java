import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("World")
public class World {
   @ObfuscatedName("v")
   @Export("activity")
   String activity;
   @ObfuscatedName("j")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("b")
   @Export("address")
   String address;
   @ObfuscatedName("c")
   static int[] field697 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("i")
   static int[] field698 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1005160497
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -956782709
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2120743919
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1718033259
   )
   static int field703 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1636278889
   )
   @Export("location")
   int location;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1679173391
   )
   @Export("index")
   int index;
   @ObfuscatedName("nn")
   static class65 field706;
   @ObfuscatedName("eo")
   static SpritePixels[] field709;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1238970531
   )
   static int field711 = 0;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-70"
   )
   boolean method645() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-44"
   )
   boolean method646() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "88"
   )
   boolean method647() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-311787718"
   )
   boolean method648() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1853438574"
   )
   static int method650(int var0) {
      MessageNode var1 = (MessageNode)class47.field951.method2372((long)var0);
      return null == var1?-1:(var1.previous == class47.field948.field1900?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-95"
   )
   boolean method668() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2000684403"
   )
   static final int method671() {
      if(class184.field2735.field714) {
         return WallObject.plane;
      } else {
         int var0 = class2.method19(VertexNormal.cameraX, class37.cameraY, WallObject.plane);
         return var0 - class36.cameraZ < 800 && (class10.tileSettings[WallObject.plane][VertexNormal.cameraX >> 7][class37.cameraY >> 7] & 4) != 0?WallObject.plane:3;
      }
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "-1340325081"
   )
   static final void method672(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && Widget.validInterfaces[var2]) {
         Widget.field2271.method3315(var2);
         if(null != Widget.widgets[var2]) {
            boolean var6 = true;

            for(var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(Widget.widgets[var2][var5] != null) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               Widget.widgets[var2] = null;
            }

            Widget.validInterfaces[var2] = false;
         }
      }

      class143.method2737(var2);
      Widget var4 = class179.method3296(var3);
      if(null != var4) {
         class174.method3276(var4);
      }

      class13.method173();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(class30.method696(var5)) {
            class164.method3159(Widget.widgets[var5], 1);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1855649599"
   )
   static final int method674(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2069959719"
   )
   boolean method678() {
      return (2 & this.mask) != 0;
   }
}
