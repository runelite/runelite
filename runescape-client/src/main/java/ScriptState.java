import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1895373177
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("f")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("rasterProvider")
   public static BufferProvider rasterProvider;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1612919269
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("e")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("k")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-14"
   )
   static final void method1022(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4799()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1126 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field931[var4][var5] == Client.field932) {
                     continue;
                  }

                  Client.field931[var4][var5] = Client.field932;
               }

               if(!var2.composition.field3643) {
                  var3 -= Integer.MIN_VALUE;
               }

               class48.region.method2701(BoundingBox2D.plane, var2.x, var2.y, WorldMapType2.getTileHeight(var2.field1126 * 64 - 64 + var2.x, var2.field1126 * 64 - 64 + var2.y, BoundingBox2D.plane), var2.field1126 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1170);
            }
         }
      }

   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(Lhz;Ljq;IIZI)V",
      garbageValue = "-256260065"
   )
   static final void method1023(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         Varcs.method1806(var7, Buffer.getColTags(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
      }

   }
}
