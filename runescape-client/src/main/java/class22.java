import java.awt.Container;
import java.awt.Insets;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class22 implements Comparator {
   @ObfuscatedName("q")
   static int[][][] field590;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1928193751
   )
   static int field591;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "-16"
   )
   int method574(class217 var1, class217 var2) {
      if(var2.field3204 == var1.field3204) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3204 == Client.world) {
               return -1;
            }

            if(Client.world == var2.field3204) {
               return 1;
            }
         }

         return var1.field3204 < var2.field3204?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method574((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class22(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1001316650"
   )
   static void method580() {
      Client var0 = Client.field277;
      synchronized(Client.field277) {
         Container var1 = Client.field277.method3058();
         if(var1 != null) {
            class31.field720 = Math.max(var1.getSize().width, class93.field1648);
            class146.field2258 = Math.max(var1.getSize().height, class9.field151);
            Insets var2;
            if(WallObject.field1621 == var1) {
               var2 = WallObject.field1621.getInsets();
               class31.field720 -= var2.left + var2.right;
               class146.field2258 -= var2.bottom + var2.top;
            }

            if(class31.field720 <= 0) {
               class31.field720 = 1;
            }

            if(class146.field2258 <= 0) {
               class146.field2258 = 1;
            }

            if(class23.method586() == 1) {
               class159.field2374 = Client.field346;
               class92.field1643 = Client.field509 * 503;
            } else {
               class159.field2374 = Math.min(class31.field720, 7680);
               class92.field1643 = Math.min(class146.field2258, 2160);
            }

            GameEngine.field2270 = (class31.field720 - class159.field2374) / 2;
            GameEngine.field2263 = 0;
            class79.canvas.setSize(class159.field2374, class92.field1643);
            Buffer.bufferProvider = class1.method10(class159.field2374, class92.field1643, class79.canvas);
            if(WallObject.field1621 == var1) {
               var2 = WallObject.field1621.getInsets();
               class79.canvas.setLocation(var2.left + GameEngine.field2270, var2.top + GameEngine.field2263);
            } else {
               class79.canvas.setLocation(GameEngine.field2270, GameEngine.field2263);
            }

            class45.method950();
            if(Client.widgetRoot != -1) {
               class47.method989(Client.widgetRoot, class159.field2374, class92.field1643, true);
            }

            World.method666();
         }
      }
   }
}
