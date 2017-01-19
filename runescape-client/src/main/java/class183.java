import java.awt.Component;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class183 implements Runnable {
   @ObfuscatedName("u")
   static class179 field2729;
   @ObfuscatedName("c")
   static Deque field2730 = new Deque();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -866520163
   )
   public static int field2731 = 0;
   @ObfuscatedName("h")
   public static Object field2732 = new Object();
   @ObfuscatedName("s")
   static Deque field2733 = new Deque();
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -775225907
   )
   static int field2735;

   public void run() {
      try {
         while(true) {
            Deque var2 = field2733;
            class180 var1;
            synchronized(field2733) {
               var1 = (class180)field2733.method2330();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2704 == 0) {
                  var1.field2702.method2172((int)var1.hash, var1.field2701, var1.field2701.length);
                  var2 = field2733;
                  synchronized(field2733) {
                     var1.unlink();
                  }
               } else if(var1.field2704 == 1) {
                  var1.field2701 = var1.field2702.method2171((int)var1.hash);
                  var2 = field2733;
                  synchronized(field2733) {
                     field2730.method2333(var1);
                  }
               }

               var14 = field2732;
               synchronized(field2732) {
                  if(field2731 <= 1) {
                     field2731 = 0;
                     field2732.notifyAll();
                     return;
                  }

                  field2731 = 600;
               }
            } else {
               Projectile.method757(100L);
               var14 = field2732;
               synchronized(field2732) {
                  if(field2731 <= 1) {
                     field2731 = 0;
                     field2732.notifyAll();
                     return;
                  }

                  --field2731;
               }
            }
         }
      } catch (Exception var13) {
         NPC.method695((String)null, var13);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1771907553"
   )
   public static void method3266(boolean var0) {
      if(class185.field2755 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2708(var0?2:3);
            var1.method2710(0);
            class185.field2755.method2015(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2755.method2006();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2756;
            class185.field2755 = null;
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "-229"
   )
   public static void method3267(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-968865046"
   )
   public static boolean method3268(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
