import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1014775575
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 558788587
   )
   int field1547;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1208084231
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 596485527
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("k")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1576682119
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1931537841
   )
   int field1554;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 232456399
   )
   int field1555 = 0;

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "69049361"
   )
   static final void method1832(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class97.method1866(var2);
      }

      XItemContainer.method144(var2);
      Widget var4 = class108.method1988(var3);
      if(null != var4) {
         class204.method3671(var4);
      }

      class63.method1107();
      if(Client.widgetRoot != -1) {
         class9.method95(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZI)V",
      garbageValue = "-391059031"
   )
   public static void method1833(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1933 = 1;
      ChatLineBuffer.field967 = var0;
      GroundObject.field1298 = var1;
      class207.field3097 = var2;
      class138.field1921 = var3;
      class138.field1927 = var4;
      class138.field1926 = 10000;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "1137364846"
   )
   static void method1834(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class112.method2038(var1, var2);
      if(var5 != null) {
         if(null != var5.field2309) {
            class18 var6 = new class18();
            var6.field204 = var5;
            var6.field208 = var0;
            var6.field202 = var4;
            var6.field205 = var5.field2309;
            CombatInfo1.method594(var6);
         }

         boolean var10 = true;
         if(var5.contentType > 0) {
            var10 = XClanMember.method224(var5);
         }

         if(var10) {
            int var8 = class170.method3147(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> 1 + var9 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  Client.field336.method2963(44);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

               if(var0 == 2) {
                  Client.field336.method2963(221);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

               if(var0 == 3) {
                  Client.field336.method2963(1);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

               if(var0 == 4) {
                  Client.field336.method2963(217);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

               if(var0 == 5) {
                  Client.field336.method2963(161);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

               if(var0 == 6) {
                  Client.field336.method2963(243);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

               if(var0 == 7) {
                  Client.field336.method2963(134);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

               if(var0 == 8) {
                  Client.field336.method2963(177);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

               if(var0 == 9) {
                  Client.field336.method2963(24);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

               if(var0 == 10) {
                  Client.field336.method2963(255);
                  Client.field336.method2711(var1);
                  Client.field336.method2709(var2);
                  Client.field336.method2709(var3);
               }

            }
         }
      }
   }
}
