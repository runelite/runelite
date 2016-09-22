import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public final class class16 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1399406295
   )
   int field217;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 939246539
   )
   int field218;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 995621983
   )
   int field219;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -769052617
   )
   int field220;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -565116363
   )
   int field221;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2128109059
   )
   int field222;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1338959717
   )
   int field223;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 253114145
   )
   int field224 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 104165003
   )
   int field225;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 252091175
   )
   static int field226;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -228334495
   )
   int field227 = 0;
   @ObfuscatedName("aw")
   static class149 field228;
   @ObfuscatedName("da")
   @Export("region")
   static Region region;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 854792113
   )
   int field231;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1030834993
   )
   int field232;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-77"
   )
   static void method181(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field660[var5]) {
            var2[var4] = World.field660[var5];
            var3[var4] = World.field661[var5];
            ++var4;
         }
      }

      World.field660 = var2;
      World.field661 = var3;
      ChatLineBuffer.method670(World.worldList, 0, World.worldList.length - 1, World.field660, World.field661);
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1839290241"
   )
   static String method182(int var0) {
      return Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass125;IS)V",
      garbageValue = "-239"
   )
   static final void method183(class125 var0, int var1) {
      int var2 = var0.offset;
      class34.field786 = 0;
      Projectile.method103(var0);
      class52.method1098(var0);
      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IZIB)V",
      garbageValue = "-59"
   )
   public static final void method184(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class59.field1265 = var0;
         class59.field1262 = var1;
         class129.field2122 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-2086107109"
   )
   static byte[] method185(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "2109705621"
   )
   static void method186(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            GameObject.method2225(var6, var2, var3, var4);
            class18.method197(var6, var2, var3);
            if(var6.itemId > var6.scrollWidth - var6.width) {
               var6.itemId = var6.scrollWidth - var6.width;
            }

            if(var6.itemId < 0) {
               var6.itemId = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class10.method136(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lclass35;I)V",
      garbageValue = "-2143126745"
   )
   static final void method187(class35 var0) {
      if(Client.flagX == WidgetNode.localPlayer.x >> 7 && Client.flagY == WidgetNode.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class34.field779;
      int[] var2 = class34.field780;
      int var3 = var1;
      if(var0 == class35.field802 || var0 == class35.field795) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class35.field802) {
            var5 = WidgetNode.localPlayer;
            var6 = WidgetNode.localPlayer.field54 << 14;
         } else if(class35.field795 == var0) {
            var5 = Client.cachedPlayers[Client.field555];
            var6 = Client.field555 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class35.field798 && Client.field555 == var2[var4]) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod785() && !var5.field41) {
            var5.field50 = false;
            if((Client.field285 && var1 > 50 || var1 > 200) && class35.field802 != var0 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field50 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field31) {
                  var5.field50 = false;
                  var5.field39 = class116.method2462(var5.x, var5.y, Item.plane);
                  region.method2010(Item.plane, var5.x, var5.y, var5.field39, 60, var5, var5.angle, var6, var5.field33, var5.field47, var5.field48, var5.field49);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field387 == Client.field472[var7][var8]) {
                        continue;
                     }

                     Client.field472[var7][var8] = Client.field387;
                  }

                  var5.field39 = class116.method2462(var5.x, var5.y, Item.plane);
                  region.method1959(Item.plane, var5.x, var5.y, var5.field39, 60, var5, var5.angle, var6, var5.field842);
               }
            }
         }
      }

   }
}
