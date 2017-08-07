import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("v")
   @Export("validInterfaces")
   static boolean[] validInterfaces;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1323858539"
   )
   public abstract int vmethod3018(int var1, int var2);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1736198972"
   )
   public abstract void vmethod3017();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1721610276"
   )
   public static final void method3024(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class7.field229.method3580(new class8(var7, var9, var8, var10, -49088));
   }
}
