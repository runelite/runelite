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
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qv")
   protected static volatile boolean field1768 = false;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      longValue = 6099442957557589477L
   )
   static volatile long field1769 = 0L;
   @ObfuscatedName("qu")
   static long[] field1770 = new long[32];
   @ObfuscatedName("pr")
   static boolean field1771 = false;
   @ObfuscatedName("pw")
   boolean field1772;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -1308399215
   )
   static int field1773 = 20;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -32453397
   )
   static int field1774 = 1;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 438914815
   )
   protected static int field1775 = 0;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -734583143
   )
   protected static int field1776 = 0;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = -1807908667
   )
   static int field1777 = 0;
   @ObfuscatedName("pf")
   static GameEngine field1778 = null;
   @ObfuscatedName("qs")
   static long[] field1779 = new long[32];
   @ObfuscatedName("qk")
   protected static volatile boolean field1780 = true;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 352059097
   )
   static int field1781 = 500;
   @ObfuscatedName("qf")
   protected static boolean field1782 = false;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -1316327787
   )
   protected static int field1783 = 0;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      longValue = -45255338001434591L
   )
   static long field1784 = 0L;
   @ObfuscatedName("ri")
   static volatile boolean field1785 = true;

   @ObfuscatedName("rl")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-6454"
   )
   void method2147() {
      Container var1 = this.method2156();
      long var2 = class202.method3838();
      long var4 = field1770[Item.field882];
      field1770[Item.field882] = var2;
      Item.field882 = Item.field882 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field1775 = ((var6 >> 1) + 32000) / var6;
      }

      if(++field1781 - 1 > 50) {
         field1781 -= 50;
         field1780 = true;
         class107.canvas.setSize(class16.field169, class65.field1103);
         class107.canvas.setVisible(true);
         if(MessageNode.field230 == var1) {
            Insets var7 = MessageNode.field230.getInsets();
            class107.canvas.setLocation(field1776 + var7.left, var7.top + field1783);
         } else {
            class107.canvas.setLocation(field1776, field1783);
         }
      }

      this.vmethod2245();
   }

   @ObfuscatedName("rm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2107710349"
   )
   protected final synchronized void method2149() {
      Container var1 = this.method2156();
      if(class107.canvas != null) {
         class107.canvas.removeFocusListener(this);
         var1.remove(class107.canvas);
      }

      class16.field169 = Math.max(var1.getWidth(), class7.field63);
      class65.field1103 = Math.max(var1.getHeight(), SecondaryBufferProvider.field3197);
      Insets var2;
      if(null != MessageNode.field230) {
         var2 = MessageNode.field230.getInsets();
         class16.field169 -= var2.left + var2.right;
         class65.field1103 -= var2.bottom + var2.top;
      }

      class107.canvas = new RSCanvas(this);
      var1.add(class107.canvas);
      class107.canvas.setSize(class16.field169, class65.field1103);
      class107.canvas.setVisible(true);
      if(MessageNode.field230 == var1) {
         var2 = MessageNode.field230.getInsets();
         class107.canvas.setLocation(var2.left + field1776, field1783 + var2.top);
      } else {
         class107.canvas.setLocation(field1776, field1783);
      }

      class107.canvas.addFocusListener(this);
      class107.canvas.requestFocus();
      field1780 = true;
      BufferProvider var3 = class116.method2298(class16.field169, class65.field1103, class107.canvas);
      if(null != class34.bufferProvider) {
         class34.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      class34.bufferProvider = var3;
      field1768 = false;
      field1769 = class202.method3838();
   }

   @ObfuscatedName("rp")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2050256969"
   )
   protected final boolean method2150() {
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
                     this.method2208("invalidhost");
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

   @ObfuscatedName("rr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-123"
   )
   void method2152() {
      long var1 = class202.method3838();
      long var3 = field1779[class101.field1648];
      field1779[class101.field1648] = var1;
      class101.field1648 = 1 + class101.field1648 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class63.field1083 = field1785;
      }

      this.packetHandler();
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public void destroy() {
      if(this == field1778 && !field1771) {
         field1784 = class202.method3838();
         class0.method12(5000L);
         this.method2236();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(field1778 == this && !field1771) {
         field1780 = true;
         if(null != class103.field1667 && class103.field1667.startsWith("1.5") && class202.method3838() - field1769 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class16.field169 && var2.height >= class65.field1103) {
               field1768 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field1785 = true;
      field1780 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field1785 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("rk")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "96"
   )
   protected Container method2156() {
      return (Container)(MessageNode.field230 != null?MessageNode.field230:this);
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2510"
   )
   protected abstract void vmethod2159();

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1648613444"
   )
   protected abstract void packetHandler();

   public void stop() {
      if(field1778 == this && !field1771) {
         field1784 = class202.method3838() + 4000L;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-129346549"
   )
   protected abstract void vmethod2161();

   @ObfuscatedName("ry")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Dimension;",
      garbageValue = "10"
   )
   protected Dimension method2163() {
      Container var1 = this.method2156();
      int var2 = Math.max(var1.getWidth(), class7.field63);
      int var3 = Math.max(var1.getHeight(), SecondaryBufferProvider.field3197);
      if(MessageNode.field230 != null) {
         Insets var4 = MessageNode.field230.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   public void run() {
      try {
         int var3;
         if(class103.field1672 != null) {
            String var1 = class103.field1672.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1667;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2208("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  for(var3 = 6; var3 < var2.length(); ++var3) {
                     char var5 = var2.charAt(var3);
                     boolean var4 = var5 >= 48 && var5 <= 57;
                     if(!var4) {
                        break;
                     }
                  }

                  String var14 = var2.substring(6, var3);
                  boolean var7 = false;
                  boolean var8 = false;
                  int var9 = 0;
                  int var10 = var14.length();
                  int var11 = 0;

                  boolean var6;
                  while(true) {
                     if(var11 >= var10) {
                        var6 = var8;
                        break;
                     }

                     label211: {
                        char var12 = var14.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == 45) {
                              var7 = true;
                              break label211;
                           }

                           if(var12 == 43) {
                              break label211;
                           }
                        }

                        int var19;
                        if(var12 >= 48 && var12 <= 57) {
                           var19 = var12 - 48;
                        } else if(var12 >= 65 && var12 <= 90) {
                           var19 = var12 - 55;
                        } else {
                           if(var12 < 97 || var12 > 122) {
                              var6 = false;
                              break;
                           }

                           var19 = var12 - 87;
                        }

                        if(var19 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var19 = -var19;
                        }

                        int var13 = 10 * var9 + var19;
                        if(var9 != var13 / 10) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6 && class28.method635(var14) < 10) {
                     this.method2208("wrongjava");
                     return;
                  }
               }

               field1774 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2149();
         this.vmethod2159();
         VertexNormal.field1414 = class193.method3569();

         label110:
         while(true) {
            class103 var17;
            Canvas var18;
            do {
               if(field1784 != 0L && class202.method3838() >= field1784) {
                  break label110;
               }

               class7.field60 = VertexNormal.field1414.vmethod2091(field1773, field1774);

               for(int var15 = 0; var15 < class7.field60; ++var15) {
                  this.method2152();
               }

               this.method2147();
               var17 = class15.field159;
               var18 = class107.canvas;
            } while(null == var17.field1670);

            for(var3 = 0; var3 < 50 && var17.field1670.peekEvent() != null; ++var3) {
               class0.method12(1L);
            }

            if(null != var18) {
               var17.field1670.postEvent(new ActionEvent(var18, 1001, "dummy"));
            }
         }
      } catch (Exception var16) {
         class39.method772((String)null, var16);
         this.method2208("crash");
      }

      this.method2236();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("rx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "58"
   )
   protected void method2208(String var1) {
      if(!this.field1772) {
         this.field1772 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("re")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "253078502"
   )
   protected final void method2209(int var1, int var2, int var3) {
      try {
         if(null != field1778) {
            ++field1777;
            if(field1777 >= 3) {
               this.method2208("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1778 = this;
         class16.field169 = var1;
         class65.field1103 = var2;
         class101.field1650 = var3;
         class101.field1643 = this;
         if(null == class15.field159) {
            class15.field159 = new class103();
         }

         class15.field159.method2000(this, 1);
      } catch (Exception var5) {
         class39.method772((String)null, var5);
         this.method2208("crash");
      }

   }

   public void start() {
      if(field1778 == this && !field1771) {
         field1784 = 0L;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-61"
   )
   static final void method2223() {
      if(FileOnDisk.field1183 != null) {
         FileOnDisk.field1183.method2121();
         FileOnDisk.field1183 = null;
      }

      XItemContainer.method179();
      class157.region.method1740();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2302();
      }

      System.gc();
      class138.field1917 = 1;
      class1.field12 = null;
      class138.field1918 = -1;
      Frames.field1566 = -1;
      class101.field1649 = 0;
      class34.field742 = false;
      class114.field1792 = 2;
      Client.field318 = -1;
      Client.field524 = false;
      WallObject.method1921();
      class186.setGameState(10);
   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("rf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "49"
   )
   final synchronized void method2236() {
      if(!field1771) {
         field1771 = true;

         try {
            class107.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2161();
         } catch (Exception var4) {
            ;
         }

         if(MessageNode.field230 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class15.field159) {
            try {
               class15.field159.method2017();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2242();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "136392450"
   )
   protected abstract void vmethod2242();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "62"
   )
   protected abstract void vmethod2245();
}
