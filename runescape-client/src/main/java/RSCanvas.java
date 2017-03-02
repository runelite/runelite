import java.awt.Canvas;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("da")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("b")
   Component field1747;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -816881823
   )
   static int field1749;

   public final void paint(Graphics var1) {
      this.field1747.paint(var1);
   }

   RSCanvas(Component var1) {
      this.field1747 = var1;
   }

   public final void update(Graphics var1) {
      this.field1747.update(var1);
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1723371631"
   )
   static void method2141(int var0, int var1, int var2, int var3) {
      Widget var4 = CollisionData.method2322(var0, var1);
      if(var4 != null && null != var4.field2253) {
         class18 var5 = new class18();
         var5.field185 = var4;
         var5.field197 = var4.field2253;
         class97.method1988(var5);
      }

      Client.field442 = var3;
      Client.field549 = true;
      class170.field2331 = var0;
      Client.field441 = var1;
      class137.field1908 = var2;
      Frames.method1960(var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "24"
   )
   static int method2142(int var0) {
      MessageNode var1 = (MessageNode)class47.field924.method2386((long)var0);
      return null == var1?-1:(var1.next == class47.field923.field1896?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "23"
   )
   static int method2144(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class32.scriptStringStack[--World.scriptStringStackSize];
         class140.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class101.field1648 -= 2;
         ChatLineBuffer.method987(class9.localPlayer, class32.field729[class101.field1648], class32.field729[1 + class101.field1648]);
         return 1;
      } else if(var0 == 3103) {
         Client.field327.method3124(6);

         for(WidgetNode var20 = (WidgetNode)Client.componentTable.method2423(); var20 != null; var20 = (WidgetNode)Client.componentTable.method2424()) {
            if(var20.field179 == 0 || var20.field179 == 3) {
               class30.method683(var20, true);
            }
         }

         if(Client.field546 != null) {
            Frames.method1960(Client.field546);
            Client.field546 = null;
         }

         return 1;
      } else {
         boolean var7;
         int var21;
         if(var0 == 3104) {
            var3 = class32.scriptStringStack[--World.scriptStringStackSize];
            var21 = 0;
            var7 = false;
            boolean var22 = false;
            int var9 = 0;
            int var10 = var3.length();
            int var11 = 0;

            boolean var6;
            while(true) {
               if(var11 >= var10) {
                  var6 = var22;
                  break;
               }

               label334: {
                  char var12 = var3.charAt(var11);
                  if(var11 == 0) {
                     if(var12 == 45) {
                        var7 = true;
                        break label334;
                     }

                     if(var12 == 43) {
                        break label334;
                     }
                  }

                  int var23;
                  if(var12 >= 48 && var12 <= 57) {
                     var23 = var12 - 48;
                  } else if(var12 >= 65 && var12 <= 90) {
                     var23 = var12 - 55;
                  } else {
                     if(var12 < 97 || var12 > 122) {
                        var6 = false;
                        break;
                     }

                     var23 = var12 - 87;
                  }

                  if(var23 >= 10) {
                     var6 = false;
                     break;
                  }

                  if(var7) {
                     var23 = -var23;
                  }

                  int var13 = var23 + 10 * var9;
                  if(var13 / 10 != var9) {
                     var6 = false;
                     break;
                  }

                  var9 = var13;
                  var22 = true;
               }

               ++var11;
            }

            if(var6) {
               var21 = Overlay.method3854(var3);
            }

            Client.field327.method3124(26);
            Client.field327.method2844(var21);
            return 1;
         } else if(var0 == 3105) {
            var3 = class32.scriptStringStack[--World.scriptStringStackSize];
            Client.field327.method3124(198);
            Client.field327.method3010(var3.length() + 1);
            Client.field327.method2893(var3);
            return 1;
         } else if(var0 == 3106) {
            var3 = class32.scriptStringStack[--World.scriptStringStackSize];
            Client.field327.method3124(32);
            Client.field327.method3010(var3.length() + 1);
            Client.field327.method2893(var3);
            return 1;
         } else {
            int var5;
            int var14;
            String var15;
            if(var0 == 3107) {
               var14 = class32.field729[--class101.field1648];
               var15 = class32.scriptStringStack[--World.scriptStringStackSize];
               var5 = class45.field907;
               int[] var24 = class45.field900;
               var7 = false;

               for(int var8 = 0; var8 < var5; ++var8) {
                  Player var17 = Client.cachedPlayers[var24[var8]];
                  if(var17 != null && class9.localPlayer != var17 && null != var17.name && var17.name.equalsIgnoreCase(var15)) {
                     if(var14 == 1) {
                        Client.field327.method3124(69);
                        Client.field327.method3010(0);
                        Client.field327.method2890(var24[var8]);
                     } else if(var14 == 4) {
                        Client.field327.method3124(225);
                        Client.field327.method2842(var24[var8]);
                        Client.field327.method3048(0);
                     } else if(var14 == 6) {
                        Client.field327.method3124(58);
                        Client.field327.method2887(var24[var8]);
                        Client.field327.method2880(0);
                     } else if(var14 == 7) {
                        Client.field327.method3124(53);
                        Client.field327.method2880(0);
                        Client.field327.method2889(var24[var8]);
                     }

                     var7 = true;
                     break;
                  }
               }

               if(!var7) {
                  class140.sendGameMessage(4, "", "Unable to find " + var15);
               }

               return 1;
            } else if(var0 == 3108) {
               class101.field1648 -= 3;
               var14 = class32.field729[class101.field1648];
               var21 = class32.field729[class101.field1648 + 1];
               var5 = class32.field729[class101.field1648 + 2];
               Widget var16 = class140.method2681(var5);
               FileOnDisk.method1487(var16, var14, var21);
               return 1;
            } else if(var0 == 3109) {
               class101.field1648 -= 2;
               var14 = class32.field729[class101.field1648];
               var21 = class32.field729[class101.field1648 + 1];
               Widget var25 = var2?class32.field719:class185.field2760;
               FileOnDisk.method1487(var25, var14, var21);
               return 1;
            } else if(var0 == 3110) {
               class36.field769 = class32.field729[--class101.field1648] == 1;
               return 1;
            } else if(var0 == 3111) {
               class32.field729[++class101.field1648 - 1] = WallObject.field1551.field689?1:0;
               return 1;
            } else if(var0 == 3112) {
               WallObject.field1551.field689 = class32.field729[--class101.field1648] == 1;
               DecorativeObject.method1977();
               return 1;
            } else if(var0 == 3113) {
               var3 = class32.scriptStringStack[--World.scriptStringStackSize];
               boolean var4 = class32.field729[--class101.field1648] == 1;
               if(var4) {
                  if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                     try {
                        Desktop.getDesktop().browse(new URI(var3));
                        return 1;
                     } catch (Exception var19) {
                        ;
                     }
                  }

                  if(class114.field1787.startsWith("win")) {
                     class5.method84(var3, 0);
                  } else if(class114.field1787.startsWith("mac")) {
                     ChatMessages.method934(var3, 1, "openjs");
                  } else {
                     class5.method84(var3, 2);
                  }
               } else {
                  class5.method84(var3, 3);
               }

               return 1;
            } else if(var0 == 3115) {
               var14 = class32.field729[--class101.field1648];
               Client.field327.method3124(172);
               Client.field327.method2842(var14);
               return 1;
            } else if(var0 == 3116) {
               var14 = class32.field729[--class101.field1648];
               World.scriptStringStackSize -= 2;
               var15 = class32.scriptStringStack[World.scriptStringStackSize];
               String var18 = class32.scriptStringStack[World.scriptStringStackSize + 1];
               if(var15.length() > 500) {
                  return 1;
               } else if(var18.length() > 500) {
                  return 1;
               } else {
                  Client.field327.method3124(75);
                  Client.field327.method2842(1 + class25.method615(var15) + class25.method615(var18));
                  Client.field327.method2893(var18);
                  Client.field327.method2893(var15);
                  Client.field327.method2880(var14);
                  return 1;
               }
            } else if(var0 == 3117) {
               Client.field433 = class32.field729[--class101.field1648] == 1;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }
}
