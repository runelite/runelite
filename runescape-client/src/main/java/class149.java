import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class149 {
   @ObfuscatedName("ex")
   static SpritePixels[] field2037;

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(LSequence;IIIS)V",
      garbageValue = "376"
   )
   static void method2796(Sequence var0, int var1, int var2, int var3) {
      if(Client.field419 < 50 && Client.field554 != 0) {
         if(null != var0.field3061 && var1 < var0.field3061.length) {
            int var4 = var0.field3061[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field556[Client.field419] = var5;
               Client.field557[Client.field419] = var6;
               Client.field558[Client.field419] = 0;
               Client.field560[Client.field419] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field559[Client.field419] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field419;
            }
         }
      }
   }

   class149() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1268000936"
   )
   static final void method2797() {
      Overlay.field3050.reset();
      FloorUnderlayDefinition.field2802.reset();
      Buffer.method2878();
      class41.method837();
      MessageNode.method230();
      class39.method814();
      class22.method231();
      Spotanim.field2799.reset();
      Spotanim.field2787.reset();
      Varbit.field2846.reset();
      class187.field2771.reset();
      class196.field2867.reset();
      class196.spriteCache.reset();
      class196.field2869.reset();
      class176.method3277();
      PlayerComposition.field2168.reset();
      Widget.field2180.reset();
      Widget.field2199.reset();
      Widget.field2182.reset();
      Widget.field2183.reset();
      ((TextureProvider)class84.field1458).method1499();
      Script.field964.reset();
      Client.field341.method3340();
      FloorUnderlayDefinition.field2811.method3340();
      RSCanvas.field1765.method3340();
      class188.field2778.method3340();
      class33.field778.method3340();
      class3.field39.method3340();
      class195.field2859.method3340();
      class0.field2.method3340();
      KitDefinition.field2825.method3340();
      class99.field1655.method3340();
      class1.field12.method3340();
      class110.field1763.method3340();
   }
}
