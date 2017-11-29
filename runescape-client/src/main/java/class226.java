import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class226 implements class225 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static final class226 field2871;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static final class226 field2865;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static final class226 field2872;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static final class226 field2864;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static final class226 field2868;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static final class226 field2867;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static final class226 field2870;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static final class226 field2869;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static final class226 field2866;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static final class226 field2873;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1698609985
   )
   public final int field2874;

   static {
      field2871 = new class226("", 10);
      field2865 = new class226("", 11);
      field2872 = new class226("", 12);
      field2864 = new class226("", 13);
      field2868 = new class226("", 14);
      field2867 = new class226("", 15, new ScriptVarType[]{ScriptVarType.field154, ScriptVarType.field154}, (ScriptVarType[])null);
      field2870 = new class226("", 16, new ScriptVarType[]{ScriptVarType.field154, ScriptVarType.field154}, (ScriptVarType[])null);
      field2869 = new class226("", 17, new ScriptVarType[]{ScriptVarType.field154, ScriptVarType.field154}, (ScriptVarType[])null);
      field2866 = new class226("", 73, true, true);
      field2873 = new class226("", 76, true, false);
   }

   class226(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lb;Z[Lb;)V"
   )
   class226(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2874 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lb;[Lb;)V"
   )
   class226(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class226(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.field2874;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ldn;I)V",
      garbageValue = "1526416258"
   )
   static final void method4216(TaskDataNode var0) {
      var0.field1635 = false;
      if(var0.field1634 != null) {
         var0.field1634.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4054(); var1 != null; var1 = var0.vmethod4055()) {
         method4216(var1);
      }

   }
}
