import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class16 extends class131 {
   @ObfuscatedName("x")
   String field175;
   @ObfuscatedName("i")
   short field176;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 903243367
   )
   int field180 = (int)(class9.method117() / 1000L);

   class16(String var1, int var2) {
      this.field175 = var1;
      this.field176 = (short)var2;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1769694187"
   )
   static final void method179(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class176.method3243(var0, var1, class60.plane) - var2;
         var0 -= class36.cameraX;
         var3 -= class36.cameraZ;
         var1 -= GroundObject.cameraY;
         int var4 = class84.field1438[class165.cameraPitch];
         int var5 = class84.field1428[class165.cameraPitch];
         int var6 = class84.field1438[XClanMember.cameraYaw];
         int var7 = class84.field1428[XClanMember.cameraYaw];
         int var8 = var7 * var0 + var6 * var1 >> 16;
         var1 = var7 * var1 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            Client.field388 = Client.camera2 / 2 + Client.scale * var0 / var1;
            Client.field491 = Client.camera3 / 2 + Client.scale * var8 / var1;
         } else {
            Client.field388 = -1;
            Client.field491 = -1;
         }
      } else {
         Client.field388 = -1;
         Client.field491 = -1;
      }

   }

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "882440275"
   )
   static void method180(int var0) {
      for(class133 var1 = (class133)Client.widgetFlags.method2344(); var1 != null; var1 = (class133)Client.widgetFlags.method2343()) {
         if((var1.hash >> 48 & 65535L) == (long)var0) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1995043503"
   )
   public static int method181(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;B)V",
      garbageValue = "-20"
   )
   static void method182(int var0, class116 var1, class184 var2) {
      class180 var3 = new class180();
      var3.field2673 = 1;
      var3.hash = (long)var0;
      var3.field2670 = var1;
      var3.field2671 = var2;
      Deque var4 = class183.field2705;
      Deque var5 = class183.field2705;
      synchronized(class183.field2705) {
         class183.field2705.method2394(var3);
      }

      class171.method3232();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "114"
   )
   public static int method183(CharSequence var0) {
      return KitDefinition.method3499(var0, 10, true);
   }
}
