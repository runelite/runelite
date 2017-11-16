import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
public class class251 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3372;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3371;
   @ObfuscatedName("r")
   public boolean field3370;

   static {
      field3371 = new NodeCache(64);
   }

   public class251() {
      this.field3370 = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-1239758229"
   )
   public void method4315(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4316(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;IB)V",
      garbageValue = "0"
   )
   void method4316(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3370 = true;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-44"
   )
   public static boolean method4309(char var0) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var1 = class273.field3712;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("s")
   public static String method4317(long var0) {
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
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class275.field3719[(int)(var6 - var0 * 37L)];
               if(var8 == '_') {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1108415518"
   )
   public static final boolean method4307() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field596 == KeyFocusListener.field598) {
            return false;
         } else {
            class96.field1426 = KeyFocusListener.field588[KeyFocusListener.field596];
            class233.field3200 = KeyFocusListener.field592[KeyFocusListener.field596];
            KeyFocusListener.field596 = KeyFocusListener.field596 + 1 & 127;
            return true;
         }
      }
   }
}
