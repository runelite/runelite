import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class11 {
   @ObfuscatedName("q")
   Script field121;
   @ObfuscatedName("p")
   String[] field123;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 462388255
   )
   int field124 = -1;
   @ObfuscatedName("ed")
   static SpritePixels[] field125;
   @ObfuscatedName("bj")
   static class184 field127;
   @ObfuscatedName("i")
   static byte[][] field129;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 758422607
   )
   public static int field130;
   @ObfuscatedName("ey")
   static SpritePixels[] field131;
   @ObfuscatedName("eb")
   static SpritePixels field132;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1002022309
   )
   static int field133;
   @ObfuscatedName("h")
   int[] field134;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "-1993555701"
   )
   static World method148() {
      return World.field711 < World.field703?World.worldList[++World.field711 - 1]:null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1739464062"
   )
   static final int method149(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = TextureProvider.method1508(var3, var5);
      int var8 = TextureProvider.method1508(var3 + 1, var5);
      int var9 = TextureProvider.method1508(var3, var5 + 1);
      int var10 = TextureProvider.method1508(var3 + 1, 1 + var5);
      int var11 = class7.method92(var7, var8, var4, var2);
      int var12 = class7.method92(var9, var10, var4, var2);
      return class7.method92(var11, var12, var6, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2144836861"
   )
   public static void method150() {
      if(class103.field1685.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1718[186] = 57;
         class105.field1718[187] = 27;
         class105.field1718[188] = 71;
         class105.field1718[189] = 26;
         class105.field1718[190] = 72;
         class105.field1718[191] = 73;
         class105.field1718[192] = 58;
         class105.field1718[219] = 42;
         class105.field1718[220] = 74;
         class105.field1718[221] = 43;
         class105.field1718[222] = 59;
         class105.field1718[223] = 28;
      } else {
         class105.field1718[44] = 71;
         class105.field1718[45] = 26;
         class105.field1718[46] = 72;
         class105.field1718[47] = 73;
         class105.field1718[59] = 57;
         class105.field1718[61] = 27;
         class105.field1718[91] = 42;
         class105.field1718[92] = 74;
         class105.field1718[93] = 43;
         class105.field1718[192] = 28;
         class105.field1718[222] = 58;
         class105.field1718[520] = 59;
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1746812358"
   )
   static final void method151(Widget var0, int var1, int var2) {
      if(Client.field564 == 0 || Client.field564 == 3) {
         if(class115.field1804 == 1 || !class15.field173 && class115.field1804 == 4) {
            class164 var3 = var0.method3219(true);
            if(null == var3) {
               return;
            }

            int var4 = class115.field1796 - var1;
            int var5 = class115.field1806 - var2;
            if(var3.method3156(var4, var5)) {
               var4 -= var3.field2156 / 2;
               var5 -= var3.field2157 / 2;
               int var6 = Client.mapAngle + Client.mapScale & 2047;
               int var7 = class84.field1468[var6];
               int var8 = class84.field1462[var6];
               var7 = var7 * (256 + Client.mapScaleDelta) >> 8;
               var8 = (Client.mapScaleDelta + 256) * var8 >> 8;
               int var9 = var4 * var8 + var7 * var5 >> 11;
               int var10 = var5 * var8 - var7 * var4 >> 11;
               int var11 = var9 + class36.localPlayer.x >> 7;
               int var12 = class36.localPlayer.y - var10 >> 7;
               Client.field348.method3073(69);
               Client.field348.method2918(18);
               Client.field348.method2865(class5.baseX + var11);
               Client.field348.method2918(class105.field1713[82]?(class105.field1713[81]?2:1):0);
               Client.field348.method2864(var12 + XClanMember.baseY);
               Client.field348.method2918(var4);
               Client.field348.method2918(var5);
               Client.field348.method2831(Client.mapAngle);
               Client.field348.method2918(57);
               Client.field348.method2918(Client.mapScale);
               Client.field348.method2918(Client.mapScaleDelta);
               Client.field348.method2918(89);
               Client.field348.method2831(class36.localPlayer.x);
               Client.field348.method2831(class36.localPlayer.y);
               Client.field348.method2918(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2013708159"
   )
   static final int method152(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }
}
