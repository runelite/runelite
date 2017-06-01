import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("c")
   String field919;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -595186249
   )
   @Export("world")
   int world;
   @ObfuscatedName("v")
   @Export("rank")
   byte rank;
   @ObfuscatedName("ee")
   static Font field922;
   @ObfuscatedName("fd")
   static byte[][] field923;
   @ObfuscatedName("cq")
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("i")
   @Export("username")
   String username;

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-977860796"
   )
   static final void method1139(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(RSSocket.method2986(var0)) {
         class95.method1754(CombatInfo1.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZI)I",
      garbageValue = "-977645929"
   )
   static int method1140(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = WorldMapType1.method261(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = WorldMapType1.method261(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "124"
   )
   public static int method1141(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
