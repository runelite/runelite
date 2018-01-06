import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class230 implements class229 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static final class230 field2900;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static final class230 field2897;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static final class230 field2906;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static final class230 field2899;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static final class230 field2903;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static final class230 field2901;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static final class230 field2902;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static final class230 field2896;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static final class230 field2904;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static final class230 field2898;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -401449357
   )
   public final int field2905;

   static {
      field2900 = new class230("", 10);
      field2897 = new class230("", 11);
      field2906 = new class230("", 12);
      field2899 = new class230("", 13);
      field2903 = new class230("", 14);
      field2901 = new class230("", 15, new ScriptVarType[]{ScriptVarType.field137, ScriptVarType.field137}, (ScriptVarType[])null);
      field2902 = new class230("", 16, new ScriptVarType[]{ScriptVarType.field137, ScriptVarType.field137}, (ScriptVarType[])null);
      field2896 = new class230("", 17, new ScriptVarType[]{ScriptVarType.field137, ScriptVarType.field137}, (ScriptVarType[])null);
      field2904 = new class230("", 73, true, true);
      field2898 = new class230("", 76, true, false);
   }

   class230(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lt;Z[Lt;)V"
   )
   class230(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2905 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lt;[Lt;)V"
   )
   class230(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class230(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.field2905;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "61"
   )
   public static final boolean method4200() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field602 == KeyFocusListener.field604) {
            return false;
         } else {
            FileRequest.field3304 = KeyFocusListener.field599[KeyFocusListener.field602];
            GameSocket.field2186 = KeyFocusListener.field598[KeyFocusListener.field602];
            KeyFocusListener.field602 = KeyFocusListener.field602 + 1 & 127;
            return true;
         }
      }
   }
}
