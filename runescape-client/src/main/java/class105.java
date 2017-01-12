import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1193633027
   )
   static int field1683 = 0;
   @ObfuscatedName("u")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("cj")
   public static boolean[] field1700 = new boolean[112];
   @ObfuscatedName("cm")
   static int[] field1701 = new int[128];
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1593842027
   )
   static int field1702 = 0;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1151265175
   )
   public static int field1703 = 0;
   @ObfuscatedName("ce")
   static char[] field1704 = new char[128];
   @ObfuscatedName("cg")
   static int[] field1705 = new int[128];
   @ObfuscatedName("ch")
   public static int[] field1706 = new int[128];
   @ObfuscatedName("cf")
   static int[] field1708 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 366670059
   )
   static int field1709 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 786033497
   )
   public static int field1710 = 0;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -101927445
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -650915673
   )
   static int field1713 = 0;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1708.length) {
            var2 = field1708[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1703 >= 0 && var2 >= 0) {
            field1701[field1703] = var2;
            field1703 = field1703 + 1 & 127;
            if(field1702 == field1703) {
               field1703 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field1713 & 127;
            if(field1709 != var3) {
               field1705[field1713] = var2;
               field1704[field1713] = 0;
               field1713 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if((var2 <= 0 || var2 >= 128) && (var2 < 160 || var2 > 255)) {
               label67: {
                  if(var2 != 0) {
                     char[] var7 = class203.field3061;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label67;
                        }
                     }
                  }

                  var3 = false;
               }
            } else {
               var3 = true;
            }

            if(var3) {
               int var4 = 1 + field1713 & 127;
               if(field1709 != var4) {
                  field1705[field1713] = -1;
                  field1704[field1713] = var2;
                  field1713 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2006873400"
   )
   static final void method1961(String var0) {
      if(!var0.equals("")) {
         Client.field326.method3029(7);
         Client.field326.method2760(class148.method2740(var0));
         Client.field326.method2811(var0);
      }
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field1703 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1708.length) {
            var2 = field1708[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1703 >= 0 && var2 >= 0) {
            field1701[field1703] = ~var2;
            field1703 = 1 + field1703 & 127;
            if(field1702 == field1703) {
               field1703 = -1;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1126437566"
   )
   public static void method1982() {
      if(keyboard != null) {
         class105 var0 = keyboard;
         synchronized(keyboard) {
            keyboard = null;
         }
      }

   }
}
