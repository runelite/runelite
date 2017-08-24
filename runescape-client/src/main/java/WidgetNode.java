import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("fa")
   static byte[][] field850;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -639579995
   )
   static int field851;
   @ObfuscatedName("a")
   boolean field854;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1356359209
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1328378399
   )
   @Export("owner")
   int owner;

   WidgetNode() {
      this.field854 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-11"
   )
   public static int method1121(int var0) {
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
      int var6 = class212.field2607[var5 - var4];
      return class212.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method1120() {
      Client.field1050 = 0;
      int var0 = (Player.localPlayer.x >> 7) + class149.baseX;
      int var1 = (Player.localPlayer.y >> 7) + class67.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field1050 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field1050 = 1;
      }

      if(Client.field1050 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field1050 = 0;
      }

   }
}
