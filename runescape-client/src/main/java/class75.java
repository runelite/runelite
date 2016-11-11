import java.awt.Component;
import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class75 implements Runnable {
   @ObfuscatedName("ey")
   static SpritePixels[] field1401;
   @ObfuscatedName("e")
   volatile boolean field1403 = false;
   @ObfuscatedName("g")
   volatile boolean field1404 = false;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1672084919
   )
   static int field1408;
   @ObfuscatedName("h")
   volatile class59[] field1409 = new class59[2];
   @ObfuscatedName("i")
   class139 field1410;

   public void run() {
      this.field1404 = true;

      try {
         while(!this.field1403) {
            class59 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1409[var1];
               if(null != var2) {
                  var2.method1239();
               }
            }

            PlayerComposition.method3511(10L);
            class139 var5 = this.field1410;
            var2 = null;
            if(var5.field2148 != null) {
               for(int var3 = 0; var3 < 50 && var5.field2148.peekEvent() != null; ++var3) {
                  PlayerComposition.method3511(1L);
               }

               if(var2 != null) {
                  var5.field2148.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         class93.method2139((String)null, var8);
      } finally {
         this.field1404 = false;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lclass54;",
      garbageValue = "1919907600"
   )
   public static class54 method1609(int var0) {
      class54 var1 = (class54)class54.field1155.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class54.field1159.method3292(5, var0);
         var1 = new class54();
         if(null != var2) {
            var1.method1098(new Buffer(var2));
         }

         class54.field1155.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "656467257"
   )
   static void method1610() {
      Client.field378.method2801(215);
      class125 var0 = Client.field378;
      int var1 = Client.isResized?2:1;
      var0.method2529(var1);
      Client.field378.method2701(class62.field1267);
      Client.field378.method2701(class77.field1428);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-61"
   )
   public static void method1612(Component var0) {
      var0.addMouseListener(class143.mouse);
      var0.addMouseMotionListener(class143.mouse);
      var0.addFocusListener(class143.mouse);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-24312201"
   )
   public static int method1613(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2044[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
