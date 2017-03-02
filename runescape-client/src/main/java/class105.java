import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 801741547
   )
   static int field1693 = 0;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -696731201
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("ce")
   public static boolean[] field1700 = new boolean[112];
   @ObfuscatedName("cb")
   static int[] field1701 = new int[128];
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1975189485
   )
   static int field1702 = 0;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1017553539
   )
   public static int field1703 = 0;
   @ObfuscatedName("cd")
   static char[] field1704 = new char[128];
   @ObfuscatedName("cq")
   static int[] field1705 = new int[128];
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1460017367
   )
   public static int field1707 = 0;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1649967131
   )
   static int field1708 = 0;
   @ObfuscatedName("ca")
   public static int[] field1709 = new int[128];
   @ObfuscatedName("ds")
   static byte[][] field1711;
   @ObfuscatedName("x")
   public static boolean field1713;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 675620605
   )
   public static int field1715;
   @ObfuscatedName("bn")
   @Export("host")
   static String host;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1738817947
   )
   static int field1718 = 0;
   @ObfuscatedName("b")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("cy")
   public static int[] field1720 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

   @ObfuscatedName("l")
   static final void method2050(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1720.length) {
            var2 = field1720[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1703 >= 0 && var2 >= 0) {
            field1701[field1703] = var2;
            field1703 = 1 + field1703 & 127;
            if(field1703 == field1702) {
               field1703 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field1718 + 1 & 127;
            if(field1708 != var3) {
               field1705[field1718] = var2;
               field1704[field1718] = 0;
               field1718 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1720.length) {
            var2 = field1720[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1703 >= 0 && var2 >= 0) {
            field1701[field1703] = ~var2;
            field1703 = field1703 + 1 & 127;
            if(field1703 == field1702) {
               field1703 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field1703 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label70: {
                  if(var2 != 0) {
                     char[] var7 = class203.field3081;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label70;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field1718 + 1 & 127;
               if(var4 != field1708) {
                  field1705[field1718] = -1;
                  field1704[field1718] = var2;
                  field1718 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "812657608"
   )
   static void method2075() {
      for(class31 var0 = (class31)class31.field700.method2472(); var0 != null; var0 = (class31)class31.field700.method2479()) {
         if(var0.field696 != null) {
            class16.field168.method994(var0.field696);
            var0.field696 = null;
         }

         if(var0.field709 != null) {
            class16.field168.method994(var0.field709);
            var0.field709 = null;
         }
      }

      class31.field700.method2467();
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1035998142"
   )
   static final void method2076(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field544; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field490[var4] = true;
         }
      }

   }
}
