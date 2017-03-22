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

@ObfuscatedName("dx")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ra")
   protected static volatile boolean field1775 = false;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -871289925
   )
   static int field1776 = 0;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      longValue = 3652586276972800377L
   )
   static long field1777 = 0L;
   @ObfuscatedName("rr")
   static volatile boolean field1778 = true;
   @ObfuscatedName("qa")
   boolean field1779 = false;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 1793550669
   )
   static int field1780 = 20;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 1780489431
   )
   static int field1781 = 1;
   @ObfuscatedName("qb")
   static boolean field1782 = false;
   @ObfuscatedName("qg")
   protected static long[] field1783 = new long[32];
   @ObfuscatedName("qk")
   protected static long[] field1784 = new long[32];
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 282133281
   )
   protected static int field1785 = 0;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 1594682993
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("rk")
   public static volatile boolean field1787 = true;
   @ObfuscatedName("rc")
   @ObfuscatedGetter(
      intValue = -307258865
   )
   static int field1788 = 500;
   @ObfuscatedName("rd")
   protected static boolean field1789 = false;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -1687426091
   )
   protected static int field1790 = 0;
   @ObfuscatedName("pm")
   static GameEngine field1791 = null;
   @ObfuscatedName("rp")
   @ObfuscatedGetter(
      longValue = -6127573671392865625L
   )
   static volatile long field1793 = 0L;

   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1884491965"
   )
   protected final void method2152(int var1, int var2, int var3) {
      try {
         if(field1791 != null) {
            ++field1776;
            if(field1776 >= 3) {
               this.method2166("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1791 = this;
         class108.field1748 = var1;
         class145.field2018 = var2;
         class101.field1663 = var3;
         class101.field1666 = this;
         if(class72.field1193 == null) {
            class72.field1193 = new class103();
         }

         class72.field1193.method2023(this, 1);
      } catch (Exception var5) {
         class31.method703((String)null, var5);
         this.method2166("crash");
      }

   }

   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2108713309"
   )
   protected final synchronized void method2153() {
      Container var1 = this.method2169();
      if(null != CollisionData.canvas) {
         CollisionData.canvas.removeFocusListener(this);
         var1.remove(CollisionData.canvas);
      }

      class108.field1748 = Math.max(var1.getWidth(), class172.field2340);
      class145.field2018 = Math.max(var1.getHeight(), class105.field1731);
      Insets var2;
      if(null != class16.field206) {
         var2 = class16.field206.getInsets();
         class108.field1748 -= var2.left + var2.right;
         class145.field2018 -= var2.top + var2.bottom;
      }

      CollisionData.canvas = new RSCanvas(this);
      var1.add(CollisionData.canvas);
      CollisionData.canvas.setSize(class108.field1748, class145.field2018);
      CollisionData.canvas.setVisible(true);
      if(class16.field206 == var1) {
         var2 = class16.field206.getInsets();
         CollisionData.canvas.setLocation(var2.left + field1785, var2.top + field1790);
      } else {
         CollisionData.canvas.setLocation(field1785, field1790);
      }

      CollisionData.canvas.addFocusListener(this);
      CollisionData.canvas.requestFocus();
      field1787 = true;
      BufferProvider var3 = CombatInfo2.method3547(class108.field1748, class145.field2018, CollisionData.canvas);
      if(Frames.bufferProvider != null) {
         Frames.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      Frames.bufferProvider = var3;
      field1775 = false;
      field1793 = class99.method2005();
   }

   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1312363819"
   )
   protected final boolean method2154() {
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
                     this.method2166("invalidhost");
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

   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1860848996"
   )
   void method2157() {
      Container var1 = this.method2169();
      long var2 = class99.method2005();
      long var4 = field1783[CipherBuffer.field2114];
      field1783[CipherBuffer.field2114] = var2;
      CipherBuffer.field2114 = 1 + CipherBuffer.field2114 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field1788 - 1 > 50) {
         field1788 -= 50;
         field1787 = true;
         CollisionData.canvas.setSize(class108.field1748, class145.field2018);
         CollisionData.canvas.setVisible(true);
         if(class16.field206 == var1) {
            Insets var7 = class16.field206.getInsets();
            CollisionData.canvas.setLocation(field1785 + var7.left, var7.top + field1790);
         } else {
            CollisionData.canvas.setLocation(field1785, field1790);
         }
      }

      this.vmethod2203();
   }

   public void stop() {
      if(this == field1791 && !field1782) {
         field1777 = class99.method2005() + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusLost(FocusEvent var1) {
      field1778 = false;
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

   public final void windowOpened(WindowEvent var1) {
   }

   public void start() {
      if(this == field1791 && !field1782) {
         field1777 = 0L;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ql")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2069547870"
   )
   protected void method2166(String var1) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-48"
   )
   protected abstract void vmethod2167();

   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "154942088"
   )
   protected Container method2169() {
      return (Container)(class16.field206 != null?class16.field206:this);
   }

   public abstract void init();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2051261552"
   )
   protected abstract void vmethod2179();

   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   final synchronized void method2182() {
      if(!field1782) {
         field1782 = true;

         try {
            CollisionData.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2167();
         } catch (Exception var4) {
            ;
         }

         if(class16.field206 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class72.field1193 != null) {
            try {
               class72.field1193.method2020();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2229();
      }
   }

   public final void focusGained(FocusEvent var1) {
      field1778 = true;
      field1787 = true;
   }

   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void method2198() {
      long var1 = class99.method2005();
      long var3 = field1784[class5.field58];
      field1784[class5.field58] = var1;
      class5.field58 = 1 + class5.field58 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class101.field1661 = field1778;
      }

      this.packetHandler();
   }

   public void run() {
      try {
         int var3;
         if(class103.field1678 != null) {
            String var1 = class103.field1678.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1687;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2166("wrongjava");
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

                  String var6 = var2.substring(6, var3);
                  if(Buffer.method2946(var6) && class196.method3599(var6) < 10) {
                     this.method2166("wrongjava");
                     return;
                  }
               }

               field1781 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2153();
         this.vmethod2179();
         class161.field2129 = Script.method973();

         label83:
         while(true) {
            class103 var9;
            Canvas var10;
            do {
               if(0L != field1777 && class99.method2005() >= field1777) {
                  break label83;
               }

               ItemLayer.field1226 = class161.field2129.vmethod2108(field1780, field1781);

               for(int var7 = 0; var7 < ItemLayer.field1226; ++var7) {
                  this.method2198();
               }

               this.method2157();
               var9 = class72.field1193;
               var10 = CollisionData.canvas;
            } while(var9.field1679 == null);

            for(var3 = 0; var3 < 50 && var9.field1679.peekEvent() != null; ++var3) {
               class140.method2660(1L);
            }

            if(null != var10) {
               var9.field1679.postEvent(new ActionEvent(var10, 1001, "dummy"));
            }
         }
      } catch (Exception var8) {
         class31.method703((String)null, var8);
         this.method2166("crash");
      }

      this.method2182();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected abstract void vmethod2203();

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "1555467870"
   )
   protected Dimension method2212() {
      Container var1 = this.method2169();
      int var2 = Math.max(var1.getWidth(), class172.field2340);
      int var3 = Math.max(var1.getHeight(), class105.field1731);
      if(null != class16.field206) {
         Insets var4 = class16.field206.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   public void destroy() {
      if(field1791 == this && !field1782) {
         field1777 = class99.method2005();
         class140.method2660(5000L);
         this.method2182();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   protected abstract void vmethod2229();

   public final synchronized void paint(Graphics var1) {
      if(this == field1791 && !field1782) {
         field1787 = true;
         if(class103.field1687 != null && class103.field1687.startsWith("1.5") && class99.method2005() - field1793 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class108.field1748 && var2.height >= class145.field2018) {
               field1775 = true;
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "-125"
   )
   static void method2240(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var14;
      if(class41.worldSelectShown) {
         if(class115.field1813 == 1 || !class202.field3076 && class115.field1813 == 4) {
            var1 = 280 + class41.field846;
            if(class115.field1814 >= var1 && class115.field1814 <= 14 + var1 && class115.field1815 >= 4 && class115.field1815 <= 18) {
               class57.method1163(0, 0);
            } else if(class115.field1814 >= var1 + 15 && class115.field1814 <= 80 + var1 && class115.field1815 >= 4 && class115.field1815 <= 18) {
               class57.method1163(0, 1);
            } else {
               var2 = class41.field846 + 390;
               if(class115.field1814 >= var2 && class115.field1814 <= var2 + 14 && class115.field1815 >= 4 && class115.field1815 <= 18) {
                  class57.method1163(1, 0);
               } else if(class115.field1814 >= 15 + var2 && class115.field1814 <= var2 + 80 && class115.field1815 >= 4 && class115.field1815 <= 18) {
                  class57.method1163(1, 1);
               } else {
                  var3 = 500 + class41.field846;
                  if(class115.field1814 >= var3 && class115.field1814 <= var3 + 14 && class115.field1815 >= 4 && class115.field1815 <= 18) {
                     class57.method1163(2, 0);
                  } else if(class115.field1814 >= var3 + 15 && class115.field1814 <= var3 + 80 && class115.field1815 >= 4 && class115.field1815 <= 18) {
                     class57.method1163(2, 1);
                  } else {
                     var14 = 610 + class41.field846;
                     if(class115.field1814 >= var14 && class115.field1814 <= 14 + var14 && class115.field1815 >= 4 && class115.field1815 <= 18) {
                        class57.method1163(3, 0);
                     } else if(class115.field1814 >= var14 + 15 && class115.field1814 <= var14 + 80 && class115.field1815 >= 4 && class115.field1815 <= 18) {
                        class57.method1163(3, 1);
                     } else if(class115.field1814 >= 708 + class41.field846 && class115.field1815 >= 4 && class115.field1814 <= 50 + 708 + class41.field846 && class115.field1815 <= 20) {
                        class41.worldSelectShown = false;
                        class41.field880.method4147(class41.field846, 0);
                        class41.field850.method4147(382 + class41.field846, 0);
                        class186.field2763.method4090(class41.field846 + 382 - class186.field2763.originalWidth / 2, 18);
                     } else if(class41.field848 != -1) {
                        World var9 = World.worldList[class41.field848];
                        ItemLayer.method1518(var9);
                        class41.worldSelectShown = false;
                        class41.field880.method4147(class41.field846, 0);
                        class41.field850.method4147(382 + class41.field846, 0);
                        class186.field2763.method4090(382 + class41.field846 - class186.field2763.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class115.field1813 == 1 || !class202.field3076 && class115.field1813 == 4) && class115.field1814 >= 765 + class41.field846 - 50 && class115.field1815 >= 453) {
            class8.field84.field712 = !class8.field84.field712;
            class0.method10();
            if(!class8.field84.field712) {
               class184 var10 = class3.field39;
               var2 = var10.method3321("scape main");
               var3 = var10.method3322(var2, "");
               class40.method821(var10, var2, var3, 255, false);
            } else {
               class138.field1919.method2536();
               class138.field1920 = 1;
               class138.field1916 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class41.field863;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field409 == 0) {
                  if(class115.field1813 == 1 || !class202.field3076 && class115.field1813 == 4) {
                     var1 = 5 + class41.field846;
                     short var11 = 463;
                     byte var12 = 100;
                     byte var4 = 35;
                     if(class115.field1814 >= var1 && class115.field1814 <= var12 + var1 && class115.field1815 >= var11 && class115.field1815 <= var11 + var4) {
                        if(class108.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(World.worldServersDownload != null) {
                     class105.method2058();
                  }
               }

               var1 = class115.field1813;
               var2 = class115.field1814;
               var3 = class115.field1815;
               if(!class202.field3076 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class41.loginIndex == 0) {
                  boolean var13 = false;

                  while(GroundObject.method1593()) {
                     if(FileOnDisk.field1202 == 84) {
                        var13 = true;
                     }
                  }

                  var5 = 180 + class41.loginWindowX - 80;
                  var6 = 291;
                  if(var1 == 1 && var2 >= var5 - 75 && var2 <= 75 + var5 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                     RSCanvas.method2137(GroundObject.method1596("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var5 = 180 + class41.loginWindowX + 80;
                  if(var1 == 1 && var2 >= var5 - 75 && var2 <= 75 + var5 && var3 >= var6 - 20 && var3 <= var6 + 20 || var13) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field870 = "";
                        class41.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class41.loginMessage2 = "Your normal account will not be affected.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class41.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other almost everywhere";
                           class41.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class41.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other";
                           class41.loginMessage3 = "almost everywhere.";
                        }

                        class41.field870 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field870 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }
                  }
               } else {
                  short var16;
                  if(class41.loginIndex != 1) {
                     short var15;
                     if(class41.loginIndex == 2) {
                        var15 = 231;
                        var14 = var15 + 30;
                        if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                           class41.loginIndex2 = 0;
                        }

                        var14 += 15;
                        if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                           class41.loginIndex2 = 1;
                        }

                        var14 += 15;
                        var15 = 361;
                        if(var1 == 1 && var3 >= var15 - 15 && var3 < var15) {
                           class5.method67("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }

                        var5 = class41.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var2 >= var5 - 75 && var2 <= 75 + var5 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                           class41.username = class41.username.trim();
                           if(class41.username.length() == 0) {
                              class5.method67("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class41.field873.length() == 0) {
                              class5.method67("", "Please enter your password.", "");
                              return;
                           }

                           class5.method67("", "Connecting to server...", "");
                           class41.field874 = class8.field84.field722.containsKey(Integer.valueOf(class152.method2814(class41.username)))?class97.field1638:class97.field1640;
                           class187.setGameState(20);
                           return;
                        }

                        var5 = class41.loginWindowX + 180 + 80;
                        if(var1 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field873 = "";
                           CombatInfoListHolder.field781 = 0;
                           class146.authCode = "";
                           class41.field875 = true;
                        }

                        while(true) {
                           while(GroundObject.method1593()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class157.field2108 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(FileOnDisk.field1202 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field873 = "";
                                 CombatInfoListHolder.field781 = 0;
                                 class146.authCode = "";
                                 class41.field875 = true;
                              } else if(class41.loginIndex2 == 0) {
                                 if(FileOnDisk.field1202 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(FileOnDisk.field1202 == 84 || FileOnDisk.field1202 == 80) {
                                    class41.loginIndex2 = 1;
                                 }

                                 if(var7 && class41.username.length() < 320) {
                                    class41.username = class41.username + class157.field2108;
                                 }
                              } else if(class41.loginIndex2 == 1) {
                                 if(FileOnDisk.field1202 == 85 && class41.field873.length() > 0) {
                                    class41.field873 = class41.field873.substring(0, class41.field873.length() - 1);
                                 }

                                 if(FileOnDisk.field1202 == 84 || FileOnDisk.field1202 == 80) {
                                    class41.loginIndex2 = 0;
                                 }

                                 if(FileOnDisk.field1202 == 84) {
                                    class41.username = class41.username.trim();
                                    if(class41.username.length() == 0) {
                                       class5.method67("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class41.field873.length() == 0) {
                                       class5.method67("", "Please enter your password.", "");
                                       return;
                                    }

                                    class5.method67("", "Connecting to server...", "");
                                    class41.field874 = class8.field84.field722.containsKey(Integer.valueOf(class152.method2814(class41.username)))?class97.field1638:class97.field1640;
                                    class187.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class41.field873.length() < 20) {
                                    class41.field873 = class41.field873 + class157.field2108;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class41.loginIndex == 3) {
                        var14 = class41.loginWindowX + 180;
                        var16 = 276;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var16 - 20 && var3 <= var16 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        }

                        var14 = 180 + class41.loginWindowX;
                        var16 = 326;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var16 - 20 && var3 <= var16 + 20) {
                           class5.method67("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var17;
                        int var18;
                        if(class41.loginIndex == 4) {
                           var14 = class41.loginWindowX + 180 - 80;
                           var16 = 321;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var16 - 20 && var3 <= 20 + var16) {
                              class146.authCode.trim();
                              if(class146.authCode.length() != 6) {
                                 class5.method67("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              CombatInfoListHolder.field781 = Integer.parseInt(class146.authCode);
                              class146.authCode = "";
                              class41.field874 = class41.field875?class97.field1639:class97.field1645;
                              class5.method67("", "Connecting to server...", "");
                              class187.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var2 >= 180 + class41.loginWindowX - 9 && var2 <= 130 + class41.loginWindowX + 180 && var3 >= 263 && var3 <= 296) {
                              class41.field875 = !class41.field875;
                           }

                           if(var1 == 1 && var2 >= class41.loginWindowX + 180 - 34 && var2 <= 34 + class41.loginWindowX + 180 && var3 >= 351 && var3 <= 363) {
                              RSCanvas.method2137(GroundObject.method1596("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var14 = 80 + class41.loginWindowX + 180;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var16 - 20 && var3 <= 20 + var16) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field873 = "";
                              CombatInfoListHolder.field781 = 0;
                              class146.authCode = "";
                           }

                           while(GroundObject.method1593()) {
                              var17 = false;

                              for(var18 = 0; var18 < "1234567890".length(); ++var18) {
                                 if(class157.field2108 == "1234567890".charAt(var18)) {
                                    var17 = true;
                                    break;
                                 }
                              }

                              if(FileOnDisk.field1202 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field873 = "";
                                 CombatInfoListHolder.field781 = 0;
                                 class146.authCode = "";
                              } else {
                                 if(FileOnDisk.field1202 == 85 && class146.authCode.length() > 0) {
                                    class146.authCode = class146.authCode.substring(0, class146.authCode.length() - 1);
                                 }

                                 if(FileOnDisk.field1202 == 84) {
                                    class146.authCode.trim();
                                    if(class146.authCode.length() != 6) {
                                       class5.method67("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    CombatInfoListHolder.field781 = Integer.parseInt(class146.authCode);
                                    class146.authCode = "";
                                    class41.field874 = class41.field875?class97.field1639:class97.field1645;
                                    class5.method67("", "Connecting to server...", "");
                                    class187.setGameState(20);
                                    return;
                                 }

                                 if(var17 && class146.authCode.length() < 6) {
                                    class146.authCode = class146.authCode + class157.field2108;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 5) {
                           var14 = 180 + class41.loginWindowX - 80;
                           var16 = 321;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var16 - 20 && var3 <= 20 + var16) {
                              class18.method210();
                              return;
                           }

                           var14 = 180 + class41.loginWindowX + 80;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var16 - 20 && var3 <= 20 + var16) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field873 = "";
                           }

                           while(GroundObject.method1593()) {
                              var17 = false;

                              for(var18 = 0; var18 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var18) {
                                 if(class157.field2108 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var18)) {
                                    var17 = true;
                                    break;
                                 }
                              }

                              if(FileOnDisk.field1202 == 13) {
                                 class41.loginMessage1 = "";
                                 class41.loginMessage2 = "Enter your username/email & password.";
                                 class41.loginMessage3 = "";
                                 class41.loginIndex = 2;
                                 class41.loginIndex2 = 0;
                                 class41.field873 = "";
                              } else {
                                 if(FileOnDisk.field1202 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(FileOnDisk.field1202 == 84) {
                                    class18.method210();
                                    return;
                                 }

                                 if(var17 && class41.username.length() < 320) {
                                    class41.username = class41.username + class157.field2108;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!GroundObject.method1593()) {
                                    var15 = 321;
                                    if(var1 == 1 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                                       class41.loginMessage1 = "";
                                       class41.loginMessage2 = "Enter your username/email & password.";
                                       class41.loginMessage3 = "";
                                       class41.loginIndex = 2;
                                       class41.loginIndex2 = 0;
                                       class41.field873 = "";
                                    }

                                    return;
                                 }
                              } while(FileOnDisk.field1202 != 84 && FileOnDisk.field1202 != 13);

                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field873 = "";
                           }
                        }
                     }
                  } else {
                     while(GroundObject.method1593()) {
                        if(FileOnDisk.field1202 == 84) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        } else if(FileOnDisk.field1202 == 13) {
                           class41.loginIndex = 0;
                        }
                     }

                     var14 = class41.loginWindowX + 180 - 80;
                     var16 = 321;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var16 - 20 && var3 <= 20 + var16) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var14 = 180 + class41.loginWindowX + 80;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var16 - 20 && var3 <= 20 + var16) {
                        class41.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)LSpritePixels;",
      garbageValue = "116"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var4 << 40) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class154.getItemDefinition(var0);
      if(var1 > 1 && null != var9.countObj) {
         int var19 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var19 = var9.countObj[var11];
            }
         }

         if(var19 != -1) {
            var9 = class154.getItemDefinition(var19);
         }
      }

      Model var10 = var9.getModel(1);
      if(var10 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.notedTemplate != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var20) {
               return null;
            }
         } else if(var9.field2998 != -1) {
            var20 = createSprite(var9.field2997, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field3000 != -1) {
            var20 = createSprite(var9.field2973, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method4000(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method4030();
         class84.method1707();
         class84.method1697(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field3000 != -1) {
            var20.method4149(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class84.field1441[var9.xan2d] * var16 >> 16;
         int var18 = class84.field1462[var9.xan2d] * var16 >> 16;
         var10.method1617();
         var10.method1629(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var9.offsetY2d + var10.modelHeight / 2 + var17, var9.offsetY2d + var18);
         if(var9.field2998 != -1) {
            var20.method4149(0, 0);
         }

         if(var2 >= 1) {
            var8.method4231(1);
         }

         if(var2 >= 2) {
            var8.method4231(16777215);
         }

         if(var3 != 0) {
            var8.method4170(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.method4149(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class25.field610.method3881(class94.method1982(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method4044(var15);
         class84.method1707();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-367340394"
   )
   static boolean method2242(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = GroundObject.method1598(var0, class165.field2155);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(GroundObject.method1598(var3.name, class165.field2155))) {
               return true;
            }

            if(var1.equalsIgnoreCase(GroundObject.method1598(var3.previousName, class165.field2155))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "118"
   )
   public static void method2243(Applet var0, String var1) {
      class114.field1798 = var0;
      class114.field1794 = var1;
   }
}
