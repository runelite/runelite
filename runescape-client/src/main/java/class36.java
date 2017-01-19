import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class36 {
   @ObfuscatedName("a")
   static final BigInteger field766 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("g")
   static final BigInteger field767 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("l")
   static int[] field771;
   @ObfuscatedName("at")
   static class110 field773;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1097224267"
   )
   static void method713() {
      int var0 = GameEngine.field1780;
      int var1 = GameEngine.field1781;
      int var2 = class15.field180 - class16.field186 - var0;
      int var3 = class25.field590 - ChatMessages.field907 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = class227.field3230.method2088();
            int var5 = 0;
            int var6 = 0;
            if(class118.field1855 == var4) {
               Insets var7 = class118.field1855.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class25.field590);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class15.field180, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class15.field180 + var5 - var2, var6, var2, class25.field590);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class25.field590 - var3, class15.field180, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-821105888"
   )
   static final void method714(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class20.field234.method3724(var0, 250);
      int var6 = class20.field234.method3744(var0, 250) * 13;
      Rasterizer2D.method3876(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var2 + var6, 0);
      Rasterizer2D.method3863(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
      class20.field234.method3731(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class31.method659(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var2 + var6);
      if(var1) {
         try {
            Graphics var7 = class25.canvas.getGraphics();
            class57.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class25.canvas.repaint();
         }
      } else {
         class13.method150(var3, var4, var5, var6);
      }

   }
}
