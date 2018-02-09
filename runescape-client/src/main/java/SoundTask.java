import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("nj")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("minimapSprite")
   static SpritePixels minimapSprite;
   @ObfuscatedName("d")
   static ScheduledExecutorService field1574;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Ldf;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2262();
            }
         }
      } catch (Exception var4) {
         GrandExchangeEvent.method78((String)null, var4);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)Lki;",
      garbageValue = "1733170084"
   )
   public static final SpritePixels method2330(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var3 * var2];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new SpritePixels(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new SpritePixels(0, 0);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "749149977"
   )
   public static char method2329(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(IIII)Lbl;",
      garbageValue = "-2048453846"
   )
   static final WidgetNode method2331(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      TotalQuantityComparator.method91(var1);
      Widget var4 = class216.getWidget(var0);
      class33.method341(var4);
      if(Client.field885 != null) {
         class33.method341(Client.field885);
         Client.field885 = null;
      }

      class80.method1825();
      class5.method14(ScriptState.widgets[var0 >> 16], var4, false);
      FrameMap.method2900(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(ServerPacket.loadWidget(var5)) {
            WorldMapType1.method269(ScriptState.widgets[var5], 1);
         }
      }

      return var3;
   }

   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-211983707"
   )
   static void method2332(Buffer var0, int var1) {
      class27.method213(var0.payload, var1);
      if(class157.randomDat != null) {
         try {
            class157.randomDat.seek(0L);
            class157.randomDat.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}
