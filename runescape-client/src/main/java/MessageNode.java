import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1337319355
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1243580987
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1321441375
   )
   @Export("type")
   int type;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   Name field824;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field820;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field821;
   @ObfuscatedName("i")
   @Export("sender")
   String sender;
   @ObfuscatedName("u")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.field820 = class303.field3851;
      this.field821 = class303.field3851;
      int var5 = ++class95.field1452 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1153();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "2119410222"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      int var5 = ++class95.field1452 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1153();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1021227538"
   )
   void method1148() {
      this.field820 = class303.field3851;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-91"
   )
   final boolean method1149() {
      if(this.field820 == class303.field3851) {
         this.method1150();
      }

      return this.field820 == class303.field3850;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "879368758"
   )
   void method1150() {
      this.field820 = WorldMapRectangle.friendManager.field1256.isMember(this.field824)?class303.field3850:class303.field3849;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-5"
   )
   void method1162() {
      this.field821 = class303.field3851;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1789850734"
   )
   final boolean method1152() {
      if(this.field821 == class303.field3851) {
         this.method1161();
      }

      return this.field821 == class303.field3850;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1799114894"
   )
   void method1161() {
      this.field821 = WorldMapRectangle.friendManager.field1254.isMember(this.field824)?class303.field3850:class303.field3849;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1987340125"
   )
   final void method1153() {
      if(this.name != null) {
         this.field824 = new Name(FontName.method5489(this.name), GZipDecompressor.loginType);
      } else {
         this.field824 = null;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "668518010"
   )
   static File method1176(String var0) {
      if(!class170.field2234) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class170.field2232.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class170.field2233, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class170.field2232.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-1068467679"
   )
   static int method1177(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class81.intStack[--WorldComparator.intStackSize];
         var4 = class44.getWidget(var3);
      } else {
         var4 = var2?class81.field1285:Signlink.field2218;
      }

      if(var0 == 1000) {
         WorldComparator.intStackSize -= 4;
         var4.originalX = class81.intStack[WorldComparator.intStackSize];
         var4.originalY = class81.intStack[WorldComparator.intStackSize + 1];
         var4.dynamicX = class81.intStack[WorldComparator.intStackSize + 2];
         var4.dynamicY = class81.intStack[WorldComparator.intStackSize + 3];
         FontName.method5490(var4);
         class23.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class86.method1889(MouseRecorder.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         WorldComparator.intStackSize -= 4;
         var4.originalWidth = class81.intStack[WorldComparator.intStackSize];
         var4.originalHeight = class81.intStack[WorldComparator.intStackSize + 1];
         var4.dynamicWidth = class81.intStack[WorldComparator.intStackSize + 2];
         var4.buttonType = class81.intStack[WorldComparator.intStackSize + 3];
         FontName.method5490(var4);
         class23.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class86.method1889(MouseRecorder.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class81.intStack[--WorldComparator.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            FontName.method5490(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class81.intStack[--WorldComparator.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.noScrollThrough = class81.intStack[--WorldComparator.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-769054461"
   )
   static final boolean method1179(int var0, int var1) {
      ObjectComposition var2 = GameCanvas.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4996(var1);
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "123"
   )
   @Export("drawObject")
   static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class255.region.getWallObjectHash(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class255.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = BoundingBox2D.minimapSprite.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = GameCanvas.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = GroundObject.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.width * 4 - var14.width) / 2;
               int var16 = (var13.length * 4 - var14.height) / 2;
               var14.method5825(var1 * 4 + var15 + 48, var16 + (104 - var2 - var13.length) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class255.region.method2888(var0, var1, var2);
      if(var5 != 0) {
         var6 = class255.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = GameCanvas.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = GroundObject.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.width * 4 - var17.width) / 2;
               var18 = (var23.length * 4 - var17.height) / 2;
               var17.method5825(var12 + var1 * 4 + 48, (104 - var2 - var23.length) * 4 + var18 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = BoundingBox2D.minimapSprite.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class255.region.getGroundObjectHash(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = GameCanvas.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = GroundObject.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.width * 4 - var20.width) / 2;
               int var21 = (var19.length * 4 - var20.height) / 2;
               var20.method5825(var9 + var1 * 4 + 48, var21 + (104 - var2 - var19.length) * 4 + 48);
            }
         }
      }

   }
}
