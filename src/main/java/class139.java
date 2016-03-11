import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class139 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -2872537875825431663L
   )
   public static long field2156 = 0L;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 297635917
   )
   public static volatile int field2157 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -830007797
   )
   public static volatile int field2158 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -322415873
   )
   public static volatile int field2159 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1056622207
   )
   public static volatile int field2160 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 693812993
   )
   public static int field2161 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -36763061
   )
   public static int field2162 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 146197761
   )
   public static int field2163 = 0;
   @ObfuscatedName("j")
   public static class139 field2164 = new class139();
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1066914613
   )
   public static volatile int field2165 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1104085871
   )
   public static volatile int field2166 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 3423388795055634613L
   )
   public static volatile long field2167 = 0L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -156634355
   )
   public static int field2168 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1088176559
   )
   public static int field2169 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2094169891
   )
   public static volatile int field2170 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1192950665
   )
   public static int field2171 = 0;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2164) {
         field2170 = 0;
         field2165 = var1.getX();
         field2166 = var1.getY();
         field2167 = class109.method2381();
         if(var1.isAltDown()) {
            field2159 = 4;
            field2158 = 4;
         } else if(var1.isMetaDown()) {
            field2159 = 2;
            field2158 = 2;
         } else {
            field2159 = 1;
            field2158 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != field2164) {
         field2170 = 0;
         field2158 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(field2164 != null) {
         field2170 = 0;
         field2157 = var1.getX();
         field2160 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2164) {
         field2158 = 0;
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(field2164 != null) {
         field2170 = 0;
         field2157 = -1;
         field2160 = -1;
      }

   }

   @ObfuscatedName("a")
   static int method2893(int var0) {
      class27 var1 = (class27)class11.field174.get(Integer.valueOf(var0));
      return null == var1?0:var1.method640();
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != field2164) {
         field2170 = 0;
         field2157 = var1.getX();
         field2160 = var1.getY();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(field2164 != null) {
         field2170 = 0;
         field2157 = var1.getX();
         field2160 = var1.getY();
      }

   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-61"
   )
   static final void method2913() {
      class109.method2382();
      if(null == class132.field2073) {
         if(null == client.field536) {
            int var0 = field2168;
            int var1;
            int var2;
            int var3;
            int var6;
            int var7;
            int var14;
            int var15;
            String var10000;
            if(client.field308) {
               if(1 != var0 && (class94.field1617 || 4 != var0)) {
                  var1 = field2162;
                  var2 = field2171;
                  if(var1 < class136.field2114 - 10 || var1 > 10 + class74.field1373 + class136.field2114 || var2 < class75.field1387 - 10 || var2 > 10 + class75.field1387 + client.field429) {
                     client.field308 = false;
                     class159.method3134(class136.field2114, class75.field1387, class74.field1373, client.field429);
                  }
               }

               if(var0 == 1 || !class94.field1617 && 4 == var0) {
                  var1 = class136.field2114;
                  var2 = class75.field1387;
                  var3 = class74.field1373;
                  var14 = field2169;
                  var15 = field2163;
                  var6 = -1;

                  int var8;
                  for(var7 = 0; var7 < client.field430; ++var7) {
                     var8 = var2 + 31 + 15 * (client.field430 - 1 - var7);
                     if(var14 > var1 && var14 < var1 + var3 && var15 > var8 - 13 && var15 < var8 + 3) {
                        var6 = var7;
                     }
                  }

                  if(-1 != var6 && var6 >= 0) {
                     var7 = client.field431[var6];
                     var8 = client.field432[var6];
                     int var9 = client.field433[var6];
                     int var10 = client.field523[var6];
                     var10000 = client.field437[var6];
                     String var12 = client.field365[var6];
                     class83.method1863(var7, var8, var9, var10, var12, field2169, field2163);
                  }

                  client.field308 = false;
                  class159.method3134(class136.field2114, class75.field1387, class74.field1373, client.field429);
               }
            } else {
               if((1 == var0 || !class94.field1617 && 4 == var0) && client.field430 > 0) {
                  var1 = client.field433[client.field430 - 1];
                  if(39 == var1 || 40 == var1 || 41 == var1 || var1 == 42 || var1 == 43 || 33 == var1 || var1 == 34 || 35 == var1 || 36 == var1 || 37 == var1 || var1 == 38 || 1005 == var1) {
                     label333: {
                        var2 = client.field431[client.field430 - 1];
                        var3 = client.field432[client.field430 - 1];
                        class172 var4 = class31.method698(var3);
                        boolean var5;
                        if(!class86.method2050(class42.method898(var4))) {
                           var6 = class42.method898(var4);
                           var5 = 0 != (var6 >> 29 & 1);
                           if(!var5) {
                              break label333;
                           }
                        }

                        if(class132.field2073 != null && !client.field543 && 1 != client.field427) {
                           var6 = client.field430 - 1;
                           if(var6 < 0) {
                              var5 = false;
                           } else {
                              var7 = client.field433[var6];
                              if(var7 >= 2000) {
                                 var7 -= 2000;
                              }

                              if(1007 == var7) {
                                 var5 = true;
                              } else {
                                 var5 = false;
                              }
                           }

                           if(!var5 && client.field430 > 0) {
                              class49.method1006(client.field533, client.field292);
                           }
                        }

                        client.field543 = false;
                        client.field341 = 0;
                        if(null != class132.field2073) {
                           class114.method2400(class132.field2073);
                        }

                        class132.field2073 = class31.method698(var3);
                        client.field535 = var2;
                        client.field533 = field2169;
                        client.field292 = field2163;
                        if(client.field430 > 0) {
                           var15 = client.field430 - 1;
                           class11.field180 = new class30();
                           class11.field180.field704 = client.field431[var15];
                           class11.field180.field696 = client.field432[var15];
                           class11.field180.field705 = client.field433[var15];
                           class11.field180.field698 = client.field523[var15];
                           class11.field180.field697 = client.field437[var15];
                        }

                        class114.method2400(class132.field2073);
                        return;
                     }
                  }
               }

               if(1 == var0 || !class94.field1617 && 4 == var0) {
                  label337: {
                     if(client.field427 != 1 || client.field430 <= 2) {
                        var2 = client.field430 - 1;
                        boolean var13;
                        if(var2 < 0) {
                           var13 = false;
                        } else {
                           var3 = client.field433[var2];
                           if(var3 >= 2000) {
                              var3 -= 2000;
                           }

                           if(1007 == var3) {
                              var13 = true;
                           } else {
                              var13 = false;
                           }
                        }

                        if(!var13) {
                           break label337;
                        }
                     }

                     var0 = 2;
                  }
               }

               if((1 == var0 || !class94.field1617 && var0 == 4) && client.field430 > 0) {
                  var1 = client.field430 - 1;
                  if(var1 >= 0) {
                     var2 = client.field431[var1];
                     var3 = client.field432[var1];
                     var14 = client.field433[var1];
                     var15 = client.field523[var1];
                     var10000 = client.field437[var1];
                     String var16 = client.field365[var1];
                     class83.method1863(var2, var3, var14, var15, var16, field2169, field2163);
                  }
               }

               if(var0 == 2 && client.field430 > 0) {
                  class19.method212(field2169, field2163);
               }
            }

         }
      }
   }
}
