import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1908090327
   )
   @Export("id")
   int id = class115.method2186();
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1898974721
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2048898487
   )
   @Export("type")
   int type;
   @ObfuscatedName("a")
   @Export("name")
   String name;
   @ObfuscatedName("c")
   @Export("value")
   String value;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 1392162575
   )
   static int field231;
   @ObfuscatedName("f")
   @Export("sender")
   String sender;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-91"
   )
   void method195(int var1, String var2, String var3, String var4) {
      this.id = class115.method2186();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-10"
   )
   static final void method198(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class33.menuAction(var1, var2, var3, var4, var5, var6, class115.field1791, class115.field1796);
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "683252175"
   )
   static final void method199(boolean var0) {
      class40.method741();
      ++Client.field332;
      if(Client.field332 >= 50 || var0) {
         Client.field332 = 0;
         if(!Client.field337 && null != class37.field774) {
            Client.field326.method3029(217);

            try {
               class37.field774.method2018(Client.field326.payload, 0, Client.field326.offset);
               Client.field326.offset = 0;
            } catch (IOException var2) {
               Client.field337 = true;
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "3"
   )
   public static int method200(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-19627853"
   )
   public static void method201(class182 var0) {
      class188.field2753 = var0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)Z",
      garbageValue = "49"
   )
   public static boolean method202(CharSequence var0, int var1, boolean var2) {
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

            int var9;
            if(var8 >= 48 && var8 <= 57) {
               var9 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var9 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var9 = var8 - 87;
            }

            if(var9 >= var1) {
               return false;
            }

            if(var3) {
               var9 = -var9;
            }

            int var10 = var1 * var5 + var9;
            if(var10 / var1 != var5) {
               return false;
            }

            var5 = var10;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
