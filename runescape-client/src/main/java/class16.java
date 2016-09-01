import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public final class class16 extends Node {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 598551759
   )
   int field231;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1041607399
   )
   int field232;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1561138147
   )
   int field233;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 160541781
   )
   int field234;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -886868633
   )
   int field235;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1010687395
   )
   int field236;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 883946093
   )
   int field238;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1863318063
   )
   int field239;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 440446959
   )
   int field240 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1232099093
   )
   int field241 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -109733939
   )
   int field243;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1375665677
   )
   int field244;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-11772296"
   )
   public static void method186() {
      if(class143.mouse != null) {
         class143 var0 = class143.mouse;
         synchronized(class143.mouse) {
            class143.mouse = null;
         }
      }

   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)Ljava/lang/String;",
      garbageValue = "37"
   )
   static String method187(Widget var0, int var1) {
      int var3 = class132.method2880(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && null == var0.field2804?null:(null != var0.actions && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "28740140"
   )
   public static void method188(Component var0) {
      var0.addMouseListener(class143.mouse);
      var0.addMouseMotionListener(class143.mouse);
      var0.addFocusListener(class143.mouse);
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-183563488"
   )
   static void method189(Widget var0) {
      Widget var1 = var0.parentId == -1?null:World.method628(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = FaceNormal.field1499;
         var3 = class212.field3175;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      ChatMessages.method240(var0, var2, var3, false);
      class93.method2128(var0, var2, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   static final void method190() {
      int var0 = Client.field344 + class48.localPlayer.x;
      int var1 = class48.localPlayer.y + Client.field346;
      if(CollisionData.field1964 - var0 < -500 || CollisionData.field1964 - var0 > 500 || class163.field2701 - var1 < -500 || class163.field2701 - var1 > 500) {
         CollisionData.field1964 = var0;
         class163.field2701 = var1;
      }

      if(CollisionData.field1964 != var0) {
         CollisionData.field1964 += (var0 - CollisionData.field1964) / 16;
      }

      if(class163.field2701 != var1) {
         class163.field2701 += (var1 - class163.field2701) / 16;
      }

      int var2;
      int var3;
      if(class143.field2203 == 4 && class134.field2117) {
         var2 = class143.field2210 - Client.field306;
         Client.field368 = var2 * 2;
         Client.field306 = var2 != -1 && var2 != 1?(Client.field306 + class143.field2210) / 2:class143.field2210;
         var3 = Client.field369 - class143.field2204;
         Client.field367 = var3 * 2;
         Client.field369 = var3 != -1 && var3 != 1?(class143.field2204 + Client.field369) / 2:class143.field2204;
      } else {
         if(class140.field2167[96]) {
            Client.field367 += (-24 - Client.field367) / 2;
         } else if(class140.field2167[97]) {
            Client.field367 += (24 - Client.field367) / 2;
         } else {
            Client.field367 /= 2;
         }

         if(class140.field2167[98]) {
            Client.field368 += (12 - Client.field368) / 2;
         } else if(class140.field2167[99]) {
            Client.field368 += (-12 - Client.field368) / 2;
         } else {
            Client.field368 /= 2;
         }

         Client.field306 = class143.field2210;
         Client.field369 = class143.field2204;
      }

      Client.mapAngle = Client.field367 / 2 + Client.mapAngle & 2047;
      Client.field365 += Client.field368 / 2;
      if(Client.field365 < 128) {
         Client.field365 = 128;
      }

      if(Client.field365 > 383) {
         Client.field365 = 383;
      }

      var2 = CollisionData.field1964 >> 7;
      var3 = class163.field2701 >> 7;
      int var4 = KitDefinition.method936(CollisionData.field1964, class163.field2701, FrameMap.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = FrameMap.plane;
               if(var8 < 3 && (class5.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class5.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = 192 * var5;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field374) {
         Client.field374 += (var6 - Client.field374) / 24;
      } else if(var6 < Client.field374) {
         Client.field374 += (var6 - Client.field374) / 80;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-155248136"
   )
   static final void method191(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2556();
            if(var7 == 0) {
               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = -class146.method3060(var4 + var2 + 932731, var5 + var3 + 556238) * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2556();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = 8 * -var8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class109.field1921[var1][var2][var3] = var0.method2557();
               class5.field75[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field76[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field85[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2556();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2556();
               break;
            }

            if(var7 <= 49) {
               var0.method2556();
            }
         }
      }

   }
}
