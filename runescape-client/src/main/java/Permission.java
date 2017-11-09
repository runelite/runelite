import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3241(0, -1, true, false, true),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3234(1, 0, true, true, true),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3237(2, 1, true, true, false),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3236(3, 2, false, false, true),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3242(4, 3, false, false, true),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3238(5, 10, false, false, true);

   @ObfuscatedName("ao")
   static int[] field3243;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2070942117
   )
   final int field3233;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1250836219
   )
   public final int field3240;
   @ObfuscatedName("b")
   public final boolean field3239;
   @ObfuscatedName("n")
   public final boolean field3235;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3233 = var3;
      this.field3240 = var4;
      this.field3239 = var6;
      this.field3235 = var7;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field3233;
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1121223284"
   )
   static final void method4256(boolean var0) {
      if(var0) {
         Client.field904 = class91.field1338?class150.field2117:class150.field2120;
      } else {
         Client.field904 = Buffer.preferences.preferences.containsKey(Integer.valueOf(class215.method4071(class91.username)))?class150.field2119:class150.field2116;
      }

   }
}
