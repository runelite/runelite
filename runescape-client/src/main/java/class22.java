import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class22 extends class119 {
   @ObfuscatedName("hk")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("dd")
   static int[] field266;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1808174658"
   )
   public static void method231() {
      Sequence.field3068.reset();
      Sequence.field3057.reset();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-1593579874"
   )
   protected boolean vmethod2329(int var1, int var2, int var3, CollisionData var4) {
      return super.field1859 == var2 && var3 == super.field1858;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1208078526"
   )
   static void method235() {
      Client var0 = Client.field308;
      synchronized(Client.field308) {
         Container var1 = Client.field308.method2169();
         if(var1 != null) {
            class16.field208 = Math.max(var1.getSize().width, class172.field2340);
            class178.field2668 = Math.max(var1.getSize().height, class105.field1731);
            Insets var2;
            if(class16.field206 == var1) {
               var2 = class16.field206.getInsets();
               class16.field208 -= var2.right + var2.left;
               class178.field2668 -= var2.top + var2.bottom;
            }

            if(class16.field208 <= 0) {
               class16.field208 = 1;
            }

            if(class178.field2668 <= 0) {
               class178.field2668 = 1;
            }

            if(class13.method196() == 1) {
               class108.field1748 = Client.field528;
               class145.field2018 = Client.field330;
            } else {
               class108.field1748 = Math.min(class16.field208, 7680);
               class145.field2018 = Math.min(class178.field2668, 2160);
            }

            GameEngine.field1785 = (class16.field208 - class108.field1748) / 2;
            GameEngine.field1790 = 0;
            CollisionData.canvas.setSize(class108.field1748, class145.field2018);
            Frames.bufferProvider = CombatInfo2.method3547(class108.field1748, class145.field2018, CollisionData.canvas);
            if(class16.field206 == var1) {
               var2 = class16.field206.getInsets();
               CollisionData.canvas.setLocation(var2.left + GameEngine.field1785, GameEngine.field1790 + var2.top);
            } else {
               CollisionData.canvas.setLocation(GameEngine.field1785, GameEngine.field1790);
            }

            class188.method3460();
            if(Client.widgetRoot != -1) {
               class94.method1978(true);
            }

            TextureProvider.method1515();
         }
      }
   }

   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-100"
   )
   static void method237(Buffer var0, int var1) {
      class0.method2(var0.payload, var1);
      if(class104.field1695 != null) {
         try {
            class104.field1695.method1446(0L);
            class104.field1695.method1450(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-2021386542"
   )
   static final void method238(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class15.field185.method3930(var0, 250);
      int var6 = class15.field185.method3879(var0, 250) * 13;
      Rasterizer2D.method4028(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 0);
      Rasterizer2D.method4010(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      class15.field185.method3916(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      WidgetNode.method208(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
      if(var1) {
         try {
            Graphics var7 = CollisionData.canvas.getGraphics();
            Frames.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var13) {
            CollisionData.canvas.repaint();
         }
      } else {
         int var12 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field311; ++var11) {
            if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var12 && Client.widgetPositionX[var11] < var9 + var12 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
               Client.field488[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LFloorUnderlayDefinition;",
      garbageValue = "-349106909"
   )
   public static FloorUnderlayDefinition method239(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2802.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.field2806.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(null != var2) {
            var1.method3487(new Buffer(var2), var0);
         }

         var1.method3486();
         FloorUnderlayDefinition.field2802.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "423720064"
   )
   static int method240(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class26.field624:class32.field754;
      if(var0 == 1500) {
         class32.field756[++class32.field752 - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class32.field756[++class32.field752 - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class32.field756[++class32.field752 - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class32.field756[++class32.field752 - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class32.field756[++class32.field752 - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class32.field756[++class32.field752 - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)[B",
      garbageValue = "30"
   )
   public static byte[] method241(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(var4 == 8364) {
            var2[var3] = -128;
         } else if(var4 == 8218) {
            var2[var3] = -126;
         } else if(var4 == 402) {
            var2[var3] = -125;
         } else if(var4 == 8222) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(var4 == 710) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(var4 == 8249) {
            var2[var3] = -117;
         } else if(var4 == 338) {
            var2[var3] = -116;
         } else if(var4 == 381) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(var4 == 8217) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(var4 == 353) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(var4 == 382) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1830153135"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class5.method80(var0, var1, var2, var3, var4, var5, false);
   }
}
