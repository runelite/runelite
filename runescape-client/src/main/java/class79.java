import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class79 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 856754761
   )
   static int field1435;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -843210241
   )
   static int field1436;
   @ObfuscatedName("n")
   public static int[] field1438;
   @ObfuscatedName("g")
   public static int[] field1439;
   @ObfuscatedName("d")
   public static int[] field1440;
   @ObfuscatedName("m")
   public static byte[][] field1441;
   @ObfuscatedName("a")
   static int[] field1442;
   @ObfuscatedName("u")
   public static int[] field1443;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-19400"
   )
   static void method1713() {
      class5.field86 = 99;
      class5.field102 = new byte[4][104][104];
      class5.field88 = new byte[4][104][104];
      class5.field89 = new byte[4][104][104];
      class5.field90 = new byte[4][104][104];
      class5.field107 = new int[4][105][105];
      class35.field801 = new byte[4][105][105];
      class5.field91 = new int[105][105];
      class5.field92 = new int[104];
      class172.field2751 = new int[104];
      class5.field93 = new int[104];
      class5.field94 = new int[104];
      class0.field1 = new int[104];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method1714() {
      int var0;
      if(Client.field398 == 0) {
         class128.region = new Region(4, 104, 104, class5.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class178.field2953 = new SpritePixels(512, 512);
         class33.field769 = "Starting game engine...";
         class33.field756 = 5;
         Client.field398 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field398 == 20) {
            int[] var33 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 15 + var1 * 32 + 128;
               var3 = 3 * var2 + 600;
               var4 = class94.field1623[var2];
               var33[var1] = var4 * var3 >> 16;
            }

            Region.method1987(var33, 500, 800, 512, 334);
            class33.field769 = "Prepared visibility map";
            class33.field756 = 10;
            Client.field398 = 30;
         } else if(Client.field398 == 30) {
            Client.field331 = Player.method48(0, false, true, true);
            class114.field2007 = Player.method48(1, false, true, true);
            XItemContainer.field233 = Player.method48(2, true, false, true);
            class21.field598 = Player.method48(3, false, true, true);
            class109.field1929 = Player.method48(4, false, true, true);
            class9.field173 = Player.method48(5, true, true, true);
            Client.field476 = Player.method48(6, true, true, false);
            VertexNormal.field1688 = Player.method48(7, false, true, true);
            ItemComposition.field1199 = Player.method48(8, false, true, true);
            Client.field333 = Player.method48(9, false, true, true);
            class139.field2139 = Player.method48(10, false, true, true);
            class5.field104 = Player.method48(11, false, true, true);
            class116.field2015 = Player.method48(12, false, true, true);
            class168.field2705 = Player.method48(13, true, false, true);
            class140.field2179 = Player.method48(14, false, true, false);
            World.field672 = Player.method48(15, false, true, true);
            class33.field769 = "Connecting to update server";
            class33.field756 = 20;
            Client.field398 = 40;
         } else if(Client.field398 == 40) {
            byte var30 = 0;
            var0 = var30 + Client.field331.method3368() * 4 / 100;
            var0 += class114.field2007.method3368() * 4 / 100;
            var0 += XItemContainer.field233.method3368() * 2 / 100;
            var0 += class21.field598.method3368() * 2 / 100;
            var0 += class109.field1929.method3368() * 6 / 100;
            var0 += class9.field173.method3368() * 4 / 100;
            var0 += Client.field476.method3368() * 2 / 100;
            var0 += VertexNormal.field1688.method3368() * 60 / 100;
            var0 += ItemComposition.field1199.method3368() * 2 / 100;
            var0 += Client.field333.method3368() * 2 / 100;
            var0 += class139.field2139.method3368() * 2 / 100;
            var0 += class5.field104.method3368() * 2 / 100;
            var0 += class116.field2015.method3368() * 2 / 100;
            var0 += class168.field2705.method3368() * 2 / 100;
            var0 += class140.field2179.method3368() * 2 / 100;
            var0 += World.field672.method3368() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class33.field769 = "Checking for updates - " + var0 + "%";
               }

               class33.field756 = 30;
            } else {
               class33.field769 = "Loaded update list";
               class33.field756 = 30;
               Client.field398 = 45;
            }
         } else if(Client.field398 == 45) {
            boolean var29 = !Client.field304;
            class59.field1239 = 22050;
            class222.field3221 = var29;
            class59.field1231 = 2;
            class187 var35 = new class187();
            var35.method3632(9, 128);
            World.field683 = class168.method3267(class40.field898, class164.canvas, 0, 22050);
            World.field683.method1262(var35);
            class171.method3399(World.field672, class140.field2179, class109.field1929, var35);
            XClanMember.field652 = class168.method3267(class40.field898, class164.canvas, 1, 2048);
            class0.field11 = new class58();
            XClanMember.field652.method1262(class0.field11);
            class127.field2079 = new class77(22050, class59.field1239);
            class33.field769 = "Prepared sound engine";
            class33.field756 = 35;
            Client.field398 = 50;
         } else if(Client.field398 == 50) {
            var0 = 0;
            if(class32.field737 == null) {
               class32.field737 = class43.method888(ItemComposition.field1199, class168.field2705, "p11_full", "");
            } else {
               ++var0;
            }

            if(class136.field2123 == null) {
               class136.field2123 = class43.method888(ItemComposition.field1199, class168.field2705, "p12_full", "");
            } else {
               ++var0;
            }

            if(null == MessageNode.field811) {
               MessageNode.field811 = class43.method888(ItemComposition.field1199, class168.field2705, "b12_full", "");
            } else {
               ++var0;
            }

            if(var0 < 3) {
               class33.field769 = "Loading fonts - " + 100 * var0 / 3 + "%";
               class33.field756 = 40;
            } else {
               class162.field2650 = new class163(true);
               class33.field769 = "Loaded fonts";
               class33.field756 = 40;
               Client.field398 = 60;
            }
         } else {
            class171 var25;
            class171 var34;
            if(Client.field398 == 60) {
               var34 = class139.field2139;
               var25 = ItemComposition.field1199;
               var3 = 0;
               if(var34.method3360("title.jpg", "")) {
                  ++var3;
               }

               if(var25.method3360("logo", "")) {
                  ++var3;
               }

               if(var25.method3360("logo_deadman_mode", "")) {
                  ++var3;
               }

               if(var25.method3360("titlebox", "")) {
                  ++var3;
               }

               if(var25.method3360("titlebutton", "")) {
                  ++var3;
               }

               if(var25.method3360("runes", "")) {
                  ++var3;
               }

               if(var25.method3360("title_mute", "")) {
                  ++var3;
               }

               if(var25.method3308("options_radio_buttons,0")) {
                  ++var3;
               }

               if(var25.method3308("options_radio_buttons,2")) {
                  ++var3;
               }

               var25.method3360("sl_back", "");
               var25.method3360("sl_flags", "");
               var25.method3360("sl_arrows", "");
               var25.method3360("sl_stars", "");
               var25.method3360("sl_button", "");
               var4 = Client.method527();
               if(var3 < var4) {
                  class33.field769 = "Loading title screen - " + var3 * 100 / var4 + "%";
                  class33.field756 = 50;
               } else {
                  class33.field769 = "Loaded title screen";
                  class33.field756 = 50;
                  class117.setGameState(5);
                  Client.field398 = 70;
               }
            } else if(Client.field398 == 70) {
               if(!XItemContainer.field233.method3315()) {
                  class33.field769 = "Loading config - " + XItemContainer.field233.method3376() + "%";
                  class33.field756 = 60;
               } else {
                  class31.method671(XItemContainer.field233);
                  NPC.method740(XItemContainer.field233);
                  class171 var32 = XItemContainer.field233;
                  var34 = VertexNormal.field1688;
                  KitDefinition.field1054 = var32;
                  KitDefinition.field1046 = var34;
                  class169.field2712 = KitDefinition.field1054.method3299(3);
                  class12.method149(XItemContainer.field233, VertexNormal.field1688, Client.field304);
                  var25 = XItemContainer.field233;
                  class171 var27 = VertexNormal.field1688;
                  NPCComposition.field919 = var25;
                  NPCComposition.field905 = var27;
                  class171 var26 = XItemContainer.field233;
                  class171 var5 = VertexNormal.field1688;
                  boolean var6 = Client.isMembers;
                  class227 var7 = class32.field737;
                  class129.field2096 = var26;
                  ItemComposition.field1166 = var5;
                  class229.isMembersWorld = var6;
                  class54.field1157 = class129.field2096.method3299(10);
                  FaceNormal.field1507 = var7;
                  class171 var8 = XItemContainer.field233;
                  class171 var9 = Client.field331;
                  class171 var10 = class114.field2007;
                  Sequence.field1010 = var8;
                  Sequence.field1007 = var9;
                  Sequence.field1008 = var10;
                  class171 var11 = XItemContainer.field233;
                  class171 var12 = VertexNormal.field1688;
                  class45.field1038 = var11;
                  class45.field1031 = var12;
                  Friend.method195(XItemContainer.field233);
                  class171 var13 = XItemContainer.field233;
                  class220.field3215 = var13;
                  class56.field1220 = class220.field3215.method3299(16);
                  class171 var14 = class21.field598;
                  class171 var15 = VertexNormal.field1688;
                  class171 var16 = ItemComposition.field1199;
                  class171 var17 = class168.field2705;
                  CollisionData.field1945 = var14;
                  Widget.field2793 = var15;
                  Widget.field2794 = var16;
                  Widget.field2832 = var17;
                  Widget.widgets = new Widget[CollisionData.field1945.method3300()][];
                  Widget.validInterfaces = new boolean[CollisionData.field1945.method3300()];
                  NPCComposition.method838(XItemContainer.field233);
                  Widget.method3469(XItemContainer.field233);
                  class93.method2140(XItemContainer.field233);
                  FaceNormal.method1941(XItemContainer.field233);
                  class5.chatMessages = new ChatMessages();
                  class171 var18 = XItemContainer.field233;
                  class171 var19 = ItemComposition.field1199;
                  class171 var20 = class168.field2705;
                  class51.field1127 = var18;
                  class51.field1115 = var19;
                  class51.field1102 = var20;
                  class171 var21 = XItemContainer.field233;
                  class171 var22 = ItemComposition.field1199;
                  class49.field1082 = var21;
                  RSCanvas.field2193 = var22;
                  class33.field769 = "Loaded config";
                  class33.field756 = 60;
                  Client.field398 = 80;
               }
            } else if(Client.field398 != 80) {
               if(Client.field398 == 90) {
                  if(!Client.field333.method3315()) {
                     class33.field769 = "Loading textures - " + Client.field333.method3376() + "%";
                     class33.field756 = 90;
                  } else {
                     TextureProvider var31 = new TextureProvider(Client.field333, ItemComposition.field1199, 20, 0.8D, Client.field304?64:128);
                     class94.method2147(var31);
                     class94.method2180(0.8D);
                     class33.field769 = "Loaded textures";
                     class33.field756 = 90;
                     Client.field398 = 110;
                  }
               } else if(Client.field398 == 110) {
                  Client.field311 = new class13();
                  class40.field898.method2920(Client.field311, 10);
                  class33.field769 = "Loaded input handler";
                  class33.field756 = 94;
                  Client.field398 = 120;
               } else if(Client.field398 == 120) {
                  if(!class139.field2139.method3360("huffman", "")) {
                     class33.field769 = "Loading wordpack - " + 0 + "%";
                     class33.field756 = 96;
                  } else {
                     class116 var23 = new class116(class139.field2139.method3306("huffman", ""));
                     class225.field3236 = var23;
                     class33.field769 = "Loaded wordpack";
                     class33.field756 = 96;
                     Client.field398 = 130;
                  }
               } else if(Client.field398 == 130) {
                  if(!class21.field598.method3315()) {
                     class33.field769 = "Loading interfaces - " + class21.field598.method3376() * 4 / 5 + "%";
                     class33.field756 = 100;
                  } else if(!class116.field2015.method3315()) {
                     class33.field769 = "Loading interfaces - " + (80 + class116.field2015.method3376() / 6) + "%";
                     class33.field756 = 100;
                  } else if(!class168.field2705.method3315()) {
                     class33.field769 = "Loading interfaces - " + (96 + class168.field2705.method3376() / 20) + "%";
                     class33.field756 = 100;
                  } else {
                     class33.field769 = "Loaded interfaces";
                     class33.field756 = 100;
                     Client.field398 = 140;
                  }
               } else if(Client.field398 == 140) {
                  class117.setGameState(10);
               }
            } else {
               var0 = 0;
               SpritePixels var24;
               if(class51.field1107 == null) {
                  var25 = ItemComposition.field1199;
                  var3 = var25.method3304("compass");
                  var4 = var25.method3305(var3, "");
                  var24 = class1.method13(var25, var3, var4);
                  class51.field1107 = var24;
               } else {
                  ++var0;
               }

               if(class119.field2032 == null) {
                  var25 = ItemComposition.field1199;
                  var3 = var25.method3304("mapedge");
                  var4 = var25.method3305(var3, "");
                  var24 = class1.method13(var25, var3, var4);
                  class119.field2032 = var24;
               } else {
                  ++var0;
               }

               if(null == class152.field2279) {
                  class152.field2279 = class51.method1072(ItemComposition.field1199, "mapscene", "");
               } else {
                  ++var0;
               }

               if(NPC.field804 == null) {
                  NPC.field804 = NPC.method756(ItemComposition.field1199, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(WidgetNode.field64 == null) {
                  WidgetNode.field64 = NPC.method756(ItemComposition.field1199, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(class75.field1401 == null) {
                  class75.field1401 = NPC.method756(ItemComposition.field1199, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(null == class137.field2130) {
                  class137.field2130 = NPC.method756(ItemComposition.field1199, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(WidgetNode.field66 == null) {
                  WidgetNode.field66 = NPC.method756(ItemComposition.field1199, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(class24.field639 == null) {
                  class24.field639 = NPC.method756(ItemComposition.field1199, "cross", "");
               } else {
                  ++var0;
               }

               if(null == WallObject.field1588) {
                  WallObject.field1588 = NPC.method756(ItemComposition.field1199, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class222.field3222 == null) {
                  class222.field3222 = class51.method1072(ItemComposition.field1199, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(Client.field379 == null) {
                  Client.field379 = class51.method1072(ItemComposition.field1199, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class33.field769 = "Loading sprites - " + 100 * var0 / 12 + "%";
                  class33.field756 = 70;
               } else {
                  class226.modIcons = Client.field379;
                  class119.field2032.method1745();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var28 = 0; var28 < NPC.field804.length; ++var28) {
                     NPC.field804[var28].method1741(var1 + var4, var2 + var4, var4 + var3);
                  }

                  class152.field2279[0].method1897(var4 + var1, var4 + var2, var4 + var3);
                  class33.field769 = "Loaded sprites";
                  class33.field756 = 70;
                  Client.field398 = 90;
               }
            }
         }
      }
   }
}
