import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class51 extends CacheableNode {
   @ObfuscatedName("g")
   public static class170 field1127;
   @ObfuscatedName("e")
   static NodeCache field1128 = new NodeCache(64);
   @ObfuscatedName("h")
   @Export("spriteCache")
   static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 343161613
   )
   int field1130 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 91035515
   )
   int field1131 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -465465731
   )
   public int field1133 = 16777215;
   @ObfuscatedName("l")
   public static class170 field1134;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2119655079
   )
   public int field1135 = 70;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1478067921
   )
   int field1136 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -901440423
   )
   int field1137 = -1;
   @ObfuscatedName("s")
   static NodeCache field1138 = new NodeCache(20);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 132407137
   )
   int field1139 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1482299811
   )
   public int field1140 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -819716559
   )
   public int field1142 = -1;
   @ObfuscatedName("x")
   String field1143 = "";
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1200379707
   )
   public int field1144 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -59737953
   )
   public int field1145 = 0;
   @ObfuscatedName("ck")
   public static char field1146;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -428384161
   )
   public int field1150 = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1779459932"
   )
   void method1079(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1080(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1473135211"
   )
   void method1080(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1131 = var1.method2698();
      } else if(var2 == 2) {
         this.field1133 = var1.method2637();
      } else if(var2 == 3) {
         this.field1130 = var1.method2698();
      } else if(var2 == 4) {
         this.field1136 = var1.method2698();
      } else if(var2 == 5) {
         this.field1137 = var1.method2698();
      } else if(var2 == 6) {
         this.field1139 = var1.method2698();
      } else if(var2 == 7) {
         this.field1140 = var1.method2636();
      } else if(var2 == 8) {
         this.field1143 = var1.method2642();
      } else if(var2 == 9) {
         this.field1135 = var1.method2635();
      } else if(var2 == 10) {
         this.field1150 = var1.method2636();
      } else if(var2 == 11) {
         this.field1142 = 0;
      } else if(var2 == 12) {
         this.field1144 = var1.method2633();
      } else if(var2 == 13) {
         this.field1145 = var1.method2636();
      } else if(var2 == 14) {
         this.field1142 = var1.method2635();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "67"
   )
   public String method1081(int var1) {
      String var2 = this.field1143;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class21.method583(var1, false) + var2.substring(2 + var3);
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-10475"
   )
   static final void method1082(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field496; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field498[var4] = true;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-32"
   )
   public SpritePixels method1084() {
      if(this.field1136 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1136);
         if(null != var1) {
            return var1;
         } else {
            var1 = class32.method699(field1127, this.field1136, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1136);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-116"
   )
   public SpritePixels method1085() {
      if(this.field1139 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1139);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class32.method699(field1127, this.field1139, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1139);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "47"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 39) {
         Client.field337.method2903(182);
         Client.field337.method2619(var0);
         Client.field337.method2675(var1);
         Client.field337.method2666(var3);
         Client.field300 = 0;
         ObjectComposition.field994 = class134.method2983(var1);
         Client.field509 = var0;
      }

      if(var2 == 21) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field337.method2903(101);
         Client.field337.method2619(var0 + class0.baseX);
         Client.field337.method2668(var3);
         Client.field337.method2658(class140.field2171[82]?1:0);
         Client.field337.method2668(var1 + class21.baseY);
      }

      Player var8;
      if(var2 == 49) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(201);
            Client.field337.method2619(var3);
            Client.field337.method2657(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 19) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field337.method2903(211);
         Client.field337.method2654(class140.field2171[82]?1:0);
         Client.field337.method2668(var3);
         Client.field337.method2619(class0.baseX + var0);
         Client.field337.method2619(class21.baseY + var1);
      }

      if(var2 == 2) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field337.method2903(127);
         Client.field337.method2668(var0 + class0.baseX);
         Client.field337.method2666(var3 >> 14 & 32767);
         Client.field337.method2675(class13.field209);
         Client.field337.method2657(class140.field2171[82]?1:0);
         Client.field337.method2668(Client.field449);
         Client.field337.method2619(var1 + class21.baseY);
      }

      if(var2 == 23) {
         class136.region.method2028(VertexNormal.plane, var0, var1);
      }

      if(var2 == 3) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field337.method2903(219);
         Client.field337.method2666(var3 >> 14 & 32767);
         Client.field337.method2666(class0.baseX + var0);
         Client.field337.method2783(class140.field2171[82]?1:0);
         Client.field337.method2666(var1 + class21.baseY);
      }

      if(var2 == 1004) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.field337.method2903(165);
         Client.field337.method2668(var3);
      }

      if(var2 == 42) {
         Client.field337.method2903(38);
         Client.field337.method2668(var0);
         Client.field337.method2675(var1);
         Client.field337.method2668(var3);
         Client.field300 = 0;
         ObjectComposition.field994 = class134.method2983(var1);
         Client.field509 = var0;
      }

      if(var2 == 37) {
         Client.field337.method2903(116);
         Client.field337.method2667(var0);
         Client.field337.method2668(var3);
         Client.field337.method2676(var1);
         Client.field300 = 0;
         ObjectComposition.field994 = class134.method2983(var1);
         Client.field509 = var0;
      }

      int var9;
      Widget var10;
      if(var2 == 29) {
         Client.field337.method2903(23);
         Client.field337.method2728(var1);
         var10 = class134.method2983(var1);
         if(null != var10.dynamicValues && var10.dynamicValues[0][0] == 5) {
            var9 = var10.dynamicValues[0][1];
            if(class179.widgetSettings[var9] != var10.field2921[0]) {
               class179.widgetSettings[var9] = var10.field2921[0];
               ClassInfo.method4080(var9);
            }
         }
      }

      NPC var11;
      if(var2 == 8) {
         var11 = Client.cachedNPCs[var3];
         if(var11 != null) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(133);
            Client.field337.method2783(class140.field2171[82]?1:0);
            Client.field337.method2666(var3);
            Client.field337.method2666(Client.field449);
            Client.field337.method2677(class13.field209);
         }
      }

      if(var2 == 5) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field337.method2903(99);
         Client.field337.method2619(var0 + class0.baseX);
         Client.field337.method2619(var3 >> 14 & 32767);
         Client.field337.method2658(class140.field2171[82]?1:0);
         Client.field337.method2619(var1 + class21.baseY);
      }

      if(var2 == 44) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(82);
            Client.field337.method2783(class140.field2171[82]?1:0);
            Client.field337.method2668(var3);
         }
      }

      if(var2 == 12) {
         var11 = Client.cachedNPCs[var3];
         if(null != var11) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(141);
            Client.field337.method2666(var3);
            Client.field337.method2783(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 9) {
         var11 = Client.cachedNPCs[var3];
         if(var11 != null) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(248);
            Client.field337.method2668(var3);
            Client.field337.method2783(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 1002) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.field337.method2903(223);
         Client.field337.method2619(var3 >> 14 & 32767);
      }

      if(var2 == 24) {
         var10 = class134.method2983(var1);
         boolean var12 = true;
         if(var10.contentType > 0) {
            var12 = class126.method2917(var10);
         }

         if(var12) {
            Client.field337.method2903(23);
            Client.field337.method2728(var1);
         }
      }

      if(var2 == 34) {
         Client.field337.method2903(147);
         Client.field337.method2675(var1);
         Client.field337.method2619(var3);
         Client.field337.method2668(var0);
         Client.field300 = 0;
         ObjectComposition.field994 = class134.method2983(var1);
         Client.field509 = var0;
      }

      if(var2 == 47) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(160);
            Client.field337.method2657(class140.field2171[82]?1:0);
            Client.field337.method2668(var3);
         }
      }

      if(var2 == 50) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(120);
            Client.field337.method2658(class140.field2171[82]?1:0);
            Client.field337.method2666(var3);
         }
      }

      if(var2 == 51) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(63);
            Client.field337.method2619(var3);
            Client.field337.method2658(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 58) {
         var10 = class151.method3265(var1, var0);
         if(var10 != null) {
            Client.field337.method2903(213);
            Client.field337.method2676(var1);
            Client.field337.method2667(Client.field449);
            Client.field337.method2619(var0);
            Client.field337.method2668(var10.item);
            Client.field337.method2675(class13.field209);
            Client.field337.method2668(Client.field459);
         }
      }

      if(var2 == 1) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field337.method2903(89);
         Client.field337.method2677(DecorativeObject.field1688);
         Client.field337.method2668(class21.baseY + var1);
         Client.field337.method2619(class23.field618);
         Client.field337.method2668(class0.baseX + var0);
         Client.field337.method2619(var3 >> 14 & 32767);
         Client.field337.method2783(class140.field2171[82]?1:0);
         Client.field337.method2667(class10.field165);
      }

      if(var2 == 22) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field337.method2903(87);
         Client.field337.method2658(class140.field2171[82]?1:0);
         Client.field337.method2619(class21.baseY + var1);
         Client.field337.method2667(class0.baseX + var0);
         Client.field337.method2668(var3);
      }

      if(var2 == 14) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(66);
            Client.field337.method2619(class23.field618);
            Client.field337.method2675(DecorativeObject.field1688);
            Client.field337.method2657(class140.field2171[82]?1:0);
            Client.field337.method2667(var3);
            Client.field337.method2667(class10.field165);
         }
      }

      if(var2 == 48) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(156);
            Client.field337.method2783(class140.field2171[82]?1:0);
            Client.field337.method2668(var3);
         }
      }

      if(var2 == 45) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(140);
            Client.field337.method2783(class140.field2171[82]?1:0);
            Client.field337.method2619(var3);
         }
      }

      if(var2 == 30 && Client.field376 == null) {
         class33.method718(var1, var0);
         Client.field376 = class151.method3265(var1, var0);
         class79.method1777(Client.field376);
      }

      if(var2 == 17) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field337.method2903(48);
         Client.field337.method2658(class140.field2171[82]?1:0);
         Client.field337.method2619(Client.field449);
         Client.field337.method2668(class21.baseY + var1);
         Client.field337.method2666(class0.baseX + var0);
         Client.field337.method2728(class13.field209);
         Client.field337.method2666(var3);
      }

      if(var2 == 11) {
         var11 = Client.cachedNPCs[var3];
         if(null != var11) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(102);
            Client.field337.method2666(var3);
            Client.field337.method2783(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 18) {
         Client.field480 = var6;
         Client.field404 = var7;
         Client.field406 = 2;
         Client.field537 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field337.method2903(129);
         Client.field337.method2668(var0 + class0.baseX);
         Client.field337.method2619(var3);
         Client.field337.method2668(class21.baseY + var1);
         Client.field337.method2658(class140.field2171[82]?1:0);
      }

      if(var2 == 28) {
         Client.field337.method2903(23);
         Client.field337.method2728(var1);
         var10 = class134.method2983(var1);
         if(var10.dynamicValues != null && var10.dynamicValues[0][0] == 5) {
            var9 = var10.dynamicValues[0][1];
            class179.widgetSettings[var9] = 1 - class179.widgetSettings[var9];
            ClassInfo.method4080(var9);
         }
      }

      if(var2 == 35) {
         Client.field337.method2903(207);
         Client.field337.method2675(var1);
         Client.field337.method2619(var0);
         Client.field337.method2668(var3);
         Client.field300 = 0;
         ObjectComposition.field994 = class134.method2983(var1);
         Client.field509 = var0;
      }

      if(var2 == 38) {
         class0.method0();
         var10 = class134.method2983(var1);
         Client.field439 = 1;
         class23.field618 = var0;
         DecorativeObject.field1688 = var1;
         class10.field165 = var3;
         class79.method1777(var10);
         Client.field447 = class16.method205(16748608) + class1.getItemDefinition(var3).name + class16.method205(16777215);
         if(null == Client.field447) {
            Client.field447 = "null";
         }
      } else {
         if(var2 == 4) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(13);
            Client.field337.method2667(var3 >> 14 & 32767);
            Client.field337.method2658(class140.field2171[82]?1:0);
            Client.field337.method2619(var0 + class0.baseX);
            Client.field337.method2619(class21.baseY + var1);
         }

         if(var2 == 41) {
            Client.field337.method2903(135);
            Client.field337.method2668(var0);
            Client.field337.method2728(var1);
            Client.field337.method2668(var3);
            Client.field300 = 0;
            ObjectComposition.field994 = class134.method2983(var1);
            Client.field509 = var0;
         }

         if(var2 == 6) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(36);
            Client.field337.method2666(class21.baseY + var1);
            Client.field337.method2667(var3 >> 14 & 32767);
            Client.field337.method2619(class0.baseX + var0);
            Client.field337.method2657(class140.field2171[82]?1:0);
         }

         if(var2 == 1005) {
            var10 = class134.method2983(var1);
            if(var10 != null && var10.itemQuantities[var0] >= 100000) {
               SecondaryBufferProvider.sendGameMessage(27, "", var10.itemQuantities[var0] + " x " + class1.getItemDefinition(var3).name);
            } else {
               Client.field337.method2903(165);
               Client.field337.method2668(var3);
            }

            Client.field300 = 0;
            ObjectComposition.field994 = class134.method2983(var1);
            Client.field509 = var0;
         }

         if(var2 == 16) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(240);
            Client.field337.method2667(var3);
            Client.field337.method2668(class23.field618);
            Client.field337.method2668(var0 + class0.baseX);
            Client.field337.method2667(class21.baseY + var1);
            Client.field337.method2675(DecorativeObject.field1688);
            Client.field337.method2657(class140.field2171[82]?1:0);
            Client.field337.method2619(class10.field165);
         }

         if(var2 == 7) {
            var11 = Client.cachedNPCs[var3];
            if(null != var11) {
               Client.field480 = var6;
               Client.field404 = var7;
               Client.field406 = 2;
               Client.field537 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field337.method2903(46);
               Client.field337.method2783(class140.field2171[82]?1:0);
               Client.field337.method2667(var3);
               Client.field337.method2668(class10.field165);
               Client.field337.method2666(class23.field618);
               Client.field337.method2676(DecorativeObject.field1688);
            }
         }

         if(var2 == 10) {
            var11 = Client.cachedNPCs[var3];
            if(var11 != null) {
               Client.field480 = var6;
               Client.field404 = var7;
               Client.field406 = 2;
               Client.field537 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field337.method2903(9);
               Client.field337.method2667(var3);
               Client.field337.method2657(class140.field2171[82]?1:0);
            }
         }

         if(var2 == 33) {
            Client.field337.method2903(6);
            Client.field337.method2667(var3);
            Client.field337.method2666(var0);
            Client.field337.method2675(var1);
            Client.field300 = 0;
            ObjectComposition.field994 = class134.method2983(var1);
            Client.field509 = var0;
         }

         if(var2 == 20) {
            Client.field480 = var6;
            Client.field404 = var7;
            Client.field406 = 2;
            Client.field537 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field337.method2903(252);
            Client.field337.method2667(var3);
            Client.field337.method2666(class0.baseX + var0);
            Client.field337.method2668(class21.baseY + var1);
            Client.field337.method2658(class140.field2171[82]?1:0);
         }

         if(var2 == 40) {
            Client.field337.method2903(142);
            Client.field337.method2666(var3);
            Client.field337.method2666(var0);
            Client.field337.method2728(var1);
            Client.field300 = 0;
            ObjectComposition.field994 = class134.method2983(var1);
            Client.field509 = var0;
         }

         if(var2 == 26) {
            Client.field337.method2903(197);
            WidgetNode var13 = (WidgetNode)Client.componentTable.method3939();

            while(true) {
               if(var13 == null) {
                  if(null != Client.field376) {
                     class79.method1777(Client.field376);
                     Client.field376 = null;
                  }
                  break;
               }

               if(var13.field60 == 0 || var13.field60 == 3) {
                  class145.method3130(var13, true);
               }

               var13 = (WidgetNode)Client.componentTable.method3935();
            }
         }

         if(var2 == 31) {
            Client.field337.method2903(131);
            Client.field337.method2668(class23.field618);
            Client.field337.method2666(var0);
            Client.field337.method2728(DecorativeObject.field1688);
            Client.field337.method2666(var3);
            Client.field337.method2666(class10.field165);
            Client.field337.method2676(var1);
            Client.field300 = 0;
            ObjectComposition.field994 = class134.method2983(var1);
            Client.field509 = var0;
         }

         if(var2 == 15) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field480 = var6;
               Client.field404 = var7;
               Client.field406 = 2;
               Client.field537 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field337.method2903(88);
               Client.field337.method2783(class140.field2171[82]?1:0);
               Client.field337.method2728(class13.field209);
               Client.field337.method2667(var3);
               Client.field337.method2667(Client.field449);
            }
         }

         if(var2 == 36) {
            Client.field337.method2903(245);
            Client.field337.method2667(var3);
            Client.field337.method2666(var0);
            Client.field337.method2677(var1);
            Client.field300 = 0;
            ObjectComposition.field994 = class134.method2983(var1);
            Client.field509 = var0;
         }

         if(var2 == 32) {
            Client.field337.method2903(228);
            Client.field337.method2728(var1);
            Client.field337.method2619(Client.field449);
            Client.field337.method2619(var0);
            Client.field337.method2619(var3);
            Client.field337.method2676(class13.field209);
            Client.field300 = 0;
            ObjectComposition.field994 = class134.method2983(var1);
            Client.field509 = var0;
         }

         if(var2 == 13) {
            var11 = Client.cachedNPCs[var3];
            if(null != var11) {
               Client.field480 = var6;
               Client.field404 = var7;
               Client.field406 = 2;
               Client.field537 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field337.method2903(76);
               Client.field337.method2783(class140.field2171[82]?1:0);
               Client.field337.method2668(var3);
            }
         }

         if(var2 == 25) {
            var10 = class151.method3265(var1, var0);
            if(null != var10) {
               class0.method0();
               Projectile.method109(var1, var0, class215.method4089(Player.method39(var10)), var10.item);
               Client.field439 = 0;
               Client.field306 = class4.method48(var10);
               if(Client.field306 == null) {
                  Client.field306 = "Null";
               }

               if(var10.field2855) {
                  Client.field452 = var10.name + class16.method205(16777215);
               } else {
                  Client.field452 = class16.method205('\uff00') + var10.field2809 + class16.method205(16777215);
               }
            }
         } else {
            if(var2 == 1001) {
               Client.field480 = var6;
               Client.field404 = var7;
               Client.field406 = 2;
               Client.field537 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field337.method2903(111);
               Client.field337.method2783(class140.field2171[82]?1:0);
               Client.field337.method2666(var1 + class21.baseY);
               Client.field337.method2666(var3 >> 14 & 32767);
               Client.field337.method2619(var0 + class0.baseX);
            }

            if(var2 == 46) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field480 = var6;
                  Client.field404 = var7;
                  Client.field406 = 2;
                  Client.field537 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field337.method2903(25);
                  Client.field337.method2783(class140.field2171[82]?1:0);
                  Client.field337.method2619(var3);
               }
            }

            if(var2 == 1003) {
               Client.field480 = var6;
               Client.field404 = var7;
               Client.field406 = 2;
               Client.field537 = 0;
               var11 = Client.cachedNPCs[var3];
               if(null != var11) {
                  NPCComposition var14 = var11.composition;
                  if(null != var14.field937) {
                     var14 = var14.method820();
                  }

                  if(var14 != null) {
                     Client.field337.method2903(178);
                     Client.field337.method2666(var14.id);
                  }
               }
            }

            if(var2 == 57 || var2 == 1007) {
               var10 = class151.method3265(var1, var0);
               if(null != var10) {
                  class50.method1077(var3, var1, var0, var10.item, var5);
               }
            }

            if(var2 == 43) {
               Client.field337.method2903(81);
               Client.field337.method2675(var1);
               Client.field337.method2668(var0);
               Client.field337.method2666(var3);
               Client.field300 = 0;
               ObjectComposition.field994 = class134.method2983(var1);
               Client.field509 = var0;
            }

            if(Client.field439 != 0) {
               Client.field439 = 0;
               class79.method1777(class134.method2983(DecorativeObject.field1688));
            }

            if(Client.field448) {
               class0.method0();
            }

            if(null != ObjectComposition.field994 && Client.field300 == 0) {
               class79.method1777(ObjectComposition.field994);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Lclass227;",
      garbageValue = "1705751998"
   )
   public class227 method1094() {
      if(this.field1131 == -1) {
         return null;
      } else {
         class227 var1 = (class227)field1138.get((long)this.field1131);
         if(var1 != null) {
            return var1;
         } else {
            class170 var2 = field1127;
            class170 var3 = class225.field3226;
            int var4 = this.field1131;
            class227 var5;
            if(!class4.method49(var2, var4, 0)) {
               var5 = null;
            } else {
               byte[] var6 = var3.method3411(var4, 0);
               class227 var7;
               if(null == var6) {
                  var7 = null;
               } else {
                  class227 var8 = new class227(var6, class79.field1457, class180.field2962, class192.field3106, class79.field1458, class79.field1459, class145.field2236);
                  ItemComposition.method1182();
                  var7 = var8;
               }

               var5 = var7;
            }

            Object var9 = null;
            return var5;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-604983827"
   )
   public SpritePixels method1099() {
      if(this.field1130 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1130);
         if(null != var1) {
            return var1;
         } else {
            var1 = class32.method699(field1127, this.field1130, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1130);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1366787254"
   )
   public SpritePixels method1101() {
      if(this.field1137 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1137);
         if(null != var1) {
            return var1;
         } else {
            var1 = class32.method699(field1127, this.field1137, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1137);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1968848073"
   )
   public static void method1116() {
      KitDefinition.field1063.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-31"
   )
   public static boolean method1117(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
