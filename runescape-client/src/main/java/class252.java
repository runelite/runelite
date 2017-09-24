import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class252 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3389;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field3388;
   @ObfuscatedName("a")
   char field3393;
   @ObfuscatedName("n")
   boolean field3391;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 356083987
   )
   public int field3390;
   @ObfuscatedName("o")
   public String field3392;

   static {
      field3389 = new NodeCache(64);
   }

   class252() {
      this.field3391 = true;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "2007045520"
   )
   void method4443(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class267.field3660[var5 - 128];
            if(var6 == 0) {
               var6 = 63;
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3393 = var3;
      } else if(var2 == 2) {
         this.field3390 = var1.readInt();
      } else if(var2 == 4) {
         this.field3391 = false;
      } else if(var2 == 5) {
         this.field3392 = var1.readString();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "19"
   )
   void method4441() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1907393303"
   )
   void method4442(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4443(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-425711436"
   )
   public boolean method4444() {
      return this.field3393 == 115;
   }

   @ObfuscatedName("j")
   public static String method4440(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class269.field3672[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
