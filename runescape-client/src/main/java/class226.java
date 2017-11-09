import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class226 implements class225 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class226 field2870;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class226 field2862;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class226 field2865;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class226 field2861;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class226 field2867;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class226 field2866;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class226 field2863;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class226 field2868;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   static final class226 field2869;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class226 field2873;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 601338101
   )
   public final int field2871;

   static {
      field2870 = new class226("", 10);
      field2862 = new class226("", 11);
      field2865 = new class226("", 12);
      field2861 = new class226("", 13);
      field2867 = new class226("", 14);
      field2866 = new class226("", 15, new ScriptVarType[]{ScriptVarType.field144, ScriptVarType.field144}, (ScriptVarType[])null);
      field2863 = new class226("", 16, new ScriptVarType[]{ScriptVarType.field144, ScriptVarType.field144}, (ScriptVarType[])null);
      field2868 = new class226("", 17, new ScriptVarType[]{ScriptVarType.field144, ScriptVarType.field144}, (ScriptVarType[])null);
      field2869 = new class226("", 73, true, true);
      field2873 = new class226("", 76, true, false);
   }

   class226(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Le;Z[Le;)V"
   )
   class226(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2871 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Le;[Le;)V"
   )
   class226(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class226(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field2871;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2013312520"
   )
   static final String method4216(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + WallObject.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + WallObject.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + WallObject.getColTags(16776960) + var1 + "</col>");
   }
}
