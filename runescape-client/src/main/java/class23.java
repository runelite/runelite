import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class23 {
   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "([Lhg;IIIZI)V",
      garbageValue = "-188237791"
   )
   static void method171(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class204.method3697(var6, var2, var3, var4);
            class228.method4086(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               Player.method1171(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-28354025"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class290.font_p12full.method4773(var0, 250);
      int var6 = class290.font_p12full.method4774(var0, 250) * 13;
      Rasterizer2D.method4973(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2, 16777215);
      class290.font_p12full.method4780(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      RSSocket.method3044(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6);
      if(var1) {
         class19.field322.vmethod5051(0, 0);
      } else {
         class60.method1024(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1510618933"
   )
   static void method170() {
      for(class82 var0 = (class82)class82.field1314.getFront(); var0 != null; var0 = (class82)class82.field1314.getNext()) {
         if(var0.field1316 != null) {
            class36.field513.method1934(var0.field1316);
            var0.field1316 = null;
         }

         if(var0.field1312 != null) {
            class36.field513.method1934(var0.field1312);
            var0.field1312 = null;
         }
      }

      class82.field1314.clear();
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "0"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class9.method50(var0, class29.field422);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class9.method50(var3.name, class29.field422))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class9.method50(var3.previousName, class29.field422))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "1017683361"
   )
   static int method174(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class266.method4862(class84.intStack[--class84.intStackSize]);
      } else {
         var3 = var2?class269.field3661:DecorativeObject.field2164;
      }

      class255.method4531(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class84.intStack[--class84.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class54.localPlayer.composition.method3959();
            return 1;
         } else {
            return 2;
         }
      } else {
         class84.intStackSize -= 2;
         int var4 = class84.intStack[class84.intStackSize];
         int var5 = class84.intStack[class84.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = ClassInfo.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2663 = var6.offsetX2d;
         var3.field2621 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2681 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2681 = 1;
         } else {
            var3.field2681 = 2;
         }

         if(var3.field2678 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2678;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)Lbs;",
      garbageValue = "121"
   )
   static MessageNode method173(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class99.chatLineMap.get(Integer.valueOf(var0));
      return var2.method1907(var1);
   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(I)Lkv;",
      garbageValue = "1032723323"
   )
   static RenderOverview method172() {
      return BaseVarType.renderOverview;
   }
}
