import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   @Export("keyboard")
   static KeyFocusListener keyboard;
   @ObfuscatedName("ck")
   public static boolean[] field618;
   @ObfuscatedName("ci")
   static int[] field612;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -85165919
   )
   static int field617;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 1988370463
   )
   static int field611;
   @ObfuscatedName("cf")
   static char[] field608;
   @ObfuscatedName("ch")
   static int[] field616;
   @ObfuscatedName("cg")
   public static int[] field614;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1867807953
   )
   public static int field605;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 579932745
   )
   static int field619;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1225368965
   )
   static int field615;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 274595721
   )
   static int field621;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1921407203
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks;
   @ObfuscatedName("cx")
   static int[] field623;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1191727349
   )
   static int field624;

   static {
      keyboard = new KeyFocusListener();
      field618 = new boolean[112];
      field612 = new int[128];
      field617 = 0;
      field611 = 0;
      field608 = new char[128];
      field616 = new int[128];
      field614 = new int[128];
      field605 = 0;
      field619 = 0;
      field615 = 0;
      field621 = 0;
      keyboardIdleTicks = 0;
      field623 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field623.length) {
            var2 = field623[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field611 >= 0 && var2 >= 0) {
            field612[field611] = var2;
            field611 = field611 + 1 & 127;
            if(field617 == field611) {
               field611 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field615 + 1 & 127;
            if(var3 != field619) {
               field616[field615] = var2;
               field608[field615] = 0;
               field615 = var3;
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
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field623.length) {
            var2 = field623[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field611 >= 0 && var2 >= 0) {
            field612[field611] = ~var2;
            field611 = field611 + 1 & 127;
            if(field611 == field617) {
               field611 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label58: {
                  if(var2 != 0) {
                     char[] var7 = class273.field3719;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label58;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field615 + 1 & 127;
               if(var4 != field619) {
                  field616[field615] = -1;
                  field608[field615] = var2;
                  field615 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field611 = -1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "77"
   )
   public static int method831(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-1230388583"
   )
   public static boolean method832(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  return false;
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
