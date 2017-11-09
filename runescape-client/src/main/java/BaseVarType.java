import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("BaseVarType")
public enum BaseVarType implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   @Export("INTEGER")
   INTEGER(2, 0, Integer.class, new class2()),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   @Export("STRING")
   STRING(0, 2, String.class, new class5());

   @ObfuscatedName("ay")
   protected static String field27;
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   static Task field28;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1147071591
   )
   final int field25;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2062975513
   )
   final int field26;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lm;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field25 = var3;
      this.field26 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field26;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "70"
   )
   static final boolean method14(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else {
         boolean var1 = var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
         if(var1) {
            return true;
         } else {
            char[] var2 = class274.field3722;

            int var3;
            char var4;
            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            var2 = class274.field3724;

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(I)Lkz;",
      garbageValue = "-235340549"
   )
   static RenderOverview method13() {
      return Client.renderOverview;
   }
}
