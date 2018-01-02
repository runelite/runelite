import net.runelite.mapping.*;

import java.applet.Applet;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.net.URL;

@ObfuscatedName("be")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("nh")
   @ObfuscatedSignature(
      signature = "[Lbu;"
   )
   @Export("clanMembers")
   @Hook("clanMembersChanged")
   static ClanMember[] clanMembers;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lbe;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -673297861
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -1677517307063427709L
   )
   static long field654;
   @ObfuscatedName("z")
   static boolean field649;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 676579953
   )
   static int field640;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -978847015
   )
   static int field636;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1092574815
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("o")
   protected static long[] field633;
   @ObfuscatedName("i")
   protected static long[] field662;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 543143111
   )
   static int field652;
   @ObfuscatedName("ay")
   protected static String field656;
   @ObfuscatedName("av")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = 7654158968335052561L
   )
   @Export("garbageCollectorLastCollectionTime")
   static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      longValue = -1390540160102048077L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("t")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1436933147
   )
   protected int field648;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1808357613
   )
   protected int field642;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 547435641
   )
   int field643;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1667296909
   )
   int field646;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1087092705
   )
   int field645;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 2128705989
   )
   int field634;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -42615535
   )
   int field647;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1760149929
   )
   int field644;
   @ObfuscatedName("aq")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("ax")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("at")
   volatile boolean field651;
   @ObfuscatedName("ac")
   boolean field653;
   @ObfuscatedName("aw")
   volatile boolean field663;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = -8357752157919559945L
   )
   volatile long field655;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ah")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("az")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field654 = 0L;
      field649 = false;
      field640 = 20;
      field636 = 1;
      FPS = 0;
      field633 = new long[32];
      field662 = new long[32];
      field652 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field643 = 0;
      this.field646 = 0;
      this.field651 = true;
      this.field653 = false;
      this.field663 = false;
      this.field655 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      ChatLineBuffer.method1858(new SoundTaskDataProvider());
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "229703779"
   )
   protected final void method809(int var1, int var2) {
      if(this.field647 != var1 || var2 != this.field644) {
         this.method825();
      }

      this.field647 = var1;
      this.field644 = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;B)V",
      garbageValue = "92"
   )
   final void method808(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            World.method1500(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Lfe;",
      garbageValue = "124"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1362299099"
   )
   protected void method884(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2042047067"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.KeyHandler_keyCodes[186] = 57;
         KeyFocusListener.KeyHandler_keyCodes[187] = 27;
         KeyFocusListener.KeyHandler_keyCodes[188] = 71;
         KeyFocusListener.KeyHandler_keyCodes[189] = 26;
         KeyFocusListener.KeyHandler_keyCodes[190] = 72;
         KeyFocusListener.KeyHandler_keyCodes[191] = 73;
         KeyFocusListener.KeyHandler_keyCodes[192] = 58;
         KeyFocusListener.KeyHandler_keyCodes[219] = 42;
         KeyFocusListener.KeyHandler_keyCodes[220] = 74;
         KeyFocusListener.KeyHandler_keyCodes[221] = 43;
         KeyFocusListener.KeyHandler_keyCodes[222] = 59;
         KeyFocusListener.KeyHandler_keyCodes[223] = 28;
      } else {
         KeyFocusListener.KeyHandler_keyCodes[44] = 71;
         KeyFocusListener.KeyHandler_keyCodes[45] = 26;
         KeyFocusListener.KeyHandler_keyCodes[46] = 72;
         KeyFocusListener.KeyHandler_keyCodes[47] = 73;
         KeyFocusListener.KeyHandler_keyCodes[59] = 57;
         KeyFocusListener.KeyHandler_keyCodes[61] = 27;
         KeyFocusListener.KeyHandler_keyCodes[91] = 42;
         KeyFocusListener.KeyHandler_keyCodes[92] = 74;
         KeyFocusListener.KeyHandler_keyCodes[93] = 43;
         KeyFocusListener.KeyHandler_keyCodes[192] = 28;
         KeyFocusListener.KeyHandler_keyCodes[222] = 58;
         KeyFocusListener.KeyHandler_keyCodes[520] = 59;
      }

      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      class27.method213(this.canvas);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1880271323"
   )
   final void method814() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method839();
         this.field648 = Math.max(var2.field3813, this.field645);
         this.field642 = Math.max(var2.field3812, this.field634);
         if(this.field648 <= 0) {
            this.field648 = 1;
         }

         if(this.field642 <= 0) {
            this.field642 = 1;
         }

         Huffman.canvasWidth = Math.min(this.field648, this.field647);
         VertexNormal.canvasHeight = Math.min(this.field642, this.field644);
         this.field643 = (this.field648 - Huffman.canvasWidth) / 2;
         this.field646 = 0;
         this.canvas.setSize(Huffman.canvasWidth, VertexNormal.canvasHeight);
         ScriptState.rasterProvider = new MainBufferProvider(Huffman.canvasWidth, VertexNormal.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(this.field643 + var3.left, var3.top + this.field646);
         } else {
            this.canvas.setLocation(this.field643, this.field646);
         }

         this.field651 = true;
         this.vmethod1131();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-531735453"
   )
   protected abstract void vmethod1131();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1124015557"
   )
   void method851() {
      int var1 = this.field643;
      int var2 = this.field646;
      int var3 = this.field648 - Huffman.canvasWidth - var1;
      int var4 = this.field642 - VertexNormal.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.frame) {
               Insets var8 = this.frame.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field642);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field648, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field648 - var3, var7, var3, this.field642);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field642 - var4, this.field648, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   final void method806() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field597 = -1;
      WorldMapType1.method245(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      class27.method213(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method825();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "114"
   )
   @Export("initialize")
   protected final void initialize(int var1, int var2, int var3) {
      try {
         if(shell != null) {
            ++shellCount;
            if(shellCount >= 3) {
               this.error("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         shell = this;
         Huffman.canvasWidth = var1;
         VertexNormal.canvasHeight = var2;
         class37.revision = var3;
         RunException.field2114 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         PendingSpawn.method1461((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1462728631"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      Huffman.canvasWidth = Math.max(var1.getWidth(), this.field645);
      VertexNormal.canvasHeight = Math.max(var1.getHeight(), this.field634);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         Huffman.canvasWidth -= var2.right + var2.left;
         VertexNormal.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(Huffman.canvasWidth, VertexNormal.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(var2.left + this.field643, this.field646 + var2.top);
      } else {
         this.canvas.setLocation(this.field643, this.field646);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field651 = true;
      if(ScriptState.rasterProvider != null && Huffman.canvasWidth == ScriptState.rasterProvider.width && VertexNormal.canvasHeight == ScriptState.rasterProvider.height) {
         ((MainBufferProvider)ScriptState.rasterProvider).replaceComponent(this.canvas);
         ScriptState.rasterProvider.drawFull(0, 0);
      } else {
         ScriptState.rasterProvider = new MainBufferProvider(Huffman.canvasWidth, VertexNormal.canvasHeight, this.canvas);
      }

      this.field663 = false;
      this.field655 = Preferences.currentTimeMs();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1972956818"
   )
   @Export("isValidHost")
   protected final boolean isValidHost() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(var1.endsWith("127.0.0.1")) {
               return true;
            } else {
               while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
                  var1 = var1.substring(0, var1.length() - 1);
               }

               if(var1.endsWith("192.168.1.")) {
                  return true;
               } else {
                  this.error("invalidhost");
                  return false;
               }
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1495810888"
   )
   void method822() {
      long var1 = Preferences.currentTimeMs();
      long var3 = field662[class33.field438];
      field662[class33.field438] = var1;
      class33.field438 = class33.field438 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class238.field3251 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "578551261"
   )
   void method823() {
      Container var1 = this.container();
      long var2 = Preferences.currentTimeMs();
      long var4 = field633[class188.field2540];
      field633[class188.field2540] = var2;
      class188.field2540 = class188.field2540 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field652 - 1 > 50) {
         field652 -= 50;
         this.field651 = true;
         this.canvas.setSize(Huffman.canvasWidth, VertexNormal.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(this.field643 + var7.left, var7.top + this.field646);
         } else {
            this.canvas.setLocation(this.field643, this.field646);
         }
      }

      if(this.field663) {
         this.method806();
      }

      this.method897();
      this.methodDraw(this.field651);
      if(this.field651) {
         this.method851();
      }

      this.field651 = false;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-735809929"
   )
   final void method897() {
      Bounds var1 = this.method839();
      if(var1.field3813 != this.field648 || var1.field3812 != this.field642 || this.field653) {
         this.method814();
         this.field653 = false;
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "628276959"
   )
   final void method825() {
      this.field653 = true;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1956695990"
   )
   final synchronized void method826() {
      if(!field649) {
         field649 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1125();
         } catch (Exception var4) {
            ;
         }

         if(this.frame != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(taskManager != null) {
            try {
               taskManager.join();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1278();
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-990310815"
   )
   protected abstract void setUp();

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "972327216"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-910850089"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   protected abstract void vmethod1125();

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "7"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class279.field3737 == null) {
            class279.field3737 = new java.awt.Font("Helvetica", 1, 13);
            NamedRecord.field515 = this.canvas.getFontMetrics(class279.field3737);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, Huffman.canvasWidth, VertexNormal.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class34.field461 == null) {
               class34.field461 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class34.field461.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class279.field3737);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - NamedRecord.field515.stringWidth(var2)) / 2, 22);
            var4.drawImage(class34.field461, Huffman.canvasWidth / 2 - 152, VertexNormal.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = Huffman.canvasWidth / 2 - 152;
            int var8 = VertexNormal.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class279.field3737);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - NamedRecord.field515.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-856646586"
   )
   protected final void method836() {
      class34.field461 = null;
      class279.field3737 = null;
      NamedRecord.field515 = null;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.hasErrored) {
         this.hasErrored = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "33"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)Lkr;",
      garbageValue = "-77"
   )
   Bounds method839() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field645);
      int var3 = Math.max(var1.getHeight(), this.field634);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1554237123"
   )
   protected final boolean method840() {
      return this.frame != null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2033473326"
   )
   protected abstract void vmethod1278();

   public final void destroy() {
      if(this == shell && !field649) {
         field654 = Preferences.currentTimeMs();
         World.method1500(5000L);
         this.method826();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field649) {
         this.field651 = true;
         if(Preferences.currentTimeMs() - this.field655 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= Huffman.canvasWidth && var2.height >= VertexNormal.canvasHeight) {
               this.field663 = true;
            }
         }

      }
   }

   public final void start() {
      if(this == shell && !field649) {
         field654 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field649) {
         field654 = Preferences.currentTimeMs() + 4000L;
      }
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field651 = true;
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public void run() {
      try {
         if(Signlink.javaVendor != null) {
            String var1 = Signlink.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = Signlink.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length(); ++var3) {
                     char var5 = var2.charAt(var3);
                     boolean var4 = var5 >= '0' && var5 <= '9';
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

                     label184: {
                        char var12 = var14.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == '-') {
                              var7 = true;
                              break label184;
                           }

                           if(var12 == '+') {
                              break label184;
                           }
                        }

                        int var19;
                        if(var12 >= '0' && var12 <= '9') {
                           var19 = var12 - '0';
                        } else if(var12 >= 'A' && var12 <= 'Z') {
                           var19 = var12 - '7';
                        } else {
                           if(var12 < 'a' || var12 > 'z') {
                              var6 = false;
                              break;
                           }

                           var19 = var12 - 'W';
                        }

                        if(var19 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var19 = -var19;
                        }

                        int var13 = var9 * 10 + var19;
                        if(var9 != var13 / 10) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6 && class228.method4195(var14) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               field636 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();

         Object var18;
         try {
            var18 = new NanoTimer();
         } catch (Throwable var16) {
            var18 = new MilliTimer();
         }

         LoginPacket.timer = (Timer)var18;

         while(field654 == 0L || Preferences.currentTimeMs() < field654) {
            class225.field2739 = LoginPacket.timer.vmethod3075(field640, field636);

            for(int var15 = 0; var15 < class225.field2739; ++var15) {
               this.method822();
            }

            this.method823();
            this.method808(this.canvas);
         }
      } catch (Exception var17) {
         PendingSpawn.method1461((String)null, var17);
         this.error("crash");
      }

      this.method826();
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-824884122"
   )
   @Export("prependIndices")
   static final String[] prependIndices(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1945275127"
   )
   static final void method857(String var0) {
      if(var0 != null) {
         String var1 = SpritePixels2.cleanUsername(var0, PendingSpawn.jagexLoginType);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = SpritePixels2.cleanUsername(var4, PendingSpawn.jagexLoginType);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.friendCount;

                  for(int var7 = var2; var7 < Client.friendCount; ++var7) {
                     Client.friends[var7] = Client.friends[var7 + 1];
                  }

                  Client.field1041 = Client.cycleCntr;
                  PacketNode var8 = FileSystem.bufferForSize(ClientPacket.field2354, Client.signlink.field1449);
                  var8.packetBuffer.putByte(Ignore.getLength(var0));
                  var8.packetBuffer.putString(var0);
                  Client.signlink.method1862(var8);
                  break;
               }
            }

         }
      }
   }
}
