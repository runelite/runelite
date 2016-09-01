import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public final class class140 implements KeyListener, FocusListener {
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 2001380087
   )
   static int field2150 = 0;
   @ObfuscatedName("cn")
   static char[] field2160 = new char[128];
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1294571693
   )
   static int field2163 = 0;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1119613685
   )
   static int field2164 = 0;
   @ObfuscatedName("bw")
   static class171 field2165;
   @ObfuscatedName("cw")
   public static boolean[] field2167 = new boolean[112];
   @ObfuscatedName("ci")
   static int[] field2168 = new int[128];
   @ObfuscatedName("x")
   @Export("keyboard")
   public static class140 keyboard = new class140();
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -2143270523
   )
   static int field2170 = 0;
   @ObfuscatedName("ch")
   static int[] field2172 = new int[128];
   @ObfuscatedName("cp")
   public static int[] field2173 = new int[128];
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1639374001
   )
   public static int field2174 = 0;
   @ObfuscatedName("ce")
   static int[] field2175 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 426154807
   )
   static int field2176 = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1861758817
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks = 0;

   public final void keyTyped(KeyEvent var1) {
      if(null != keyboard) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if((var2 <= 0 || var2 >= 128) && (var2 < 160 || var2 > 255)) {
               label62: {
                  if(var2 != 0) {
                     char[] var4 = class168.field2724;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label62;
                        }
                     }
                  }

                  var3 = false;
               }
            } else {
               var3 = true;
            }

            if(var3) {
               int var7 = 1 + field2176 & 127;
               if(field2150 != var7) {
                  field2172[field2176] = -1;
                  field2160[field2176] = var2;
                  field2176 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field2170 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2175.length) {
            var2 = field2175[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2170 >= 0 && var2 >= 0) {
            field2168[field2170] = ~var2;
            field2170 = field2170 + 1 & 127;
            if(field2163 == field2170) {
               field2170 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1947261060"
   )
   static void method2950() {
      if(class114.loadWorlds()) {
         class33.worldSelectShown = true;
      }

   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2175.length) {
            var2 = field2175[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2170 >= 0 && var2 >= 0) {
            field2168[field2170] = var2;
            field2170 = field2170 + 1 & 127;
            if(field2170 == field2163) {
               field2170 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2176 + 1 & 127;
            if(var3 != field2150) {
               field2172[field2176] = var2;
               field2160[field2176] = 0;
               field2176 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Z",
      garbageValue = "167"
   )
   static boolean method2968(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class10.method123(var0, class127.field2087);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class10.method123(var3.name, class127.field2087))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class10.method123(var3.previousName, class127.field2087))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-667440247"
   )
   public static void method2969() {
      PlayerComposition.field2977.reset();
   }
}
