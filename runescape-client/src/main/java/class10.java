import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class10 extends class110 {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1338980993
   )
   static int field165;
   @ObfuscatedName("jx")
   static Widget[] field169;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 577181087
   )
   static int field171;
   @ObfuscatedName("bm")
   static class171 field172;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;S)Z",
      garbageValue = "150"
   )
   protected boolean vmethod2486(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field1951 && super.field1948 == var3;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;III)Lclass59;",
      garbageValue = "-937612401"
   )
   public static final class59 method141(class139 var0, Component var1, int var2, int var3) {
      if(class59.field1254 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1248 = new int[256 * (class59.field1264?2:1)];
            var4.field1253 = var3;
            var4.vmethod1627(var1);
            var4.field1252 = 1024 + (var3 & -1024);
            if(var4.field1252 > 16384) {
               var4.field1252 = 16384;
            }

            var4.vmethod1628(var4.field1252);
            if(class59.field1245 > 0 && null == class186.field3013) {
               class186.field3013 = new class75();
               class186.field3013.field1427 = var0;
               var0.method3029(class186.field3013, class59.field1245);
            }

            if(class186.field3013 != null) {
               if(class186.field3013.field1424[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class186.field3013.field1424[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class59();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "121"
   )
   static void method143() {
      Client var0 = Client.field477;
      Client var1 = Client.field477;
      synchronized(Client.field477) {
         Container var2 = Client.field477.method3174();
         if(null != var2) {
            SecondaryBufferProvider.field1450 = Math.max(var2.getSize().width, ItemLayer.field1757);
            class144.field2220 = Math.max(var2.getSize().height, class128.field2089);
            if(class114.field2013 == var2) {
               Insets var3 = class114.field2013.getInsets();
               SecondaryBufferProvider.field1450 -= var3.right + var3.left;
               class144.field2220 -= var3.top + var3.bottom;
            }

            if(SecondaryBufferProvider.field1450 <= 0) {
               SecondaryBufferProvider.field1450 = 1;
            }

            if(class144.field2220 <= 0) {
               class144.field2220 = 1;
            }

            if(class53.method1139() == 1) {
               class189.field3056 = Client.field508;
               Actor.field892 = Client.field321 * 503;
            } else {
               class189.field3056 = Math.min(SecondaryBufferProvider.field1450, 7680);
               Actor.field892 = Math.min(class144.field2220, 2160);
            }

            GameEngine.field2268 = (SecondaryBufferProvider.field1450 - class189.field3056) / 2;
            GameEngine.field2262 = 0;
            class107.canvas.setSize(class189.field3056, Actor.field892);
            int var13 = class189.field3056;
            int var4 = Actor.field892;
            Canvas var5 = class107.canvas;

            Object var6;
            try {
               MainBufferProvider var7 = new MainBufferProvider();
               var7.init(var13, var4, var5);
               var6 = var7;
            } catch (Throwable var11) {
               SecondaryBufferProvider var8 = new SecondaryBufferProvider();
               var8.init(var13, var4, var5);
               var6 = var8;
            }

            class54.bufferProvider = (BufferProvider)var6;
            if(var2 == class114.field2013) {
               Insets var14 = class114.field2013.getInsets();
               class107.canvas.setLocation(GameEngine.field2268 + var14.left, GameEngine.field2262 + var14.top);
            } else {
               class107.canvas.setLocation(GameEngine.field2268, GameEngine.field2262);
            }

            class4.method44();
            if(Client.widgetRoot != -1) {
               int var15 = Client.widgetRoot;
               int var16 = class189.field3056;
               int var9 = Actor.field892;
               if(class14.method179(var15)) {
                  class0.method2(Widget.widgets[var15], -1, var16, var9, true);
               }
            }

            RSCanvas.method3088();
         }

      }
   }
}
