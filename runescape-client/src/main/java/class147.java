import java.applet.Applet;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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

@ObfuscatedName("ez")
@Implements("GameEngine")
public abstract class class147 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -222606211
   )
   static int field2252 = 1;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -1729640103
   )
   static int field2253 = 0;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      longValue = 6685478038011975L
   )
   static long field2254 = 0L;
   @ObfuscatedName("pb")
   static boolean field2255 = false;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = -1264618141
   )
   static int field2256 = 20;
   @ObfuscatedName("qj")
   protected static boolean field2257 = false;
   @ObfuscatedName("qf")
   protected static volatile boolean field2258 = false;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -1888027383
   )
   @Export("FPS")
   protected static int field2259 = 0;
   @ObfuscatedName("qi")
   protected static long[] field2260 = new long[32];
   @ObfuscatedName("ql")
   protected static long[] field2261 = new long[32];
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -590387909
   )
   protected static int field2262 = 0;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 1343507395
   )
   protected static int field2263 = 0;
   @ObfuscatedName("qx")
   protected static Font field2264;
   @ObfuscatedName("qm")
   public static volatile boolean field2265 = true;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 1696461621
   )
   static int field2266 = 500;
   @ObfuscatedName("pc")
   boolean field2267;
   @ObfuscatedName("pr")
   static class147 field2268 = null;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      longValue = -9120706505316912183L
   )
   static volatile long field2269 = 0L;
   @ObfuscatedName("rn")
   static volatile boolean field2270 = true;
   @ObfuscatedName("ae")
   static class83[] field2271;

   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-72"
   )
   protected final boolean method3068() {
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
                     this.method3079("invalidhost");
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
         if(class139.field2147 != null) {
            String var1 = class139.field2147.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class139.field2143;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3079("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class30.method665(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var5 = class20.method557(var4, 10, true);
                  if(var5 && class136.method2912(var4) < 10) {
                     this.method3079("wrongjava");
                     return;
                  }
               }

               field2252 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3125();
         this.vmethod3075();

         Object var9;
         try {
            var9 = new class150();
         } catch (Throwable var7) {
            var9 = new class144();
         }

         class43.field1003 = (class136)var9;

         while(field2254 == 0L || class193.method3805() < field2254) {
            class6.field118 = class43.field1003.vmethod3166(field2256, field2252);

            for(int var6 = 0; var6 < class6.field118; ++var6) {
               this.method3069();
            }

            this.method3082();
            class113.method2488(class40.field900, class112.field1965);
         }
      } catch (Exception var8) {
         class54.method1130((String)null, var8);
         this.method3079("crash");
      }

      this.method3115();
   }

   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1310349195"
   )
   void method3069() {
      long var1 = class193.method3805();
      long var3 = field2261[class104.field1824];
      field2261[class104.field1824] = var1;
      class104.field1824 = 1 + class104.field1824 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class125.field2070 = field2270;
      }

      this.vmethod3076();
   }

   public void start() {
      if(this == field2268 && !field2255) {
         field2254 = 0L;
      }
   }

   public void stop() {
      if(this == field2268 && !field2255) {
         field2254 = class193.method3805() + 4000L;
      }
   }

   public void destroy() {
      if(this == field2268 && !field2255) {
         field2254 = class193.method3805();
         class141.method2993(5000L);
         this.method3115();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2268 && !field2255) {
         field2265 = true;
         if(class139.field2143 != null && class139.field2143.startsWith("1.5") && class193.method3805() - field2269 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class12.field174 && var2.height >= class19.field264) {
               field2258 = true;
            }
         }

      }
   }

   public final void focusLost(FocusEvent var1) {
      field2270 = false;
   }

   public final void windowActivated(WindowEvent var1) {
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1323697636"
   )
   protected abstract void vmethod3075();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   protected abstract void vmethod3076();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-257870777"
   )
   protected abstract void vmethod3078();

   @ObfuscatedName("rm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1220299500"
   )
   protected void method3079(String var1) {
      if(!this.field2267) {
         this.field2267 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("rz")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Dimension;",
      garbageValue = "37"
   )
   protected Dimension method3081() {
      Container var1 = this.method3103();
      int var2 = Math.max(var1.getWidth(), class13.field176);
      int var3 = Math.max(var1.getHeight(), class27.field662);
      if(class39.field835 != null) {
         Insets var4 = class39.field835.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "610866329"
   )
   void method3082() {
      Container var1 = this.method3103();
      long var2 = class193.method3805();
      long var4 = field2260[class129.field2094];
      field2260[class129.field2094] = var2;
      class129.field2094 = class129.field2094 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var7 = (int)(var2 - var4);
         field2259 = ((var7 >> 1) + 32000) / var7;
      }

      if(++field2266 - 1 > 50) {
         field2266 -= 50;
         field2265 = true;
         class112.field1965.setSize(class12.field174, class19.field264);
         class112.field1965.setVisible(true);
         if(class39.field835 == var1) {
            Insets var6 = class39.field835.getInsets();
            class112.field1965.setLocation(field2262 + var6.left, field2263 + var6.top);
         } else {
            class112.field1965.setLocation(field2262, field2263);
         }
      }

      this.vmethod3107();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass27;Lclass27;IZB)I",
      garbageValue = "26"
   )
   static int method3089(class27 var0, class27 var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.field652;
         int var5 = var1.field652;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field655 - var1.field655:(var2 == 3?(var0.field645.equals("-")?(var1.field645.equals("-")?0:(var3?-1:1)):(var1.field645.equals("-")?(var3?1:-1):var0.field645.compareTo(var1.field645))):(var2 == 4?(var0.method617()?(var1.method617()?0:1):(var1.method617()?-1:0)):(var2 == 5?(var0.method618()?(var1.method618()?0:1):(var1.method618()?-1:0)):(var2 == 6?(var0.method616()?(var1.method616()?0:1):(var1.method616()?-1:0)):(var2 == 7?(var0.method614()?(var1.method614()?0:1):(var1.method614()?-1:0)):var0.field650 - var1.field650)))));
      }
   }

   @ObfuscatedName("ra")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "67"
   )
   protected Container method3103() {
      return (Container)(class39.field835 != null?class39.field835:this);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "22050"
   )
   protected abstract void vmethod3107();

   @ObfuscatedName("rf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1737007152"
   )
   final synchronized void method3115() {
      if(!field2255) {
         field2255 = true;

         try {
            class112.field1965.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3078();
         } catch (Exception var4) {
            ;
         }

         if(class39.field835 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class40.field900 != null) {
            try {
               class40.field900.method2944();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3137();
      }
   }

   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-557232173"
   )
   protected final synchronized void method3125() {
      Container var1 = this.method3103();
      if(null != class112.field1965) {
         class112.field1965.removeFocusListener(this);
         var1.remove(class112.field1965);
      }

      class12.field174 = Math.max(var1.getWidth(), class13.field176);
      class19.field264 = Math.max(var1.getHeight(), class27.field662);
      Insets var2;
      if(class39.field835 != null) {
         var2 = class39.field835.getInsets();
         class12.field174 -= var2.left + var2.right;
         class19.field264 -= var2.bottom + var2.top;
      }

      class112.field1965 = new class142(this);
      var1.add(class112.field1965);
      class112.field1965.setSize(class12.field174, class19.field264);
      class112.field1965.setVisible(true);
      if(var1 == class39.field835) {
         var2 = class39.field835.getInsets();
         class112.field1965.setLocation(field2262 + var2.left, var2.top + field2263);
      } else {
         class112.field1965.setLocation(field2262, field2263);
      }

      class112.field1965.addFocusListener(this);
      class112.field1965.requestFocus();
      field2265 = true;
      class80 var3 = class49.method1043(class12.field174, class19.field264, class112.field1965);
      if(null != class78.field1454) {
         class78.field1454.vmethod1959(var3.field1470.getGraphics(), 0, 0);
      }

      class78.field1454 = var3;
      field2258 = false;
      field2269 = class193.method3805();
   }

   public abstract void init();

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "945315545"
   )
   protected final void method3131(int var1, int var2, int var3) {
      try {
         if(field2268 != null) {
            ++field2253;
            if(field2253 >= 3) {
               this.method3079("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2268 = this;
         class12.field174 = var1;
         class19.field264 = var2;
         class151.field2286 = var3;
         class151.field2285 = this;
         if(null == class40.field900) {
            class40.field900 = new class139();
         }

         class40.field900.method2937(this, 1);
      } catch (Exception var5) {
         class54.method1130((String)null, var5);
         this.method3079("crash");
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-69"
   )
   protected abstract void vmethod3137();

   public final void focusGained(FocusEvent var1) {
      field2270 = true;
      field2265 = true;
   }
}
