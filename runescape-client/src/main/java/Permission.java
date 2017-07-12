import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("hu")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("i")
   field3185(0, -1, true, false, true),
   @ObfuscatedName("w")
   field3180(1, 0, true, true, true),
   @ObfuscatedName("a")
   field3189(2, 1, true, true, false),
   @ObfuscatedName("t")
   field3182(3, 2, false, false, true),
   @ObfuscatedName("s")
   field3183(4, 3, false, false, true),
   @ObfuscatedName("r")
   field3181(5, 10, false, false, true);

   @ObfuscatedName("j")
   public final boolean field3184;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -139272601
   )
   public final int field3186;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -809857567
   )
   final int field3187;
   @ObfuscatedName("k")
   public final boolean field3188;
   @ObfuscatedName("e")
   @Export("blendedSaturation")
   static int[] blendedSaturation;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field3187;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "59"
   )
   static Class method4095(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   private Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3187 = var3;
      this.field3186 = var4;
      this.field3184 = var6;
      this.field3188 = var7;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-727744477"
   )
   public static void method4098() {
      ObjectComposition.objects.reset();
      ObjectComposition.field3487.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3486.reset();
   }
}
