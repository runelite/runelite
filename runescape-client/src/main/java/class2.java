import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class2 {
   @ObfuscatedName("g")
   String field21;
   @ObfuscatedName("k")
   String field22;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 860991939
   )
   public final int field23;
   @ObfuscatedName("f")
   public final XGrandExchangeOffer field24;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -1712252673056918757L
   )
   public final long field26;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -89621671
   )
   @Export("cameraY")
   static int cameraY;

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "1510276633"
   )
   static void method18(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class32.method654(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class32.method654(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2311((long)var1.id);
      if(null != var5) {
         int var6 = var5.id;
         if(class212.method3870(var6)) {
            class32.method654(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1292512942"
   )
   public String method19() {
      return this.field21;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "970394703"
   )
   public String method24() {
      return this.field22;
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field22 = var1.method2767();
      this.field21 = var1.method2767();
      this.field23 = var1.readUnsignedShort();
      this.field26 = var1.method2866();
      int var4 = var1.method2844();
      int var5 = var1.method2844();
      this.field24 = new XGrandExchangeOffer();
      this.field24.method42(2);
      this.field24.method43(var2);
      this.field24.price = var4;
      this.field24.totalQuantity = var5;
      this.field24.quantitySold = 0;
      this.field24.spent = 0;
      this.field24.itemId = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;IIB)Lclass57;",
      garbageValue = "-43"
   )
   public static final class57 method25(class103 var0, Component var1, int var2, int var3) {
      if(class57.field1053 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1066 = new int[256 * (class57.field1062?2:1)];
            var4.field1039 = var3;
            var4.vmethod1086(var1);
            var4.field1048 = (var3 & -1024) + 1024;
            if(var4.field1048 > 16384) {
               var4.field1048 = 16384;
            }

            var4.vmethod1087(var4.field1048);
            if(class57.field1056 > 0 && class186.field2770 == null) {
               class186.field2770 = new class63();
               class186.field2770.field1092 = var0;
               var0.method1932(class186.field2770, class57.field1056);
            }

            if(null != class186.field2770) {
               if(class186.field2770.field1090[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class186.field2770.field1090[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIII[LCollisionData;I)V",
      garbageValue = "-986944914"
   )
   static final void method26(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var2 + var8 < 103) {
                  var5[var6].flags[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               WidgetNode.method184(var10, var7, var1 + var8, var2 + var9, var3, var4, 0);
            }
         }
      }

   }
}
