import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public abstract class class109 {
   @ObfuscatedName("mp")
   static byte field1742;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1162322467
   )
   public static int field1744;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "1544086013"
   )
   static int method2040(World var0, World var1, int var2, boolean var3) {
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
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method611()?(var1.method611()?0:1):(var1.method611()?-1:0)):(var2 == 5?(var0.method609()?(var1.method609()?0:1):(var1.method609()?-1:0)):(var2 == 6?(var0.method627()?(var1.method627()?0:1):(var1.method627()?-1:0)):(var2 == 7?(var0.method651()?(var1.method651()?0:1):(var1.method651()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1908807561"
   )
   abstract int vmethod2041(int var1, int var2);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "683063643"
   )
   public abstract void vmethod2044();
}
