import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -505196129
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("fe")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1167853917
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1957506109
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2120405891
   )
   @Export("level")
   int level;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1183024183
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2114952073
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 254755159
   )
   @Export("height")
   int height;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   Sequence field1261;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 98235345
   )
   int field1258;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -578102889
   )
   int field1259;
   @ObfuscatedName("j")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1258 = 0;
      this.field1259 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class250.getSpotAnimType(this.id).field3413;
      if(var8 != -1) {
         this.finished = false;
         this.field1261 = Permission.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1327278645"
   )
   final void method1612(int var1) {
      if(!this.finished) {
         this.field1259 += var1;

         while(this.field1259 > this.field1261.frameLenghts[this.field1258]) {
            this.field1259 -= this.field1261.frameLenghts[this.field1258];
            ++this.field1258;
            if(this.field1258 >= this.field1261.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lef;",
      garbageValue = "620909653"
   )
   protected final Model getModel() {
      Spotanim var1 = class250.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1258);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;III)I",
      garbageValue = "-1618544689"
   )
   static int method1615(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "600080221"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class115.validInterfaces[var0]) {
         return true;
      } else if(!class37.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = class37.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class115.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = class37.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            class115.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "633941032"
   )
   static int method1619(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class139.field2008:AttackOption.field1306;
      }

      class33.method344(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class82.intStack[--class82.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = UrlRequest.localPlayer.composition.method4100();
            return 1;
         } else {
            return 2;
         }
      } else {
         class82.intStackSize -= 2;
         int var4 = class82.intStack[class82.intStackSize];
         int var5 = class82.intStack[class82.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = KitDefinition.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2808 = var6.offsetX2d;
         var3.field2809 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2866 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2866 = 1;
         } else {
            var3.field2866 = 2;
         }

         if(var3.field2836 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2836;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lec;",
      garbageValue = "108"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class86.method1658(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
