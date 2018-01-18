import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class64 {
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lil;Lil;ZII)V",
      garbageValue = "-1949251751"
   )
   static void method1100(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class91.field1341) {
         if(var3 == 4) {
            class91.loginIndex = 4;
         }

      } else {
         class91.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         int var7;
         int var8;
         label159: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               var7 = var6.getWidth();
               var8 = var6.getHeight();
               int[] var9 = new int[var7 * var8];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label159;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         class91.field1339 = var5;
         GrandExchangeEvents.field269 = class91.field1339.method5271();
         if((Client.flags & 536870912) != 0) {
            class91.logoSprite = class222.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class91.logoSprite = class222.getSprite(var1, "logo", "");
         }

         class91.field1337 = class222.getSprite(var1, "titlebox", "");
         class277.field3744 = class222.getSprite(var1, "titlebutton", "");
         class91.runeSprites = BufferProvider.getIndexedSprites(var1, "runes", "");
         ItemContainer.titlemuteSprite = BufferProvider.getIndexedSprites(var1, "title_mute", "");
         MouseRecorder.field812 = class222.getSprite(var1, "options_radio_buttons,0", "");
         DynamicObject.field1442 = class222.getSprite(var1, "options_radio_buttons,4", "");
         class2.field11 = class222.getSprite(var1, "options_radio_buttons,2", "");
         class91.field1342 = class222.getSprite(var1, "options_radio_buttons,6", "");
         FileSystem.field3301 = MouseRecorder.field812.originalWidth;
         class153.field2128 = MouseRecorder.field812.height;
         Friend.field777 = new int[256];

         int var12;
         for(var12 = 0; var12 < 64; ++var12) {
            Friend.field777[var12] = var12 * 262144;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            Friend.field777[var12 + 64] = var12 * 1024 + 16711680;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            Friend.field777[var12 + 128] = var12 * 4 + 16776960;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            Friend.field777[var12 + 192] = 16777215;
         }

         GrandExchangeOffer.field296 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            GrandExchangeOffer.field296[var12] = var12 * 1024;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            GrandExchangeOffer.field296[var12 + 64] = var12 * 4 + 65280;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            GrandExchangeOffer.field296[var12 + 128] = var12 * 262144 + 65535;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            GrandExchangeOffer.field296[var12 + 192] = 16777215;
         }

         class33.field451 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class33.field451[var12] = var12 * 4;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class33.field451[var12 + 64] = var12 * 262144 + 255;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class33.field451[var12 + 128] = var12 * 1024 + 16711935;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class33.field451[var12 + 192] = 16777215;
         }

         class39.field515 = new int[256];
         FrameMap.field1958 = new int['耀'];
         class72.field833 = new int['耀'];
         class37.method495((IndexedSprite)null);
         GrandExchangeEvent.field282 = new int['耀'];
         SoundTask.field1571 = new int['耀'];
         if(var2) {
            class91.username = "";
            class91.password = "";
         }

         class249.field3363 = 0;
         IndexStoreActionHandler.field3327 = "";
         class91.field1367 = true;
         class91.worldSelectShown = false;
         if(!class222.preferences.muted) {
            IndexData var15 = Size.indexTrack1;
            var7 = var15.getFile("scape main");
            var8 = var15.getChild(var7, "");
            class214.field2631 = 1;
            class214.field2632 = var15;
            Ignore.field810 = var7;
            class262.field3474 = var8;
            class35.field477 = 255;
            class214.field2627 = false;
            FontName.field3711 = 2;
         } else {
            class214.field2631 = 1;
            class214.field2632 = null;
            Ignore.field810 = -1;
            class262.field3474 = -1;
            class35.field477 = 0;
            class214.field2627 = false;
            FontName.field3711 = 2;
         }

         Overlay.sendConInfo(false);
         class91.field1341 = true;
         class91.field1336 = (class87.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1336 + 202;
         class91.field1344 = class91.loginWindowX + 180;
         class91.field1339.method5287(class91.field1336, 0);
         GrandExchangeEvents.field269.method5287(class91.field1336 + 382, 0);
         class91.logoSprite.method5253(class91.field1336 + 382 - class91.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1781539320"
   )
   static synchronized void method1101(byte[] var0) {
      if(var0.length == 100 && class185.field2538 < 1000) {
         class185.field2536[++class185.field2538 - 1] = var0;
      } else if(var0.length == 5000 && class185.field2535 < 250) {
         class185.field2539[++class185.field2535 - 1] = var0;
      } else if(var0.length == 30000 && class185.field2537 < 50) {
         class185.field2542[++class185.field2537 - 1] = var0;
      } else {
         if(class254.field3404 != null) {
            for(int var1 = 0; var1 < Frames.field2042.length; ++var1) {
               if(var0.length == Frames.field2042[var1] && class185.field2541[var1] < class254.field3404[var1].length) {
                  class254.field3404[var1][class185.field2541[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "41"
   )
   static int method1099(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class82.intStackSize -= 3;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         int var5 = class82.intStack[class82.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = UrlRequester.getWidget(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class82.field1267 = var12;
               } else {
                  CombatInfo1.field1216 = var12;
               }

               class28.method220(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class82.field1267:CombatInfo1.field1216;
            Widget var10 = UrlRequester.getWidget(var9.id);
            var10.children[var9.index] = null;
            class28.method220(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
            var9.children = null;
            class28.method220(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
               if(var9 != null) {
                  class82.intStack[++class82.intStackSize - 1] = 1;
                  if(var2) {
                     class82.field1267 = var9;
                  } else {
                     CombatInfo1.field1216 = var9;
                  }
               } else {
                  class82.intStack[++class82.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class82.intStackSize -= 2;
            var3 = class82.intStack[class82.intStackSize];
            var4 = class82.intStack[class82.intStackSize + 1];
            Widget var11 = ScriptVarType.getWidgetChild(var3, var4);
            if(var11 != null && var4 != -1) {
               class82.intStack[++class82.intStackSize - 1] = 1;
               if(var2) {
                  class82.field1267 = var11;
               } else {
                  CombatInfo1.field1216 = var11;
               }
            } else {
               class82.intStack[++class82.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "1"
   )
   static int method1102(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class82.intStack[++class82.intStackSize - 1] = class34.loadWorlds()?1:0;
         return 1;
      } else {
         World var4;
         if(var0 == 6501) {
            World.field1217 = 0;
            if(World.field1217 < World.worldCount) {
               var4 = World.worldList[++World.field1217 - 1];
            } else {
               var4 = null;
            }

            if(var4 != null) {
               class82.intStack[++class82.intStackSize - 1] = var4.id;
               class82.intStack[++class82.intStackSize - 1] = var4.mask;
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var4.activity;
               class82.intStack[++class82.intStackSize - 1] = var4.location;
               class82.intStack[++class82.intStackSize - 1] = var4.playerCount;
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var4.address;
            } else {
               class82.intStack[++class82.intStackSize - 1] = -1;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            World var3;
            if(World.field1217 < World.worldCount) {
               var3 = World.worldList[++World.field1217 - 1];
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class82.intStack[++class82.intStackSize - 1] = var3.id;
               class82.intStack[++class82.intStackSize - 1] = var3.mask;
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3.activity;
               class82.intStack[++class82.intStackSize - 1] = var3.location;
               class82.intStack[++class82.intStackSize - 1] = var3.playerCount;
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3.address;
            } else {
               class82.intStack[++class82.intStackSize - 1] = -1;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class82.intStack[--class82.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var7 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class82.intStack[++class82.intStackSize - 1] = var4.id;
                  class82.intStack[++class82.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++class82.intStackSize - 1] = var4.location;
                  class82.intStack[++class82.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = -1;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class82.intStackSize -= 4;
               var7 = class82.intStack[class82.intStackSize];
               boolean var10 = class82.intStack[class82.intStackSize + 1] == 1;
               var5 = class82.intStack[class82.intStackSize + 2];
               boolean var6 = class82.intStack[class82.intStackSize + 3] == 1;
               class5.method14(var7, var10, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field1002 = class82.intStack[--class82.intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  class262 var9;
                  if(var0 == 6513) {
                     class82.intStackSize -= 2;
                     var7 = class82.intStack[class82.intStackSize];
                     var8 = class82.intStack[class82.intStackSize + 1];
                     var9 = DynamicObject.method1881(var8);
                     if(var9.method4617()) {
                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = class45.getNpcDefinition(var7).method4822(var8, var9.field3478);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = class45.getNpcDefinition(var7).method4829(var8, var9.field3477);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class82.intStackSize -= 2;
                     var7 = class82.intStack[class82.intStackSize];
                     var8 = class82.intStack[class82.intStackSize + 1];
                     var9 = DynamicObject.method1881(var8);
                     if(var9.method4617()) {
                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = NPC.getObjectDefinition(var7).method4716(var8, var9.field3478);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = NPC.getObjectDefinition(var7).method4757(var8, var9.field3477);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class82.intStackSize -= 2;
                     var7 = class82.intStack[class82.intStackSize];
                     var8 = class82.intStack[class82.intStackSize + 1];
                     var9 = DynamicObject.method1881(var8);
                     if(var9.method4617()) {
                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = class115.getItemDefinition(var7).method4773(var8, var9.field3478);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = class115.getItemDefinition(var7).method4772(var8, var9.field3477);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class82.intStackSize -= 2;
                     var7 = class82.intStack[class82.intStackSize];
                     var8 = class82.intStack[class82.intStackSize + 1];
                     var9 = DynamicObject.method1881(var8);
                     if(var9.method4617()) {
                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = class260.method4605(var7).method4638(var8, var9.field3478);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = class260.method4605(var7).method4637(var8, var9.field3477);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var7 = class82.intStack[--class82.intStackSize];
               if(var7 >= 0 && var7 < World.worldCount) {
                  var4 = World.worldList[var7];
                  class82.intStack[++class82.intStackSize - 1] = var4.id;
                  class82.intStack[++class82.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++class82.intStackSize - 1] = var4.location;
                  class82.intStack[++class82.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = -1;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
