import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class18 implements Comparator {
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -1935718401
   )
   @Export("myWorldPort")
   static int myWorldPort;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lb;Lb;I)I",
      garbageValue = "-217579539"
   )
   int method131(class14 var1, class14 var2) {
      return var1.method80().compareTo(var2.method80());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method131((class14)var1, (class14)var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lco;",
      garbageValue = "1912746613"
   )
   static Preferences method137() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = class81.getPreferencesFile("", Client.field923.field3198, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }
}
