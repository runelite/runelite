import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class72 implements Runnable {
   @ObfuscatedName("bu")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -710426131
   )
   public static int field858;
   @ObfuscatedName("e")
   boolean field861;
   @ObfuscatedName("n")
   Object field859;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -632974773
   )
   int field857;
   @ObfuscatedName("y")
   int[] field860;
   @ObfuscatedName("w")
   int[] field863;

   class72() {
      this.field861 = true;
      this.field859 = new Object();
      this.field857 = 0;
      this.field860 = new int[500];
      this.field863 = new int[500];
   }

   public void run() {
      for(; this.field861; class41.method585(50L)) {
         Object var1 = this.field859;
         synchronized(this.field859) {
            if(this.field857 < 500) {
               this.field860[this.field857] = MouseInput.field718;
               this.field863[this.field857] = MouseInput.field719;
               ++this.field857;
            }
         }
      }

   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lhg;B)Ljava/lang/String;",
      garbageValue = "122"
   )
   static String method1123(Widget var0) {
      int var2 = class15.getWidgetConfig(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "0"
   )
   static long method1124(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }
}
