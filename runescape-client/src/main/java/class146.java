import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public final class class146 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1378522323
   )
   int field2164;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -240664073
   )
   int field2165;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 11888619
   )
   int field2166;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -214545445
   )
   int field2167;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -306134599
   )
   int field2168;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 143435555
   )
   int field2169;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 215600285
   )
   int field2170;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -47073749
   )
   int field2171;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1051049729
   )
   int field2172;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 378767691
   )
   int field2173;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2081529231
   )
   int field2174;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 387118129
   )
   int field2175;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2074838213
   )
   int field2176;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2120104555
   )
   int field2177;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1077987527
   )
   int field2178;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -728007523
   )
   int field2179;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1328777833
   )
   int field2180;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 175942941
   )
   int field2181;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILclass219;I)I",
      garbageValue = "-21685522"
   )
   public static int method2895(int var0, class219 var1) {
      return (var0 << 8) + var1.field2797;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LScript;",
      garbageValue = "1078091564"
   )
   static Script method2896(int var0) {
      Script var1 = (Script)Script.field1552.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class23.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = CombatInfo1.method1543(var2);
            Script.field1552.put(var1, (long)var0);
            return var1;
         }
      }
   }
}
