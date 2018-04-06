import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
public class class245 implements class244 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class245 field2976;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class245 field2969;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class245 field2965;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class245 field2970;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class245 field2967;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class245 field2968;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class245 field2971;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class245 field2966;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static final class245 field2963;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class245 field2972;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -806646689
   )
   static int field2975;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2125768335
   )
   public final int field2973;

   static {
      field2976 = new class245("", 10);
      field2969 = new class245("", 11);
      field2965 = new class245("", 12);
      field2970 = new class245("", 13);
      field2967 = new class245("", 14);
      field2968 = new class245("", 15, new ScriptVarType[]{ScriptVarType.field47, ScriptVarType.field47}, (ScriptVarType[])null);
      field2971 = new class245("", 16, new ScriptVarType[]{ScriptVarType.field47, ScriptVarType.field47}, (ScriptVarType[])null);
      field2966 = new class245("", 17, new ScriptVarType[]{ScriptVarType.field47, ScriptVarType.field47}, (ScriptVarType[])null);
      field2963 = new class245("", 73, true, true);
      field2972 = new class245("", 76, true, false);
   }

   class245(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lz;Z[Lz;)V"
   )
   class245(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2973 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lz;[Lz;)V"
   )
   class245(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class245(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-369819377"
   )
   public int rsOrdinal() {
      return this.field2973;
   }
}
