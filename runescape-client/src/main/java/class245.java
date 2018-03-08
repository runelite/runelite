import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class245 implements class244 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   public static final class245 field2965;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   public static final class245 field2964;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   public static final class245 field2957;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   public static final class245 field2958;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   public static final class245 field2955;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   public static final class245 field2960;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   public static final class245 field2956;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   public static final class245 field2962;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static final class245 field2963;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   public static final class245 field2959;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1870085083
   )
   public final int field2961;

   static {
      field2965 = new class245("", 10);
      field2964 = new class245("", 11);
      field2957 = new class245("", 12);
      field2958 = new class245("", 13);
      field2955 = new class245("", 14);
      field2960 = new class245("", 15, new ScriptVarType[]{ScriptVarType.field210, ScriptVarType.field210}, (ScriptVarType[])null);
      field2956 = new class245("", 16, new ScriptVarType[]{ScriptVarType.field210, ScriptVarType.field210}, (ScriptVarType[])null);
      field2962 = new class245("", 17, new ScriptVarType[]{ScriptVarType.field210, ScriptVarType.field210}, (ScriptVarType[])null);
      field2963 = new class245("", 73, true, true);
      field2959 = new class245("", 76, true, false);
   }

   class245(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Le;Z[Le;)V"
   )
   class245(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2961 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Le;[Le;)V"
   )
   class245(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class245(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.field2961;
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "1029495609"
   )
   static final String method4529(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class37.getColTags(16711680):(var2 < -6?class37.getColTags(16723968):(var2 < -3?class37.getColTags(16740352):(var2 < 0?class37.getColTags(16756736):(var2 > 9?class37.getColTags(65280):(var2 > 6?class37.getColTags(4259584):(var2 > 3?class37.getColTags(8453888):(var2 > 0?class37.getColTags(12648192):class37.getColTags(16776960))))))));
   }
}
