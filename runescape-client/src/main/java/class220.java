import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class220 implements class219 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static final class220 field2772;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static final class220 field2771;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static final class220 field2763;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static final class220 field2764;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static final class220 field2765;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static final class220 field2766;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static final class220 field2762;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static final class220 field2767;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static final class220 field2768;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   static final class220 field2770;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2060737289
   )
   public final int field2769;

   static {
      field2772 = new class220("", 10);
      field2763 = new class220("", 11);
      field2764 = new class220("", 12);
      field2765 = new class220("", 13);
      field2766 = new class220("", 14);
      field2762 = new class220("", 15, new ScriptVarType[]{ScriptVarType.field187, ScriptVarType.field187}, (ScriptVarType[])null);
      field2767 = new class220("", 16, new ScriptVarType[]{ScriptVarType.field187, ScriptVarType.field187}, (ScriptVarType[])null);
      field2768 = new class220("", 17, new ScriptVarType[]{ScriptVarType.field187, ScriptVarType.field187}, (ScriptVarType[])null);
      field2770 = new class220("", 73, true, true);
      field2771 = new class220("", 76, true, false);
   }

   class220(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lv;Z[Lv;)V"
   )
   class220(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2769 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lv;[Lv;)V"
   )
   class220(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class220(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field2769;
   }
}
