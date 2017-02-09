import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class2 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 1268066012306088113L
   )
   public final long field21;
   @ObfuscatedName("o")
   public final XGrandExchangeOffer field22;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1471444435
   )
   public final int field23;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -995307453
   )
   static int field25;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1594755343
   )
   static int field27;
   @ObfuscatedName("w")
   String field28;
   @ObfuscatedName("r")
   String field30;

   class2(Buffer var1, byte var2, int var3) {
      this.field30 = var1.method2934();
      this.field28 = var1.method2934();
      this.field23 = var1.readUnsignedShort();
      this.field21 = var1.method2932();
      int var4 = var1.method3062();
      int var5 = var1.method3062();
      this.field22 = new XGrandExchangeOffer();
      this.field22.method72(2);
      this.field22.method53(var2);
      this.field22.price = var4;
      this.field22.totalQuantity = var5;
      this.field22.quantitySold = 0;
      this.field22.spent = 0;
      this.field22.itemId = var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method22() {
      return this.field30;
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-14"
   )
   static final void method23(int var0) {
      if(class15.method193(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2054 = 0;
               var3.field2176 = 0;
            }
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-46"
   )
   public String method26() {
      return this.field28;
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(LWidget;S)V",
      garbageValue = "-2144"
   )
   static void method28(Widget var0) {
      if(Client.field481 == var0.field2181) {
         Client.field482[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;III)Lclass57;",
      garbageValue = "-1005543625"
   )
   public static final class57 method30(class103 var0, Component var1, int var2, int var3) {
      if(class57.field1045 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1051 = new int[256 * (class57.field1057?2:1)];
            var4.field1060 = var3;
            var4.vmethod1141(var1);
            var4.field1048 = 1024 + (var3 & -1024);
            if(var4.field1048 > 16384) {
               var4.field1048 = 16384;
            }

            var4.vmethod1125(var4.field1048);
            if(ObjectComposition.field2920 > 0 && class57.field1049 == null) {
               class57.field1049 = new class63();
               class57.field1049.field1098 = var0;
               var0.method1945(class57.field1049, ObjectComposition.field2920);
            }

            if(null != class57.field1049) {
               if(null != class57.field1049.field1095[var2]) {
                  throw new IllegalArgumentException();
               }

               class57.field1049.field1095[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
