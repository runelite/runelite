import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class219 implements class218 {
   @ObfuscatedName("a")
   public static final class219 field2798;
   @ObfuscatedName("p")
   public static final class219 field2792;
   @ObfuscatedName("j")
   public static final class219 field2802;
   @ObfuscatedName("n")
   public static final class219 field2793;
   @ObfuscatedName("r")
   public static final class219 field2794;
   @ObfuscatedName("v")
   public static final class219 field2795;
   @ObfuscatedName("e")
   public static final class219 field2796;
   @ObfuscatedName("l")
   public static final class219 field2797;
   @ObfuscatedName("s")
   public static final class219 field2805;
   @ObfuscatedName("w")
   static final class219 field2799;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1519970161
   )
   public final int field2801;

   static {
      field2798 = new class219("", 10);
      field2802 = new class219("", 11);
      field2793 = new class219("", 12);
      field2794 = new class219("", 13);
      field2795 = new class219("", 14);
      field2796 = new class219("", 15, new ScriptVarType[]{ScriptVarType.field194, ScriptVarType.field194}, (ScriptVarType[])null);
      field2797 = new class219("", 16, new ScriptVarType[]{ScriptVarType.field194, ScriptVarType.field194}, (ScriptVarType[])null);
      field2805 = new class219("", 17, new ScriptVarType[]{ScriptVarType.field194, ScriptVarType.field194}, (ScriptVarType[])null);
      field2799 = new class219("", 73, true, true);
      field2792 = new class219("", 76, true, false);
   }

   class219(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   class219(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2801 = var2;
   }

   class219(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field2801;
   }
}
