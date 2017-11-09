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

@ObfuscatedName("bt")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 398291963
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1219885941
   )
   public static int field708;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1983383387
   )
   public static volatile int field717;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1844588765
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1512354921
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2132285777
   )
   public static int field706;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -824282685
   )
   public static int field704;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1339395791
   )
   public static volatile int field709;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1236470419
   )
   public static volatile int field710;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1480788165
   )
   public static volatile int field711;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 6699854831604578627L
   )
   public static volatile long field712;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -85987053
   )
   public static int field713;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1499206669
   )
   public static int field714;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 468880647
   )
   public static int field715;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 4105391194477095219L
   )
   public static long field701;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field717 = 0;
      mouseX = -1;
      mouseY = -1;
      field706 = 0;
      field704 = 0;
      field708 = 0;
      field709 = 0;
      field710 = 0;
      field711 = 0;
      field712 = 0L;
      field713 = 0;
      field714 = 0;
      field715 = 0;
      field701 = 0L;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;B)I",
      garbageValue = "29"
   )
   final int method1054(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field710 = var1.getX();
         field711 = var1.getY();
         field712 = class268.currentTimeMs();
         field709 = this.method1054(var1);
         if(field709 != 0) {
            field717 = field709;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field717 = 0;
      }

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

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field717 = 0;
      }

   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1610100075"
   )
   static final void method1067() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var0.level == Ignore.plane && !var0.finished) {
            if(Client.gameCycle >= var0.startCycle) {
               var0.method1748(Client.field925);
               if(var0.finished) {
                  var0.unlink();
               } else {
                  class56.region.method2920(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }
}
