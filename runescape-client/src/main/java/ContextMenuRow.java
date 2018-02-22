import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("pf")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   @Export("friendManager")
   public static FriendManager friendManager;
   @ObfuscatedName("h")
   static byte[][][] field1282;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1016726501
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1740535819
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -395823977
   )
   @Export("type")
   int type;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2101389723
   )
   @Export("identifier")
   int identifier;
   @ObfuscatedName("a")
   @Export("option")
   String option;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Ljx;",
      garbageValue = "-68"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method5002(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method5022(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.int3 != -1) {
            var1.method5035(getItemDefinition(var1.int3), getItemDefinition(var1.int2));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.int1 = 0;
            if(var1.field3573 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3573.getHead(); var4 != null; var4 = var1.field3573.getTail()) {
                  class271 var5 = class157.method3163((int)var4.hash);
                  if(var5.field3479) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3573 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1789163745"
   )
   public static void method1858(int var0, int var1) {
      Varbit var3 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = UnitPriceComparator.varbit_ref.getConfigData(14, var0);
         var3 = new Varbit();
         if(var8 != null) {
            var3.decode(new Buffer(var8));
         }

         Varbit.varbits.put(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.configId;
      int var5 = var2.leastSignificantBit;
      int var6 = var2.mostSignificantBit;
      int var7 = class231.varpsMasks[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class231.widgetSettings[var4] = class231.widgetSettings[var4] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2093696065"
   )
   static final int method1860(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1062947285"
   )
   static final void method1859(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         Client.preferences.hideRoofs = !Client.preferences.hideRoofs;
         VertexNormal.method2802();
         if(Client.preferences.hideRoofs) {
            class149.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class149.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(var0.equalsIgnoreCase("renderself")) {
         Client.field925 = !Client.field925;
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
            if(Client.field864 > 0) {
               VertexNormal.method2800();
            } else {
               Client.field912.method5599();
               WorldMapType1.setGameState(40);
               class1.field11 = Client.field863.getSocket();
               Client.field863.method2035();
            }
         }

         if(var0.equalsIgnoreCase("cs")) {
            class149.sendGameMessage(99, "", "" + Client.field866);
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      PacketNode var1 = class61.method1076(ClientPacket.field2429, Client.field863.field1434);
      var1.packetBuffer.putByte(var0.length() + 1);
      var1.packetBuffer.putString(var0);
      Client.field863.method2039(var1);
   }
}
