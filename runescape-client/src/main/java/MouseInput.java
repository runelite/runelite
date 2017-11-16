import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lbe;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -172309373
   )
   public static int field676;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -538094973
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1746484201
   )
   public static volatile int field677;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -651917053
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1857751209
   )
   public static int field681;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1053997561
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 912044335
   )
   public static int field689;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1874559127
   )
   public static volatile int field683;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1218179683
   )
   public static volatile int field684;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -832561995
   )
   public static volatile int field691;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 205847998346770525L
   )
   public static volatile long field686;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 117384827
   )
   public static int field687;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1187101085
   )
   public static int field674;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1577756865
   )
   public static int field688;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 3127154179926897597L
   )
   public static long field690;
   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field677 = 0;
      mouseX = -1;
      mouseY = -1;
      field689 = 0;
      field681 = 0;
      field676 = 0;
      field683 = 0;
      field684 = 0;
      field691 = 0;
      field686 = 0L;
      field687 = 0;
      field674 = 0;
      field688 = 0;
      field690 = 0L;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "-948348820"
   )
   final int method938(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field677 = 0;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field677 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field684 = var1.getX();
         field691 = var1.getY();
         field686 = ChatLineBuffer.currentTimeMs();
         field683 = this.method938(var1);
         if(field683 != 0) {
            field677 = field683;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1074633856"
   )
   public static int method963(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-11"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(SoundTask.listFetcher == null) {
            SoundTask.listFetcher = InvType.field3331.method2899(new URL(PendingSpawn.field1139));
         } else if(SoundTask.listFetcher.method2916()) {
            byte[] var0 = SoundTask.listFetcher.method2919();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            class54.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = class54.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            class72.method1060(class54.worldList, 0, class54.worldList.length - 1, World.field1211, World.field1217);
            SoundTask.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         SoundTask.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "2064824425"
   )
   public static void method937(Huffman var0) {
      class272.field3707 = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "169865582"
   )
   public static int method939(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }
}
