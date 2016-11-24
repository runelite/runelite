import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class48 extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -69934975
   )
   int field932;
   @ObfuscatedName("g")
   static int[][] field933;
   @ObfuscatedName("m")
   int[] field934;
   @ObfuscatedName("h")
   String[] field935;
   @ObfuscatedName("n")
   static NodeCache field936 = new NodeCache(128);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 280844843
   )
   int field937;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2064198939
   )
   int field938;
   @ObfuscatedName("d")
   int[] field939;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1546132059
   )
   int field940;

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2006031227"
   )
   static final String method888(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1776600516"
   )
   static final int method891(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = Projectile.method818(var3, var5);
      int var8 = Projectile.method818(1 + var3, var5);
      int var9 = Projectile.method818(var3, var5 + 1);
      int var10 = Projectile.method818(1 + var3, 1 + var5);
      int var11 = class6.method85(var7, var8, var4, var2);
      int var12 = class6.method85(var9, var10, var4, var2);
      return class6.method85(var11, var12, var6, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "2"
   )
   public static byte[] method892(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class31.method695(var3):var3;
      } else if(var0 instanceof class163) {
         class163 var2 = (class163)var0;
         return var2.vmethod3210();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
