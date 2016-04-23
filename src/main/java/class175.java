import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class175 extends class204 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1819994917
   )
   public final int field2890;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -126814149
   )
   public final int field2891;
   @ObfuscatedName("z")
   public final int[] field2892;
   @ObfuscatedName("v")
   static int[] field2893;
   @ObfuscatedName("m")
   public final int[] field2895;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 1192468455
   )
   static int field2896;

   class175(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2890 = var1;
      this.field2891 = var2;
      this.field2895 = var3;
      this.field2892 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-881651993"
   )
   public boolean method3411(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2892.length) {
         int var3 = this.field2892[var2];
         if(var1 >= var3 && var1 <= this.field2895[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "820010214"
   )
   public static void method3413() {
      class42.field970.method3707();
      class42.field971.method3707();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass37;IS)V",
      garbageValue = "-1355"
   )
   static final void method3414(class37 var0, int var1) {
      class50.method1009(var0.field816, var0.field840, var1);
   }
}
