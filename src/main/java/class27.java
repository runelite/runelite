import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("at")
public class class27 {
   @ObfuscatedName("av")
   static String field669;
   @ObfuscatedName("r")
   class35[] field670 = new class35[100];
   @ObfuscatedName("au")
   static class167 field672;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1427435169
   )
   int field674;
   @ObfuscatedName("en")
   static class80[] field676;

   @ObfuscatedName("r")
   class35 method638(int var1) {
      return var1 >= 0 && var1 < this.field674?this.field670[var1]:null;
   }

   @ObfuscatedName("f")
   int method639() {
      return this.field674;
   }

   @ObfuscatedName("s")
   static int method640(char var0) {
      int var1 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var1 = (var0 << 4) + 1;
      }

      return var1;
   }

   @ObfuscatedName("a")
   class35 method641(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field670[99];

      for(int var6 = this.field674; var6 > 0; --var6) {
         if(var6 != 100) {
            this.field670[var6] = this.field670[var6 - 1];
         }
      }

      if(null == var5) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3946();
         var5.method3920();
         var5.method737(var1, var2, var4, var3);
      }

      this.field670[0] = var5;
      if(this.field674 < 100) {
         ++this.field674;
      }

      return var5;
   }

   @ObfuscatedName("w")
   static void method644(int var0) {
      if(0 != client.field531 && var0 != -1) {
         class86.method2097(class29.field701, var0, 0, client.field531, false);
         client.field533 = true;
      }

   }

   @ObfuscatedName("a")
   static final boolean method648(char var0) {
      return 160 == var0 || 32 == var0 || 95 == var0 || var0 == 45;
   }
}
