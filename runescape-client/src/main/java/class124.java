import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class124 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2120066781
   )
   static int field2065 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1806385655
   )
   static int field2066 = 0;
   @ObfuscatedName("h")
   static byte[][] field2067 = new byte[1000][];
   @ObfuscatedName("a")
   static byte[][] field2068 = new byte[50][];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -955130687
   )
   static int field2069 = 0;
   @ObfuscatedName("r")
   static byte[][] field2071 = new byte[250][];

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1992805775"
   )
   static final void method2847() {
      for(int var0 = 0; var0 < client.field535; ++var0) {
         --client.field449[var0];
         if(client.field449[var0] >= -10) {
            class61 var9 = client.field494[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = class61.method1356(class17.field254, client.field370[var0], 0);
               if(null == var9) {
                  continue;
               }

               client.field449[var0] += var9.method1343();
               client.field494[var0] = var9;
            }

            if(client.field449[var0] < 0) {
               int var2;
               if(client.field291[var0] != 0) {
                  int var3 = 128 * (client.field291[var0] & 255);
                  int var4 = client.field291[var0] >> 16 & 255;
                  int var5 = 64 + 128 * var4 - class118.field2035.field896;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = client.field291[var0] >> 8 & 255;
                  int var7 = 64 + 128 * var6 - class118.field2035.field879;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     client.field449[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * client.field536 / var3;
               } else {
                  var2 = client.field376;
               }

               if(var2 > 0) {
                  class65 var10 = var9.method1342().method1381(class7.field135);
                  class67 var11 = class67.method1440(var10, 100, var2);
                  var11.method1411(client.field539[var0] - 1);
                  class31.field742.method1241(var11);
               }

               client.field449[var0] = -100;
            }
         } else {
            --client.field535;

            for(int var1 = var0; var1 < client.field535; ++var1) {
               client.field370[var1] = client.field370[var1 + 1];
               client.field494[var1] = client.field494[var1 + 1];
               client.field539[var1] = client.field539[var1 + 1];
               client.field449[var1] = client.field449[1 + var1];
               client.field291[var1] = client.field291[1 + var1];
            }

            --var0;
         }
      }

      if(client.field411 && !class122.method2686()) {
         if(client.field354 != 0 && client.field533 != -1) {
            class127.method2904(class109.field1948, client.field533, 0, client.field354, false);
         }

         client.field411 = false;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1032669641"
   )
   static synchronized byte[] method2848(int var0) {
      byte[] var1;
      if(var0 == 100 && field2069 > 0) {
         var1 = field2067[--field2069];
         field2067[field2069] = null;
         return var1;
      } else if(var0 == 5000 && field2065 > 0) {
         var1 = field2071[--field2065];
         field2071[field2065] = null;
         return var1;
      } else if(var0 == 30000 && field2066 > 0) {
         var1 = field2068[--field2066];
         field2068[field2066] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("rd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   protected static final void method2851() {
      class54.field1171 = null;
      class146.field2236 = null;
      class26.field662 = null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Ljava/lang/String;Ljava/lang/String;I)Lclass227;",
      garbageValue = "771415960"
   )
   public static class227 method2852(class170 var0, class170 var1, String var2, String var3) {
      int var4 = var0.method3342(var2);
      int var5 = var0.method3357(var4, var3);
      return class116.method2519(var0, var1, var4, var5);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-1962251148"
   )
   public static void method2853(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class141.field2181.startsWith("win")) {
            class170.method3424(var0, 0);
            return;
         }

         if(class141.field2181.startsWith("mac")) {
            class111.method2482(var0, 1, var2);
            return;
         }

         class170.method3424(var0, 2);
      } else {
         class170.method3424(var0, 3);
      }

   }
}
