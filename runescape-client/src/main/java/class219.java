import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class219 implements class218 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2770;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2767;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2774;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2768;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2769;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2775;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2771;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2778;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2773;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   static final class219 field2772;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -181006649
   )
   public final int field2776;

   static {
      field2770 = new class219("", 10);
      field2774 = new class219("", 11);
      field2775 = new class219("", 12);
      field2769 = new class219("", 13);
      field2768 = new class219("", 14);
      field2771 = new class219("", 15, new ScriptVarType[]{ScriptVarType.field92, ScriptVarType.field92}, (ScriptVarType[])null);
      field2778 = new class219("", 16, new ScriptVarType[]{ScriptVarType.field92, ScriptVarType.field92}, (ScriptVarType[])null);
      field2773 = new class219("", 17, new ScriptVarType[]{ScriptVarType.field92, ScriptVarType.field92}, (ScriptVarType[])null);
      field2772 = new class219("", 73, true, true);
      field2767 = new class219("", 76, true, false);
   }

   class219(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lv;Z[Lv;)V"
   )
   class219(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2776 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lv;[Lv;)V"
   )
   class219(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field2776;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Liz;",
      garbageValue = "149232034"
   )
   public static Overlay method4073(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }
}
