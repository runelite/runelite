import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("i")
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1517100313
   )
   static int field667;
   @ObfuscatedName("co")
   static int[] field676;
   @ObfuscatedName("ca")
   public static boolean[] field659;
   @ObfuscatedName("cf")
   static int[] field665;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -345213379
   )
   static int field673;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1195195041
   )
   static int field663;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1536882955
   )
   static int field672;
   @ObfuscatedName("cj")
   static char[] field660;
   @ObfuscatedName("cr")
   static int[] field669;
   @ObfuscatedName("cz")
   public static int[] field670;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -398072213
   )
   public static int field671;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -979221669
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1036662863
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 440297159
   )
   static int field674;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1378839515
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;

   static {
      keyboard = new KeyFocusListener();
      field659 = new boolean[112];
      field665 = new int[128];
      field663 = 0;
      field667 = 0;
      field660 = new char[128];
      field669 = new int[128];
      field670 = new int[128];
      field671 = 0;
      field672 = 0;
      field673 = 0;
      field674 = 0;
      keyboardIdleTicks = 0;
      field676 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label59: {
                  if(var2 != 0) {
                     char[] var7 = class266.field3668;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label59;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field673 + 1 & 127;
               if(var4 != field672) {
                  field669[field673] = -1;
                  field660[field673] = var2;
                  field673 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field667 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field676.length) {
            var2 = field676[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field667 >= 0 && var2 >= 0) {
            field665[field667] = ~var2;
            field667 = field667 + 1 & 127;
            if(field667 == field663) {
               field667 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field676.length) {
            var2 = field676[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field667 >= 0 && var2 >= 0) {
            field665[field667] = var2;
            field667 = field667 + 1 & 127;
            if(field667 == field663) {
               field667 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field673 + 1 & 127;
            if(var3 != field672) {
               field669[field673] = var2;
               field660[field673] = 0;
               field673 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;S)Ljava/lang/String;",
      garbageValue = "-25356"
   )
   static String method788(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class177.method3365(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(class20.field339 != null) {
               var7 = class23.method160(class20.field339.field2245);
               if(class20.field339.value != null) {
                  var7 = (String)class20.field339.value;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "11"
   )
   static final void method789(String var0) {
      if(var0 != null) {
         String var1 = Player.method1179(var0, Client.field928);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = Player.method1179(var4, Client.field928);
               if(class272.method4895(var0, var1, var4, var5)) {
                  --Client.ignoreCount;

                  for(int var6 = var2; var6 < Client.ignoreCount; ++var6) {
                     Client.ignores[var6] = Client.ignores[var6 + 1];
                  }

                  Client.field1025 = Client.field1112;
                  Client.secretPacketBuffer1.putOpcode(215);
                  Client.secretPacketBuffer1.putByte(class261.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "1897520108"
   )
   static MessageNode method790(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var2.method1876(var1);
   }
}
