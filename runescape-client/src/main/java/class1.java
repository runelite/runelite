import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class1 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field1;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field2;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field10;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field3;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field4;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static Buffer field0;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field5;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field6;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   static Widget field9;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1485633541
   )
   final int field7;

   static {
      field1 = new class1(1);
      field2 = new class1(5);
      field10 = new class1(3);
      field3 = new class1(0);
      field4 = new class1(4);
      field5 = new class1(2);
      field6 = new class1(6);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2105931920"
   )
   public static int method3(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class211.field2609[var5 - var4];
      return class211.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-50"
   )
   static void method1(int var0) {
      Client.field951 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      int var1 = Client.isResized?2:1;
      if(var1 == 1) {
         class28.clientInstance.method939(765, 503);
      } else {
         class28.clientInstance.method939(7680, 2160);
      }

      if(Client.gameState >= 25) {
         class34.method480();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "37"
   )
   public static final void method2() {
      while(true) {
         class9 var0 = (class9)class7.field226.method3559();
         if(var0 == null) {
            return;
         }

         var0.vmethod54();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1864482637"
   )
   @Export("resetMapInfo")
   static void resetMapInfo() {
      Item.underlayIds = null;
      class61.overlayIds = null;
      class12.overlayPaths = null;
      class61.overlayRotations = null;
      class9.field249 = null;
      class61.field750 = null;
      FileRequest.field3211 = null;
      class61.blendedHue = null;
      class98.blendedSaturation = null;
      class10.field256 = null;
      class61.field763 = null;
      Varcs.field1508 = null;
   }
}
