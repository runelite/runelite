import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class1 {
   @ObfuscatedName("s")
   public final List field10;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -1143927225
   )
   static int field11;
   @ObfuscatedName("c")
   public static Comparator field12 = new class7();
   @ObfuscatedName("h")
   public static Comparator field13;
   @ObfuscatedName("a")
   public static Comparator field14;
   @ObfuscatedName("b")
   static class228 field15;
   @ObfuscatedName("bd")
   static class184 field16;
   @ObfuscatedName("f")
   public static Comparator field17;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Ljava/lang/String;Ljava/lang/String;I)LFont;",
      garbageValue = "-1129503655"
   )
   public static Font method7(class182 var0, class182 var1, String var2, String var3) {
      int var4 = var0.method3197(var2);
      int var5 = var0.method3198(var4, var3);
      return class180.method3174(var0, var1, var4, var5);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1067706712"
   )
   static void method8(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }

   static {
      new class0();
      field17 = new class5();
      field13 = new class6();
      field14 = new class3();
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1585055882"
   )
   static final void method10() {
      for(class25 var0 = (class25)Client.field359.method2330(); var0 != null; var0 = (class25)Client.field359.method2346()) {
         if(var0.field588 == -1) {
            var0.field586 = 0;
            Player.method221(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1766479299"
   )
   static final void method11(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field547 - Client.field546) * var5 / 100 + Client.field546;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var14;
      short var15;
      if(var7 < Client.field374) {
         var15 = Client.field374;
         var6 = 334 * var15 * var2 / (var3 * 512);
         if(var6 > Client.field384) {
            var6 = Client.field384;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var14 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method3843();
               Rasterizer2D.method3876(var0, var1, var14, var3, -16777216);
               Rasterizer2D.method3876(var0 + var2 - var14, var1, var14, var3, -16777216);
            }

            var0 += var14;
            var2 -= var14 * 2;
         }
      } else if(var7 > Client.field553) {
         var15 = Client.field553;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field550) {
            var6 = Client.field550;
            var8 = var15 * var2 * 334 / (512 * var6);
            var14 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method3843();
               Rasterizer2D.method3876(var0, var1, var2, var14, -16777216);
               Rasterizer2D.method3876(var0, var3 + var1 - var14, var2, var14, -16777216);
            }

            var1 += var14;
            var3 -= 2 * var14;
         }
      }

      var8 = var5 * (Client.field549 - Client.field535) / 100 + Client.field535;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var9 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 32 * var10 + 128 + 15;
            int var12 = 3 * var11 + 600;
            int var13 = class84.field1444[var11];
            var9[var10] = var12 * var13 >> 16;
         }

         Region.method1723(var9, 500, 800, var2, var3);
      }

      Client.field378 = var0;
      Client.field555 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "155766431"
   )
   static final int method12() {
      if(class38.field794.field699) {
         return class118.plane;
      } else {
         int var0 = XClanMember.method223(XItemContainer.cameraX, class20.cameraY, class118.plane);
         return var0 - class11.cameraZ < 800 && (class10.tileSettings[class118.plane][XItemContainer.cameraX >> 7][class20.cameraY >> 7] & 4) != 0?class118.plane:3;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "20"
   )
   public void method13(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field10, var1);
      } else {
         Collections.sort(this.field10, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-739685178"
   )
   static void method14(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class41.method754(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class41.method754(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2274((long)var1.id);
      if(null != var5) {
         class119.method2225(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field10 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field10.add(new class2(var1, var5, var3));
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1824641571"
   )
   static void method15() {
      int var0 = class16.field186;
      int var1 = ChatMessages.field907;
      if(class15.field180 < var0) {
         var0 = class15.field180;
      }

      if(class25.field590 < var1) {
         var1 = class25.field590;
      }

      if(null != class38.field794) {
         try {
            class100.method1894(class227.field3230, "resize", new Object[]{Integer.valueOf(Tile.method1515())});
         } catch (Throwable var3) {
            ;
         }
      }

   }
}
