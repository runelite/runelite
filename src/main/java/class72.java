import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bv")
public class class72 implements Runnable {
   @ObfuscatedName("nm")
   static class55 field1353;
   @ObfuscatedName("x")
   volatile class56[] field1354 = new class56[2];
   @ObfuscatedName("t")
   volatile boolean field1355 = false;
   @ObfuscatedName("w")
   class136 field1356;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 133450213
   )
   public static int field1358;
   @ObfuscatedName("d")
   public static String[] field1361;
   @ObfuscatedName("p")
   volatile boolean field1362 = false;

   @ObfuscatedName("x")
   static String method1574(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   public void run() {
      this.field1362 = true;

      try {
         while(!this.field1355) {
            class56 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1354[var1];
               if(var2 != null) {
                  var2.method1234();
               }
            }

            class104.method2291(10L);
            class136 var9 = this.field1356;
            var2 = null;
            if(var9.field2109 != null) {
               for(int var3 = 0; var3 < 50 && var9.field2109.peekEvent() != null; ++var3) {
                  class104.method2291(1L);
               }

               if(null != var2) {
                  var9.field2109.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var7) {
         class0.method0((String)null, var7);
      } finally {
         this.field1362 = false;
      }

   }

   @ObfuscatedName("y")
   static final void method1576(class122 var0) {
      for(int var1 = 0; var1 < class32.field758; ++var1) {
         int var2 = class32.field748[var1];
         class2 var3 = client.field415[var2];
         int var4 = var0.method2506();
         if((var4 & 2) != 0) {
            var4 += var0.method2506() << 8;
         }

         class35.method754(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("da")
   static final class3 method1577(int var0, int var1, int var2) {
      class3 var3 = new class3();
      var3.field74 = var1;
      var3.field79 = var2;
      client.field455.method3807(var3, (long)var0);
      class77.method1671(var1);
      class173 var4 = class52.method1115(var0);
      class134.method2877(var4);
      if(client.field458 != null) {
         class134.method2877(client.field458);
         client.field458 = null;
      }

      class32.method727();
      class34.method746(class173.field2830[var0 >> 16], var4, false);
      class47.method1021(var1);
      if(client.field454 != -1) {
         class39.method797(client.field454, 1);
      }

      return var3;
   }
}
