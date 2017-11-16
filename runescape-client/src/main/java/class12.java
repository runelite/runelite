import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
final class class12 implements Comparator {
   @ObfuscatedName("b")
   static boolean field256;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 384634911
   )
   static int field257;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lj;Lj;I)I",
      garbageValue = "-726085790"
   )
   int method65(class14 var1, class14 var2) {
      return var1.field277 < var2.field277?-1:(var2.field277 == var1.field277?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method65((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1840324206"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1167477540"
   )
   static final void method64() {
      Client.field905.method1857();
      class48.method673();
      Client.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class96.method1815(2);
      Client.field1083 = -1;
      Client.field1084 = false;
      Widget.method4065();
      class2.setGameState(10);
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(Lhx;I)I",
      garbageValue = "1436774736"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   public static void method72(int var0, int var1, int var2) {
      PacketNode var3 = class18.method133(ClientPacket.field2352, Client.field905.field1460);
      var3.packetBuffer.method3219(var0);
      var3.packetBuffer.method3212(var2);
      var3.packetBuffer.method3221(var1);
      Client.field905.method1855(var3);
   }
}
