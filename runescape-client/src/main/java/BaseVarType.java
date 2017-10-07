import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("BaseVarType")
public enum BaseVarType implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   @Export("INTEGER")
   INTEGER(0, 0, Integer.class, new class2()),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1650721349
   )
   final int field29;
   @ObfuscatedName("og")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   static SpritePixels field33;
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static IndexData field34;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1102820803
   )
   final int field36;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Ld;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field29 = var3;
      this.field36 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field36;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1770943711"
   )
   static final void method13(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class93.loadWidget(var0)) {
         class31.field457 = null;
         WorldMapType2.gameDraw(class177.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class31.field457 != null) {
            WorldMapType2.gameDraw(class31.field457, -1412584499, var1, var2, var3, var4, GraphicsObject.field1358, class39.field546, var7);
            class31.field457 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1118[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1118[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([Lhj;Lhj;ZI)V",
      garbageValue = "1111171552"
   )
   static void method17(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      FaceNormal.method2938(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         FaceNormal.method2938(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class93.loadWidget(var6)) {
            FaceNormal.method2938(class177.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILhh;I)Lcv;",
      garbageValue = "-950271913"
   )
   static Script method15(int var0, class219 var1) {
      Script var2 = (Script)Script.field1518.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class51.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class51.indexScripts.method4224(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class219.method4177(var5);
               if(var2 != null) {
                  Script.field1518.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-236155284"
   )
   static final void method16(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class61.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1][var3 + var2] = class61.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var3 + var1][var2] = class61.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class61.tileHeights[var0][var1 - 1][var2] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class61.tileHeights[var0][var1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class61.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "89045784"
   )
   static int method14(int var0) {
      MessageNode var1 = (MessageNode)class96.field1508.get((long)var0);
      return var1 == null?-1:(var1.next == class96.field1509.field2504?-1:((MessageNode)var1.next).id);
   }
}
