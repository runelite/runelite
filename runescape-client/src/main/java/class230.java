import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class230 implements class178 {
   @ObfuscatedName("j")
   public static final class230 field3171;
   @ObfuscatedName("p")
   public static final class230 field3172;
   @ObfuscatedName("i")
   public static final class230 field3173;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -138837861
   )
   public final int field3174;
   @ObfuscatedName("f")
   public static final class230 field3175;
   @ObfuscatedName("g")
   public final boolean field3176;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 829061741
   )
   final int field3177;
   @ObfuscatedName("h")
   public final boolean field3179;
   @ObfuscatedName("n")
   public static final class230 field3180;
   @ObfuscatedName("m")
   public static final class230 field3181;
   @ObfuscatedName("rw")
   static class291 field3183;

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class230(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field3177 = var1;
      this.field3174 = var2;
      this.field3179 = var4;
      this.field3176 = var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field3177;
   }

   static {
      field3180 = new class230(0, -1, true, false, true);
      field3172 = new class230(1, 0, true, true, true);
      field3173 = new class230(2, 1, true, true, false);
      field3171 = new class230(3, 2, false, false, true);
      field3175 = new class230(4, 3, false, false, true);
      field3181 = new class230(5, 10, false, false, true);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1880574919"
   )
   static char method4112(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LFont;",
      garbageValue = "-2010778759"
   )
   public static Font method4113(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.method4141(var2);
      int var5 = var0.method4209(var4, var3);
      Font var6;
      if(!class112.method2092(var0, var4, var5)) {
         var6 = null;
      } else {
         byte[] var8 = var1.getConfigData(var4, var5);
         Font var7;
         if(var8 == null) {
            var7 = null;
         } else {
            Font var9 = new Font(var8, class95.field1493, class286.field3790, class286.field3793, class241.field3293, class174.field2410, class31.field449);
            VertexNormal.method2592();
            var7 = var9;
         }

         var6 = var7;
      }

      return var6;
   }
}
