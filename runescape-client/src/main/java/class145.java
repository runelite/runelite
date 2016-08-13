import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class145 {
   @ObfuscatedName("l")
   public static class170 field2235;
   @ObfuscatedName("n")
   public static byte[][] field2236;

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "-7"
   )
   static boolean method3128(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class156.method3300(var0, Client.field518);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class156.method3300(Client.friends[var3].name, Client.field518)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class156.method3300(WidgetNode.localPlayer.name, Client.field518))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1098458733"
   )
   static void method3129(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field666[var5] != var0) {
            var2[var4] = World.field666[var5];
            var3[var4] = World.field665[var5];
            ++var4;
         }
      }

      World.field666 = var2;
      World.field665 = var3;
      class9.method133(World.worldList, 0, World.worldList.length - 1, World.field666, World.field665);
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "70"
   )
   static final void method3130(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class163.method3329(var2);
      }

      for(class204 var4 = (class204)Client.widgetFlags.method3939(); null != var4; var4 = (class204)Client.widgetFlags.method3935()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var6 = class134.method2983(var3);
      if(var6 != null) {
         class79.method1777(var6);
      }

      class124.method2891();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class14.method179(var5)) {
            class9.method134(Widget.widgets[var5], 1);
         }
      }

   }
}
