import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
@Implements("Ignore")
public class Ignore extends Nameable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -249698307
   )
   int field3850;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lka;B)I",
      garbageValue = "-1"
   )
   int method5442(Ignore var1) {
      return this.field3850 - var1.field3850;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lkg;I)I",
      garbageValue = "1389713193"
   )
   public int vmethod5501(Nameable var1) {
      return this.method5442((Ignore)var1);
   }

   public int compareTo(Object var1) {
      return this.method5442((Ignore)var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;IIS)Ljava/lang/String;",
      garbageValue = "27594"
   )
   public static String method5441(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var8; ++var5) {
            CharSequence var6 = var0[var5];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }
}
