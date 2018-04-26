import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
public class class245 implements class244 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static final class245 field2960;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static final class245 field2961;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static final class245 field2962;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static final class245 field2969;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static final class245 field2963;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static final class245 field2964;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static final class245 field2965;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static final class245 field2966;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static final class245 field2967;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static final class245 field2968;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -937459413
   )
   public final int field2959;

   static {
      field2960 = new class245("", 10);
      field2961 = new class245("", 11);
      field2962 = new class245("", 12);
      field2969 = new class245("", 13);
      field2963 = new class245("", 14);
      field2964 = new class245("", 15, new ScriptVarType[]{ScriptVarType.field112, ScriptVarType.field112}, (ScriptVarType[])null);
      field2965 = new class245("", 16, new ScriptVarType[]{ScriptVarType.field112, ScriptVarType.field112}, (ScriptVarType[])null);
      field2966 = new class245("", 17, new ScriptVarType[]{ScriptVarType.field112, ScriptVarType.field112}, (ScriptVarType[])null);
      field2967 = new class245("", 73, true, true);
      field2968 = new class245("", 76, true, false);
   }

   class245(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Ls;Z[Ls;)V"
   )
   class245(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2959 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Ls;[Ls;)V"
   )
   class245(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class245(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.field2959;
   }
}
