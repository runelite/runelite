import java.applet.Applet;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class141 {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = 1161354225
   )
   static int field2183;
   @ObfuscatedName("h")
   public static String field2184 = null;
   @ObfuscatedName("i")
   public static Applet field2190 = null;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   public static void method2972() {
      try {
         File var0 = new File(class152.field2280, "random.dat");
         int var2;
         if(var0.exists()) {
            class152.field2283 = new class231(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label37:
            for(int var1 = 0; var1 < FrameMap.field1817.length; ++var1) {
               for(var2 = 0; var2 < class124.field2050.length; ++var2) {
                  File var3 = new File(class124.field2050[var2] + FrameMap.field1817[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class152.field2283 = new class231(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if(null == class152.field2283) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class152.field2283 = new class231(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1210059431"
   )
   static final void method2973() {
      int var0 = class146.menuX;
      int var1 = class130.menuY;
      int var2 = ChatLineBuffer.menuWidth;
      int var3 = class194.menuHeight;
      int var4 = 6116423;
      class82.method1853(var0, var1, var2, var3, var4);
      class82.method1853(1 + var0, 1 + var1, var2 - 2, 16, 0);
      class82.method1856(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      MessageNode.field811.method4124("Choose Option", 3 + var0, 14 + var1, var4, -1);
      int var5 = class143.field2204;
      int var6 = class143.field2206;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = 15 * (Client.menuOptionCount - 1 - var7) + var1 + 31;
         var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         class227 var10 = MessageNode.field811;
         String var12;
         if(Client.menuTargets[var7].length() > 0) {
            var12 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var12 = Client.menuOptions[var7];
         }

         var10.method4124(var12, 3 + var0, var8, var9, 0);
      }

      var7 = class146.menuX;
      var8 = class130.menuY;
      var9 = ChatLineBuffer.menuWidth;
      int var13 = class194.menuHeight;

      for(int var11 = 0; var11 < Client.field425; ++var11) {
         if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var7 + var9 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var13 + var8) {
            Client.field506[var11] = true;
         }
      }

   }
}
