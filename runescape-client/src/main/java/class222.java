import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class222 {
   @ObfuscatedName("k")
   public static final boolean[] field2843;
   @ObfuscatedName("e")
   public static int[] field2842;

   static {
      field2843 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2842 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2842[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhj;I)Ljava/lang/String;",
      garbageValue = "913941881"
   )
   static String method4189(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + Varcs.method1895(ScriptVarType.method27(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(class29.field435 != null) {
               var4 = class90.method1796(class29.field435.field2240);
               if(class29.field435.value != null) {
                  var4 = (String)class29.field435.value;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
