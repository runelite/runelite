import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("x")
   boolean field805;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -805232959
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1770047139
   )
   @Export("owner")
   int owner;

   WidgetNode() {
      this.field805 = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Liv;",
      garbageValue = "-148769420"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3459 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1597797660"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3209 != 0 && var3 > IndexDataBase.field3209) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3209 == 0 || var6 <= IndexDataBase.field3209)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class167.method3142(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-119"
   )
   static final void method1114(int var0) {
      class83.method1680();
      class207.method3883();
      int var1 = WorldMapType3.method181(var0).configType;
      if(var1 != 0) {
         int var2 = class211.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field1119) {
               if(Client.field1119 == 0 && Client.field1069 != -1) {
                  class177.method3419(class2.indexTrack1, Client.field1069, 0, var3, false);
                  Client.field1121 = false;
               } else if(var3 == 0) {
                  class48.method729();
                  Client.field1121 = false;
               } else if(class203.field2475 != 0) {
                  class203.field2474 = var3;
               } else {
                  class203.field2473.method3709(var3);
               }

               Client.field1119 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1125 = 127;
            }

            if(var2 == 1) {
               Client.field1125 = 96;
            }

            if(var2 == 2) {
               Client.field1125 = 64;
            }

            if(var2 == 3) {
               Client.field1125 = 32;
            }

            if(var2 == 4) {
               Client.field1125 = 0;
            }
         }

         if(var1 == 5) {
            Client.field1020 = var2;
         }

         if(var1 == 6) {
            Client.field1045 = var2;
         }

         if(var1 == 9) {
            Client.field1046 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1123 = 127;
            }

            if(var2 == 1) {
               Client.field1123 = 96;
            }

            if(var2 == 2) {
               Client.field1123 = 64;
            }

            if(var2 == 3) {
               Client.field1123 = 32;
            }

            if(var2 == 4) {
               Client.field1123 = 0;
            }
         }

         if(var1 == 17) {
            Client.field1051 = var2 & '\uffff';
         }

         class91[] var4;
         if(var1 == 18) {
            var4 = new class91[]{class91.field1384, class91.field1385, class91.field1386, class91.field1393};
            Client.field1117 = (class91)CollisionData.forOrdinal(var4, var2);
            if(Client.field1117 == null) {
               Client.field1117 = class91.field1386;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field927 = -1;
            } else {
               Client.field927 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var4 = new class91[]{class91.field1384, class91.field1385, class91.field1386, class91.field1393};
            Client.field918 = (class91)CollisionData.forOrdinal(var4, var2);
            if(Client.field918 == null) {
               Client.field918 = class91.field1386;
            }
         }

      }
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lfw;B)V",
      garbageValue = "37"
   )
   static void method1111(Buffer var0) {
      if(Client.field930 != null) {
         var0.putBytes(Client.field930, 0, Client.field930.length);
      } else {
         byte[] var1 = RSCanvas.method803();
         var0.putBytes(var1, 0, var1.length);
      }
   }
}
