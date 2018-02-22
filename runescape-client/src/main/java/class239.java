import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
public class class239 implements class238 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class239 field2915;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class239 field2916;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class239 field2918;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class239 field2924;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class239 field2919;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class239 field2920;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class239 field2921;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class239 field2922;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static final class239 field2923;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static final class239 field2925;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 421279679
   )
   public final int field2917;

   static {
      field2915 = new class239("", 10);
      field2916 = new class239("", 11);
      field2918 = new class239("", 12);
      field2924 = new class239("", 13);
      field2919 = new class239("", 14);
      field2920 = new class239("", 15, new ScriptVarType[]{ScriptVarType.field184, ScriptVarType.field184}, (ScriptVarType[])null);
      field2921 = new class239("", 16, new ScriptVarType[]{ScriptVarType.field184, ScriptVarType.field184}, (ScriptVarType[])null);
      field2922 = new class239("", 17, new ScriptVarType[]{ScriptVarType.field184, ScriptVarType.field184}, (ScriptVarType[])null);
      field2923 = new class239("", 73, true, true);
      field2925 = new class239("", 76, true, false);
   }

   class239(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Ll;Z[Ll;)V"
   )
   class239(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2917 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Ll;[Ll;)V"
   )
   class239(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class239(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.field2917;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lee;IB)V",
      garbageValue = "1"
   )
   public static final void method4492(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.indicesCount; ++var2) {
         if(var0.field1869[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.modelViewportYs[var3];
            int var7 = Model.modelViewportYs[var4];
            int var8 = Model.modelViewportYs[var5];
            class182.method3439(Model.modelViewportXs[var3], Model.modelViewportXs[var4], Model.modelViewportXs[var5], var6, var7, var8, var1);
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ldn;B)V",
      garbageValue = "5"
   )
   static final void method4485(TaskDataNode var0) {
      var0.field1603 = false;
      if(var0.data != null) {
         var0.data.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4324(); var1 != null; var1 = var0.vmethod4323()) {
         method4485(var1);
      }

   }
}
