import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class143 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1627448867
   )
   public static int field2198 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 4918194927816958645L
   )
   static volatile long field2199 = 0L;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1572126849
   )
   public static volatile int field2200 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -844121721
   )
   static volatile int field2201 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 788563685
   )
   static volatile int field2202 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2011641197
   )
   public static int field2203 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 936881863
   )
   public static int field2204 = 0;
   @ObfuscatedName("my")
   static SpritePixels field2205;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 450813403
   )
   static volatile int field2206 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1628218569
   )
   static volatile int field2207 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 2591427944093743893L
   )
   public static long field2208 = 0L;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -118551003
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1549463961
   )
   public static int field2210 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1463924521
   )
   public static int field2211 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -520257225
   )
   static volatile int field2212 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1281262595
   )
   public static int field2213 = 0;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = -865586889
   )
   static int field2214;
   @ObfuscatedName("nd")
   static class77 field2215;
   @ObfuscatedName("w")
   static int[] field2219;
   @ObfuscatedName("r")
   @Export("mouse")
   public static class143 mouse = new class143();

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2201 = var1.getX();
         field2202 = var1.getY();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2207 = var1.getX();
         field2212 = var1.getY();
         field2199 = class34.method713();
         if(var1.isAltDown()) {
            field2206 = 4;
            field2200 = 4;
         } else if(var1.isMetaDown()) {
            field2206 = 2;
            field2200 = 2;
         } else {
            field2206 = 1;
            field2200 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2200 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != mouse) {
         field2200 = 0;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2201 = var1.getX();
         field2202 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2201 = -1;
         field2202 = -1;
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2201 = var1.getX();
         field2202 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2114152060"
   )
   public static void method3023(boolean var0) {
      if(ItemComposition.isMembersWorld != var0) {
         ItemComposition.field1159.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         ItemComposition.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "-1257898458"
   )
   public static String method3024(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "-65"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Widget var12;
      if(var2 == 25) {
         var12 = class166.method3265(var1, var0);
         if(null != var12) {
            class85.method1926();
            class34.method703(var1, var0, class77.method1637(class132.method2880(var12)), var12.item);
            Client.field432 = 0;
            Client.field437 = Item.method656(var12);
            if(Client.field437 == null) {
               Client.field437 = "Null";
            }

            if(var12.field2809) {
               Client.field438 = var12.name + class154.method3185(16777215);
            } else {
               Client.field438 = class154.method3185('\uff00') + var12.field2926 + class154.method3185(16777215);
            }
         }

      } else {
         Player var8;
         if(var2 == 46) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(213);
               Client.field323.method2589(var3);
               Client.field323.method2580(class140.field2167[82]?1:0);
            }
         }

         NPC var11;
         if(var2 == 13) {
            var11 = Client.cachedNPCs[var3];
            if(null != var11) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(199);
               Client.field323.method2661(var3);
               Client.field323.method2758(class140.field2167[82]?1:0);
            }
         }

         if(var2 == 50) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(219);
               Client.field323.method2715(class140.field2167[82]?1:0);
               Client.field323.method2661(var3);
            }
         }

         int var9;
         if(var2 == 28) {
            Client.field323.method2818(25);
            Client.field323.method2544(var1);
            var12 = World.method628(var1);
            if(null != var12.dynamicValues && var12.dynamicValues[0][0] == 5) {
               var9 = var12.dynamicValues[0][1];
               class179.widgetSettings[var9] = 1 - class179.widgetSettings[var9];
               Widget.method3468(var9);
            }
         }

         if(var2 == 8) {
            var11 = Client.cachedNPCs[var3];
            if(var11 != null) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(88);
               Client.field323.method2582(class140.field2167[82]?1:0);
               Client.field323.method2589(Client.field482);
               Client.field323.method2722(XClanMember.field626);
               Client.field323.method2589(var3);
            }
         }

         if(var2 == 37) {
            Client.field323.method2818(39);
            Client.field323.method2588(var0);
            Client.field323.method2544(var1);
            Client.field323.method2661(var3);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 23) {
            Projectile.region.method1985(FrameMap.plane, var0, var1);
         }

         if(var2 == 40) {
            Client.field323.method2818(252);
            Client.field323.method2589(var0);
            Client.field323.method2588(var3);
            Client.field323.method2733(var1);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 7) {
            var11 = Client.cachedNPCs[var3];
            if(null != var11) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(209);
               Client.field323.method2661(class110.field1944);
               Client.field323.method2661(var3);
               Client.field323.method2544(class119.field2040);
               Client.field323.method2589(class75.field1391);
               Client.field323.method2580(class140.field2167[82]?1:0);
            }
         }

         if(var2 == 48) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(208);
               Client.field323.method2589(var3);
               Client.field323.method2582(class140.field2167[82]?1:0);
            }
         }

         if(var2 == 39) {
            Client.field323.method2818(150);
            Client.field323.method2575(var1);
            Client.field323.method2542(var3);
            Client.field323.method2661(var0);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 35) {
            Client.field323.method2818(203);
            Client.field323.method2575(var1);
            Client.field323.method2588(var3);
            Client.field323.method2588(var0);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 42) {
            Client.field323.method2818(197);
            Client.field323.method2575(var1);
            Client.field323.method2589(var3);
            Client.field323.method2661(var0);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 26) {
            FrameMap.method2348();
         }

         if(var2 == 47) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(104);
               Client.field323.method2661(var3);
               Client.field323.method2582(class140.field2167[82]?1:0);
            }
         }

         if(var2 == 43) {
            Client.field323.method2818(189);
            Client.field323.method2733(var1);
            Client.field323.method2589(var0);
            Client.field323.method2589(var3);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 1003) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            var11 = Client.cachedNPCs[var3];
            if(null != var11) {
               NPCComposition var10 = var11.composition;
               if(null != var10.field914) {
                  var10 = var10.method779();
               }

               if(null != var10) {
                  Client.field323.method2818(198);
                  Client.field323.method2588(var10.id);
               }
            }
         }

         if(var2 == 29) {
            Client.field323.method2818(25);
            Client.field323.method2544(var1);
            var12 = World.method628(var1);
            if(null != var12.dynamicValues && var12.dynamicValues[0][0] == 5) {
               var9 = var12.dynamicValues[0][1];
               if(var12.field2924[0] != class179.widgetSettings[var9]) {
                  class179.widgetSettings[var9] = var12.field2924[0];
                  Widget.method3468(var9);
               }
            }
         }

         if(var2 == 21) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(183);
            Client.field323.method2580(class140.field2167[82]?1:0);
            Client.field323.method2589(var3);
            Client.field323.method2588(var1 + class159.baseY);
            Client.field323.method2588(class28.baseX + var0);
         }

         if(var2 == 15) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(7);
               Client.field323.method2542(var3);
               Client.field323.method2542(Client.field482);
               Client.field323.method2580(class140.field2167[82]?1:0);
               Client.field323.method2733(XClanMember.field626);
            }
         }

         if(var2 == 51) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(90);
               Client.field323.method2580(class140.field2167[82]?1:0);
               Client.field323.method2589(var3);
            }
         }

         if(var2 == 12) {
            var11 = Client.cachedNPCs[var3];
            if(null != var11) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(4);
               Client.field323.method2715(class140.field2167[82]?1:0);
               Client.field323.method2589(var3);
            }
         }

         if(var2 == 3) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(86);
            Client.field323.method2589(var1 + class159.baseY);
            Client.field323.method2661(var3 >> 14 & 32767);
            Client.field323.method2758(class140.field2167[82]?1:0);
            Client.field323.method2588(var0 + class28.baseX);
         }

         if(var2 == 30 && Client.field443 == null) {
            class12.method152(var1, var0);
            Client.field443 = class166.method3265(var1, var0);
            class75.method1606(Client.field443);
         }

         if(var2 == 9) {
            var11 = Client.cachedNPCs[var3];
            if(var11 != null) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(254);
               Client.field323.method2715(class140.field2167[82]?1:0);
               Client.field323.method2588(var3);
            }
         }

         if(var2 == 31) {
            Client.field323.method2818(125);
            Client.field323.method2542(class110.field1944);
            Client.field323.method2588(var3);
            Client.field323.method2542(var0);
            Client.field323.method2544(var1);
            Client.field323.method2589(class75.field1391);
            Client.field323.method2733(class119.field2040);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 44) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(176);
               Client.field323.method2589(var3);
               Client.field323.method2582(class140.field2167[82]?1:0);
            }
         }

         if(var2 == 6) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(103);
            Client.field323.method2715(class140.field2167[82]?1:0);
            Client.field323.method2661(var0 + class28.baseX);
            Client.field323.method2588(class159.baseY + var1);
            Client.field323.method2661(var3 >> 14 & 32767);
         }

         if(var2 == 33) {
            Client.field323.method2818(71);
            Client.field323.method2722(var1);
            Client.field323.method2542(var3);
            Client.field323.method2588(var0);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 1002) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.field323.method2818(30);
            Client.field323.method2661(var3 >> 14 & 32767);
         }

         if(var2 == 1) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(239);
            Client.field323.method2588(var1 + class159.baseY);
            Client.field323.method2661(var0 + class28.baseX);
            Client.field323.method2589(class75.field1391);
            Client.field323.method2542(class110.field1944);
            Client.field323.method2588(var3 >> 14 & 32767);
            Client.field323.method2733(class119.field2040);
            Client.field323.method2582(class140.field2167[82]?1:0);
         }

         if(var2 == 22) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(177);
            Client.field323.method2588(class28.baseX + var0);
            Client.field323.method2542(var3);
            Client.field323.method2589(class159.baseY + var1);
            Client.field323.method2582(class140.field2167[82]?1:0);
         }

         if(var2 == 1004) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.field323.method2818(225);
            Client.field323.method2589(var3);
         }

         if(var2 == 20) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(222);
            Client.field323.method2661(var0 + class28.baseX);
            Client.field323.method2542(var1 + class159.baseY);
            Client.field323.method2580(class140.field2167[82]?1:0);
            Client.field323.method2542(var3);
         }

         if(var2 == 1001) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(82);
            Client.field323.method2542(class159.baseY + var1);
            Client.field323.method2580(class140.field2167[82]?1:0);
            Client.field323.method2661(var3 >> 14 & 32767);
            Client.field323.method2661(var0 + class28.baseX);
         }

         if(var2 == 36) {
            Client.field323.method2818(224);
            Client.field323.method2542(var0);
            Client.field323.method2542(var3);
            Client.field323.method2722(var1);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 45) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(147);
               Client.field323.method2588(var3);
               Client.field323.method2715(class140.field2167[82]?1:0);
            }
         }

         if(var2 == 1005) {
            var12 = World.method628(var1);
            if(var12 != null && var12.itemQuantities[var0] >= 100000) {
               class23.sendGameMessage(27, "", var12.itemQuantities[var0] + " x " + MessageNode.getItemDefinition(var3).name);
            } else {
               Client.field323.method2818(225);
               Client.field323.method2589(var3);
            }

            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 58) {
            var12 = class166.method3265(var1, var0);
            if(var12 != null) {
               Client.field323.method2818(96);
               Client.field323.method2661(Client.field436);
               Client.field323.method2661(var0);
               Client.field323.method2575(XClanMember.field626);
               Client.field323.method2544(var1);
               Client.field323.method2542(Client.field482);
               Client.field323.method2542(var12.item);
            }
         }

         if(var2 == 41) {
            Client.field323.method2818(142);
            Client.field323.method2733(var1);
            Client.field323.method2542(var3);
            Client.field323.method2661(var0);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 18) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(141);
            Client.field323.method2542(var1 + class159.baseY);
            Client.field323.method2715(class140.field2167[82]?1:0);
            Client.field323.method2588(var3);
            Client.field323.method2588(var0 + class28.baseX);
         }

         if(var2 == 5) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(54);
            Client.field323.method2661(class159.baseY + var1);
            Client.field323.method2589(var3 >> 14 & 32767);
            Client.field323.method2758(class140.field2167[82]?1:0);
            Client.field323.method2588(var0 + class28.baseX);
         }

         if(var2 == 49) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(241);
               Client.field323.method2758(class140.field2167[82]?1:0);
               Client.field323.method2588(var3);
            }
         }

         if(var2 == 2) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(172);
            Client.field323.method2715(class140.field2167[82]?1:0);
            Client.field323.method2588(Client.field482);
            Client.field323.method2589(class159.baseY + var1);
            Client.field323.method2544(XClanMember.field626);
            Client.field323.method2661(var3 >> 14 & 32767);
            Client.field323.method2589(var0 + class28.baseX);
         }

         if(var2 == 4) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(134);
            Client.field323.method2542(var3 >> 14 & 32767);
            Client.field323.method2588(class28.baseX + var0);
            Client.field323.method2589(var1 + class159.baseY);
            Client.field323.method2580(class140.field2167[82]?1:0);
         }

         if(var2 == 10) {
            var11 = Client.cachedNPCs[var3];
            if(var11 != null) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(218);
               Client.field323.method2589(var3);
               Client.field323.method2715(class140.field2167[82]?1:0);
            }
         }

         if(var2 == 34) {
            Client.field323.method2818(70);
            Client.field323.method2661(var3);
            Client.field323.method2588(var0);
            Client.field323.method2733(var1);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 14) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(234);
               Client.field323.method2542(class75.field1391);
               Client.field323.method2588(var3);
               Client.field323.method2544(class119.field2040);
               Client.field323.method2542(class110.field1944);
               Client.field323.method2580(class140.field2167[82]?1:0);
            }
         }

         if(var2 == 16) {
            Client.field334 = var6;
            Client.field390 = var7;
            Client.field465 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2818(135);
            Client.field323.method2589(var3);
            Client.field323.method2542(var0 + class28.baseX);
            Client.field323.method2758(class140.field2167[82]?1:0);
            Client.field323.method2733(class119.field2040);
            Client.field323.method2589(class110.field1944);
            Client.field323.method2588(class75.field1391);
            Client.field323.method2542(class159.baseY + var1);
         }

         if(var2 == 32) {
            Client.field323.method2818(66);
            Client.field323.method2661(Client.field482);
            Client.field323.method2722(XClanMember.field626);
            Client.field323.method2575(var1);
            Client.field323.method2588(var0);
            Client.field323.method2661(var3);
            Client.field393 = 0;
            class168.field2725 = World.method628(var1);
            Client.field394 = var0;
         }

         if(var2 == 11) {
            var11 = Client.cachedNPCs[var3];
            if(null != var11) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(98);
               Client.field323.method2588(var3);
               Client.field323.method2715(class140.field2167[82]?1:0);
            }
         }

         if(var2 == 38) {
            class85.method1926();
            var12 = World.method628(var1);
            Client.field432 = 1;
            class75.field1391 = var0;
            class119.field2040 = var1;
            class110.field1944 = var3;
            class75.method1606(var12);
            Client.field433 = class154.method3185(16748608) + MessageNode.getItemDefinition(var3).name + class154.method3185(16777215);
            if(Client.field433 == null) {
               Client.field433 = "null";
            }

         } else {
            if(var2 == 24) {
               var12 = World.method628(var1);
               boolean var13 = true;
               if(var12.contentType > 0) {
                  var13 = class118.method2499(var12);
               }

               if(var13) {
                  Client.field323.method2818(25);
                  Client.field323.method2544(var1);
               }
            }

            if(var2 == 17) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(12);
               Client.field323.method2588(var1 + class159.baseY);
               Client.field323.method2758(class140.field2167[82]?1:0);
               Client.field323.method2542(Client.field482);
               Client.field323.method2722(XClanMember.field626);
               Client.field323.method2588(var3);
               Client.field323.method2589(var0 + class28.baseX);
            }

            if(var2 == 57 || var2 == 1007) {
               var12 = class166.method3265(var1, var0);
               if(null != var12) {
                  class18.method198(var3, var1, var0, var12.item, var5);
               }
            }

            if(var2 == 19) {
               Client.field334 = var6;
               Client.field390 = var7;
               Client.field465 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2818(73);
               Client.field323.method2589(var3);
               Client.field323.method2588(class159.baseY + var1);
               Client.field323.method2582(class140.field2167[82]?1:0);
               Client.field323.method2588(class28.baseX + var0);
            }

            if(Client.field432 != 0) {
               Client.field432 = 0;
               class75.method1606(World.method628(class119.field2040));
            }

            if(Client.field404) {
               class85.method1926();
            }

            if(class168.field2725 != null && Client.field393 == 0) {
               class75.method1606(class168.field2725);
            }

         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1354880340"
   )
   static final int method3026(int var0, int var1) {
      int var2 = class161.method3205(var0 - 1, var1 - 1) + class161.method3205(1 + var0, var1 - 1) + class161.method3205(var0 - 1, var1 + 1) + class161.method3205(1 + var0, 1 + var1);
      int var3 = class161.method3205(var0 - 1, var1) + class161.method3205(1 + var0, var1) + class161.method3205(var0, var1 - 1) + class161.method3205(var0, var1 + 1);
      int var4 = class161.method3205(var0, var1);
      return var4 / 4 + var2 / 16 + var3 / 8;
   }
}
