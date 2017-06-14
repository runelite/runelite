import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public final class class50 implements KeyListener, FocusListener {
   @ObfuscatedName("cf")
   public static int[] field619;
   @ObfuscatedName("cp")
   public static boolean[] field624;
   @ObfuscatedName("n")
   @Export("keyboard")
   public static class50 keyboard;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 785446729
   )
   public static int field627;
   @ObfuscatedName("ci")
   static char[] field628;
   @ObfuscatedName("cc")
   public static int[] field629;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 370252979
   )
   public static int field630;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1249693031
   )
   public static int field631;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -919258503
   )
   public static int field632;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -935002941
   )
   public static int field633;
   @ObfuscatedName("cu")
   static int[] field634;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -795682771
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cx")
   static int[] field636;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 717708513
   )
   public static int field638;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field636.length) {
            var2 = field636[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field627 >= 0 && var2 >= 0) {
            field619[field627] = var2;
            field627 = field627 + 1 & 127;
            if(field630 == field627) {
               field627 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field638 + 1 & 127;
            if(field632 != var3) {
               field634[field638] = var2;
               field628[field638] = 0;
               field638 = var3;
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
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label73: {
                  if(var2 != 0) {
                     char[] var4 = class266.field3673;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label73;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var7 = field638 + 1 & 127;
               if(var7 != field632) {
                  field634[field638] = -1;
                  field628[field638] = var2;
                  field638 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   static {
      keyboard = new class50();
      field624 = new boolean[112];
      field619 = new int[128];
      field630 = 0;
      field627 = 0;
      field628 = new char[128];
      field634 = new int[128];
      field629 = new int[128];
      field631 = 0;
      field632 = 0;
      field638 = 0;
      field633 = 0;
      keyboardIdleTicks = 0;
      field636 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field636.length) {
            var2 = field636[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field627 >= 0 && var2 >= 0) {
            field619[field627] = ~var2;
            field627 = field627 + 1 & 127;
            if(field630 == field627) {
               field627 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field627 = -1;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "2065014034"
   )
   static int method742(int var0, Script var1, boolean var2) {
      String var10;
      if(var0 == 3100) {
         var10 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
         class98.sendGameMessage(0, "", var10);
         return 1;
      } else if(var0 == 3101) {
         class165.intStackSize -= 2;
         class37.method499(class168.localPlayer, class83.intStack[class165.intStackSize], class83.intStack[class165.intStackSize + 1]);
         return 1;
      } else if(var0 != 3103) {
         int var12;
         if(var0 == 3104) {
            var10 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
            var12 = 0;
            if(class157.method2977(var10)) {
               var12 = class214.method3998(var10);
            }

            Client.secretPacketBuffer1.putOpcode(101);
            Client.secretPacketBuffer1.putInt(var12);
            return 1;
         } else if(var0 == 3105) {
            var10 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
            Client.secretPacketBuffer1.putOpcode(52);
            Client.secretPacketBuffer1.putByte(var10.length() + 1);
            Client.secretPacketBuffer1.method3150(var10);
            return 1;
         } else if(var0 == 3106) {
            var10 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
            Client.secretPacketBuffer1.putOpcode(3);
            Client.secretPacketBuffer1.putByte(var10.length() + 1);
            Client.secretPacketBuffer1.method3150(var10);
            return 1;
         } else {
            String var4;
            int var7;
            if(var0 == 3107) {
               var7 = class83.intStack[--class165.intStackSize];
               var4 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
               Preferences.method1574(var7, var4);
               return 1;
            } else if(var0 == 3108) {
               class165.intStackSize -= 3;
               var7 = class83.intStack[class165.intStackSize];
               var12 = class83.intStack[class165.intStackSize + 1];
               int var9 = class83.intStack[class165.intStackSize + 2];
               Widget var6 = class177.method3390(var9);
               class51.method750(var6, var7, var12);
               return 1;
            } else if(var0 == 3109) {
               class165.intStackSize -= 2;
               var7 = class83.intStack[class165.intStackSize];
               var12 = class83.intStack[class165.intStackSize + 1];
               Widget var11 = var2?class278.field3737:class37.field515;
               class51.method750(var11, var7, var12);
               return 1;
            } else if(var0 == 3110) {
               ItemLayer.field1798 = class83.intStack[--class165.intStackSize] == 1;
               return 1;
            } else if(var0 == 3111) {
               class83.intStack[++class165.intStackSize - 1] = class66.field801.field1318?1:0;
               return 1;
            } else if(var0 == 3112) {
               class66.field801.field1318 = class83.intStack[--class165.intStackSize] == 1;
               WorldMapType3.method232();
               return 1;
            } else if(var0 == 3113) {
               var10 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
               boolean var8 = class83.intStack[--class165.intStackSize] == 1;
               class7.method44(var10, var8, "openjs", false);
               return 1;
            } else if(var0 == 3115) {
               var7 = class83.intStack[--class165.intStackSize];
               Client.secretPacketBuffer1.putOpcode(232);
               Client.secretPacketBuffer1.putShort(var7);
               return 1;
            } else if(var0 == 3116) {
               var7 = class83.intStack[--class165.intStackSize];
               ISAACCipher.scriptStringStackSize -= 2;
               var4 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize];
               String var5 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize + 1];
               if(var4.length() > 500) {
                  return 1;
               } else if(var5.length() > 500) {
                  return 1;
               } else {
                  Client.secretPacketBuffer1.putOpcode(6);
                  Client.secretPacketBuffer1.putShort(Script.method1836(var4) + 1 + Script.method1836(var5));
                  Client.secretPacketBuffer1.method3150(var5);
                  Client.secretPacketBuffer1.method3185(var7);
                  Client.secretPacketBuffer1.method3150(var4);
                  return 1;
               }
            } else if(var0 == 3117) {
               Client.field1179 = class83.intStack[--class165.intStackSize] == 1;
               return 1;
            } else {
               return 2;
            }
         }
      } else {
         Client.secretPacketBuffer1.putOpcode(169);

         for(WidgetNode var3 = (WidgetNode)Client.componentTable.method3548(); var3 != null; var3 = (WidgetNode)Client.componentTable.method3556()) {
            if(var3.field816 == 0 || var3.field816 == 3) {
               WorldMapType3.method231(var3, true);
            }
         }

         if(Client.field1147 != null) {
            CombatInfo1.method1515(Client.field1147);
            Client.field1147 = null;
         }

         return 1;
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "912125432"
   )
   static final void method743() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.method3622(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.method3608()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class267.method4888(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
