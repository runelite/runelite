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

@ObfuscatedName("br")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("i")
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 652741531
   )
   public static volatile int field744;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1885057981
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1308741569
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1756762255
   )
   public static volatile int field751;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1702299711
   )
   public static int field742;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1292655903
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2121271035
   )
   public static int field748;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 550344653
   )
   public static volatile int field752;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 462310583
   )
   public static int field749;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -892013223
   )
   public static int field754;
   @ObfuscatedName("pw")
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1611168441
   )
   public static int field747;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1988621821
   )
   public static int field756;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1604348979
   )
   public static volatile int field762;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -7497020445329385425L
   )
   public static volatile long field760;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 5899679638078048939L
   )
   public static long field757;
   @ObfuscatedName("op")
   static SpritePixels field758;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field744 = 0;
      mouseX = -1;
      mouseY = -1;
      field754 = 0;
      field748 = 0;
      field749 = 0;
      field762 = 0;
      field751 = 0;
      field752 = 0;
      field760 = 0L;
      field742 = 0;
      field747 = 0;
      field756 = 0;
      field757 = 0L;
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field751 = var1.getX();
         field752 = var1.getY();
         field760 = DState.currentTimeMs();
         if(var1.isAltDown()) {
            field762 = 4;
            field744 = 4;
         } else if(var1.isMetaDown()) {
            field762 = 2;
            field744 = 2;
         } else {
            field762 = 1;
            field744 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field744 = 0;
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

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field744 = 0;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "-1201528818"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class18.method133(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILclass219;B)I",
      garbageValue = "106"
   )
   public static int method1018(int var0, class219 var1) {
      return (var0 + '鱀' << 8) + var1.field2804;
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "41"
   )
   static void method1017(int var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(155);
      Client.secretPacketBuffer1.putLEInt(var0);
      Client.secretPacketBuffer1.putIntOb1(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "2055308343"
   )
   public static boolean method1042(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
