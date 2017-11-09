import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("f")
   static int[] field821;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 338237193
   )
   static int field815;
   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "Lft;"
   )
   static RSSocket field823;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 219162155
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 482317817
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 301925605
   )
   @Export("type")
   int type;
   @ObfuscatedName("j")
   @Export("name")
   String name;
   @ObfuscatedName("v")
   @Export("sender")
   String sender;
   @ObfuscatedName("x")
   @Export(
      value = "value",
      setter = true
   )
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = RSCanvas.method857();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "465663983"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = RSCanvas.method857();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "68"
   )
   static int method1177(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;ZII)V",
      garbageValue = "1539314424"
   )
   static void method1172(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class91.field1361) {
         if(var3 == 4) {
            class91.loginIndex = 4;
         }

      } else {
         class91.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4308("title.jpg", "");
         class91.field1336 = class230.method4239(var4);
         class91.field1368 = class91.field1336.method5267();
         if((Client.flags & 536870912) != 0) {
            class91.logoSprite = class250.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class91.logoSprite = class250.getSprite(var1, "logo", "");
         }

         class91.field1333 = class250.getSprite(var1, "titlebox", "");
         class91.field1334 = class250.getSprite(var1, "titlebutton", "");
         class91.field1335 = class150.method3023(var1, "runes", "");
         class91.titlemuteSprite = class150.method3023(var1, "title_mute", "");
         WallObject.field2046 = class250.getSprite(var1, "options_radio_buttons,0", "");
         Preferences.field1235 = class250.getSprite(var1, "options_radio_buttons,4", "");
         class296.field3859 = class250.getSprite(var1, "options_radio_buttons,2", "");
         class82.field1265 = class250.getSprite(var1, "options_radio_buttons,6", "");
         class44.field561 = WallObject.field2046.originalWidth;
         class91.field1358 = WallObject.field2046.height;
         ClanMember.field867 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            ClanMember.field867[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ClanMember.field867[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ClanMember.field867[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ClanMember.field867[var5 + 192] = 16777215;
         }

         ChatLineBuffer.field1458 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            ChatLineBuffer.field1458[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ChatLineBuffer.field1458[var5 + 64] = var5 * 4 + 65280;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ChatLineBuffer.field1458[var5 + 128] = var5 * 262144 + 65535;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ChatLineBuffer.field1458[var5 + 192] = 16777215;
         }

         field821 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            field821[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            field821[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            field821[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            field821[var5 + 192] = 16777215;
         }

         Overlay.field3653 = new int[256];
         Permission.field3243 = new int['耀'];
         class34.field466 = new int['耀'];
         class64.method1148((IndexedSprite)null);
         CombatInfoListHolder.field1288 = new int['耀'];
         class13.field281 = new int['耀'];
         if(var2) {
            class91.username = "";
            class91.password = "";
         }

         class96.field1429 = 0;
         class268.field3685 = "";
         class91.field1338 = true;
         class91.worldSelectShown = false;
         if(!Buffer.preferences.muted) {
            IndexData var8 = class21.indexTrack1;
            int var6 = var8.getFile("scape main");
            int var7 = var8.getChild(var6, "");
            class210.field2594 = 1;
            class184.field2516 = var8;
            class210.field2598 = var6;
            class210.field2599 = var7;
            class37.field485 = 255;
            class210.field2595 = false;
            class47.field584 = 2;
         } else {
            class37.method552(2);
         }

         class29.sendConInfo(false);
         class91.field1361 = true;
         class91.field1332 = (Tile.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1332 + 202;
         class233.field3209 = class91.loginWindowX + 180;
         class91.field1336.method5276(class91.field1332, 0);
         class91.field1368.method5276(class91.field1332 + 382, 0);
         class91.logoSprite.method5246(class91.field1332 + 382 - class91.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "864941172"
   )
   static int method1175(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
      } else {
         var3 = var2?class285.field3789:Friend.field768;
      }

      String var4 = class82.scriptStringStack[--class24.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class82.intStack[--class56.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class82.intStack[--class56.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class82.scriptStringStack[--class24.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class82.intStack[--class56.intStackSize]);
         }
      }

      var7 = class82.intStack[--class56.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2846 = var8;
      } else if(var0 == 1401) {
         var3.field2811 = var8;
      } else if(var0 == 1402) {
         var3.field2810 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2816 = var8;
      } else if(var0 == 1406) {
         var3.field2818 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2826 = var8;
      } else if(var0 == 1410) {
         var3.field2743 = var8;
      } else if(var0 == 1411) {
         var3.field2755 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2831 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2742 = var8;
      } else if(var0 == 1419) {
         var3.field2829 = var8;
      } else if(var0 == 1420) {
         var3.field2830 = var8;
      } else if(var0 == 1421) {
         var3.field2798 = var8;
      } else if(var0 == 1422) {
         var3.field2832 = var8;
      } else if(var0 == 1423) {
         var3.field2833 = var8;
      } else if(var0 == 1424) {
         var3.field2721 = var8;
      } else if(var0 == 1425) {
         var3.field2850 = var8;
      } else if(var0 == 1426) {
         var3.field2837 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2835 = var8;
      }

      var3.field2749 = true;
      return 1;
   }
}
