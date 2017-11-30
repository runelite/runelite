import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class31 {
   @ObfuscatedName("t")
   static byte[][][] field413;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 607993823
   )
   final int field415;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 150136621
   )
   final int field412;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -876482359
   )
   final int field414;

   class31(int var1, int var2, int var3) {
      this.field415 = var1;
      this.field412 = var2;
      this.field414 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1622088007"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class34.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lcp;Lcp;IZS)I",
      garbageValue = "3622"
   )
   static int method268(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1496()?(var1.method1496()?0:1):(var1.method1496()?-1:0)):(var2 == 5?(var0.method1494()?(var1.method1494()?0:1):(var1.method1494()?-1:0)):(var2 == 6?(var0.method1495()?(var1.method1495()?0:1):(var1.method1495()?-1:0)):(var2 == 7?(var0.method1518()?(var1.method1518()?0:1):(var1.method1518()?-1:0)):var0.id - var1.id)))));
      }
   }
}
