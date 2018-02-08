import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("World")
public class World {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1932121885
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1025177045
   )
   static int field1185;
   @ObfuscatedName("d")
   static int[] field1186;
   @ObfuscatedName("z")
   static int[] field1187;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1138658645
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -392833049
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1204813963
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("f")
   @Export("address")
   String address;
   @ObfuscatedName("q")
   @Export("activity")
   String activity;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1451119293
   )
   @Export("location")
   int location;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -734576747
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1185 = 0;
      field1186 = new int[]{1, 1, 1, 1};
      field1187 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1754934647"
   )
   boolean method1621() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-26"
   )
   boolean method1656() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1924413214"
   )
   boolean method1635() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1381794573"
   )
   boolean method1624() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-21777"
   )
   boolean method1654() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-987984627"
   )
   boolean method1627() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Liu;",
      garbageValue = "1418620201"
   )
   public static CombatInfo2 method1664(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3442.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3447.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         CombatInfo2.field3442.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "200446003"
   )
   static final void method1662(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         WorldComparator.preferences.hideRoofs = !WorldComparator.preferences.hideRoofs;
         CombatInfo1.method1618();
         if(WorldComparator.preferences.hideRoofs) {
            SoundTaskDataProvider.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            SoundTaskDataProvider.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.drawBoundingBoxes3D) {
               class7.drawBoundingBoxes3D = true;
               class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ALWAYS;
            } else if(class7.boundingBox3DDrawMode == BoundingBox3DDrawMode.ALWAYS) {
               class7.drawBoundingBoxes3D = true;
               class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
            } else {
               class7.drawBoundingBoxes3D = false;
            }
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class263.method4864();
         }

         if(var0.equalsIgnoreCase("cs")) {
            SoundTaskDataProvider.sendGameMessage(99, "", "" + Client.field1054);
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      PacketNode var1 = Script.method2025(ClientPacket.field2322, Client.field937.field1454);
      var1.packetBuffer.putByte(var0.length() + 1);
      var1.packetBuffer.putString(var0);
      Client.field937.method2044(var1);
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-12"
   )
   static final int method1659() {
      if(WorldComparator.preferences.hideRoofs) {
         return class60.plane;
      } else {
         int var0 = MessageNode.getTileHeight(class89.cameraX, class3.cameraY, class60.plane);
         return var0 - class216.cameraZ < 800 && (class62.tileSettings[class60.plane][class89.cameraX >> 7][class3.cameraY >> 7] & 4) != 0?class60.plane:3;
      }
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "175522160"
   )
   static final void method1660() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if(var0.hitpoints == 0) {
            if(var0.field1103 >= 0) {
               var2 = var0.field1103;
               var3 = var0.field1105;
               var4 = class219.getObjectDefinition(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method4955(var3);
               if(!var1) {
                  continue;
               }
            }

            MouseRecorder.method1077(var0.level, var0.type, var0.x, var0.y, var0.field1103, var0.field1104, var0.field1105);
            var0.unlink();
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102) {
               if(var0.id >= 0) {
                  var2 = var0.id;
                  var3 = var0.field1108;
                  var4 = class219.getObjectDefinition(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method4955(var3);
                  if(!var1) {
                     continue;
                  }
               }

               MouseRecorder.method1077(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1108);
               var0.delay = -1;
               if(var0.field1103 == var0.id && var0.field1103 == -1) {
                  var0.unlink();
               } else if(var0.field1103 == var0.id && var0.orientation == var0.field1104 && var0.field1108 == var0.field1105) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16711680"
   )
   static void method1632() {
      if(Client.spellSelected) {
         Widget var0 = class44.getWidgetChild(class249.field3357, Client.field1038);
         if(var0 != null && var0.field2781 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.objs = var0.field2781;
            class84.method1868(var1);
         }

         Client.spellSelected = false;
         class33.method341(var0);
      }
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1642509560"
   )
   static void method1661(int var0) {
      for(IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
         if((var1.hash >> 48 & 65535L) == (long)var0) {
            var1.unlink();
         }
      }

   }
}
