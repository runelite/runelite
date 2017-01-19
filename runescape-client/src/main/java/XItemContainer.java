import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("s")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("c")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("hi")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("f")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("if")
   static Widget field130;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      longValue = 5122233448423515875L
   )
   static long field133;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 1312631455
   )
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2100032069"
   )
   public static void method136(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3223 = var0.readUnsignedByte();
      var2.field3225 = var0.method2727();
      var2.field3226 = new int[var2.field3223];
      var2.field3224 = new int[var2.field3223];
      var2.fields = new Field[var2.field3223];
      var2.field3227 = new int[var2.field3223];
      var2.methods = new Method[var2.field3223];
      var2.args = new byte[var2.field3223][][];

      for(int var3 = 0; var3 < var2.field3223; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2911();
                  var6 = var0.method2911();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2911();
                  }

                  String var20 = var0.method2911();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2727();
                        var10[var11] = new byte[var12];
                        var0.method2824(var10[var11], 0, var12);
                     }
                  }

                  var2.field3226[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = BufferProvider.method3914(var8[var12]);
                  }

                  Class var22 = BufferProvider.method3914(var20);
                  if(BufferProvider.method3914(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = BufferProvider.method3914(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(var16.getName().equals(var6)) {
                        Class[] var17 = var16.getParameterTypes();
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var17[var19] != var21[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.args[var3] = var10;
               }
            } else {
               var5 = var0.method2911();
               var6 = var0.method2911();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2727();
               }

               var2.field3226[var3] = var4;
               var2.field3227[var3] = var7;
               if(BufferProvider.method3914(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = BufferProvider.method3914(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3224[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3224[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3224[var3] = -3;
         } catch (Exception var27) {
            var2.field3224[var3] = -4;
         } catch (Throwable var28) {
            var2.field3224[var3] = -5;
         }
      }

      class227.field3231.method2292(var2);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "613346144"
   )
   static final void method143() {
      if(Client.widgetRoot != -1) {
         MessageNode.method185(Client.widgetRoot);
      }

      int var0;
      for(var0 = 0; var0 < Client.field404; ++var0) {
         if(Client.field497[var0]) {
            Client.field294[var0] = true;
         }

         Client.field561[var0] = Client.field497[var0];
         Client.field497[var0] = false;
      }

      Client.field496 = Client.gameCycle;
      Client.field440 = -1;
      Client.field441 = -1;
      class179.field2694 = null;
      int var1;
      int var2;
      int var3;
      if(Client.widgetRoot != -1) {
         Client.field404 = 0;
         var0 = Client.widgetRoot;
         var1 = class16.field186;
         var2 = ChatMessages.field907;
         if(!class109.method1999(var0)) {
            for(var3 = 0; var3 < 100; ++var3) {
               Client.field497[var3] = true;
            }
         } else {
            class94.field1581 = null;
            class0.gameDraw(Widget.widgets[var0], -1, 0, 0, var1, var2, 0, 0, -1);
            if(null != class94.field1581) {
               class0.gameDraw(class94.field1581, -1412584499, 0, 0, var1, var2, FrameMap.field1473, class0.field8, -1);
               class94.field1581 = null;
            }
         }
      }

      Rasterizer2D.method3843();
      if(!Client.isMenuOpen) {
         if(Client.field440 != -1) {
            DecorativeObject.method1862(Client.field440, Client.field441);
         }
      } else {
         var0 = Client.menuX;
         var1 = class6.menuY;
         var2 = class5.menuWidth;
         var3 = ChatMessages.menuHeight;
         int var4 = 6116423;
         Rasterizer2D.method3876(var0, var1, var2, var3, var4);
         Rasterizer2D.method3876(1 + var0, 1 + var1, var2 - 2, 16, 0);
         Rasterizer2D.method3863(1 + var0, 18 + var1, var2 - 2, var3 - 19, 0);
         class16.field187.method3727("Choose Option", 3 + var0, 14 + var1, var4, -1);
         int var5 = class115.field1810;
         int var6 = class115.field1803;

         for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
            int var8 = var1 + 31 + 15 * (Client.menuOptionCount - 1 - var7);
            int var9 = 16777215;
            if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
               var9 = 16776960;
            }

            class16.field187.method3727(class3.method38(var7), var0 + 3, var8, var9, 0);
         }

         class13.method150(Client.menuX, class6.menuY, class5.menuWidth, ChatMessages.menuHeight);
      }

      if(Client.field504 == 3) {
         for(var0 = 0; var0 < Client.field404; ++var0) {
            if(Client.field561[var0]) {
               Rasterizer2D.method3849(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field294[var0]) {
               Rasterizer2D.method3849(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      class7.method84(class118.plane, localPlayer.x, localPlayer.y, Client.field533);
      Client.field533 = 0;
   }

   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1428177029"
   )
   static void method144(int var0) {
      for(class133 var1 = (class133)Client.widgetFlags.method2283(); null != var1; var1 = (class133)Client.widgetFlags.method2277()) {
         if((var1.hash >> 48 & 65535L) == (long)var0) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "1179831317"
   )
   static final void method146(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class36.field771.length; ++var2) {
         class36.field771[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class36.field771[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class221.field3193[var5] = (class36.field771[1 + var5] + class36.field771[var5 - 1] + class36.field771[var5 - 128] + class36.field771[var5 + 128]) / 4;
            }
         }

         int[] var8 = class36.field771;
         class36.field771 = class221.field3193;
         class221.field3193 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var0.offsetX + var4 + 16;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = var5 + (var6 << 7);
                  class36.field771[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "2141245874"
   )
   public static int method147(String var0) {
      return var0.length() + 2;
   }
}
