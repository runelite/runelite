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

@ObfuscatedName("de")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("rh")
   static volatile boolean field1767 = true;
   @ObfuscatedName("ro")
   @ObfuscatedGetter(
      longValue = -7598558109231386921L
   )
   static volatile long field1768 = 0L;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      longValue = -1692282633157909889L
   )
   static long field1769 = 0L;
   @ObfuscatedName("qk")
   static boolean field1770 = false;
   @ObfuscatedName("qy")
   protected static long[] field1771 = new long[32];
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 299129695
   )
   static int field1772 = 20;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = 1367109327
   )
   static int field1773 = 1;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 1706443521
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("px")
   static GameEngine field1775 = null;
   @ObfuscatedName("qv")
   protected static long[] field1776 = new long[32];
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -1705866225
   )
   protected static int field1777 = 0;
   @ObfuscatedName("rc")
   @ObfuscatedGetter(
      intValue = -1400810361
   )
   static int field1778 = 500;
   @ObfuscatedName("qt")
   boolean field1779 = false;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 1722242009
   )
   static int field1780 = 0;
   @ObfuscatedName("rb")
   protected static boolean field1781 = false;
   @ObfuscatedName("rs")
   protected static volatile boolean field1782 = false;
   @ObfuscatedName("qm")
   protected static volatile boolean field1783 = true;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -2069540269
   )
   protected static int field1784 = 0;

   @ObfuscatedName("rg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-451390116"
   )
   protected void method2160(String var1) {
      if(!this.field1779) {
         this.field1779 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("rr")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "422688788"
   )
   protected final void method2161(int var1, int var2, int var3) {
      try {
         if(null != field1775) {
            ++field1780;
            if(field1780 >= 3) {
               this.method2160("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1775 = this;
         class32.field758 = var1;
         class47.field950 = var2;
         class101.field1655 = var3;
         class101.field1657 = this;
         if(null == class33.field775) {
            class33.field775 = new class103();
         }

         class33.field775.method2025(this, 1);
      } catch (Exception var5) {
         class37.method822((String)null, var5);
         this.method2160("crash");
      }

   }

   @ObfuscatedName("rn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1643150244"
   )
   protected final synchronized void method2162() {
      Container var1 = this.method2177();
      if(GameObject.canvas != null) {
         GameObject.canvas.removeFocusListener(this);
         var1.remove(GameObject.canvas);
      }

      class32.field758 = Math.max(var1.getWidth(), Actor.field683);
      class47.field950 = Math.max(var1.getHeight(), class103.field1683);
      Insets var2;
      if(null != class3.field39) {
         var2 = class3.field39.getInsets();
         class32.field758 -= var2.right + var2.left;
         class47.field950 -= var2.bottom + var2.top;
      }

      GameObject.canvas = new RSCanvas(this);
      var1.add(GameObject.canvas);
      GameObject.canvas.setSize(class32.field758, class47.field950);
      GameObject.canvas.setVisible(true);
      if(class3.field39 == var1) {
         var2 = class3.field39.getInsets();
         GameObject.canvas.setLocation(var2.left + field1777, var2.top + field1784);
      } else {
         GameObject.canvas.setLocation(field1777, field1784);
      }

      GameObject.canvas.addFocusListener(this);
      GameObject.canvas.requestFocus();
      field1783 = true;
      BufferProvider var3 = Varbit.method3558(class32.field758, class47.field950, GameObject.canvas);
      if(CombatInfo1.bufferProvider != null) {
         CombatInfo1.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      CombatInfo1.bufferProvider = var3;
      field1782 = false;
      field1768 = class0.method11();
   }

   @ObfuscatedName("re")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "364030860"
   )
   protected final boolean method2163() {
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
                     this.method2160("invalidhost");
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
         if(class103.field1685 != null) {
            String var1 = class103.field1685.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1674;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2160("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class22.method218(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class105.method2082(var4) && class145.method2759(var4) < 10) {
                     this.method2160("wrongjava");
                     return;
                  }
               }

               field1773 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2162();
         this.vmethod2173();

         Object var8;
         try {
            var8 = new class98();
         } catch (Throwable var6) {
            var8 = new class99();
         }

         class159.field2135 = (class109)var8;

         while(field1769 == 0L || class0.method11() < field1769) {
            ChatMessages.field944 = class159.field2135.vmethod2108(field1772, field1773);

            for(int var5 = 0; var5 < ChatMessages.field944; ++var5) {
               this.method2222();
            }

            this.method2165();
            ChatMessages.method945(class33.field775, GameObject.canvas);
         }
      } catch (Exception var7) {
         class37.method822((String)null, var7);
         this.method2160("crash");
      }

      this.method2253();
   }

   @ObfuscatedName("rw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2040024180"
   )
   void method2165() {
      Container var1 = this.method2177();
      long var2 = class0.method11();
      long var4 = field1776[class63.field1109];
      field1776[class63.field1109] = var2;
      class63.field1109 = 1 + class63.field1109 & 31;
      if(0L != var4 && var2 > var4) {
         int var7 = (int)(var2 - var4);
         FPS = ((var7 >> 1) + 32000) / var7;
      }

      if(++field1778 - 1 > 50) {
         field1778 -= 50;
         field1783 = true;
         GameObject.canvas.setSize(class32.field758, class47.field950);
         GameObject.canvas.setVisible(true);
         if(class3.field39 == var1) {
            Insets var6 = class3.field39.getInsets();
            GameObject.canvas.setLocation(var6.left + field1777, field1784 + var6.top);
         } else {
            GameObject.canvas.setLocation(field1777, field1784);
         }
      }

      this.vmethod2175();
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public void start() {
      if(this == field1775 && !field1770) {
         field1769 = 0L;
      }
   }

   public void destroy() {
      if(this == field1775 && !field1770) {
         field1769 = class0.method11();
         class115.method2292(5000L);
         this.method2253();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      field1767 = true;
      field1783 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field1767 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("ry")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "-257672195"
   )
   protected Dimension method2171() {
      Container var1 = this.method2177();
      int var2 = Math.max(var1.getWidth(), Actor.field683);
      int var3 = Math.max(var1.getHeight(), class103.field1683);
      if(class3.field39 != null) {
         Insets var4 = class3.field39.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1812159670"
   )
   protected abstract void vmethod2173();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1613505822"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1800546571"
   )
   protected abstract void vmethod2175();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1036839229"
   )
   protected abstract void vmethod2176();

   public void stop() {
      if(this == field1775 && !field1770) {
         field1769 = class0.method11() + 4000L;
      }
   }

   @ObfuscatedName("rq")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "36"
   )
   protected Container method2177() {
      return (Container)(class3.field39 != null?class3.field39:this);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1556589275"
   )
   protected abstract void vmethod2179();

   public final void windowIconified(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("rx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   void method2222() {
      long var1 = class0.method11();
      long var3 = field1771[class0.field5];
      field1771[class0.field5] = var1;
      class0.field5 = class0.field5 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class63.field1108 = field1767;
      }

      this.packetHandler();
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1456297867"
   )
   public static void method2231() {
      Widget.field2252.reset();
      Widget.field2300.reset();
      Widget.field2201.reset();
      Widget.field2202.reset();
   }

   public final synchronized void paint(Graphics var1) {
      if(field1775 == this && !field1770) {
         field1783 = true;
         if(class103.field1674 != null && class103.field1674.startsWith("1.5") && class0.method11() - field1768 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class32.field758 && var2.height >= class47.field950) {
               field1782 = true;
            }
         }

      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "630536289"
   )
   static final void method2252(boolean var0) {
      Client.field428 = 0;
      Client.field346 = 0;
      XClanMember.method255();

      int var1;
      NPC var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      while(Client.field350.method3075(Client.field351) >= 27) {
         var1 = Client.field350.method3095(15);
         if(var1 == 32767) {
            break;
         }

         boolean var2 = false;
         if(Client.cachedNPCs[var1] == null) {
            Client.cachedNPCs[var1] = new NPC();
            var2 = true;
         }

         var3 = Client.cachedNPCs[var1];
         Client.field345[++Client.field340 - 1] = var1;
         var3.field672 = Client.gameCycle;
         if(var0) {
            var4 = Client.field350.method3095(8);
            if(var4 > 127) {
               var4 -= 256;
            }
         } else {
            var4 = Client.field350.method3095(5);
            if(var4 > 15) {
               var4 -= 32;
            }
         }

         var5 = Client.field350.method3095(1);
         if(var5 == 1) {
            Client.field347[++Client.field346 - 1] = var1;
         }

         var6 = Client.field350.method3095(1);
         var3.composition = class13.getNpcDefinition(Client.field350.method3095(14));
         var7 = Client.field344[Client.field350.method3095(3)];
         if(var2) {
            var3.field674 = var3.angle = var7;
         }

         if(var0) {
            var8 = Client.field350.method3095(8);
            if(var8 > 127) {
               var8 -= 256;
            }
         } else {
            var8 = Client.field350.method3095(5);
            if(var8 > 15) {
               var8 -= 32;
            }
         }

         var3.field657 = var3.composition.field3010;
         var3.field654 = var3.composition.field3031;
         if(var3.field654 == 0) {
            var3.angle = 0;
         }

         var3.field631 = var3.composition.field3037;
         var3.field652 = var3.composition.field3015;
         var3.field633 = var3.composition.field3016;
         var3.field634 = var3.composition.field3017;
         var3.idlePoseAnimation = var3.composition.field3011;
         var3.field676 = var3.composition.field3012;
         var3.field630 = var3.composition.field3014;
         var3.method801(class36.localPlayer.pathX[0] + var4, class36.localPlayer.pathY[0] + var8, var6 == 1);
      }

      Client.field350.method3074();

      int var13;
      for(var1 = 0; var1 < Client.field346; ++var1) {
         var13 = Client.field347[var1];
         var3 = Client.cachedNPCs[var13];
         var4 = Client.field350.readUnsignedByte();
         if((var4 & 16) != 0) {
            var3.composition = class13.getNpcDefinition(Client.field350.method2873());
            var3.field657 = var3.composition.field3010;
            var3.field654 = var3.composition.field3031;
            var3.field631 = var3.composition.field3037;
            var3.field652 = var3.composition.field3015;
            var3.field633 = var3.composition.field3016;
            var3.field634 = var3.composition.field3017;
            var3.idlePoseAnimation = var3.composition.field3011;
            var3.field676 = var3.composition.field3012;
            var3.field630 = var3.composition.field3014;
         }

         if((var4 & 1) != 0) {
            var5 = Client.field350.readUnsignedShort();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = Client.field350.method2859();
            if(var3.animation == var5 && var5 != -1) {
               var7 = class195.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field642 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field677 = 0;
               }

               if(var7 == 2) {
                  var3.field677 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || class195.getAnimation(var5).forcedPriority >= class195.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field642 = 0;
               var3.actionAnimationDisable = var6;
               var3.field677 = 0;
               var3.field682 = var3.field673;
            }
         }

         if((var4 & 2) != 0) {
            var3.graphic = Client.field350.method2867();
            var5 = Client.field350.method2965();
            var3.field664 = var5 >> 16;
            var3.field639 = Client.gameCycle + (var5 & '\uffff');
            var3.field661 = 0;
            var3.field662 = 0;
            if(var3.field639 > Client.gameCycle) {
               var3.field661 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 64) != 0) {
            var5 = Client.field350.readUnsignedByte();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = Client.field350.method2846();
                  if(var7 == 32767) {
                     var7 = Client.field350.method2846();
                     var9 = Client.field350.method2846();
                     var8 = Client.field350.method2846();
                     var10 = Client.field350.method2846();
                  } else if(var7 != 32766) {
                     var9 = Client.field350.method2846();
                  } else {
                     var7 = -1;
                  }

                  var11 = Client.field350.method2846();
                  var3.method616(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = Client.field350.method2859();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = Client.field350.method2846();
                  var9 = Client.field350.method2846();
                  if(var9 != 32767) {
                     var10 = Client.field350.method2846();
                     var11 = Client.field350.method2897();
                     int var12 = var9 > 0?Client.field350.readUnsignedByte():var11;
                     var3.method631(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method621(var8);
                  }
               }
            }
         }

         if((var4 & 32) != 0) {
            var3.overhead = Client.field350.method2868();
            var3.field638 = 100;
         }

         if((var4 & 8) != 0) {
            var3.interacting = Client.field350.method2867();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 4) != 0) {
            var5 = Client.field350.method2867();
            var6 = Client.field350.method2869();
            var7 = var3.x - 64 * (var5 - class5.baseX - class5.baseX);
            var8 = var3.y - (var6 - XClanMember.baseY - XClanMember.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field651 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }
      }

      for(var1 = 0; var1 < Client.field428; ++var1) {
         var13 = Client.field388[var1];
         if(Client.cachedNPCs[var13].field672 != Client.gameCycle) {
            Client.cachedNPCs[var13].composition = null;
            Client.cachedNPCs[var13] = null;
         }
      }

      if(Client.field350.offset != Client.field351) {
         throw new RuntimeException(Client.field350.offset + "," + Client.field351);
      } else {
         for(var1 = 0; var1 < Client.field340; ++var1) {
            if(Client.cachedNPCs[Client.field345[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.field340);
            }
         }

      }
   }

   @ObfuscatedName("rj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-836830998"
   )
   final synchronized void method2253() {
      if(!field1770) {
         field1770 = true;

         try {
            GameObject.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2176();
         } catch (Exception var4) {
            ;
         }

         if(null != class3.field39) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class33.field775) {
            try {
               class33.field775.method2022();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2179();
      }
   }
}
