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

@ObfuscatedName("bx")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lbx;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("t")
   static volatile int field701;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1966243249
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 139185199
   )
   @Export("mouseX")
   static volatile int mouseX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1097943105
   )
   static volatile int field708;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1879849463
   )
   public static int field697;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1778112117
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1507014095
   )
   public static int field696;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 599995629
   )
   static volatile int field711;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 487026775
   )
   public static int field705;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 693013477
   )
   public static int field704;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1213513391
   )
   public static int field709;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 755724499
   )
   public static int field713;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1385246887
   )
   static volatile int field707;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 5899552059216359677L
   )
   static volatile long field702;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 1272243764917861139L
   )
   public static long field714;
   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static class289 field715;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field701 = 0;
      mouseX = -1;
      mouseY = -1;
      field704 = 0;
      field696 = 0;
      field705 = 0;
      field707 = 0;
      field708 = 0;
      field711 = 0;
      field702 = 0L;
      field697 = 0;
      field709 = 0;
      field713 = 0;
      field714 = 0L;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;B)I",
      garbageValue = "1"
   )
   final int method1009(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field708 = var1.getX();
         field711 = var1.getY();
         field702 = BuildType.currentTimeMs();
         field707 = this.method1009(var1);
         if(field707 != 0) {
            field701 = field707 * 967447941;
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

   public final synchronized void mouseDragged(MouseEvent var1) {
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

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field701 = 0;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field701 = 0;
      }

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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2146128222"
   )
   static void method1047() {
      if(class92.field1420) {
         class92.field1396 = null;
         class92.field1397 = null;
         class164.field2293 = null;
         class92.field1411 = null;
         class92.field1399 = null;
         class11.logoSprite = null;
         class36.titlemuteSprite = null;
         class90.field1378 = null;
         class149.field2178 = null;
         class92.field1424 = null;
         class29.field400 = null;
         class40.field517 = null;
         class88.field1359 = null;
         class66.field788 = null;
         ISAACCipher.field2404 = null;
         WorldMapData.field433 = null;
         class47.field566 = null;
         class60.field719 = null;
         class174.field2373 = null;
         class268.field3657 = null;
         XClanMember.field889 = null;
         class21.field324 = null;
         class27.method210(2);
         GroundObject.sendConInfo(true);
         class92.field1420 = false;
      }
   }
}
