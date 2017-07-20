import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lbi;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1393529103
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("m")
   public static volatile int field726;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1245241795
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1236717491
   )
   public static volatile int field739;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2133795727
   )
   public static int field729;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1526623995
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 275204421
   )
   public static int field730;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 236596117
   )
   public static volatile int field734;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -594013797
   )
   public static int field731;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -256594387
   )
   public static int field733;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -533035283
   )
   public static int field737;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 676895789
   )
   public static int field723;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -102684187
   )
   public static volatile int field732;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -4285684367670123289L
   )
   public static volatile long field735;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 3834031202036676489L
   )
   public static long field722;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field726 = 0;
      mouseX = -1;
      mouseY = -1;
      field733 = 0;
      field730 = 0;
      field731 = 0;
      field732 = 0;
      field739 = 0;
      field734 = 0;
      field735 = 0L;
      field729 = 0;
      field737 = 0;
      field723 = 0;
      field722 = 0L;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "1082480715"
   )
   final int method937(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field726 = 0;
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

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field726 = 0;
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field739 = var1.getX();
         field734 = var1.getY();
         field735 = class157.currentTimeMs();
         field732 = this.method937(var1);
         if(field732 != 0) {
            field726 = field732 * 550497311;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1139430281"
   )
   public static boolean method972(int var0) {
      return var0 >= class221.field2807.field2803 && var0 <= class221.field2808.field2803;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lcc;",
      garbageValue = "-263259062"
   )
   static Preferences method971() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = WallObject.getPreferencesFile("", class98.field1497.field3159, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-409992531"
   )
   static void method968(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1281[var5] != var0) {
            var2[var4] = World.field1281[var5];
            var3[var4] = World.field1285[var5];
            ++var4;
         }
      }

      World.field1281 = var2;
      World.field1285 = var3;
      class1.method1(class64.worldList, 0, class64.worldList.length - 1, World.field1281, World.field1285);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CIB)Ljava/lang/String;",
      garbageValue = "32"
   )
   public static String method974(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "55"
   )
   public static String method973(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "160"
   )
   static int method949(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1796();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lcw;Lcw;IZI)I",
      garbageValue = "-1931581387"
   )
   static int method957(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1510()?(var1.method1510()?0:1):(var1.method1510()?-1:0)):(var2 == 5?(var0.method1508()?(var1.method1508()?0:1):(var1.method1508()?-1:0)):(var2 == 6?(var0.method1512()?(var1.method1512()?0:1):(var1.method1512()?-1:0)):(var2 == 7?(var0.method1507()?(var1.method1507()?0:1):(var1.method1507()?-1:0)):var0.id - var1.id)))));
      }
   }
}
