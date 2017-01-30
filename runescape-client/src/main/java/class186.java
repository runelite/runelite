import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class186 extends CacheableNode {
   @ObfuscatedName("nk")
   static class57 field2763;
   @ObfuscatedName("g")
   static NodeCache field2764 = new NodeCache(64);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -634196697
   )
   public int field2765 = 0;
   @ObfuscatedName("p")
   public static class182 field2767;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = 550542205
   )
   static int field2768;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "39"
   )
   public static int method3408(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2019581920"
   )
   void method3409(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2765 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1051966224"
   )
   void method3412(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3409(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "-1525965433"
   )
   public static SpritePixels method3417(class182 var0, int var1, int var2) {
      return !class196.method3575(var0, var1, var2)?null:MessageNode.method200();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)LModIcon;",
      garbageValue = "-76"
   )
   public static ModIcon method3418() {
      ModIcon var0 = new ModIcon();
      var0.width = class225.field3214;
      var0.originalHeight = NPC.field761;
      var0.offsetX = class225.field3216[0];
      var0.offsetY = class225.field3215[0];
      var0.originalWidth = class22.field231[0];
      var0.height = class225.field3218[0];
      var0.palette = class183.field2719;
      var0.pixels = class48.field949[0];
      class225.field3216 = null;
      class225.field3215 = null;
      class22.field231 = null;
      class225.field3218 = null;
      class183.field2719 = null;
      class48.field949 = null;
      return var0;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   static void method3419() {
      Client var0 = class88.field1536;
      synchronized(class88.field1536) {
         Container var1 = class88.field1536.method2114();
         if(null != var1) {
            class40.field813 = Math.max(var1.getSize().width, GameEngine.field1770);
            class8.field75 = Math.max(var1.getSize().height, class97.field1637);
            if(class15.field163 == var1) {
               Insets var2 = class15.field163.getInsets();
               class40.field813 -= var2.right + var2.left;
               class8.field75 -= var2.top + var2.bottom;
            }

            if(class40.field813 <= 0) {
               class40.field813 = 1;
            }

            if(class8.field75 <= 0) {
               class8.field75 = 1;
            }

            int var10 = Client.isResized?2:1;
            if(var10 == 1) {
               class26.field577 = Client.field492;
               class187.field2776 = Client.field493;
            } else {
               class26.field577 = Math.min(class40.field813, 7680);
               class187.field2776 = Math.min(class8.field75, 2160);
            }

            GameEngine.field1779 = (class40.field813 - class26.field577) / 2;
            GameEngine.field1780 = 0;
            class157.canvas.setSize(class26.field577, class187.field2776);
            int var4 = class26.field577;
            int var5 = class187.field2776;
            Canvas var6 = class157.canvas;

            Object var3;
            try {
               MainBufferProvider var7 = new MainBufferProvider();
               var7.init(var4, var5, var6);
               var3 = var7;
            } catch (Throwable var11) {
               SecondaryBufferProvider var8 = new SecondaryBufferProvider();
               var8.init(var4, var5, var6);
               var3 = var8;
            }

            class57.bufferProvider = (BufferProvider)var3;
            if(class15.field163 == var1) {
               Insets var13 = class15.field163.getInsets();
               class157.canvas.setLocation(GameEngine.field1779 + var13.left, GameEngine.field1780 + var13.top);
            } else {
               class157.canvas.setLocation(GameEngine.field1779, GameEngine.field1780);
            }

            class33.method685();
            if(Client.widgetRoot != -1) {
               class41.method756(true);
            }

            class114.method2204();
         }
      }
   }
}
