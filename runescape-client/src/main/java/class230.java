import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class230 implements class229 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   public static final class230 field2886;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   public static final class230 field2880;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   public static final class230 field2878;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   public static final class230 field2884;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   public static final class230 field2879;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   public static final class230 field2881;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   public static final class230 field2882;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   public static final class230 field2883;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static final class230 field2885;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   public static final class230 field2876;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -994179067
   )
   public final int field2877;

   static {
      field2886 = new class230("", 10);
      field2880 = new class230("", 11);
      field2878 = new class230("", 12);
      field2884 = new class230("", 13);
      field2879 = new class230("", 14);
      field2881 = new class230("", 15, new ScriptVarType[]{ScriptVarType.field69, ScriptVarType.field69}, (ScriptVarType[])null);
      field2882 = new class230("", 16, new ScriptVarType[]{ScriptVarType.field69, ScriptVarType.field69}, (ScriptVarType[])null);
      field2883 = new class230("", 17, new ScriptVarType[]{ScriptVarType.field69, ScriptVarType.field69}, (ScriptVarType[])null);
      field2885 = new class230("", 73, true, true);
      field2876 = new class230("", 76, true, false);
   }

   class230(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lt;Z[Lt;)V"
   )
   class230(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2877 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lt;[Lt;)V"
   )
   class230(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class230(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.field2877;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljp;",
      garbageValue = "-672594403"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }
}
