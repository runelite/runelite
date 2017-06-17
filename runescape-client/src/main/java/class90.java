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
      int var5;
      int var6;
      int var7;
      Widget var8;
      Widget var9;
      if(var0 < 1000) {
         Widget var29;
         if(var0 == 100) {
            class83.intStackSize -= 3;
            var4 = class83.intStack[class83.intStackSize];
            var7 = class83.intStack[class83.intStackSize + 1];
            var5 = class83.intStack[class83.intStackSize + 2];
            if(var7 == 0) {
               throw new RuntimeException();
            }

            var8 = class223.method3959(var4);
            if(var8.children == null) {
               var8.children = new Widget[var5 + 1];
            }

            if(var8.children.length <= var5) {
               Widget[] var28 = new Widget[var5 + 1];

               for(var6 = 0; var6 < var8.children.length; ++var6) {
                  var28[var6] = var8.children[var6];
               }

               var8.children = var28;
            }

            if(var5 > 0 && var8.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            }

            var29 = new Widget();
            var29.type = var7;
            var29.parentId = var29.id = var8.id;
            var29.index = var5;
            var29.hasScript = true;
            var8.children[var5] = var29;
            if(var2) {
               class43.field582 = var29;
            } else {
               class31.field457 = var29;
            }

            XItemContainer.method1020(var8);
            var3 = 1;
         } else if(var0 == 101) {
            var9 = var2?class43.field582:class31.field457;
            var29 = class223.method3959(var9.id);
            var29.children[var9.index] = null;
            XItemContainer.method1020(var29);
            var3 = 1;
         } else if(var0 == 102) {
            var9 = class223.method3959(class83.intStack[--class83.intStackSize]);
            var9.children = null;
            XItemContainer.method1020(var9);
            var3 = 1;
         } else if(var0 == 200) {
            class83.intStackSize -= 2;
            var4 = class83.intStack[class83.intStackSize];
            var7 = class83.intStack[class83.intStackSize + 1];
            var29 = class172.method3015(var4, var7);
            if(var29 != null && var7 != -1) {
               class83.intStack[++class83.intStackSize - 1] = 1;
               if(var2) {
                  class43.field582 = var29;
               } else {
                  class31.field457 = var29;
               }
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 201) {
            var9 = class223.method3959(class83.intStack[--class83.intStackSize]);
            if(var9 != null) {
               class83.intStack[++class83.intStackSize - 1] = 1;
               if(var2) {
                  class43.field582 = var9;
               } else {
                  class31.field457 = var9;
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
         var8 = var2?class43.field582:class31.field457;
         if(var0 == 1500) {
            class83.intStack[++class83.intStackSize - 1] = var8.relativeX;
            var3 = 1;
         } else if(var0 == 1501) {
            class83.intStack[++class83.intStackSize - 1] = var8.relativeY;
            var3 = 1;
         } else if(var0 == 1502) {
            class83.intStack[++class83.intStackSize - 1] = var8.width;
            var3 = 1;
         } else if(var0 == 1503) {
            class83.intStack[++class83.intStackSize - 1] = var8.height;
            var3 = 1;
         } else if(var0 == 1504) {
            class83.intStack[++class83.intStackSize - 1] = var8.isHidden?1:0;
            var3 = 1;
         } else if(var0 == 1505) {
            class83.intStack[++class83.intStackSize - 1] = var8.parentId;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1700) {
         var9 = var2?class43.field582:class31.field457;
         if(var0 == 1600) {
            class83.intStack[++class83.intStackSize - 1] = var9.scrollX;
            var3 = 1;
         } else if(var0 == 1601) {
            class83.intStack[++class83.intStackSize - 1] = var9.scrollY;
            var3 = 1;
         } else if(var0 == 1602) {
            class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var9.text;
            var3 = 1;
         } else if(var0 == 1603) {
            class83.intStack[++class83.intStackSize - 1] = var9.scrollWidth;
            var3 = 1;
         } else if(var0 == 1604) {
            class83.intStack[++class83.intStackSize - 1] = var9.scrollHeight;
            var3 = 1;
         } else if(var0 == 1605) {
            class83.intStack[++class83.intStackSize - 1] = var9.field2737;
            var3 = 1;
         } else if(var0 == 1606) {
            class83.intStack[++class83.intStackSize - 1] = var9.rotationX;
            var3 = 1;
         } else if(var0 == 1607) {
            class83.intStack[++class83.intStackSize - 1] = var9.rotationY;
            var3 = 1;
         } else if(var0 == 1608) {
            class83.intStack[++class83.intStackSize - 1] = var9.rotationZ;
            var3 = 1;
         } else if(var0 == 1609) {
            class83.intStack[++class83.intStackSize - 1] = var9.opacity;
            var3 = 1;
         } else if(var0 == 1610) {
            class83.intStack[++class83.intStackSize - 1] = var9.field2686;
            var3 = 1;
         } else if(var0 == 1611) {
            class83.intStack[++class83.intStackSize - 1] = var9.textColor;
            var3 = 1;
         } else if(var0 == 1612) {
            class83.intStack[++class83.intStackSize - 1] = var9.field2728;
            var3 = 1;
         } else if(var0 == 1613) {
            class83.intStack[++class83.intStackSize - 1] = var9.field2684.rsOrdinal();
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1800) {
         var8 = var2?class43.field582:class31.field457;
         if(var0 == 1700) {
            class83.intStack[++class83.intStackSize - 1] = var8.itemId;
            var3 = 1;
         } else if(var0 == 1701) {
            if(var8.itemId != -1) {
               class83.intStack[++class83.intStackSize - 1] = var8.itemQuantity;
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 1702) {
            class83.intStack[++class83.intStackSize - 1] = var8.index;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1900) {
         var9 = var2?class43.field582:class31.field457;
         if(var0 == 1800) {
            class83.intStack[++class83.intStackSize - 1] = WorldMapType1.method263(class15.method92(var9));
            var3 = 1;
         } else if(var0 == 1801) {
            var7 = class83.intStack[--class83.intStackSize];
            --var7;
            if(var9.actions != null && var7 < var9.actions.length && var9.actions[var7] != null) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var9.actions[var7];
            } else {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            }

            var3 = 1;
         } else if(var0 == 1802) {
            if(var9.name == null) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var9.name;
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
         var9 = class223.method3959(class83.intStack[--class83.intStackSize]);
         if(var0 == 2500) {
            class83.intStack[++class83.intStackSize - 1] = var9.relativeX;
            var3 = 1;
         } else if(var0 == 2501) {
            class83.intStack[++class83.intStackSize - 1] = var9.relativeY;
            var3 = 1;
         } else if(var0 == 2502) {
            class83.intStack[++class83.intStackSize - 1] = var9.width;
            var3 = 1;
         } else if(var0 == 2503) {
            class83.intStack[++class83.intStackSize - 1] = var9.height;
            var3 = 1;
         } else if(var0 == 2504) {
            class83.intStack[++class83.intStackSize - 1] = var9.isHidden?1:0;
            var3 = 1;
         } else if(var0 == 2505) {
            class83.intStack[++class83.intStackSize - 1] = var9.parentId;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 2700) {
         var9 = class223.method3959(class83.intStack[--class83.intStackSize]);
         if(var0 == 2600) {
            class83.intStack[++class83.intStackSize - 1] = var9.scrollX;
            var3 = 1;
         } else if(var0 == 2601) {
            class83.intStack[++class83.intStackSize - 1] = var9.scrollY;
            var3 = 1;
         } else if(var0 == 2602) {
            class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var9.text;
            var3 = 1;
         } else if(var0 == 2603) {
            class83.intStack[++class83.intStackSize - 1] = var9.scrollWidth;
            var3 = 1;
         } else if(var0 == 2604) {
            class83.intStack[++class83.intStackSize - 1] = var9.scrollHeight;
            var3 = 1;
         } else if(var0 == 2605) {
            class83.intStack[++class83.intStackSize - 1] = var9.field2737;
            var3 = 1;
         } else if(var0 == 2606) {
            class83.intStack[++class83.intStackSize - 1] = var9.rotationX;
            var3 = 1;
         } else if(var0 == 2607) {
            class83.intStack[++class83.intStackSize - 1] = var9.rotationY;
            var3 = 1;
         } else if(var0 == 2608) {
            class83.intStack[++class83.intStackSize - 1] = var9.rotationZ;
            var3 = 1;
         } else if(var0 == 2609) {
            class83.intStack[++class83.intStackSize - 1] = var9.opacity;
            var3 = 1;
         } else if(var0 == 2610) {
            class83.intStack[++class83.intStackSize - 1] = var9.field2686;
            var3 = 1;
         } else if(var0 == 2611) {
            class83.intStack[++class83.intStackSize - 1] = var9.textColor;
            var3 = 1;
         } else if(var0 == 2612) {
            class83.intStack[++class83.intStackSize - 1] = var9.field2728;
            var3 = 1;
         } else if(var0 == 2613) {
            class83.intStack[++class83.intStackSize - 1] = var9.field2684.rsOrdinal();
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 2800) {
         if(var0 == 2700) {
            var9 = class223.method3959(class83.intStack[--class83.intStackSize]);
            class83.intStack[++class83.intStackSize - 1] = var9.itemId;
            var3 = 1;
         } else if(var0 == 2701) {
            var9 = class223.method3959(class83.intStack[--class83.intStackSize]);
            if(var9.itemId != -1) {
               class83.intStack[++class83.intStackSize - 1] = var9.itemQuantity;
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 2702) {
            var4 = class83.intStack[--class83.intStackSize];
            WidgetNode var27 = (WidgetNode)Client.componentTable.method3425((long)var4);
            if(var27 != null) {
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
         var9 = class223.method3959(class83.intStack[--class83.intStackSize]);
         if(var0 == 2800) {
            class83.intStack[++class83.intStackSize - 1] = WorldMapType1.method263(class15.method92(var9));
            var3 = 1;
         } else if(var0 == 2801) {
            var7 = class83.intStack[--class83.intStackSize];
            --var7;
            if(var9.actions != null && var7 < var9.actions.length && var9.actions[var7] != null) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var9.actions[var7];
            } else {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            }

            var3 = 1;
         } else if(var0 == 2802) {
            if(var9.name == null) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var9.name;
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
            var7 = class83.intStack[class83.intStackSize + 1];
            var5 = class83.intStack[class83.intStackSize + 2];
            if(Client.field1144 != 0 && var7 != 0 && Client.field931 < 50) {
               Client.field1036[Client.field931] = var4;
               Client.field1155[Client.field931] = var7;
               Client.field1150[Client.field931] = var5;
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
               IndexData var26 = FaceNormal.indexTrack1;
               var5 = Client.field1141;
               class203.field2517 = 1;
               class203.field2518 = var26;
               class203.field2519 = var4;
               class29.field438 = 0;
               class182.field2455 = var5;
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
         boolean var10;
         int var11;
         String var12;
         String var13;
         int var14;
         int[] var15;
         if(var0 < 4200) {
            if(var0 == 4100) {
               var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
               var7 = class83.intStack[--class83.intStackSize];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var13 + var7;
               var3 = 1;
            } else if(var0 == 4101) {
               class24.scriptStringStackSize -= 2;
               var13 = class83.scriptStringStack[class24.scriptStringStackSize];
               var12 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var13 + var12;
               var3 = 1;
            } else if(var0 == 4102) {
               var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
               var7 = class83.intStack[--class83.intStackSize];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var13 + ItemLayer.method2308(var7, true);
               var3 = 1;
            } else if(var0 == 4103) {
               var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var13.toLowerCase();
               var3 = 1;
            } else if(var0 == 4104) {
               var4 = class83.intStack[--class83.intStackSize];
               long var30 = 86400000L * (11745L + (long)var4);
               class83.field1328.setTime(new Date(var30));
               var14 = class83.field1328.get(5);
               var11 = class83.field1328.get(2);
               var6 = class83.field1328.get(1);
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var14 + "-" + class83.field1335[var11] + "-" + var6;
               var3 = 1;
            } else if(var0 == 4105) {
               class24.scriptStringStackSize -= 2;
               var13 = class83.scriptStringStack[class24.scriptStringStackSize];
               var12 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
               if(class20.localPlayer.composition != null && class20.localPlayer.composition.isFemale) {
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var12;
               } else {
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var13;
               }

               var3 = 1;
            } else if(var0 == 4106) {
               var4 = class83.intStack[--class83.intStackSize];
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = Integer.toString(var4);
               var3 = 1;
            } else if(var0 == 4107) {
               class24.scriptStringStackSize -= 2;
               int[] var31 = class83.intStack;
               var7 = ++class83.intStackSize - 1;
               var14 = class205.method3705(class83.scriptStringStack[class24.scriptStringStackSize], class83.scriptStringStack[class24.scriptStringStackSize + 1], Client.field1120);
               byte var60;
               if(var14 > 0) {
                  var60 = 1;
               } else if(var14 < 0) {
                  var60 = -1;
               } else {
                  var60 = 0;
               }

               var31[var7] = var60;
               var3 = 1;
            } else {
               byte[] var32;
               Font var61;
               if(var0 == 4108) {
                  var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class83.intStackSize -= 2;
                  var7 = class83.intStack[class83.intStackSize];
                  var5 = class83.intStack[class83.intStackSize + 1];
                  var32 = class33.field476.getConfigData(var5, 0);
                  var61 = new Font(var32);
                  class83.intStack[++class83.intStackSize - 1] = var61.method4630(var13, var7);
                  var3 = 1;
               } else if(var0 == 4109) {
                  var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class83.intStackSize -= 2;
                  var7 = class83.intStack[class83.intStackSize];
                  var5 = class83.intStack[class83.intStackSize + 1];
                  var32 = class33.field476.getConfigData(var5, 0);
                  var61 = new Font(var32);
                  class83.intStack[++class83.intStackSize - 1] = var61.method4629(var13, var7);
                  var3 = 1;
               } else if(var0 == 4110) {
                  class24.scriptStringStackSize -= 2;
                  var13 = class83.scriptStringStack[class24.scriptStringStackSize];
                  var12 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
                  if(class83.intStack[--class83.intStackSize] == 1) {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var13;
                  } else {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var12;
                  }

                  var3 = 1;
               } else if(var0 == 4111) {
                  var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = FontTypeFace.method4631(var13);
                  var3 = 1;
               } else if(var0 == 4112) {
                  var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  var7 = class83.intStack[--class83.intStackSize];
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var13 + (char)var7;
                  var3 = 1;
               } else {
                  char var58;
                  if(var0 == 4113) {
                     var4 = class83.intStack[--class83.intStackSize];
                     var15 = class83.intStack;
                     var5 = ++class83.intStackSize - 1;
                     var58 = (char)var4;
                     if(var58 >= 32 && var58 <= 126) {
                        var10 = true;
                     } else if(var58 >= 160 && var58 <= 255) {
                        var10 = true;
                     } else if(var58 != 8364 && var58 != 338 && var58 != 8212 && var58 != 339 && var58 != 376) {
                        var10 = false;
                     } else {
                        var10 = true;
                     }

                     var15[var5] = var10?1:0;
                     var3 = 1;
                  } else if(var0 == 4114) {
                     var4 = class83.intStack[--class83.intStackSize];
                     var15 = class83.intStack;
                     var5 = ++class83.intStackSize - 1;
                     var58 = (char)var4;
                     var10 = var58 >= 48 && var58 <= 57 || var58 >= 65 && var58 <= 90 || var58 >= 97 && var58 <= 122;
                     var15[var5] = var10?1:0;
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
                     var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                     if(var13 != null) {
                        class83.intStack[++class83.intStackSize - 1] = var13.length();
                     } else {
                        class83.intStack[++class83.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 4118) {
                     var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                     class83.intStackSize -= 2;
                     var7 = class83.intStack[class83.intStackSize];
                     var5 = class83.intStack[class83.intStackSize + 1];
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var13.substring(var7, var5);
                     var3 = 1;
                  } else if(var0 == 4119) {
                     var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                     StringBuilder var54 = new StringBuilder(var13.length());
                     boolean var48 = false;

                     for(var14 = 0; var14 < var13.length(); ++var14) {
                        var58 = var13.charAt(var14);
                        if(var58 == 60) {
                           var48 = true;
                        } else if(var58 == 62) {
                           var48 = false;
                        } else if(!var48) {
                           var54.append(var58);
                        }
                     }

                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var54.toString();
                     var3 = 1;
                  } else if(var0 == 4120) {
                     var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                     var7 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = var13.indexOf(var7);
                     var3 = 1;
                  } else if(var0 == 4121) {
                     class24.scriptStringStackSize -= 2;
                     var13 = class83.scriptStringStack[class24.scriptStringStackSize];
                     var12 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
                     var5 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = var13.indexOf(var12, var5);
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }
               }
            }

            return var3;
         } else {
            String var16;
            if(var0 < 4300) {
               if(var0 == 4200) {
                  var4 = class83.intStack[--class83.intStackSize];
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class224.getItemDefinition(var4).name;
                  var3 = 1;
               } else {
                  ItemComposition var59;
                  if(var0 == 4201) {
                     class83.intStackSize -= 2;
                     var4 = class83.intStack[class83.intStackSize];
                     var7 = class83.intStack[class83.intStackSize + 1];
                     var59 = class224.getItemDefinition(var4);
                     if(var7 >= 1 && var7 <= 5 && var59.groundActions[var7 - 1] != null) {
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var59.groundActions[var7 - 1];
                     } else {
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     }

                     var3 = 1;
                  } else if(var0 == 4202) {
                     class83.intStackSize -= 2;
                     var4 = class83.intStack[class83.intStackSize];
                     var7 = class83.intStack[class83.intStackSize + 1];
                     var59 = class224.getItemDefinition(var4);
                     if(var7 >= 1 && var7 <= 5 && var59.inventoryActions[var7 - 1] != null) {
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var59.inventoryActions[var7 - 1];
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
                     ItemComposition var56;
                     if(var0 == 4205) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var56 = class224.getItemDefinition(var4);
                        if(var56.notedTemplate == -1 && var56.note >= 0) {
                           class83.intStack[++class83.intStackSize - 1] = var56.note;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4206) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var56 = class224.getItemDefinition(var4);
                        if(var56.notedTemplate >= 0 && var56.note >= 0) {
                           class83.intStack[++class83.intStackSize - 1] = var56.note;
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
                        var56 = class224.getItemDefinition(var4);
                        if(var56.field3546 == -1 && var56.field3545 >= 0) {
                           class83.intStack[++class83.intStackSize - 1] = var56.field3545;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4209) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var56 = class224.getItemDefinition(var4);
                        if(var56.field3546 >= 0 && var56.field3545 >= 0) {
                           class83.intStack[++class83.intStackSize - 1] = var56.field3545;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4210) {
                        var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                        var7 = class83.intStack[--class83.intStackSize];
                        var10 = var7 == 1;
                        var16 = var13.toLowerCase();
                        short[] var50 = new short[16];
                        var6 = 0;
                        int var44 = 0;

                        while(true) {
                           short[] var55;
                           if(var44 >= class181.field2449) {
                              class269.field3681 = var50;
                              class40.field549 = 0;
                              class5.field44 = var6;
                              String[] var47 = new String[class5.field44];

                              for(int var57 = 0; var57 < class5.field44; ++var57) {
                                 var47[var57] = class224.getItemDefinition(var50[var57]).name;
                              }

                              var55 = class269.field3681;
                              class19.method162(var47, var55, 0, var47.length - 1);
                              break;
                           }

                           ItemComposition var45 = class224.getItemDefinition(var44);
                           if((!var10 || var45.field3513) && var45.notedTemplate == -1 && var45.name.toLowerCase().indexOf(var16) != -1) {
                              if(var6 >= 250) {
                                 class5.field44 = -1;
                                 class269.field3681 = null;
                                 break;
                              }

                              if(var6 >= var50.length) {
                                 var55 = new short[var50.length * 2];

                                 for(int var53 = 0; var53 < var6; ++var53) {
                                    var55[var53] = var50[var53];
                                 }

                                 var50 = var55;
                              }

                              var50[var6++] = (short)var44;
                           }

                           ++var44;
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
                  var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class83.intStackSize -= 2;
                  var7 = class83.intStack[class83.intStackSize];
                  var5 = class83.intStack[class83.intStackSize + 1];
                  Client.secretPacketBuffer1.putOpcode(180);
                  Client.secretPacketBuffer1.putByte(Friend.method1023(var13) + 2);
                  Client.secretPacketBuffer1.method3125(var13);
                  Client.secretPacketBuffer1.putByte(var7 - 1);
                  Client.secretPacketBuffer1.putByte(var5);
                  var3 = 1;
               } else {
                  ChatLineBuffer var33;
                  if(var0 == 5003) {
                     class83.intStackSize -= 2;
                     var4 = class83.intStack[class83.intStackSize];
                     var7 = class83.intStack[class83.intStackSize + 1];
                     var33 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var4));
                     MessageNode var39 = var33.method1765(var7);
                     if(var39 != null) {
                        class83.intStack[++class83.intStackSize - 1] = var39.id;
                        class83.intStack[++class83.intStackSize - 1] = var39.tick;
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var39.name != null?var39.name:"";
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var39.sender != null?var39.sender:"";
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var39.value != null?var39.value:"";
                     } else {
                        class83.intStack[++class83.intStackSize - 1] = -1;
                        class83.intStack[++class83.intStackSize - 1] = 0;
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     }

                     var3 = 1;
                  } else {
                     MessageNode var34;
                     if(var0 == 5004) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var34 = class9.method50(var4);
                        if(var34 != null) {
                           class83.intStack[++class83.intStackSize - 1] = var34.type;
                           class83.intStack[++class83.intStackSize - 1] = var34.tick;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var34.name != null?var34.name:"";
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var34.sender != null?var34.sender:"";
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var34.value != null?var34.value:"";
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
                        var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                        var7 = class83.intStack[--class83.intStackSize];
                        var16 = var13.toLowerCase();
                        byte var35 = 0;
                        if(var16.startsWith("yellow:")) {
                           var35 = 0;
                           var13 = var13.substring("yellow:".length());
                        } else if(var16.startsWith("red:")) {
                           var35 = 1;
                           var13 = var13.substring("red:".length());
                        } else if(var16.startsWith("green:")) {
                           var35 = 2;
                           var13 = var13.substring("green:".length());
                        } else if(var16.startsWith("cyan:")) {
                           var35 = 3;
                           var13 = var13.substring("cyan:".length());
                        } else if(var16.startsWith("purple:")) {
                           var35 = 4;
                           var13 = var13.substring("purple:".length());
                        } else if(var16.startsWith("white:")) {
                           var35 = 5;
                           var13 = var13.substring("white:".length());
                        } else if(var16.startsWith("flash1:")) {
                           var35 = 6;
                           var13 = var13.substring("flash1:".length());
                        } else if(var16.startsWith("flash2:")) {
                           var35 = 7;
                           var13 = var13.substring("flash2:".length());
                        } else if(var16.startsWith("flash3:")) {
                           var35 = 8;
                           var13 = var13.substring("flash3:".length());
                        } else if(var16.startsWith("glow1:")) {
                           var35 = 9;
                           var13 = var13.substring("glow1:".length());
                        } else if(var16.startsWith("glow2:")) {
                           var35 = 10;
                           var13 = var13.substring("glow2:".length());
                        } else if(var16.startsWith("glow3:")) {
                           var35 = 11;
                           var13 = var13.substring("glow3:".length());
                        } else if(Client.field1120 != 0) {
                           if(var16.startsWith("yellow:")) {
                              var35 = 0;
                              var13 = var13.substring("yellow:".length());
                           } else if(var16.startsWith("red:")) {
                              var35 = 1;
                              var13 = var13.substring("red:".length());
                           } else if(var16.startsWith("green:")) {
                              var35 = 2;
                              var13 = var13.substring("green:".length());
                           } else if(var16.startsWith("cyan:")) {
                              var35 = 3;
                              var13 = var13.substring("cyan:".length());
                           } else if(var16.startsWith("purple:")) {
                              var35 = 4;
                              var13 = var13.substring("purple:".length());
                           } else if(var16.startsWith("white:")) {
                              var35 = 5;
                              var13 = var13.substring("white:".length());
                           } else if(var16.startsWith("flash1:")) {
                              var35 = 6;
                              var13 = var13.substring("flash1:".length());
                           } else if(var16.startsWith("flash2:")) {
                              var35 = 7;
                              var13 = var13.substring("flash2:".length());
                           } else if(var16.startsWith("flash3:")) {
                              var35 = 8;
                              var13 = var13.substring("flash3:".length());
                           } else if(var16.startsWith("glow1:")) {
                              var35 = 9;
                              var13 = var13.substring("glow1:".length());
                           } else if(var16.startsWith("glow2:")) {
                              var35 = 10;
                              var13 = var13.substring("glow2:".length());
                           } else if(var16.startsWith("glow3:")) {
                              var35 = 11;
                              var13 = var13.substring("glow3:".length());
                           }
                        }

                        var16 = var13.toLowerCase();
                        byte var41 = 0;
                        if(var16.startsWith("wave:")) {
                           var41 = 1;
                           var13 = var13.substring("wave:".length());
                        } else if(var16.startsWith("wave2:")) {
                           var41 = 2;
                           var13 = var13.substring("wave2:".length());
                        } else if(var16.startsWith("shake:")) {
                           var41 = 3;
                           var13 = var13.substring("shake:".length());
                        } else if(var16.startsWith("scroll:")) {
                           var41 = 4;
                           var13 = var13.substring("scroll:".length());
                        } else if(var16.startsWith("slide:")) {
                           var41 = 5;
                           var13 = var13.substring("slide:".length());
                        } else if(Client.field1120 != 0) {
                           if(var16.startsWith("wave:")) {
                              var41 = 1;
                              var13 = var13.substring("wave:".length());
                           } else if(var16.startsWith("wave2:")) {
                              var41 = 2;
                              var13 = var13.substring("wave2:".length());
                           } else if(var16.startsWith("shake:")) {
                              var41 = 3;
                              var13 = var13.substring("shake:".length());
                           } else if(var16.startsWith("scroll:")) {
                              var41 = 4;
                              var13 = var13.substring("scroll:".length());
                           } else if(var16.startsWith("slide:")) {
                              var41 = 5;
                              var13 = var13.substring("slide:".length());
                           }
                        }

                        Client.secretPacketBuffer1.putOpcode(91);
                        Client.secretPacketBuffer1.putByte(0);
                        var6 = Client.secretPacketBuffer1.offset;
                        Client.secretPacketBuffer1.putByte(var7);
                        Client.secretPacketBuffer1.putByte(var35);
                        Client.secretPacketBuffer1.putByte(var41);
                        class208.method3796(Client.secretPacketBuffer1, var13);
                        Client.secretPacketBuffer1.method3030(Client.secretPacketBuffer1.offset - var6);
                        var3 = 1;
                     } else if(var0 == 5009) {
                        class24.scriptStringStackSize -= 2;
                        var13 = class83.scriptStringStack[class24.scriptStringStackSize];
                        var12 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
                        Client.secretPacketBuffer1.putOpcode(170);
                        Client.secretPacketBuffer1.putShort(0);
                        var5 = Client.secretPacketBuffer1.offset;
                        Client.secretPacketBuffer1.method3125(var13);
                        class208.method3796(Client.secretPacketBuffer1, var12);
                        Client.secretPacketBuffer1.method3156(Client.secretPacketBuffer1.offset - var5);
                        var3 = 1;
                     } else if(var0 == 5015) {
                        if(class20.localPlayer != null && class20.localPlayer.name != null) {
                           var13 = class20.localPlayer.name;
                        } else {
                           var13 = "";
                        }

                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var13;
                        var3 = 1;
                     } else if(var0 == 5016) {
                        class83.intStack[++class83.intStackSize - 1] = Client.field1123;
                        var3 = 1;
                     } else if(var0 == 5017) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var15 = class83.intStack;
                        var5 = ++class83.intStackSize - 1;
                        var33 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var4));
                        if(var33 == null) {
                           var14 = 0;
                        } else {
                           var14 = var33.method1766();
                        }

                        var15[var5] = var14;
                        var3 = 1;
                     } else if(var0 == 5018) {
                        var4 = class83.intStack[--class83.intStackSize];
                        var15 = class83.intStack;
                        var5 = ++class83.intStackSize - 1;
                        var34 = (MessageNode)class98.field1517.method3389((long)var4);
                        if(var34 == null) {
                           var14 = -1;
                        } else if(var34.previous == class98.field1523.field2501) {
                           var14 = -1;
                        } else {
                           var14 = ((MessageNode)var34.previous).id;
                        }

                        var15[var5] = var14;
                        var3 = 1;
                     } else if(var0 == 5019) {
                        var4 = class83.intStack[--class83.intStackSize];
                        class83.intStack[++class83.intStackSize - 1] = PacketBuffer.method3287(var4);
                        var3 = 1;
                     } else if(var0 == 5020) {
                        var13 = class83.scriptStringStack[--class24.scriptStringStackSize];
                        if(var13.equalsIgnoreCase("toggleroof")) {
                           Item.field1481.field1299 = !Item.field1481.field1299;
                           class5.method16();
                           if(Item.field1481.field1299) {
                              class5.sendGameMessage(99, "", "Roofs are now all hidden");
                           } else {
                              class5.sendGameMessage(99, "", "Roofs will only be removed selectively");
                           }
                        }

                        if(var13.equalsIgnoreCase("displayfps")) {
                           Client.field918 = !Client.field918;
                        }

                        if(var13.equalsIgnoreCase("clickbox")) {
                           Model.field1925 = !Model.field1925;
                           class5.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1925?"AABB":"Legacy"));
                        }

                        if(Client.rights >= 2) {
                           if(var13.equalsIgnoreCase("aabb")) {
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

                           if(var13.equalsIgnoreCase("legacyboxes")) {
                              class7.field234 = !class7.field234;
                              class5.sendGameMessage(99, "", "Show legacy boxes: " + class7.field234);
                           }

                           if(var13.equalsIgnoreCase("geotests")) {
                              class7.field235 = !class7.field235;
                              class5.sendGameMessage(99, "", "Show geometry tests: " + class7.field235);
                           }

                           if(var13.equalsIgnoreCase("fpson")) {
                              Client.field918 = true;
                           }

                           if(var13.equalsIgnoreCase("fpsoff")) {
                              Client.field918 = false;
                           }

                           if(var13.equalsIgnoreCase("gc")) {
                              System.gc();
                           }

                           if(var13.equalsIgnoreCase("clientdrop")) {
                              if(Client.field957 > 0) {
                                 TextureProvider.method2306();
                              } else {
                                 class23.setGameState(40);
                                 class222.field2846 = WidgetNode.rssocket;
                                 WidgetNode.rssocket = null;
                              }
                           }

                           if(var13.equalsIgnoreCase("errortest") && Client.field1161 == 2) {
                              throw new RuntimeException();
                           }
                        }

                        Client.secretPacketBuffer1.putOpcode(146);
                        Client.secretPacketBuffer1.putByte(var13.length() + 1);
                        Client.secretPacketBuffer1.method3125(var13);
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
                  }
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
                  var14 = class83.intStack[class83.intStackSize];
                  var11 = class83.intStack[class83.intStackSize + 1];
                  if(!Client.field1152) {
                     Client.field1159 = var14;
                     Client.mapAngle = var11;
                  }

                  var3 = 1;
               } else if(var0 == 5505) {
                  class83.intStack[++class83.intStackSize - 1] = Client.field1159;
                  var3 = 1;
               } else if(var0 == 5506) {
                  class83.intStack[++class83.intStackSize - 1] = Client.mapAngle;
                  var3 = 1;
               } else if(var0 == 5530) {
                  var14 = class83.intStack[--class83.intStackSize];
                  if(var14 < 0) {
                     var14 = 0;
                  }

                  Client.field995 = var14;
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
               boolean var17;
               if(var0 >= 6600) {
                  if(var0 < 6700) {
                     if(var0 == 6600) {
                        var4 = Player.plane;
                        var7 = class19.baseX + (class20.localPlayer.x >> 7);
                        var5 = class21.baseY + (class20.localPlayer.y >> 7);
                        WidgetNode.method1030().method5168(var4, var7, var5, true);
                        var3 = 1;
                     } else {
                        WorldMapData var37;
                        if(var0 == 6601) {
                           var4 = class83.intStack[--class83.intStackSize];
                           var12 = "";
                           var37 = WidgetNode.method1030().method5151(var4);
                           if(var37 != null) {
                              var12 = var37.method338();
                           }

                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var12;
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
                           Coordinates var40;
                           if(var0 == 6606) {
                              var40 = new Coordinates(class83.intStack[--class83.intStackSize]);
                              WidgetNode.method1030().method5069(var40.worldX, var40.worldY);
                              var3 = 1;
                           } else if(var0 == 6607) {
                              var40 = new Coordinates(class83.intStack[--class83.intStackSize]);
                              WidgetNode.method1030().method5213(var40.worldX, var40.worldY);
                              var3 = 1;
                           } else if(var0 == 6608) {
                              var40 = new Coordinates(class83.intStack[--class83.intStackSize]);
                              WidgetNode.method1030().method5182(var40.plane, var40.worldX, var40.worldY);
                              var3 = 1;
                           } else if(var0 == 6609) {
                              var40 = new Coordinates(class83.intStack[--class83.intStackSize]);
                              WidgetNode.method1030().method5072(var40.plane, var40.worldX, var40.worldY);
                              var3 = 1;
                           } else if(var0 == 6610) {
                              class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5073();
                              class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5074();
                              var3 = 1;
                           } else {
                              WorldMapData var38;
                              if(var0 == 6611) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 var38 = WidgetNode.method1030().method5151(var4);
                                 if(var38 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var38.method300().method3825();
                                 }

                                 var3 = 1;
                              } else if(var0 == 6612) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 var38 = WidgetNode.method1030().method5151(var4);
                                 if(var38 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = (var38.method294() - var38.method293() + 1) * 64;
                                    class83.intStack[++class83.intStackSize - 1] = (var38.method296() - var38.method305() + 1) * 64;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6613) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 var38 = WidgetNode.method1030().method5151(var4);
                                 if(var38 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var38.method293() * 64;
                                    class83.intStack[++class83.intStackSize - 1] = var38.method305() * 64;
                                    class83.intStack[++class83.intStackSize - 1] = var38.method294() * 64 + 64 - 1;
                                    class83.intStack[++class83.intStackSize - 1] = var38.method296() * 64 + 64 - 1;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6614) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 var38 = WidgetNode.method1030().method5151(var4);
                                 if(var38 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var38.method314();
                                 }

                                 var3 = 1;
                              } else if(var0 == 6615) {
                                 var40 = WidgetNode.method1030().method5075();
                                 if(var40 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var40.worldX;
                                    class83.intStack[++class83.intStackSize - 1] = var40.worldY;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6616) {
                                 class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5076();
                                 var3 = 1;
                              } else if(var0 == 6617) {
                                 var40 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                 var38 = WidgetNode.method1030().method5055();
                                 if(var38 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                    var3 = 1;
                                 } else {
                                    int[] var42 = var38.method346(var40.plane, var40.worldX, var40.worldY);
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
                                 Coordinates var43;
                                 if(var0 == 6618) {
                                    var40 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                    var38 = WidgetNode.method1030().method5055();
                                    if(var38 == null) {
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                       var3 = 1;
                                    } else {
                                       var43 = var38.method317(var40.worldX, var40.worldY);
                                       if(var43 == null) {
                                          class83.intStack[++class83.intStackSize - 1] = -1;
                                       } else {
                                          class83.intStack[++class83.intStackSize - 1] = var43.method3825();
                                       }

                                       var3 = 1;
                                    }
                                 } else {
                                    Coordinates var51;
                                    if(var0 == 6619) {
                                       class83.intStackSize -= 2;
                                       var4 = class83.intStack[class83.intStackSize];
                                       var51 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                       var37 = WidgetNode.method1030().method5151(var4);
                                       var14 = class20.localPlayer.field884;
                                       var11 = (class20.localPlayer.x >> 7) + class19.baseX;
                                       var6 = class21.baseY + (class20.localPlayer.y >> 7);
                                       Coordinates var49 = new Coordinates(var14, var11, var6);
                                       WidgetNode.method1030().method5207(var37, var49, var51, false);
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
                                       var37 = WidgetNode.method1030().method5151(var4);
                                       if(var37 == null) {
                                          class83.intStack[++class83.intStackSize - 1] = 0;
                                          var3 = 1;
                                       } else {
                                          class83.intStack[++class83.intStackSize - 1] = var37.method282(var51.plane, var51.worldX, var51.worldY)?1:0;
                                          var3 = 1;
                                       }
                                    } else if(var0 == 6622) {
                                       class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5107();
                                       class83.intStack[++class83.intStackSize - 1] = WidgetNode.method1030().method5144();
                                       var3 = 1;
                                    } else if(var0 == 6623) {
                                       var40 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                       var38 = WidgetNode.method1030().method5051(var40.plane, var40.worldX, var40.worldY);
                                       if(var38 == null) {
                                          class83.intStack[++class83.intStackSize - 1] = -1;
                                       } else {
                                          class83.intStack[++class83.intStackSize - 1] = var38.method287();
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
                                       boolean var52;
                                       if(var0 == 6628) {
                                          var52 = class83.intStack[--class83.intStackSize] == 1;
                                          WidgetNode.method1030().method5082(var52);
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
                                          var52 = class83.intStack[--class83.intStackSize] == 1;
                                          WidgetNode.method1030().method5086(var52);
                                          var3 = 1;
                                       } else if(var0 == 6633) {
                                          class83.intStackSize -= 2;
                                          var4 = class83.intStack[class83.intStackSize];
                                          var17 = class83.intStack[class83.intStackSize + 1] == 1;
                                          WidgetNode.method1030().method5087(var4, var17);
                                          var3 = 1;
                                       } else if(var0 == 6634) {
                                          class83.intStackSize -= 2;
                                          var4 = class83.intStack[class83.intStackSize];
                                          var17 = class83.intStack[class83.intStackSize + 1] == 1;
                                          WidgetNode.method1030().method5088(var4, var17);
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
                                          var43 = WidgetNode.method1030().method5094(var4, var51);
                                          if(var43 == null) {
                                             class83.intStack[++class83.intStackSize - 1] = -1;
                                          } else {
                                             class83.intStack[++class83.intStackSize - 1] = var43.method3825();
                                          }

                                          var3 = 1;
                                       } else {
                                          class39 var24;
                                          if(var0 == 6639) {
                                             var24 = WidgetNode.method1030().method5114();
                                             if(var24 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                             } else {
                                                class83.intStack[++class83.intStackSize - 1] = var24.field541;
                                                class83.intStack[++class83.intStackSize - 1] = var24.field538.method3825();
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6640) {
                                             var24 = WidgetNode.method1030().method5052();
                                             if(var24 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                             } else {
                                                class83.intStack[++class83.intStackSize - 1] = var24.field541;
                                                class83.intStack[++class83.intStackSize - 1] = var24.field538.method3825();
                                             }

                                             var3 = 1;
                                          } else {
                                             Area var25;
                                             if(var0 == 6693) {
                                                var4 = class83.intStack[--class83.intStackSize];
                                                var25 = Area.field3304[var4];
                                                if(var25.name == null) {
                                                   class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                                } else {
                                                   class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var25.name;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6694) {
                                                var4 = class83.intStack[--class83.intStackSize];
                                                var25 = Area.field3304[var4];
                                                class83.intStack[++class83.intStackSize - 1] = var25.field3315;
                                                var3 = 1;
                                             } else if(var0 == 6695) {
                                                var4 = class83.intStack[--class83.intStackSize];
                                                var25 = Area.field3304[var4];
                                                if(var25 == null) {
                                                   class83.intStack[++class83.intStackSize - 1] = -1;
                                                } else {
                                                   class83.intStack[++class83.intStackSize - 1] = var25.field3306;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6696) {
                                                var4 = class83.intStack[--class83.intStackSize];
                                                var25 = Area.field3304[var4];
                                                if(var25 == null) {
                                                   class83.intStack[++class83.intStackSize - 1] = -1;
                                                } else {
                                                   class83.intStack[++class83.intStackSize - 1] = var25.spriteId;
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
                     World var18;
                     if(var0 == 6501) {
                        World.field1293 = 0;
                        if(World.field1293 < World.field1281) {
                           var18 = World.worldList[++World.field1293 - 1];
                        } else {
                           var18 = null;
                        }

                        if(var18 != null) {
                           class83.intStack[++class83.intStackSize - 1] = var18.id;
                           class83.intStack[++class83.intStackSize - 1] = var18.mask;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var18.activity;
                           class83.intStack[++class83.intStackSize - 1] = var18.location;
                           class83.intStack[++class83.intStackSize - 1] = var18.playerCount;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var18.address;
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
                        World var19;
                        if(World.field1293 < World.field1281) {
                           var19 = World.worldList[++World.field1293 - 1];
                        } else {
                           var19 = null;
                        }

                        if(var19 != null) {
                           class83.intStack[++class83.intStackSize - 1] = var19.id;
                           class83.intStack[++class83.intStackSize - 1] = var19.mask;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var19.activity;
                           class83.intStack[++class83.intStackSize - 1] = var19.location;
                           class83.intStack[++class83.intStackSize - 1] = var19.playerCount;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var19.address;
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
                        var18 = null;

                        for(var5 = 0; var5 < World.field1281; ++var5) {
                           if(World.worldList[var5].id == var4) {
                              var18 = World.worldList[var5];
                              break;
                           }
                        }

                        if(var18 != null) {
                           class83.intStack[++class83.intStackSize - 1] = var18.id;
                           class83.intStack[++class83.intStackSize - 1] = var18.mask;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var18.activity;
                           class83.intStack[++class83.intStackSize - 1] = var18.location;
                           class83.intStack[++class83.intStackSize - 1] = var18.playerCount;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var18.address;
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
                        var17 = class83.intStack[class83.intStackSize + 1] == 1;
                        var5 = class83.intStack[class83.intStackSize + 2];
                        var10 = class83.intStack[class83.intStackSize + 3] == 1;
                        if(World.worldList != null) {
                           class225.method3965(0, World.worldList.length - 1, var4, var17, var5, var10);
                        }

                        var3 = 1;
                     } else if(var0 == 6511) {
                        var4 = class83.intStack[--class83.intStackSize];
                        if(var4 >= 0 && var4 < World.field1281) {
                           var18 = World.worldList[var4];
                           class83.intStack[++class83.intStackSize - 1] = var18.id;
                           class83.intStack[++class83.intStackSize - 1] = var18.mask;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var18.activity;
                           class83.intStack[++class83.intStackSize - 1] = var18.location;
                           class83.intStack[++class83.intStackSize - 1] = var18.playerCount;
                           class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var18.address;
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
                        class251 var36;
                        if(var0 == 6513) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var7 = class83.intStack[class83.intStackSize + 1];
                           var36 = class230.method3978(var7);
                           if(var36.method4300()) {
                              class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class158.getNpcDefinition(var4).method4519(var7, var36.field3398);
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = class158.getNpcDefinition(var4).method4518(var7, var36.field3397);
                           }

                           var3 = 1;
                        } else if(var0 == 6514) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var7 = class83.intStack[class83.intStackSize + 1];
                           var36 = class230.method3978(var7);
                           if(var36.method4300()) {
                              class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class29.getObjectDefinition(var4).method4399(var7, var36.field3398);
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = class29.getObjectDefinition(var4).method4414(var7, var36.field3397);
                           }

                           var3 = 1;
                        } else if(var0 == 6515) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var7 = class83.intStack[class83.intStackSize + 1];
                           var36 = class230.method3978(var7);
                           if(var36.method4300()) {
                              class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class224.getItemDefinition(var4).method4451(var7, var36.field3398);
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = class224.getItemDefinition(var4).method4455(var7, var36.field3397);
                           }

                           var3 = 1;
                        } else if(var0 == 6516) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var7 = class83.intStack[class83.intStackSize + 1];
                           var36 = class230.method3978(var7);
                           byte[] var20;
                           class252 var21;
                           class252 var22;
                           if(var36.method4300()) {
                              String[] var23 = class83.scriptStringStack;
                              var11 = ++class24.scriptStringStackSize - 1;
                              var21 = (class252)class252.field3400.get((long)var4);
                              if(var21 != null) {
                                 var22 = var21;
                              } else {
                                 var20 = class217.field2793.getConfigData(34, var4);
                                 var21 = new class252();
                                 if(var20 != null) {
                                    var21.method4315(new Buffer(var20));
                                 }

                                 var21.method4314();
                                 class252.field3400.put(var21, (long)var4);
                                 var22 = var21;
                              }

                              var23[var11] = var22.method4322(var7, var36.field3398);
                           } else {
                              int[] var46 = class83.intStack;
                              var11 = ++class83.intStackSize - 1;
                              var21 = (class252)class252.field3400.get((long)var4);
                              if(var21 != null) {
                                 var22 = var21;
                              } else {
                                 var20 = class217.field2793.getConfigData(34, var4);
                                 var21 = new class252();
                                 if(var20 != null) {
                                    var21.method4315(new Buffer(var20));
                                 }

                                 var21.method4314();
                                 class252.field3400.put(var21, (long)var4);
                                 var22 = var21;
                              }

                              var46[var11] = var22.method4317(var7, var36.field3397);
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

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("9df796757dde3a3b23a971146949b472608c29472dbc3eb079a16cf0ed5c25aab4edb6225d1ebe9c2fcfd7832924edaad7788f2b1a0e5c09a22c679a7fc547893224d45af661efcb1b9843d39bbad6c4cf2d22fc5392e43611f40faad8c8364a7d82266fd1f92cb350cd4e893b9aa12a25493b0bac617a6f4b46cc17d539af4b", 16);
   }
}
