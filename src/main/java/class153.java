import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class153 {
   @ObfuscatedName("p")
   public final String field2264;
   @ObfuscatedName("w")
   static final class153 field2265 = new class153("BUILDLIVE", 3);
   @ObfuscatedName("f")
   static final class153 field2266 = new class153("RC", 1);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2028406329
   )
   public final int field2267;
   @ObfuscatedName("s")
   static final class153 field2269 = new class153("WIP", 2);
   @ObfuscatedName("e")
   static final class153 field2270 = new class153("LIVE", 0);

   class153(String var1, int var2) {
      this.field2264 = var1;
      this.field2267 = var2;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lclass37;B)V",
      garbageValue = "0"
   )
   static final void method3158(class37 var0) {
      if(0 != var0.field841) {
         if(var0.field845 != -1) {
            Object var1 = null;
            if(var0.field845 < '耀') {
               var1 = client.field316[var0.field845];
            } else if(var0.field845 >= '耀') {
               var1 = client.field387[var0.field845 - '耀'];
            }

            if(null != var1) {
               int var2 = var0.field804 - ((class37)var1).field804;
               int var3 = var0.field814 - ((class37)var1).field814;
               if(0 != var2 || 0 != var3) {
                  var0.field793 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field800) {
               var0.field845 = -1;
               var0.field800 = false;
            }
         }

         if(var0.field815 != -1 && (0 == var0.field834 || var0.field832 > 0)) {
            var0.field793 = var0.field815;
            var0.field815 = -1;
         }

         int var4 = var0.field793 - var0.field790 & 2047;
         if(var4 == 0 && var0.field800) {
            var0.field845 = -1;
            var0.field800 = false;
         }

         if(var4 != 0) {
            ++var0.field835;
            boolean var5;
            if(var4 > 1024) {
               var0.field790 -= var0.field841;
               var5 = true;
               if(var4 < var0.field841 || var4 > 2048 - var0.field841) {
                  var0.field790 = var0.field793;
                  var5 = false;
               }

               if(var0.field847 == var0.field838 && (var0.field835 > 25 || var5)) {
                  if(var0.field794 != -1) {
                     var0.field838 = var0.field794;
                  } else {
                     var0.field838 = var0.field796;
                  }
               }
            } else {
               var0.field790 += var0.field841;
               var5 = true;
               if(var4 < var0.field841 || var4 > 2048 - var0.field841) {
                  var0.field790 = var0.field793;
                  var5 = false;
               }

               if(var0.field847 == var0.field838 && (var0.field835 > 25 || var5)) {
                  if(-1 != var0.field795) {
                     var0.field838 = var0.field795;
                  } else {
                     var0.field838 = var0.field796;
                  }
               }
            }

            var0.field790 &= 2047;
         } else {
            var0.field835 = 0;
         }

      }
   }
}
