import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class106 {
   @ObfuscatedName("g")
   static int[][] field1873 = new int[128][128];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1083348849
   )
   static int field1875;
   @ObfuscatedName("d")
   static int[] field1876 = new int[4096];
   @ObfuscatedName("h")
   static int[][] field1877 = new int[128][128];
   @ObfuscatedName("bw")
   static class168 field1878;
   @ObfuscatedName("kn")
   @Export("chatMessages")
   static class19 field1879;
   @ObfuscatedName("s")
   static int[] field1881 = new int[4096];

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1013174962"
   )
   public static boolean method2335(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-729424280"
   )
   public static void method2342(Component var0) {
      var0.addMouseListener(class140.field2186);
      var0.addMouseMotionListener(class140.field2186);
      var0.addFocusListener(class140.field2186);
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1621073986"
   )
   static void method2343() {
      if(client.field437) {
         class173 var0 = class74.method1561(class27.field669, client.field342);
         if(null != var0 && null != var0.field2825) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field5 = var0.field2825;
            class171.method3363(var1);
         }

         client.field437 = false;
         class20.method547(var0);
      }
   }
}
