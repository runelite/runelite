import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
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

@ObfuscatedName("dc")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ps")
   boolean field1763;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 1106499973
   )
   protected static int field1764 = 0;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = 2443634682187802879L
   )
   static long field1765 = 0L;
   @ObfuscatedName("pi")
   static boolean field1766 = false;
   @ObfuscatedName("qe")
   static long[] field1767 = new long[32];
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -1569726721
   )
   static int field1768 = 1;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 942975699
   )
   static int field1769 = 500;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -353054033
   )
   static int field1770 = 20;
   @ObfuscatedName("pe")
   static GameEngine field1771 = null;
   @ObfuscatedName("qp")
   static long[] field1772 = new long[32];
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 612940105
   )
   protected static int field1773 = 0;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -930058023
   )
   protected static int field1774 = 0;
   @ObfuscatedName("qf")
   protected static volatile boolean field1775 = true;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -1803670509
   )
   static int field1776 = 0;
   @ObfuscatedName("qv")
   protected static boolean field1777 = false;
   @ObfuscatedName("qx")
   protected static volatile boolean field1778 = false;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      longValue = -563271883019741069L
   )
   static volatile long field1779 = 0L;
   @ObfuscatedName("rn")
   static volatile boolean field1780 = true;

   @ObfuscatedName("pq")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1527848338"
   )
   protected final boolean method2073() {
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
                     this.method2083("invalidhost");
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
         if(null != class103.field1665) {
            String var1 = class103.field1665.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1663;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2083("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
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

                     label177: {
                        char var12 = var14.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == 45) {
                              var7 = true;
                              break label177;
                           }

                           if(var12 == 43) {
                              break label177;
                           }
                        }

                        int var17;
                        if(var12 >= 48 && var12 <= 57) {
                           var17 = var12 - 48;
                        } else if(var12 >= 65 && var12 <= 90) {
                           var17 = var12 - 55;
                        } else {
                           if(var12 < 97 || var12 > 122) {
                              var6 = false;
                              break;
                           }

                           var17 = var12 - 87;
                        }

                        if(var17 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var17 = -var17;
                        }

                        int var13 = var17 + 10 * var9;
                        if(var13 / 10 != var9) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6 && class177.method3191(var14) < 10) {
                     this.method2083("wrongjava");
                     return;
                  }
               }

               field1768 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2086();
         this.vmethod2080();
         class5.field51 = Ignore.method192();

         while(0L == field1765 || class72.method1385() < field1765) {
            class41.field857 = class5.field51.vmethod2018(field1770, field1768);

            for(int var15 = 0; var15 < class41.field857; ++var15) {
               this.method2074();
            }

            this.method2075();
            class108.method2014(class41.field855, class110.canvas);
         }
      } catch (Exception var16) {
         FaceNormal.method1864((String)null, var16);
         this.method2083("crash");
      }

      this.method2076();
   }

   @ObfuscatedName("pr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "107"
   )
   void method2074() {
      long var1 = class72.method1385();
      long var3 = field1772[class65.field1112];
      field1772[class65.field1112] = var1;
      class65.field1112 = 1 + class65.field1112 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class9.field83 = field1780;
      }

      this.packetHandler();
   }

   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1491030934"
   )
   void method2075() {
      Container var1 = this.method2084();
      long var2 = class72.method1385();
      long var4 = field1767[class109.field1729];
      field1767[class109.field1729] = var2;
      class109.field1729 = 1 + class109.field1729 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field1764 = ((var6 >> 1) + 32000) / var6;
      }

      if(++field1769 - 1 > 50) {
         field1769 -= 50;
         field1775 = true;
         class110.canvas.setSize(ItemLayer.field1223, class112.field1755);
         class110.canvas.setVisible(true);
         if(var1 == class164.field2162) {
            Insets var7 = class164.field2162.getInsets();
            class110.canvas.setLocation(var7.left + field1773, field1774 + var7.top);
         } else {
            class110.canvas.setLocation(field1773, field1774);
         }
      }

      this.vmethod2107();
   }

   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-81"
   )
   final synchronized void method2076() {
      if(!field1766) {
         field1766 = true;

         try {
            class110.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2082();
         } catch (Exception var4) {
            ;
         }

         if(class164.field2162 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class41.field855) {
            try {
               class41.field855.method1930();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2090();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(field1771 == this && !field1766) {
         field1775 = true;
         if(null != class103.field1663 && class103.field1663.startsWith("1.5") && class72.method1385() - field1779 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= ItemLayer.field1223 && var2.height >= class112.field1755) {
               field1778 = true;
            }
         }

      }
   }

   public void stop() {
      if(this == field1771 && !field1766) {
         field1765 = class72.method1385() + 4000L;
      }
   }

   public void destroy() {
      if(field1771 == this && !field1766) {
         field1765 = class72.method1385();
         class10.method149(5000L);
         this.method2076();
      }
   }

   public abstract void init();

   public final void focusLost(FocusEvent var1) {
      field1780 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      field1780 = true;
      field1775 = true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   protected abstract void vmethod2080();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1179563118"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-555505450"
   )
   protected abstract void vmethod2082();

   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2028149222"
   )
   protected void method2083(String var1) {
      if(!this.field1763) {
         this.field1763 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "-89"
   )
   protected Container method2084() {
      return (Container)(null != class164.field2162?class164.field2162:this);
   }

   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "-1688455089"
   )
   protected Dimension method2085() {
      Container var1 = this.method2084();
      int var2 = Math.max(var1.getWidth(), class108.field1726);
      int var3 = Math.max(var1.getHeight(), Item.field896);
      if(class164.field2162 != null) {
         Insets var4 = class164.field2162.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("ps")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-125"
   )
   protected final synchronized void method2086() {
      Container var1 = this.method2084();
      if(null != class110.canvas) {
         class110.canvas.removeFocusListener(this);
         var1.remove(class110.canvas);
      }

      ItemLayer.field1223 = Math.max(var1.getWidth(), class108.field1726);
      class112.field1755 = Math.max(var1.getHeight(), Item.field896);
      Insets var2;
      if(null != class164.field2162) {
         var2 = class164.field2162.getInsets();
         ItemLayer.field1223 -= var2.left + var2.right;
         class112.field1755 -= var2.top + var2.bottom;
      }

      class110.canvas = new RSCanvas(this);
      var1.add(class110.canvas);
      class110.canvas.setSize(ItemLayer.field1223, class112.field1755);
      class110.canvas.setVisible(true);
      if(class164.field2162 == var1) {
         var2 = class164.field2162.getInsets();
         class110.canvas.setLocation(field1773 + var2.left, var2.top + field1774);
      } else {
         class110.canvas.setLocation(field1773, field1774);
      }

      class110.canvas.addFocusListener(this);
      class110.canvas.requestFocus();
      field1775 = true;
      int var3 = ItemLayer.field1223;
      int var4 = class112.field1755;
      Canvas var5 = class110.canvas;

      Object var9;
      try {
         MainBufferProvider var6 = new MainBufferProvider();
         var6.init(var3, var4, var5);
         var9 = var6;
      } catch (Throwable var8) {
         SecondaryBufferProvider var7 = new SecondaryBufferProvider();
         var7.init(var3, var4, var5);
         var9 = var7;
      }

      if(null != ChatMessages.bufferProvider) {
         ChatMessages.bufferProvider.draw(((BufferProvider)var9).image.getGraphics(), 0, 0);
      }

      ChatMessages.bufferProvider = (BufferProvider)var9;
      field1778 = false;
      field1779 = class72.method1385();
   }

   public void start() {
      if(this == field1771 && !field1766) {
         field1765 = 0L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1764302418"
   )
   protected abstract void vmethod2090();

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-37"
   )
   protected abstract void vmethod2107();

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("pi")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "386279950"
   )
   protected final void method2145(int var1, int var2, int var3) {
      try {
         if(field1771 != null) {
            ++field1776;
            if(field1776 >= 3) {
               this.method2083("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1771 = this;
         ItemLayer.field1223 = var1;
         class112.field1755 = var2;
         class39.field804 = var3;
         class108.field1719 = this;
         if(class41.field855 == null) {
            class41.field855 = new class103();
         }

         class41.field855.method1932(this, 1);
      } catch (Exception var5) {
         FaceNormal.method1864((String)null, var5);
         this.method2083("crash");
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "86"
   )
   static final void method2156(class68 var0) {
      var0.field1145 = false;
      if(null != var0.field1147) {
         var0.field1147.field1179 = 0;
      }

      for(class68 var1 = var0.vmethod2666(); null != var1; var1 = var0.vmethod2658()) {
         method2156(var1);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-1533483427"
   )
   static void method2157(int var0, boolean var1, int var2, boolean var3) {
      if(class107.worldList != null) {
         NPC.method691(0, class107.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "568819432"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3050.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2826.method3211(12, var0);
         var1 = new Sequence();
         if(null != var2) {
            var1.method3678(new Buffer(var2));
         }

         var1.method3680();
         Sequence.field3050.put(var1, (long)var0);
         return var1;
      }
   }
}
