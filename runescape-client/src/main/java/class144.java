import java.applet.Applet;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("GameEngine")
public abstract class class144 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pw")
   boolean field2200;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -299486427
   )
   static int field2201 = 0;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      longValue = -8683743782822624849L
   )
   static long field2202 = 0L;
   @ObfuscatedName("pa")
   static boolean field2203 = false;
   @ObfuscatedName("pp")
   static class144 field2204 = null;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 1609816185
   )
   static int field2205 = 20;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -2002387027
   )
   static int field2206 = 1;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 1300557993
   )
   @Export("FPS")
   protected static int field2207 = 0;
   @ObfuscatedName("qy")
   static long[] field2208 = new long[32];
   @ObfuscatedName("qz")
   protected static boolean field2209 = false;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 76408011
   )
   protected static int field2210 = 0;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 270128779
   )
   protected static int field2211 = 0;
   @ObfuscatedName("qp")
   protected static volatile boolean field2212 = true;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -1834982127
   )
   static int field2213 = 500;
   @ObfuscatedName("qq")
   protected static volatile boolean field2214 = false;
   @ObfuscatedName("qd")
   static long[] field2215 = new long[32];
   @ObfuscatedName("rp")
   @ObfuscatedGetter(
      longValue = -204724362780181817L
   )
   static volatile long field2216 = 0L;
   @ObfuscatedName("rl")
   static volatile boolean field2217 = true;
   @ObfuscatedName("dx")
   static int[] field2220;

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusLost(FocusEvent var1) {
      field2217 = false;
   }

   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-966580052"
   )
   void method2984() {
      long var1 = class12.method162();
      long var3 = field2215[class46.field1062];
      field2215[class46.field1062] = var1;
      class46.field1062 = 1 + class46.field1062 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class131.field2078 = field2217;
      }

      this.vmethod2992();
   }

   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1032604152"
   )
   final synchronized void method2985() {
      if(!field2203) {
         field2203 = true;

         try {
            class122.field2024.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2987();
         } catch (Exception var4) {
            ;
         }

         if(class85.field1464 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class38.field878) {
            try {
               class38.field878.method2880();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2998();
      }
   }

   public void start() {
      if(field2204 == this && !field2203) {
         field2202 = 0L;
      }
   }

   public void stop() {
      if(field2204 == this && !field2203) {
         field2202 = class12.method162() + 4000L;
      }
   }

   public void destroy() {
      if(this == field2204 && !field2203) {
         field2202 = class12.method162();
         class116.method2448(5000L);
         this.method2985();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   protected abstract void vmethod2987();

   public final void focusGained(FocusEvent var1) {
      field2217 = true;
      field2212 = true;
   }

   public abstract void init();

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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-696510695"
   )
   protected abstract void vmethod2991();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   protected abstract void vmethod2992();

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2111856721"
   )
   protected abstract void vmethod2993();

   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1349306167"
   )
   protected void method2995(String var1) {
      if(!this.field2200) {
         this.field2200 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-930633563"
   )
   protected Container method2996() {
      return (Container)(class85.field1464 != null?class85.field1464:this);
   }

   @ObfuscatedName("ql")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Dimension;",
      garbageValue = "7"
   )
   protected Dimension method2997() {
      Container var1 = this.method2996();
      int var2 = Math.max(var1.getWidth(), class98.field1682);
      int var3 = Math.max(var1.getHeight(), class136.field2114);
      if(class85.field1464 != null) {
         Insets var4 = class85.field1464.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-99228613"
   )
   protected abstract void vmethod2998();

   public final void windowActivated(WindowEvent var1) {
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2204 && !field2203) {
         field2212 = true;
         if(null != class124.field2046 && class124.field2046.startsWith("1.5") && class12.method162() - field2216 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class15.field214 && var2.height >= class15.field215) {
               field2214 = true;
            }
         }

      }
   }

   public void run() {
      try {
         if(class136.field2115 != null) {
            String var1 = class136.field2115.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class124.field2046;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2995("wrongjava");
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

                  String var8 = var2.substring(6, var3);
                  if(class133.method2844(var8)) {
                     int var9 = class121.method2729(var8, 10, true);
                     if(var9 < 10) {
                        this.method2995("wrongjava");
                        return;
                     }
                  }
               }

               field2206 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3084();
         this.vmethod2991();
         class43.field1020 = class114.method2436();

         while(0L == field2202 || class12.method162() < field2202) {
            class33.field777 = class43.field1020.vmethod3106(field2205, field2206);

            for(int var7 = 0; var7 < class33.field777; ++var7) {
               this.method2984();
            }

            this.method3089();
            class17.method202(class38.field878, class122.field2024);
         }
      } catch (Exception var6) {
         class90.method2067((String)null, var6);
         this.method2995("crash");
      }

      this.method2985();
   }

   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-977982019"
   )
   protected final boolean method3032() {
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
                     this.method2995("invalidhost");
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

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "765"
   )
   protected final void method3044(int var1, int var2, int var3) {
      try {
         if(field2204 != null) {
            ++field2201;
            if(field2201 >= 3) {
               this.method2995("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2204 = this;
         class15.field214 = var1;
         class15.field215 = var2;
         class148.field2236 = var3;
         class126.field2052 = this;
         if(class38.field878 == null) {
            class38.field878 = new class136();
         }

         class38.field878.method2862(this, 1);
      } catch (Exception var5) {
         class90.method2067((String)null, var5);
         this.method2995("crash");
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   static final void method3081() {
      if(client.field295 > 1) {
         --client.field295;
      }

      if(client.field332 > 0) {
         --client.field332;
      }

      if(client.field333) {
         client.field333 = false;
         class115.method2442();
      } else {
         if(!client.field418) {
            client.field424[0] = "Cancel";
            client.field425[0] = "";
            client.field422[0] = 1006;
            client.field496 = 1;
         }

         int var0;
         for(var0 = 0; var0 < 100 && class75.method1591(); ++var0) {
            ;
         }

         if(30 == client.field286) {
            while(true) {
               class210 var1 = (class210)class211.field3143.method3856();
               boolean var15;
               if(var1 == null) {
                  var15 = false;
               } else {
                  var15 = true;
               }

               int var16;
               if(!var15) {
                  Object var17 = class44.field1036.field192;
                  int var2;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  synchronized(class44.field1036.field192) {
                     if(!client.field277) {
                        class44.field1036.field195 = 0;
                     } else if(0 != class140.field2159 || class44.field1036.field195 >= 40) {
                        client.field322.method2737(42);
                        client.field322.method2477(0);
                        var16 = client.field322.field2005;
                        var2 = 0;

                        for(var3 = 0; var3 < class44.field1036.field195 && client.field322.field2005 - var16 < 240; ++var3) {
                           ++var2;
                           var4 = class44.field1036.field191[var3];
                           if(var4 < 0) {
                              var4 = 0;
                           } else if(var4 > 502) {
                              var4 = 502;
                           }

                           var5 = class44.field1036.field194[var3];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 764) {
                              var5 = 764;
                           }

                           var6 = var4 * 765 + var5;
                           if(-1 == class44.field1036.field191[var3] && class44.field1036.field194[var3] == -1) {
                              var5 = -1;
                              var4 = -1;
                              var6 = 524287;
                           }

                           if(var5 == client.field290 && client.field505 == var4) {
                              if(client.field489 < 2047) {
                                 ++client.field489;
                              }
                           } else {
                              var7 = var5 - client.field290;
                              client.field290 = var5;
                              var8 = var4 - client.field505;
                              client.field505 = var4;
                              if(client.field489 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                                 var7 += 32;
                                 var8 += 32;
                                 client.field322.method2661(var8 + (var7 << 6) + (client.field489 << 12));
                                 client.field489 = 0;
                              } else if(client.field489 < 8) {
                                 client.field322.method2606(var6 + 8388608 + (client.field489 << 19));
                                 client.field489 = 0;
                              } else {
                                 client.field322.method2480(var6 + -1073741824 + (client.field489 << 19));
                                 client.field489 = 0;
                              }
                           }
                        }

                        client.field322.method2562(client.field322.field2005 - var16);
                        if(var2 >= class44.field1036.field195) {
                           class44.field1036.field195 = 0;
                        } else {
                           class44.field1036.field195 -= var2;

                           for(var3 = 0; var3 < class44.field1036.field195; ++var3) {
                              class44.field1036.field194[var3] = class44.field1036.field194[var3 + var2];
                              class44.field1036.field191[var3] = class44.field1036.field191[var3 + var2];
                           }
                        }
                     }
                  }

                  if(1 == class140.field2159 || !class89.field1563 && 4 == class140.field2159 || class140.field2159 == 2) {
                     long var18 = (class140.field2164 - client.field289) / 50L;
                     if(var18 > 4095L) {
                        var18 = 4095L;
                     }

                     client.field289 = class140.field2164;
                     var2 = class140.field2170;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > class15.field215) {
                        var2 = class15.field215;
                     }

                     var3 = class140.field2169;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class15.field214) {
                        var3 = class15.field214;
                     }

                     var4 = (int)var18;
                     client.field322.method2737(28);
                     client.field322.method2661((var4 << 1) + (class140.field2159 == 2?1:0));
                     client.field322.method2661(var3);
                     client.field322.method2661(var2);
                  }

                  if(class137.field2140 > 0) {
                     client.field322.method2737(223);
                     client.field322.method2661(0);
                     var0 = client.field322.field2005;
                     long var19 = class12.method162();

                     for(var3 = 0; var3 < class137.field2140; ++var3) {
                        long var26 = var19 - client.field503;
                        if(var26 > 16777215L) {
                           var26 = 16777215L;
                        }

                        client.field503 = var19;
                        client.field322.method2515((int)var26);
                        client.field322.method2516(class137.field2139[var3]);
                     }

                     client.field322.method2524(client.field322.field2005 - var0);
                  }

                  if(client.field351 > 0) {
                     --client.field351;
                  }

                  if(class137.field2120[96] || class137.field2120[97] || class137.field2120[98] || class137.field2120[99]) {
                     client.field371 = true;
                  }

                  if(client.field371 && client.field351 <= 0) {
                     client.field351 = 20;
                     client.field371 = false;
                     client.field322.method2737(165);
                     client.field322.method2661(client.field363);
                     client.field322.method2557(client.field364);
                  }

                  if(class131.field2078 && !client.field541) {
                     client.field541 = true;
                     client.field322.method2737(236);
                     client.field322.method2477(1);
                  }

                  if(!class131.field2078 && client.field541) {
                     client.field541 = false;
                     client.field322.method2737(236);
                     client.field322.method2477(0);
                  }

                  if(client.field507 != class21.field581) {
                     client.field507 = class21.field581;
                     class127.method2805(class21.field581);
                  }

                  if(30 != client.field286) {
                     return;
                  }

                  for(class16 var22 = (class16)client.field411.method3812(); var22 != null; var22 = (class16)client.field411.method3817()) {
                     if(var22.field230 > 0) {
                        --var22.field230;
                     }

                     boolean var20;
                     class40 var29;
                     if(0 == var22.field230) {
                        if(var22.field229 >= 0) {
                           var2 = var22.field229;
                           var3 = var22.field225;
                           var29 = class9.method120(var2);
                           if(11 == var3) {
                              var3 = 10;
                           }

                           if(var3 >= 5 && var3 <= 8) {
                              var3 = 4;
                           }

                           var20 = var29.method807(var3);
                           if(!var20) {
                              continue;
                           }
                        }

                        class38.method736(var22.field227, var22.field220, var22.field221, var22.field232, var22.field229, var22.field222, var22.field225);
                        var22.method3898();
                     } else {
                        if(var22.field228 > 0) {
                           --var22.field228;
                        }

                        if(0 == var22.field228 && var22.field221 >= 1 && var22.field232 >= 1 && var22.field221 <= 102 && var22.field232 <= 102) {
                           if(var22.field223 >= 0) {
                              var2 = var22.field223;
                              var3 = var22.field219;
                              var29 = class9.method120(var2);
                              if(11 == var3) {
                                 var3 = 10;
                              }

                              if(var3 >= 5 && var3 <= 8) {
                                 var3 = 4;
                              }

                              var20 = var29.method807(var3);
                              if(!var20) {
                                 continue;
                              }
                           }

                           class38.method736(var22.field227, var22.field220, var22.field221, var22.field232, var22.field223, var22.field224, var22.field219);
                           var22.field228 = -1;
                           if(var22.field223 == var22.field229 && -1 == var22.field229) {
                              var22.method3898();
                           } else if(var22.field223 == var22.field229 && var22.field222 == var22.field224 && var22.field225 == var22.field219) {
                              var22.method3898();
                           }
                        }
                     }
                  }

                  class18.method210();
                  ++client.field510;
                  if(client.field510 > 750) {
                     class115.method2442();
                     return;
                  }

                  var0 = class32.field755;
                  int[] var21 = class32.field756;

                  for(var2 = 0; var2 < var0; ++var2) {
                     class2 var32 = client.field491[var21[var2]];
                     if(null != var32) {
                        class72.method1550(var32, 1);
                     }
                  }

                  class94.method2144();
                  class15.method191();
                  ++client.field356;
                  if(0 != client.field390) {
                     client.field389 += 20;
                     if(client.field389 >= 400) {
                        client.field390 = 0;
                     }
                  }

                  if(class19.field274 != null) {
                     ++client.field391;
                     if(client.field391 >= 15) {
                        class34.method701(class19.field274);
                        class19.field274 = null;
                     }
                  }

                  class173 var24 = class4.field78;
                  class173 var23 = class26.field664;
                  class4.field78 = null;
                  class26.field664 = null;
                  client.field454 = null;
                  client.field458 = false;
                  client.field455 = false;
                  client.field500 = 0;

                  while(class20.method551() && client.field500 < 128) {
                     if(client.field517 >= 2 && class137.field2120[82] && 66 == class137.field2133) {
                        String var35 = "";

                        class35 var28;
                        for(Iterator var30 = class11.field167.iterator(); var30.hasNext(); var35 = var35 + var28.field795 + ':' + var28.field791 + '\n') {
                           var28 = (class35)var30.next();
                        }

                        class121.field2019.setContents(new StringSelection(var35), (ClipboardOwner)null);
                     } else {
                        client.field408[client.field500] = class137.field2133;
                        client.field501[client.field500] = class109.field1917;
                        ++client.field500;
                     }
                  }

                  if(client.field412 != -1) {
                     class123.method2770(client.field412, 0, 0, class15.field214, class15.field215, 0, 0);
                  }

                  ++client.field462;

                  while(true) {
                     class0 var25;
                     class173 var31;
                     class173 var36;
                     do {
                        var25 = (class0)client.field328.method3810();
                        if(null == var25) {
                           while(true) {
                              do {
                                 var25 = (class0)client.field478.method3810();
                                 if(null == var25) {
                                    while(true) {
                                       do {
                                          var25 = (class0)client.field283.method3810();
                                          if(null == var25) {
                                             class11.method140();
                                             if(client.field450 != null) {
                                                class45.method933();
                                             }

                                             if(class25.field626 != null) {
                                                class34.method701(class25.field626);
                                                ++client.field417;
                                                if(class140.field2161 == 0) {
                                                   if(client.field397) {
                                                      if(class25.field642 == class25.field626 && client.field359 != client.field296) {
                                                         class173 var27 = class25.field626;
                                                         byte var37 = 0;
                                                         if(client.field349 == 1 && var27.field2887 == 206) {
                                                            var37 = 1;
                                                         }

                                                         if(var27.field2883[client.field296] <= 0) {
                                                            var37 = 0;
                                                         }

                                                         if(class45.method934(class48.method962(var27))) {
                                                            var4 = client.field359;
                                                            var5 = client.field296;
                                                            var27.field2883[var5] = var27.field2883[var4];
                                                            var27.field2884[var5] = var27.field2884[var4];
                                                            var27.field2883[var4] = -1;
                                                            var27.field2884[var4] = 0;
                                                         } else if(1 == var37) {
                                                            var4 = client.field359;
                                                            var5 = client.field296;

                                                            while(var4 != var5) {
                                                               if(var4 > var5) {
                                                                  var27.method3371(var4 - 1, var4);
                                                                  --var4;
                                                               } else if(var4 < var5) {
                                                                  var27.method3371(var4 + 1, var4);
                                                                  ++var4;
                                                               }
                                                            }
                                                         } else {
                                                            var27.method3371(client.field296, client.field359);
                                                         }

                                                         client.field322.method2737(85);
                                                         client.field322.method2587(class25.field626.field2826);
                                                         client.field322.method2590(var37);
                                                         client.field322.method2525(client.field359);
                                                         client.field322.method2557(client.field296);
                                                      }
                                                   } else if((client.field545 == 1 || class33.method692(client.field496 - 1)) && client.field496 > 2) {
                                                      class39.method772(client.field394, client.field395);
                                                   } else if(client.field496 > 0) {
                                                      var2 = client.field394;
                                                      var3 = client.field395;
                                                      class30 var33 = class16.field231;
                                                      class13.method171(var33.field713, var33.field704, var33.field705, var33.field711, var33.field703, var33.field703, var2, var3);
                                                      class16.field231 = null;
                                                   }

                                                   client.field391 = 10;
                                                   class140.field2159 = 0;
                                                   class25.field626 = null;
                                                } else if(client.field417 >= 5 && (class140.field2162 > 5 + client.field394 || class140.field2162 < client.field394 - 5 || class140.field2163 > client.field395 + 5 || class140.field2163 < client.field395 - 5)) {
                                                   client.field397 = true;
                                                }
                                             }

                                             if(class86.field1471 != -1) {
                                                var2 = class86.field1471;
                                                var3 = class86.field1502;
                                                client.field322.method2737(74);
                                                client.field322.method2477(5);
                                                client.field322.method2681(class137.field2120[82]?(class137.field2120[81]?2:1):0);
                                                client.field322.method2624(var2 + class22.field594);
                                                client.field322.method2557(var3 + class114.field1981);
                                                class86.field1471 = -1;
                                                client.field387 = class140.field2169;
                                                client.field539 = class140.field2170;
                                                client.field390 = 1;
                                                client.field389 = 0;
                                                client.field512 = var2;
                                                client.field513 = var3;
                                             }

                                             if(var24 != class4.field78) {
                                                if(null != var24) {
                                                   class34.method701(var24);
                                                }

                                                if(class4.field78 != null) {
                                                   class34.method701(class4.field78);
                                                }
                                             }

                                             if(class26.field664 != var23 && client.field429 == client.field428) {
                                                if(var23 != null) {
                                                   class34.method701(var23);
                                                }

                                                if(class26.field664 != null) {
                                                   class34.method701(class26.field664);
                                                }
                                             }

                                             if(null != class26.field664) {
                                                if(client.field428 < client.field429) {
                                                   ++client.field428;
                                                   if(client.field429 == client.field428) {
                                                      class34.method701(class26.field664);
                                                   }
                                                }
                                             } else if(client.field428 > 0) {
                                                --client.field428;
                                             }

                                             var2 = class106.field1881.field823 + client.field342;
                                             var3 = client.field346 + class106.field1881.field813;
                                             if(class17.field236 - var2 < -500 || class17.field236 - var2 > 500 || class160.field2646 - var3 < -500 || class160.field2646 - var3 > 500) {
                                                class17.field236 = var2;
                                                class160.field2646 = var3;
                                             }

                                             if(var2 != class17.field236) {
                                                class17.field236 += (var2 - class17.field236) / 16;
                                             }

                                             if(class160.field2646 != var3) {
                                                class160.field2646 += (var3 - class160.field2646) / 16;
                                             }

                                             if(class140.field2161 == 4 && class89.field1563) {
                                                var4 = class140.field2163 - client.field392;
                                                client.field366 = var4 * 2;
                                                client.field392 = var4 != -1 && var4 != 1?(client.field392 + class140.field2163) / 2:class140.field2163;
                                                var5 = client.field367 - class140.field2162;
                                                client.field365 = var5 * 2;
                                                client.field367 = var5 != -1 && 1 != var5?(class140.field2162 + client.field367) / 2:class140.field2162;
                                             } else {
                                                if(class137.field2120[96]) {
                                                   client.field365 += (-24 - client.field365) / 2;
                                                } else if(class137.field2120[97]) {
                                                   client.field365 += (24 - client.field365) / 2;
                                                } else {
                                                   client.field365 /= 2;
                                                }

                                                if(class137.field2120[98]) {
                                                   client.field366 += (12 - client.field366) / 2;
                                                } else if(class137.field2120[99]) {
                                                   client.field366 += (-12 - client.field366) / 2;
                                                } else {
                                                   client.field366 /= 2;
                                                }

                                                client.field392 = class140.field2163;
                                                client.field367 = class140.field2162;
                                             }

                                             client.field364 = client.field365 / 2 + client.field364 & 2047;
                                             client.field363 += client.field366 / 2;
                                             if(client.field363 < 128) {
                                                client.field363 = 128;
                                             }

                                             if(client.field363 > 383) {
                                                client.field363 = 383;
                                             }

                                             var4 = class17.field236 >> 7;
                                             var5 = class160.field2646 >> 7;
                                             var6 = class107.method2369(class17.field236, class160.field2646, class21.field581);
                                             var7 = 0;
                                             int var9;
                                             int var10;
                                             int var11;
                                             if(var4 > 3 && var5 > 3 && var4 < 100 && var5 < 100) {
                                                for(var8 = var4 - 4; var8 <= var4 + 4; ++var8) {
                                                   for(var9 = var5 - 4; var9 <= 4 + var5; ++var9) {
                                                      var10 = class21.field581;
                                                      if(var10 < 3 && 2 == (class5.field90[1][var8][var9] & 2)) {
                                                         ++var10;
                                                      }

                                                      var11 = var6 - class5.field93[var10][var8][var9];
                                                      if(var11 > var7) {
                                                         var7 = var11;
                                                      }
                                                   }
                                                }
                                             }

                                             var8 = var7 * 192;
                                             if(var8 > 98048) {
                                                var8 = 98048;
                                             }

                                             if(var8 < '耀') {
                                                var8 = '耀';
                                             }

                                             if(var8 > client.field372) {
                                                client.field372 += (var8 - client.field372) / 24;
                                             } else if(var8 < client.field372) {
                                                client.field372 += (var8 - client.field372) / 80;
                                             }

                                             if(client.field558) {
                                                var2 = 64 + class150.field2258 * 128;
                                                var3 = 64 + class17.field241 * 128;
                                                var4 = class107.method2369(var2, var3, class21.field581) - class1.field28;
                                                if(class77.field1404 < var2) {
                                                   class77.field1404 += class49.field1092 * (var2 - class77.field1404) / 1000 + class119.field2006;
                                                   if(class77.field1404 > var2) {
                                                      class77.field1404 = var2;
                                                   }
                                                }

                                                if(class77.field1404 > var2) {
                                                   class77.field1404 -= class49.field1092 * (class77.field1404 - var2) / 1000 + class119.field2006;
                                                   if(class77.field1404 < var2) {
                                                      class77.field1404 = var2;
                                                   }
                                                }

                                                if(class7.field138 < var4) {
                                                   class7.field138 += class119.field2006 + class49.field1092 * (var4 - class7.field138) / 1000;
                                                   if(class7.field138 > var4) {
                                                      class7.field138 = var4;
                                                   }
                                                }

                                                if(class7.field138 > var4) {
                                                   class7.field138 -= class119.field2006 + (class7.field138 - var4) * class49.field1092 / 1000;
                                                   if(class7.field138 < var4) {
                                                      class7.field138 = var4;
                                                   }
                                                }

                                                if(class72.field1353 < var3) {
                                                   class72.field1353 += class49.field1092 * (var3 - class72.field1353) / 1000 + class119.field2006;
                                                   if(class72.field1353 > var3) {
                                                      class72.field1353 = var3;
                                                   }
                                                }

                                                if(class72.field1353 > var3) {
                                                   class72.field1353 -= class119.field2006 + (class72.field1353 - var3) * class49.field1092 / 1000;
                                                   if(class72.field1353 < var3) {
                                                      class72.field1353 = var3;
                                                   }
                                                }

                                                var2 = class47.field1072 * 128 + 64;
                                                var3 = class95.field1634 * 128 + 64;
                                                var4 = class107.method2369(var2, var3, class21.field581) - class76.field1391;
                                                var5 = var2 - class77.field1404;
                                                var6 = var4 - class7.field138;
                                                var7 = var3 - class72.field1353;
                                                var8 = (int)Math.sqrt((double)(var5 * var5 + var7 * var7));
                                                var9 = (int)(Math.atan2((double)var6, (double)var8) * 325.949D) & 2047;
                                                var10 = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                                                if(var9 < 128) {
                                                   var9 = 128;
                                                }

                                                if(var9 > 383) {
                                                   var9 = 383;
                                                }

                                                if(class59.field1222 < var9) {
                                                   class59.field1222 += (var9 - class59.field1222) * class56.field1202 / 1000 + class103.field1779;
                                                   if(class59.field1222 > var9) {
                                                      class59.field1222 = var9;
                                                   }
                                                }

                                                if(class59.field1222 > var9) {
                                                   class59.field1222 -= class103.field1779 + (class59.field1222 - var9) * class56.field1202 / 1000;
                                                   if(class59.field1222 < var9) {
                                                      class59.field1222 = var9;
                                                   }
                                                }

                                                var11 = var10 - class32.field750;
                                                if(var11 > 1024) {
                                                   var11 -= 2048;
                                                }

                                                if(var11 < -1024) {
                                                   var11 += 2048;
                                                }

                                                if(var11 > 0) {
                                                   class32.field750 += class103.field1779 + var11 * class56.field1202 / 1000;
                                                   class32.field750 &= 2047;
                                                }

                                                if(var11 < 0) {
                                                   class32.field750 -= class103.field1779 + -var11 * class56.field1202 / 1000;
                                                   class32.field750 &= 2047;
                                                }

                                                int var12 = var10 - class32.field750;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 < 0 && var11 > 0 || var12 > 0 && var11 < 0) {
                                                   class32.field750 = var10;
                                                }
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++client.field532[var2];
                                             }

                                             class34.field784.method220();
                                             var2 = ++class140.field2157 - 1;
                                             var4 = class82.method1868();
                                             if(var2 > 15000 && var4 > 15000) {
                                                client.field332 = 250;
                                                class52.method1053(14500);
                                                client.field322.method2737(65);
                                             }

                                             ++client.field440;
                                             if(client.field440 > 500) {
                                                client.field440 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   client.field342 += client.field498;
                                                }

                                                if(2 == (var5 & 2)) {
                                                   client.field346 += client.field347;
                                                }

                                                if((var5 & 4) == 4) {
                                                   client.field348 += client.field549;
                                                }
                                             }

                                             if(client.field342 < -50) {
                                                client.field498 = 2;
                                             }

                                             if(client.field342 > 50) {
                                                client.field498 = -2;
                                             }

                                             if(client.field346 < -55) {
                                                client.field347 = 2;
                                             }

                                             if(client.field346 > 55) {
                                                client.field347 = -2;
                                             }

                                             if(client.field348 < -40) {
                                                client.field549 = 1;
                                             }

                                             if(client.field348 > 40) {
                                                client.field549 = -1;
                                             }

                                             ++client.field355;
                                             if(client.field355 > 500) {
                                                client.field355 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if(1 == (var5 & 1)) {
                                                   client.field410 += client.field352;
                                                }

                                                if(2 == (var5 & 2)) {
                                                   client.field353 += client.field300;
                                                }
                                             }

                                             if(client.field410 < -60) {
                                                client.field352 = 2;
                                             }

                                             if(client.field410 > 60) {
                                                client.field352 = -2;
                                             }

                                             if(client.field353 < -20) {
                                                client.field300 = 1;
                                             }

                                             if(client.field353 > 10) {
                                                client.field300 = -1;
                                             }

                                             for(class38 var34 = (class38)client.field316.method3764(); null != var34; var34 = (class38)client.field316.method3765()) {
                                                if((long)var34.field877 < class12.method162() / 1000L - 5L) {
                                                   if(var34.field874 > 0) {
                                                      class125.method2783(5, "", var34.field875 + " has logged in.");
                                                   }

                                                   if(var34.field874 == 0) {
                                                      class125.method2783(5, "", var34.field875 + " has logged out.");
                                                   }

                                                   var34.method3894();
                                                }
                                             }

                                             ++client.field354;
                                             if(client.field354 > 50) {
                                                client.field322.method2737(60);
                                             }

                                             try {
                                                if(class167.field2697 != null && client.field322.field2005 > 0) {
                                                   class167.field2697.method2964(client.field322.field2007, 0, client.field322.field2005);
                                                   client.field322.field2005 = 0;
                                                   client.field354 = 0;
                                                }
                                             } catch (IOException var13) {
                                                class115.method2442();
                                             }

                                             return;
                                          }

                                          var36 = var25.field8;
                                          if(var36.field2766 < 0) {
                                             break;
                                          }

                                          var31 = class29.method645(var36.field2784);
                                       } while(var31 == null || null == var31.field2847 || var36.field2766 >= var31.field2847.length || var31.field2847[var36.field2766] != var36);

                                       class16.method197(var25);
                                    }
                                 }

                                 var36 = var25.field8;
                                 if(var36.field2766 < 0) {
                                    break;
                                 }

                                 var31 = class29.method645(var36.field2784);
                              } while(var31 == null || null == var31.field2847 || var36.field2766 >= var31.field2847.length || var36 != var31.field2847[var36.field2766]);

                              class16.method197(var25);
                           }
                        }

                        var36 = var25.field8;
                        if(var36.field2766 < 0) {
                           break;
                        }

                        var31 = class29.method645(var36.field2784);
                     } while(null == var31 || null == var31.field2847 || var36.field2766 >= var31.field2847.length || var31.field2847[var36.field2766] != var36);

                     class16.method197(var25);
                  }
               }

               client.field322.method2737(83);
               client.field322.method2477(0);
               var16 = client.field322.field2005;
               class130.method2819(client.field322);
               client.field322.method2562(client.field322.field2005 - var16);
            }
         }
      }
   }

   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "910341878"
   )
   protected final synchronized void method3084() {
      Container var1 = this.method2996();
      if(null != class122.field2024) {
         class122.field2024.removeFocusListener(this);
         var1.remove(class122.field2024);
      }

      class15.field214 = Math.max(var1.getWidth(), class98.field1682);
      class15.field215 = Math.max(var1.getHeight(), class136.field2114);
      Insets var2;
      if(null != class85.field1464) {
         var2 = class85.field1464.getInsets();
         class15.field214 -= var2.left + var2.right;
         class15.field215 -= var2.bottom + var2.top;
      }

      class122.field2024 = new class139(this);
      var1.add(class122.field2024);
      class122.field2024.setSize(class15.field214, class15.field215);
      class122.field2024.setVisible(true);
      if(class85.field1464 == var1) {
         var2 = class85.field1464.getInsets();
         class122.field2024.setLocation(var2.left + field2210, var2.top + field2211);
      } else {
         class122.field2024.setLocation(field2210, field2211);
      }

      class122.field2024.addFocusListener(this);
      class122.field2024.requestFocus();
      field2212 = true;
      class77 var3 = class109.method2415(class15.field214, class15.field215, class122.field2024);
      if(null != class135.field2094) {
         class135.field2094.vmethod1857(var3.field1400.getGraphics(), 0, 0);
      }

      class135.field2094 = var3;
      field2214 = false;
      field2216 = class12.method162();
   }

   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1724916487"
   )
   void method3089() {
      Container var1 = this.method2996();
      long var2 = class12.method162();
      long var4 = field2208[class29.field700];
      field2208[class29.field700] = var2;
      class29.field700 = 1 + class29.field700 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2207 = ((var6 >> 1) + 32000) / var6;
      }

      if(++field2213 - 1 > 50) {
         field2213 -= 50;
         field2212 = true;
         class122.field2024.setSize(class15.field214, class15.field215);
         class122.field2024.setVisible(true);
         if(class85.field1464 == var1) {
            Insets var7 = class85.field1464.getInsets();
            class122.field2024.setLocation(field2210 + var7.left, field2211 + var7.top);
         } else {
            class122.field2024.setLocation(field2210, field2211);
         }
      }

      this.vmethod2993();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILclass107;Lclass108;I)Z",
      garbageValue = "882781219"
   )
   public static final boolean method3090(int var0, int var1, int var2, class107 var3, class108 var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class106.field1876[var7][var8] = 99;
      class106.field1888[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class106.field1880[var11] = var0;
      int var20 = var11 + 1;
      class106.field1886[var11] = var1;
      int[][] var13 = var4.field1911;

      while(true) {
         label350:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label327:
                     do {
                        if(var20 == var12) {
                           class175.field2908 = var5;
                           class106.field1875 = var6;
                           return false;
                        }

                        var5 = class106.field1880[var12];
                        var6 = class106.field1886[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.field1907;
                        var15 = var6 - var4.field1908;
                        if(var3.vmethod2368(var2, var5, var6, var4)) {
                           class175.field2908 = var5;
                           class106.field1875 = var6;
                           return true;
                        }

                        var16 = 1 + class106.field1888[var18][var19];
                        if(var18 > 0 && 0 == class106.field1876[var18 - 1][var19] && 0 == (var13[var14 - 1][var15] & 19136782) && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1880[var20] = var5 - 1;
                                 class106.field1886[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class106.field1876[var18 - 1][var19] = 2;
                                 class106.field1888[var18 - 1][var19] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 - 1][var17 + var15] & 19136830)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class106.field1876[var18 + 1][var19] == 0 && (var13[var2 + var14][var15] & 19136899) == 0 && (var13[var2 + var14][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1880[var20] = 1 + var5;
                                 class106.field1886[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1876[var18 + 1][var19] = 8;
                                 class106.field1888[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class106.field1876[var18][var19 - 1] == 0 && 0 == (var13[var14][var15 - 1] & 19136782) && 0 == (var13[var14 + var2 - 1][var15 - 1] & 19136899)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1880[var20] = var5;
                                 class106.field1886[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1876[var18][var19 - 1] = 1;
                                 class106.field1888[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && 0 == class106.field1876[var18][var19 + 1] && 0 == (var13[var14][var15 + var2] & 19136824) && 0 == (var13[var14 + var2 - 1][var2 + var15] & 19136992)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1880[var20] = var5;
                                 class106.field1886[var20] = 1 + var6;
                                 var20 = var20 + 1 & 4095;
                                 class106.field1876[var18][var19 + 1] = 4;
                                 class106.field1888[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var2 + var15] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && 0 == class106.field1876[var18 - 1][var19 - 1] && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1880[var20] = var5 - 1;
                                 class106.field1886[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1876[var18 - 1][var19 - 1] = 3;
                                 class106.field1888[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 - 1][var17 + (var15 - 1)] & 19136830) || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && 0 == class106.field1876[var18 + 1][var19 - 1] && 0 == (var13[var2 + var14][var15 - 1] & 19136899)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1880[var20] = var5 + 1;
                                 class106.field1886[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1876[1 + var18][var19 - 1] = 9;
                                 class106.field1888[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var17 + (var15 - 1)] & 19136995) != 0 || 0 != (var13[var14 + var17][var15 - 1] & 19136911)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class106.field1876[var18 - 1][1 + var19] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if(0 != (var13[var14 - 1][var17 + var15] & 19136830) || 0 != (var13[var14 - 1 + var17][var2 + var15] & 19137016)) {
                                 continue label327;
                              }
                           }

                           class106.field1880[var20] = var5 - 1;
                           class106.field1886[var20] = 1 + var6;
                           var20 = var20 + 1 & 4095;
                           class106.field1876[var18 - 1][var19 + 1] = 6;
                           class106.field1888[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(0 != class106.field1876[1 + var18][var19 + 1]);
            } while((var13[var14 + var2][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var2 + var15] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label350;
               }
            }

            class106.field1880[var20] = var5 + 1;
            class106.field1886[var20] = 1 + var6;
            var20 = 1 + var20 & 4095;
            class106.field1876[var18 + 1][1 + var19] = 12;
            class106.field1888[var18 + 1][var19 + 1] = var16;
         }
      }
   }
}
