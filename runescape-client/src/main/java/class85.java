import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public final class class85 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1709812633
   )
   int field1463;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1889525209
   )
   int field1464;
   @ObfuscatedName("h")
   boolean field1466 = true;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1309923451
   )
   int field1467;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1710796193
   )
   int field1468;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2023420993
   )
   int field1469;
   @ObfuscatedName("bf")
   protected static FontMetrics field1471;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1543049973
   )
   int field1472;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class85(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1467 = var1;
      this.field1464 = var2;
      this.field1472 = var3;
      this.field1463 = var4;
      this.field1468 = var5;
      this.field1469 = var6;
      this.field1466 = var7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-1776294733"
   )
   public static byte[] method1750(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class41.method856(var3):var3;
      } else if(var0 instanceof class156) {
         class156 var2 = (class156)var0;
         return var2.vmethod3063();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
