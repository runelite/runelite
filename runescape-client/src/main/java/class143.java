import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class143 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2077261529
   )
   static volatile int field2215 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 4378126679370282297L
   )
   static volatile long field2216 = 0L;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -649451809
   )
   static volatile int field2217 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -648503575
   )
   static volatile int field2218 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1779848985
   )
   static volatile int field2219 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2078789269
   )
   public static int field2220 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1193824625
   )
   static volatile int field2221 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1938959205
   )
   public static int field2222 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 239630439
   )
   public static int field2223 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 528895935
   )
   static volatile int field2224 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1190273929
   )
   public static int field2225 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1298499335
   )
   public static int field2226 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 32819773
   )
   public static int field2227 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1956394957
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("a")
   @Export("mouse")
   public static class143 mouse = new class143();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -2955393446041624535L
   )
   public static long field2230 = 0L;

   public final void focusGained(FocusEvent var1) {
   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2218 = var1.getX();
         field2219 = var1.getY();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2218 = var1.getX();
         field2219 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2218 = var1.getX();
         field2219 = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field2217 = 0;
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2224 = var1.getX();
         field2221 = var1.getY();
         field2216 = class5.method63();
         if(var1.isAltDown()) {
            field2215 = 4;
            field2217 = 4;
         } else if(var1.isMetaDown()) {
            field2215 = 2;
            field2217 = 2;
         } else {
            field2215 = 1;
            field2217 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("d")
   static final void method2978(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2218 = -1;
         field2219 = -1;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2217 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "0"
   )
   static final void method3004(Actor var0) {
      var0.field842 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = Friend.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.field1009 != null) {
            ++var0.field870;
            if(var0.poseFrame < var1.field1009.length && var0.field870 > var1.field1015[var0.poseFrame]) {
               var0.field870 = 1;
               ++var0.poseFrame;
               class107.method2314(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.field1009.length) {
               var0.field870 = 0;
               var0.poseFrame = 0;
               class107.method2314(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field879) {
         if(var0.field877 < 0) {
            var0.field877 = 0;
         }

         int var3 = class49.method1029(var0.graphic).field1034;
         if(var3 != -1) {
            Sequence var2 = Friend.getAnimation(var3);
            if(var2 != null && null != var2.field1009) {
               ++var0.field878;
               if(var0.field877 < var2.field1009.length && var0.field878 > var2.field1015[var0.field877]) {
                  var0.field878 = 1;
                  ++var0.field877;
                  class107.method2314(var2, var0.field877, var0.x, var0.y);
               }

               if(var0.field877 >= var2.field1009.length && (var0.field877 < 0 || var0.field877 >= var2.field1009.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var1 = Friend.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field898 > 0 && var0.field859 <= Client.gameCycle && var0.field845 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = Friend.getAnimation(var0.animation);
         if(null != var1 && null != var1.field1009) {
            ++var0.field881;
            if(var0.actionFrame < var1.field1009.length && var0.field881 > var1.field1015[var0.actionFrame]) {
               var0.field881 = 1;
               ++var0.actionFrame;
               class107.method2314(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.field1009.length) {
               var0.actionFrame -= var1.field1014;
               ++var0.field875;
               if(var0.field875 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.field1009.length) {
                  class107.method2314(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field842 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
