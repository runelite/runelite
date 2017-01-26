import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class137 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -673039587
   )
   int field1903;
   @ObfuscatedName("g")
   byte[] field1904;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1808255237
   )
   int field1905;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -601821625
   )
   int field1906;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 18264865
   )
   int field1907;
   @ObfuscatedName("p")
   byte[] field1908;
   @ObfuscatedName("u")
   static int[][][] field1909;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 719370059
   )
   int field1910;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1829686875
   )
   int field1911;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1366460719
   )
   int field1912;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1939125332"
   )
   static final void method2486(Widget var0, int var1, int var2) {
      if(Client.field513 == 0 || Client.field513 == 3) {
         if(class115.field1813 == 1 || !class48.field937 && class115.field1813 == 4) {
            class164 var3 = var0.method3218(true);
            if(null == var3) {
               return;
            }

            int var4 = class115.field1811 - var1;
            int var5 = class115.field1812 - var2;
            if(var3.method3116(var4, var5)) {
               var4 -= var3.field2156 / 2;
               var5 -= var3.field2153 / 2;
               int var6 = Client.mapScale + Client.mapAngle & 2047;
               int var7 = class84.field1438[var6];
               int var8 = class84.field1452[var6];
               var7 = var7 * (256 + Client.mapScaleDelta) >> 8;
               var8 = (Client.mapScaleDelta + 256) * var8 >> 8;
               int var9 = var5 * var7 + var4 * var8 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = class16.localPlayer.x + var9 >> 7;
               int var12 = class16.localPlayer.y - var10 >> 7;
               Client.field394.method3037(46);
               Client.field394.method2799(18);
               Client.field394.method2839(class105.field1708[82]?(class105.field1708[81]?2:1):0);
               Client.field394.method2904(class3.baseY + var12);
               Client.field394.method2904(var11 + Projectile.baseX);
               Client.field394.method2799(var4);
               Client.field394.method2799(var5);
               Client.field394.method2837(Client.mapAngle);
               Client.field394.method2799(57);
               Client.field394.method2799(Client.mapScale);
               Client.field394.method2799(Client.mapScaleDelta);
               Client.field394.method2799(89);
               Client.field394.method2837(class16.localPlayer.x);
               Client.field394.method2837(class16.localPlayer.y);
               Client.field394.method2799(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "-2145901942"
   )
   static void method2487(World var0) {
      if(var0.method651() != Client.isMembers) {
         Client.isMembers = var0.method651();
         class149.method2785(var0.method651());
      }

      MessageNode.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class49.field963 = Client.field424 == 0?'ꩊ':'鱀' + var0.id;
      class174.field2637 = Client.field424 == 0?443:'썐' + var0.id;
      class103.field1676 = class49.field963;
   }
}
