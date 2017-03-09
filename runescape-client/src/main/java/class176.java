import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public final class class176 {
   @ObfuscatedName("t")
   static int[] field2648;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-1246525862"
   )
   public static int method3276(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "64"
   )
   public static void method3277() {
      CombatInfo2.field2828.reset();
      CombatInfo2.field2840.reset();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1692675534"
   )
   static int method3278(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class32.field752 -= 2;
         Client.field567 = (short)class32.field756[class32.field752];
         if(Client.field567 <= 0) {
            Client.field567 = 256;
         }

         Client.field568 = (short)class32.field756[class32.field752 + 1];
         if(Client.field568 <= 0) {
            Client.field568 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class32.field752 -= 2;
         Client.field569 = (short)class32.field756[class32.field752];
         if(Client.field569 <= 0) {
            Client.field569 = 256;
         }

         Client.field522 = (short)class32.field756[1 + class32.field752];
         if(Client.field522 <= 0) {
            Client.field522 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class32.field752 -= 4;
         Client.field324 = (short)class32.field756[class32.field752];
         if(Client.field324 <= 0) {
            Client.field324 = 1;
         }

         Client.field572 = (short)class32.field756[1 + class32.field752];
         if(Client.field572 <= 0) {
            Client.field572 = 32767;
         } else if(Client.field572 < Client.field324) {
            Client.field572 = Client.field324;
         }

         Client.field573 = (short)class32.field756[class32.field752 + 2];
         if(Client.field573 <= 0) {
            Client.field573 = 1;
         }

         Client.field574 = (short)class32.field756[3 + class32.field752];
         if(Client.field574 <= 0) {
            Client.field574 = 32767;
         } else if(Client.field574 < Client.field573) {
            Client.field574 = Client.field573;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field551 != null) {
            class40.method824(0, 0, Client.field551.width, Client.field551.height, false);
            class32.field756[++class32.field752 - 1] = Client.camera2;
            class32.field756[++class32.field752 - 1] = Client.camera3;
         } else {
            class32.field756[++class32.field752 - 1] = -1;
            class32.field756[++class32.field752 - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class32.field756[++class32.field752 - 1] = Client.field569;
         class32.field756[++class32.field752 - 1] = Client.field522;
         return 1;
      } else if(var0 == 6205) {
         class32.field756[++class32.field752 - 1] = Client.field567;
         class32.field756[++class32.field752 - 1] = Client.field568;
         return 1;
      } else {
         return 2;
      }
   }

   class176() throws Throwable {
      throw new Error();
   }
}
