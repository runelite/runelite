import java.awt.Component;
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

@ObfuscatedName("bw")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lbw;"
   )
   @Export("mouse")
   static MouseInput mouse;
   @ObfuscatedName("c")
   static volatile int field731;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 136935517
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1703598327
   )
   @Export("mouseX")
   static volatile int mouseX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1061587803
   )
   static volatile int field737;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1816546859
   )
   public static int field740;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 350903419
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1962896761
   )
   public static int field734;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1675473445
   )
   static volatile int field738;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 626615905
   )
   public static int field735;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 998129991
   )
   public static int field733;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2092832971
   )
   public static int field741;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1234128223
   )
   public static int field742;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 33136743
   )
   static volatile int field726;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 7411988209137159099L
   )
   static volatile long field739;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -6784869811888689119L
   )
   public static long field736;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   static IndexData field744;
   @ObfuscatedName("nn")
   static byte field728;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 1756045519
   )
   static int field748;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field731 = 0;
      mouseX = -1;
      mouseY = -1;
      field733 = 0;
      field734 = 0;
      field735 = 0;
      field726 = 0;
      field737 = 0;
      field738 = 0;
      field739 = 0L;
      field740 = 0;
      field741 = 0;
      field742 = 0;
      field736 = 0L;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "1514961475"
   )
   final int method1031(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field731 = 0;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field737 = var1.getX();
         field738 = var1.getY();
         field739 = class74.currentTimeMs();
         field726 = this.method1031(var1);
         if(field726 != 0) {
            field731 = field726 * 562025627;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field731 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "5327"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class27.clientInstance.method915();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field968 = 0;
            Client.field969 = 0;
         }

         if(var0 != 20 && var0 != 40 && class20.field337 != null) {
            class20.field337.close();
            class20.field337 = null;
         }

         if(Client.gameState == 25) {
            Client.field995 = 0;
            Client.field991 = 0;
            Client.field992 = 1;
            Client.field981 = 0;
            Client.field1091 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               WidgetNode.method1148(field744, class176.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               WidgetNode.method1148(field744, class176.indexSprites, false, 4);
            } else {
               class90.method1721();
            }
         } else {
            WidgetNode.method1148(field744, class176.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1239321519"
   )
   static void method1065(Component var0) {
      var0.removeMouseListener(mouse);
      var0.removeMouseMotionListener(mouse);
      var0.removeFocusListener(mouse);
      field731 = 0;
   }
}
