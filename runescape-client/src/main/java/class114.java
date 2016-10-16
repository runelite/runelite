import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class114 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 251356067
   )
   static int field1985;
   @ObfuscatedName("r")
   static Widget field1986;
   @ObfuscatedName("s")
   static final String[][] field1987 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("t")
   static Calendar field1989;
   @ObfuscatedName("dl")
   @Export("region")
   static Region region;
   @ObfuscatedName("z")
   static final String[] field1991 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1448708239"
   )
   static void method2397() {
      int var0;
      if(Client.field295 == 0) {
         region = new Region(4, 104, 104, class5.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class11.field166 = new SpritePixels(512, 512);
         class33.field719 = "Starting game engine...";
         class33.field718 = 5;
         Client.field295 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field295 == 20) {
            int[] var26 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 15 + var1 * 32 + 128;
               var3 = 3 * var2 + 600;
               var4 = class94.field1631[var2];
               var26[var1] = var3 * var4 >> 16;
            }

            Region.method1950(var26, 500, 800, 512, 334);
            class33.field719 = "Prepared visibility map";
            class33.field718 = 10;
            Client.field295 = 30;
         } else if(Client.field295 == 30) {
            class23.field583 = class5.method63(0, false, true, true);
            Sequence.field983 = class5.method63(1, false, true, true);
            class10.field154 = class5.method63(2, true, false, true);
            class124.field2043 = class5.method63(3, false, true, true);
            Client.field443 = class5.method63(4, false, true, true);
            class24.field603 = class5.method63(5, true, true, true);
            class47.field1024 = class5.method63(6, true, true, false);
            class192.field3101 = class5.method63(7, false, true, true);
            class152.field2281 = class5.method63(8, false, true, true);
            class154.field2299 = class5.method63(9, false, true, true);
            class128.field2074 = class5.method63(10, false, true, true);
            Buffer.field2033 = class5.method63(11, false, true, true);
            class188.field3046 = class5.method63(12, false, true, true);
            Client.field299 = class5.method63(13, true, false, true);
            class18.field236 = class5.method63(14, false, true, false);
            class143.field2200 = class5.method63(15, false, true, true);
            class33.field719 = "Connecting to update server";
            class33.field718 = 20;
            Client.field295 = 40;
         } else if(Client.field295 == 40) {
            byte var23 = 0;
            var0 = var23 + class23.field583.method3334() * 4 / 100;
            var0 += Sequence.field983.method3334() * 4 / 100;
            var0 += class10.field154.method3334() * 2 / 100;
            var0 += class124.field2043.method3334() * 2 / 100;
            var0 += Client.field443.method3334() * 6 / 100;
            var0 += class24.field603.method3334() * 4 / 100;
            var0 += class47.field1024.method3334() * 2 / 100;
            var0 += class192.field3101.method3334() * 60 / 100;
            var0 += class152.field2281.method3334() * 2 / 100;
            var0 += class154.field2299.method3334() * 2 / 100;
            var0 += class128.field2074.method3334() * 2 / 100;
            var0 += Buffer.field2033.method3334() * 2 / 100;
            var0 += class188.field3046.method3334() * 2 / 100;
            var0 += Client.field299.method3334() * 2 / 100;
            var0 += class18.field236.method3334() * 2 / 100;
            var0 += class143.field2200.method3334() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class33.field719 = "Checking for updates - " + var0 + "%";
               }

               class33.field718 = 30;
            } else {
               class33.field719 = "Loaded update list";
               class33.field718 = 30;
               Client.field295 = 45;
            }
         } else {
            class171 var16;
            class171 var18;
            class171 var19;
            if(Client.field295 == 45) {
               boolean var22 = !Client.field271;
               class59.field1219 = 22050;
               class59.field1222 = var22;
               class59.field1215 = 2;
               class187 var27 = new class187();
               var27.method3589(9, 128);
               class22.field576 = class35.method731(class8.field121, Frames.canvas, 0, 22050);
               class22.field576.method1176(var27);
               var16 = class143.field2200;
               var18 = class18.field236;
               var19 = Client.field443;
               class186.field3000 = var16;
               class186.field3008 = var18;
               class186.field3001 = var19;
               class186.field3007 = var27;
               Client.field527 = class35.method731(class8.field121, Frames.canvas, 1, 2048);
               class75.field1389 = new class58();
               Client.field527.method1176(class75.field1389);
               KitDefinition.field1004 = new class77(22050, class59.field1219);
               class33.field719 = "Prepared sound engine";
               class33.field718 = 35;
               Client.field295 = 50;
            } else if(Client.field295 == 50) {
               var0 = 0;
               if(null == class92.field1590) {
                  class92.field1590 = class11.method146(class152.field2281, Client.field299, "p11_full", "");
               } else {
                  ++var0;
               }

               if(null == class218.field3204) {
                  class218.field3204 = class11.method146(class152.field2281, Client.field299, "p12_full", "");
               } else {
                  ++var0;
               }

               if(null == class117.field2001) {
                  class117.field2001 = class11.method146(class152.field2281, Client.field299, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class33.field719 = "Loading fonts - " + 100 * var0 / 3 + "%";
                  class33.field718 = 40;
               } else {
                  FaceNormal.field1500 = new class163(true);
                  class33.field719 = "Loaded fonts";
                  class33.field718 = 40;
                  Client.field295 = 60;
               }
            } else if(Client.field295 == 60) {
               var0 = Player.method22(class128.field2074, class152.field2281);
               byte var21 = 9;
               if(var0 < var21) {
                  class33.field719 = "Loading title screen - " + var0 * 100 / var21 + "%";
                  class33.field718 = 50;
               } else {
                  class33.field719 = "Loaded title screen";
                  class33.field718 = 50;
                  class112.setGameState(5);
                  Client.field295 = 70;
               }
            } else if(Client.field295 == 70) {
               if(!class10.field154.method3254()) {
                  class33.field719 = "Loading config - " + class10.field154.method3340() + "%";
                  class33.field718 = 60;
               } else {
                  class171 var25 = class10.field154;
                  class48.field1036 = var25;
                  XItemContainer.method184(class10.field154);
                  class171 var17 = class10.field154;
                  var16 = class192.field3101;
                  KitDefinition.field1009 = var17;
                  class112.field1941 = var16;
                  KitDefinition.field1005 = KitDefinition.field1009.method3260(3);
                  class22.method570(class10.field154, class192.field3101, Client.field271);
                  var18 = class10.field154;
                  var19 = class192.field3101;
                  NPCComposition.field869 = var18;
                  NPCComposition.field887 = var19;
                  class21.method547(class10.field154, class192.field3101, Client.isMembers, class92.field1590);
                  class189.method3728(class10.field154, class23.field583, Sequence.field983);
                  class33.method710(class10.field154, class192.field3101);
                  class51.method1031(class10.field154);
                  class171 var20 = class10.field154;
                  class56.field1198 = var20;
                  class232.field3277 = class56.field1198.method3260(16);
                  class171 var6 = class124.field2043;
                  class171 var7 = class192.field3101;
                  class171 var8 = class152.field2281;
                  class171 var9 = Client.field299;
                  Widget.field2788 = var6;
                  Widget.field2789 = var7;
                  Widget.field2790 = var8;
                  Widget.field2884 = var9;
                  Widget.widgets = new Widget[Widget.field2788.method3327()][];
                  Widget.validInterfaces = new boolean[Widget.field2788.method3327()];
                  class21.method543(class10.field154);
                  class171 var10 = class10.field154;
                  class222.field3215 = var10;
                  class116.method2409(class10.field154);
                  class171 var11 = class10.field154;
                  class53.field1125 = var11;
                  class141.chatMessages = new ChatMessages();
                  class171 var12 = class10.field154;
                  class171 var13 = class152.field2281;
                  class171 var14 = Client.field299;
                  class51.field1101 = var12;
                  class51.field1073 = var13;
                  class51.field1091 = var14;
                  class16.method187(class10.field154, class152.field2281);
                  class33.field719 = "Loaded config";
                  class33.field718 = 60;
                  Client.field295 = 80;
               }
            } else if(Client.field295 != 80) {
               if(Client.field295 == 90) {
                  if(!class154.field2299.method3254()) {
                     class33.field719 = "Loading textures - " + class154.field2299.method3340() + "%";
                     class33.field718 = 90;
                  } else {
                     TextureProvider var24 = new TextureProvider(class154.field2299, class152.field2281, 20, 0.8D, Client.field271?64:128);
                     class94.method2085(var24);
                     class94.method2086(0.8D);
                     class33.field719 = "Loaded textures";
                     class33.field718 = 90;
                     Client.field295 = 110;
                  }
               } else if(Client.field295 == 110) {
                  class18.field244 = new class13();
                  class8.field121.method2878(class18.field244, 10);
                  class33.field719 = "Loaded input handler";
                  class33.field718 = 94;
                  Client.field295 = 120;
               } else if(Client.field295 == 120) {
                  if(!class128.field2074.method3268("huffman", "")) {
                     class33.field719 = "Loading wordpack - " + 0 + "%";
                     class33.field718 = 96;
                  } else {
                     class116 var15 = new class116(class128.field2074.method3273("huffman", ""));
                     class225.field3230 = var15;
                     class33.field719 = "Loaded wordpack";
                     class33.field718 = 96;
                     Client.field295 = 130;
                  }
               } else if(Client.field295 == 130) {
                  if(!class124.field2043.method3254()) {
                     class33.field719 = "Loading interfaces - " + class124.field2043.method3340() * 4 / 5 + "%";
                     class33.field718 = 100;
                  } else if(!class188.field3046.method3254()) {
                     class33.field719 = "Loading interfaces - " + (80 + class188.field3046.method3340() / 6) + "%";
                     class33.field718 = 100;
                  } else if(!Client.field299.method3254()) {
                     class33.field719 = "Loading interfaces - " + (96 + Client.field299.method3340() / 20) + "%";
                     class33.field718 = 100;
                  } else {
                     class33.field719 = "Loaded interfaces";
                     class33.field718 = 100;
                     Client.field295 = 140;
                  }
               } else if(Client.field295 == 140) {
                  class112.setGameState(10);
               }
            } else {
               var0 = 0;
               if(null == class191.field3097) {
                  class191.field3097 = Buffer.method2695(class152.field2281, "compass", "");
               } else {
                  ++var0;
               }

               if(class169.field2716 == null) {
                  class169.field2716 = Buffer.method2695(class152.field2281, "mapedge", "");
               } else {
                  ++var0;
               }

               if(null == class16.field222) {
                  class16.field222 = ChatLineBuffer.method670(class152.field2281, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class172.field2753 == null) {
                  class172.field2753 = Client.method493(class152.field2281, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(null == class128.field2076) {
                  class128.field2076 = Client.method493(class152.field2281, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(null == ObjectComposition.field957) {
                  ObjectComposition.field957 = Client.method493(class152.field2281, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(ChatMessages.field260 == null) {
                  ChatMessages.field260 = Client.method493(class152.field2281, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(null == Item.field676) {
                  Item.field676 = Client.method493(class152.field2281, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(null == NPCComposition.field907) {
                  NPCComposition.field907 = Client.method493(class152.field2281, "cross", "");
               } else {
                  ++var0;
               }

               if(Client.field348 == null) {
                  Client.field348 = Client.method493(class152.field2281, "mapdots", "");
               } else {
                  ++var0;
               }

               if(null == class166.field2699) {
                  class166.field2699 = ChatLineBuffer.method670(class152.field2281, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(null == class35.field761) {
                  class35.field761 = ChatLineBuffer.method670(class152.field2281, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class33.field719 = "Loading sprites - " + 100 * var0 / 12 + "%";
                  class33.field718 = 70;
               } else {
                  class226.modIcons = class35.field761;
                  class169.field2716.method1704();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var5 = 0; var5 < class172.field2753.length; ++var5) {
                     class172.field2753[var5].method1746(var4 + var1, var2 + var4, var4 + var3);
                  }

                  class16.field222[0].method1870(var1 + var4, var2 + var4, var4 + var3);
                  class33.field719 = "Loaded sprites";
                  class33.field718 = 70;
                  Client.field295 = 90;
               }
            }
         }
      }
   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1989 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
