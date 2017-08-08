import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public class class237 implements Runnable {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   public static Deque field3215;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   public static Deque field3214;
   @ObfuscatedName("y")
   public static Object field3217;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1036809397
   )
   public static int field3216;
   @ObfuscatedName("w")
   static Thread field3219;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -514096071
   )
   static int field3218;

   static {
      field3215 = new Deque();
      field3214 = new Deque();
      field3216 = 0;
      field3217 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3215;
            FileSystem var1;
            synchronized(field3215) {
               var1 = (FileSystem)field3215.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3189 == 0) {
                  var1.index.method3045((int)var1.hash, var1.field3185, var1.field3185.length);
                  var2 = field3215;
                  synchronized(field3215) {
                     var1.unlink();
                  }
               } else if(var1.field3189 == 1) {
                  var1.field3185 = var1.index.method3046((int)var1.hash);
                  var2 = field3215;
                  synchronized(field3215) {
                     field3214.addFront(var1);
                  }
               }

               var14 = field3217;
               synchronized(field3217) {
                  if(field3216 <= 1) {
                     field3216 = 0;
                     field3217.notifyAll();
                     return;
                  }

                  field3216 = 600;
               }
            } else {
               class41.method585(100L);
               var14 = field3217;
               synchronized(field3217) {
                  if(field3216 <= 1) {
                     field3216 = 0;
                     field3217.notifyAll();
                     return;
                  }

                  --field3216;
               }
            }
         }
      } catch (Exception var13) {
         NPC.method1722((String)null, var13);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "906748837"
   )
   static void method4205(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.field729 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "920289176"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = class54.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field901 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class25.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - ScriptEvent.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class29.plane = var2.field900 = var4;
      if(class97.field1492[var1] != null) {
         var2.decodeApperance(class97.field1492[var1]);
      }

      class97.field1493 = 0;
      class97.field1494[++class97.field1493 - 1] = var1;
      class97.field1490[var1] = 0;
      class97.field1495 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class97.field1497[var7] = (var10 << 14) + var11 + (var9 << 28);
            class97.field1496[var7] = 0;
            class97.field1499[var7] = -1;
            class97.field1498[++class97.field1495 - 1] = var7;
            class97.field1490[var7] = 0;
         }
      }

      var0.byteAccess();
   }
}
