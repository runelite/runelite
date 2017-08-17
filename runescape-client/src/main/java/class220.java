import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class220 implements class219 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public static final class220 field2798;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public static final class220 field2797;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public static final class220 field2792;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public static final class220 field2789;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public static final class220 field2790;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public static final class220 field2791;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public static final class220 field2793;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public static final class220 field2794;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public static final class220 field2795;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static final class220 field2799;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 896652503
   )
   public final int field2796;

   static {
      field2798 = new class220("", 10);
      field2792 = new class220("", 11);
      field2790 = new class220("", 12);
      field2791 = new class220("", 13);
      field2789 = new class220("", 14);
      field2793 = new class220("", 15, new ScriptVarType[]{ScriptVarType.field187, ScriptVarType.field187}, (ScriptVarType[])null);
      field2794 = new class220("", 16, new ScriptVarType[]{ScriptVarType.field187, ScriptVarType.field187}, (ScriptVarType[])null);
      field2795 = new class220("", 17, new ScriptVarType[]{ScriptVarType.field187, ScriptVarType.field187}, (ScriptVarType[])null);
      field2799 = new class220("", 73, true, true);
      field2797 = new class220("", 76, true, false);
   }

   class220(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lc;Z[Lc;)V"
   )
   class220(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2796 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lc;[Lc;)V"
   )
   class220(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class220(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field2796;
   }
}
