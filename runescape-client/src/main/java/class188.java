import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class188 extends CacheableNode {
   @ObfuscatedName("n")
   public static NodeCache field2783 = new NodeCache(64);
   @ObfuscatedName("g")
   public boolean field2784 = false;
   @ObfuscatedName("x")
   public static class182 field2786;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1098713580"
   )
   public void method3510(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3511(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "901487535"
   )
   void method3511(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2784 = true;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "512"
   )
   static final void method3513(int var0, int var1) {
      if(Client.field304 == 2) {
         class39.method823((Client.field295 - Player.baseX << 7) + Client.field310, Client.field311 + (Client.field382 - SecondaryBufferProvider.baseY << 7), Client.field346 * 2);
         if(Client.field447 > -1 && Client.gameCycle % 20 < 10) {
            CombatInfoListHolder.field758[0].method4174(Client.field447 + var0 - 12, var1 + Client.field469 - 28);
         }

      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "-1798381896"
   )
   static final void method3520(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            if(var6) {
               Client.field436 = Client.menuOptionCount;
            }

            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1104920938"
   )
   public static String method3522(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class150.method2850(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
