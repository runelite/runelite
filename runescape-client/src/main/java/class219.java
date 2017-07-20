import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class219 implements class218 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class219 field2762;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class219 field2768;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class219 field2760;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class219 field2761;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class219 field2763;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class219 field2766;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class219 field2770;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class219 field2765;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public static final class219 field2773;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static final class219 field2767;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -2022400111
   )
   public static int field2771;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -826279375
   )
   public final int field2769;

   static {
      field2762 = new class219("", 10);
      field2760 = new class219("", 11);
      field2761 = new class219("", 12);
      field2766 = new class219("", 13);
      field2763 = new class219("", 14);
      field2770 = new class219("", 15, new ScriptVarType[]{ScriptVarType.field89, ScriptVarType.field89}, (ScriptVarType[])null);
      field2765 = new class219("", 16, new ScriptVarType[]{ScriptVarType.field89, ScriptVarType.field89}, (ScriptVarType[])null);
      field2773 = new class219("", 17, new ScriptVarType[]{ScriptVarType.field89, ScriptVarType.field89}, (ScriptVarType[])null);
      field2767 = new class219("", 73, true, true);
      field2768 = new class219("", 76, true, false);
   }

   class219(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Ls;Z[Ls;)V"
   )
   class219(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2769 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Ls;[Ls;)V"
   )
   class219(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field2769;
   }
}
