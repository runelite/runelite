import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class220 implements class219 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static final class220 field2796;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static final class220 field2805;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static final class220 field2799;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static final class220 field2798;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static final class220 field2800;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static final class220 field2809;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static final class220 field2801;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static final class220 field2803;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static final class220 field2797;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static final class220 field2804;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1655823943
   )
   public final int field2806;

   static {
      field2796 = new class220("", 10);
      field2799 = new class220("", 11);
      field2798 = new class220("", 12);
      field2809 = new class220("", 13);
      field2800 = new class220("", 14);
      field2801 = new class220("", 15, new ScriptVarType[]{ScriptVarType.field110, ScriptVarType.field110}, (ScriptVarType[])null);
      field2803 = new class220("", 16, new ScriptVarType[]{ScriptVarType.field110, ScriptVarType.field110}, (ScriptVarType[])null);
      field2797 = new class220("", 17, new ScriptVarType[]{ScriptVarType.field110, ScriptVarType.field110}, (ScriptVarType[])null);
      field2804 = new class220("", 73, true, true);
      field2805 = new class220("", 76, true, false);
   }

   class220(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lq;Z[Lq;)V"
   )
   class220(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2806 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lq;[Lq;)V"
   )
   class220(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class220(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field2806;
   }
}
