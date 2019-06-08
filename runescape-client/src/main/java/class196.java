import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class196 {
   @ObfuscatedName("of")
   @ObfuscatedSignature(
      signature = "Lch;"
   )
   @Export("varcs")
   static Varcs varcs;

   static {
      new HashMap();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "125"
   )
   static int method3736(int var0, Script var1, boolean var2) {
      return var0 < 1000?Canvas.method861(var0, var1, var2):(var0 < 1100?class1.method8(var0, var1, var2):(var0 < 1200?StructDefinition.method4952(var0, var1, var2):(var0 < 1300?class32.method576(var0, var1, var2):(var0 < 1400?WorldMapAreaData.method710(var0, var1, var2):(var0 < 1500?class11.method141(var0, var1, var2):(var0 < 1600?WorldMapSectionType.method253(var0, var1, var2):(var0 < 1700?ScriptEvent.method1185(var0, var1, var2):(var0 < 1800?Formatting.method2023(var0, var1, var2):(var0 < 1900?class16.method188(var0, var1, var2):(var0 < 2000?FriendSystem.method1867(var0, var1, var2):(var0 < 2100?class1.method8(var0, var1, var2):(var0 < 2200?StructDefinition.method4952(var0, var1, var2):(var0 < 2300?class32.method576(var0, var1, var2):(var0 < 2400?WorldMapAreaData.method710(var0, var1, var2):(var0 < 2500?class11.method141(var0, var1, var2):(var0 < 2600?ViewportMouse.method2983(var0, var1, var2):(var0 < 2700?GrandExchangeEvents.method75(var0, var1, var2):(var0 < 2800?class11.method146(var0, var1, var2):(var0 < 2900?class15.method182(var0, var1, var2):(var0 < 3000?FriendSystem.method1867(var0, var1, var2):(var0 < 3200?class4.method54(var0, var1, var2):(var0 < 3300?WorldComparator.method68(var0, var1, var2):(var0 < 3400?ScriptEvent.method1187(var0, var1, var2):(var0 < 3500?Formatting.method2022(var0, var1, var2):(var0 < 3700?FontName.method5639(var0, var1, var2):(var0 < 4000?class248.method4741(var0, var1, var2):(var0 < 4100?TextureProvider.method2752(var0, var1, var2):(var0 < 4200?class211.method4103(var0, var1, var2):(var0 < 4300?class1.method16(var0, var1, var2):(var0 < 5100?DynamicObject.method2223(var0, var1, var2):(var0 < 5400?UserComparator4.method3335(var0, var1, var2):(var0 < 5600?OwnWorldComparator.method1285(var0, var1, var2):(var0 < 5700?Decimator.method2492(var0, var1, var2):(var0 < 6300?class229.method4513(var0, var1, var2):(var0 < 6600?class31.method573(var0, var1, var2):(var0 < 6700?class54.method1093(var0, var1, var2):2))))))))))))))))))))))))))))))))))));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-127"
   )
   static void method3740() {
      if(Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
         Login.currentLoginField = 1;
      } else {
         Login.currentLoginField = 0;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1247389467"
   )
   static final String method3735(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}
