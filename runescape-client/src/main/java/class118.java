import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class118 {
   @ObfuscatedName("qt")
   protected static java.awt.Frame field2008;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 6000103790125884763L
   )
   static long field2009;

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-718618775"
   )
   static void method2422() {
      Client var0 = Client.field389;
      synchronized(Client.field389) {
         Container var1 = Client.field389.method3063();
         if(var1 != null) {
            class177.field2942 = Math.max(var1.getSize().width, class157.field2334);
            class137.field2111 = Math.max(var1.getSize().height, XClanMember.field613);
            if(var1 == field2008) {
               Insets var2 = field2008.getInsets();
               class177.field2942 -= var2.left + var2.right;
               class137.field2111 -= var2.top + var2.bottom;
            }

            if(class177.field2942 <= 0) {
               class177.field2942 = 1;
            }

            if(class137.field2111 <= 0) {
               class137.field2111 = 1;
            }

            if(class158.method3158() == 1) {
               class50.field1069 = Client.field483;
               class139.field2143 = Client.field484 * 503;
            } else {
               class50.field1069 = Math.min(class177.field2942, 7680);
               class139.field2143 = Math.min(class137.field2111, 2160);
            }

            GameEngine.field2239 = (class177.field2942 - class50.field1069) / 2;
            GameEngine.field2240 = 0;
            Frames.canvas.setSize(class50.field1069, class139.field2143);
            int var3 = class50.field1069;
            int var4 = class139.field2143;
            Canvas var5 = Frames.canvas;

            Object var15;
            try {
               MainBufferProvider var6 = new MainBufferProvider();
               var6.init(var3, var4, var5);
               var15 = var6;
            } catch (Throwable var13) {
               SecondaryBufferProvider var7 = new SecondaryBufferProvider();
               var7.init(var3, var4, var5);
               var15 = var7;
            }

            Player.bufferProvider = (BufferProvider)var15;
            if(field2008 == var1) {
               Insets var16 = field2008.getInsets();
               Frames.canvas.setLocation(GameEngine.field2239 + var16.left, GameEngine.field2240 + var16.top);
            } else {
               Frames.canvas.setLocation(GameEngine.field2239, GameEngine.field2240);
            }

            int var10 = class50.field1069;
            int var11 = class139.field2143;
            if(class177.field2942 < var10) {
               var10 = class177.field2942;
            }

            if(class137.field2111 < var11) {
               var11 = class137.field2111;
            }

            if(null != Sequence.field984) {
               try {
                  class135.method2849(Client.field389, "resize", new Object[]{Integer.valueOf(class158.method3158())});
               } catch (Throwable var12) {
                  ;
               }
            }

            if(Client.widgetRoot != -1) {
               class11.method135(Client.widgetRoot, class50.field1069, class139.field2143, true);
            }

            class9.method121();
         }
      }
   }
}
