import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class140 extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1242865951
   )
   int field1968;
   @ObfuscatedName("m")
   class142 field1969;
   @ObfuscatedName("b")
   class55 field1970;
   @ObfuscatedName("g")
   class137 field1971;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 598774883
   )
   int field1972;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -851105889
   )
   int field1973;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -45611559
   )
   int field1974;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 456511699
   )
   int field1976;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1750773603
   )
   int field1977;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1086043375
   )
   int field1978;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1082063089
   )
   int field1979;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1268035843
   )
   int field1980;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2108990683
   )
   int field1981;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2097142935
   )
   int field1982;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -516751119
   )
   int field1983;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1002006979
   )
   int field1984;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2107041007
   )
   int field1985;
   @ObfuscatedName("d")
   class66 field1986;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 383911255
   )
   int field1987;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 514201427
   )
   int field1989;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2046663379
   )
   int field1990;
   @ObfuscatedName("as")
   static SpritePixels[] field1991;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "640"
   )
   void method2566() {
      this.field1969 = null;
      this.field1970 = null;
      this.field1971 = null;
      this.field1986 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-4878"
   )
   public static boolean method2567(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-5"
   )
   static final void method2569(boolean var0) {
      for(int var1 = 0; var1 < Client.field492; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field327[var1]];
         int var3 = 536870912 + (Client.field327[var1] << 14);
         if(var2 != null && var2.vmethod702() && var0 == var2.composition.isVisible && var2.composition.method3618()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field612 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field391 == Client.field390[var4][var5]) {
                     continue;
                  }

                  Client.field390[var4][var5] = Client.field391;
               }

               if(!var2.composition.field2993) {
                  var3 -= Integer.MIN_VALUE;
               }

               class159.region.method1677(class63.plane, var2.x, var2.y, ChatLineBuffer.method896(var2.field612 * 64 - 64 + var2.x, var2.y + (var2.field612 * 64 - 64), class63.plane), 60 + (var2.field612 * 64 - 64), var2, var2.angle, var3, var2.field606);
            }
         }
      }

   }
}
