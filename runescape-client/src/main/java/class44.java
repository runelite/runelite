import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
final class class44 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("ns")
   static class57 field914;

   public int compare(Object var1, Object var2) {
      return this.method889((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-452298851"
   )
   public static boolean method883(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1867097074"
   )
   static final void method886(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class184.field2735.field714 = !class184.field2735.field714;
         class99.method1996();
         if(class184.field2735.field714) {
            class16.method186(99, "", "Roofs are now all hidden");
         } else {
            class16.method186(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field321 = !Client.field321;
      }

      if(Client.field472 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            Client.field321 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field321 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(Client.field358 > 0) {
               class6.method73();
            } else {
               class8.setGameState(40);
               class159.field2130 = class149.field2036;
               class149.field2036 = null;
            }
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field305 == 2) {
            throw new RuntimeException();
         }
      }

      Client.field348.method3073(156);
      Client.field348.method2918(var0.length() + 1);
      Client.field348.method2824(var0);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1613033160"
   )
   int method889(class2 var1, class2 var2) {
      if(var1.field30 == var2.field30) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field30 == Client.world) {
               return -1;
            }

            if(Client.world == var2.field30) {
               return 1;
            }
         }

         return var1.field30 < var2.field30?-1:1;
      }
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("rk")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZB)V",
      garbageValue = "-52"
   )
   protected static final void method890(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = GameObject.canvas.getGraphics();
         if(null == Varbit.field2849) {
            Varbit.field2849 = new java.awt.Font("Helvetica", 1, 13);
            class13.field156 = GameObject.canvas.getFontMetrics(Varbit.field2849);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class32.field758, class47.field950);
         }

         if(null == var2) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(class5.field65 == null) {
               class5.field65 = GameObject.canvas.createImage(304, 34);
            }

            Graphics var5 = class5.field65.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, 3 * var0, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(var0 * 3 + 2, 2, 300 - 3 * var0, 30);
            var5.setFont(Varbit.field2849);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - class13.field156.stringWidth(var1)) / 2, 22);
            var4.drawImage(class5.field65, class32.field758 / 2 - 152, class47.field950 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class32.field758 / 2 - 152;
            int var7 = class47.field950 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(2 + var6, var7 + 2, var0 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, var7 + 1, 301, 31);
            var4.fillRect(2 + var6 + var0 * 3, 2 + var7, 300 - 3 * var0, 30);
            var4.setFont(Varbit.field2849);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - class13.field156.stringWidth(var1)) / 2, var7 + 22);
         }
      } catch (Exception var9) {
         GameObject.canvas.repaint();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[Lclass221;",
      garbageValue = "753581463"
   )
   public static class221[] method892() {
      return new class221[]{class221.field3202, class221.field3203, class221.field3204, class221.field3207, class221.field3205};
   }
}
