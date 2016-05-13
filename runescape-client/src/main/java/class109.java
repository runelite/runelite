import java.awt.Component;
import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class109 {
   @ObfuscatedName("cg")
   public static char field1917;

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "7021"
   )
   static final String method2413(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class12.method163('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class12.method163(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class12.method163(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "64"
   )
   static final void method2414(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class5.field84[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class5.field93[0][var5][var4] = class5.field93[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class5.field93[0][var5][var4] = class5.field93[0][1 + var5][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.field93[0][var5][var4] = class5.field93[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class5.field93[0][var5][var4] = class5.field93[0][var5][1 + var4];
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)Lclass77;",
      garbageValue = "-118"
   )
   public static class77 method2415(int var0, int var1, Component var2) {
      try {
         class81 var3 = new class81();
         var3.vmethod1852(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class75 var4 = new class75();
         var4.vmethod1852(var0, var1, var2);
         return var4;
      }
   }

   static {
      new HashMap();
   }
}
