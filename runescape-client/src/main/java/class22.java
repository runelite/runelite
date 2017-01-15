import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class22 extends class119 {
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 529750145
   )
   static int field234;
   @ObfuscatedName("cf")
   static class208 field235;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 699207233
   )
   static int field236;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 242502223
   )
   static int field237;
   @ObfuscatedName("j")
   static Buffer field238;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-44"
   )
   static int method203(int var0, int var1, int var2) {
      return (class10.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class10.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "703014920"
   )
   protected boolean vmethod2276(int var1, int var2, int var3, CollisionData var4) {
      return super.field1838 == var2 && var3 == super.field1840;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "59"
   )
   static final void method207() {
      int var0;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(class94.method1870(var0)) {
            GroundObject.method1499(Widget.widgets[var0], -1);
         }
      }

      for(var0 = 0; var0 < Client.field533; ++var0) {
         if(Client.field485[var0]) {
            Client.field486[var0] = true;
         }

         Client.field487[var0] = Client.field485[var0];
         Client.field485[var0] = false;
      }

      Client.field484 = Client.gameCycle;
      Client.field429 = -1;
      Client.field430 = -1;
      class13.field144 = null;
      if(Client.widgetRoot != -1) {
         Client.field533 = 0;
         class40.method743(Client.widgetRoot, 0, 0, class0.field1, class65.field1099, 0, 0, -1);
      }

      class219.method3964();
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(!Client.isMenuOpen) {
         if(Client.field429 != -1) {
            class13.method173(Client.field429, Client.field430);
         }
      } else {
         var0 = class118.menuX;
         var1 = Buffer.menuY;
         var2 = class20.menuWidth;
         var3 = class94.menuHeight;
         int var7 = 6116423;
         class219.method3993(var0, var1, var2, var3, var7);
         class219.method3993(1 + var0, var1 + 1, var2 - 2, 16, 0);
         class219.method3977(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
         class97.field1621.method3867("Choose Option", 3 + var0, var1 + 14, var7, -1);
         var4 = class115.field1788;
         var5 = class115.field1789;

         for(var6 = 0; var6 < Client.menuOptionCount; ++var6) {
            int var8 = 15 * (Client.menuOptionCount - 1 - var6) + var1 + 31;
            int var9 = 16777215;
            if(var4 > var0 && var4 < var2 + var0 && var5 > var8 - 13 && var5 < var8 + 3) {
               var9 = 16776960;
            }

            class208 var10 = class97.field1621;
            String var11;
            if(Client.menuTargets[var6].length() > 0) {
               var11 = Client.menuOptions[var6] + " " + Client.menuTargets[var6];
            } else {
               var11 = Client.menuOptions[var6];
            }

            var10.method3867(var11, 3 + var0, var8, var9, 0);
         }

         class152.method2757(class118.menuX, Buffer.menuY, class20.menuWidth, class94.menuHeight);
      }

      if(Client.field492 == 3) {
         for(var0 = 0; var0 < Client.field533; ++var0) {
            if(Client.field487[var0]) {
               class219.method3976(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field486[var0]) {
               class219.method3976(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      var0 = class60.plane;
      var1 = class148.localPlayer.x;
      var2 = class148.localPlayer.y;
      var3 = Client.field462;

      for(class31 var12 = (class31)class31.field703.method2391(); null != var12; var12 = (class31)class31.field703.method2393()) {
         if(var12.field705 != -1 || null != var12.field709) {
            var4 = 0;
            if(var1 > var12.field702) {
               var4 += var1 - var12.field702;
            } else if(var1 < var12.field700) {
               var4 += var12.field700 - var1;
            }

            if(var2 > var12.field716) {
               var4 += var2 - var12.field716;
            } else if(var2 < var12.field701) {
               var4 += var12.field701 - var2;
            }

            if(var4 - 64 <= var12.field704 && Client.field557 != 0 && var12.field699 == var0) {
               var4 -= 64;
               if(var4 < 0) {
                  var4 = 0;
               }

               var5 = (var12.field704 - var4) * Client.field557 / var12.field704;
               Object var13;
               class53 var14;
               class55 var15;
               class66 var16;
               if(null == var12.field706) {
                  if(var12.field705 >= 0) {
                     var13 = null;
                     var14 = class53.method955(class10.field94, var12.field705, 0);
                     if(var14 != null) {
                        var15 = var14.method953().method994(class140.field1961);
                        var16 = class66.method1130(var15, 100, var5);
                        var16.method1133(-1);
                        class20.field222.method889(var16);
                        var12.field706 = var16;
                     }
                  }
               } else {
                  var12.field706.method1134(var5);
               }

               if(var12.field698 == null) {
                  if(null != var12.field709 && (var12.field710 -= var3) <= 0) {
                     var6 = (int)(Math.random() * (double)var12.field709.length);
                     var13 = null;
                     var14 = class53.method955(class10.field94, var12.field709[var6], 0);
                     if(var14 != null) {
                        var15 = var14.method953().method994(class140.field1961);
                        var16 = class66.method1130(var15, 100, var5);
                        var16.method1133(0);
                        class20.field222.method889(var16);
                        var12.field698 = var16;
                        var12.field710 = var12.field707 + (int)(Math.random() * (double)(var12.field708 - var12.field707));
                     }
                  }
               } else {
                  var12.field698.method1134(var5);
                  if(!var12.field698.linked()) {
                     var12.field698 = null;
                  }
               }
            } else {
               if(null != var12.field706) {
                  class20.field222.method903(var12.field706);
                  var12.field706 = null;
               }

               if(null != var12.field698) {
                  class20.field222.method903(var12.field698);
                  var12.field698 = null;
               }
            }
         }
      }

      Client.field462 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "-1892930506"
   )
   public static void method209(class182 var0, class182 var1, class182 var2, class182 var3) {
      Widget.field2245 = var0;
      Widget.field2177 = var1;
      XClanMember.field277 = var2;
      Widget.field2318 = var3;
      Widget.widgets = new Widget[Widget.field2245.method3291()][];
      class6.validInterfaces = new boolean[Widget.field2245.method3291()];
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)I",
      garbageValue = "13"
   )
   static final int method210(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class44.method799(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class88.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class165.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class172.field2333[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class165.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class148.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class172.field2335[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class44.method799(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class88.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class165.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class101.method1911(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = FrameMap.baseX + (class148.localPlayer.x >> 7);
               }

               if(var6 == 19) {
                  var7 = XItemContainer.baseY + (class148.localPlayer.y >> 7);
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[Lclass177;",
      garbageValue = "-69"
   )
   public static class177[] method211() {
      return new class177[]{class177.field2645, class177.field2642, class177.field2650, class177.field2644, class177.field2646, class177.field2643};
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "0"
   )
   public static void method212(class159 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3228.method2358();
      if(null != var1) {
         int var2 = var0.offset;
         var0.method2763(var1.field3221);

         for(int var3 = 0; var3 < var1.field3220; ++var3) {
            if(var1.field3222[var3] != 0) {
               var0.method2760(var1.field3222[var3]);
            } else {
               try {
                  int var4 = var1.field3219[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2760(0);
                     var0.method2763(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3224[var3]);
                     var0.method2760(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2760(0);
                     var0.method2763(var6);
                  }

                  Method var7;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var7 = var1.methods[var3];
                        var6 = var7.getModifiers();
                        var0.method2760(0);
                        var0.method2763(var6);
                     }
                  } else {
                     var7 = var1.methods[var3];
                     byte[][] var8 = var1.args[var3];
                     Object[] var9 = new Object[var8.length];

                     for(int var10 = 0; var10 < var8.length; ++var10) {
                        ObjectInputStream var11 = new ObjectInputStream(new ByteArrayInputStream(var8[var10]));
                        var9[var10] = var11.readObject();
                     }

                     Object var24 = var7.invoke((Object)null, var9);
                     if(null == var24) {
                        var0.method2760(0);
                     } else if(var24 instanceof Number) {
                        var0.method2760(1);
                        var0.method2933(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2760(2);
                        var0.method2811((String)var24);
                     } else {
                        var0.method2760(4);
                     }
                  }
               } catch (ClassNotFoundException var12) {
                  var0.method2760(-10);
               } catch (InvalidClassException var13) {
                  var0.method2760(-11);
               } catch (StreamCorruptedException var14) {
                  var0.method2760(-12);
               } catch (OptionalDataException var15) {
                  var0.method2760(-13);
               } catch (IllegalAccessException var16) {
                  var0.method2760(-14);
               } catch (IllegalArgumentException var17) {
                  var0.method2760(-15);
               } catch (InvocationTargetException var18) {
                  var0.method2760(-16);
               } catch (SecurityException var19) {
                  var0.method2760(-17);
               } catch (IOException var20) {
                  var0.method2760(-18);
               } catch (NullPointerException var21) {
                  var0.method2760(-19);
               } catch (Exception var22) {
                  var0.method2760(-20);
               } catch (Throwable var23) {
                  var0.method2760(-21);
               }
            }
         }

         var0.method2797(var2);
         var1.unlink();
      }

   }
}
