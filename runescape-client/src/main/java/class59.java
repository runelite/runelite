import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class59 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -331057379
   )
   @Export("mouseX")
   static volatile int mouseX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 684343621
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1467005745
   )
   static volatile int field712;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 146825275
   )
   public static int field713;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -640134069
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1859968881
   )
   public static int field715;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1352309063
   )
   public static int field716;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1237911771
   )
   static volatile int field717;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1468825625
   )
   static volatile int field718;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1962248423
   )
   static volatile int field720;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -1338499936449539719L
   )
   static volatile long field721;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 703349467
   )
   public static int field723;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -653098593
   )
   public static int field724;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -2695468476728371925L
   )
   public static long field725;
   @ObfuscatedName("n")
   @Export("mouse")
   public static class59 mouse;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 680487917
   )
   public static int field729;

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1825178703"
   )
   static final void method969(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class33.field476 || var1 != class95.field1491) {
         class33.field476 = var0;
         class95.field1491 = var1;
         class3.setGameState(25);
         class157.method2976("Loading - please wait.", true);
         int var3 = class61.baseX;
         int var4 = class23.baseY;
         class61.baseX = (var0 - 6) * 8;
         class23.baseY = (var1 - 6) * 8;
         int var5 = class61.baseX - var3;
         int var6 = class23.baseY - var4;
         var3 = class61.baseX;
         var4 = class23.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < '耀'; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var19 = var20; var18 != var19; var19 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var5 + var19;
               int var16 = var14 + var6;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var19][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var19][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var13 = (PendingSpawn)Client.pendingSpawns.method3622(); var13 != null; var13 = (PendingSpawn)Client.pendingSpawns.method3608()) {
            var13.x -= var5;
            var13.y -= var6;
            if(var13.x < 0 || var13.y < 0 || var13.x >= 104 || var13.y >= 104) {
               var13.unlink();
            }
         }

         if(Client.detinationX != 0) {
            Client.detinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field1077 = 0;
         Client.field987 = false;
         Client.field1144 = -1;
         Client.field1048.method3601();
         Client.projectiles.method3601();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].method3016();
         }

      }
   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field712 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field717 = var1.getX();
         field720 = var1.getY();
         field721 = class134.method2587();
         if(var1.isAltDown()) {
            field718 = 4;
            field712 = 4;
         } else if(var1.isMetaDown()) {
            field718 = 2;
            field712 = 2;
         } else {
            field718 = 1;
            field712 = 1;
         }
      }

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

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

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

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field712 = 0;
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   static {
      mouse = new class59();
      mouseIdleTicks = 0;
      field712 = 0;
      mouseX = -1;
      mouseY = -1;
      field716 = 0;
      field729 = 0;
      field715 = 0;
      field718 = 0;
      field717 = 0;
      field720 = 0;
      field721 = 0L;
      field713 = 0;
      field723 = 0;
      field724 = 0;
      field725 = 0L;
   }
}
