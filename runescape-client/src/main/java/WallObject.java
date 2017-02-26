import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1966406059
   )
   int field1558;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1826329799
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1942782481
   )
   int field1560;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1550674665
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 811674073
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 366384161
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2103095997
   )
   int field1566 = 0;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 1495199563
   )
   @Export("plane")
   static int plane;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-42"
   )
   static void method1954() {
      int var0;
      if(Client.field333 == 0) {
         Script.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class16.field183 = new SpritePixels(512, 512);
         class41.field876 = "Starting game engine...";
         class41.field851 = 5;
         Client.field333 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field333 == 20) {
            int[] var24 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 32 * var1 + 128 + 15;
               var3 = 600 + 3 * var2;
               var4 = class84.field1468[var2];
               var24[var1] = var4 * var3 >> 16;
            }

            Region.method1790(var24, 500, 800, 512, 334);
            class41.field876 = "Prepared visibility map";
            class41.field851 = 10;
            Client.field333 = 30;
         } else if(Client.field333 == 30) {
            class20.field228 = class41.method865(0, false, true, true);
            class1.field23 = class41.method865(1, false, true, true);
            class40.field833 = class41.method865(2, true, false, true);
            class116.field1819 = class41.method865(3, false, true, true);
            Client.field336 = class41.method865(4, false, true, true);
            Client.field337 = class41.method865(5, true, true, true);
            ScriptState.field127 = class41.method865(6, true, true, false);
            class10.field111 = class41.method865(7, false, true, true);
            class165.field2167 = class41.method865(8, false, true, true);
            class107.field1738 = class41.method865(9, false, true, true);
            class38.field821 = class41.method865(10, false, true, true);
            class150.field2044 = class41.method865(11, false, true, true);
            class145.field2013 = class41.method865(12, false, true, true);
            class0.field0 = class41.method865(13, true, false, true);
            class22.field254 = class41.method865(14, false, true, false);
            XItemContainer.field137 = class41.method865(15, false, true, true);
            class41.field876 = "Connecting to update server";
            class41.field851 = 20;
            Client.field333 = 40;
         } else if(Client.field333 == 40) {
            byte var21 = 0;
            var0 = var21 + class20.field228.method3394() * 4 / 100;
            var0 += class1.field23.method3394() * 4 / 100;
            var0 += class40.field833.method3394() * 2 / 100;
            var0 += class116.field1819.method3394() * 2 / 100;
            var0 += Client.field336.method3394() * 6 / 100;
            var0 += Client.field337.method3394() * 4 / 100;
            var0 += ScriptState.field127.method3394() * 2 / 100;
            var0 += class10.field111.method3394() * 60 / 100;
            var0 += class165.field2167.method3394() * 2 / 100;
            var0 += class107.field1738.method3394() * 2 / 100;
            var0 += class38.field821.method3394() * 2 / 100;
            var0 += class150.field2044.method3394() * 2 / 100;
            var0 += class145.field2013.method3394() * 2 / 100;
            var0 += class0.field0.method3394() * 2 / 100;
            var0 += class22.field254.method3394() * 2 / 100;
            var0 += XItemContainer.field137.method3394() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field876 = "Checking for updates - " + var0 + "%";
               }

               class41.field851 = 30;
            } else {
               class41.field876 = "Loaded update list";
               class41.field851 = 30;
               Client.field333 = 45;
            }
         } else if(Client.field333 == 45) {
            boolean var20 = !Client.field308;
            class57.field1061 = 22050;
            class57.field1070 = var20;
            class57.field1062 = 2;
            class139 var26 = new class139();
            var26.method2554(9, 128);
            class44.field914 = class33.method784(class33.field775, GameObject.canvas, 0, 22050);
            class44.field914.method1110(var26);
            KitDefinition.method3503(XItemContainer.field137, class22.field254, Client.field336, var26);
            class167.field2189 = class33.method784(class33.field775, GameObject.canvas, 1, 2048);
            class16.field184 = new class51();
            class167.field2189.method1110(class16.field184);
            World.field706 = new class65(22050, class57.field1061);
            class41.field876 = "Prepared sound engine";
            class41.field851 = 35;
            Client.field333 = 50;
         } else if(Client.field333 == 50) {
            var0 = 0;
            if(class13.field154 == null) {
               class13.field154 = GroundObject.method1596(class165.field2167, class0.field0, "p11_full", "");
            } else {
               ++var0;
            }

            if(class175.field2651 == null) {
               class175.field2651 = GroundObject.method1596(class165.field2167, class0.field0, "p12_full", "");
            } else {
               ++var0;
            }

            if(NPC.field786 == null) {
               NPC.field786 = GroundObject.method1596(class165.field2167, class0.field0, "b12_full", "");
            } else {
               ++var0;
            }

            if(var0 < 3) {
               class41.field876 = "Loading fonts - " + 100 * var0 / 3 + "%";
               class41.field851 = 40;
            } else {
               class116.field1825 = new class230(true);
               class41.field876 = "Loaded fonts";
               class41.field851 = 40;
               Client.field333 = 60;
            }
         } else if(Client.field333 == 60) {
            var0 = class22.method217(class38.field821, class165.field2167);
            var1 = ItemLayer.method1510();
            if(var0 < var1) {
               class41.field876 = "Loading title screen - " + 100 * var0 / var1 + "%";
               class41.field851 = 50;
            } else {
               class41.field876 = "Loaded title screen";
               class41.field851 = 50;
               class8.setGameState(5);
               Client.field333 = 70;
            }
         } else {
            class184 var15;
            if(Client.field333 == 70) {
               if(!class40.field833.method3307()) {
                  class41.field876 = "Loading config - " + class40.field833.method3401() + "%";
                  class41.field851 = 60;
               } else {
                  class108.method2104(class40.field833);
                  class157.method3058(class40.field833);
                  class184 var23 = class40.field833;
                  class184 var25 = class10.field111;
                  KitDefinition.field2825 = var23;
                  KitDefinition.field2818 = var25;
                  class215.field3174 = KitDefinition.field2825.method3313(3);
                  class143.method2728(class40.field833, class10.field111, Client.field308);
                  var15 = class40.field833;
                  class184 var18 = class10.field111;
                  NPCComposition.field3005 = var15;
                  NPCComposition.field3003 = var18;
                  class148.method2796(class40.field833, class10.field111, Client.isMembers, class13.field154);
                  class143.method2739(class40.field833, class20.field228, class1.field23);
                  class184 var17 = class40.field833;
                  class184 var5 = class10.field111;
                  class148.field2028 = var17;
                  class0.field6 = var5;
                  class30.method687(class40.field833);
                  class170.method3269(class40.field833);
                  class184 var6 = class116.field1819;
                  class184 var7 = class10.field111;
                  class184 var8 = class165.field2167;
                  class184 var9 = class0.field0;
                  Widget.field2271 = var6;
                  Widget.field2241 = var7;
                  Widget.field2197 = var8;
                  Widget.field2198 = var9;
                  Widget.widgets = new Widget[Widget.field2271.method3314()][];
                  Widget.validInterfaces = new boolean[Widget.field2271.method3314()];
                  XItemContainer.method157(class40.field833);
                  CombatInfoListHolder.method788(class40.field833);
                  class184 var10 = class40.field833;
                  class188.field2789 = var10;
                  class184 var11 = class40.field833;
                  class189.field2793 = var11;
                  class20.chatMessages = new ChatMessages();
                  class165.method3160(class40.field833, class165.field2167, class0.field0);
                  class184 var12 = class40.field833;
                  class184 var13 = class165.field2167;
                  CombatInfo2.field2837 = var12;
                  CombatInfo2.field2833 = var13;
                  class41.field876 = "Loaded config";
                  class41.field851 = 60;
                  Client.field333 = 80;
               }
            } else if(Client.field333 != 80) {
               if(Client.field333 == 90) {
                  if(!class107.field1738.method3307()) {
                     class41.field876 = "Loading textures - " + class107.field1738.method3401() + "%";
                     class41.field851 = 90;
                  } else {
                     TextureProvider var22 = new TextureProvider(class107.field1738, class165.field2167, 20, 0.8D, Client.field308?64:128);
                     class84.method1690(var22);
                     class84.method1691(0.8D);
                     class41.field876 = "Loaded textures";
                     class41.field851 = 90;
                     Client.field333 = 110;
                  }
               } else if(Client.field333 == 110) {
                  Client.field316 = new class20();
                  class33.field775.method2025(Client.field316, 10);
                  class41.field876 = "Loaded input handler";
                  class41.field851 = 94;
                  Client.field333 = 120;
               } else if(Client.field333 == 120) {
                  if(!class38.field821.method3321("huffman", "")) {
                     class41.field876 = "Loading wordpack - " + 0 + "%";
                     class41.field851 = 96;
                  } else {
                     class145 var14 = new class145(class38.field821.method3338("huffman", ""));
                     class103.method2026(var14);
                     class41.field876 = "Loaded wordpack";
                     class41.field851 = 96;
                     Client.field333 = 130;
                  }
               } else if(Client.field333 == 130) {
                  if(!class116.field1819.method3307()) {
                     class41.field876 = "Loading interfaces - " + class116.field1819.method3401() * 4 / 5 + "%";
                     class41.field851 = 100;
                  } else if(!class145.field2013.method3307()) {
                     class41.field876 = "Loading interfaces - " + (80 + class145.field2013.method3401() / 6) + "%";
                     class41.field851 = 100;
                  } else if(!class0.field0.method3307()) {
                     class41.field876 = "Loading interfaces - " + (96 + class0.field0.method3401() / 20) + "%";
                     class41.field851 = 100;
                  } else {
                     class41.field876 = "Loaded interfaces";
                     class41.field851 = 100;
                     Client.field333 = 140;
                  }
               } else if(Client.field333 == 140) {
                  class8.setGameState(10);
               }
            } else {
               var0 = 0;
               SpritePixels var16;
               if(null == class189.field2795) {
                  var15 = class165.field2167;
                  var3 = var15.method3335("compass");
                  var4 = var15.method3319(var3, "");
                  var16 = class182.method3305(var15, var3, var4);
                  class189.field2795 = var16;
               } else {
                  ++var0;
               }

               if(ScriptState.field132 == null) {
                  var15 = class165.field2167;
                  var3 = var15.method3335("mapedge");
                  var4 = var15.method3319(var3, "");
                  var16 = class182.method3305(var15, var3, var4);
                  ScriptState.field132 = var16;
               } else {
                  ++var0;
               }

               if(class31.field741 == null) {
                  class31.field741 = Frames.method1957(class165.field2167, "mapscene", "");
               } else {
                  ++var0;
               }

               if(Tile.field1355 == null) {
                  Tile.field1355 = class31.method711(class165.field2167, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(null == class31.field726) {
                  class31.field726 = class31.method711(class165.field2167, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(ScriptState.field125 == null) {
                  ScriptState.field125 = class31.method711(class165.field2167, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class177.field2672 == null) {
                  class177.field2672 = class31.method711(class165.field2167, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(null == World.field709) {
                  World.field709 = class31.method711(class165.field2167, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(null == XGrandExchangeOffer.field56) {
                  XGrandExchangeOffer.field56 = class31.method711(class165.field2167, "cross", "");
               } else {
                  ++var0;
               }

               if(null == ScriptState.field131) {
                  ScriptState.field131 = class31.method711(class165.field2167, "mapdots", "");
               } else {
                  ++var0;
               }

               if(Player.field284 == null) {
                  Player.field284 = Frames.method1957(class165.field2167, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class18.field215 == null) {
                  class18.field215 = Frames.method1957(class165.field2167, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class41.field876 = "Loading sprites - " + 100 * var0 / 12 + "%";
                  class41.field851 = 70;
               } else {
                  FontTypeFace.modIcons = class18.field215;
                  ScriptState.field132.method4187();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var19 = 0; var19 < Tile.field1355.length; ++var19) {
                     Tile.field1355[var19].method4218(var4 + var1, var2 + var4, var4 + var3);
                  }

                  class31.field741[0].method4109(var4 + var1, var4 + var2, var3 + var4);
                  class41.field876 = "Loaded sprites";
                  class41.field851 = 70;
                  Client.field333 = 90;
               }
            }
         }
      }
   }
}
