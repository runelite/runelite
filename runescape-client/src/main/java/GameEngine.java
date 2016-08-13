import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -1414177189
   )
   static int field2251 = 20;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = 325039805
   )
   static int field2252 = 0;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      longValue = 2076138819687844761L
   )
   static long field2253 = 0L;
   @ObfuscatedName("pg")
   static boolean field2254 = false;
   @ObfuscatedName("pd")
   boolean field2255;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = 9098071
   )
   static int field2256 = 1;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 566740855
   )
   static int field2258 = 500;
   @ObfuscatedName("qt")
   protected static long[] field2259 = new long[32];
   @ObfuscatedName("qd")
   protected static long[] field2260 = new long[32];
   @ObfuscatedName("rv")
   static volatile boolean field2261 = true;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 1189694439
   )
   protected static int field2262 = 0;
   @ObfuscatedName("qe")
   public static volatile boolean field2263 = true;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -592561851
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("qi")
   protected static boolean field2265 = false;
   @ObfuscatedName("qx")
   protected static volatile boolean field2266 = false;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      longValue = -7721056355659316701L
   )
   static volatile long field2267 = 0L;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -719269089
   )
   protected static int field2268 = 0;
   @ObfuscatedName("pp")
   static GameEngine field2270 = null;

   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "53"
   )
   protected final void method3155(int var1, int var2, int var3) {
      try {
         if(field2270 != null) {
            ++field2252;
            if(field2252 >= 3) {
               this.method3170("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2270 = this;
         class189.field3056 = var1;
         Actor.field892 = var2;
         class151.field2284 = var3;
         class151.field2286 = this;
         if(null == class125.field2070) {
            class125.field2070 = new class139();
         }

         class125.field2070.method3029(this, 1);
      } catch (Exception var5) {
         class13.method176((String)null, var5);
         this.method3170("crash");
      }

   }

   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1932774633"
   )
   protected final synchronized void method3156() {
      Container var1 = this.method3174();
      if(class107.canvas != null) {
         class107.canvas.removeFocusListener(this);
         var1.remove(class107.canvas);
      }

      class189.field3056 = Math.max(var1.getWidth(), ItemLayer.field1757);
      Actor.field892 = Math.max(var1.getHeight(), class128.field2089);
      Insets var2;
      if(class114.field2013 != null) {
         var2 = class114.field2013.getInsets();
         class189.field3056 -= var2.right + var2.left;
         Actor.field892 -= var2.top + var2.bottom;
      }

      class107.canvas = new RSCanvas(this);
      var1.add(class107.canvas);
      class107.canvas.setSize(class189.field3056, Actor.field892);
      class107.canvas.setVisible(true);
      if(var1 == class114.field2013) {
         var2 = class114.field2013.getInsets();
         class107.canvas.setLocation(field2268 + var2.left, var2.top + field2262);
      } else {
         class107.canvas.setLocation(field2268, field2262);
      }

      class107.canvas.addFocusListener(this);
      class107.canvas.requestFocus();
      field2263 = true;
      BufferProvider var3 = class21.method573(class189.field3056, Actor.field892, class107.canvas);
      if(class54.bufferProvider != null) {
         class54.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      class54.bufferProvider = var3;
      field2266 = false;
      field2267 = class56.method1249();
   }

   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-124"
   )
   protected final boolean method3157() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(!var1.equals("mechscape.com") && !var1.endsWith(".mechscape.com")) {
               if(var1.endsWith("127.0.0.1")) {
                  return true;
               } else {
                  while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= 48 && var1.charAt(var1.length() - 1) <= 57) {
                     var1 = var1.substring(0, var1.length() - 1);
                  }

                  if(var1.endsWith("192.168.1.")) {
                     return true;
                  } else {
                     this.method3170("invalidhost");
                     return false;
                  }
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   public void run() {
      try {
         int var1;
         if(null != class139.field2152) {
            String var2 = class139.field2152.toLowerCase();
            if(var2.indexOf("sun") != -1 || var2.indexOf("apple") != -1) {
               String var3 = class139.field2146;
               if(var3.equals("1.1") || var3.startsWith("1.1.") || var3.equals("1.2") || var3.startsWith("1.2.") || var3.equals("1.3") || var3.startsWith("1.3.") || var3.equals("1.4") || var3.startsWith("1.4.") || var3.equals("1.5") || var3.startsWith("1.5.") || var3.equals("1.6.0")) {
                  this.method3170("wrongjava");
                  return;
               }

               if(var3.startsWith("1.6.0_")) {
                  for(var1 = 6; var1 < var3.length() && class40.method812(var3.charAt(var1)); ++var1) {
                     ;
                  }

                  String var4 = var3.substring(6, var1);
                  boolean var5 = false;
                  boolean var6 = false;
                  int var7 = 0;
                  int var8 = var4.length();
                  int var9 = 0;

                  boolean var10;
                  while(true) {
                     if(var9 >= var8) {
                        var10 = var6;
                        break;
                     }

                     label186: {
                        char var11 = var4.charAt(var9);
                        if(var9 == 0) {
                           if(var11 == 45) {
                              var5 = true;
                              break label186;
                           }

                           if(var11 == 43) {
                              break label186;
                           }
                        }

                        int var12;
                        if(var11 >= 48 && var11 <= 57) {
                           var12 = var11 - 48;
                        } else if(var11 >= 65 && var11 <= 90) {
                           var12 = var11 - 55;
                        } else {
                           if(var11 < 97 || var11 > 122) {
                              var10 = false;
                              break;
                           }

                           var12 = var11 - 87;
                        }

                        if(var12 >= 10) {
                           var10 = false;
                           break;
                        }

                        if(var5) {
                           var12 = -var12;
                        }

                        int var13 = var12 + 10 * var7;
                        if(var13 / 10 != var7) {
                           var10 = false;
                           break;
                        }

                        var7 = var13;
                        var6 = true;
                     }

                     ++var9;
                  }

                  if(var10) {
                     int var18 = class5.method91(var4, 10, true);
                     if(var18 < 10) {
                        this.method3170("wrongjava");
                        return;
                     }
                  }
               }

               field2256 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3156();
         this.vmethod3166();
         GroundObject.field1669 = class53.method1137();

         label104:
         while(true) {
            class139 var15;
            Canvas var16;
            do {
               if(0L != field2253 && class56.method1249() >= field2253) {
                  break label104;
               }

               class45.field1050 = GroundObject.field1669.vmethod3261(field2251, field2256);

               for(int var17 = 0; var17 < class45.field1050; ++var17) {
                  this.method3158();
               }

               this.method3159();
               var15 = class125.field2070;
               var16 = class107.canvas;
            } while(null == var15.field2151);

            for(var1 = 0; var1 < 50 && var15.field2151.peekEvent() != null; ++var1) {
               class22.method594(1L);
            }

            if(null != var16) {
               var15.field2151.postEvent(new ActionEvent(var16, 1001, "dummy"));
            }
         }
      } catch (Exception var14) {
         class13.method176((String)null, var14);
         this.method3170("crash");
      }

      this.method3189();
   }

   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "230061674"
   )
   void method3158() {
      long var1 = class56.method1249();
      long var3 = field2260[ChatMessages.field286];
      field2260[ChatMessages.field286] = var1;
      ChatMessages.field286 = 1 + ChatMessages.field286 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class54.field1172 = field2261;
      }

      this.packetHandler();
   }

   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "485557939"
   )
   void method3159() {
      Container var1 = this.method3174();
      long var2 = class56.method1249();
      long var4 = field2259[GameObject.field1745];
      field2259[GameObject.field1745] = var2;
      GameObject.field1745 = GameObject.field1745 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field2258 - 1 > 50) {
         field2258 -= 50;
         field2263 = true;
         class107.canvas.setSize(class189.field3056, Actor.field892);
         class107.canvas.setVisible(true);
         if(class114.field2013 == var1) {
            Insets var7 = class114.field2013.getInsets();
            class107.canvas.setLocation(var7.left + field2268, field2262 + var7.top);
         } else {
            class107.canvas.setLocation(field2268, field2262);
         }
      }

      this.vmethod3225();
   }

   public void stop() {
      if(this == field2270 && !field2254) {
         field2253 = class56.method1249() + 4000L;
      }

   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2270 && !field2254) {
         field2263 = true;
         if(class139.field2146 != null && class139.field2146.startsWith("1.5") && class56.method1249() - field2267 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class189.field3056 && var2.height >= Actor.field892) {
               field2266 = true;
            }
         }
      }

   }

   public final void focusLost(FocusEvent var1) {
      field2261 = false;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   protected abstract void vmethod3166();

   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1479444814"
   )
   protected void method3170(String var1) {
      if(!this.field2255) {
         this.field2255 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "-1159034136"
   )
   protected Dimension method3172() {
      Container var1 = this.method3174();
      int var2 = Math.max(var1.getWidth(), ItemLayer.field1757);
      int var3 = Math.max(var1.getHeight(), class128.field2089);
      if(null != class114.field2013) {
         Insets var4 = class114.field2013.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "265552880"
   )
   protected abstract void vmethod3173();

   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1527425134"
   )
   protected Container method3174() {
      return (Container)(class114.field2013 != null?class114.field2013:this);
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      field2261 = true;
      field2263 = true;
   }

   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-824891580"
   )
   final synchronized void method3189() {
      if(!field2254) {
         field2254 = true;

         try {
            class107.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3234();
         } catch (Exception var4) {
            ;
         }

         if(null != class114.field2013) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class125.field2070) {
            try {
               class125.field2070.method3026();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3173();
      }

   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public void start() {
      if(this == field2270 && !field2254) {
         field2253 = 0L;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   protected abstract void vmethod3225();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1575533843"
   )
   protected abstract void vmethod3234();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lclass56;",
      garbageValue = "-2"
   )
   public static class56 method3242(int var0) {
      class56 var1 = (class56)class56.field1231.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class56.field1232.method3411(16, var0);
         var1 = new class56();
         if(null != var2) {
            var1.method1236(new Buffer(var2));
         }

         class56.field1231.put(var1, (long)var0);
         return var1;
      }
   }

   public void destroy() {
      if(field2270 == this && !field2254) {
         field2253 = class56.method1249();
         class22.method594(5000L);
         this.method3189();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1031914960"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "424460431"
   )
   static final void method3250(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3 && var3.parentId == var1 && (!var3.field2855 || !class9.method132(var3))) {
            int var4;
            if(var3.type == 0) {
               if(!var3.field2855 && class9.method132(var3) && var3 != class11.field177) {
                  continue;
               }

               method3250(var0, var3.id);
               if(null != var3.children) {
                  method3250(var3.children, var3.id);
               }

               WidgetNode var5 = (WidgetNode)Client.componentTable.method3936((long)var3.id);
               if(null != var5) {
                  var4 = var5.id;
                  if(class14.method179(var4)) {
                     method3250(Widget.widgets[var4], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2854 != -1 || var3.field2923 != -1) {
                  boolean var7 = class53.method1149(var3);
                  if(var7) {
                     var4 = var3.field2923;
                  } else {
                     var4 = var3.field2854;
                  }

                  if(var4 != -1) {
                     Sequence var6 = class22.getAnimation(var4);

                     for(var3.field2930 += Client.field370; var3.field2930 > var6.field1018[var3.field2929]; class79.method1777(var3)) {
                        var3.field2930 -= var6.field1018[var3.field2929];
                        ++var3.field2929;
                        if(var3.field2929 >= var6.field1030.length) {
                           var3.field2929 -= var6.field1020;
                           if(var3.field2929 < 0 || var3.field2929 >= var6.field1030.length) {
                              var3.field2929 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2863 != 0 && !var3.field2855) {
                  int var8 = var3.field2863 >> 16;
                  var4 = var3.field2863 << 16 >> 16;
                  var8 *= Client.field370;
                  var4 *= Client.field370;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var4 + var3.rotationZ & 2047;
                  class79.method1777(var3);
               }
            }
         }
      }

   }
}
