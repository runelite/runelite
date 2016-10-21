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

@ObfuscatedName("ex")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pr")
   static boolean field2238 = false;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = 2046274251
   )
   static int field2239 = 0;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      longValue = -7153342840268970727L
   )
   static long field2240 = 0L;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 1542049293
   )
   static int field2241 = 20;
   @ObfuscatedName("pi")
   boolean field2242;
   @ObfuscatedName("qe")
   protected static boolean field2243 = false;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 986142509
   )
   static int field2244 = 1;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -1384175295
   )
   protected static int field2245 = 0;
   @ObfuscatedName("qq")
   protected static long[] field2246 = new long[32];
   @ObfuscatedName("qf")
   protected static long[] field2247 = new long[32];
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -360503011
   )
   protected static int field2248 = 0;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -1178948169
   )
   static int field2249 = 500;
   @ObfuscatedName("qj")
   public static volatile boolean field2250 = true;
   @ObfuscatedName("pw")
   static GameEngine field2251 = null;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 1896818195
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("qa")
   protected static volatile boolean field2253 = false;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      longValue = 5818752439180633651L
   )
   static volatile long field2254 = 0L;
   @ObfuscatedName("rp")
   static volatile boolean field2255 = true;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -1546346161
   )
   static int field2256;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "76"
   )
   protected abstract void vmethod3031();

   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "17"
   )
   protected final void method3032(int var1, int var2, int var3) {
      try {
         if(null != field2251) {
            ++field2239;
            if(field2239 >= 3) {
               this.method3046("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2251 = this;
         class153.field2296 = var1;
         class93.field1616 = var2;
         class151.field2269 = var3;
         class151.field2268 = this;
         if(class54.field1146 == null) {
            class54.field1146 = new class139();
         }

         class54.field1146.method2910(this, 1);
      } catch (Exception var5) {
         Frames.method2316((String)null, var5);
         this.method3046("crash");
      }

   }

   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1408607806"
   )
   protected final synchronized void method3033() {
      Container var1 = this.method3047();
      if(GameObject.canvas != null) {
         GameObject.canvas.removeFocusListener(this);
         var1.remove(GameObject.canvas);
      }

      class153.field2296 = Math.max(var1.getWidth(), Projectile.field125);
      class93.field1616 = Math.max(var1.getHeight(), class116.field2022);
      Insets var2;
      if(null != CollisionData.field1956) {
         var2 = CollisionData.field1956.getInsets();
         class153.field2296 -= var2.left + var2.right;
         class93.field1616 -= var2.top + var2.bottom;
      }

      GameObject.canvas = new RSCanvas(this);
      var1.add(GameObject.canvas);
      GameObject.canvas.setSize(class153.field2296, class93.field1616);
      GameObject.canvas.setVisible(true);
      if(CollisionData.field1956 == var1) {
         var2 = CollisionData.field1956.getInsets();
         GameObject.canvas.setLocation(var2.left + field2248, field2245 + var2.top);
      } else {
         GameObject.canvas.setLocation(field2248, field2245);
      }

      GameObject.canvas.addFocusListener(this);
      GameObject.canvas.requestFocus();
      field2250 = true;
      int var3 = class153.field2296;
      int var4 = class93.field1616;
      Canvas var5 = GameObject.canvas;

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

      if(null != XClanMember.bufferProvider) {
         XClanMember.bufferProvider.draw(((BufferProvider)var9).image.getGraphics(), 0, 0);
      }

      XClanMember.bufferProvider = (BufferProvider)var9;
      field2253 = false;
      field2254 = class11.method139();
   }

   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2126884098"
   )
   protected final boolean method3034() {
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
                     this.method3046("invalidhost");
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

   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-6863"
   )
   void method3037() {
      Container var1 = this.method3047();
      long var2 = class11.method139();
      long var4 = field2246[Item.field687];
      field2246[Item.field687] = var2;
      Item.field687 = Item.field687 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var7 = (int)(var2 - var4);
         FPS = (32000 + (var7 >> 1)) / var7;
      }

      if(++field2249 - 1 > 50) {
         field2249 -= 50;
         field2250 = true;
         GameObject.canvas.setSize(class153.field2296, class93.field1616);
         GameObject.canvas.setVisible(true);
         if(CollisionData.field1956 == var1) {
            Insets var6 = CollisionData.field1956.getInsets();
            GameObject.canvas.setLocation(field2248 + var6.left, field2245 + var6.top);
         } else {
            GameObject.canvas.setLocation(field2248, field2245);
         }
      }

      this.vmethod3099();
   }

   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-505607791"
   )
   final synchronized void method3038() {
      if(!field2238) {
         field2238 = true;

         try {
            GameObject.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3045();
         } catch (Exception var4) {
            ;
         }

         if(CollisionData.field1956 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class54.field1146 != null) {
            try {
               class54.field1146.method2906();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3049();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(field2251 == this && !field2238) {
         field2250 = true;
         if(class139.field2140 != null && class139.field2140.startsWith("1.5") && class11.method139() - field2254 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class153.field2296 && var2.height >= class93.field1616) {
               field2253 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field2255 = true;
      field2250 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2255 = false;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-41"
   )
   protected abstract void packetHandler();

   public void start() {
      if(field2251 == this && !field2238) {
         field2240 = 0L;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1378080876"
   )
   protected abstract void vmethod3045();

   @ObfuscatedName("rl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2134692080"
   )
   protected void method3046(String var1) {
      if(!this.field2242) {
         this.field2242 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("rp")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "2012736629"
   )
   protected Container method3047() {
      return (Container)(null != CollisionData.field1956?CollisionData.field1956:this);
   }

   @ObfuscatedName("ra")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "-2127575172"
   )
   protected Dimension method3048() {
      Container var1 = this.method3047();
      int var2 = Math.max(var1.getWidth(), Projectile.field125);
      int var3 = Math.max(var1.getHeight(), class116.field2022);
      if(CollisionData.field1956 != null) {
         Insets var4 = CollisionData.field1956.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1000163604"
   )
   protected abstract void vmethod3049();

   public final void windowActivated(WindowEvent var1) {
   }

   public void destroy() {
      if(field2251 == this && !field2238) {
         field2240 = class11.method139();
         class110.method2407(5000L);
         this.method3038();
      }
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "-791807433"
   )
   public static class45 method3084(int var0) {
      class45 var1 = (class45)class45.field1029.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field1016.method3304(13, var0);
         var1 = new class45();
         var1.field1017 = var0;
         if(null != var2) {
            var1.method924(new Buffer(var2));
         }

         class45.field1029.put(var1, (long)var0);
         return var1;
      }
   }

   public void run() {
      try {
         int var3;
         if(null != class139.field2146) {
            String var1 = class139.field2146.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class139.field2140;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3046("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  for(var3 = 6; var3 < var2.length() && class167.method3259(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class16.method185(var4)) {
                     int var5 = class93.method2129(var4, 10, true);
                     if(var5 < 10) {
                        this.method3046("wrongjava");
                        return;
                     }
                  }
               }

               field2244 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3033();
         this.vmethod3031();
         class54.field1148 = class40.method790();

         label77:
         while(true) {
            class139 var8;
            Canvas var9;
            do {
               if(0L != field2240 && class11.method139() >= field2240) {
                  break label77;
               }

               Tile.field1807 = class54.field1148.vmethod3142(field2241, field2244);

               for(int var6 = 0; var6 < Tile.field1807; ++var6) {
                  this.method3126();
               }

               this.method3037();
               var8 = class54.field1146;
               var9 = GameObject.canvas;
            } while(null == var8.field2141);

            for(var3 = 0; var3 < 50 && var8.field2141.peekEvent() != null; ++var3) {
               class110.method2407(1L);
            }

            if(var9 != null) {
               var8.field2141.postEvent(new ActionEvent(var9, 1001, "dummy"));
            }
         }
      } catch (Exception var7) {
         Frames.method2316((String)null, var7);
         this.method3046("crash");
      }

      this.method3038();
   }

   public void stop() {
      if(field2251 == this && !field2238) {
         field2240 = class11.method139() + 4000L;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1927887775"
   )
   protected abstract void vmethod3099();

   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1454970298"
   )
   void method3126() {
      long var1 = class11.method139();
      long var3 = field2247[class174.field2771];
      field2247[class174.field2771] = var1;
      class174.field2771 = 1 + class174.field2771 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         World.field665 = field2255;
      }

      this.packetHandler();
   }
}
