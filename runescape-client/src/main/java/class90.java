import java.math.BigInteger;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class90 {
   @ObfuscatedName("n")
   static class103 field1395;
   @ObfuscatedName("m")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;
   @ObfuscatedName("z")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("p")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1960859143"
   )
   static int method1617(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      return class51.field668 != null && class51.field668.hash == var2?class77.field1207.offset * 99 / (class77.field1207.payload.length - class51.field668.field3214) + 1:0;
   }

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("9df796757dde3a3b23a971146949b472608c29472dbc3eb079a16cf0ed5c25aab4edb6225d1ebe9c2fcfd7832924edaad7788f2b1a0e5c09a22c679a7fc547893224d45af661efcb1b9843d39bbad6c4cf2d22fc5392e43611f40faad8c8364a7d82266fd1f92cb350cd4e893b9aa12a25493b0bac617a6f4b46cc17d539af4b", 16);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IZIB)V",
      garbageValue = "40"
   )
   public static final void method1618(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class109.field1635 = var0;
         class222.field2849 = var1;
         class109.field1623 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-67"
   )
   static int method1619(int var0, Script var1, boolean var2) {
      byte var3;
      int var4;
      int var6;
      int var9;
      int var24;
      Widget var29;
      Widget var67;
      if(var0 < 1000) {
         if(var0 == 100) {
            class83.intStackSize -= 3;
            var4 = class83.intStack[class83.intStackSize];
            var24 = class83.intStack[class83.intStackSize + 1];
            var6 = class83.intStack[class83.intStackSize + 2];
            if(var24 == 0) {
               throw new RuntimeException();
            }

            var29 = class223.method3959(var4);
            if(var29.children == null) {
               var29.children = new Widget[var6 + 1];
            }

            if(var29.children.length <= var6) {
               Widget[] var34 = new Widget[var6 + 1];

               for(var9 = 0; var9 < var29.children.length; ++var9) {
                  var34[var9] = var29.children[var9];
               }

               var29.children = var34;
            }

            if(var6 > 0 && var29.children[var6 - 1] == null) {
               throw new RuntimeException("" + (var6 - 1));
            }

            Widget var35 = new Widget();
            var35.type = var24;
            var35.parentId = var35.id = var29.id;
            var35.index = var6;
            var35.hasScript = true;
            var29.children[var6] = var35;
            if(var2) {
               class43.field582 = var35;
            } else {
               class31.field457 = var35;
            }

            XItemContainer.method1020(var29);
            var3 = 1;
         } else if(var0 == 101) {
            var67 = var2?class43.field582:class31.field457;
            Widget var65 = class223.method3959(var67.id);
            var65.children[var67.index] = null;
            XItemContainer.method1020(var65);
            var3 = 1;
         } else if(var0 == 102) {
            var67 = class223.method3959(class83.intStack[--class83.intStackSize]);
            var67.children = null;
            XItemContainer.method1020(var67);
            var3 = 1;
         } else if(var0 == 200) {
            class83.intStackSize -= 2;
            var4 = class83.intStack[class83.intStackSize];
            var24 = class83.intStack[class83.intStackSize + 1];
            Widget var53 = class172.method3015(var4, var24);
            if(var53 != null && var24 != -1) {
               class83.intStack[++class83.intStackSize - 1] = 1;
               if(var2) {
                  class43.field582 = var53;
               } else {
                  class31.field457 = var53;
               }
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 201) {
            var67 = class223.method3959(class83.intStack[--class83.intStackSize]);
            if(var67 != null) {
               class83.intStack[++class83.intStackSize - 1] = 1;
               if(var2) {
                  class43.field582 = var67;
               } else {
                  class31.field457 = var67;
               }
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1100) {
         return class14.method90(var0, var1, var2);
      } else if(var0 < 1200) {
         return class71.method1047(var0, var1, var2);
      } else if(var0 < 1300) {
         return class164.method2956(var0, var1, var2);
      } else if(var0 < 1400) {
         return WorldMapData.method350(var0, var1, var2);
      } else if(var0 < 1500) {
         return GroundObject.method2378(var0, var1, var2);
      } else if(var0 < 1600) {
         var29 = var2?class43.field582:class31.field457;
         if(var0 == 1500) {
            class83.intStack[++class83.intStackSize - 1] = var29.relativeX;
            var3 = 1;
         } else if(var0 == 1501) {
            class83.intStack[++class83.intStackSize - 1] = var29.relativeY;
            var3 = 1;
         } else if(var0 == 1502) {
            class83.intStack[++class83.intStackSize - 1] = var29.width;
            var3 = 1;
         } else if(var0 == 1503) {
            class83.intStack[++class83.intStackSize - 1] = var29.height;
            var3 = 1;
         } else if(var0 == 1504) {
            class83.intStack[++class83.intStackSize - 1] = var29.isHidden?1:0;
            var3 = 1;
         } else if(var0 == 1505) {
            class83.intStack[++class83.intStackSize - 1] = var29.parentId;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1700) {
         var67 = var2?class43.field582:class31.field457;
         if(var0 == 1600) {
            class83.intStack[++class83.intStackSize - 1] = var67.scrollX;
            var3 = 1;
         } else if(var0 == 1601) {
            class83.intStack[++class83.intStackSize - 1] = var67.scrollY;
            var3 = 1;
         } else if(var0 == 1602) {
            class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var67.text;
            var3 = 1;
         } else if(var0 == 1603) {
            class83.intStack[++class83.intStackSize - 1] = var67.scrollWidth;
            var3 = 1;
         } else if(var0 == 1604) {
            class83.intStack[++class83.intStackSize - 1] = var67.scrollHeight;
            var3 = 1;
         } else if(var0 == 1605) {
            class83.intStack[++class83.intStackSize - 1] = var67.field2737;
            var3 = 1;
         } else if(var0 == 1606) {
            class83.intStack[++class83.intStackSize - 1] = var67.rotationX;
            var3 = 1;
         } else if(var0 == 1607) {
            class83.intStack[++class83.intStackSize - 1] = var67.rotationY;
            var3 = 1;
         } else if(var0 == 1608) {
            class83.intStack[++class83.intStackSize - 1] = var67.rotationZ;
            var3 = 1;
         } else if(var0 == 1609) {
            class83.intStack[++class83.intStackSize - 1] = var67.opacity;
            var3 = 1;
         } else if(var0 == 1610) {
            class83.intStack[++class83.intStackSize - 1] = var67.field2686;
            var3 = 1;
         } else if(var0 == 1611) {
            class83.intStack[++class83.intStackSize - 1] = var67.textColor;
            var3 = 1;
         } else if(var0 == 1612) {
            class83.intStack[++class83.intStackSize - 1] = var67.field2728;
            var3 = 1;
         } else if(var0 == 1613) {
            class83.intStack[++class83.intStackSize - 1] = var67.field2684.ordinal();
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1800) {
         var29 = var2?class43.field582:class31.field457;
         if(var0 == 1700) {
            class83.intStack[++class83.intStackSize - 1] = var29.itemId;
            var3 = 1;
         } else if(var0 == 1701) {
            if(var29.itemId != -1) {
               class83.intStack[++class83.intStackSize - 1] = var29.itemQuantity;
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 1702) {
            class83.intStack[++class83.intStackSize - 1] = var29.index;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1900) {
         var67 = var2?class43.field582:class31.field457;
         if(var0 == 1800) {
            class83.intStack[++class83.intStackSize - 1] = WorldMapType1.method263(class15.method92(var67));
            var3 = 1;
         } else if(var0 == 1801) {
            var24 = class83.intStack[--class83.intStackSize];
            --var24;
            if(var67.actions != null && var24 < var67.actions.length && var67.actions[var24] != null) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var67.actions[var24];
            } else {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            }

            var3 = 1;
         } else if(var0 == 1802) {
            if(var67.name == null) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var67.name;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 2000) {
         return VertexNormal.method2490(var0, var1, var2);
      } else if(var0 < 2100) {
         return class14.method90(var0, var1, var2);
      } else if(var0 < 2200) {
         return class71.method1047(var0, var1, var2);
      } else if(var0 < 2300) {
         return class164.method2956(var0, var1, var2);
      } else if(var0 < 2400) {
         return WorldMapData.method350(var0, var1, var2);
      } else if(var0 < 2500) {
         return GroundObject.method2378(var0, var1, var2);
      } else if(var0 < 2600) {
         var67 = class223.method3959(class83.intStack[--class83.intStackSize]);
         if(var0 == 2500) {
            class83.intStack[++class83.intStackSize - 1] = var67.relativeX;
            var3 = 1;
         } else if(var0 == 2501) {
            class83.intStack[++class83.intStackSize - 1] = var67.relativeY;
            var3 = 1;
         } else if(var0 == 2502) {
            class83.intStack[++class83.intStackSize - 1] = var67.width;
            var3 = 1;
         } else if(var0 == 2503) {
            class83.intStack[++class83.intStackSize - 1] = var67.height;
            var3 = 1;
         } else if(var0 == 2504) {
            class83.intStack[++class83.intStackSize - 1] = var67.isHidden?1:0;
            var3 = 1;
         } else if(var0 == 2505) {
            class83.intStack[++class83.intStackSize - 1] = var67.parentId;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 2700) {
         var67 = class223.method3959(class83.intStack[--class83.intStackSize]);
         if(var0 == 2600) {
            class83.intStack[++class83.intStackSize - 1] = var67.scrollX;
            var3 = 1;
         } else if(var0 == 2601) {
            class83.intStack[++class83.intStackSize - 1] = var67.scrollY;
            var3 = 1;
         } else if(var0 == 2602) {
            class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var67.text;
            var3 = 1;
         } else if(var0 == 2603) {
            class83.intStack[++class83.intStackSize - 1] = var67.scrollWidth;
            var3 = 1;
         } else if(var0 == 2604) {
            class83.intStack[++class83.intStackSize - 1] = var67.scrollHeight;
            var3 = 1;
         } else if(var0 == 2605) {
            class83.intStack[++class83.intStackSize - 1] = var67.field2737;
            var3 = 1;
         } else if(var0 == 2606) {
            class83.intStack[++class83.intStackSize - 1] = var67.rotationX;
            var3 = 1;
         } else if(var0 == 2607) {
            class83.intStack[++class83.intStackSize - 1] = var67.rotationY;
            var3 = 1;
         } else if(var0 == 2608) {
            class83.intStack[++class83.intStackSize - 1] = var67.rotationZ;
            var3 = 1;
         } else if(var0 == 2609) {
            class83.intStack[++class83.intStackSize - 1] = var67.opacity;
            var3 = 1;
         } else if(var0 == 2610) {
            class83.intStack[++class83.intStackSize - 1] = var67.field2686;
            var3 = 1;
         } else if(var0 == 2611) {
            class83.intStack[++class83.intStackSize - 1] = var67.textColor;
            var3 = 1;
         } else if(var0 == 2612) {
            class83.intStack[++class83.intStackSize - 1] = var67.field2728;
            var3 = 1;
         } else if(var0 == 2613) {
            class83.intStack[++class83.intStackSize - 1] = var67.field2684.ordinal();
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 2800) {
         if(var0 == 2700) {
            var67 = class223.method3959(class83.intStack[--class83.intStackSize]);
            class83.intStack[++class83.intStackSize - 1] = var67.itemId;
            var3 = 1;
         } else if(var0 == 2701) {
            var67 = class223.method3959(class83.intStack[--class83.intStackSize]);
            if(var67.itemId != -1) {
               class83.intStack[++class83.intStackSize - 1] = var67.itemQuantity;
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 2702) {
            var4 = class83.intStack[--class83.intStackSize];
            WidgetNode var64 = (WidgetNode)Client.componentTable.method3425((long)var4);
            if(var64 != null) {
               class83.intStack[++class83.intStackSize - 1] = 1;
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 2706) {
            class83.intStack[++class83.intStackSize - 1] = Client.widgetRoot;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 2900) {
         var67 = class223.method3959(class83.intStack[--class83.intStackSize]);
         if(var0 == 2800) {
            class83.intStack[++class83.intStackSize - 1] = WorldMapType1.method263(class15.method92(var67));
            var3 = 1;
         } else if(var0 == 2801) {
            var24 = class83.intStack[--class83.intStackSize];
            --var24;
            if(var67.actions != null && var24 < var67.actions.length && var67.actions[var24] != null) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var67.actions[var24];
            } else {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            }

            var3 = 1;
         } else if(var0 == 2802) {
            if(var67.name == null) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var67.name;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 3000) {
         return VertexNormal.method2490(var0, var1, var2);
      } else if(var0 < 3200) {
         return class278.method4806(var0, var1, var2);
      } else if(var0 < 3300) {
         if(var0 == 3200) {
            class83.intStackSize -= 3;
            var4 = class83.intStack[class83.intStackSize];
            var24 = class83.intStack[class83.intStackSize + 1];
            var6 = class83.intStack[class83.intStackSize + 2];
            if(Client.field1144 != 0 && var24 != 0 && Client.field931 < 50) {
               Client.field1036[Client.field931] = var4;
               Client.field1155[Client.field931] = var24;
               Client.field1150[Client.field931] = var6;
               Client.audioEffects[Client.field931] = null;
               Client.field1170[Client.field931] = 0;
               ++Client.field931;
            }

            var3 = 1;
         } else if(var0 == 3201) {
            var4 = class83.intStack[--class83.intStackSize];
            if(var4 == -1 && !Client.field1143) {
               class203.field2516.method3579();
               class203.field2517 = 1;
               class203.field2518 = null;
            } else if(var4 != -1 && var4 != Client.field1142 && Client.field1141 != 0 && !Client.field1143) {
               IndexData var63 = FaceNormal.indexTrack1;
               var6 = Client.field1141;
               class203.field2517 = 1;
               class203.field2518 = var63;
               class203.field2519 = var4;
               class29.field438 = 0;
               class182.field2455 = var6;
               class88.field1384 = false;
               CollisionData.field2304 = 2;
            }

            Client.field1142 = var4;
            var3 = 1;
         } else if(var0 == 3202) {
            class83.intStackSize -= 2;
            GameEngine.method931(class83.intStack[class83.intStackSize], class83.intStack[class83.intStackSize + 1]);
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 3400) {
         return class5.method14(var0, var1, var2);
      } else if(var0 < 3500) {
         return WidgetNode.method1032(var0, var1, var2);
      } else if(var0 < 3700) {
         return class205.method3703(var0, var1, var2);
      } else if(var0 < 4000) {
         return class10.method59(var0, var1, var2);
      } else if(var0 < 4100) {
         return Renderable.method2758(var0, var1, var2);
      } else {
         boolean var19;
         int var20;
         String var40;
         String var45;
         int var48;
         int[] var59;
         if(var0 < 4200) {
            if(var0 == 4100) {
               var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
               var24 = class83.intStack[--class83.intStackSize];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var45 + var24;
               var3 = 1;
            } else if(var0 == 4101) {
               class24.scriptStringStackSize -= 2;
               var45 = class83.scriptStringStack[class24.scriptStringStackSize];
               var40 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var45 + var40;
               var3 = 1;
            } else if(var0 == 4102) {
               var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
               var24 = class83.intStack[--class83.intStackSize];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var45 + ItemLayer.method2308(var24, true);
               var3 = 1;
            } else if(var0 == 4103) {
               var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var45.toLowerCase();
               var3 = 1;
            } else if(var0 == 4104) {
               var4 = class83.intStack[--class83.intStackSize];
               long var17 = 86400000L * (11745L + (long)var4);
               class83.field1328.setTime(new Date(var17));
               var48 = class83.field1328.get(5);
               var20 = class83.field1328.get(2);
               var9 = class83.field1328.get(1);
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var48 + "-" + class83.field1335[var20] + "-" + var9;
               var3 = 1;
            } else if(var0 == 4105) {
               class24.scriptStringStackSize -= 2;
               var45 = class83.scriptStringStack[class24.scriptStringStackSize];
               var40 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
               if(class20.localPlayer.composition != null && class20.localPlayer.composition.isFemale) {
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var40;
               } else {
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var45;
               }

               var3 = 1;
            } else if(var0 == 4106) {
               var4 = class83.intStack[--class83.intStackSize];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = Integer.toString(var4);
               var3 = 1;
            } else if(var0 == 4107) {
               class24.scriptStringStackSize -= 2;
               int[] var66 = class83.intStack;
               var24 = ++class83.intStackSize - 1;
               var48 = class205.method3705(class83.scriptStringStack[class24.scriptStringStackSize], class83.scriptStringStack[class24.scriptStringStackSize + 1], Client.field1120);
               byte var30;
               if(var48 > 0) {
                  var30 = 1;
               } else if(var48 < 0) {
                  var30 = -1;
               } else {
                  var30 = 0;
               }

               var66[var24] = var30;
               var3 = 1;
            } else {
               byte[] var27;
               Font var32;
               if(var0 == 4108) {
                  var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class83.intStackSize -= 2;
                  var24 = class83.intStack[class83.intStackSize];
                  var6 = class83.intStack[class83.intStackSize + 1];
                  var27 = class33.field476.getConfigData(var6, 0);
                  var32 = new Font(var27);
                  class83.intStack[++class83.intStackSize - 1] = var32.method4630(var45, var24);
                  var3 = 1;
               } else if(var0 == 4109) {
                  var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class83.intStackSize -= 2;
                  var24 = class83.intStack[class83.intStackSize];
                  var6 = class83.intStack[class83.intStackSize + 1];
                  var27 = class33.field476.getConfigData(var6, 0);
                  var32 = new Font(var27);
                  class83.intStack[++class83.intStackSize - 1] = var32.method4629(var45, var24);
                  var3 = 1;
               } else if(var0 == 4110) {
                  class24.scriptStringStackSize -= 2;
                  var45 = class83.scriptStringStack[class24.scriptStringStackSize];
                  var40 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
                  if(class83.intStack[--class83.intStackSize] == 1) {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var45;
                  } else {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var40;
                  }

                  var3 = 1;
               } else if(var0 == 4111) {
                  var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = FontTypeFace.method4631(var45);
                  var3 = 1;
               } else if(var0 == 4112) {
                  var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  var24 = class83.intStack[--class83.intStackSize];
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var45 + (char)var24;
                  var3 = 1;
               } else {
                  char var61;
                  if(var0 == 4113) {
                     var4 = class83.intStack[--class83.intStackSize];
                     var59 = class83.intStack;
                     var6 = ++class83.intStackSize - 1;
                     var61 = (char)var4;
                     if(var61 >= 32 && var61 <= 126) {
                        var19 = true;
                     } else if(var61 >= 160 && var61 <= 255) {
                        var19 = true;
                     } else if(var61 != 8364 && var61 != 338 && var61 != 8212 && var61 != 339 && var61 != 376) {
                        var19 = false;
                     } else {
                        var19 = true;
                     }

                     var59[var6] = var19?1:0;
                     var3 = 1;
                  } else if(var0 == 4114) {
                     var4 = class83.intStack[--class83.intStackSize];
                     var59 = class83.intStack;
                     var6 = ++class83.intStackSize - 1;
                     var61 = (char)var4;
                     var19 = var61 >= 48 && var61 <= 57 || var61 >= 65 && var61 <= 90 || var61 >= 97 && var61 <= 122;
                     var59[var6] = var19?1:0;
                     var3 = 1;
                  } else if(var0 == 4115) {
                     var4 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = class157.method2865((char)var4)?1:0;
                     var3 = 1;
                  } else if(var0 == 4116) {
                     var4 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = WallObject.method2761((char)var4)?1:0;
                     var3 = 1;
                  } else if(var0 == 4117) {
                     var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                     if(var45 != null) {
                        class83.intStack[++class83.intStackSize - 1] = var45.length();
                     } else {
                        class83.intStack[++class83.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 4118) {
                     var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                     class83.intStackSize -= 2;
                     var24 = class83.intStack[class83.intStackSize];
                     var6 = class83.intStack[class83.intStackSize + 1];
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var45.substring(var24, var6);
                     var3 = 1;
                  } else if(var0 == 4119) {
                     var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                     StringBuilder var62 = new StringBuilder(var45.length());
                     boolean var37 = false;

                     for(var48 = 0; var48 < var45.length(); ++var48) {
                        var61 = var45.charAt(var48);
                        if(var61 == 60) {
                           var37 = true;
                        } else if(var61 == 62) {
                           var37 = false;
                        } else if(!var37) {
                           var62.append(var61);
                        }
                     }

                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var62.toString();
                     var3 = 1;
                  } else if(var0 == 4120) {
                     var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                     var24 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = var45.indexOf(var24);
                     var3 = 1;
                  } else if(var0 == 4121) {
                     class24.scriptStringStackSize -= 2;
                     var45 = class83.scriptStringStack[class24.scriptStringStackSize];
                     var40 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
                     var6 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = var45.indexOf(var40, var6);
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }
               }
            }

            return var3;
         } else {
            String var49;
            if(var0 < 4300) {
               if(var0 == 4200) {
                  var4 = class83.intStack[--class83.intStackSize];
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class224.getItemDefinition(var4).name;
                  var3 = 1;
               } else {
                  ItemComposition var50;
                  if(var0 == 4201) {
                     class83.intStackSize -= 2;
                     var4 = class83.intStack[class83.intStackSize];
                     var24 = class83.intStack[class83.intStackSize + 1];
                     var50 = class224.getItemDefinition(var4);
                     if(var24 >= 1 && var24 <= 5 && var50.groundActions[var24 - 1] != null) {
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var50.groundActions[var24 - 1];
                     } else {
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     }

                     var3 = 1;
                  } else if(var0 == 4202) {
                     class83.intStackSize -= 2;
                     var4 = class83.intStack[class83.intStackSize];
                     var24 = class83.intStack[class83.intStackSize + 1];
                     var50 = class224.getItemDefinition(var4);
                     if(var24 >= 1 && var24 <= 5 && var50.inventoryActions[var24 - 1] != null) {
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var50.inventoryActions[var24 - 1];
                     } else {
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     }

                     var3 = 1;
                  } else if(var0 == 4203) {
                     var4 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = class224.getItemDefinition(var4).price;
                     var3 = 1;
                  } else if(var0 == 4204) {
                     var4 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = class224.getItemDefinition(var4).isStackable == 1?1:0;
                     var3 = 1;
                  } else {
                     ItemComposition var60;
                     if(var0 == 4205) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var60 = class224.getItemDefinition(var4);
                        if(var60.notedTemplate == -1 && var60.note >= 0) {
                           class83.intStack[++class83.intStackSize - 1] = var60.note;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4206) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var60 = class224.getItemDefinition(var4);
                        if(var60.notedTemplate >= 0 && var60.note >= 0) {
                           class83.intStack[++class83.intStackSize - 1] = var60.note;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4207) {
                        var4 = class83.intStack[--class83.intStackSize];
                        class83.intStack[++class83.intStackSize - 1] = class224.getItemDefinition(var4).isMembers?1:0;
                        var3 = 1;
                     } else if(var0 == 4208) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var60 = class224.getItemDefinition(var4);
                        if(var60.field3546 == -1 && var60.field3545 >= 0) {
                           class83.intStack[++class83.intStackSize - 1] = var60.field3545;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4209) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var60 = class224.getItemDefinition(var4);
                        if(var60.field3546 >= 0 && var60.field3545 >= 0) {
                           class83.intStack[++class83.intStackSize - 1] = var60.field3545;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4210) {
                        var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                        var24 = class83.intStack[--class83.intStackSize];
                        var19 = var24 == 1;
                        var49 = var45.toLowerCase();
                        short[] var31 = new short[16];
                        var9 = 0;
                        int var10 = 0;

                        while(true) {
                           if(var10 >= class181.field2449) {
                              class269.field3681 = var31;
                              class40.field549 = 0;
                              class5.field44 = var9;
                              String[] var57 = new String[class5.field44];

                              for(int var22 = 0; var22 < class5.field44; ++var22) {
                                 var57[var22] = class224.getItemDefinition(var31[var22]).name;
                              }

                              short[] var38 = class269.field3681;
                              class19.method162(var57, var38, 0, var57.length - 1);
                              break;
                           }

                           ItemComposition var36 = class224.getItemDefinition(var10);
                           if((!var19 || var36.field3513) && var36.notedTemplate == -1 && var36.name.toLowerCase().indexOf(var49) != -1) {
                              if(var9 >= 250) {
                                 class5.field44 = -1;
                                 class269.field3681 = null;
                                 break;
                              }

                              if(var9 >= var31.length) {
                                 short[] var12 = new short[var31.length * 2];

                                 for(int var13 = 0; var13 < var9; ++var13) {
                                    var12[var13] = var31[var13];
                                 }

                                 var31 = var12;
                              }

                              var31[var9++] = (short)var10;
                           }

                           ++var10;
                        }

                        class83.intStack[++class83.intStackSize - 1] = class5.field44;
                        var3 = 1;
                     } else if(var0 == 4211) {
                        if(class269.field3681 != null && class40.field549 < class5.field44) {
                           class83.intStack[++class83.intStackSize - 1] = class269.field3681[++class40.field549 - 1] & '\uffff';
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = -1;
                        }

                        var3 = 1;
                     } else if(var0 == 4212) {
                        class40.field549 = 0;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }
                  }
               }

               return var3;
            } else if(var0 < 5100) {
               if(var0 == 5000) {
                  class83.intStack[++class83.intStackSize - 1] = Client.field954;
                  var3 = 1;
               } else if(var0 == 5001) {
                  class83.intStackSize -= 3;
                  Client.field954 = class83.intStack[class83.intStackSize];
                  Item.field1480 = Player.method1095(class83.intStack[class83.intStackSize + 1]);
                  if(Item.field1480 == null) {
                     Item.field1480 = class276.field3734;
                  }

                  Client.field1123 = class83.intStack[class83.intStackSize + 2];
                  Client.secretPacketBuffer1.putOpcode(225);
                  Client.secretPacketBuffer1.putByte(Client.field954);
                  Client.secretPacketBuffer1.putByte(Item.field1480.field3735);
                  Client.secretPacketBuffer1.putByte(Client.field1123);
                  var3 = 1;
               } else if(var0 == 5002) {
                  var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class83.intStackSize -= 2;
                  var24 = class83.intStack[class83.intStackSize];
                  var6 = class83.intStack[class83.intStackSize + 1];
                  Client.secretPacketBuffer1.putOpcode(180);
                  Client.secretPacketBuffer1.putByte(Friend.method1023(var45) + 2);
                  Client.secretPacketBuffer1.method3125(var45);
                  Client.secretPacketBuffer1.putByte(var24 - 1);
                  Client.secretPacketBuffer1.putByte(var6);
                  var3 = 1;
               } else if(var0 == 5003) {
                  class83.intStackSize -= 2;
                  var4 = class83.intStack[class83.intStackSize];
                  var24 = class83.intStack[class83.intStackSize + 1];
                  ChatLineBuffer var26 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var4));
                  MessageNode var47 = var26.method1765(var24);
                  if(var47 != null) {
                     class83.intStack[++class83.intStackSize - 1] = var47.id;
                     class83.intStack[++class83.intStackSize - 1] = var47.tick;
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var47.name != null?var47.name:"";
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var47.sender != null?var47.sender:"";
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var47.value != null?var47.value:"";
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 5004) {
                  var4 = class83.intStack[--class83.intStackSize];
                  MessageNode var58 = class9.method50(var4);
                  if(var58 != null) {
                     class83.intStack[++class83.intStackSize - 1] = var58.type;
                     class83.intStack[++class83.intStackSize - 1] = var58.tick;
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var58.name != null?var58.name:"";
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var58.sender != null?var58.sender:"";
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var58.value != null?var58.value:"";
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 5005) {
                  if(Item.field1480 == null) {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = Item.field1480.field3735;
                  }

                  var3 = 1;
               } else if(var0 == 5008) {
                  var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  var24 = class83.intStack[--class83.intStackSize];
                  var49 = var45.toLowerCase();
                  byte var52 = 0;
                  if(var49.startsWith("yellow:")) {
                     var52 = 0;
                     var45 = var45.substring("yellow:".length());
                  } else if(var49.startsWith("red:")) {
                     var52 = 1;
                     var45 = var45.substring("red:".length());
                  } else if(var49.startsWith("green:")) {
                     var52 = 2;
                     var45 = var45.substring("green:".length());
                  } else if(var49.startsWith("cyan:")) {
                     var52 = 3;
                     var45 = var45.substring("cyan:".length());
                  } else if(var49.startsWith("purple:")) {
                     var52 = 4;
                     var45 = var45.substring("purple:".length());
                  } else if(var49.startsWith("white:")) {
                     var52 = 5;
                     var45 = var45.substring("white:".length());
                  } else if(var49.startsWith("flash1:")) {
                     var52 = 6;
                     var45 = var45.substring("flash1:".length());
                  } else if(var49.startsWith("flash2:")) {
                     var52 = 7;
                     var45 = var45.substring("flash2:".length());
                  } else if(var49.startsWith("flash3:")) {
                     var52 = 8;
                     var45 = var45.substring("flash3:".length());
                  } else if(var49.startsWith("glow1:")) {
                     var52 = 9;
                     var45 = var45.substring("glow1:".length());
                  } else if(var49.startsWith("glow2:")) {
                     var52 = 10;
                     var45 = var45.substring("glow2:".length());
                  } else if(var49.startsWith("glow3:")) {
                     var52 = 11;
                     var45 = var45.substring("glow3:".length());
                  } else if(Client.field1120 != 0) {
                     if(var49.startsWith("yellow:")) {
                        var52 = 0;
                        var45 = var45.substring("yellow:".length());
                     } else if(var49.startsWith("red:")) {
                        var52 = 1;
                        var45 = var45.substring("red:".length());
                     } else if(var49.startsWith("green:")) {
                        var52 = 2;
                        var45 = var45.substring("green:".length());
                     } else if(var49.startsWith("cyan:")) {
                        var52 = 3;
                        var45 = var45.substring("cyan:".length());
                     } else if(var49.startsWith("purple:")) {
                        var52 = 4;
                        var45 = var45.substring("purple:".length());
                     } else if(var49.startsWith("white:")) {
                        var52 = 5;
                        var45 = var45.substring("white:".length());
                     } else if(var49.startsWith("flash1:")) {
                        var52 = 6;
                        var45 = var45.substring("flash1:".length());
                     } else if(var49.startsWith("flash2:")) {
                        var52 = 7;
                        var45 = var45.substring("flash2:".length());
                     } else if(var49.startsWith("flash3:")) {
                        var52 = 8;
                        var45 = var45.substring("flash3:".length());
                     } else if(var49.startsWith("glow1:")) {
                        var52 = 9;
                        var45 = var45.substring("glow1:".length());
                     } else if(var49.startsWith("glow2:")) {
                        var52 = 10;
                        var45 = var45.substring("glow2:".length());
                     } else if(var49.startsWith("glow3:")) {
                        var52 = 11;
                        var45 = var45.substring("glow3:".length());
                     }
                  }

                  var49 = var45.toLowerCase();
                  byte var54 = 0;
                  if(var49.startsWith("wave:")) {
                     var54 = 1;
                     var45 = var45.substring("wave:".length());
                  } else if(var49.startsWith("wave2:")) {
                     var54 = 2;
                     var45 = var45.substring("wave2:".length());
                  } else if(var49.startsWith("shake:")) {
                     var54 = 3;
                     var45 = var45.substring("shake:".length());
                  } else if(var49.startsWith("scroll:")) {
                     var54 = 4;
                     var45 = var45.substring("scroll:".length());
                  } else if(var49.startsWith("slide:")) {
                     var54 = 5;
                     var45 = var45.substring("slide:".length());
                  } else if(Client.field1120 != 0) {
                     if(var49.startsWith("wave:")) {
                        var54 = 1;
                        var45 = var45.substring("wave:".length());
                     } else if(var49.startsWith("wave2:")) {
                        var54 = 2;
                        var45 = var45.substring("wave2:".length());
                     } else if(var49.startsWith("shake:")) {
                        var54 = 3;
                        var45 = var45.substring("shake:".length());
                     } else if(var49.startsWith("scroll:")) {
                        var54 = 4;
                        var45 = var45.substring("scroll:".length());
                     } else if(var49.startsWith("slide:")) {
                        var54 = 5;
                        var45 = var45.substring("slide:".length());
                     }
                  }

                  Client.secretPacketBuffer1.putOpcode(91);
                  Client.secretPacketBuffer1.putByte(0);
                  var9 = Client.secretPacketBuffer1.offset;
                  Client.secretPacketBuffer1.putByte(var24);
                  Client.secretPacketBuffer1.putByte(var52);
                  Client.secretPacketBuffer1.putByte(var54);
                  class208.method3796(Client.secretPacketBuffer1, var45);
                  Client.secretPacketBuffer1.method3030(Client.secretPacketBuffer1.offset - var9);
                  var3 = 1;
               } else if(var0 == 5009) {
                  class24.scriptStringStackSize -= 2;
                  var45 = class83.scriptStringStack[class24.scriptStringStackSize];
                  var40 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
                  Client.secretPacketBuffer1.putOpcode(170);
                  Client.secretPacketBuffer1.putShort(0);
                  var6 = Client.secretPacketBuffer1.offset;
                  Client.secretPacketBuffer1.method3125(var45);
                  class208.method3796(Client.secretPacketBuffer1, var40);
                  Client.secretPacketBuffer1.method3156(Client.secretPacketBuffer1.offset - var6);
                  var3 = 1;
               } else if(var0 == 5015) {
                  if(class20.localPlayer != null && class20.localPlayer.name != null) {
                     var45 = class20.localPlayer.name;
                  } else {
                     var45 = "";
                  }

                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var45;
                  var3 = 1;
               } else if(var0 == 5016) {
                  class83.intStack[++class83.intStackSize - 1] = Client.field1123;
                  var3 = 1;
               } else if(var0 == 5017) {
                  var4 = class83.intStack[--class83.intStackSize];
                  var59 = class83.intStack;
                  var6 = ++class83.intStackSize - 1;
                  ChatLineBuffer var8 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var4));
                  if(var8 == null) {
                     var48 = 0;
                  } else {
                     var48 = var8.method1766();
                  }

                  var59[var6] = var48;
                  var3 = 1;
               } else if(var0 == 5018) {
                  var4 = class83.intStack[--class83.intStackSize];
                  var59 = class83.intStack;
                  var6 = ++class83.intStackSize - 1;
                  MessageNode var28 = (MessageNode)class98.field1517.method3389((long)var4);
                  if(var28 == null) {
                     var48 = -1;
                  } else if(var28.previous == class98.field1523.field2501) {
                     var48 = -1;
                  } else {
                     var48 = ((MessageNode)var28.previous).id;
                  }

                  var59[var6] = var48;
                  var3 = 1;
               } else if(var0 == 5019) {
                  var4 = class83.intStack[--class83.intStackSize];
                  class83.intStack[++class83.intStackSize - 1] = PacketBuffer.method3287(var4);
                  var3 = 1;
               } else if(var0 == 5020) {
                  var45 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  if(var45.equalsIgnoreCase("toggleroof")) {
                     Item.field1481.field1299 = !Item.field1481.field1299;
                     class5.method16();
                     if(Item.field1481.field1299) {
                        class5.sendGameMessage(99, "", "Roofs are now all hidden");
                     } else {
                        class5.sendGameMessage(99, "", "Roofs will only be removed selectively");
                     }
                  }

                  if(var45.equalsIgnoreCase("displayfps")) {
                     Client.field918 = !Client.field918;
                  }

                  if(var45.equalsIgnoreCase("clickbox")) {
                     Model.field1925 = !Model.field1925;
                     class5.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1925?"AABB":"Legacy"));
                  }

                  if(Client.rights >= 2) {
                     if(var45.equalsIgnoreCase("aabb")) {
                        if(!class7.field238) {
                           class7.field238 = true;
                           class7.field233 = class11.field270;
                           class5.sendGameMessage(99, "", "AABB boxes: All");
                        } else if(class7.field233 == class11.field270) {
                           class7.field238 = true;
                           class7.field233 = class11.field274;
                           class5.sendGameMessage(99, "", "AABB boxes: Mouse Over");
                        } else {
                           class7.field238 = false;
                           class5.sendGameMessage(99, "", "AABB boxes: Off");
                        }
                     }

                     if(var45.equalsIgnoreCase("legacyboxes")) {
                        class7.field234 = !class7.field234;
                        class5.sendGameMessage(99, "", "Show legacy boxes: " + class7.field234);
                     }

                     if(var45.equalsIgnoreCase("geotests")) {
                        class7.field235 = !class7.field235;
                        class5.sendGameMessage(99, "", "Show geometry tests: " + class7.field235);
                     }

                     if(var45.equalsIgnoreCase("fpson")) {
                        Client.field918 = true;
                     }

                     if(var45.equalsIgnoreCase("fpsoff")) {
                        Client.field918 = false;
                     }

                     if(var45.equalsIgnoreCase("gc")) {
                        System.gc();
                     }

                     if(var45.equalsIgnoreCase("clientdrop")) {
                        if(Client.field957 > 0) {
                           TextureProvider.method2306();
                        } else {
                           class23.setGameState(40);
                           class222.field2846 = WidgetNode.rssocket;
                           WidgetNode.rssocket = null;
                        }
                     }

                     if(var45.equalsIgnoreCase("errortest") && Client.field1161 == 2) {
                        throw new RuntimeException();
                     }
                  }

                  Client.secretPacketBuffer1.putOpcode(146);
                  Client.secretPacketBuffer1.putByte(var45.length() + 1);
                  Client.secretPacketBuffer1.method3125(var45);
                  var3 = 1;
               } else if(var0 == 5021) {
                  Client.field1124 = class83.scriptStringStack[--class24.scriptStringStackSize].toLowerCase().trim();
                  var3 = 1;
               } else if(var0 == 5022) {
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.field1124;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 5400) {
               if(var0 == 5306) {
                  class83.intStack[++class83.intStackSize - 1] = class241.method4167();
                  var3 = 1;
               } else if(var0 == 5307) {
                  var4 = class83.intStack[--class83.intStackSize];
                  if(var4 == 1 || var4 == 2) {
                     WorldMapType2.method508(var4);
                  }

                  var3 = 1;
               } else if(var0 == 5308) {
                  class83.intStack[++class83.intStackSize - 1] = Item.field1481.field1303;
                  var3 = 1;
               } else if(var0 == 5309) {
                  var4 = class83.intStack[--class83.intStackSize];
                  if(var4 == 1 || var4 == 2) {
                     Item.field1481.field1303 = var4;
                     class5.method16();
                  }

                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 5600) {
               if(var0 == 5504) {
                  class83.intStackSize -= 2;
                  var48 = class83.intStack[class83.intStackSize];
                  var20 = class83.intStack[class83.intStackSize + 1];
                  if(!Client.field1152) {
                     Client.field1159 = var48;
                     Client.mapAngle = var20;
                  }

                  var3 = 1;
               } else if(var0 == 5505) {
                  class83.intStack[++class83.intStackSize - 1] = Client.field1159;
                  var3 = 1;
               } else if(var0 == 5506) {
                  class83.intStack[++class83.intStackSize - 1] = Client.mapAngle;
                  var3 = 1;
               } else if(var0 == 5530) {
                  var48 = class83.intStack[--class83.intStackSize];
                  if(var48 < 0) {
                     var48 = 0;
                  }

                  Client.field995 = var48;
                  var3 = 1;
               } else if(var0 == 5531) {
                  class83.intStack[++class83.intStackSize - 1] = Client.field995;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 5700) {
               return class11.method60(var0, var1, var2);
            } else if(var0 < 6300) {
               if(var0 == 6200) {
                  class83.intStackSize -= 2;
                  Client.field988 = (short)class83.intStack[class83.intStackSize];
                  if(Client.field988 <= 0) {
                     Client.field988 = 256;
                  }

                  Client.field1147 = (short)class83.intStack[class83.intStackSize + 1];
                  if(Client.field1147 <= 0) {
                     Client.field1147 = 205;
                  }

                  var3 = 1;
               } else if(var0 == 6201) {
                  class83.intStackSize -= 2;
                  Client.field1160 = (short)class83.intStack[class83.intStackSize];
                  if(Client.field1160 <= 0) {
                     Client.field1160 = 256;
                  }

                  Client.field904 = (short)class83.intStack[class83.intStackSize + 1];
                  if(Client.field904 <= 0) {
                     Client.field904 = 320;
                  }

                  var3 = 1;
               } else if(var0 == 6202) {
                  class83.intStackSize -= 4;
                  Client.field1162 = (short)class83.intStack[class83.intStackSize];
                  if(Client.field1162 <= 0) {
                     Client.field1162 = 1;
                  }

                  Client.field1163 = (short)class83.intStack[class83.intStackSize + 1];
                  if(Client.field1163 <= 0) {
                     Client.field1163 = 32767;
                  } else if(Client.field1163 < Client.field1162) {
                     Client.field1163 = Client.field1162;
                  }

                  Client.field1164 = (short)class83.intStack[class83.intStackSize + 2];
                  if(Client.field1164 <= 0) {
                     Client.field1164 = 1;
                  }

                  Client.field1165 = (short)class83.intStack[class83.intStackSize + 3];
                  if(Client.field1165 <= 0) {
                     Client.field1165 = 32767;
                  } else if(Client.field1165 < Client.field1164) {
                     Client.field1165 = Client.field1164;
                  }

                  var3 = 1;
               } else if(var0 == 6203) {
                  if(Client.field1078 != null) {
                     Player.method1069(0, 0, Client.field1078.width, Client.field1078.height, false);
                     class83.intStack[++class83.intStackSize - 1] = Client.viewportHeight;
                     class83.intStack[++class83.intStackSize - 1] = Client.viewportWidth;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     class83.intStack[++class83.intStackSize - 1] = -1;
                  }

                  var3 = 1;
               } else if(var0 == 6204) {
                  class83.intStack[++class83.intStackSize - 1] = Client.field1160;
                  class83.intStack[++class83.intStackSize - 1] = Client.field904;
                  var3 = 1;
               } else if(var0 == 6205) {
                  class83.intStack[++class83.intStackSize - 1] = Client.field988;
                  class83.intStack[++class83.intStackSize - 1] = Client.field1147;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else {
               boolean var5;
               if(var0 >= 6600) {
                  if(var0 < 6700) {
                     if(var0 == 6600) {
                        var4 = Player.plane;
                        var24 = class19.baseX + (class20.localPlayer.x >> 7);
                        var6 = class21.baseY + (class20.localPlayer.y >> 7);
                        WidgetNode.method1030().method5168(var4, var24, var6, true);
                        var3 = 1;
                     } else {
                        WorldMapData var41;
                        if(var0 == 6601) {
                           var4 = class83.intStack[--class83.intStackSize];
                           var40 = "";
                           var41 = WidgetNode.method1030().method5151(var4);
                           if(var41 != null) {
                              var40 = var41.method338();
                           }

                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var40;
                           var3 = 1;
                        } else if(var0 == 6602) {
                           var4 = class83.intStack[--class83.intStackSize];
                           WidgetNode.method1030().method5053(var4);
                           var3 = 1;
                        } else if(var0 == 6603) {
                           class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5065();
                           var3 = 1;
                        } else if(var0 == 6604) {
                           var4 = class83.intStack[--class83.intStackSize];
                           WidgetNode.method1030().method5062(var4);
                           var3 = 1;
                        } else if(var0 == 6605) {
                           class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5067()?1:0;
                           var3 = 1;
                        } else {
                           Coordinates var39;
                           if(var0 == 6606) {
                              var39 = new Coordinates(class83.intStack[--class83.intStackSize]);
                              WidgetNode.method1030().method5069(var39.worldX, var39.worldY);
                              var3 = 1;
                           } else if(var0 == 6607) {
                              var39 = new Coordinates(class83.intStack[--class83.intStackSize]);
                              WidgetNode.method1030().method5213(var39.worldX, var39.worldY);
                              var3 = 1;
                           } else if(var0 == 6608) {
                              var39 = new Coordinates(class83.intStack[--class83.intStackSize]);
                              WidgetNode.method1030().method5182(var39.plane, var39.worldX, var39.worldY);
                              var3 = 1;
                           } else if(var0 == 6609) {
                              var39 = new Coordinates(class83.intStack[--class83.intStackSize]);
                              WidgetNode.method1030().method5072(var39.plane, var39.worldX, var39.worldY);
                              var3 = 1;
                           } else if(var0 == 6610) {
                              class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5073();
                              class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5074();
                              var3 = 1;
                           } else {
                              WorldMapData var46;
                              if(var0 == 6611) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 var46 = WidgetNode.method1030().method5151(var4);
                                 if(var46 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var46.method300().method3825();
                                 }

                                 var3 = 1;
                              } else if(var0 == 6612) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 var46 = WidgetNode.method1030().method5151(var4);
                                 if(var46 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = (var46.method294() - var46.method293() + 1) * 64;
                                    class83.intStack[++class83.intStackSize - 1] = (var46.method296() - var46.method305() + 1) * 64;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6613) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 var46 = WidgetNode.method1030().method5151(var4);
                                 if(var46 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var46.method293() * 64;
                                    class83.intStack[++class83.intStackSize - 1] = var46.method305() * 64;
                                    class83.intStack[++class83.intStackSize - 1] = var46.method294() * 64 + 64 - 1;
                                    class83.intStack[++class83.intStackSize - 1] = var46.method296() * 64 + 64 - 1;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6614) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 var46 = WidgetNode.method1030().method5151(var4);
                                 if(var46 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var46.method314();
                                 }

                                 var3 = 1;
                              } else if(var0 == 6615) {
                                 var39 = WidgetNode.method1030().method5075();
                                 if(var39 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var39.worldX;
                                    class83.intStack[++class83.intStackSize - 1] = var39.worldY;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6616) {
                                 class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5076();
                                 var3 = 1;
                              } else if(var0 == 6617) {
                                 var39 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                 var46 = WidgetNode.method1030().method5055();
                                 if(var46 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                    var3 = 1;
                                 } else {
                                    int[] var42 = var46.method346(var39.plane, var39.worldX, var39.worldY);
                                    if(var42 == null) {
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = var42[0];
                                       class83.intStack[++class83.intStackSize - 1] = var42[1];
                                    }

                                    var3 = 1;
                                 }
                              } else {
                                 Coordinates var44;
                                 if(var0 == 6618) {
                                    var39 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                    var46 = WidgetNode.method1030().method5055();
                                    if(var46 == null) {
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                       var3 = 1;
                                    } else {
                                       var44 = var46.method317(var39.worldX, var39.worldY);
                                       if(var44 == null) {
                                          class83.intStack[++class83.intStackSize - 1] = -1;
                                       } else {
                                          class83.intStack[++class83.intStackSize - 1] = var44.method3825();
                                       }

                                       var3 = 1;
                                    }
                                 } else {
                                    Coordinates var51;
                                    if(var0 == 6619) {
                                       class83.intStackSize -= 2;
                                       var4 = class83.intStack[class83.intStackSize];
                                       var51 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                       var41 = WidgetNode.method1030().method5151(var4);
                                       var48 = class20.localPlayer.field884;
                                       var20 = (class20.localPlayer.x >> 7) + class19.baseX;
                                       var9 = class21.baseY + (class20.localPlayer.y >> 7);
                                       Coordinates var56 = new Coordinates(var48, var20, var9);
                                       WidgetNode.method1030().method5207(var41, var56, var51, false);
                                       var3 = 1;
                                    } else if(var0 == 6620) {
                                       class83.intStackSize -= 2;
                                       var4 = class83.intStack[class83.intStackSize];
                                       var51 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                       class240.method4157(var4, var51, true);
                                       var3 = 1;
                                    } else if(var0 == 6621) {
                                       class83.intStackSize -= 2;
                                       var4 = class83.intStack[class83.intStackSize];
                                       var51 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                       var41 = WidgetNode.method1030().method5151(var4);
                                       if(var41 == null) {
                                          class83.intStack[++class83.intStackSize - 1] = 0;
                                          var3 = 1;
                                       } else {
                                          class83.intStack[++class83.intStackSize - 1] = var41.method282(var51.plane, var51.worldX, var51.worldY)?1:0;
                                          var3 = 1;
                                       }
                                    } else if(var0 == 6622) {
                                       class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5107();
                                       class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5144();
                                       var3 = 1;
                                    } else if(var0 == 6623) {
                                       var39 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                       var46 = WidgetNode.method1030().method5051(var39.plane, var39.worldX, var39.worldY);
                                       if(var46 == null) {
                                          class83.intStack[++class83.intStackSize - 1] = -1;
                                       } else {
                                          class83.intStack[++class83.intStackSize - 1] = var46.method287();
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6624) {
                                       WidgetNode.method1030().method5078(class83.intStack[--class83.intStackSize]);
                                       var3 = 1;
                                    } else if(var0 == 6625) {
                                       WidgetNode.method1030().method5080();
                                       var3 = 1;
                                    } else if(var0 == 6626) {
                                       WidgetNode.method1030().method5147(class83.intStack[--class83.intStackSize]);
                                       var3 = 1;
                                    } else if(var0 == 6627) {
                                       WidgetNode.method1030().method5081();
                                       var3 = 1;
                                    } else {
                                       boolean var33;
                                       if(var0 == 6628) {
                                          var33 = class83.intStack[--class83.intStackSize] == 1;
                                          WidgetNode.method1030().method5082(var33);
                                          var3 = 1;
                                       } else if(var0 == 6629) {
                                          var4 = class83.intStack[--class83.intStackSize];
                                          WidgetNode.method1030().method5083(var4);
                                          var3 = 1;
                                       } else if(var0 == 6630) {
                                          var4 = class83.intStack[--class83.intStackSize];
                                          WidgetNode.method1030().method5084(var4);
                                          var3 = 1;
                                       } else if(var0 == 6631) {
                                          WidgetNode.method1030().method5085();
                                          var3 = 1;
                                       } else if(var0 == 6632) {
                                          var33 = class83.intStack[--class83.intStackSize] == 1;
                                          WidgetNode.method1030().method5086(var33);
                                          var3 = 1;
                                       } else if(var0 == 6633) {
                                          class83.intStackSize -= 2;
                                          var4 = class83.intStack[class83.intStackSize];
                                          var5 = class83.intStack[class83.intStackSize + 1] == 1;
                                          WidgetNode.method1030().method5087(var4, var5);
                                          var3 = 1;
                                       } else if(var0 == 6634) {
                                          class83.intStackSize -= 2;
                                          var4 = class83.intStack[class83.intStackSize];
                                          var5 = class83.intStack[class83.intStackSize + 1] == 1;
                                          WidgetNode.method1030().method5088(var4, var5);
                                          var3 = 1;
                                       } else if(var0 == 6635) {
                                          class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5089()?1:0;
                                          var3 = 1;
                                       } else if(var0 == 6636) {
                                          var4 = class83.intStack[--class83.intStackSize];
                                          class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5113(var4)?1:0;
                                          var3 = 1;
                                       } else if(var0 == 6637) {
                                          var4 = class83.intStack[--class83.intStackSize];
                                          class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5091(var4)?1:0;
                                          var3 = 1;
                                       } else if(var0 == 6638) {
                                          class83.intStackSize -= 2;
                                          var4 = class83.intStack[class83.intStackSize];
                                          var51 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                          var44 = WidgetNode.method1030().method5094(var4, var51);
                                          if(var44 == null) {
                                             class83.intStack[++class83.intStackSize - 1] = -1;
                                          } else {
                                             class83.intStack[++class83.intStackSize - 1] = var44.method3825();
                                          }

                                          var3 = 1;
                                       } else {
                                          class39 var43;
                                          if(var0 == 6639) {
                                             var43 = WidgetNode.method1030().method5114();
                                             if(var43 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                             } else {
                                                class83.intStack[++class83.intStackSize - 1] = var43.field541;
                                                class83.intStack[++class83.intStackSize - 1] = var43.field538.method3825();
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6640) {
                                             var43 = WidgetNode.method1030().method5052();
                                             if(var43 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                             } else {
                                                class83.intStack[++class83.intStackSize - 1] = var43.field541;
                                                class83.intStack[++class83.intStackSize - 1] = var43.field538.method3825();
                                             }

                                             var3 = 1;
                                          } else {
                                             Area var55;
                                             if(var0 == 6693) {
                                                var4 = class83.intStack[--class83.intStackSize];
                                                var55 = Area.field3304[var4];
                                                if(var55.name == null) {
                                                   class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                                } else {
                                                   class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var55.name;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6694) {
                                                var4 = class83.intStack[--class83.intStackSize];
                                                var55 = Area.field3304[var4];
                                                class83.intStack[++class83.intStackSize - 1] = var55.field3315;
                                                var3 = 1;
                                             } else if(var0 == 6695) {
                                                var4 = class83.intStack[--class83.intStackSize];
                                                var55 = Area.field3304[var4];
                                                if(var55 == null) {
                                                   class83.intStack[++class83.intStackSize - 1] = -1;
                                                } else {
                                                   class83.intStack[++class83.intStackSize - 1] = var55.field3306;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6696) {
                                                var4 = class83.intStack[--class83.intStackSize];
                                                var55 = Area.field3304[var4];
                                                if(var55 == null) {
                                                   class83.intStack[++class83.intStackSize - 1] = -1;
                                                } else {
                                                   class83.intStack[++class83.intStackSize - 1] = var55.spriteId;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6697) {
                                                class83.intStack[++class83.intStackSize - 1] = class175.field2423.field612;
                                                var3 = 1;
                                             } else if(var0 == 6698) {
                                                class83.intStack[++class83.intStackSize - 1] = class175.field2423.field608.method3825();
                                                var3 = 1;
                                             } else if(var0 == 6699) {
                                                class83.intStack[++class83.intStackSize - 1] = class175.field2423.field607.method3825();
                                                var3 = 1;
                                             } else {
                                                var3 = 2;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }

                     return var3;
                  } else {
                     return 2;
                  }
               } else {
                  if(var0 == 6500) {
                     class83.intStack[++class83.intStackSize - 1] = class17.loadWorlds()?1:0;
                     var3 = 1;
                  } else {
                     World var15;
                     if(var0 == 6501) {
                        World.field1293 = 0;
                        if(World.field1293 < World.field1281) {
                           var15 = World.worldList[++World.field1293 - 1];
                        } else {
                           var15 = null;
                        }

                        if(var15 != null) {
                           class83.intStack[++class83.intStackSize - 1] = var15.id;
                           class83.intStack[++class83.intStackSize - 1] = var15.mask;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.activity;
                           class83.intStack[++class83.intStackSize - 1] = var15.location;
                           class83.intStack[++class83.intStackSize - 1] = var15.playerCount;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.address;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = -1;
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 6502) {
                        World var14;
                        if(World.field1293 < World.field1281) {
                           var14 = World.worldList[++World.field1293 - 1];
                        } else {
                           var14 = null;
                        }

                        if(var14 != null) {
                           class83.intStack[++class83.intStackSize - 1] = var14.id;
                           class83.intStack[++class83.intStackSize - 1] = var14.mask;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var14.activity;
                           class83.intStack[++class83.intStackSize - 1] = var14.location;
                           class83.intStack[++class83.intStackSize - 1] = var14.playerCount;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var14.address;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = -1;
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 6506) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var15 = null;

                        for(var6 = 0; var6 < World.field1281; ++var6) {
                           if(World.worldList[var6].id == var4) {
                              var15 = World.worldList[var6];
                              break;
                           }
                        }

                        if(var15 != null) {
                           class83.intStack[++class83.intStackSize - 1] = var15.id;
                           class83.intStack[++class83.intStackSize - 1] = var15.mask;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.activity;
                           class83.intStack[++class83.intStackSize - 1] = var15.location;
                           class83.intStack[++class83.intStackSize - 1] = var15.playerCount;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.address;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = -1;
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 6507) {
                        class83.intStackSize -= 4;
                        var4 = class83.intStack[class83.intStackSize];
                        var5 = class83.intStack[class83.intStackSize + 1] == 1;
                        var6 = class83.intStack[class83.intStackSize + 2];
                        var19 = class83.intStack[class83.intStackSize + 3] == 1;
                        if(World.worldList != null) {
                           class225.method3965(0, World.worldList.length - 1, var4, var5, var6, var19);
                        }

                        var3 = 1;
                     } else if(var0 == 6511) {
                        var4 = class83.intStack[--class83.intStackSize];
                        if(var4 >= 0 && var4 < World.field1281) {
                           var15 = World.worldList[var4];
                           class83.intStack[++class83.intStackSize - 1] = var15.id;
                           class83.intStack[++class83.intStackSize - 1] = var15.mask;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.activity;
                           class83.intStack[++class83.intStackSize - 1] = var15.location;
                           class83.intStack[++class83.intStackSize - 1] = var15.playerCount;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.address;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = -1;
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 6512) {
                        Client.field1140 = class83.intStack[--class83.intStackSize] == 1;
                        var3 = 1;
                     } else {
                        class251 var16;
                        if(var0 == 6513) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var24 = class83.intStack[class83.intStackSize + 1];
                           var16 = class230.method3978(var24);
                           if(var16.method4300()) {
                              class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class158.getNpcDefinition(var4).method4519(var24, var16.field3398);
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = class158.getNpcDefinition(var4).method4518(var24, var16.field3397);
                           }

                           var3 = 1;
                        } else if(var0 == 6514) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var24 = class83.intStack[class83.intStackSize + 1];
                           var16 = class230.method3978(var24);
                           if(var16.method4300()) {
                              class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class29.getObjectDefinition(var4).method4399(var24, var16.field3398);
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = class29.getObjectDefinition(var4).method4414(var24, var16.field3397);
                           }

                           var3 = 1;
                        } else if(var0 == 6515) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var24 = class83.intStack[class83.intStackSize + 1];
                           var16 = class230.method3978(var24);
                           if(var16.method4300()) {
                              class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class224.getItemDefinition(var4).method4451(var24, var16.field3398);
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = class224.getItemDefinition(var4).method4455(var24, var16.field3397);
                           }

                           var3 = 1;
                        } else if(var0 == 6516) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var24 = class83.intStack[class83.intStackSize + 1];
                           var16 = class230.method3978(var24);
                           byte[] var11;
                           class252 var21;
                           class252 var23;
                           if(var16.method4300()) {
                              String[] var7 = class83.scriptStringStack;
                              var20 = ++class24.scriptStringStackSize - 1;
                              var21 = (class252)class252.field3400.get((long)var4);
                              if(var21 != null) {
                                 var23 = var21;
                              } else {
                                 var11 = class217.field2793.getConfigData(34, var4);
                                 var21 = new class252();
                                 if(var11 != null) {
                                    var21.method4315(new Buffer(var11));
                                 }

                                 var21.method4314();
                                 class252.field3400.put(var21, (long)var4);
                                 var23 = var21;
                              }

                              var7[var20] = var23.method4322(var24, var16.field3398);
                           } else {
                              int[] var25 = class83.intStack;
                              var20 = ++class83.intStackSize - 1;
                              var21 = (class252)class252.field3400.get((long)var4);
                              if(var21 != null) {
                                 var23 = var21;
                              } else {
                                 var11 = class217.field2793.getConfigData(34, var4);
                                 var21 = new class252();
                                 if(var11 != null) {
                                    var21.method4315(new Buffer(var11));
                                 }

                                 var21.method4314();
                                 class252.field3400.put(var21, (long)var4);
                                 var23 = var21;
                              }

                              var25[var20] = var23.method4317(var24, var16.field3397);
                           }

                           var3 = 1;
                        } else {
                           var3 = 2;
                        }
                     }
                  }

                  return var3;
               }
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "65"
   )
   static int method1620() {
      return ++class98.field1518 - 1;
   }
}
