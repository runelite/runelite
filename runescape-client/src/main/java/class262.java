import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class262 {
   @ObfuscatedName("a")
   IndexDataBase field3633;
   @ObfuscatedName("n")
   HashMap field3634;
   @ObfuscatedName("j")
   IndexDataBase field3632;

   public class262(IndexDataBase var1, IndexDataBase var2) {
      this.field3633 = var1;
      this.field3632 = var2;
      this.field3634 = new HashMap();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Lclass261;I)Ljava/util/HashMap;",
      garbageValue = "-1123358068"
   )
   public HashMap method4656(class261[] var1) {
      HashMap var2 = new HashMap();
      class261[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class261 var5 = var3[var4];
         if(this.field3634.containsKey(var5)) {
            var2.put(var5, this.field3634.get(var5));
         } else {
            IndexDataBase var7 = this.field3633;
            IndexDataBase var8 = this.field3632;
            String var9 = var5.field3630;
            int var10 = var7.getFile(var9);
            int var11 = var7.getChild(var10, "");
            Font var12;
            if(!IndexData.method4200(var7, var10, var11)) {
               var12 = null;
            } else {
               byte[] var14 = var8.getConfigData(var10, var11);
               Font var13;
               if(var14 == null) {
                  var13 = null;
               } else {
                  Font var15 = new Font(var14, class286.field3795, class31.offsetsY, class286.field3797, class90.field1405, class286.field3796, class177.spritePixels);
                  class18.method138();
                  var13 = var15;
               }

               var12 = var13;
            }

            if(var12 != null) {
               this.field3634.put(var5, var12);
               var2.put(var5, var12);
            }
         }
      }

      return var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "490588091"
   )
   public static char method4659(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class266.field3663[var1 - 128];
            if(var2 == 0) {
               var2 = 63;
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }
}
