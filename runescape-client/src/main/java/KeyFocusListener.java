import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lab;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -103316675
   )
   public static int field607;
   @ObfuscatedName("cq")
   static int[] field594;
   @ObfuscatedName("cf")
   public static boolean[] field604;
   @ObfuscatedName("cy")
   public static int[] field605;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 2025951343
   )
   public static int field606;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 508458877
   )
   public static int field597;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -2094195467
   )
   public static int field612;
   @ObfuscatedName("cb")
   static char[] field608;
   @ObfuscatedName("co")
   static int[] field616;
   @ObfuscatedName("ce")
   public static int[] field617;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1426752629
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 376484171
   )
   public static int field611;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 318111533
   )
   public static int field614;
   @ObfuscatedName("ow")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static SpritePixels field619;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1721700547
   )
   @Export("cameraY")
   static int cameraY;

   static {
      keyboard = new KeyFocusListener();
      field604 = new boolean[112];
      field605 = new int[128];
      field606 = 0;
      field607 = 0;
      field608 = new char[128];
      field616 = new int[128];
      field617 = new int[128];
      field611 = 0;
      field612 = 0;
      field597 = 0;
      field614 = 0;
      keyboardIdleTicks = 0;
      field594 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field594.length) {
            var2 = field594[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field607 >= 0 && var2 >= 0) {
            field605[field607] = var2;
            field607 = field607 + 1 & 127;
            if(field606 == field607) {
               field607 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field597 + 1 & 127;
            if(var3 != field612) {
               field616[field597] = var2;
               field608[field597] = 0;
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
         if(var2 >= 0 && var2 < field594.length) {
            var2 = field594[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field607 >= 0 && var2 >= 0) {
            field605[field607] = ~var2;
            field607 = field607 + 1 & 127;
            if(field607 == field606) {
               field607 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && Script.method1865(var2)) {
            int var3 = field597 + 1 & 127;
            if(var3 != field612) {
               field616[field597] = -1;
               field608[field597] = var2;
               field597 = var3;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field607 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1910067055"
   )
   static void method786(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.field701 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfy;II)V",
      garbageValue = "1159429005"
   )
   static final void method784(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class96.field1477 = 0;
      int var3 = 0;
      var0.bitAccess();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class96.field1470; ++var4) {
         var5 = class96.field1468[var4];
         if((class96.field1471[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
            } else {
               var6 = var0.getBits(1);
               if(var6 == 0) {
                  var3 = class238.method4236(var0);
                  class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
               } else {
                  class1.decodeMovement(var0, var5);
               }
            }
         }
      }

      var0.byteAccess();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var4 = 0; var4 < class96.field1470; ++var4) {
            var5 = class96.field1468[var4];
            if((class96.field1471[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
               } else {
                  var6 = var0.getBits(1);
                  if(var6 == 0) {
                     var3 = class238.method4236(var0);
                     class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
                  } else {
                     class1.decodeMovement(var0, var5);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var4 = 0; var4 < class96.field1472; ++var4) {
               var5 = class96.field1480[var4];
               if((class96.field1471[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
                  } else {
                     var6 = var0.getBits(1);
                     if(var6 == 0) {
                        var3 = class238.method4236(var0);
                        class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
                     } else if(class88.decodeRegionHash(var0, var5)) {
                        class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var4 = 0; var4 < class96.field1472; ++var4) {
                  var5 = class96.field1480[var4];
                  if((class96.field1471[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
                     } else {
                        var6 = var0.getBits(1);
                        if(var6 == 0) {
                           var3 = class238.method4236(var0);
                           class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
                        } else if(class88.decodeRegionHash(var0, var5)) {
                           class96.field1471[var5] = (byte)(class96.field1471[var5] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class96.field1470 = 0;
                  class96.field1472 = 0;

                  Player var7;
                  for(var4 = 1; var4 < 2048; ++var4) {
                     class96.field1471[var4] = (byte)(class96.field1471[var4] >> 1);
                     var7 = Client.cachedPlayers[var4];
                     if(var7 != null) {
                        class96.field1468[++class96.field1470 - 1] = var4;
                     } else {
                        class96.field1480[++class96.field1472 - 1] = var4;
                     }
                  }

                  for(var3 = 0; var3 < class96.field1477; ++var3) {
                     var4 = class96.field1478[var3];
                     var7 = Client.cachedPlayers[var4];
                     var6 = var0.readUnsignedByte();
                     if((var6 & 4) != 0) {
                        var6 += var0.readUnsignedByte() << 8;
                     }

                     class82.method1618(var0, var4, var7, var6);
                  }

                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Lhn;I)Ljava/lang/String;",
      garbageValue = "1318461698"
   )
   static String method760(Widget var0) {
      return MilliTimer.method2938(class169.getWidgetConfig(var0)) == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
