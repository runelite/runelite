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

@ObfuscatedName("dn")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 1101081347
   )
   protected static int field1761 = 0;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -831287065
   )
   static int field1762 = 0;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      longValue = -740869861089996859L
   )
   static long field1763 = 0L;
   @ObfuscatedName("qx")
   static boolean field1764 = false;
   @ObfuscatedName("rt")
   @ObfuscatedGetter(
      intValue = -644791379
   )
   static int field1765 = 500;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 1020098319
   )
   static int field1766 = 20;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -1099259127
   )
   static int field1767 = 1;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 517962419
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("qd")
   static long[] field1769 = new long[32];
   @ObfuscatedName("qt")
   boolean field1770 = false;
   @ObfuscatedName("rq")
   static volatile boolean field1772 = true;
   @ObfuscatedName("rc")
   public static volatile boolean field1773 = true;
   @ObfuscatedName("pb")
   static GameEngine field1774 = null;
   @ObfuscatedName("ry")
   protected static boolean field1775 = false;
   @ObfuscatedName("rp")
   protected static volatile boolean field1776 = false;
   @ObfuscatedName("rg")
   @ObfuscatedGetter(
      longValue = -2632328654031875715L
   )
   static volatile long field1777 = 0L;
   @ObfuscatedName("qr")
   static long[] field1778 = new long[32];
   @ObfuscatedName("dw")
   static byte[][] field1779;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 845265717
   )
   protected static int field1780 = 0;

   @ObfuscatedName("sn")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2114213749"
   )
   protected final void method2164(int var1, int var2, int var3) {
      try {
         if(field1774 != null) {
            ++field1762;
            if(field1762 >= 3) {
               this.method2178("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1774 = this;
         class2.field21 = var1;
         class20.field216 = var2;
         class101.field1650 = var3;
         class101.field1645 = this;
         if(null == class25.field579) {
            class25.field579 = new class103();
         }

         class25.field579.method2031(this, 1);
      } catch (Exception var5) {
         FaceNormal.method1950((String)null, var5);
         this.method2178("crash");
      }

   }

   public void destroy() {
      if(field1774 == this && !field1764) {
         field1763 = ChatMessages.method935();
         class115.method2301(5000L);
         this.method2175();
      }
   }

   @ObfuscatedName("sm")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1251835943"
   )
   protected final boolean method2165() {
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
                     this.method2178("invalidhost");
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
         int var3;
         if(null != class103.field1661) {
            String var1 = class103.field1661.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1660;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2178("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  for(var3 = 6; var3 < var2.length() && DecorativeObject.method1978(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var7 = false;
                  boolean var8 = false;
                  int var9 = 0;
                  int var10 = var4.length();
                  int var11 = 0;

                  boolean var6;
                  while(true) {
                     if(var11 >= var10) {
                        var6 = var8;
                        break;
                     }

                     label186: {
                        char var12 = var4.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == 45) {
                              var7 = true;
                              break label186;
                           }

                           if(var12 == 43) {
                              break label186;
                           }
                        }

                        int var18;
                        if(var12 >= 48 && var12 <= 57) {
                           var18 = var12 - 48;
                        } else if(var12 >= 65 && var12 <= 90) {
                           var18 = var12 - 55;
                        } else {
                           if(var12 < 97 || var12 > 122) {
                              var6 = false;
                              break;
                           }

                           var18 = var12 - 87;
                        }

                        if(var18 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var18 = -var18;
                        }

                        int var13 = var9 * 10 + var18;
                        if(var13 / 10 != var9) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6 && Overlay.method3854(var4) < 10) {
                     this.method2178("wrongjava");
                     return;
                  }
               }

               field1767 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2221();
         this.vmethod2174();
         class36.field770 = class88.method1934();

         label104:
         while(true) {
            class103 var16;
            Canvas var17;
            do {
               if(field1763 != 0L && ChatMessages.method935() >= field1763) {
                  break label104;
               }

               class40.field806 = class36.field770.vmethod2103(field1766, field1767);

               for(int var14 = 0; var14 < class40.field806; ++var14) {
                  this.method2166();
               }

               this.method2227();
               var16 = class25.field579;
               var17 = class0.canvas;
            } while(var16.field1666 == null);

            for(var3 = 0; var3 < 50 && var16.field1666.peekEvent() != null; ++var3) {
               class115.method2301(1L);
            }

            if(var17 != null) {
               var16.field1666.postEvent(new ActionEvent(var17, 1001, "dummy"));
            }
         }
      } catch (Exception var15) {
         FaceNormal.method1950((String)null, var15);
         this.method2178("crash");
      }

      this.method2175();
   }

   @ObfuscatedName("sb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1275631118"
   )
   void method2166() {
      long var1 = ChatMessages.method935();
      long var3 = field1778[class33.field735];
      field1778[class33.field735] = var1;
      class33.field735 = class33.field735 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class85.field1447 = field1772;
      }

      this.packetHandler();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZB)V",
      garbageValue = "105"
   )
   public static void method2168(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1915 = 1;
      class138.field1918 = var0;
      class20.field205 = var1;
      class85.field1446 = var2;
      FaceNormal.field1561 = var3;
      class105.field1713 = var4;
      class138.field1917 = 10000;
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      field1772 = true;
      field1773 = true;
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public void stop() {
      if(field1774 == this && !field1764) {
         field1763 = ChatMessages.method935() + 4000L;
      }
   }

   public abstract void init();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "741615720"
   )
   protected abstract void vmethod2174();

   @ObfuscatedName("sr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   final synchronized void method2175() {
      if(!field1764) {
         field1764 = true;

         try {
            class0.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2177();
         } catch (Exception var4) {
            ;
         }

         if(null != Item.field881) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class25.field579 != null) {
            try {
               class25.field579.method2029();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2181();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2009460796"
   )
   protected abstract void vmethod2176();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "130923589"
   )
   protected abstract void vmethod2177();

   @ObfuscatedName("sg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-25695880"
   )
   protected void method2178(String var1) {
      if(!this.field1770) {
         this.field1770 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("sj")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "538331421"
   )
   protected Dimension method2180() {
      Container var1 = this.method2220();
      int var2 = Math.max(var1.getWidth(), class177.field2666);
      int var3 = Math.max(var1.getHeight(), class94.field1583);
      if(null != Item.field881) {
         Insets var4 = Item.field881.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1100979627"
   )
   protected abstract void vmethod2181();

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public void start() {
      if(field1774 == this && !field1764) {
         field1763 = 0L;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass186;",
      garbageValue = "16711680"
   )
   public static class186 method2217(int var0) {
      class186 var1 = (class186)class186.field2763.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class186.field2764.getConfigData(5, var0);
         var1 = new class186();
         if(null != var2) {
            var1.method3490(new Buffer(var2));
         }

         class186.field2763.put(var1, (long)var0);
         return var1;
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field1774 && !field1764) {
         field1773 = true;
         if(null != class103.field1660 && class103.field1660.startsWith("1.5") && ChatMessages.method935() - field1777 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class2.field21 && var2.height >= class20.field216) {
               field1776 = true;
            }
         }

      }
   }

   @ObfuscatedName("ss")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "-12"
   )
   protected Container method2220() {
      return (Container)(Item.field881 != null?Item.field881:this);
   }

   @ObfuscatedName("si")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "66"
   )
   protected final synchronized void method2221() {
      Container var1 = this.method2220();
      if(null != class0.canvas) {
         class0.canvas.removeFocusListener(this);
         var1.remove(class0.canvas);
      }

      class2.field21 = Math.max(var1.getWidth(), class177.field2666);
      class20.field216 = Math.max(var1.getHeight(), class94.field1583);
      Insets var2;
      if(null != Item.field881) {
         var2 = Item.field881.getInsets();
         class2.field21 -= var2.left + var2.right;
         class20.field216 -= var2.top + var2.bottom;
      }

      class0.canvas = new RSCanvas(this);
      var1.add(class0.canvas);
      class0.canvas.setSize(class2.field21, class20.field216);
      class0.canvas.setVisible(true);
      if(Item.field881 == var1) {
         var2 = Item.field881.getInsets();
         class0.canvas.setLocation(var2.left + field1761, var2.top + field1780);
      } else {
         class0.canvas.setLocation(field1761, field1780);
      }

      class0.canvas.addFocusListener(this);
      class0.canvas.requestFocus();
      field1773 = true;
      BufferProvider var3 = class22.method223(class2.field21, class20.field216, class0.canvas);
      if(null != class22.bufferProvider) {
         class22.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      class22.bufferProvider = var3;
      field1776 = false;
      field1777 = ChatMessages.method935();
   }

   @ObfuscatedName("sy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "65535"
   )
   void method2227() {
      Container var1 = this.method2220();
      long var2 = ChatMessages.method935();
      long var4 = field1769[class9.field80];
      field1769[class9.field80] = var2;
      class9.field80 = 1 + class9.field80 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = (32000 + (var6 >> 1)) / var6;
      }

      if(++field1765 - 1 > 50) {
         field1765 -= 50;
         field1773 = true;
         class0.canvas.setSize(class2.field21, class20.field216);
         class0.canvas.setVisible(true);
         if(var1 == Item.field881) {
            Insets var7 = Item.field881.getInsets();
            class0.canvas.setLocation(var7.left + field1761, var7.top + field1780);
         } else {
            class0.canvas.setLocation(field1761, field1780);
         }
      }

      this.vmethod2176();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1035239250"
   )
   protected abstract void packetHandler();

   public final void focusLost(FocusEvent var1) {
      field1772 = false;
   }
}
