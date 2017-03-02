import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class37 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Lclass158;IB)Lclass158;",
      garbageValue = "-104"
   )
   public static class158 method801(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod4183()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2000058950"
   )
   public static boolean method802() {
      ClassInfo var0 = (ClassInfo)class227.field3246.method2455();
      return null != var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2051420565"
   )
   public static boolean method806(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   class37() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Ljava/lang/String;",
      garbageValue = "2"
   )
   static String method807(Widget var0) {
      return class0.method10(class8.method112(var0)) == 0?null:(null != var0.field2275 && var0.field2275.trim().length() != 0?var0.field2275:null);
   }
}
