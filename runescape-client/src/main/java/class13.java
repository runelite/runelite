import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class13 {
   @ObfuscatedName("g")
   static int[] field130;
   @ObfuscatedName("lf")
   static class216 field141;

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1608534691"
   )
   static final void method182(boolean var0) {
      for(int var1 = 0; var1 < Client.field323; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field324[var1]];
         int var3 = 536870912 + (Client.field324[var1] << 14);
         if(var2 != null && var2.vmethod795() && var0 == var2.composition.isVisible && var2.composition.method3806()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field634 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field334[var4][var5] == Client.field543) {
                     continue;
                  }

                  Client.field334[var4][var5] = Client.field543;
               }

               if(!var2.composition.field3039) {
                  var3 -= Integer.MIN_VALUE;
               }

               Varbit.region.method1838(class156.plane, var2.x, var2.y, class65.method1224(var2.x + (var2.field634 * 64 - 64), var2.field634 * 64 - 64 + var2.y, class156.plane), 60 + (var2.field634 * 64 - 64), var2, var2.angle, var3, var2.field632);
            }
         }
      }

   }

   class13() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)LScript;",
      garbageValue = "0"
   )
   static Script method183(int var0) {
      Script var1 = (Script)Script.field934.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class143.field2004.getConfigData(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new Script();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.readInt();
            var1.localIntCount = var3.readUnsignedShort();
            var1.localStringCount = var3.readUnsignedShort();
            var1.intStackCount = var3.readUnsignedShort();
            var1.stringStackCount = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2863();
            var1.instructions = new int[var4];
            var1.intOperands = new int[var4];
            var1.stringOperands = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.instructions[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.stringOperands[var5] = var3.readString();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.intOperands[var5] = var3.readInt();
               } else {
                  var1.intOperands[var5] = var3.readUnsignedByte();
               }
            }

            Script.field934.put(var1, (long)var0);
            return var1;
         }
      }
   }
}
