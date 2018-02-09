import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class230 implements class229 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static final class230 field2892;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static final class230 field2893;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static final class230 field2894;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static final class230 field2895;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static final class230 field2896;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static final class230 field2897;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static final class230 field2898;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static final class230 field2902;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static final class230 field2900;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static final class230 field2901;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1668077241
   )
   public final int field2899;

   static {
      field2892 = new class230("", 10);
      field2893 = new class230("", 11);
      field2894 = new class230("", 12);
      field2895 = new class230("", 13);
      field2896 = new class230("", 14);
      field2897 = new class230("", 15, new ScriptVarType[]{ScriptVarType.field200, ScriptVarType.field200}, (ScriptVarType[])null);
      field2898 = new class230("", 16, new ScriptVarType[]{ScriptVarType.field200, ScriptVarType.field200}, (ScriptVarType[])null);
      field2902 = new class230("", 17, new ScriptVarType[]{ScriptVarType.field200, ScriptVarType.field200}, (ScriptVarType[])null);
      field2900 = new class230("", 73, true, true);
      field2901 = new class230("", 76, true, false);
   }

   class230(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lt;Z[Lt;)V"
   )
   class230(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2899 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lt;[Lt;)V"
   )
   class230(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class230(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.field2899;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1215432455"
   )
   @Export("getItemStackAmountText")
   static final String getItemStackAmountText(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}
