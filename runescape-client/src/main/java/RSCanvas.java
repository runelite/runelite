import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("ej")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("g")
   public static class170 field2197;
   @ObfuscatedName("l")
   Component field2201;

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   static final void method3079() {
      Client.field339.method2899();
      int var0 = Client.field339.method2907(8);
      int var1;
      if(var0 < Client.field486) {
         for(var1 = var0; var1 < Client.field486; ++var1) {
            Client.field388[++Client.field419 - 1] = Client.field334[var1];
         }
      }

      if(var0 > Client.field486) {
         throw new RuntimeException("");
      } else {
         Client.field486 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.field334[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.field339.method2907(1);
            if(var4 == 0) {
               Client.field334[++Client.field486 - 1] = var2;
               var3.field880 = Client.gameCycle;
            } else {
               int var5 = Client.field339.method2907(2);
               if(var5 == 0) {
                  Client.field334[++Client.field486 - 1] = var2;
                  var3.field880 = Client.gameCycle;
                  Client.field336[++Client.field454 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.field334[++Client.field486 - 1] = var2;
                     var3.field880 = Client.gameCycle;
                     var6 = Client.field339.method2907(3);
                     var3.method760(var6, (byte)1);
                     var7 = Client.field339.method2907(1);
                     if(var7 == 1) {
                        Client.field336[++Client.field454 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.field334[++Client.field486 - 1] = var2;
                     var3.field880 = Client.gameCycle;
                     var6 = Client.field339.method2907(3);
                     var3.method760(var6, (byte)2);
                     var7 = Client.field339.method2907(3);
                     var3.method760(var7, (byte)2);
                     int var8 = Client.field339.method2907(1);
                     if(var8 == 1) {
                        Client.field336[++Client.field454 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field388[++Client.field419 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   public final void paint(Graphics var1) {
      this.field2201.paint(var1);
   }

   public final void update(Graphics var1) {
      this.field2201.update(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-654859235"
   )
   public static void method3087() {
      class50.field1117.reset();
   }

   RSCanvas(Component var1) {
      this.field2201 = var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-312842563"
   )
   static void method3088() {
      int var0 = GameEngine.field2268;
      int var1 = GameEngine.field2262;
      int var2 = SecondaryBufferProvider.field1450 - class189.field3056 - var0;
      int var3 = class144.field2220 - Actor.field892 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field477.method3174();
            int var5 = 0;
            int var6 = 0;
            if(class114.field2013 == var4) {
               Insets var7 = class114.field2013.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class144.field2220);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, SecondaryBufferProvider.field1450, var1);
            }

            if(var2 > 0) {
               var9.fillRect(SecondaryBufferProvider.field1450 + var5 - var2, var6, var2, class144.field2220);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class144.field2220 + var6 - var3, SecondaryBufferProvider.field1450, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1223507582"
   )
   static void method3089() {
      for(class24 var0 = (class24)class24.field630.method3980(); var0 != null; var0 = (class24)class24.field630.method3970()) {
         if(null != var0.field622) {
            class20.field585.method1285(var0.field622);
            var0.field622 = null;
         }

         if(null != var0.field633) {
            class20.field585.method1285(var0.field633);
            var0.field633 = null;
         }
      }

      class24.field630.method3996();
   }
}
