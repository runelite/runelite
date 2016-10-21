import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class50 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1887456865
   )
   public int field1092;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1014596999
   )
   public int field1093;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -312288319
   )
   public int field1094;
   @ObfuscatedName("f")
   public static class170 field1095;
   @ObfuscatedName("e")
   static NodeCache field1097 = new NodeCache(64);

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "655029947"
   )
   static final void method1014(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field482; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field526[var4] = true;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "73"
   )
   void method1015(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method1016(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2066705131"
   )
   void method1016(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1092 = var1.method2535();
         this.field1094 = var1.method2656();
         this.field1093 = var1.method2656();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModIcon;B)V",
      garbageValue = "1"
   )
   static final void method1017(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < ChatLineBuffer.field685.length; ++var2) {
         ChatLineBuffer.field685[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         ChatLineBuffer.field685[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class188.field3046[var5] = (ChatLineBuffer.field685[128 + var5] + ChatLineBuffer.field685[var5 - 128] + ChatLineBuffer.field685[var5 - 1] + ChatLineBuffer.field685[1 + var5]) / 4;
            }
         }

         int[] var8 = ChatLineBuffer.field685;
         ChatLineBuffer.field685 = class188.field3046;
         class188.field3046 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var0.offsetX + 16 + var4;
                  int var6 = var0.offsetY + var3 + 16;
                  int var7 = var5 + (var6 << 7);
                  ChatLineBuffer.field685[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "-2030409328"
   )
   public static void method1025(class170 var0, class170 var1, class170 var2) {
      class51.field1102 = var0;
      class51.field1099 = var1;
      Ignore.field131 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "74"
   )
   public static int method1027(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1359174708"
   )
   static final int method1028(int var0, int var1) {
      int var2 = BufferProvider.method1728(var0 - 1, var1 - 1) + BufferProvider.method1728(var0 + 1, var1 - 1) + BufferProvider.method1728(var0 - 1, var1 + 1) + BufferProvider.method1728(var0 + 1, var1 + 1);
      int var3 = BufferProvider.method1728(var0 - 1, var1) + BufferProvider.method1728(1 + var0, var1) + BufferProvider.method1728(var0, var1 - 1) + BufferProvider.method1728(var0, var1 + 1);
      int var4 = BufferProvider.method1728(var0, var1);
      return var4 / 4 + var3 / 8 + var2 / 16;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "523036285"
   )
   static void method1030() {
      int var0 = GameEngine.field2248;
      int var1 = GameEngine.field2245;
      int var2 = Sequence.field1010 - class153.field2296 - var0;
      int var3 = class130.field2099 - class93.field1616 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field442.method3047();
            int var5 = 0;
            int var6 = 0;
            if(CollisionData.field1956 == var4) {
               Insets var7 = CollisionData.field1956.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class130.field2099);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, Sequence.field1010, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + Sequence.field1010 - var2, var6, var2, class130.field2099);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class130.field2099 + var6 - var3, Sequence.field1010, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }
}
