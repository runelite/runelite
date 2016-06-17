import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class20 implements class112 {
   @ObfuscatedName("j")
   static final class20 field571 = new class20(2);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -594525697
   )
   final int field572;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = 1049834371
   )
   @Export("menuHeight")
   static int field573;
   @ObfuscatedName("d")
   static final class20 field574 = new class20(3);
   @ObfuscatedName("b")
   static final class20 field575 = new class20(0);
   @ObfuscatedName("g")
   static final class20 field576 = new class20(1);

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class20(int var1) {
      this.field572 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "977914203"
   )
   public int vmethod3185() {
      return this.field572;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lclass52;",
      garbageValue = "-573951741"
   )
   public static class52 method553(int var0) {
      class52 var1 = (class52)class52.field1130.method3764((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class52.field1131.method3266(16, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1067(new class119(var2));
         }

         class52.field1130.method3759(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)[Lclass80;",
      garbageValue = "1094969738"
   )
   public static class80[] method554(class167 var0, String var1, String var2) {
      int var3 = var0.method3281(var1);
      int var4 = var0.method3282(var3, var2);
      class80[] var5;
      if(!class38.method766(var0, var3, var4)) {
         var5 = null;
      } else {
         class80[] var7 = new class80[class76.field1361];

         for(int var8 = 0; var8 < class76.field1361; ++var8) {
            class80 var9 = var7[var8] = new class80();
            var9.field1393 = class109.field1890;
            var9.field1388 = class76.field1351;
            var9.field1392 = class76.field1353[var8];
            var9.field1395 = class131.field2048[var8];
            var9.field1390 = class76.field1354[var8];
            var9.field1391 = class28.field674[var8];
            var9.field1389 = class8.field135;
            var9.field1394 = class76.field1355[var8];
         }

         class7.method95();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   static void method555() {
      client.field331.field1976 = 0;
      client.field332.field1976 = 0;
      client.field335 = -1;
      client.field338 = 1;
      client.field406 = -1;
      client.field540 = -1;
      client.field334 = 0;
      client.field441 = 0;
      client.field519 = 0;
      client.field429 = 0;
      client.field428 = false;
      client.field493 = 0;
      client.field521 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         client.field410[var0] = null;
      }

      class153.field2262 = null;

      for(var0 = 0; var0 < client.field326.length; ++var0) {
         class34 var1 = client.field326[var0];
         if(var1 != null) {
            var1.field815 = -1;
            var1.field816 = false;
         }
      }

      class15.field221 = new class196(32);
      class43.method919(30);

      for(var0 = 0; var0 < 100; ++var0) {
         client.field507[var0] = true;
      }

      client.field331.method2781(174);
      class122 var3 = client.field331;
      int var2 = client.field501?2:1;
      var3.method2650(var2);
      client.field331.method2695(class45.field1026);
      client.field331.method2695(class143.field2169);
   }
}
