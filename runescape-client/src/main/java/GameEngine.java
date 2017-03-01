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

@ObfuscatedName("dg")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      longValue = -8136973070877293693L
   )
   static long field1766 = 0L;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -1386110487
   )
   static int field1767 = 0;
   @ObfuscatedName("ri")
   protected static volatile boolean field1768 = false;
   @ObfuscatedName("pe")
   static GameEngine field1769 = null;
   @ObfuscatedName("qu")
   static long[] field1770 = new long[32];
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 1967897789
   )
   static int field1771 = 20;
   @ObfuscatedName("qp")
   boolean field1772 = false;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -652417451
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("qd")
   static boolean field1774 = false;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = 1954871135
   )
   static int field1775 = 1;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 1549270859
   )
   protected static int field1776 = 0;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 1265949869
   )
   protected static int field1777 = 0;
   @ObfuscatedName("ql")
   public static volatile boolean field1778 = true;
   @ObfuscatedName("rh")
   @ObfuscatedGetter(
      intValue = 981251333
   )
   static int field1779 = 500;
   @ObfuscatedName("rn")
   protected static boolean field1780 = false;
   @ObfuscatedName("rb")
   static volatile boolean field1781 = true;
   @ObfuscatedName("re")
   @ObfuscatedGetter(
      longValue = 6832592749814751209L
   )
   static volatile long field1782 = 0L;
   @ObfuscatedName("qe")
   static long[] field1783 = new long[32];

   @ObfuscatedName("ra")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   protected final void method2188(int var1, int var2, int var3) {
      try {
         if(null != field1769) {
            ++field1767;
            if(field1767 >= 3) {
               this.method2201("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1769 = this;
         RSCanvas.field1756 = var1;
         class65.field1128 = var2;
         class161.field2138 = var3;
         class101.field1657 = this;
         if(null == class114.field1793) {
            class114.field1793 = new class103();
         }

         class114.field1793.method2067(this, 1);
      } catch (Exception var5) {
         class97.method2025((String)null, var5);
         this.method2201("crash");
      }

   }

   @ObfuscatedName("rs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1787656419"
   )
   protected final synchronized void method2189() {
      Container var1 = this.method2202();
      if(class110.canvas != null) {
         class110.canvas.removeFocusListener(this);
         var1.remove(class110.canvas);
      }

      RSCanvas.field1756 = Math.max(var1.getWidth(), class72.field1193);
      class65.field1128 = Math.max(var1.getHeight(), class104.field1698);
      Insets var2;
      if(CollisionData.field1835 != null) {
         var2 = CollisionData.field1835.getInsets();
         RSCanvas.field1756 -= var2.left + var2.right;
         class65.field1128 -= var2.top + var2.bottom;
      }

      class110.canvas = new RSCanvas(this);
      var1.add(class110.canvas);
      class110.canvas.setSize(RSCanvas.field1756, class65.field1128);
      class110.canvas.setVisible(true);
      if(var1 == CollisionData.field1835) {
         var2 = CollisionData.field1835.getInsets();
         class110.canvas.setLocation(field1776 + var2.left, var2.top + field1777);
      } else {
         class110.canvas.setLocation(field1776, field1777);
      }

      class110.canvas.addFocusListener(this);
      class110.canvas.requestFocus();
      field1778 = true;
      int var3 = RSCanvas.field1756;
      int var4 = class65.field1128;
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

      if(class57.bufferProvider != null) {
         class57.bufferProvider.draw(((BufferProvider)var9).image.getGraphics(), 0, 0);
      }

      class57.bufferProvider = (BufferProvider)var9;
      field1768 = false;
      field1782 = WallObject.method1985();
   }

   public void run() {
      try {
         if(null != class103.field1677) {
            String var1 = class103.field1677.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1688;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2201("wrongjava");
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

                  String var6 = var2.substring(6, var3);
                  boolean var14 = class165.method3230(var6, 10, true);
                  if(var14 && GameObject.method2019(var6) < 10) {
                     this.method2201("wrongjava");
                     return;
                  }
               }

               field1775 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2189();
         this.vmethod2198();

         Object var11;
         try {
            var11 = new class98();
         } catch (Throwable var9) {
            var11 = new class99();
         }

         Frames.field1576 = (class109)var11;

         label91:
         while(true) {
            Canvas var8;
            class103 var12;
            do {
               if(field1766 != 0L && WallObject.method1985() >= field1766) {
                  break label91;
               }

               Friend.field148 = Frames.field1576.vmethod2133(field1771, field1775);

               for(int var7 = 0; var7 < Friend.field148; ++var7) {
                  this.method2191();
               }

               this.method2208();
               var12 = class114.field1793;
               var8 = class110.canvas;
            } while(var12.field1679 == null);

            for(int var13 = 0; var13 < 50 && var12.field1679.peekEvent() != null; ++var13) {
               class47.method970(1L);
            }

            if(null != var8) {
               var12.field1679.postEvent(new ActionEvent(var8, 1001, "dummy"));
            }
         }
      } catch (Exception var10) {
         class97.method2025((String)null, var10);
         this.method2201("crash");
      }

      this.method2193();
   }

   @ObfuscatedName("rw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-94"
   )
   void method2191() {
      long var1 = WallObject.method1985();
      long var3 = field1783[class32.field739];
      field1783[class32.field739] = var1;
      class32.field739 = 1 + class32.field739 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class13.field133 = field1781;
      }

      this.packetHandler();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1113671925"
   )
   protected abstract void vmethod2192();

   @ObfuscatedName("rl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1169827976"
   )
   final synchronized void method2193() {
      if(!field1774) {
         field1774 = true;

         try {
            class110.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2192();
         } catch (Exception var4) {
            ;
         }

         if(null != CollisionData.field1835) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class114.field1793 != null) {
            try {
               class114.field1793.method2052();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2295();
      }
   }

   public void start() {
      if(field1769 == this && !field1774) {
         field1766 = 0L;
      }
   }

   public abstract void init();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field1769 && !field1774) {
         field1778 = true;
         if(null != class103.field1688 && class103.field1688.startsWith("1.5") && WallObject.method1985() - field1782 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= RSCanvas.field1756 && var2.height >= class65.field1128) {
               field1768 = true;
            }
         }

      }
   }

   public final void focusLost(FocusEvent var1) {
      field1781 = false;
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

   @ObfuscatedName("rv")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-24"
   )
   protected final boolean method2196() {
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
                     this.method2201("invalidhost");
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

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1084210149"
   )
   protected abstract void vmethod2198();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   protected abstract void packetHandler();

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("sm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1524558958"
   )
   protected void method2201(String var1) {
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

   @ObfuscatedName("sj")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-382663111"
   )
   protected Container method2202() {
      return (Container)(CollisionData.field1835 != null?CollisionData.field1835:this);
   }

   @ObfuscatedName("sl")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Dimension;",
      garbageValue = "13"
   )
   protected Dimension method2203() {
      Container var1 = this.method2202();
      int var2 = Math.max(var1.getWidth(), class72.field1193);
      int var3 = Math.max(var1.getHeight(), class104.field1698);
      if(null != CollisionData.field1835) {
         Insets var4 = CollisionData.field1835.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("rr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1546809888"
   )
   void method2208() {
      Container var1 = this.method2202();
      long var2 = WallObject.method1985();
      long var4 = field1770[class115.field1815];
      field1770[class115.field1815] = var2;
      class115.field1815 = class115.field1815 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field1779 - 1 > 50) {
         field1779 -= 50;
         field1778 = true;
         class110.canvas.setSize(RSCanvas.field1756, class65.field1128);
         class110.canvas.setVisible(true);
         if(CollisionData.field1835 == var1) {
            Insets var7 = CollisionData.field1835.getInsets();
            class110.canvas.setLocation(var7.left + field1776, field1777 + var7.top);
         } else {
            class110.canvas.setLocation(field1776, field1777);
         }
      }

      this.vmethod2280();
   }

   public void stop() {
      if(field1769 == this && !field1774) {
         field1766 = WallObject.method1985() + 4000L;
      }
   }

   public void destroy() {
      if(field1769 == this && !field1774) {
         field1766 = WallObject.method1985();
         class47.method970(5000L);
         this.method2193();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILScript;ZS)I",
      garbageValue = "13478"
   )
   static int method2239(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field558 == 0) {
            class32.field726[++class32.field735 - 1] = -2;
         } else if(Client.field558 == 1) {
            class32.field726[++class32.field735 - 1] = -1;
         } else {
            class32.field726[++class32.field735 - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var14;
         if(var0 == 3601) {
            var14 = class32.field726[--class32.field735];
            if(Client.field558 == 2 && var14 < Client.friendCount) {
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = Client.friends[var14].name;
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = Client.friends[var14].previousName;
            } else {
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var14 = class32.field726[--class32.field735];
            if(Client.field558 == 2 && var14 < Client.friendCount) {
               class32.field726[++class32.field735 - 1] = Client.friends[var14].world;
            } else {
               class32.field726[++class32.field735 - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var14 = class32.field726[--class32.field735];
            if(Client.field558 == 2 && var14 < Client.friendCount) {
               class32.field726[++class32.field735 - 1] = Client.friends[var14].rank;
            } else {
               class32.field726[++class32.field735 - 1] = 0;
            }

            return 1;
         } else {
            int var4;
            String var22;
            if(var0 == 3604) {
               var22 = class32.scriptStringStack[--class30.scriptStringStackSize];
               var4 = class32.field726[--class32.field735];
               Client.field332.method3144(48);
               Client.field332.method2873(class165.method3233(var22) + 1);
               Client.field332.method2873(var4);
               Client.field332.method2915(var22);
               return 1;
            } else if(var0 == 3605) {
               var22 = class32.scriptStringStack[--class30.scriptStringStackSize];
               Client.method571(var22);
               return 1;
            } else if(var0 == 3606) {
               var22 = class32.scriptStringStack[--class30.scriptStringStackSize];
               class18.method204(var22);
               return 1;
            } else if(var0 == 3607) {
               var22 = class32.scriptStringStack[--class30.scriptStringStackSize];
               class37.method809(var22, false);
               return 1;
            } else if(var0 == 3608) {
               var22 = class32.scriptStringStack[--class30.scriptStringStackSize];
               class37.method817(var22);
               return 1;
            } else if(var0 == 3609) {
               var22 = class32.scriptStringStack[--class30.scriptStringStackSize];
               class177[] var17 = class0.method12();

               for(int var5 = 0; var5 < var17.length; ++var5) {
                  class177 var23 = var17[var5];
                  if(var23.field2665 != -1) {
                     int var9 = var23.field2665;
                     String var8 = "<img=" + var9 + ">";
                     if(var22.startsWith(var8)) {
                        var22 = var22.substring(6 + Integer.toString(var23.field2665).length());
                        break;
                     }
                  }
               }

               class32.field726[++class32.field735 - 1] = class20.method215(var22, false)?1:0;
               return 1;
            } else {
               String[] var3;
               String var6;
               int var11;
               int var12;
               char var13;
               String var16;
               long var18;
               if(var0 == 3611) {
                  if(Client.field516 != null) {
                     var3 = class32.scriptStringStack;
                     var4 = ++class30.scriptStringStackSize - 1;
                     var6 = Client.field516;
                     var18 = 0L;
                     var11 = var6.length();

                     for(var12 = 0; var12 < var11; ++var12) {
                        var18 *= 37L;
                        var13 = var6.charAt(var12);
                        if(var13 >= 65 && var13 <= 90) {
                           var18 += (long)(1 + var13 - 65);
                        } else if(var13 >= 97 && var13 <= 122) {
                           var18 += (long)(var13 + 1 - 97);
                        } else if(var13 >= 48 && var13 <= 57) {
                           var18 += (long)(27 + var13 - 48);
                        }

                        if(var18 >= 177917621779460413L) {
                           break;
                        }
                     }

                     while(0L == var18 % 37L && var18 != 0L) {
                        var18 /= 37L;
                     }

                     var16 = class99.method2037(var18);
                     if(null == var16) {
                        var16 = "";
                     }

                     var3[var4] = var16;
                  } else {
                     class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3612) {
                  if(Client.field516 != null) {
                     class32.field726[++class32.field735 - 1] = class119.clanChatCount;
                  } else {
                     class32.field726[++class32.field735 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3613) {
                  var14 = class32.field726[--class32.field735];
                  if(Client.field516 != null && var14 < class119.clanChatCount) {
                     class32.scriptStringStack[++class30.scriptStringStackSize - 1] = Friend.clanMembers[var14].username;
                  } else {
                     class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3614) {
                  var14 = class32.field726[--class32.field735];
                  if(null != Client.field516 && var14 < class119.clanChatCount) {
                     class32.field726[++class32.field735 - 1] = Friend.clanMembers[var14].world;
                  } else {
                     class32.field726[++class32.field735 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3615) {
                  var14 = class32.field726[--class32.field735];
                  if(Client.field516 != null && var14 < class119.clanChatCount) {
                     class32.field726[++class32.field735 - 1] = Friend.clanMembers[var14].rank;
                  } else {
                     class32.field726[++class32.field735 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3616) {
                  class32.field726[++class32.field735 - 1] = class32.field737;
                  return 1;
               } else if(var0 == 3617) {
                  var22 = class32.scriptStringStack[--class30.scriptStringStackSize];
                  class203.method3847(var22);
                  return 1;
               } else if(var0 == 3618) {
                  class32.field726[++class32.field735 - 1] = Client.field518;
                  return 1;
               } else if(var0 == 3619) {
                  var22 = class32.scriptStringStack[--class30.scriptStringStackSize];
                  class2.method35(var22);
                  return 1;
               } else if(var0 == 3620) {
                  Client.field332.method3144(194);
                  Client.field332.method2873(0);
                  return 1;
               } else if(var0 == 3621) {
                  if(Client.field558 == 0) {
                     class32.field726[++class32.field735 - 1] = -1;
                  } else {
                     class32.field726[++class32.field735 - 1] = Client.ignoreCount;
                  }

                  return 1;
               } else if(var0 == 3622) {
                  var14 = class32.field726[--class32.field735];
                  if(Client.field558 != 0 && var14 < Client.ignoreCount) {
                     class32.scriptStringStack[++class30.scriptStringStackSize - 1] = Client.ignores[var14].name;
                     class32.scriptStringStack[++class30.scriptStringStackSize - 1] = Client.ignores[var14].previousName;
                  } else {
                     class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                     class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3623) {
                  label393: {
                     var22 = class32.scriptStringStack[--class30.scriptStringStackSize];
                     String var15 = "<img=0>";
                     if(!var22.startsWith(var15)) {
                        String var7 = "<img=1>";
                        if(!var22.startsWith(var7)) {
                           break label393;
                        }
                     }

                     var22 = var22.substring(7);
                  }

                  class32.field726[++class32.field735 - 1] = Friend.method189(var22)?1:0;
                  return 1;
               } else if(var0 == 3624) {
                  var14 = class32.field726[--class32.field735];
                  if(null != Friend.clanMembers && var14 < class119.clanChatCount && Friend.clanMembers[var14].username.equalsIgnoreCase(WidgetNode.localPlayer.name)) {
                     class32.field726[++class32.field735 - 1] = 1;
                  } else {
                     class32.field726[++class32.field735 - 1] = 0;
                  }

                  return 1;
               } else if(var0 != 3625) {
                  return 2;
               } else {
                  if(Client.clanChatOwner != null) {
                     var3 = class32.scriptStringStack;
                     var4 = ++class30.scriptStringStackSize - 1;
                     var6 = Client.clanChatOwner;
                     var18 = 0L;
                     var11 = var6.length();

                     for(var12 = 0; var12 < var11; ++var12) {
                        var18 *= 37L;
                        var13 = var6.charAt(var12);
                        if(var13 >= 65 && var13 <= 90) {
                           var18 += (long)(1 + var13 - 65);
                        } else if(var13 >= 97 && var13 <= 122) {
                           var18 += (long)(1 + var13 - 97);
                        } else if(var13 >= 48 && var13 <= 57) {
                           var18 += (long)(var13 + 27 - 48);
                        }

                        if(var18 >= 177917621779460413L) {
                           break;
                        }
                     }

                     while(var18 % 37L == 0L && var18 != 0L) {
                        var18 /= 37L;
                     }

                     var16 = class99.method2037(var18);
                     if(var16 == null) {
                        var16 = "";
                     }

                     var3[var4] = var16;
                  } else {
                     class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               }
            }
         }
      }
   }

   public final void focusGained(FocusEvent var1) {
      field1781 = true;
      field1778 = true;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   public static void method2276() {
      ObjectComposition.field2900.reset();
      ObjectComposition.field2924.reset();
      ObjectComposition.field2902.reset();
      ObjectComposition.field2903.reset();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1255804382"
   )
   protected abstract void vmethod2280();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2124065695"
   )
   static final void method2292() {
      Region.field1532 = false;
      Client.field290 = false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "-1917222888"
   )
   static void method2294(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class41.field822 = (RSCanvas.field1756 - Client.field504) / 2;
         class41.loginWindowX = 202 + class41.field822;
      }

      if(class41.worldSelectShown) {
         class154.method3104(var0, var1);
      } else {
         if(var3) {
            class41.field824.method4172(class41.field822, 0);
            class41.field825.method4172(382 + class41.field822, 0);
            class168.field2191.method4115(class41.field822 + 382 - class168.field2191.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method3912("RuneScape is loading - please wait...", 180 + class41.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4012(180 + class41.loginWindowX - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4012(class41.loginWindowX + 180 - 151, 1 + var5, 302, 32, 0);
            Rasterizer2D.method4056(180 + class41.loginWindowX - 150, var5 + 2, class41.field853 * 3, 30, 9179409);
            Rasterizer2D.method4056(class41.field853 * 3 + (class41.loginWindowX + 180 - 150), 2 + var5, 300 - class41.field853 * 3, 30, 0);
            var0.method3912(class41.field855, class41.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var18;
         int var19;
         short var20;
         if(Client.gameState == 20) {
            class41.field821.method4115(180 + class41.loginWindowX - class41.field821.originalWidth / 2, 271 - class41.field821.height / 2);
            var18 = 211;
            var0.method3912(class41.loginMessage1, class41.loginWindowX + 180, var18, 16776960, 0);
            var19 = var18 + 15;
            var0.method3912(class41.loginMessage2, 180 + class41.loginWindowX, var19, 16776960, 0);
            var19 += 15;
            var0.method3912(class41.loginMessage3, 180 + class41.loginWindowX, var19, 16776960, 0);
            var19 += 15;
            var19 += 10;
            if(class41.loginIndex != 4) {
               var0.method3973("Login: ", 180 + class41.loginWindowX - 110, var19, 16777215, 0);
               var20 = 200;

               for(var6 = class41.username; var0.method3904(var6) > var20; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method3973(FontTypeFace.method3949(var6), 180 + class41.loginWindowX - 70, var19, 16777215, 0);
               var19 += 15;
               var0.method3973("Password: " + class156.method3128(class41.field845), 180 + class41.loginWindowX - 108, var19, 16777215, 0);
               var19 += 15;
            }
         }

         int var7;
         int var21;
         int var24;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field821.method4115(class41.loginWindowX, 171);
            short var14;
            if(class41.loginIndex == 0) {
               var18 = 251;
               var0.method3912("Welcome to RuneScape", class41.loginWindowX + 180, var18, 16776960, 0);
               var19 = var18 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var14 = 291;
               class41.field826.method4115(var5 - 73, var14 - 20);
               var0.method3913("New User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               class41.field826.method4115(var5 - 73, var14 - 20);
               var0.method3913("Existing User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3912(class41.field840, class41.loginWindowX + 180, 211, 16776960, 0);
               var18 = 236;
               var0.method3912(class41.loginMessage1, 180 + class41.loginWindowX, var18, 16777215, 0);
               var19 = var18 + 15;
               var0.method3912(class41.loginMessage2, 180 + class41.loginWindowX, var19, 16777215, 0);
               var19 += 15;
               var0.method3912(class41.loginMessage3, 180 + class41.loginWindowX, var19, 16777215, 0);
               var19 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var14 = 321;
               class41.field826.method4115(var5 - 73, var14 - 20);
               var0.method3912("Continue", var5, var14 + 5, 16777215, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               class41.field826.method4115(var5 - 73, var14 - 20);
               var0.method3912("Cancel", var5, 5 + var14, 16777215, 0);
            } else {
               short var8;
               if(class41.loginIndex == 2) {
                  var18 = 211;
                  var0.method3912(class41.loginMessage1, 180 + class41.loginWindowX, var18, 16776960, 0);
                  var19 = var18 + 15;
                  var0.method3912(class41.loginMessage2, 180 + class41.loginWindowX, var19, 16776960, 0);
                  var19 += 15;
                  var0.method3912(class41.loginMessage3, 180 + class41.loginWindowX, var19, 16776960, 0);
                  var19 += 15;
                  var19 += 10;
                  var0.method3973("Login: ", 180 + class41.loginWindowX - 110, var19, 16777215, 0);
                  var20 = 200;

                  for(var6 = class41.username; var0.method3904(var6) > var20; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method3973(FontTypeFace.method3949(var6) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class37.method813(16776960) + "|":""), class41.loginWindowX + 180 - 70, var19, 16777215, 0);
                  var19 += 15;
                  var0.method3973("Password: " + class156.method3128(class41.field845) + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class37.method813(16776960) + "|":""), class41.loginWindowX + 180 - 108, var19, 16777215, 0);
                  var19 += 15;
                  var7 = class41.loginWindowX + 180 - 80;
                  var8 = 321;
                  class41.field826.method4115(var7 - 73, var8 - 20);
                  var0.method3912("Login", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + class41.loginWindowX + 180;
                  class41.field826.method4115(var7 - 73, var8 - 20);
                  var0.method3912("Cancel", var7, 5 + var8, 16777215, 0);
                  var18 = 357;
                  var1.method3912("Forgotten your password? <col=ffffff>Click here.", 180 + class41.loginWindowX, var18, 16776960, 0);
               } else if(class41.loginIndex == 3) {
                  var18 = 201;
                  var0.method3912("Invalid username or password.", class41.loginWindowX + 180, var18, 16776960, 0);
                  var19 = var18 + 20;
                  var1.method3912("For accounts created after 24th November 2010, please use your", 180 + class41.loginWindowX, var19, 16776960, 0);
                  var19 += 15;
                  var1.method3912("email address to login. Otherwise please login with your username.", 180 + class41.loginWindowX, var19, 16776960, 0);
                  var19 += 15;
                  var5 = class41.loginWindowX + 180;
                  var14 = 276;
                  class41.field826.method4115(var5 - 73, var14 - 20);
                  var2.method3912("Try again", var5, var14 + 5, 16777215, 0);
                  var5 = class41.loginWindowX + 180;
                  var14 = 326;
                  class41.field826.method4115(var5 - 73, var14 - 20);
                  var2.method3912("Forgotten password?", var5, 5 + var14, 16777215, 0);
               } else if(class41.loginIndex == 4) {
                  var0.method3912("Authenticator", 180 + class41.loginWindowX, 211, 16776960, 0);
                  var18 = 236;
                  var0.method3912(class41.loginMessage1, 180 + class41.loginWindowX, var18, 16777215, 0);
                  var19 = var18 + 15;
                  var0.method3912(class41.loginMessage2, class41.loginWindowX + 180, var19, 16777215, 0);
                  var19 += 15;
                  var0.method3912(class41.loginMessage3, 180 + class41.loginWindowX, var19, 16777215, 0);
                  var19 += 15;
                  var0.method3973("PIN: " + class156.method3128(XItemContainer.authCode) + (Client.gameCycle % 40 < 20?class37.method813(16776960) + "|":""), class41.loginWindowX + 180 - 108, var19, 16777215, 0);
                  var19 -= 8;
                  var0.method3973("Trust this computer", 180 + class41.loginWindowX - 9, var19, 16776960, 0);
                  var19 += 15;
                  var0.method3973("for 30 days: ", class41.loginWindowX + 180 - 9, var19, 16776960, 0);
                  var5 = class41.loginWindowX + 180 - 9 + var0.method3904("for 30 days: ") + 15;
                  var24 = var19 - var0.field3112;
                  ModIcon var15;
                  if(class41.field847) {
                     var15 = class41.field835;
                  } else {
                     var15 = FaceNormal.field1568;
                  }

                  var15.method4115(var5, var24);
                  var19 += 15;
                  var21 = class41.loginWindowX + 180 - 80;
                  short var9 = 321;
                  class41.field826.method4115(var21 - 73, var9 - 20);
                  var0.method3912("Continue", var21, 5 + var9, 16777215, 0);
                  var21 = 80 + class41.loginWindowX + 180;
                  class41.field826.method4115(var21 - 73, var9 - 20);
                  var0.method3912("Cancel", var21, 5 + var9, 16777215, 0);
                  var1.method3912("<u=ff>Can\'t Log In?</u>", 180 + class41.loginWindowX, 36 + var9, 255, 0);
               } else if(class41.loginIndex == 5) {
                  var0.method3912("Forgotten your password?", class41.loginWindowX + 180, 201, 16776960, 0);
                  var18 = 221;
                  var2.method3912(class41.loginMessage1, 180 + class41.loginWindowX, var18, 16776960, 0);
                  var19 = var18 + 15;
                  var2.method3912(class41.loginMessage2, 180 + class41.loginWindowX, var19, 16776960, 0);
                  var19 += 15;
                  var2.method3912(class41.loginMessage3, 180 + class41.loginWindowX, var19, 16776960, 0);
                  var19 += 15;
                  var19 += 14;
                  var0.method3973("Username/email: ", class41.loginWindowX + 180 - 145, var19, 16777215, 0);
                  var20 = 174;

                  for(var6 = class41.username; var0.method3904(var6) > var20; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method3973(FontTypeFace.method3949(var6) + (Client.gameCycle % 40 < 20?class37.method813(16776960) + "|":""), class41.loginWindowX + 180 - 34, var19, 16777215, 0);
                  var19 += 15;
                  var7 = 180 + class41.loginWindowX - 80;
                  var8 = 321;
                  class41.field826.method4115(var7 - 73, var8 - 20);
                  var0.method3912("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = class41.loginWindowX + 180 + 80;
                  class41.field826.method4115(var7 - 73, var8 - 20);
                  var0.method3912("Back", var7, var8 + 5, 16777215, 0);
               } else if(class41.loginIndex == 6) {
                  var18 = 211;
                  var0.method3912(class41.loginMessage1, class41.loginWindowX + 180, var18, 16776960, 0);
                  var19 = var18 + 15;
                  var0.method3912(class41.loginMessage2, class41.loginWindowX + 180, var19, 16776960, 0);
                  var19 += 15;
                  var0.method3912(class41.loginMessage3, 180 + class41.loginWindowX, var19, 16776960, 0);
                  var19 += 15;
                  var5 = 180 + class41.loginWindowX;
                  var14 = 321;
                  class41.field826.method4115(var5 - 73, var14 - 20);
                  var0.method3912("Back", var5, 5 + var14, 16777215, 0);
               }
            }
         }

         if(class41.field834 > 0) {
            var19 = class41.field834;
            var20 = 256;
            class41.field833 += 128 * var19;
            if(class41.field833 > class185.field2768.length) {
               class41.field833 -= class185.field2768.length;
               var24 = (int)(Math.random() * 12.0D);
               FrameMap.method1787(ScriptState.field95[var24]);
            }

            var24 = 0;
            var7 = 128 * var19;
            var21 = (var20 - var19) * 128;

            int var10;
            int var23;
            for(var23 = 0; var23 < var21; ++var23) {
               var10 = class47.field946[var24 + var7] - var19 * class185.field2768[var24 + class41.field833 & class185.field2768.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class47.field946[var24++] = var10;
            }

            int var11;
            int var12;
            for(var23 = var20 - var19; var23 < var20; ++var23) {
               var10 = 128 * var23;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class47.field946[var10 + var11] = 255;
                  } else {
                     class47.field946[var11 + var10] = 0;
                  }
               }
            }

            if(class41.field831 > 0) {
               class41.field831 -= 4 * var19;
            }

            if(class41.field856 > 0) {
               class41.field856 -= var19 * 4;
            }

            if(class41.field831 == 0 && class41.field856 == 0) {
               var23 = (int)(Math.random() * (double)(2000 / var19));
               if(var23 == 0) {
                  class41.field831 = 1024;
               }

               if(var23 == 1) {
                  class41.field856 = 1024;
               }
            }

            for(var23 = 0; var23 < var20 - var19; ++var23) {
               class41.field829[var23] = class41.field829[var19 + var23];
            }

            for(var23 = var20 - var19; var23 < var20; ++var23) {
               class41.field829[var23] = (int)(Math.sin((double)class41.field836 / 14.0D) * 16.0D + Math.sin((double)class41.field836 / 15.0D) * 14.0D + Math.sin((double)class41.field836 / 16.0D) * 12.0D);
               ++class41.field836;
            }

            class41.field857 += var19;
            var23 = (var19 + (Client.gameCycle & 1)) / 2;
            if(var23 > 0) {
               for(var10 = 0; var10 < class41.field857 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class47.field946[var11 + (var12 << 7)] = 192;
               }

               class41.field857 = 0;
               var10 = 0;

               label278:
               while(true) {
                  int var13;
                  if(var10 >= var20) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label278;
                        }

                        var11 = 0;

                        for(var12 = -var23; var12 < var20; ++var12) {
                           var13 = 128 * var12;
                           if(var12 + var23 < var20) {
                              var11 += class30.field688[var13 + var10 + 128 * var23];
                           }

                           if(var12 - (var23 + 1) >= 0) {
                              var11 -= class30.field688[var13 + var10 - 128 * (var23 + 1)];
                           }

                           if(var12 >= 0) {
                              class47.field946[var10 + var13] = var11 / (1 + 2 * var23);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = 128 * var10;

                  for(var13 = -var23; var13 < 128; ++var13) {
                     if(var23 + var13 < 128) {
                        var11 += class47.field946[var23 + var13 + var12];
                     }

                     if(var13 - (1 + var23) >= 0) {
                        var11 -= class47.field946[var13 + var12 - (1 + var23)];
                     }

                     if(var13 >= 0) {
                        class30.field688[var13 + var12] = var11 / (1 + 2 * var23);
                     }
                  }

                  ++var10;
               }
            }

            class41.field834 = 0;
         }

         class38.method819();
         class189.field2789[ObjectComposition.field2944.field691?1:0].method4115(765 + class41.field822 - 40, 463);
         if(Client.gameState > 5 && Client.field428 == 0) {
            if(null != class41.field852) {
               var19 = 5 + class41.field822;
               var20 = 463;
               byte var25 = 100;
               byte var22 = 35;
               class41.field852.method4115(var19, var20);
               var0.method3912("World" + " " + Client.world, var25 / 2 + var19, var22 / 2 + var20 - 2, 16777215, 0);
               if(null != class22.worldServersDownload) {
                  var1.method3912("Loading...", var25 / 2 + var19, 12 + var20 + var22 / 2, 16777215, 0);
               } else {
                  var1.method3912("Click to switch", var19 + var25 / 2, var22 / 2 + var20 + 12, 16777215, 0);
               }
            } else {
               class41.field852 = class162.method3186(class39.field808, "sl_button", "");
            }
         }

         try {
            Graphics var16 = class110.canvas.getGraphics();
            class57.bufferProvider.draw(var16, 0, 0);
         } catch (Exception var17) {
            class110.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
   )
   protected abstract void vmethod2295();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIB)LSpritePixels;",
      garbageValue = "-119"
   )
   public static SpritePixels method2296(class182 var0, int var1, int var2) {
      if(!class137.method2556(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class225.field3234;
         var4.maxHeight = class0.field2;
         var4.offsetX = class225.field3236[0];
         var4.offsetY = class145.field2013[0];
         var4.width = class186.field2775[0];
         var4.height = class225.field3235[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = Ignore.field211[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class225.field3237[var6[var7] & 255];
         }

         WallObject.method1986();
         return var4;
      }
   }
}
