import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class119 {
   @ObfuscatedName("a")
   Inflater field2059;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class119(int var1, int var2, int var3) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "1808148153"
   )
   public static ModIcon[] method2474(class170 var0, String var1, String var2) {
      int var3 = var0.method3324(var1);
      int var4 = var0.method3313(var3, var2);
      return class21.method571(var0, var3, var4);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "-1840081339"
   )
   public void method2475(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2059 == null) {
            this.field2059 = new Inflater(true);
         }

         try {
            this.field2059.setInput(var1.payload, var1.offset + 10, var1.payload.length - (8 + var1.offset + 10));
            this.field2059.inflate(var2);
         } catch (Exception var4) {
            this.field2059.reset();
            throw new RuntimeException("");
         }

         this.field2059.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZB)V",
      garbageValue = "127"
   )
   protected static final void method2478(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class79.canvas.getGraphics();
         if(class32.field731 == null) {
            class32.field731 = new Font("Helvetica", 1, 13);
            FrameMap.field1845 = class79.canvas.getFontMetrics(class32.field731);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class159.field2374, class92.field1643);
         }

         if(null == var2) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(Frames.field1852 == null) {
               Frames.field1852 = class79.canvas.createImage(304, 34);
            }

            Graphics var5 = Frames.field1852.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, 3 * var0, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + 3 * var0, 2, 300 - 3 * var0, 30);
            var5.setFont(class32.field731);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - FrameMap.field1845.stringWidth(var1)) / 2, 22);
            var4.drawImage(Frames.field1852, class159.field2374 / 2 - 152, class92.field1643 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class159.field2374 / 2 - 152;
            int var7 = class92.field1643 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(2 + var6, var7 + 2, 3 * var0, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, 1 + var7, 301, 31);
            var4.fillRect(2 + var6 + var0 * 3, 2 + var7, 300 - 3 * var0, 30);
            var4.setFont(class32.field731);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - FrameMap.field1845.stringWidth(var1)) / 2, 22 + var7);
         }
      } catch (Exception var9) {
         class79.canvas.repaint();
      }

   }

   public class119() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "33"
   )
   static final void method2479() {
      for(int var0 = 0; var0 < Client.field522; ++var0) {
         --Client.field471[var0];
         if(Client.field471[var0] >= -10) {
            class61 var9 = Client.field432[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = class61.method1309(class47.field1065, Client.field523[var0], 0);
               if(null == var9) {
                  continue;
               }

               Client.field471[var0] += var9.method1300();
               Client.field432[var0] = var9;
            }

            if(Client.field471[var0] < 0) {
               int var2;
               if(Client.field526[var0] != 0) {
                  int var3 = 128 * (Client.field526[var0] & 255);
                  int var4 = Client.field526[var0] >> 16 & 255;
                  int var5 = 64 + 128 * var4 - WidgetNode.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field526[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - WidgetNode.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field471[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = Client.field414 * (var3 - var8) / var3;
               } else {
                  var2 = Client.field520;
               }

               if(var2 > 0) {
                  class65 var10 = var9.method1299().method1330(class53.field1160);
                  class67 var11 = class67.method1468(var10, 100, var2);
                  var11.method1430(Client.field428[var0] - 1);
                  GameObject.field1759.method1187(var11);
               }

               Client.field471[var0] = -100;
            }
         } else {
            --Client.field522;

            for(int var1 = var0; var1 < Client.field522; ++var1) {
               Client.field523[var1] = Client.field523[var1 + 1];
               Client.field432[var1] = Client.field432[1 + var1];
               Client.field428[var1] = Client.field428[var1 + 1];
               Client.field471[var1] = Client.field471[var1 + 1];
               Client.field526[var1] = Client.field526[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field426 && !Player.method40()) {
         if(Client.field517 != 0 && Client.field496 != -1) {
            class50.method1046(class8.field140, Client.field496, 0, Client.field517, false);
         }

         Client.field426 = false;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-125"
   )
   static void method2480() {
      class33.username = class33.username.trim();
      if(class33.username.length() == 0) {
         class192.method3774("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class117.method2464();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = class109.method2402(var1, class33.username);
         }

         switch(var0) {
         case 2:
            class192.method3774("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.loginIndex = 6;
            break;
         case 3:
            class192.method3774("", "Error connecting to server.", "");
            break;
         case 4:
            class192.method3774("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class192.method3774("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class192.method3774("", "Error connecting to server.", "");
            break;
         case 7:
            class192.method3774("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
