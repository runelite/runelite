import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class187 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-125"
   )
   public static void method3844(int var0, int var1) {
      Varbit var3 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = Varbit.varbit_ref.getConfigData(14, var0);
         var3 = new Varbit();
         if(var8 != null) {
            var3.decode(new Buffer(var8));
         }

         Varbit.varbits.put(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.configId;
      int var5 = var2.leastSignificantBit;
      int var6 = var2.mostSignificantBit;
      int var7 = class225.varpsMasks[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class225.clientVarps[var4] = class225.clientVarps[var4] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "33"
   )
   public static void method3855(Buffer var0, int var1) {
      if(class155.randomDat != null) {
         try {
            class155.randomDat.seek(0L);
            class155.randomDat.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-120"
   )
   static final int method3860() {
      if(ScriptState.preferences.hideRoofs) {
         return class192.plane;
      } else {
         int var0 = class264.getTileHeight(WorldMapType3.cameraX, class13.cameraY, class192.plane);
         return var0 - Size.cameraZ < 800 && (class50.tileSettings[class192.plane][WorldMapType3.cameraX >> 7][class13.cameraY >> 7] & 4) != 0?class192.plane:3;
      }
   }
}
