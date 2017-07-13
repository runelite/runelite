import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class71 implements Runnable {
   @ObfuscatedName("de")
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("a")
   boolean field848;
   @ObfuscatedName("j")
   Object field852;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1171268629
   )
   int field849;
   @ObfuscatedName("r")
   int[] field850;
   @ObfuscatedName("v")
   int[] field851;

   class71() {
      this.field848 = true;
      this.field852 = new Object();
      this.field849 = 0;
      this.field850 = new int[500];
      this.field851 = new int[500];
   }

   public void run() {
      for(; this.field848; class33.method354(50L)) {
         Object var1 = this.field852;
         synchronized(this.field852) {
            if(this.field849 < 500) {
               this.field850[this.field849] = MouseInput.field722;
               this.field851[this.field849] = MouseInput.field723;
               ++this.field849;
            }
         }
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "1663922504"
   )
   static String method1103(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class2.method4(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(class8.field244 != null) {
               var7 = FileSystem.method4078(class8.field244.field2222);
               if(class8.field244.value != null) {
                  var7 = (String)class8.field244.value;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
