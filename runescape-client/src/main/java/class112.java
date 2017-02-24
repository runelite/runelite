import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public abstract class class112 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "1798624574"
   )
   static int method2145(int var0, class48 var1, boolean var2) {
      if(var0 == 6200) {
         class103.field1686 -= 2;
         Client.field385 = (short)class32.field747[class103.field1686];
         if(Client.field385 <= 0) {
            Client.field385 = 256;
         }

         Client.field560 = (short)class32.field747[class103.field1686 + 1];
         if(Client.field560 <= 0) {
            Client.field560 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class103.field1686 -= 2;
         Client.field561 = (short)class32.field747[class103.field1686];
         if(Client.field561 <= 0) {
            Client.field561 = 256;
         }

         Client.field562 = (short)class32.field747[class103.field1686 + 1];
         if(Client.field562 <= 0) {
            Client.field562 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class103.field1686 -= 4;
         Client.field378 = (short)class32.field747[class103.field1686];
         if(Client.field378 <= 0) {
            Client.field378 = 1;
         }

         Client.field482 = (short)class32.field747[1 + class103.field1686];
         if(Client.field482 <= 0) {
            Client.field482 = 32767;
         } else if(Client.field482 < Client.field378) {
            Client.field482 = Client.field378;
         }

         Client.field565 = (short)class32.field747[class103.field1686 + 2];
         if(Client.field565 <= 0) {
            Client.field565 = 1;
         }

         Client.field401 = (short)class32.field747[class103.field1686 + 3];
         if(Client.field401 <= 0) {
            Client.field401 = 32767;
         } else if(Client.field401 < Client.field565) {
            Client.field401 = Client.field565;
         }

         return 1;
      } else if(var0 == 6203) {
         if(null != Client.field477) {
            FileOnDisk.method1471(0, 0, Client.field477.width, Client.field477.height, false);
            class32.field747[++class103.field1686 - 1] = Client.camera2;
            class32.field747[++class103.field1686 - 1] = Client.camera3;
         } else {
            class32.field747[++class103.field1686 - 1] = -1;
            class32.field747[++class103.field1686 - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class32.field747[++class103.field1686 - 1] = Client.field561;
         class32.field747[++class103.field1686 - 1] = Client.field562;
         return 1;
      } else if(var0 == 6205) {
         class32.field747[++class103.field1686 - 1] = Client.field385;
         class32.field747[++class103.field1686 - 1] = Client.field560;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-2048667501"
   )
   public abstract void vmethod2146(Component var1);

   @ObfuscatedName("d")
   static final void method2147(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-997560499"
   )
   public abstract void vmethod2149(Component var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2129195278"
   )
   public abstract int vmethod2153();

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lclass112;",
      garbageValue = "-252210954"
   )
   public static class112 method2158() {
      try {
         return new class106();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("d")
   public static String method2159(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3086[(int)(var6 - 37L * var0)];
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
