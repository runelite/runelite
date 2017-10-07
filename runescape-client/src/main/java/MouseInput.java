import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lbd;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("r")
   public static volatile int field740;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1352285285
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1979917305
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1826910753
   )
   public static volatile int field748;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1290076355
   )
   public static int field741;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1760863869
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2120575701
   )
   public static int field745;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 323538369
   )
   public static volatile int field737;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 554768293
   )
   public static int field746;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1624981867
   )
   public static int field738;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1445619815
   )
   public static int field752;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1630714407
   )
   public static int field753;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 243160619
   )
   public static volatile int field749;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -3481900337317146061L
   )
   public static volatile long field750;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 2372880517834035691L
   )
   public static long field754;
   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "[Lkr;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field740 = 0;
      mouseX = -1;
      mouseY = -1;
      field738 = 0;
      field745 = 0;
      field746 = 0;
      field749 = 0;
      field748 = 0;
      field737 = 0;
      field750 = 0L;
      field741 = 0;
      field752 = 0;
      field753 = 0;
      field754 = 0L;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "-2110347142"
   )
   final int method1043(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field748 = var1.getX();
         field737 = var1.getY();
         field750 = class147.currentTimeMs();
         field749 = this.method1043(var1);
         if(field749 != 0) {
            field740 = field749 * -912548069;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field740 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field740 = 0;
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "-620600885"
   )
   public static byte[] method1060(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(var4 == 8364) {
            var2[var3] = -128;
         } else if(var4 == 8218) {
            var2[var3] = -126;
         } else if(var4 == 402) {
            var2[var3] = -125;
         } else if(var4 == 8222) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(var4 == 710) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(var4 == 8249) {
            var2[var3] = -117;
         } else if(var4 == 338) {
            var2[var3] = -116;
         } else if(var4 == 381) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(var4 == 8217) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(var4 == 353) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(var4 == 382) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }
}
