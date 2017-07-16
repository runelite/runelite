import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class98 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 268244061
   )
   static int field1521;
   @ObfuscatedName("a")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static final class186 field1520;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static final class201 field1526;
   @ObfuscatedName("ks")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   static class89 field1525;
   @ObfuscatedName("m")
   @Export("blendedSaturation")
   static int[] blendedSaturation;

   static {
      chatLineMap = new HashMap();
      field1520 = new class186(1024);
      field1526 = new class201();
      field1521 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1846948257"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = CombatInfo2.getSmoothNoise2D(var3, var5);
      int var8 = CombatInfo2.getSmoothNoise2D(var3 + 1, var5);
      int var9 = CombatInfo2.getSmoothNoise2D(var3, var5 + 1);
      int var10 = CombatInfo2.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var11 = class33.method352(var7, var8, var4, var2);
      int var12 = class33.method352(var9, var10, var4, var2);
      return class33.method352(var11, var12, var6, var2);
   }
}
