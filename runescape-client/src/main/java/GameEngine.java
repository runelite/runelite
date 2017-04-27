import java.applet.Applet;
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

@ObfuscatedName("df")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ru")
   static volatile boolean field1765 = true;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 117828851
   )
   protected static int field1766 = 0;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      longValue = 4561402566920761625L
   )
   static long field1767 = 0L;
   @ObfuscatedName("qx")
   static boolean field1768 = false;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 783407863
   )
   static int field1769 = 20;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -72920709
   )
   static int field1770 = 0;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 75817599
   )
   static int field1771 = 1;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -467669171
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("qp")
   protected static long[] field1773 = new long[32];
   @ObfuscatedName("qo")
   protected static long[] field1774 = new long[32];
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -781384431
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("qi")
   boolean field1776 = false;
   @ObfuscatedName("rc")
   protected static volatile boolean field1777 = true;
   @ObfuscatedName("re")
   @ObfuscatedGetter(
      intValue = 1819339071
   )
   static int field1778 = 500;
   @ObfuscatedName("rz")
   protected static boolean field1779 = false;
   @ObfuscatedName("rt")
   protected static volatile boolean field1780 = false;
   @ObfuscatedName("rj")
   @ObfuscatedGetter(
      longValue = 5335836468379043549L
   )
   static volatile long field1781 = 0L;
   @ObfuscatedName("pu")
   static GameEngine field1782 = null;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 523231493
   )
   protected static int field1783 = 0;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      longValue = 1112876355748774285L
   )
   static long field1784;

   @ObfuscatedName("qt")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "13037"
   )
   protected final void method2116(int var1, int var2, int var3) {
      try {
         if(field1782 != null) {
            ++field1770;
            if(field1770 >= 3) {
               this.method2129("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1782 = this;
         class187.field2760 = var1;
         IndexDataBase.field2726 = var2;
         class101.revision = var3;
         class101.field1639 = this;
         if(class45.field896 == null) {
            class45.field896 = new class103();
         }

         class45.field896.method1968(this, 1);
      } catch (Exception var5) {
         class173.method3259((String)null, var5);
         this.method2129("crash");
      }

   }

   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "880260688"
   )
   protected final synchronized void method2117() {
      Container var1 = this.method2130();
      if(class65.canvas != null) {
         class65.canvas.removeFocusListener(this);
         var1.remove(class65.canvas);
      }

      class187.field2760 = Math.max(var1.getWidth(), class94.field1563);
      IndexDataBase.field2726 = Math.max(var1.getHeight(), Ignore.field210);
      Insets var2;
      if(class3.field26 != null) {
         var2 = class3.field26.getInsets();
         class187.field2760 -= var2.left + var2.right;
         IndexDataBase.field2726 -= var2.bottom + var2.top;
      }

      class65.canvas = new RSCanvas(this);
      var1.add(class65.canvas);
      class65.canvas.setSize(class187.field2760, IndexDataBase.field2726);
      class65.canvas.setVisible(true);
      if(var1 == class3.field26) {
         var2 = class3.field26.getInsets();
         class65.canvas.setLocation(var2.left + field1766, field1783 + var2.top);
      } else {
         class65.canvas.setLocation(field1766, field1783);
      }

      class65.canvas.addFocusListener(this);
      class65.canvas.requestFocus();
      field1777 = true;
      BufferProvider var3 = NPCComposition.method3805(class187.field2760, IndexDataBase.field2726, class65.canvas);
      if(class88.bufferProvider != null) {
         class88.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      class88.bufferProvider = var3;
      field1780 = false;
      field1781 = class72.method1421();
   }

   public void run() {
      try {
         if(class103.field1659 != null) {
            String var1 = class103.field1659.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1668;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2129("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class131.method2609(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class161.method3023(var4)) {
                     int var5 = Actor.method595(var4, 10, true);
                     if(var5 < 10) {
                        this.method2129("wrongjava");
                        return;
                     }
                  }
               }

               field1771 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2117();
         this.vmethod2125();

         Object var9;
         try {
            var9 = new class98();
         } catch (Throwable var7) {
            var9 = new class99();
         }

         ChatMessages.field916 = (class109)var9;

         while(field1767 == 0L || class72.method1421() < field1767) {
            XItemContainer.field130 = ChatMessages.field916.vmethod2063(field1769, field1771);

            for(int var6 = 0; var6 < XItemContainer.field130; ++var6) {
               this.method2119();
            }

            this.method2120();
            class158.method2890(class45.field896, class65.canvas);
         }
      } catch (Exception var8) {
         class173.method3259((String)null, var8);
         this.method2129("crash");
      }

      this.method2121();
   }

   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1553307051"
   )
   void method2119() {
      long var1 = class72.method1421();
      long var3 = field1774[class108.field1727];
      field1774[class108.field1727] = var1;
      class108.field1727 = class108.field1727 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         KitDefinition.field2831 = field1765;
      }

      this.packetHandler();
   }

   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1142620483"
   )
   void method2120() {
      Container var1 = this.method2130();
      long var2 = class72.method1421();
      long var4 = field1773[FileOnDisk.field1174];
      field1773[FileOnDisk.field1174] = var2;
      FileOnDisk.field1174 = FileOnDisk.field1174 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field1778 - 1 > 50) {
         field1778 -= 50;
         field1777 = true;
         class65.canvas.setSize(class187.field2760, IndexDataBase.field2726);
         class65.canvas.setVisible(true);
         if(class3.field26 == var1) {
            Insets var7 = class3.field26.getInsets();
            class65.canvas.setLocation(var7.left + field1766, field1783 + var7.top);
         } else {
            class65.canvas.setLocation(field1766, field1783);
         }
      }

      this.vmethod2154();
   }

   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1817647515"
   )
   final synchronized void method2121() {
      if(!field1768) {
         field1768 = true;

         try {
            class65.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2128();
         } catch (Exception var4) {
            ;
         }

         if(class3.field26 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class45.field896 != null) {
            try {
               class45.field896.method1976();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2132();
      }
   }

   public void start() {
      if(field1782 == this && !field1768) {
         field1767 = 0L;
      }
   }

   public void destroy() {
      if(field1782 == this && !field1768) {
         field1767 = class72.method1421();
         class0.method14(5000L);
         this.method2121();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field1782 && !field1768) {
         field1777 = true;
         if(class103.field1668 != null && class103.field1668.startsWith("1.5") && class72.method1421() - field1781 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class187.field2760 && var2.height >= IndexDataBase.field2726) {
               field1780 = true;
            }
         }

      }
   }

   public abstract void init();

   public final void focusLost(FocusEvent var1) {
      field1765 = false;
   }

   public final void windowActivated(WindowEvent var1) {
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

   public void stop() {
      if(this == field1782 && !field1768) {
         field1767 = class72.method1421() + 4000L;
      }
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "189"
   )
   protected abstract void vmethod2125();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "790676773"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-4555"
   )
   protected abstract void vmethod2128();

   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-5"
   )
   protected void method2129(String var1) {
      if(!this.field1776) {
         this.field1776 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "48"
   )
   protected Container method2130() {
      return (Container)(class3.field26 != null?class3.field26:this);
   }

   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Dimension;",
      garbageValue = "3"
   )
   protected Dimension method2131() {
      Container var1 = this.method2130();
      int var2 = Math.max(var1.getWidth(), class94.field1563);
      int var3 = Math.max(var1.getHeight(), Ignore.field210);
      if(class3.field26 != null) {
         Insets var4 = class3.field26.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1854662748"
   )
   protected abstract void vmethod2132();

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("qs")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1110622977"
   )
   protected final boolean method2151() {
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
                     this.method2129("invalidhost");
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-907029996"
   )
   protected abstract void vmethod2154();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "945773884"
   )
   static final void method2191(Widget var0, int var1, int var2) {
      if(Client.field522 == 0 || Client.field522 == 3) {
         if(class115.field1811 == 1 || !CombatInfo1.field662 && class115.field1811 == 4) {
            class166 var3 = var0.method3211(true);
            if(var3 == null) {
               return;
            }

            int var4 = class115.field1802 - var1;
            int var5 = class115.field1813 - var2;
            if(var3.method3133(var4, var5)) {
               var4 -= var3.field2167 / 2;
               var5 -= var3.field2165 / 2;
               int var6 = Client.mapAngle + Client.mapScale & 2047;
               int var7 = class84.field1433[var6];
               int var8 = class84.field1441[var6];
               var7 = (Client.mapScaleDelta + 256) * var7 >> 8;
               var8 = var8 * (Client.mapScaleDelta + 256) >> 8;
               int var9 = var4 * var8 + var5 * var7 >> 11;
               int var10 = var8 * var5 - var7 * var4 >> 11;
               int var11 = var9 + class22.localPlayer.x >> 7;
               int var12 = class22.localPlayer.y - var10 >> 7;
               Client.secretCipherBuffer1.putOpcode(196);
               Client.secretCipherBuffer1.putByte(18);
               Client.secretCipherBuffer1.method2499(class105.field1695[82]?(class105.field1695[81]?2:1):0);
               Client.secretCipherBuffer1.method2526(class108.baseX + var11);
               Client.secretCipherBuffer1.method2416(var12 + baseY);
               Client.secretCipherBuffer1.putByte(var4);
               Client.secretCipherBuffer1.putByte(var5);
               Client.secretCipherBuffer1.putShort(Client.mapAngle);
               Client.secretCipherBuffer1.putByte(57);
               Client.secretCipherBuffer1.putByte(Client.mapScale);
               Client.secretCipherBuffer1.putByte(Client.mapScaleDelta);
               Client.secretCipherBuffer1.putByte(89);
               Client.secretCipherBuffer1.putShort(class22.localPlayer.x);
               Client.secretCipherBuffer1.putShort(class22.localPlayer.y);
               Client.secretCipherBuffer1.putByte(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field1765 = true;
      field1777 = true;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1978782694"
   )
   static final void method2201() {
      if(class6.field56 != null) {
         class6.field56.method1078();
      }

      if(class8.field70 != null) {
         class8.field70.method1078();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-208790124"
   )
   public static void method2202(int var0) {
      class159.field2063 = 1;
      class159.field2067 = null;
      CipherBuffer.field1989 = -1;
      class190.field2791 = -1;
      class159.field2069 = 0;
      class15.field164 = false;
      WallObject.field1543 = var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "1947866676"
   )
   public static void method2203(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      Sequence.field3098 = var0;
      Sequence.field3085 = var1;
      Sequence.field3086 = var2;
   }
}
