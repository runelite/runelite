import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("n")
   @Export("sender")
   String sender;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2137858817
   )
   @Export("id")
   int id = Renderable.method1942();
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -378850057
   )
   @Export("type")
   int type;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1084431559
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("cy")
   static class227 field811;
   @ObfuscatedName("g")
   @Export("name")
   String name;
   @ObfuscatedName("u")
   @Export("value")
   String value;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = 3363085843812369819L
   )
   static long field817;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass171;IIIBZB)V",
      garbageValue = "1"
   )
   static void method764(class171 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class175 var8 = (class175)class174.field2762.method3812(var6);
      if(var8 == null) {
         var8 = (class175)class174.field2764.method3812(var6);
         if(var8 == null) {
            var8 = (class175)class174.field2767.method3812(var6);
            if(null != var8) {
               if(var5) {
                  var8.method3924();
                  class174.field2762.method3813(var8, var6);
                  --class174.field2777;
                  ++class174.field2763;
               }

            } else {
               if(!var5) {
                  var8 = (class175)class174.field2769.method3812(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class175();
               var8.field2790 = var0;
               var8.field2783 = var3;
               var8.field2784 = var4;
               if(var5) {
                  class174.field2762.method3813(var8, var6);
                  ++class174.field2763;
               } else {
                  class174.field2765.method3903(var8);
                  class174.field2767.method3813(var8, var6);
                  ++class174.field2777;
               }

            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-3"
   )
   void method765(int var1, String var2, String var3, String var4) {
      this.id = Renderable.method1942();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1245590151"
   )
   public static String method767(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "33"
   )
   static void method769() {
      Client.field525 = -1L;
      Client.field370 = -1;
      Client.field311.field211 = 0;
      class38.field833 = true;
      Client.field562 = true;
      Client.field526 = -1L;
      class214.field3187 = new class205();
      Client.field378.offset = 0;
      Client.field347.offset = 0;
      Client.packetOpcode = -1;
      Client.field352 = 1;
      Client.field421 = -1;
      Client.field354 = -1;
      Client.field350 = 0;
      Client.field317 = 0;
      Client.field355 = 0;
      Client.field306 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class143.mouseIdleTicks = 0;
      class13.method165();
      Client.field453 = 0;
      Client.field455 = false;
      Client.field542 = 0;
      Client.field300 = (int)(Math.random() * 100.0D) - 50;
      Client.field368 = (int)(Math.random() * 110.0D) - 55;
      Client.field498 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field403 = 0;
      Client.field472 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field326 = class21.field607;
      Client.field327 = class21.field607;
      Client.field341 = 0;
      class34.field779 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class34.field784[var0] = null;
         class34.field777[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field432 = -1;
      Client.projectiles.method3863();
      Client.field436.method3863();

      int var2;
      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.field571 = new Deque();
      Client.field569 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class56.field1220; ++var0) {
         class56 var4 = class48.method982(var0);
         if(var4 != null) {
            class179.settings[var0] = 0;
            class179.widgetSettings[var0] = 0;
         }
      }

      class5.chatMessages.method208();
      Client.field566 = -1;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(var0 != -1 && Widget.validInterfaces[var0]) {
            CollisionData.field1945.method3301(var0);
            if(Widget.widgets[var0] != null) {
               boolean var5 = true;

               for(var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var5 = false;
                     }
                  }
               }

               if(var5) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }

      for(WidgetNode var3 = (WidgetNode)Client.componentTable.method3815(); var3 != null; var3 = (WidgetNode)Client.componentTable.method3816()) {
         class187.method3741(var3, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field464 = null;
      Client.isMenuOpen = false;
      Client.menuOptionCount = 0;
      Client.field574.method3512((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.field429[var0] = null;
         Client.field430[var0] = false;
      }

      class5.method87();
      Client.field439 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field494[var0] = true;
      }

      class75.method1610();
      Client.field541 = null;
      class40.field896 = 0;
      class146.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      class136.field2122 = null;
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "1931321126"
   )
   static World method771() {
      return World.field665 < World.field685?VertexNormal.worldList[++World.field665 - 1]:null;
   }
}
