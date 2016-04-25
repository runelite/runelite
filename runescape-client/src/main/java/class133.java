import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public abstract class class133 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public abstract void vmethod3090();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-708326601"
   )
   abstract int vmethod3089(int var1, int var2);

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "1"
   )
   static void method2829(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class51.field1126; ++var4) {
         class51 var5 = class89.method2081(var4);
         if(var5.field1127 && -1 == var5.field1139 && var5.field1095.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class121.field1985 = -1;
               class36.field789 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class36.field789 = var2;
      class52.field1143 = 0;
      class121.field1985 = var3;
      String[] var8 = new String[class121.field1985];

      for(int var9 = 0; var9 < class121.field1985; ++var9) {
         var8[var9] = class89.method2081(var2[var9]).field1095;
      }

      class115.method2441(var8, class36.field789);
   }
}
