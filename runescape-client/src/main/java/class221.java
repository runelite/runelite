import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class221 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 323937679
   )
   public final int field2708;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 623817109
   )
   public final int field2703;
   @ObfuscatedName("m")
   public final int[] field2702;
   @ObfuscatedName("h")
   public final int[] field2704;

   class221(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2708 = var1;
      this.field2703 = var2;
      this.field2702 = var3;
      this.field2704 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2062823107"
   )
   public boolean method4347(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2704.length) {
         int var3 = this.field2704[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2702[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "720581555"
   )
   public static String method4350(CharSequence[] var0, int var1, int var2) {
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
