import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public final class class137 implements KeyListener, FocusListener {
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1168449763
   )
   static int field2118 = 0;
   @ObfuscatedName("s")
   public static class137 field2119 = new class137();
   @ObfuscatedName("ck")
   public static boolean[] field2120 = new boolean[112];
   @ObfuscatedName("cc")
   static char[] field2127 = new char[128];
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1052333759
   )
   public static int field2133;
   @ObfuscatedName("ce")
   static int[] field2134 = new int[128];
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1364809143
   )
   static int field2136 = 0;
   @ObfuscatedName("cp")
   static int[] field2138 = new int[128];
   @ObfuscatedName("cz")
   public static int[] field2139 = new int[128];
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 902452547
   )
   public static int field2140 = 0;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -1314549165
   )
   static int field2141 = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1798156569
   )
   static int field2142 = 0;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1736629939
   )
   static int field2143 = 0;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1092083941
   )
   static volatile int field2144 = 0;
   @ObfuscatedName("cq")
   public static int[] field2145 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

   public final synchronized void keyPressed(KeyEvent var1) {
      if(field2119 != null) {
         field2144 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2145.length) {
            var2 = field2145[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2136 >= 0 && var2 >= 0) {
            field2134[field2136] = var2;
            field2136 = 1 + field2136 & 127;
            if(field2118 == field2136) {
               field2136 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field2142 & 127;
            if(field2141 != var3) {
               field2138[field2142] = var2;
               field2127[field2142] = 0;
               field2142 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || 85 == var2 || 10 == var2) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(field2119 != null) {
         field2144 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2145.length) {
            var2 = field2145[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2136 >= 0 && var2 >= 0) {
            field2134[field2136] = ~var2;
            field2136 = field2136 + 1 & 127;
            if(field2136 == field2118) {
               field2136 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(field2119 != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && '\uffff' != var2) {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label71: {
                  if(0 != var2) {
                     char[] var4 = class165.field2669;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label71;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var7 = 1 + field2142 & 127;
               if(field2141 != var7) {
                  field2138[field2142] = -1;
                  field2127[field2142] = var2;
                  field2142 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1015217758"
   )
   static final void method2895(String var0) {
      if(var0 != null) {
         String var1 = class32.method690(var0, class1.field24);
         if(var1 != null) {
            for(int var2 = 0; var2 < client.field550; ++var2) {
               class7 var3 = client.field344[var2];
               String var4 = var3.field133;
               String var5 = class32.method690(var4, class1.field24);
               boolean var6;
               if(null != var0 && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --client.field550;

                  for(int var7 = var2; var7 < client.field550; ++var7) {
                     client.field344[var7] = client.field344[1 + var7];
                  }

                  client.field470 = client.field462;
                  client.field322.method2737(196);
                  client.field322.method2477(class30.method647(var0));
                  client.field322.method2483(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1788686290"
   )
   public static void method2896(Component var0) {
      var0.removeMouseListener(class140.field2158);
      var0.removeMouseMotionListener(class140.field2158);
      var0.removeFocusListener(class140.field2158);
      class140.field2171 = 0;
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2119 != null) {
         field2136 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;B)Lclass80;",
      garbageValue = "-37"
   )
   public static class80 method2910(class167 var0, String var1, String var2) {
      int var3 = var0.method3253(var1);
      int var4 = var0.method3254(var3, var2);
      class80 var5;
      if(!class35.method714(var0, var3, var4)) {
         var5 = null;
      } else {
         class80 var7 = new class80();
         var7.field1425 = class226.field3214;
         var7.field1432 = class76.field1386;
         var7.field1428 = class76.field1387[0];
         var7.field1431 = class76.field1390[0];
         var7.field1427 = class76.field1389[0];
         var7.field1429 = class9.field159[0];
         var7.field1426 = class76.field1396;
         var7.field1430 = class21.field575[0];
         class27.method633();
         var5 = var7;
      }

      return var5;
   }
}
