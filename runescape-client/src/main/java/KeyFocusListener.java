import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("ay")
   protected static boolean field608;
   @ObfuscatedName("cv")
   public static boolean[] field578;
   @ObfuscatedName("cn")
   static int[] field589;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1424243183
   )
   static int field590;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1969089659
   )
   static int field591;
   @ObfuscatedName("ck")
   static char[] field592;
   @ObfuscatedName("ct")
   static int[] field588;
   @ObfuscatedName("cb")
   public static int[] field594;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -934775189
   )
   public static int field601;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1405313657
   )
   static int field596;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1707030739
   )
   static int field597;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -350578865
   )
   static int field598;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -110662125
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("ci")
   static int[] field593;

   static {
      keyboard = new KeyFocusListener();
      field578 = new boolean[112];
      field589 = new int[128];
      field590 = 0;
      field591 = 0;
      field592 = new char[128];
      field588 = new int[128];
      field594 = new int[128];
      field601 = 0;
      field596 = 0;
      field597 = 0;
      field598 = 0;
      keyboardIdleTicks = 0;
      field593 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field593.length) {
            var2 = field593[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field591 >= 0 && var2 >= 0) {
            field589[field591] = var2;
            field591 = field591 + 1 & 127;
            if(field591 == field590) {
               field591 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field597 + 1 & 127;
            if(var3 != field596) {
               field588[field597] = var2;
               field592[field597] = 0;
               field597 = var3;
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
         if(var2 >= 0 && var2 < field593.length) {
            var2 = field593[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field591 >= 0 && var2 >= 0) {
            field589[field591] = ~var2;
            field591 = field591 + 1 & 127;
            if(field591 == field590) {
               field591 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field591 = -1;
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class251.method4309(var2)) {
            int var3 = field597 + 1 & 127;
            if(var3 != field596) {
               field588[field597] = -1;
               field592[field597] = var2;
               field597 = var3;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lig;",
      garbageValue = "-181241928"
   )
   public static Varbit method715(int var0) {
      Varbit var1 = (Varbit)Varbit.varbits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.varbit_ref.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Varbit.varbits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1273902123"
   )
   static int method701(int var0) {
      MessageNode var1 = (MessageNode)class96.field1425.get((long)var0);
      return var1 == null?-1:(var1.next == class96.field1424.field2574?-1:((MessageNode)var1.next).id);
   }
}
