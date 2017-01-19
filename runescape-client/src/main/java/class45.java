import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class45 {
   @ObfuscatedName("f")
   static byte[] field891 = new byte[2048];
   @ObfuscatedName("h")
   static byte[] field892 = new byte[2048];
   @ObfuscatedName("a")
   static Buffer[] field893 = new Buffer[2048];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -482627537
   )
   static int field894 = 0;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = 1307435255
   )
   protected static int field895;
   @ObfuscatedName("k")
   static int[] field896 = new int[2048];
   @ObfuscatedName("b")
   static int[] field897 = new int[2048];
   @ObfuscatedName("x")
   static int[] field898 = new int[2048];
   @ObfuscatedName("r")
   static int[] field899 = new int[2048];
   @ObfuscatedName("n")
   static int[] field900 = new int[2048];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1818072985
   )
   static int field901 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2072255751
   )
   static int field902 = 0;
   @ObfuscatedName("w")
   static Buffer field903 = new Buffer(new byte[5000]);
   @ObfuscatedName("j")
   static int[] field904 = new int[2048];

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1091619637"
   )
   static void method789() {
      Client var0 = class227.field3230;
      synchronized(class227.field3230) {
         Container var1 = class227.field3230.method2088();
         if(null != var1) {
            class15.field180 = Math.max(var1.getSize().width, class155.field2118);
            class25.field590 = Math.max(var1.getSize().height, class72.field1187);
            if(var1 == class118.field1855) {
               Insets var2 = class118.field1855.getInsets();
               class15.field180 -= var2.left + var2.right;
               class25.field590 -= var2.top + var2.bottom;
            }

            if(class15.field180 <= 0) {
               class15.field180 = 1;
            }

            if(class25.field590 <= 0) {
               class25.field590 = 1;
            }

            if(Tile.method1515() == 1) {
               class16.field186 = Client.field355;
               ChatMessages.field907 = Client.field508 * 503;
            } else {
               class16.field186 = Math.min(class15.field180, 7680);
               ChatMessages.field907 = Math.min(class25.field590, 2160);
            }

            GameEngine.field1780 = (class15.field180 - class16.field186) / 2;
            GameEngine.field1781 = 0;
            class25.canvas.setSize(class16.field186, ChatMessages.field907);
            int var3 = class16.field186;
            int var4 = ChatMessages.field907;
            Canvas var5 = class25.canvas;

            Object var11;
            try {
               MainBufferProvider var6 = new MainBufferProvider();
               var6.init(var3, var4, var5);
               var11 = var6;
            } catch (Throwable var9) {
               SecondaryBufferProvider var7 = new SecondaryBufferProvider();
               var7.init(var3, var4, var5);
               var11 = var7;
            }

            class57.bufferProvider = (BufferProvider)var11;
            if(var1 == class118.field1855) {
               Insets var12 = class118.field1855.getInsets();
               class25.canvas.setLocation(GameEngine.field1780 + var12.left, var12.top + GameEngine.field1781);
            } else {
               class25.canvas.setLocation(GameEngine.field1780, GameEngine.field1781);
            }

            class1.method15();
            if(Client.widgetRoot != -1) {
               Item.method770(true);
            }

            class36.method713();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1588304311"
   )
   static final void method792(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class162.field2157[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][1 + var5][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
