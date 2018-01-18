import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class230 implements class229 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class230 field2904;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class230 field2900;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class230 field2901;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class230 field2909;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class230 field2903;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class230 field2899;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class230 field2905;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class230 field2906;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static final class230 field2907;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class230 field2908;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -990295351
   )
   public final int field2902;

   static {
      field2904 = new class230("", 10);
      field2900 = new class230("", 11);
      field2901 = new class230("", 12);
      field2909 = new class230("", 13);
      field2903 = new class230("", 14);
      field2899 = new class230("", 15, new ScriptVarType[]{ScriptVarType.field74, ScriptVarType.field74}, (ScriptVarType[])null);
      field2905 = new class230("", 16, new ScriptVarType[]{ScriptVarType.field74, ScriptVarType.field74}, (ScriptVarType[])null);
      field2906 = new class230("", 17, new ScriptVarType[]{ScriptVarType.field74, ScriptVarType.field74}, (ScriptVarType[])null);
      field2907 = new class230("", 73, true, true);
      field2908 = new class230("", 76, true, false);
   }

   class230(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Ls;Z[Ls;)V"
   )
   class230(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2902 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Ls;[Ls;)V"
   )
   class230(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class230(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.field2902;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "16"
   )
   static boolean method4256(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1300198972"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = class27.method201(var0 - 1, var1 - 1) + class27.method201(1 + var0, var1 - 1) + class27.method201(var0 - 1, 1 + var1) + class27.method201(var0 + 1, var1 + 1);
      int var3 = class27.method201(var0 - 1, var1) + class27.method201(1 + var0, var1) + class27.method201(var0, var1 - 1) + class27.method201(var0, var1 + 1);
      int var4 = class27.method201(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
